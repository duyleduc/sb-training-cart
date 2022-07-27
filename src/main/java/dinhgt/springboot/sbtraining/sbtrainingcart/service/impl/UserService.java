package dinhgt.springboot.sbtraining.sbtrainingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtraining.sbtrainingcart.interfaces.UserRepository;
import dinhgt.springboot.sbtraining.sbtrainingcart.model.Account;
import dinhgt.springboot.sbtraining.sbtrainingcart.model.UserDetailsImpl;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmailAndIsActived(username, true).get();
		System.err.println(account.getEmail());
		return UserDetailsImpl.build(account);
	}

}
