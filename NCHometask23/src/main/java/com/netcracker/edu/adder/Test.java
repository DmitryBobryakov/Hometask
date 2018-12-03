package com.netcracker.edu.adder;

import java.io.File;

public class Test {

	public static void main(String[] args) throws Exception {

		IntegerFileAdder test = new IntegerFileAdder(
				"FilesForTests"+File.separator+"Test4_in1.txt", 
				"FilesForTests"+File.separator+"Test4_in2.txt",
				"FilesForTests"+File.separator+"Test4_out_real.txt");

		test.add();
	}

}
