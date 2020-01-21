package com.ex.serviceInt;

import java.util.List;

import com.ex.model.Item;

public interface ItemServiceInt {
	public List<Item> getAllItems();

	public Item save(Item item);

	public Item get(String itemName);

	public void delete(long itemId);
	public void update(Item item);
}
