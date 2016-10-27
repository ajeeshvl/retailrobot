package com.infosys.retailrobot.data;

import gherkin.deps.com.google.gson.annotations.Expose;
import gherkin.deps.com.google.gson.annotations.SerializedName;

public class DataMap {

	@SerializedName("_id")
	@Expose
	private String id;
	@SerializedName("_rev")
	@Expose
	private String rev;
	@SerializedName("value")
	@Expose
	private String value;
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
	 *            The _id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The rev
	 */
	public String getRev() {
		return rev;
	}

	/**
	 * 
	 * @param rev
	 *            The _rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}

	/**
	 * 
	 * @return The desciption
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param desciption
	 *            The desciption
	 */
	public void setValue(String value) {
		this.value = value;
	}
}