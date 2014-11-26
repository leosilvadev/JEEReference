package br.com.leonardojgs.jeereference.model.services;

import java.util.List;

import javax.ejb.Local;

import br.com.leonardojgs.jeereference.model.domains.User;

@Local
public interface UserService {

	List<User> findAll();

}
