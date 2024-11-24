package com.webapp5.accountantRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.accountantEntity.Accountant;
import com.webapp5.accountantEntity.AccountantRegistration;

public interface AccountantRepository extends JpaRepository<Accountant, Long> {

	Optional<Accountant> findByUsnAndPassword(String usn, String password);

	Optional<AccountantRegistration> findByUsn(String usn);

}
