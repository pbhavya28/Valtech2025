package assignment2.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryServiceImpl implements InventoryService {
	
	private javax.sql.DataSource dataSource;

	private SessionFactory sessionFactory;
	
	@Autowired
	ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	public void resetInventory(Item item) {
		
		item.setCurrent_qty(item.getMax_qty());
		item.setReOrder_qty(0);
		itemDAO.update(item);
	}

	@Override
	public void updateInventory(Orders o) {
		Item item;
		for (LineOrder lineOrder : o.getLineOrder()) {
			item = itemDAO.get(lineOrder.getItem().getId());
			item.setCurrent_qty(item.getCurrent_qty()-lineOrder.getQty());
			item.setReOrder_qty(item.getReOrder_qty() + lineOrder.getQty());
			itemDAO.update(item);
			if(item.getCurrent_qty() == 0) {
				resetInventory(item);
			}			
		}		
	}
}
