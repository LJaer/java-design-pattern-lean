package com.ljaer.designpatterns.decorator.io;

import java.io.*;

public class InputTest {
	public static void main(String[] args) throws IOException {
		String relativelyPath=System.getProperty("user.dir");
		System.out.println(relativelyPath);

		String textFilePath = relativelyPath+"/src/main/resources/test.txt";

		int c;
		InputStream in = null;
		try {
			in = 
				new LowerCaseInputStream(
					new BufferedInputStream(
						new FileInputStream(textFilePath)));

			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) { in.close(); }
		}
	}
}
