package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.TimeControllerDaoImpt;
import com.example.demo.Delagate.TimeControllerDelegate;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Service.TimeControlServiceImpt;

@SpringBootTest
class timeControllDelegateTest {
	
	@Autowired
	@InjectMocks
	private TimeControlServiceImpt TimeServiceImp;
	
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
		when(delegate.guardar(nuevo)).thenReturn(nuevo);
		assertNotNull(TimeServiceImp.AnadirTimeControl(nuevo));
		
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
		when(delegate.guardar(nuevo)).thenReturn(nuevo);
		assertNotNull(TimeServiceImp.AnadirTimeControl(nuevo));
		delegate.eliminar(nuevo);
		TimeServiceImp.eliminarTime(nuevo);
		assertNull(TimeServiceImp.findTimeById(nuevo.getId()));
		
		
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
		when(delegate.guardar(nuevo)).thenReturn(nuevo);
		assertNotNull(TimeServiceImp.AnadirTimeControl(nuevo));
		assertNotNull(TimeServiceImp.findTimeById(nuevo.getId()));
		nuevo.setAutostart("Nelson");
		nuevo.setOrder(BigDecimal.valueOf(85));
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Segundo");
		nuevo.setState("HEY2");
		nuevo.setIntervalRunning(BigDecimal.valueOf(75));
		nuevo.setType("MEyu");
		nuevo.setTimeInterval(BigDecimal.valueOf(29));
		when(delegate.actualizar(nuevo)).thenReturn(nuevo);
		assertEquals(nuevo.getAutostart(),TimeServiceImp.findTimeById(nuevo.getId()).getAutostart());
		assertEquals(nuevo.getOrder(),TimeServiceImp.findTimeById(nuevo.getId()).getOrder());
		assertEquals(nuevo.getLastPlayTime(),TimeServiceImp.findTimeById(nuevo.getId()).getLastPlayTime());
		assertEquals(nuevo.getName(),TimeServiceImp.findTimeById(nuevo.getId()).getName());
		assertEquals(nuevo.getState(),TimeServiceImp.findTimeById(nuevo.getId()).getState());
		assertEquals(nuevo.getIntervalRunning(),TimeServiceImp.findTimeById(nuevo.getId()).getIntervalRunning());
		assertEquals(nuevo.getType(),TimeServiceImp.findTimeById(nuevo.getId()).getType());
		assertEquals(nuevo.getTimeInterval(),TimeServiceImp.findTimeById(nuevo.getId()).getTimeInterval());
		
		
	}

}
