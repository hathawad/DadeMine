package com.dadesystems.mine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

import com.dadesystems.mine.runner.QueryRunner;

public class Mine {

	public String readFile(String fileName) {
		try {
			Scanner scan = new Scanner(new File(fileName));
			scan.useDelimiter("\\Z");
			return scan.next();
		} catch (FileNotFoundException e) {
			System.err.println(e);
			e.printStackTrace();
			return null;
		}
	}

	public void run() {
		ResultWriter writer = new ResultWriter(MineProperties.getResultWriterOutputFileName());
		QueryRunner runner = QueryRunner.getQueryRunner(MineProperties.getQueryRunnerClass(),writer);
		runner.runQuery(readFile(MineProperties.getQueryRunnerQueryFile()));
		writer.close();
	}

	public static void main(String args[]) {
		Mine mine = new Mine();
		mine.run();
	}

}