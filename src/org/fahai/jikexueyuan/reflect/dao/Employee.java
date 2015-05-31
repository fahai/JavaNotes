package org.fahai.jikexueyuan.reflect.dao;

public class Employee {

	private int id;
	private String name;
	private String duty;
	private int deptId;
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

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

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public String toString() {
		return "id: " + this.id + "\t name: " + this.name + "\t duty: "
				+ this.duty + "\t deptId: " + this.deptId;
	}

}
