package com.message.shipmentservice.mapper;

import org.springframework.beans.BeanUtils;

import com.message.shipmentservice.model.Shipment;
import com.message.shipmentservice.entity.ShipmentEntity;

public class ShipmentMapper extends BaseMapper<ShipmentEntity, Shipment>{

	@Override
	public ShipmentEntity convertToEntity(Shipment model, Object... args) {
		ShipmentEntity entity = new ShipmentEntity();
		if(model!=null) {
			BeanUtils.copyProperties(model, entity);
		}
		return entity;
	}

	@Override
	public Shipment convertToModel(ShipmentEntity entity, Object... args) {
		Shipment model = new Shipment();
		if(entity!=null) {
			BeanUtils.copyProperties(entity,model);
		}
		return model;
	}

	 
}
