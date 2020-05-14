package com.example.demo.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.GameDao;
import com.example.demo.Repository.GameRepository;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.TopicServiceImpt;

@SpringBootTest
class TsscGameTestMockU {

	
	@Autowired
	@InjectMocks
	private GameServiceImpt gameImp;
	
	@Autowired
	private TopicServiceImpt topicServiceImp;
	
	@Mock
	private GameDao Gamerepo;
	
	
	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> FINISH <-----");
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGame2GrupoMenorAUno() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(0);
		gameOne.setNSprints(1);
		gameImp.AnadirGameJuego2(gameOne, 2);
		Long id = gameOne.getId();
		when(Gamerepo.existsById(id)).thenReturn(false);
		assertFalse(gameImp.existbyId(id));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGame2SprintsMenorAUno() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(0);
		gameImp.AnadirGameJuego2(gameOne, 2);
		Long id = gameOne.getId();
		when(Gamerepo.existsById(id)).thenReturn(false);
		assertFalse(gameImp.existbyId(id));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameConTemaJuego2() {


		TsscGame game = new TsscGame();
        game.setNGroups(3);
        game.setNSprints(3);

        List<TsscGame> list = new ArrayList<TsscGame>();
        TsscTopic tsstopic = new TsscTopic();
        tsstopic.setDefaultGroups(3);
        tsstopic.setDefaultSprints(2);
        tsstopic.setTsscGames(list);
        List<TsscStory> stories = new ArrayList<TsscStory>();
        List<TsscTimecontrol> times = new ArrayList<TsscTimecontrol>();
        tsstopic.setTsscStories(stories);
        tsstopic.setTsscCronograma(times);

      //  Optional<TsscTopic> topic = Optional.of(tsstopic);
        topicServiceImp.AnadirTopic(tsstopic);
//        when(topicService.findById(tsstopic.getId())).thenReturn(true);
//        when(topicService.findByIdR(tsstopic.getId())).thenReturn(topic);
        when(Gamerepo.existsById(game.getId())).thenReturn(true);

        gameImp.AnadirGameJuego2(game,tsstopic.getId());

        assertNotNull(gameImp.findGameById(game.getId()));
	

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameGrupoMenorAUno() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(0);
		gameOne.setNSprints(1);
		gameImp.AnadirGameConTema(gameOne, 2);
		Long id = gameOne.getId();
		when(Gamerepo.existsById(id)).thenReturn(false);
		assertFalse(gameImp.existbyId(id));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameSprintsMenorAUno() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(0);
		gameImp.AnadirGameConTema(gameOne, 2);
		Long id = gameOne.getId();
		when(Gamerepo.existsById(id)).thenReturn(false);
		assertFalse(gameImp.existbyId(id));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameConTema() {

		TsscGame game = new TsscGame();
        game.setNGroups(3);
        game.setNSprints(3);

        List<TsscGame> list = new ArrayList<TsscGame>();
        TsscTopic tsstopic = new TsscTopic();
        tsstopic.setDefaultGroups(3);
        tsstopic.setDefaultSprints(2);
        tsstopic.setTsscGames(list);
        List<TsscStory> stories = new ArrayList<TsscStory>();
        List<TsscTimecontrol> times = new ArrayList<TsscTimecontrol>();
        tsstopic.setTsscStories(stories);
        tsstopic.setTsscCronograma(times);

      //  Optional<TsscTopic> topic = Optional.of(tsstopic);
        topicServiceImp.AnadirTopic(tsstopic);
//        when(topicService.findById(tsstopic.getId())).thenReturn(true);
//        when(topicService.findByIdR(tsstopic.getId())).thenReturn(topic);
        when(Gamerepo.existsById(game.getId())).thenReturn(true);

        gameImp.AnadirGameConTema(game, tsstopic.getId());

        assertNotNull(gameImp.findGameById(game.getId()));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameConTemaFalla() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(0);
		tema.setDefaultSprints(0);

		topicServiceImp.AnadirTopic(tema);

		Long id = tema.getId();
		gameImp.AnadirGameConTema(gameOne, tema.getId());
//		when(topicServiceImp.existeById(id)).thenReturn(false);
//		when(topicServiceImp.findTopicById(id)).thenReturn(null);
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(false);

		
		assertNull(gameImp.findGameById(gameOne.getId()));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameSinTema() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		
		//Optional<TsscGame> game= Optional.of(gameOne);

		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);

		gameImp.AnadirGameSinTema(gameOne);
		assertNotNull(gameImp.findGameById(gameOne.getId()));

	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameSinTemaGrupoMenor1() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(0);
		gameOne.setNSprints(1);
		
		//Optional<TsscGame> game= Optional.of(gameOne);

		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);

		gameImp.AnadirGameSinTema(gameOne);
		assertNull(gameImp.findGameById(gameOne.getId()));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameSinTemaSprintsMenor1() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(0);
		
		//Optional<TsscGame> game= Optional.of(gameOne);

		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);

		gameImp.AnadirGameSinTema(gameOne);
		assertNull(gameImp.findGameById(gameOne.getId()));

	}

	
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testActualizarGameGrupoMenorA1() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Cambiando Nombre");
		
	//   Optional<TsscGame> game= Optional.of(gameOne);
		
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);
		gameImp.AnadirGameSinTema(gameOne);
		gameImp.ActualizarGame(gameOne, 0, "Historia");
		
		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
	
		assertNotEquals(gameImp.findGameById(gameOne.getId()).getNGroups(), 0);

	}
	


	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testActualizarGameNombreVacio() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Cambiando Nombre");
		
	
        // Optional<TsscGame> game= Optional.of(gameOne);
		
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);
		gameImp.AnadirGameSinTema(gameOne);
		gameImp.ActualizarGame(gameOne, 2, "");
		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
	
		assertNotEquals(gameImp.findGameById(gameOne.getId()).getName(), "");

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testActualizarGameNombreNull() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Cambiando Nombre");
		
	
     //    Optional<TsscGame> game= Optional.of(gameOne);
		
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);
		gameImp.AnadirGameSinTema(gameOne);
		gameImp.ActualizarGame(gameOne, 2, null);
		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
	
		assertNotEquals(gameImp.findGameById(gameOne.getId()).getName(), null);
		assertNotNull(gameImp.findGameById(gameOne.getId()).getName());

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testActualizarGame() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Cambiando Nombre");
		
	
       //  Optional<TsscGame> game= Optional.of(gameOne);
		
		when(Gamerepo.existsById(gameOne.getId())).thenReturn(true);
		gameImp.AnadirGameSinTema(gameOne);
		gameImp.ActualizarGame(gameOne, 2, "Historia");
		when(Gamerepo.encontrarPorId(gameOne.getId())).thenReturn(gameOne);
	
		assertNotEquals(gameImp.findGameById(gameOne.getId()).getName(), "");
		assertNotEquals(gameImp.findGameById(gameOne.getId()).getName(), null);
		assertNotEquals(gameImp.findGameById(gameOne.getId()).getNGroups(), 0);
		assertEquals(gameImp.findGameById(gameOne.getId()).getNGroups(), 2);
		assertEquals(gameImp.findGameById(gameOne.getId()).getName(), "Historia");

	}

}
