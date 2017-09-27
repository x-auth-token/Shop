package com.pa.srv.employee;

import com.pa.common.Person;

public class Employee extends Person {

	private String accountNumber;
	private int branchId;
	private int employeeId;
	private String role;
	
	public Employee() {
		super();
	}

	public Employee(String name, String sName, String gender, String id, String pn) {
		super(name, sName, gender, id, pn);
		// TODO Auto-generated constructor stub
	}
	
	

}
