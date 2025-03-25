package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.entities.Orders;
import com.valtech.assignment.ordermanagement.repos.ItemRepo;
import com.valtech.assignment.ordermanagement.vos.ItemVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public ItemVO saveItem(ItemVO itemVo) {
		Item item = itemVo.to();
//		int id = item.getId();
		return ItemVO.from(itemRepo.save(item));
	}
	
	@Override
	public ItemVO updateItem(ItemVO itemVo) {
		return ItemVO.from(itemRepo.save(itemVo.to()));
	}
	@Override
	public ItemVO getItem(long id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
	}
	@Override
	public List<ItemVO> getItems(){
		return ItemVO.from(itemRepo.findAll());
	}
	@Override
	public void updateInventory(Orders o) {
		Item item;
		for (LineOrder lineOrder : o.getLineOrder()) {
			item = itemRepo.getReferenceById((long) lineOrder.getItem().getId());
			item.setCurrentQty(item.getCurrentQty()-lineOrder.getQty());
			item.setReOrderQty(item.getReOrderQty() + lineOrder.getQty());
			itemRepo.save(item);
			if(item.getCurrentQty() == 0) {
				resetInventory(item);
			}			
		}		
	}
	@Override
	public void resetInventory(Item item) {
		
		item.setCurrentQty(item.getMaxQty());
		item.setReOrderQty(0);
		itemRepo.save(item);
	}
	@Override
	public int getItemIdbyItemName(String name) {
		return itemRepo.findFirstByName(name).getId();
	}
}
