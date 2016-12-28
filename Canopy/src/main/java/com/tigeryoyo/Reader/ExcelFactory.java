package com.tigeryoyo.Reader;

/**
 * 具体工厂类，读excel文件
 * @author Chan
 *
 */
public class ExcelFactory implements ReaderFactory{

	public FileProduct getFileProduct(String fileName) {
		// TODO Auto-generated method stub
		return new ExcelProduct(fileName);
	}

}
