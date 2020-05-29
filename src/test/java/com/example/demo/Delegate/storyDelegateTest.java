package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Delagate.storyDelegate;
import com.example.demo.Delagate.storyDelegateImpt;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Service.GameService;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.StoryServiceImpt;
import com.example.demo.Service.TopicServiceImpt;

@SpringBootTest
class storyDelegateTest {

	
    @Autowired
	@InjectMocks
	private StoryServiceImpt storyServiceImp;

    
	@Autowired
	private GameServiceImpt gameImp;

	@Mock
	private storyDelegate delegate;
	
	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	 @Autowired
	public storyDelegateTest(StoryServiceImpt storyServiceImp, GameServiceImpt gameImp) {
		super();
		this.storyServiceImp = storyServiceImp;
		this.gameImp = gameImp;
	}




	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void guardarStory() {
		
		TsscStory story = new TsscStory();
		story.setBusinessValue(BigDecimal.valueOf(1));
		story.setInitialSprint(BigDecimal.valueOf(1));
		story.setPriority(BigDecimal.valueOf(1));		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
	
		when(delegate.guardar(story)).thenReturn(story);
         gameImp.AnadirGameSinTema(gameOne);
     
        when(delegate.existsById(story.getId())).thenReturn(true);		
		assertNotNull(storyServiceImp.AnadirStory(story, gameOne.getId()));	
		
	}
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualziarStory() {
		
		TsscStory story = new TsscStory();
		story.setBusinessValue(BigDecimal.valueOf(1));
		story.setInitialSprint(BigDecimal.valueOf(1));
		story.setPriority(BigDecimal.valueOf(1));		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
	
		when(delegate.guardar(story)).thenReturn(story);
        gameImp.AnadirGameSinTema(gameOne);
        when(delegate.existsById(story.getId())).thenReturn(true);		
		assertNotNull(storyServiceImp.AnadirStory(story, gameOne.getId()));
        story.setNumber(BigDecimal.valueOf(25));
        when(delegate.actualizar(story)).thenReturn(story);
        assertEquals(storyServiceImp.findStoryById(story.getId()).getNumber(), BigDecimal.valueOf(25));
        	
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void eliminarStory() {
		
		TsscStory story = new TsscStory();
		story.setBusinessValue(BigDecimal.valueOf(1));
		story.setInitialSprint(BigDecimal.valueOf(1));
		story.setPriority(BigDecimal.valueOf(1));		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
	
		when(delegate.guardar(story)).thenReturn(story);
         gameImp.AnadirGameSinTema(gameOne);
        when(delegate.existsById(story.getId())).thenReturn(true);	        
		assertNotNull(storyServiceImp.AnadirStory(story, gameOne.getId()));
		delegate.eliminar(story);
		storyServiceImp.eliminarStory(story);
		when(delegate.existsById(story.getId())).thenReturn(false);		
		assertFalse(storyServiceImp.existbyId(story.getId()));
		
	}
	
	

}
