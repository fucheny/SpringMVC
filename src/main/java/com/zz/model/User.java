package com.zz.model;

public class User {
	private int id;
	private String name;
	private String sex;
	private String phone;
	private String groupz;
	private String leader;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGroupz() {
		return groupz;
	}

	public void setGroupz(String groupz) {
		this.groupz = groupz;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + sex + " " + phone + " " + groupz + " " + leader;
	}

}
