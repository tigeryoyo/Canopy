package com.tigeryoyo.Reader;

import java.util.List;

/**
 * 抽象产品类
 * 
 * @author Chan
 *
 */
public abstract class FileProduct {
	/**
	 * 文件名
	 */
	protected String fileName;

	/**
	 * 存储文件内容
	 */
	protected List<String> fileContent;

	/**
	 * 构造函数
	 * 
	 * @param fileName
	 *            被读取的文件完全限定名
	 */
	public FileProduct(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileContent
	 */
	public List<String> getFileContent() {
		return fileContent;
	}

	/**
	 * 抽象读文件方法
	 */
	public abstract void read();

	/**
	 * 获取文件完全限定名
	 * 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
}
