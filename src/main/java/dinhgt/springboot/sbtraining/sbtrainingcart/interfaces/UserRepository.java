package dinhgt.springboot.sbtraining.sbtrainingcart.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dinhgt.springboot.sbtraining.sbtrainingcart.model.Account;

public interface UserRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findByEmailAndIsActived(String email, boolean isActivated);
}
