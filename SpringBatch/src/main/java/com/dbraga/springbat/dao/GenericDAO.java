package com.dbraga.springbat.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
 
 
@SuppressWarnings("unchecked")
public abstract class GenericDAO<PK, T> {
    
	@PersistenceContext
	protected EntityManager entityManager;
 
    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
	public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}