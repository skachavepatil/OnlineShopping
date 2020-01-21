package com.ex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.SalesOrder;
import com.ex.service.SalesOrderService;

@RequestMapping("/orders")
@RestController
public class SalesOrderCtrl {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderCtrl.class);
	
	@Autowired
	private SalesOrderService salesOrderService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<SalesOrder> getAllSalesOrder() {
		return salesOrderService.all();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/getbyid/{id}")
	public SalesOrder get(@PathVariable("id") long id) {
		return salesOrderService.get(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/updatebyid/{id}")
	public SalesOrder put(@PathVariable long id, @RequestBody SalesOrder salesOrderDTO) {
		salesOrderDTO.setId(id);
		return salesOrderService.save(salesOrderDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletebyid/{id}")
	public void delete(@PathVariable long id) {
		salesOrderService.delete(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public SalesOrder add(@RequestBody SalesOrder salesOrderDTO) {
		return salesOrderService.save(salesOrderDTO);
	}

}
