package com.tigeryoyo.Reader;

/**
 * 具体工厂类,读txt文件
 * @author Chan
 *
 */
public class TxtFactory implements ReaderFactory{

	public FileProduct getFileProduct(String fileName) {
		// TODO Auto-generated method stub
		return new TxtProduct(fileName);
	}

}
