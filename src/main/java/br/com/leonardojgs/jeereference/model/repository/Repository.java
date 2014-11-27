package br.com.leonardojgs.jeereference.model.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class Repository<T> {
	
	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> entityClass = getClassType();

	public T save(T e) {
		em.persist(e);
		return e;
	}

	public void remove(T entity) {
		em.remove(em.merge(entity));
	}

	public T find(Serializable id) {
		return em.find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findRange(int[] range) {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		Query q = em.createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}
	
	/**
	 *   Eduardo Guerra Example
	 *   https://groups.google.com/forum/#!topic/projeto-oo-guiado-por-padroes/pOIiOD9cifs
	 * 	
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getClassType() {
		Class<?> clazz = this.getClass();
		while (!clazz.getSuperclass().equals(Repository.class)) {
			clazz = clazz.getSuperclass();
		}
		ParameterizedType tipoGenerico = (ParameterizedType) clazz.getGenericSuperclass();
		return ((Class<T>) tipoGenerico.getActualTypeArguments()[0]);
	}

}
