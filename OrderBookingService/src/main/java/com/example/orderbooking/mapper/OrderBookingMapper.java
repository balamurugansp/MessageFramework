package com.example.orderbooking.mapper;

import org.springframework.beans.BeanUtils;

import com.example.orderbooking.entity.OrderBookingEntity;
import com.example.orderbooking.model.OrderBooking;

public class OrderBookingMapper extends BaseMapper<OrderBookingEntity, OrderBooking>{

	@Override
	public OrderBookingEntity convertToEntity(OrderBooking model, Object... args) {
		OrderBookingEntity entity = new OrderBookingEntity();
		if(model!=null) {
			BeanUtils.copyProperties(model, entity);
		}
		return entity;
	}

	@Override
	public OrderBooking convertToModel(OrderBookingEntity entity, Object... args) {
		OrderBooking model = new OrderBooking();
		if(entity!=null) {
			BeanUtils.copyProperties(entity,model);
		}
		return model;
	}

	 
}
