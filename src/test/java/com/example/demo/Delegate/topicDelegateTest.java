package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.web.client.RestTemplate;

import com.example.demo.Delagate.GameDelegateImpt;
import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Model.TsscConsulta2;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.GameServiceImpt;


@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class topicDelegateTest {

    
	final String SERVER="http://localhost:8080/";
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@InjectMocks
	private TopicDelegateImpt topicServiceImp;
	
	
	private GameServiceImpt gameService;
	

	@Autowired
	public topicDelegateTest(TopicDelegateImpt topicServiceImp,GameServiceImpt game ) {
		this.topicServiceImp = topicServiceImp;
		this.gameService = game;
	}

	@Test
	void testAnadirTopic() {

        TsscTopic topic= new TsscTopic();
        topic.setDefaultGroups(2);
        topic.setDefaultSprints(2);
        topic.setDescription("Primer Tema");
        topic.setName("Miguel");
        when(restTemplate.postForObject("http://localhost:8080/api/topics", topic, TsscTopic.class)).thenReturn(topic);
        when(restTemplate.getForObject(SERVER+"api/topics/"+topic.getId(), TsscTopic.class )).thenReturn(topic);
		assertNotNull(topicServiceImp.guardar(topic));	

	}
	
	@Test
	void encontrarTopicPorElDateGame() {

        TsscTopic topic= new TsscTopic();
        topic.setDefaultGroups(2);
        topic.setDefaultSprints(2);
        topic.setDescription("Primer Tema");
        topic.setName("Miguel");
        when(restTemplate.postForObject("http://localhost:8080/api/topics", topic, TsscTopic.class)).thenReturn(topic);
        when(restTemplate.getForObject(SERVER+"api/topics/"+topic.getId(), TsscTopic.class )).thenReturn(topic);
		assertNotNull(topicServiceImp.guardar(topic));
		
		
		
		
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(topic);
        
        
		gameService.AnadirGameConTema(gameOne, topic.getId());
		
		
		TsscGame gameTwo = new TsscGame();
		gameTwo.setNGroups(1);
		gameTwo.setNSprints(1);
		
        TsscTopic nuevoTwo= new TsscTopic();
		
        nuevoTwo.setDefaultGroups(2);
        nuevoTwo.setDefaultSprints(2);
        nuevoTwo.setDescription("Segundo Tema");
        nuevoTwo.setName("Nelson");
		
        when(restTemplate.postForObject("http://localhost:8080/api/topics", nuevoTwo, TsscTopic.class)).thenReturn(nuevoTwo);
        when(restTemplate.getForObject(SERVER+"api/topics/"+nuevoTwo.getId(), TsscTopic.class )).thenReturn(nuevoTwo);
		assertNotNull(topicServiceImp.guardar(nuevoTwo));
	
		gameTwo.setName("NelsonGame");
		gameTwo.setAdminPassword("123456");
		gameTwo.setScheduledDate(LocalDate.now());
		gameTwo.setStartTime(LocalTime.NOON);
		gameTwo.setUserPassword("456");
		gameTwo.setGuestPassword("123456");
		gameTwo.setTsscTopic(nuevoTwo);
        
		gameService.AnadirGameConTema(gameTwo, nuevoTwo.getId());
        
		TsscConsulta2[] lista= new TsscConsulta2[2];
		//TsscConsulta2 primero=new TsscConsulta2()
		when(restTemplate.getForObject(SERVER+"api/topic/fecha/"+LocalDate.now(),TsscConsulta2[].class )).thenReturn(lista);
		
		assertEquals(topicServiceImp.nuevaConsulta(LocalDate.now().toString()).size(),2);
		
		
		

	}
	
	
	@Test
	public void testactualiarTopic() {
	   
		    TsscTopic topic= new TsscTopic();
	        topic.setDefaultGroups(2);
	        topic.setDefaultSprints(2);
	        topic.setDescription("Primer Tema");
	        topic.setName("Miguel");
	        when(restTemplate.postForObject("http://localhost:8080/api/topics", topic, TsscTopic.class)).thenReturn(topic);
	        assertNotNull(topicServiceImp.guardar(topic));
	        topic.setName("nelson");
	        when(restTemplate.patchForObject(SERVER+"api/topics", topic, TsscTopic.class)).thenReturn(topic);
	        topicServiceImp.actualizar(topic);
	        when(restTemplate.getForObject(SERVER+"api/topics/"+topic.getId(), TsscTopic.class )).thenReturn(topic);
	        assertEquals(topicServiceImp.findById(topic.getId()).getName(),"nelson");
	        
	
		
	}
//	
	@Test
	public void testEliminarTopic() {
		   TsscTopic topic= new TsscTopic();
	        topic.setDefaultGroups(2);
	        topic.setDefaultSprints(2);
	        topic.setDescription("Primer Tema");
	        topic.setName("Miguel");
	        when(restTemplate.postForObject("http://localhost:8080/api/topics", topic, TsscTopic.class)).thenReturn(topic);
	        assertNotNull(topicServiceImp.guardar(topic));
	        restTemplate.delete(SERVER+"api/topics/"+topic.getId());
	        when(restTemplate.getForObject(SERVER+"api/topics/"+topic.getId(), TsscTopic.class )).thenReturn(null);
	        assertNull(topicServiceImp.findById(topic.getId()));
	        
	        
		
	}
//	
	@Test
	public void testObtenerTopic() {
	   
		   TsscTopic topic= new TsscTopic();
	        topic.setDefaultGroups(2);
	        topic.setDefaultSprints(2);
	        topic.setDescription("Primer Tema");
	        topic.setName("Miguel");
	        when(restTemplate.postForObject("http://localhost:8080/api/topics", topic, TsscTopic.class)).thenReturn(topic);
	        assertNotNull(topicServiceImp.guardar(topic));
	        when(restTemplate.getForObject(SERVER+"api/topics/"+topic.getId(), TsscTopic.class )).thenReturn(topic);
	        assertNotNull(topicServiceImp.findById(topic.getId()));
	        
	
		
	}
	
	
	
	
	
	
	
	

}
