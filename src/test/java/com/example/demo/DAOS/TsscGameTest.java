package com.example.demo.DAOS;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.TopicServiceImpt;

@SpringBootTest
class TsscGameTest {

	
	@Autowired
	private GameDao gameServiceImp;
	@Autowired
	private TopicDao topicServiceImpt;
	@Autowired
	private StoryDao storyServiceImpt;
	@Autowired
	private TimeControllerDaoImpt TimeServiceImp;

	
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testGuardar() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
        TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topicServiceImpt.guardar(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
		gameServiceImp.guardar(gameOne);
			

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testEliminar() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(null);
		gameServiceImp.guardar(gameOne);
		assertNotNull(gameServiceImp.encontrarPorId(gameOne.getId()));
		gameServiceImp.eliminar(gameOne);
		assertNull(gameServiceImp.encontrarPorId(gameOne.getId()));
	

	}

	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testEditar() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(null);
		gameServiceImp.guardar(gameOne);
		assertNotNull(gameServiceImp.encontrarPorId(gameOne.getId()));
		gameOne.setName("Nelson");
		gameOne.setAdminPassword("31860892");
		gameServiceImp.actualizar(gameOne);
		assertEquals(gameOne.getName(), gameServiceImp.encontrarPorId(gameOne.getId()).getName());
		assertEquals(gameOne.getAdminPassword(), gameServiceImp.encontrarPorId(gameOne.getId()).getAdminPassword());
	

	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorNameTopicTest() {
		
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
        TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topicServiceImpt.guardar(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
		
		gameServiceImp.guardar(gameOne);
		
		assertNotNull(gameServiceImp.encontrarPorNameTopic(nuevo.getName()));
		assertTrue(gameServiceImp.encontrarPorNameTopic(nuevo.getName()).contains(gameOne));
			
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorDescriptionTopicTest() {
		
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
        TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topicServiceImpt.guardar(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
		
		gameServiceImp.guardar(gameOne);	
		assertTrue(gameServiceImp.encontrarPorDescriptionTopic(nuevo.getDescription()).contains(gameOne));
	
		
	}
//
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorIdTopicTest() {
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
        TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		topicServiceImpt.guardar(nuevo);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameOne.setTsscTopic(nuevo);
		
		gameServiceImp.guardar(gameOne);
		assertTrue(gameServiceImp.encontrarPorIdTopic(nuevo.getId()).contains(gameOne));
		
	}
//
//	//1c) 
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorDatesTest() {
		
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.of(2020, 04, 29));
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		
		TsscGame gameTwo = new TsscGame();
		gameTwo.setNGroups(1);
		gameTwo.setNSprints(1);
	
		gameTwo.setName("Angel");
		gameTwo.setAdminPassword("123456");
		gameTwo.setScheduledDate(LocalDate.of(2020, 05, 3));
		gameTwo.setStartTime(LocalTime.NOON);
		gameTwo.setUserPassword("45685");
		gameTwo.setGuestPassword("1236");
		
		
		gameServiceImp.guardar(gameOne);
		gameServiceImp.guardar(gameTwo);
		assertTrue(gameServiceImp.encontrarPorDates(gameOne.getScheduledDate(), gameTwo.getScheduledDate()).contains(gameOne));
		assertTrue(gameServiceImp.encontrarPorDates(gameOne.getScheduledDate(), gameTwo.getScheduledDate()).contains(gameTwo));
		

		
	}
//
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorDateHoursTest() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(5);
		gameOne.setNSprints(5);
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setGuestPassword("123456");
		gameOne.setScheduledDate(LocalDate.of(2020, 04, 29));
		gameOne.setScheduledTime(LocalTime.of(10, 20));
		gameOne.setUserPassword("12348951452");
		gameServiceImp.guardar(gameOne);

		TsscGame gameTwo = new TsscGame();
		gameTwo.setNGroups(7);
		gameTwo.setNSprints(8);
		gameTwo.setName("Nelson");
		gameTwo.setAdminPassword("123456");
		gameTwo.setGuestPassword("123");
		gameTwo.setScheduledDate(LocalDate.of(2020, 04, 29));
		gameTwo.setScheduledTime(LocalTime.of(13, 2));
		gameTwo.setUserPassword("1234545");
		gameServiceImp.guardar(gameTwo);


		assertTrue(gameServiceImp.encontrarPorDateHours(gameOne.getScheduledDate(), gameOne.getScheduledTime(), gameTwo.getScheduledTime()).contains(gameOne));
		//assertTrue(gameServiceImp.findByDateHours(gameOne.getScheduledDate(), gameOne.getStartTime(), gameTwo.getStartTime()).contains(gameTwo));
		
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void  encontrarPorDateStoryTimeTest() {
		
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);	
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.of(2020, 04, 29));
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");
		gameServiceImp.guardar(gameOne);
		
		
		TsscGame gameTwo = new TsscGame();
		gameTwo.setNGroups(1);
		gameTwo.setNSprints(1);	
		gameTwo.setName("Miguellkklkl");
		gameTwo.setAdminPassword("123456888");
		gameTwo.setScheduledDate(LocalDate.of(2020, 04, 29));
		gameTwo.setStartTime(LocalTime.NOON);
		gameTwo.setUserPassword("456");
		gameTwo.setGuestPassword("123456");
		gameServiceImp.guardar(gameTwo);
				
		TsscStory story= new TsscStory();
		story.setAltDescripton("MiguelDescc");
		story.setBusinessValue(BigDecimal.valueOf(12));
		story.setInitialSprint(BigDecimal.valueOf(18));
		story.setPriority(BigDecimal.valueOf(17));
		story.setTsscGame(gameOne);
		
		TsscStory story2= new TsscStory();
		story2.setAltDescripton("MiguelDescc");
		story2.setBusinessValue(BigDecimal.valueOf(12));
		story2.setInitialSprint(BigDecimal.valueOf(18));
		story2.setPriority(BigDecimal.valueOf(17));
		story2.setTsscGame(gameTwo);
		ArrayList<TsscStory> tsscStoriesOne=new ArrayList<TsscStory>();
		ArrayList<TsscStory> tsscStoriesTwo=new ArrayList<TsscStory>();
		
		TsscStory story3= new TsscStory();
		story3.setAltDescripton("MiguelDescc");
		story3.setBusinessValue(BigDecimal.valueOf(12));
		story3.setInitialSprint(BigDecimal.valueOf(18));
		story3.setPriority(BigDecimal.valueOf(17));
		story3.setTsscGame(gameOne);
		
		storyServiceImpt.guardar(story);
		storyServiceImpt.guardar(story2);
		storyServiceImpt.guardar(story3);
		gameOne.setTsscStories(tsscStoriesOne);
		gameOne.addTsscStory(story);
		gameOne.addTsscStory(story3);
		gameTwo.setTsscStories(tsscStoriesTwo);
		gameTwo.addTsscStory(story2);
		gameServiceImp.actualizar(gameOne);
		gameServiceImp.actualizar(gameTwo);
		
		TsscGame gameThree = new TsscGame();
		gameThree.setNGroups(1);
		gameThree.setNSprints(1);	
		gameThree.setName("Miguel");
		gameThree.setAdminPassword("123456");
		gameThree.setScheduledDate(LocalDate.of(2020, 04, 29));
		gameThree.setStartTime(LocalTime.NOON);
		gameThree.setUserPassword("456");
		gameThree.setGuestPassword("123456");
		
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
		ArrayList<TsscTimecontrol> tsscTimecontrols = new ArrayList<TsscTimecontrol>();
		gameThree.setTsscTimecontrol(tsscTimecontrols);
		gameThree.addTsscTimecontrol(nuevo);
		gameServiceImp.guardar(gameThree);
	
		
		assertTrue(gameServiceImp.encontrarPorDateStoryTime(LocalDate.of(2020, 04, 29)).contains(gameOne));
		assertTrue(gameServiceImp.encontrarPorDateStoryTime(LocalDate.of(2020, 04, 29)).contains(gameTwo));
		assertTrue(gameServiceImp.encontrarPorDateStoryTime(LocalDate.of(2020, 04, 29)).contains(gameThree));
		
	
				
	}


}
