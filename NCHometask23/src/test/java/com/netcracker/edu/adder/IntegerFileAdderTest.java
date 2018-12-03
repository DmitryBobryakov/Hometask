package com.netcracker.edu.adder;



import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.InitializationError;

import junit.framework.Assert;

public class IntegerFileAdderTest {
	@BeforeClass
	public static void initializationOFDirectory() throws IOException {

		File filePath = new File("FilesForTests");
		filePath.mkdir();

	}

	@Test
	public void testAddDifferentAmountOfLines() throws Exception {

		FileWriter wrin1 = new FileWriter("FilesForTests"+File.separator+"Test0_in1.txt");
		FileWriter wrin2 = new FileWriter("FilesForTests"+File.separator+"Test0_in2.txt");
		FileWriter wrout = new FileWriter("FilesForTests"+File.separator+"Test0_out.txt");

		wrin1.write(Integer.toString(1)); // In in1.txt 3 lines
		wrin1.write(System.lineSeparator());
		wrin1.write(Integer.toString(2));
		wrin1.write(System.lineSeparator());
		wrin1.write(Integer.toString(3));

		wrin2.write(Integer.toString(1)); // in in2.txt only 2 lines
		wrin2.write(System.lineSeparator());
		wrin2.write(Integer.toString(2));

		wrout.write(Integer.toString(2)); // In out.txt must be 3 correct lines
		wrout.write(System.lineSeparator());
		wrout.write(Integer.toString(4));
		wrout.write(System.lineSeparator());
		wrout.write(Integer.toString(3));

		wrin1.close();
		wrin2.close();
		wrout.close();
		IntegerFileAdder test = new IntegerFileAdder(
				"FilesForTests"+File.separator+"Test0_in1.txt", 
				"FilesForTests"+File.separator+"Test0_in2.txt",
				"FilesForTests"+File.separator+"Test0_out_real.txt");

		test.add();
		File fileexpected = new File("FilesForTests"+File.separator+"Test0_out.txt");
		File filereal = new File("FilesForTests"+File.separator+"Test0_out_real.txt");
		Assert.assertEquals(FileUtils.readLines(fileexpected),
				FileUtils.readLines(filereal));
	}

	@Test // Same, but in1.txt- 2 lines, in2.txt- 3 lines
	public void testaddDefferentAmountOfLines1() throws Exception {
		FileWriter wrin1 = new FileWriter("FilesForTests"+File.separator+"Test1_in1.txt");
		FileWriter wrin2 = new FileWriter("FilesForTests"+File.separator+"Test1_in2.txt");
		FileWriter wrout = new FileWriter("FilesForTests"+File.separator+"Test1_out.txt");

		wrin1.write(Integer.toString(1)); // In in1.txt only 2 lines
		wrin1.write(System.lineSeparator());
		wrin1.write(Integer.toString(2));

		wrin2.write(Integer.toString(1)); // in in2.txt 3 lines
		wrin2.write(System.lineSeparator());
		wrin2.write(Integer.toString(2));
		wrin2.write(System.lineSeparator());
		wrin2.write(Integer.toString(3));

		wrout.write(Integer.toString(2)); // In out.txt must be 3 correct lines
		wrout.write(System.lineSeparator());
		wrout.write(Integer.toString(4));
		wrout.write(System.lineSeparator());
		wrout.write(Integer.toString(3));

		wrin1.close();
		wrin2.close();
		wrout.close();
		IntegerFileAdder test = new IntegerFileAdder(
				"FilesForTests"+File.separator+"Test1_in1.txt", "FilesForTests"+File.separator+"Test1_in2.txt",
				"FilesForTests"+File.separator+"Test1_out_real1.txt");

		test.add();
		File fileexpected = new File("FilesForTests"+File.separator+"Test1_out.txt");
		File filereal = new File("FilesForTests"+File.separator+"Test1_out_real1.txt");
		Assert.assertEquals(FileUtils.readLines(fileexpected),
				FileUtils.readLines(filereal));
	}

	@Test // in1.txt & in2.txt is null
	public void testaddInputFilesAreNULL() throws Exception {
		FileWriter wrin1 = new FileWriter("FilesForTests"+File.separator+"Test2_in1.txt");
		FileWriter wrin2 = new FileWriter("FilesForTests"+File.separator+"Test2_in2.txt");
		FileWriter wrout = new FileWriter("FilesForTests"+File.separator+"Test2_out.txt");

		IntegerFileAdder test = new IntegerFileAdder(
				"FilesForTests"+File.separator+"Test2_in1.txt",
				"FilesForTests"+File.separator+"Test2_in2.txt",
				"FilesForTests"+File.separator+"Test2_out_real2.txt");
		test.add();
		File fileexpected = new File("FilesForTests"+File.separator+"Test2_out.txt");
		File filereal = new File("FilesForTests"+File.separator+"Test2_out_real2.txt");
		Assert.assertEquals(FileUtils.readLines(fileexpected),
				FileUtils.readLines(filereal));

	}

	@Test(expected = NumberFormatException.class)
	// When in in1.txt is not integer
	public void testaddInInputFileIsNotInteger() throws Exception {
		FileWriter wrin1 = new FileWriter("FilesForTests"+File.separator+"Test3_in1.txt");
		FileWriter wrin2 = new FileWriter("FilesForTests"+File.separator+"Test3_in2.txt");
		FileWriter wrout = new FileWriter("FilesForTests"+File.separator+"Test3_out.txt");

		wrin1.write(Integer.toString(1)); // In in1.txt 3 lines
		wrin1.write(System.lineSeparator());
		wrin1.write("test");
		wrin1.write(System.lineSeparator());
		wrin1.write(Integer.toString(3));

		wrin2.write(Integer.toString(1)); // in in2.txt only 2 lines
		wrin2.write(System.lineSeparator());
		wrin2.write(Integer.toString(2));

		wrin1.close();
		wrin2.close();
		wrout.close();

		IntegerFileAdder test = new IntegerFileAdder(
				"FilesForTests"+File.separator+"Test3_in1.txt",
				"FilesForTests"+File.separator+"Test3_in2.txt",
				"FilesForTests"+File.separator+"Test3_out_real2.txt");
		test.add();
	}

	@Test(expected = ArithmeticException.class)
	// When int is overflowed- int>2147483646
	public void testaddOverFlowedSum() throws Exception {
		FileWriter wrin1 = new FileWriter("FilesForTests"+File.separator+"Test4_in1.txt");
		FileWriter wrin2 = new FileWriter("FilesForTests"+File.separator+"Test4_in2.txt");
		FileWriter wrout = new FileWriter("FilesForTests"+File.separator+"Test4_out.txt");

		wrin1.write(Integer.toString(2147483646));
		wrin2.write(Integer.toString(100));
		wrout.write(Integer.toString(1));

		wrin1.close();
		wrin2.close();
		wrout.close();

		IntegerFileAdder test = new IntegerFileAdder(
				"FilesForTests"+File.separator+"Test4_in1.txt",
				"FilesForTests"+File.separator+"Test4_in2.txt",
				"FilesForTests"+File.separator+"Test4_out_real.txt");
		test.add();
	}

}
