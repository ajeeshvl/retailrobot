package com.infosys.retailrobot.gherkin;

import gherkin.deps.com.google.gson.annotations.Expose;
import gherkin.deps.com.google.gson.annotations.SerializedName;

public class Step {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("keyword")
	@Expose
	private String keyword;
	@SerializedName("line")
	@Expose
	private Integer line;

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 
	 * @param keyword
	 *            The keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * 
	 * @return The line
	 */
	public Integer getLine() {
		return line;
	}

	/**
	 * 
	 * @param line
	 *            The line
	 */
	public void setLine(Integer line) {
		this.line = line;
	}

}
