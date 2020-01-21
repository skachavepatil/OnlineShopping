package com.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Item;
import com.ex.repository.ItemRepository;
import com.ex.serviceInt.ItemServiceInt;

@Transactional
@Service
public class ItemServiceImpl implements ItemServiceInt {

	/*
	 * @Autowired private ModelMapper modelMapper;
	 */

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		Item addItem = itemRepository.save(item);
		return addItem;
	}

	@Override
	public Item get(String itemName) {
		// TODO Auto-generated method stub
		return itemRepository.findByName(itemName);
	}

	@Override
	public void delete(long itemId) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(itemId);
	}

	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub
		itemRepository.updateItem(item.getDescription(), item.getPrice(),item.getName());
	}

}
