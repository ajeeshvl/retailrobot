package com.infosys.retailrobot.gherkin;

import gherkin.deps.com.google.gson.annotations.Expose;
import gherkin.deps.com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Element {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("keyword")
	@Expose
	private String keyword;
	@SerializedName("line")
	@Expose
	private Integer line;
	@SerializedName("steps")
	@Expose
	private List<Step> steps = new ArrayList<Step>();
	@SerializedName("type")
	@Expose
	private String type;

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

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

	/**
	 * 
	 * @return The steps
	 */
	public List<Step> getSteps() {
		return steps;
	}

	/**
	 * 
	 * @param steps
	 *            The steps
	 */
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
