package br.com.leonardojgs.jeereference.model.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.leonardojgs.jeereference.model.business.UserBusiness;
import br.com.leonardojgs.jeereference.model.domains.User;
import br.com.leonardojgs.jeereference.model.repository.Repository;

@Stateless
public class UserEJB implements UserBusiness {

	@Inject
    private Repository<User> repository;

	public List<User> findAll() {
		return repository.findAll();
	}

}
