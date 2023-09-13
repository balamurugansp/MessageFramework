package com.message.shipmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.message.shipmentservice.entity.ShipmentEntity;

/**
 * 
 */
public interface ShipmentRepository extends JpaRepository<ShipmentEntity, Integer> {

}