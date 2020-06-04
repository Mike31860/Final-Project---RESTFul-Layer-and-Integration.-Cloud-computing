package com.example.demo.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTopic;

@Repository
@Scope("singleton")
public class AdminDaoImpt implements AdminDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TsscAdmin guardar(TsscAdmin entity) {
		entityManager.persist(entity);
		//entityManager.merge(entity);
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
	
	@Override
	public List<TsscAdmin> findAll() {
		String jpql = "SELECT t FROM TsscAdmin t";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public TsscAdmin findByUser(String user) {
		String jpql = "Select a from TsscAdmin a Where a.username = '"+user+"'";
		TsscAdmin admin = (TsscAdmin) entityManager.createQuery(jpql).getSingleResult();
		return admin;
	}
	
	

}
