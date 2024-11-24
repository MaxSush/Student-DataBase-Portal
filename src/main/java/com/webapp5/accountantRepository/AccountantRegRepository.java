package com.webapp5.accountantRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.accountantEntity.AccountantRegistration;

public interface AccountantRegRepository extends JpaRepository<AccountantRegistration, Long> {

	Optional<AccountantRegistration> findByUsn(String usn);

	boolean existsByEmail(String email);

}
