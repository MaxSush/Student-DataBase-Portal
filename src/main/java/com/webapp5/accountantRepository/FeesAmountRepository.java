package com.webapp5.accountantRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.accountantEntity.FeesAmount;

public interface FeesAmountRepository extends JpaRepository<FeesAmount, Long> {

}
