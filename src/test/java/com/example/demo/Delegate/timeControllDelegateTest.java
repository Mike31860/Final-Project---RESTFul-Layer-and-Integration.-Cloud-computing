package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.TimeControllerDaoImpt;
import com.example.demo.Delagate.TimeControllerDelegate;
import com.example.demo.Model.TsscTimecontrol;

class timeControllDelegateTest {
	
	@Autowired
	@InjectMocks
	private TimeControllerDaoImpt TimeServiceImp;
	
	@Mock
	private TimeControllerDelegate delegate;
	
	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void GuardarTimeControllerTest() {
		
		TsscTimecontrol nuevo= new TsscTimecontrol();
		nuevo.setAutostart("Miguel");
		nuevo.setOrder(BigDecimal.ONE);
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Primero");
		nuevo.setState("HEY");
		nuevo.setIntervalRunning(BigDecimal.TEN);
		nuevo.setType("ME");
		nuevo.setTimeInterval(BigDecimal.valueOf(23));
		

		TimeServiceImp.save(nuevo);
		assertNotNull(TimeServiceImp.findById(nuevo.getId()));
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void EliminarTimeControllerTest() {
		
		TsscTimecontrol nuevo= new TsscTimecontrol();
		nuevo.setAutostart("Miguel");
		nuevo.setOrder(BigDecimal.ONE);
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Primero");
		nuevo.setState("HEY");
		nuevo.setIntervalRunning(BigDecimal.TEN);
		nuevo.setType("ME");
		nuevo.setTimeInterval(BigDecimal.valueOf(23));
		TimeServiceImp.save(nuevo);
		assertNotNull(TimeServiceImp.findById(nuevo.getId()));
		TimeServiceImp.delete(nuevo);
		assertNull(TimeServiceImp.findById(nuevo.getId()));
		
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void EditarTimeControllerTest() {
		
		TsscTimecontrol nuevo= new TsscTimecontrol();
		nuevo.setAutostart("Miguel");
		nuevo.setOrder(BigDecimal.ONE);
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Primero");
		nuevo.setState("HEY");
		nuevo.setIntervalRunning(BigDecimal.TEN);
		nuevo.setType("ME");
		nuevo.setTimeInterval(BigDecimal.valueOf(23));
		TimeServiceImp.save(nuevo);
		nuevo.setAutostart("Nelson");
		nuevo.setOrder(BigDecimal.valueOf(85));
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Segundo");
		nuevo.setState("HEY2");
		nuevo.setIntervalRunning(BigDecimal.valueOf(75));
		nuevo.setType("MEyu");
		nuevo.setTimeInterval(BigDecimal.valueOf(29));
		
		TimeServiceImp.merge(nuevo);
		
		assertEquals(nuevo.getAutostart(),TimeServiceImp.findById(nuevo.getId()).getAutostart());
		assertEquals(nuevo.getOrder(),TimeServiceImp.findById(nuevo.getId()).getOrder());
		assertEquals(nuevo.getLastPlayTime(),TimeServiceImp.findById(nuevo.getId()).getLastPlayTime());
		assertEquals(nuevo.getName(),TimeServiceImp.findById(nuevo.getId()).getName());
		assertEquals(nuevo.getState(),TimeServiceImp.findById(nuevo.getId()).getState());
		assertEquals(nuevo.getIntervalRunning(),TimeServiceImp.findById(nuevo.getId()).getIntervalRunning());
		assertEquals(nuevo.getType(),TimeServiceImp.findById(nuevo.getId()).getType());
		assertEquals(nuevo.getTimeInterval(),TimeServiceImp.findById(nuevo.getId()).getTimeInterval());
		
		
	}

}
