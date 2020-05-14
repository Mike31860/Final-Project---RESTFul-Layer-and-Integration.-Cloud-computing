package com.example.demo.DAOS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.TsscAdmin;

@SpringBootTest
class AdminTest {

	@Autowired
	private AdminDao adminDao;
	
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void guardar() {
		
		TsscAdmin miguel= new TsscAdmin();
		miguel.setPassword("miguel23456");
		miguel.setSuperAdmin("miguel7845");
		miguel.setUsername("Miguel Romero");
		
		adminDao.guardar(miguel);
		assertNotNull(adminDao.findById(miguel.getId()));
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void actualizar() {
		TsscAdmin miguel= new TsscAdmin();
		miguel.setPassword("miguel23456");
		miguel.setSuperAdmin("miguel7845");
		miguel.setUsername("Miguel Romero");
		
		adminDao.guardar(miguel);
		
		miguel.setUsername("nelson");
		adminDao.actualizar(miguel);
		assertEquals(adminDao.findById(miguel.getId()).getUsername(), miguel.getUsername());
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void delete() {
		TsscAdmin miguel= new TsscAdmin();
		miguel.setPassword("miguel23456");
		miguel.setSuperAdmin("miguel7845");
		miguel.setUsername("Miguel Romero");
		
		adminDao.guardar(miguel);
		assertNotNull(adminDao.findById(miguel.getId()));
		adminDao.eliminar(miguel);
		assertNull(adminDao.findById(miguel.getId()));
		
	}
	
	

}
