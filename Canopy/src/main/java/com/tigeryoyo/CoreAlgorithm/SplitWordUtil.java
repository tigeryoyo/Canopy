package com.tigeryoyo.CoreAlgorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.FilterModifWord;
import org.apache.log4j.Logger;

/**
 * @author Chan
 * @description 利用Ansj分词工具将文本分词 {@link} http://nlpchina.github.io/ansj_seg/
 */
public class SplitWordUtil {
	private static final Logger logger = Logger.getLogger(SplitWordUtil.class);

	/**
	 * @description 将文本分词
	 * @return
	 */
	public static List<String> getDocSplit(String string) {
		// 设置停用词
		setStopword();

		List<Term> splitRes = ToAnalysis.parse(string);
		// 去除停用词后的分词结果
		splitRes = FilterModifWord.modifResult(splitRes);

		List<String> finalRes = new ArrayList<String>();
		for (Term t : splitRes) {
			finalRes.add(t.getName());
		}

		return finalRes;
	}

	/**
	 * 设置停用词
	 */
	private static void setStopword() {
		File stopwords = new File("library/stopwords.txt");

		try {
			FileReader fr = new FileReader(stopwords);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				FilterModifWord.insertStopWord(line);
				line = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		List<String> strs = SplitWordUtil.getDocSplit("华中科技大学是个久负盛名的学校。");
		for (String str : strs) {
			System.out.println(str);
		}

		// UserDefineLibrary.insertWord("是一个", "userDefine", 1000);
		// List<Term> terms = ToAnalysis.parse("我觉得Ansj中文分词是一个不错的系统!我是王婆!");
		// System.out.println("增加新词例子:" + terms);
		// // 删除词语,只能删除.用户自定义的词典.
		// UserDefineLibrary.removeWord("ansj中文分词");
		// terms = ToAnalysis.parse("我觉得ansj中文分词是一个不错的系统!我是王婆!");
		// System.out.println("删除用户自定义词典例子:" + terms);
	}

}
