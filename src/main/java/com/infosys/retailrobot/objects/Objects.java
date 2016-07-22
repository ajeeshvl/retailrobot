package com.infosys.retailrobot.objects;

import gherkin.deps.com.google.gson.annotations.Expose;
import gherkin.deps.com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Objects {

	@SerializedName("id")
	@Expose
	private List<String> id = new ArrayList<String>();
	@SerializedName("classname")
	@Expose
	private List<String> classname = new ArrayList<String>();
	@SerializedName("partialtext")
	@Expose
	private List<String> partialtext = new ArrayList<String>();
	@SerializedName("xpath")
	@Expose
	private List<String> xpath = new ArrayList<String>();
	@SerializedName("css")
	@Expose
	private List<String> css = new ArrayList<String>();

	/**
	 * 
	 * @return The id
	 */
	public List<String> getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(List<String> id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The classname
	 */
	public List<String> getClassname() {
		return classname;
	}

	/**
	 * 
	 * @param classname
	 *            The classname
	 */
	public void setClassname(List<String> classname) {
		this.classname = classname;
	}

	/**
	 * 
	 * @return The partialtext
	 */
	public List<String> getPartialtext() {
		return partialtext;
	}

	/**
	 * 
	 * @param partialtext
	 *            The partialtext
	 */
	public void setPartialtext(List<String> partialtext) {
		this.partialtext = partialtext;
	}

	/**
	 * 
	 * @return The xpath
	 */
	public List<String> getXpath() {
		return xpath;
	}

	/**
	 * 
	 * @param xpath
	 *            The xpath
	 */
	public void setXpath(List<String> xpath) {
		this.xpath = xpath;
	}

	/**
	 * 
	 * @return The css
	 */
	public List<String> getCss() {
		return css;
	}

	/**
	 * 
	 * @param css
	 *            The css
	 */
	public void setCss(List<String> css) {
		this.css = css;
	}

}