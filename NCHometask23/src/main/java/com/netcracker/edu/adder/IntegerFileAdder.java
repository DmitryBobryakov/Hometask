package com.netcracker.edu.adder;

import java.io.FileInputStream;


import java.io.FileWriter;



import java.util.Scanner;

/**
 * Class is responsible for adding 2 files with integers line by line and saving
 * a result to another file If at least one of input files does not exist, throw
 * appropriate exception with If output file already exists, rewrite content of
 * it If there are some rows cannot be converted to integer, throw appropriate
 * exception If rows counts of input files are not equal, assume nonexistent
 * rows shall be completed by zeros If result of sum operation is not in
 * [INTEGER_MIN; INTEGER_MAX) half-open interval throw appropriate exception
 *
 * Expected file format: each line contains one integer e.g. input files:
 * input1.txt, input2.txt; output file: output.txt
 *
 * input1.txt input2.txt output.txt 1 4 5 2 5 7 3 6 9
 *
 * input1.txt input2.txt output.txt 1 4 5 2 5 7 3 6 9 11 11
 *
 *
 * Additional requirements: Large files which size exceeded free heap space
 * shall be operated successfully Unit testing shall cover positive and negative
 * cases
 *
 */
public class IntegerFileAdder implements Adder {

	private final String pathToInputFile1;
	private final String pathToInputFile2;
	private final String pathToOutputFile;

	/**
	 * Default constructor
	 * 
	 * @param pathToInputFile1
	 *            absolute path to first file
	 * @param pathToInputFile2
	 *            absolute path to second file
	 * @param pathToOutputFile
	 *            absolute path to output file
	 */
	public IntegerFileAdder(String pathToInputFile1, String pathToInputFile2,
			String pathToOutputFile) {
		this.pathToInputFile1 = pathToInputFile1;
		this.pathToInputFile2 = pathToInputFile2;
		this.pathToOutputFile = pathToOutputFile;
	}

	/**
	 * Method adds integer content of 2 input files line by line and saves
	 * result to output file or throws exception
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		
		
		try (Scanner infile1=new Scanner(new FileInputStream(pathToInputFile1));
			 Scanner infile2 =new Scanner(new FileInputStream(pathToInputFile2));
			 FileWriter outfile = new FileWriter(pathToOutputFile)) {
			
			int file1Int = 0;
			int file2Int = 0;
			int fileOutInt = 0;
			int lineNumber=0;

			while (infile1.hasNextLine() || infile2.hasNextLine()) {

				if (!infile1.hasNextLine()) {
					file1Int = 0;
					file2Int = Integer.parseInt(infile2.nextLine());
				} else if (!infile2.hasNextLine()) {
					file1Int = Integer.parseInt(infile1.nextLine());
					file2Int = 0;
				} else {
					file1Int = Integer.parseInt(infile1.nextLine());
					file2Int = Integer.parseInt(infile2.nextLine());
				}
				lineNumber++;
				long f3 = (long) file1Int + (long) file2Int;
				
				if (f3 > Integer.MAX_VALUE || f3 < Integer.MIN_VALUE) {
					throw new ArithmeticException("In line "+lineNumber+" Sum > Integer.MAX_VALUE OR "
							+ "< Integer.MIN_VALUE");
				}
				fileOutInt= file1Int + file2Int;

				
				outfile.write(Integer.toString(fileOutInt));
				outfile.write(System.lineSeparator());
			}

		} catch (Exception e) {
			throw e;
		} 

	}
}
