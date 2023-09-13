/**
 * 
 */
package com.message.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.message.billingservice.entity.BillingEntity;

/**
 * 
 */
public interface BillingServiceRepository extends JpaRepository<BillingEntity, Integer> {

}
