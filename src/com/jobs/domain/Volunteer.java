package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		
	}

	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);

	}

	@Override
	public void pay() {
		
	}

	@Override
	public String toString(){
		return ("name: "+ name+", adress: "+address+", phone:" + phone + ". This member is a volunteer.");
	}

}
