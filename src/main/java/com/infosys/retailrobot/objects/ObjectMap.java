package com.infosys.retailrobot.objects;

import gherkin.deps.com.google.gson.annotations.Expose;
import gherkin.deps.com.google.gson.annotations.SerializedName;

public class ObjectMap {

	@SerializedName("_id")
	@Expose
	private String id;
	@SerializedName("_rev")
	@Expose
	private String rev;
	@SerializedName("desciption")
	@Expose
	private String desciption;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("objects")
	@Expose
	private Objects objects;

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
	public String getDesciption() {
		return desciption;
	}

	/**
	 * 
	 * @param desciption
	 *            The desciption
	 */
	public void setDesciption(String desciption) {
		this.desciption = desciption;
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

	/**
	 * 
	 * @return The objects
	 */
	public Objects getObjects() {
		return objects;
	}

	/**
	 * 
	 * @param objects
	 *            The objects
	 */
	public void setObjects(Objects objects) {
		this.objects = objects;
	}

}