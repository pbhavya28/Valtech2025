package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Customer.State;
import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.entities.Orders;
import com.valtech.assignment.ordermanagement.entities.Orders.Status;
import com.valtech.assignment.ordermanagement.repos.LineOrderRepo;
import com.valtech.assignment.ordermanagement.repos.OrdersRepo;
import com.valtech.assignment.ordermanagement.vos.LineOrderVO;
import com.valtech.assignment.ordermanagement.vos.OrderVO;
import com.valtech.assignment.ordermanagement.vos.PlaceOrderVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepo orderRepo;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private LineOrderRepo loRepo;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Override
	public void saveOrder(PlaceOrderVO po) {
		int custId = po.custId();
		int itemId =  itemService.getItemIdbyItemName(po.itemName()) ; 
		int quantity = po.quantity();
		System.out.println("custId: "+custId +" itemId: "+itemId+" quantity: "+quantity);
		
		LineOrder lo = new LineOrder();
		lo.setItem(itemService.getItem(itemId).to());
		lo.setQty(quantity);
		
		Orders order = new Orders();
		order.addLineOrder(lo);
		order.setCustomer(customerService.getCustomer(custId).to());
		order.setStatus(Status.IN_PROGRESS);
		boolean valid = true;

		for (LineOrder lineOrder : order.getLineOrder() ) {
			if(lineOrder.getQty() > lineOrder.getItem().getCurrentQty() || order.getCustomer().getState() == State.DISABLED) {
				valid = false;
				order.setStatus(Status.REJECTED);
				orderRepo.save(order);
				System.out.println("Quantity surpassed or Customer is Disabled");
				break;	
			}
		}
		if(valid) {
			
			order.setStatus(Status.DISPATCHED);
			System.out.println("hiiiiiiiiiiii" + order.toString());
			orderRepo.save(order);
			System.out.println("item1111111111111111111");
			itemService.updateInventory(order);
			System.out.println("item22222222222222222222");
		}
	}
	
	
//	@Override
	public void saveOrder2(OrderVO orderVo) {
		boolean valid = true;
		Orders order = orderVo.to();
		
		

		for (LineOrderVO lineOrderVo : LineOrderVO.from(orderVo.lineOrder())  ) {
			if(lineOrderVo.qty() > lineOrderVo.item().getCurrentQty() || orderVo.cust().getState() == State.DISABLED) {
				valid = false;
				order.setStatus(Status.REJECTED);
				orderRepo.save(order);
				System.out.println("Quantity surpassed or Customer is Disabled");
				break;	
			}
		}
		if(valid) {
			
			order.setStatus(Status.DISPATCHED);
			System.out.println("hiiiiiiiiiiii" + order.toString());
//			System.out.println(order.getLineOrder().size()+"  000000000000000000");
			orderRepo.save(order);
			System.out.println("item1111111111111111111");
			itemService.updateInventory(order);
			System.out.println("item22222222222222222222");
		}
	}
	
	public void saveOrder1(OrderVO orderVo) {
		boolean valid = true;
		Orders order = orderVo.to();
		
		

		for (LineOrder lineOrder : order.getLineOrder() ) {
			if(lineOrder.getQty() > lineOrder.getItem().getCurrentQty() || order.getCustomer().getState() == State.DISABLED) {
				valid = false;
				order.setStatus(Status.REJECTED);
				orderRepo.save(order);
				System.out.println("Quantity surpassed or Customer is Disabled");
				break;	
			}
		}
		if(valid) {
			
			order.setStatus(Status.DISPATCHED);
			System.out.println("hiiiiiiiiiiii" + order.toString());
			System.out.println(order.getLineOrder().size()+"  000000000000000000");
			orderRepo.save(order);
			System.out.println("item1111111111111111111");
			itemService.updateInventory(order);
			System.out.println("item22222222222222222222");
		}
	}
	
	
	@Override
	public OrderVO updateOrder(OrderVO order) {
		return OrderVO.from(orderRepo.save(order.to()));
	}
	
	@Override
	public OrderVO getOrder(int id) {
		return OrderVO.from(orderRepo.getReferenceById((long) id));
	}
	
	@Override
	public List<OrderVO> getOrders(){
		return OrderVO.from(orderRepo.findAll());
	}
	
//	@Override
//	public void saveOrderThroughPlaceOrder(PlaceOrderVO placeOrderVO) {
//		
//		boolean valid = true;
//		LineOrder lo = new LineOrder();
//		lo.setItem(itemService.getItem(placeOrderVO.itemId()).to());
//		lo.setQty(placeOrderVO.quantity());
//		
//		Orders order = new Orders();
//		order.addLineOrder(lo);
//		order.setCustomer(customerService.getCustomer(placeOrderVO.custId()).to());
//		order.setStatus(Status.IN_PROGRESS);
//	      OrderVO orderVo =	OrderVO.from(order);
//		for (LineOrderVO lineOrderVo : LineOrderVO.from(orderVo.lineOrder())  ) {
//			if(lineOrderVo.qty() > lineOrderVo.item().getCurrentQty() || orderVo.cust().getState() == State.DISABLED) {
//				valid = false;
//				order.setStatus(Status.REJECTED);
////				lo.setOrder(order);
//				orderRepo.save(order);
//				System.out.println("Quantity surpassed or Customer is Disabled");
//				break;	
//			}
//		}
//		if(valid) {
//			
//			order.setStatus(Status.DISPATCHED);
//			System.out.println("hiiiiiiiiiiii" + order.toString());
//			orderRepo.save(order);
//			System.out.println("item1111111111111111111");
//			lo.setOrder(order);
////			loRepo.save(lo);
//			itemService.updateInventory(order);
//			System.out.println("item22222222222222222222");
//		}
//	}
	
}
