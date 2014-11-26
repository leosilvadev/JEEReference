package br.com.leonardojgs.jeereference.model.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.leonardojgs.jeereference.model.domains.User;
import br.com.leonardojgs.jeereference.model.services.UserService;

@Stateless
public class UserEJB implements UserService {

	@PersistenceContext
    private EntityManager em;

	public List<User> findAll() {
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
		cq.select(cq.from(User.class));
		return em.createQuery(cq).getResultList();
	}

}
