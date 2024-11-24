package com.webapp5.accountantRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.accountantEntity.TotalFees;

public interface TotalFeesRepo extends JpaRepository<TotalFees, Long> {

	TotalFees findByStudentUsn(String studentUsn);

	List<TotalFees> findAll();

}
