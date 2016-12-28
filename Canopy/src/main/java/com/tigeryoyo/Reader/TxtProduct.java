package com.tigeryoyo.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 具体产品类
 * @author Chan
 *
 */
public class TxtProduct extends FileProduct{

	public TxtProduct(String fileName) {
		super(fileName);
		fileContent = new ArrayList<String>();
	}
	
	@Override
	public void read() {
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while(line != null){
				if(!line.trim().isEmpty()){
					fileContent.add(line.trim());
				}
				line = br.readLine();
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
