package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
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

import com.example.demo.DAOS.GameDao;
import com.example.demo.Delagate.GameDelegate;
import com.example.demo.Delagate.GameDelegateImpt;
import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.TopicServiceImpt;
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class gameDelegateTest {

	final String SERVER="http://localhost:8080/";
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@InjectMocks
	private GameDelegateImpt gameServiceImp;
	
	@Autowired
	private TopicServiceImpt topiService;
	
    @Autowired
	public gameDelegateTest(GameDelegateImpt gameServiceImp) {
		super();
		this.gameServiceImp = gameServiceImp;
	}

	@Test
	void testAnadirGameconTema() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
        TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topiService.AnadirTopic(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
        
        
        when(restTemplate.postForObject(SERVER +"api/games", gameOne, TsscGame.class)).thenReturn(gameOne);
		assertNotNull(gameServiceImp.guardar(gameOne));


	}
	
	@Test
	void testActualizarGameconTema() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);		
        TsscTopic nuevo= new TsscTopic();		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topiService.AnadirTopic(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
        when(restTemplate.postForObject(SERVER +"api/games", gameOne, TsscGame.class)).thenReturn(gameOne);
		
        assertNotNull(gameServiceImp.guardar(gameOne));
		gameOne.setName("Nelson");
		gameOne.setNSprints(25);
		when(restTemplate.patchForObject(SERVER+"api/games", gameOne, TsscGame.class)).thenReturn(gameOne);
	    gameServiceImp.actualizar(gameOne);
	    when(restTemplate.getForObject(SERVER+"api/games/"+gameOne.getId(), TsscGame.class )).thenReturn(gameOne);
	    assertEquals(gameServiceImp.encontrarPorId(gameOne.getId()).getName(), "Nelson");
	    assertEquals(gameServiceImp.encontrarPorId(gameOne.getId()).getNSprints(), 25);
		


	}
	
	@Test
	void testEliminarGameconTema() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
        TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topiService.AnadirTopic(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
        
        
        when(restTemplate.postForObject(SERVER +"api/games", gameOne, TsscGame.class)).thenReturn(gameOne);
		assertNotNull(gameServiceImp.guardar(gameOne));
		restTemplate.delete(SERVER+"api/games/"+gameOne.getId());
		gameServiceImp.eliminar(gameOne.getId());
	    assertNull(gameServiceImp.encontrarPorId(gameOne.getId()));
	

	}


}
