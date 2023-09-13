package com.message.billingservice.mapper;

import org.springframework.beans.BeanUtils;

import com.message.billingservice.entity.BillingEntity;
import com.message.billingservice.model.Billing;

public class BillingMapper extends BaseMapper<BillingEntity, Billing>{

	@Override
	public BillingEntity convertToEntity(Billing model, Object... args) {
		BillingEntity entity = new BillingEntity();
		if(model!=null) {
			BeanUtils.copyProperties(model, entity);
		}
		return entity;
	}

	@Override
	public Billing convertToModel(BillingEntity entity, Object... args) {
		Billing model = new Billing();
		if(entity!=null) {
			BeanUtils.copyProperties(entity,model);
		}
		return model;
	}

	 
}
