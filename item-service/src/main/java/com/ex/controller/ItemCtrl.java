package com.ex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cs.controller.CustomerController;
import com.ex.model.Item;
import com.ex.service.ItemServiceImpl;

@RequestMapping("/items")
@RestController
public class ItemCtrl {
	
	private static final Logger LOG = LoggerFactory.getLogger(ItemCtrl.class);

	@Autowired
	ItemServiceImpl itemService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/get/{name}")
	public Item get(@PathVariable("name") String name) {
		return itemService.get(name);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{name}")
	public void put(@PathVariable("name") String name,@RequestBody Item item) {
		item.setName(name);
		itemService.update(item);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		itemService.delete(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Item add(@RequestBody Item itemDTO) {
		return itemService.save(itemDTO);
	}

}
