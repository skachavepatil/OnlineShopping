package com.ex.messagelistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.ex.service.CustomerService;

public class CustomerMessageListener {

	@Autowired
	private CustomerService customerService;

	@JmsListener(destination = "OrderQueue",containerFactory = "myFactory")
	public void receiveMessage(Customer customer) {
		System.out.println("Received <" + customer + ">");
		customerService.save(customer);
	}

	public static class Customer {

		private long id;
		private String email;
		private String firstName;
		private String lastName;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}
}
