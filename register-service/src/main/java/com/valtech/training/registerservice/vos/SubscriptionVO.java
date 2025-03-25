package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO(int id, int amount, String startDate, String endDate, List<Integer> userIds) {

	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from(Subscription sub) {
		String startDate1 = sub.getStartDate().format(FORMATTER);
		String endDate1 = sub.getEndDate().format(FORMATTER);
		List<Integer> ids = sub.getUsers().stream().map(subc -> subc.getId()).collect(Collectors.toList());
		return new SubscriptionVO(sub.getId(),sub.getAmount(),startDate1,endDate1,ids);
	}
	public Subscription to(List<User> users) {
		LocalDate startDate1 = LocalDate.parse(startDate,FORMATTER);
		LocalDate endDate1 = LocalDate.parse(endDate,FORMATTER);
		 
		Subscription sub = new Subscription(amount,startDate1,endDate1);
		sub.setUsers(users);
		return sub;
	}
	public static List<SubscriptionVO> from(List<Subscription> subs) {
		return subs.stream().map(sub -> SubscriptionVO.from(sub)).collect(Collectors.toList());
	}
	
}
