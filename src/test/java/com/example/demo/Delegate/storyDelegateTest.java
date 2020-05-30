package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Delagate.storyDelegate;
import com.example.demo.Delagate.storyDelegateImpt;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.GameService;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.StoryServiceImpt;
import com.example.demo.Service.TopicServiceImpt;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class storyDelegateTest {

	final String SERVER="http://localhost:8080/";
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@InjectMocks
	private storyDelegateImpt storyServiceImp;
	
	@Autowired
	private GameServiceImpt gameImp;
	
		
	 @Autowired
	public storyDelegateTest(storyDelegateImpt storyServiceImp) {
		this.storyServiceImp = storyServiceImp;
	
	}

	@Test
	void guardarStory() {
		
		TsscStory story = new TsscStory();
		story.setBusinessValue(BigDecimal.valueOf(1));
		story.setInitialSprint(BigDecimal.valueOf(1));
		story.setPriority(BigDecimal.valueOf(1));	
		story.setDescription("Descrip");
		

		List<TsscStory> st = new ArrayList<TsscStory>();   
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");	
		gameImp.AnadirGameSinTema(gameOne);
		story.setTsscGame(gameOne);
		when(restTemplate.postForObject("http://localhost:8080/api/stories/"+story.getTsscGame().getId(), story, TsscStory.class)).thenReturn(story);
		assertNotNull(storyServiceImp.guardar(story));
	
	}
	
	@Test
	public void testactualiarTopic() {
		
		TsscStory story = new TsscStory();
		story.setBusinessValue(BigDecimal.valueOf(1));
		story.setInitialSprint(BigDecimal.valueOf(1));
		story.setPriority(BigDecimal.valueOf(1));
		story.setDescription("Descrip");
		List<TsscStory> st = new ArrayList<TsscStory>();
		
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		gameOne.setName("Miguel");
		gameOne.setAdminPassword("123456");
		gameOne.setScheduledDate(LocalDate.now());
		gameOne.setStartTime(LocalTime.NOON);
		gameOne.setUserPassword("456");
		gameOne.setGuestPassword("123456");	
		gameImp.AnadirGameSinTema(gameOne);
		story.setTsscGame(gameOne);
		when(restTemplate.postForObject("http://localhost:8080/api/stories/"+story.getTsscGame().getId(), story, TsscStory.class)).thenReturn(story);
		assertNotNull(storyServiceImp.guardar(story));
		story.setDescription("MIGUELDDD");
		when(restTemplate.patchForObject(SERVER+"api/stories", story, TsscStory.class)).thenReturn(story);
		//assertNotNull(storyServiceImp.actualizar(story));
		
	}
	
	
	@Test
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
		gameImp.AnadirGameSinTema(gameOne);
		story.setTsscGame(gameOne);
		when(restTemplate.postForObject("http://localhost:8080/api/stories/"+story.getTsscGame().getId(), story, TsscStory.class)).thenReturn(story);
		assertNotNull(storyServiceImp.guardar(story));
		restTemplate.delete(SERVER+"api/stories/"+story.getId());
		storyServiceImp.eliminar(story);
		assertNull(storyServiceImp.encontrarPorId(story.getId()));
	
	}
	

}
