package com.example.demo.DAOS;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

@SpringBootTest
class TsscStoryTest {

	@Autowired
	private StoryDaoImpt storyDao;
	@Autowired
	private GameDaoImpt gameDao;
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void GuardarStorytest() {
	
		
		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		Long id = nueva.getId();
		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
				
		storyDao.guardar(nueva);
		gameDao.guardar(gameOne);
		
		assertTrue(storyDao.existsById(nueva.getId()));
		
			
	}
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarStorytest() {
	
		
		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(12));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		Long id = nueva.getId();
		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
				
		storyDao.guardar(nueva);
		gameDao.guardar(gameOne);
		
		nueva.setBusinessValue(BigDecimal.valueOf(15));
		storyDao.actualizar(nueva);	
		assertEquals(storyDao.encontrarPorId(nueva.getId()).getBusinessValue(), nueva.getBusinessValue());
		
			
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void eliminarStorytest() {
	
		
		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(12));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		Long id = nueva.getId();
		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
				
		storyDao.guardar(nueva);
		gameDao.guardar(gameOne);
		storyDao.eliminar(nueva);	
		assertNull(storyDao.encontrarPorId(nueva.getId()));
		
			
	}
	
	
	
	

}
