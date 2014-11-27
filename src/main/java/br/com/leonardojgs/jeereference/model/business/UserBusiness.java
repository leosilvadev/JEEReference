package br.com.leonardojgs.jeereference.model.business;

import java.util.List;

import javax.ejb.Local;

import br.com.leonardojgs.jeereference.model.domains.User;

@Local
public interface UserBusiness {

	List<User> findAll();

}
