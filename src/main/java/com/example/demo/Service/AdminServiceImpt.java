package com.example.demo.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.GameRepository;

@Service
public class AdminServiceImpt implements AdminService {

//	@Autowired
//	private AdminRepository admin;
//
//
//	@Autowired
//	public AdminServiceImpt(AdminRepository admin) {
//
//		this.admin = admin;
//	
//	}
//	
//	
//	@Override
//	public TsscAdmin agregar(TsscAdmin nuevo) {
//		
//		admin.save(nuevo);
//		return nuevo;
//	}
//
//	@Override
//	public void eliminar(TsscAdmin eliminar) {
//		admin.delete(eliminar);
//		
//	}
//
//	@Override
//	public TsscAdmin editar(TsscAdmin editar) {
//		
//		return admin.save(editar);
//	}
//	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscAdmin agregar(TsscAdmin entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscAdmin editar(TsscAdmin entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void eliminar(TsscAdmin entity) {
		entityManager.remove(entity);
		
	}

	
	

}
