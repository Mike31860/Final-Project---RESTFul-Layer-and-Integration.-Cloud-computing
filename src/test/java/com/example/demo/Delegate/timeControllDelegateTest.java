package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DAOS.TimeControllerDaoImpt;
import com.example.demo.Delagate.GameDelegateImpt;
import com.example.demo.Delagate.TimeControlDelegate;
import com.example.demo.Delagate.TimeControlDelegateImp;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.TimeControlServiceImpt;
import com.example.demo.Service.TopicServiceImpt;
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class timeControllDelegateTest {
	
	final String SERVER="http://localhost:8080/";
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@InjectMocks
	private TimeControlDelegateImp timeControlDelegate;
	
    @Autowired
	public timeControllDelegateTest(TimeControlDelegateImp timeControlDelegate) {
		this.timeControlDelegate = timeControlDelegate;
	}
	

	@Test
	void GuardarTimeControlTest() {
		
		TsscTimecontrol nuevo= new TsscTimecontrol();
		nuevo.setAutostart("Miguel");
		nuevo.setOrder(BigDecimal.ONE);
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Primero");
		nuevo.setState("HEY");
		nuevo.setIntervalRunning(BigDecimal.TEN);
		nuevo.setType("ME");
		nuevo.setTimeInterval(BigDecimal.valueOf(23));
		when(restTemplate.postForObject(SERVER +"api/times", nuevo, TsscTimecontrol.class)).thenReturn(nuevo);
		assertNotNull(timeControlDelegate.guardar(nuevo));
		
	}
	
	@Test
	void actualizarTimeControlTest() {
		
		TsscTimecontrol nuevo= new TsscTimecontrol();
		nuevo.setAutostart("Miguel");
		nuevo.setOrder(BigDecimal.ONE);
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Primero");
		nuevo.setState("HEY");
		nuevo.setIntervalRunning(BigDecimal.TEN);
		nuevo.setType("ME");
		nuevo.setTimeInterval(BigDecimal.valueOf(23));
		when(restTemplate.postForObject(SERVER +"api/times", nuevo, TsscTimecontrol.class)).thenReturn(nuevo);
		assertNotNull(timeControlDelegate.guardar(nuevo));
		nuevo.setName("hey");
		when(restTemplate.patchForObject(SERVER+"api/times", nuevo, TsscTimecontrol.class)).thenReturn(nuevo);
		assertNotNull(timeControlDelegate.actualizar(nuevo));
		
	}
	
	@Test
	void eliminarTimeControlTest() {
		
		TsscTimecontrol nuevo= new TsscTimecontrol();
		nuevo.setAutostart("Miguel");
		nuevo.setOrder(BigDecimal.ONE);
		nuevo.setLastPlayTime(LocalTime.now());
		nuevo.setName("Primero");
		nuevo.setState("HEY");
		nuevo.setIntervalRunning(BigDecimal.TEN);
		nuevo.setType("ME");
		nuevo.setTimeInterval(BigDecimal.valueOf(23));
		when(restTemplate.postForObject(SERVER +"api/times", nuevo, TsscTimecontrol.class)).thenReturn(nuevo);
		assertNotNull(timeControlDelegate.guardar(nuevo));
		restTemplate.delete(SERVER+"api/times/"+nuevo.getId());
		timeControlDelegate.eliminar(nuevo);
		assertNull(timeControlDelegate.findById(nuevo.getId()));
	
		
	}
	


}
