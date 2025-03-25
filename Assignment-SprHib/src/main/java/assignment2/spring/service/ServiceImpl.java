
package assignment2.spring.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import assignment2.spring.dao.ItemDAO;
import assignment2.spring.dao.LineOrderDAO;
import assignment2.spring.dao.OrdersDAO;
import assignment2.spring.entities.Customer.State;
import assignment2.spring.entities.LineOrder;
import assignment2.spring.entities.Orders;
import assignment2.spring.entities.Orders.Status;

public class ServiceImpl implements Service {
	
//	private javax.sql.DataSource dataSource;
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private OrdersDAO orderDAO;
	
	public void setOrderDAO(OrdersDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@Autowired
	private LineOrderDAO lineOrderDAO;
	public void setLineOrderDAO(LineOrderDAO lineOrderDAO) {
		this.lineOrderDAO = lineOrderDAO;
	}
	
	@Autowired
	private ItemDAO itemDAO;
	public void setIteamDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	@Autowired
	private InventoryService inventoryDAO;
	public void setInventoryDAO(InventoryService inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	
	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrder(Orders o) {

		boolean valid = true;

		for (LineOrder lineOrder : o.getLineOrder()) {
			if(lineOrder.getQty() > lineOrder.getItem().getCurrentQty() || o.getCustomer().getState() == State.DISABLED) {
				valid = false;
				o.setStatus(Status.REJECTED);
				orderDAO.save(o);
				System.out.println("Quantity surpassed or Customer is Disabled");
				break;	
			}
		}
		if(valid) {
			
			o.setStatus(Status.DISPATCHED);
			orderDAO.save(o);
			inventoryDAO.updateInventory(o);
			
			
			
//			Item item;
//			for (LineOrder lineOrder : o.getLineOrder()) {
//
//				item = itemDAO.get(lineOrder.getItem().getId());
//				item.setCurrent_qty(item.getCurrent_qty()-lineOrder.getQty());
//				item.setReOrder_qty(item.getReOrder_qty() + lineOrder.getQty());
////				System.out.println("iiiiiiiiiiiiiiiii"+item.getCurrent_qty());
//				itemDAO.update(item);
//				if(item.getCurrent_qty() == 0) {
//					inventoryDAO.resetInventory(item);
//				}				
////				o.setStatus(Status.REJECTED);
///
//
//			}
//			sessionFactory.getCurrentSession().flush();
//			sessionFactory.openSession();
			
		}
	}
	
	@Override
	public void saveLineOrder(LineOrder lo) {
		
		if(lo.getQty() > lo.getItem().getCurrentQty()) {
			System.out.println("Quantity surpassed..");
		}
		else{
//			lineOrderDAO.save(lo);
		}
	}

}


