package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.model.SalesOrder;
import com.ex.repository.CustomerSalesOrderRepository;
import com.ex.repository.SalesOrderRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class SalesOrderService {
	
	@Autowired
	private JavaMailSender mailSender;


	@Autowired
	private SalesOrderRepository salesOrderRepository;

	@Autowired
	private CustomerSalesOrderRepository customerSORepository;

	public List<SalesOrder> all() {
		List<SalesOrder> tempSalesList= salesOrderRepository.findAll();
		List<SalesOrder> list=new ArrayList<>();
		SalesOrder order=null;
		for(SalesOrder so:tempSalesList) {
			order=new SalesOrder();
			order.setId(so.getId());
			order.setCustId(so.getCustId());
			order.setOrderDesc(so.getOrderDesc());
			list.add(order);
		}
		return list;
	}
	public SalesOrder save(SalesOrder salesOrder) {
		SalesOrder order=salesOrderRepository.save(salesOrder);
		Customer customer = customerSORepository.getOne(salesOrder.getCustId());
		try {
				this.mailSender.send(mimeMessage -> {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(customer.getCustEmail()));
				mimeMessage.setFrom(new InternetAddress("asapriyank@gmail.com"));
				StringBuilder messageBodyBldr = new StringBuilder();
				messageBodyBldr.append("Dear ").append(customer.getCustLastName()).append(", ")
						.append(customer.getCustFirstName()).append(", thanks for your order. ")
						.append("Your order number is ").append(salesOrder.getId()).append(".");
				mimeMessage.setText(messageBodyBldr.toString());

			});
		}catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
		return order;
	}

	public SalesOrder get(long orderId) {
		Optional<SalesOrder> orderResult = salesOrderRepository.findById(orderId);
		if (!orderResult.isPresent()) {
			return null;
		}
		return orderResult.get();
	}

	public void delete(long orderId) {
		salesOrderRepository.deleteById(orderId);
	}
}
