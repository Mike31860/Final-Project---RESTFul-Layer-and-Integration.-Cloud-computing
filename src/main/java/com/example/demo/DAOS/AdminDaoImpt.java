package com.example.demo.DAOS;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TsscAdmin;

@Repository
@Scope("singleton")
public class AdminDaoImpt implements AdminDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TsscAdmin guardar(TsscAdmin entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public TsscAdmin actualizar(TsscAdmin entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void eliminar(TsscAdmin entity) {
		entityManager.remove(entity);
		
	}

	@Override
	public TsscAdmin findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(TsscAdmin.class, id);
	}

}
