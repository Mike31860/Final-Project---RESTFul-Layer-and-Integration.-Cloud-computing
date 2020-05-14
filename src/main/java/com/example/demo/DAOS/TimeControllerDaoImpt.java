package com.example.demo.DAOS;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.example.demo.Model.TsscTimecontrol;

@Repository
@Scope("singleton")
public class TimeControllerDaoImpt implements TimeControllerDao{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public  TsscTimecontrol save(TsscTimecontrol entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public TsscTimecontrol merge(TsscTimecontrol entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void delete(TsscTimecontrol entity) {
		entityManager.remove(entity);
		
	}

	@Override
	public TsscTimecontrol findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(TsscTimecontrol.class, id);
	}

}
