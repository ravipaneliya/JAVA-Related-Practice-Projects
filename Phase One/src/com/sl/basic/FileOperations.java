package com.sl.basic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
	public static void main(String[] args) {
		try {
			File myfile = new File("test.txt");
			if (myfile.createNewFile()) {
				System.out.println("File created: " + myfile.getName());
			} else {
				System.out.println("File already exists.");
			}
			FileOperations fo = new FileOperations();
			fo.readFile(myfile);
			fo.writeFile(myfile, "Add Data", false);
			fo.readFile(myfile);
			fo.writeFile(myfile, "\tAppend Data", true);
			fo.readFile(myfile);
			myfile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFile(File file) throws IOException {
		FileReader reader = new FileReader(file);
		char[] data = new char[(int) file.length()];
		reader.read(data);
		String fileData = new String(data);
		System.out.println("Read : " + fileData);
		reader.close();
	}

	public void writeFile(File file, String content, boolean isAppend) throws IOException {
		FileWriter writer = new FileWriter(file, isAppend);
		writer.write(content);
		writer.close();
	}
}
