package com.dadesystems.mine.runner;

import com.dadesystems.mine.ResultWriter;

public abstract class QueryRunner {
	protected ResultWriter writer;

	public QueryRunner(ResultWriter writer) {
		this.writer = writer;
	}

	public abstract void runQuery(String query);

	public static QueryRunner getQueryRunner(String className,ResultWriter writer) {
		try {
	          String name = className;

	          // get String Class
	          Class cl = Class.forName(name);

	          // get the constructor with one parameter
	          java.lang.reflect.Constructor constructor =
	             cl.getConstructor
	               (new Class[] {ResultWriter.class});

	          // create an instance
	         return (QueryRunner) constructor.newInstance(new Object[]{writer});

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}

}
