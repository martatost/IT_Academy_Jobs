package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

import java.lang.reflect.Array;
import java.util.List;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		repository = new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void createVolunteer(String name, String address, String phone) throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone);
		repository.addMember(volunteer);
	}


	public void payAllEmployees() {
		List<AbsStaffMember> staffMembers = repository.getAllMembers();
		for (AbsStaffMember member: staffMembers) {
			member.pay();
		}
	}

	public String getAllEmployees() {
		List<AbsStaffMember> staffMembers = repository.getAllMembers();

		String members= "\n";
		for (AbsStaffMember member: staffMembers) {
			members = members+member.toString()+"\n";
		}
		return members;
	}
}
