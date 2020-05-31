package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;




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


import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Model.TsscTopic;


@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class topicDelegateTest {

    
	final String SERVER="http://localhost:8080/";
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@InjectMocks
	private TopicDelegateImpt topicServiceImp;
	

	@Autowired
	public topicDelegateTest(TopicDelegateImpt topicServiceImp) {
		this.topicServiceImp = topicServiceImp;
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
