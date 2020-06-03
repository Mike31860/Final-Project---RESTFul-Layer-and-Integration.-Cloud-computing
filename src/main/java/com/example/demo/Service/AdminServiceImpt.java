package com.example.demo.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.AdminDao;
import com.example.demo.DAOS.TopicDao;
import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTopic;
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
	
	@Autowired
	private AdminDao repositorio;
	
	@Autowired
	public AdminServiceImpt(AdminDao repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscAdmin agregar(TsscAdmin entity) {
		
		return repositorio.guardar(entity);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscAdmin editar(TsscAdmin entity) {
		
		return repositorio.actualizar(entity);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void eliminar(TsscAdmin entity) {
		repositorio.eliminar(entity);;
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscAdmin findById(long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Iterable<TsscAdmin> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}


	
	

}
