package com.tigeryoyo;

import java.util.List;

import com.tigeryoyo.CoreAlgorithm.Canopy;
import com.tigeryoyo.Reader.FileProduct;
import com.tigeryoyo.Reader.ReaderFactory;
import com.tigeryoyo.Reader.TxtFactory;

public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReaderFactory rf = new TxtFactory();
		FileProduct fp = rf.getFileProduct("library/Test.txt");
		fp.read();
	
		Canopy canopies = new Canopy();
		canopies.setFileContent(fp.getFileContent());
		canopies.cluster();
		
		int i = 1;
		for(List<String> canopy : canopies.getCanopies()){
			System.out.println("****************分类"+i+++"********************");
			for(String str : canopy){
				System.out.println(str);
			}
			System.out.println();
		}
		
		
	}

}
