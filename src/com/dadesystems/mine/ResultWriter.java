package com.dadesystems.mine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultWriter {
	private FileWriter fileWriter;
	private List<String> elements = null;
	BufferedWriter output;

	public ResultWriter(String fileName) {
		try {
			fileWriter = new FileWriter(fileName);
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		output = new BufferedWriter(fileWriter);
	}

	public void writeLine(String line) {
		try {
			output.write(line + "\n");
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void writeElement(String element) {
		if (elements == null) {
			elements = new ArrayList<String>();
		}
		elements.add(element);
	}

	public void endLine() {
		StringBuilder line = new StringBuilder();
		for (String element : elements) {
			line.append(element);
			line.append(MineProperties.getResultWriterdelimeter());
		}
		line.deleteCharAt(line.length() - 1);
		writeLine(line.toString());
		elements = null;
	}

	public void close() {
		try {
			output.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

}
