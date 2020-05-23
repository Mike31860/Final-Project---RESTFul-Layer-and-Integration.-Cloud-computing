package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Delagate.TopicDelegate;
import com.example.demo.Model.TsscTopic;


import lombok.extern.java.Log;

@SpringBootTest
@Log
class topicDelegateTest {

	@Autowired
	@InjectMocks
	private TopicDelegate topicDelegate;

	@Test
	void testObtenerTopics() {
		
        TsscTopic carOne= new TsscTopic();
        carOne.setDefaultGroups(2);
        carOne.setDefaultSprints(2);
        carOne.setDescription("Primer Tema");
        carOne.setName("Miguel");		
		topicDelegate.guardar(carOne);
		
		TsscTopic carTwo= new TsscTopic();
		carTwo.setDefaultGroups(2);
		carTwo.setDefaultSprints(2);
		carTwo.setDescription("Primer Tema");
		carTwo.setName("Miguel");		
		topicDelegate.guardar(carTwo);
		
		TsscTopic carThree= new TsscTopic();
		carThree.setDefaultGroups(2);
		carThree.setDefaultSprints(2);
		carThree.setDescription("Primer Tema");
		carThree.setName("Miguel");		
		topicDelegate.guardar(carThree);
		

		Iterable<TsscTopic> temas = topicDelegate.findAll();
		int numero=0;
		for (TsscTopic tema : temas) {
			numero++;

		}
		assertEquals(numero,3);
		
		

	}
	
	@Test
	public void testAgregarTopic() {
	   
		TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");		
		TsscTopic tema = topicDelegate.guardar(nuevo);
		assertNotNull(topicDelegate.findById(nuevo.getId()));	
		
	}
	
	
	
	
	
	
	
	

}
