package com.tigeryoyo.Reader;

/**
 * 抽象工厂类
 * @author Chan
 *
 */
public interface ReaderFactory {
	public abstract FileProduct getFileProduct(String fileName);
}
