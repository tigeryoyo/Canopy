package com.tigeryoyo.CoreAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用Canopy对文档进行一次粗聚类，得到簇数K与各个簇的质心。 目前支持输入的测试数据为txt格式数据，一条数据为一个文本。
 * 
 * @author Chan
 *
 */
public class Canopy {

	/**
	 * 阀值T
	 */
	private double T = 0.2f;
	/**
	 * 存储原文档的内容，每一条String数据为一个文本
	 */
	private List<String> fileContent;
	/**
	 * 存储转换后的k个canopy
	 */
	private List<List<String>> canopies;

	/**
	 * 构造函数，初始化各个对象
	 */
	public Canopy() {
		canopies = new ArrayList<List<String>>();
	}

	/**
	 * 
	 * @param fileName
	 *            文件名为完全限定名
	 */
	public void cluster() {
		List<String> tmpFileList = new ArrayList<String>(fileContent);
		
		for (int i = 0; i < tmpFileList.size(); i++) {
			
			String pointStr = tmpFileList.get(i);
			if (pointStr == null) {
				continue;
			}
			tmpFileList.set(i, null);

			List<String> canopy = new ArrayList<String>();
			canopy.add(pointStr);

			/**
			 * eclipse的调试器不能调试iterator。why？ version:eclipse-jee-neon-1-win32
			 * eclipse-jee-neon-R-win32 可以正确调试
			 */
			for (int j = i + 1; j < tmpFileList.size(); j++) {
				
				String compareStr = tmpFileList.get(j);
				if (compareStr == null) {
					continue;
				}

				// 初始化Similar分词工具
				SimilarityUtil simUtil = new SimilarityUtil();
				// 计算两个文本的相似度
				double cmpSimilarity = simUtil.getSimilarity(pointStr, compareStr);

				// 如果相似度结果在T阀值圈内，将compareStr加入pointStr所在的canopy
				if (cmpSimilarity >= T) {
					canopy.add(compareStr);
					tmpFileList.set(j, null);
				}
			}
			canopies.add(canopy);	
		}
	}
	
	/**
	 * @param fileContent the fileContent to set
	 */
	public void setFileContent(List<String> fileContent) {
		this.fileContent = fileContent;
	}

	/**
	 * 获取canopies.
	 * 
	 * @return
	 */
	public List<List<String>> getCanopies() {
		return canopies;
	}
	
}
