/**
 * 
 */
package com.example.orderbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderbooking.entity.OrderBookingEntity;

/**
 * 
 */
public interface OrderBookingRepository extends JpaRepository<OrderBookingEntity, Integer> {

}
