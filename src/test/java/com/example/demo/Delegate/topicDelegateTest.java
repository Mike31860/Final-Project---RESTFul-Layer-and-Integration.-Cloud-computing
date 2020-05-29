package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.TopicDao;
import com.example.demo.Delagate.TopicDelegate;
import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.TopicServiceImpt;

import lombok.extern.java.Log;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class topicDelegateTest {


	@InjectMocks
	private TopicServiceImpt topicServiceImp;
	
	@Mock
	private TopicDelegate delegate;
	
    @Autowired
	public topicDelegateTest(TopicServiceImpt topicServiceImp, TopicDelegate delegate) {
		super();
		this.topicServiceImp = topicServiceImp;
		this.delegate = delegate;
	}
	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirTopic() {

        TsscTopic topic= new TsscTopic();
        topic.setDefaultGroups(2);
        topic.setDefaultSprints(2);
        topic.setDescription("Primer Tema");
        topic.setName("Miguel");
        when(delegate.guardar(topic)).thenReturn(topic);
		when(delegate.findById(topic.getId())).thenReturn(topic);
		assertNotNull(topicServiceImp.AnadirTopic(topic));
		
		

	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void testactualiarTopic() {
	   
		TsscTopic topic= new TsscTopic();
		topic.setDefaultGroups(2);
		topic.setDefaultSprints(2);
		topic.setDescription("Primer Tema");
		topic.setName("Miguel");		
		//topicDelegate.guardar(carTwo);
		when(delegate.guardar(topic)).thenReturn(topic);					
		when(delegate.findById(topic.getId())).thenReturn(topic);
		assertNotNull(topicServiceImp.AnadirTopic(topic));
		topic.setName("Nelson");
		when(delegate.actualizar(topic)).thenReturn(topic);
		topicServiceImp.actualizar(topic);
		assertEquals(topicServiceImp.findTopicById(topic.getId()).getName(), "Nelson");
	
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void testEliminarTopic() {
	   
		TsscTopic topic= new TsscTopic();
		topic.setDefaultGroups(2);
		topic.setDefaultSprints(2);
		topic.setDescription("Primer Tema");
		topic.setName("Miguel");		
		//topicDelegate.guardar(carTwo);
		when(delegate.guardar(topic)).thenReturn(topic);				
		when(delegate.findById(topic.getId())).thenReturn(topic);
		assertNotNull(topicServiceImp.AnadirTopic(topic));
		delegate.eliminar(topic);
		when(delegate.findById(topic.getId())).thenReturn(null);
		topicServiceImp.eliminarTopic(topic);
		assertNull(topicServiceImp.findTopicById(topic.getId()));
	
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void testObtenerTopic() {
	   
		ArrayList<TsscTopic> topis= new ArrayList<TsscTopic>();
		TsscTopic carTwo= new TsscTopic();
		carTwo.setDefaultGroups(2);
		carTwo.setDefaultSprints(2);
		carTwo.setDescription("Primer Tema");
		carTwo.setName("Miguel");		
		//topicDelegate.guardar(carTwo);
		topis.add(carTwo);
		
		TsscTopic carThree= new TsscTopic();
		carThree.setDefaultGroups(2);
		carThree.setDefaultSprints(2);
		carThree.setDescription("Primer Tema");
		carThree.setName("wdsd");		
		//topicDelegate.guardar(carTwo);
		topis.add(carThree);
		
		when(delegate.findAll()).thenReturn(topis);

		
		assertNotNull(delegate.findAll());
	
		
	}
	
	
	
	
	
	
	
	

}
