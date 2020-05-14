package com.example.demo.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.StoryDao;
import com.example.demo.Repository.StoryRepository;
import com.example.demo.Repository.TopicRepository;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.StoryServiceImpt;
import com.example.demo.Service.TopicServiceImpt;

@SpringBootTest
class TsscStoryTestMockU {

	@Autowired
	@InjectMocks
	private StoryServiceImpt StoryServiceImp;

	@Autowired
	private GameServiceImpt gameImp;

	@Mock
	private StoryDao Storyrepo;
	
	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void guardarHistoriaValorNegocio_Menor_a_1() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(0));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		Long id = nueva.getId();
		
		List<TsscStory> st = new ArrayList<TsscStory>();
	       
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
//		when(gameImp.existbyId(gameOne.getId())).thenReturn(true);
//		when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(false);
		
		
		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		assertFalse(StoryServiceImp.existbyId(id));


	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void guardarHistoriaSprintInicialMenor_a_1() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(0));
		nueva.setPriority(BigDecimal.valueOf(1));
		Long id = nueva.getId();
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
//		when(gameImp.existbyId(gameOne.getId())).thenReturn(true);
//		when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(false);
		
		
		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		assertFalse(StoryServiceImp.existbyId(id));

	}
//
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void guardarHistoriaPrioridadMenor_a_1() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(0));
		Long id = nueva.getId();
		
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		
//		when(gameImp.existbyId(gameOne.getId())).thenReturn(true);
//		when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(false);
		
		
		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		assertFalse(StoryServiceImp.existbyId(id));

	}
//
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void guardarHistoriaAsociadaJuego() {
		
		TsscGame game = new TsscGame();
        game.setNGroups(3);
        game.setNSprints(3);
        List<TsscStory> st = new ArrayList<TsscStory>();
        game.setTsscStories(st);
        gameImp.AnadirGameSinTema(game);

        Optional<TsscGame> gameN = Optional.of(game);

        TsscStory story = new TsscStory();
        story.setBusinessValue(BigDecimal.valueOf(2));
        story.setInitialSprint(BigDecimal.valueOf(2));
        story.setPriority(BigDecimal.valueOf(2));



//        when(gameService.findById(game.getId())).thenReturn(true);
//        when(gameService.findByIdR(game.getId())).thenReturn(gameN);
        when(Storyrepo.existsById(story.getId())).thenReturn(true);
//        when(gameService.addStory(game, story)).thenReturn(story);

        StoryServiceImp.AnadirStory(story, game.getId());

        assertNotNull(StoryServiceImp.findStoryById(story.getId()));

//		TsscStory nueva = new TsscStory();
//		nueva.setBusinessValue(BigDecimal.valueOf(1));
//		nueva.setInitialSprint(BigDecimal.valueOf(1));
//		nueva.setPriority(BigDecimal.valueOf(1));
//		Long id = nueva.getId();
//				
//		TsscGame gameOne = new TsscGame();
//		gameOne.setNGroups(1);
//		gameOne.setNSprints(1);
//		gameOne.setName("Miguel");
//		gameOne.setAdminPassword("123456");
//		gameOne.setScheduledDate(LocalDate.now());
//		gameOne.setStartTime(LocalTime.NOON);
//		gameOne.setUserPassword("456");
//		gameOne.setGuestPassword("123456");
//		gameOne.setTsscTopic(null);
//		
//	
////		
////		when(gameImp.existbyId(gameOne.getId())).thenReturn(true);
////		when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
////		when(Storyrepo.existsById(id)).thenReturn(true);
////		when(gameImp.agregarStory(gameOne, nueva)).thenReturn(nueva);
//		
//		//StoryServiceImp.getGame().AnadirGameSinTema(gameOne);
//		
//		ArrayList<TsscStory> lista= new ArrayList<TsscStory>();
//		gameOne.setTsscStories(lista);
//		gameImp.AnadirGameSinTema(gameOne);
//	
//
//		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
//		gameImp.agregarStory(gameOne, nueva);
//		
//		//StoryServiceImp.AnadirStory(nueva, gameOne.getId());
//		assertTrue(StoryServiceImp.existbyId(id));

	}
//	
//
//	
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void guardarHistoriaNoAsociadaJuego() {

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
		
		gameImp.AnadirGameSinTema(gameOne);
		
//		when(gameImp.existbyId(gameOne.getId())).thenReturn(false);
//		when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(false);
		
		
		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		assertFalse(StoryServiceImp.existbyId(id));

	}
//	
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarHistoriaAltDescriptionNull() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		
		nueva.setAltDescripton("AltDescript");
		nueva.setDescription("description");
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		Long id = nueva.getId();
		
		Optional<TsscStory> optional= Optional.of(nueva);
		
	
		//when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(true);
		when(Storyrepo.encontrarPorId(nueva.getId())).thenReturn(nueva);

		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		StoryServiceImp.ActualizarStory(nueva, null, "SegundaPr");
		

		assertNotEquals(StoryServiceImp.findStoryById(nueva.getId()).getAltDescripton(), null);
			

	}
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarHistoriaAltDescription() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		
		nueva.setAltDescripton("AltDescript");
		nueva.setDescription("description");
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		
		Long id = nueva.getId();
		
		Optional<TsscStory> optional= Optional.of(nueva);
		
	
		//when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(true);
		when(Storyrepo.encontrarPorId(nueva.getId())).thenReturn(nueva);

		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		StoryServiceImp.ActualizarStory(nueva, "NuevaAltDes", "SegundaPri");
		

		assertEquals(StoryServiceImp.findStoryById(nueva.getId()).getAltDescripton(), "NuevaAltDes");
		assertEquals(StoryServiceImp.findStoryById(nueva.getId()).getDescription(),"SegundaPri");
			

	}
	
	
	
	
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarHistoriaAltDescriptionVacio() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		
		nueva.setAltDescripton("AltDescript");
		nueva.setDescription("description");
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		
		Long id = nueva.getId();
		
		Optional<TsscStory> optional= Optional.of(nueva);
		
	
		//when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(true);
		when(Storyrepo.encontrarPorId(nueva.getId())).thenReturn(nueva);

		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		StoryServiceImp.ActualizarStory(nueva, "", "NuevaDescription");
		

		assertNotEquals(StoryServiceImp.findStoryById(nueva.getId()).getAltDescripton(), "");
		assertEquals(StoryServiceImp.findStoryById(nueva.getId()).getDescription(),"description");
			

	
			

	}
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarHistoriaDescriptionVacia() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		
		nueva.setAltDescripton("AltDescript");
		nueva.setDescription("description");
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		
		Long id = nueva.getId();
		
		Optional<TsscStory> optional= Optional.of(nueva);
		
	
		//when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(true);
		when(Storyrepo.encontrarPorId(nueva.getId())).thenReturn(nueva);

		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		StoryServiceImp.ActualizarStory(nueva, "nueva AltDescription", "");
		

		assertNotEquals(StoryServiceImp.findStoryById(nueva.getId()).getAltDescripton(), "nueva AltDescription");
		assertNotEquals(StoryServiceImp.findStoryById(nueva.getId()).getDescription(),"");
			
			

	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarHistoriaDescriptionNull() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		
		nueva.setAltDescripton("AltDescript");
		nueva.setDescription("description");
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		
		Long id = nueva.getId();
		
		Optional<TsscStory> optional= Optional.of(nueva);
		
	
		//when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(true);
		when(Storyrepo.encontrarPorId(nueva.getId())).thenReturn(nueva);

		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		StoryServiceImp.ActualizarStory(nueva, "nueva AltDescription", null);
		

		assertNotEquals(StoryServiceImp.findStoryById(nueva.getId()).getAltDescripton(), "nueva AltDescription");
		assertNotEquals(StoryServiceImp.findStoryById(nueva.getId()).getDescription(),null);
			
			

	}
//	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void actualizarHistoriaDescriptionyAltDescription() {

		TsscStory nueva = new TsscStory();
		nueva.setBusinessValue(BigDecimal.valueOf(1));
		nueva.setInitialSprint(BigDecimal.valueOf(1));
		nueva.setPriority(BigDecimal.valueOf(1));
		
		nueva.setAltDescripton("AltDescript");
		nueva.setDescription("description");
		
		List<TsscStory> st = new ArrayList<TsscStory>();
		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setTsscStories(st);
		
		gameImp.AnadirGameSinTema(gameOne);
		
		Long id = nueva.getId();
		
		Optional<TsscStory> optional= Optional.of(nueva);
		
	
		//when(gameImp.findGameById(gameOne.getId())).thenReturn(gameOne);
		when(Storyrepo.existsById(id)).thenReturn(true);
		when(Storyrepo.encontrarPorId(nueva.getId())).thenReturn(nueva);

		StoryServiceImp.AnadirStory(nueva, gameOne.getId());
		StoryServiceImp.ActualizarStory(nueva, "nueva AltDescription", "nuevaDescription");
		

		assertEquals(StoryServiceImp.findStoryById(nueva.getId()).getAltDescripton(), "nueva AltDescription");
		assertEquals(StoryServiceImp.findStoryById(nueva.getId()).getDescription(),"nuevaDescription");
			

	}
//	
	
	

}
