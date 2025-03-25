package assignment2.spring.service;

//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



import assignment2.spring.dao.ItemDAO;
import assignment2.spring.entities.Item;
import assignment2.spring.entities.LineOrder;
import assignment2.spring.entities.Orders;

public class InventoryServiceImpl implements InventoryService {
	
//	private javax.sql.DataSource dataSource;

//	private SessionFactory sessionFactory;
	
	@Autowired
	ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	public void resetInventory(Item item) {
		
		item.setCurrentQty(item.getMaxQty());
		item.setReOrderQty(0);
		itemDAO.update(item);
	}

	@Override
	public void updateInventory(Orders o) {
		Item item;
		for (LineOrder lineOrder : o.getLineOrder()) {
			item = itemDAO.get(lineOrder.getItem().getId());
			item.setCurrentQty(item.getCurrentQty()-lineOrder.getQty());
			item.setReOrderQty(item.getReOrderQty() + lineOrder.getQty());
			itemDAO.update(item);
			if(item.getCurrentQty() == 0) {
				resetInventory(item);
			}			
		}		
	}
}
