package com.example.demo.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.GameRepository;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.TopicServiceImpt;

@SpringBootTest
class TsscGameTest {

	@Autowired
	private TopicServiceImpt topicServiceImp;
	
	@Autowired
	private GameServiceImpt gameImp;

	@BeforeAll
	public static void beforeTest() {

	}

	@AfterAll
	public static void afterTest() {
		System.out.println("-----> FINISH <-----");
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameConTemaJuego2() {

		TsscGame gameOne = new TsscGame();
		
		ArrayList<TsscGame> lista= new ArrayList<TsscGame>();
		ArrayList<TsscStory> lista2= new ArrayList<TsscStory>();
		ArrayList<TsscTimecontrol> lista3= new ArrayList<TsscTimecontrol>();
		
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(1);
		tema.setDefaultSprints(1);
		tema.setTsscGames(lista);
		tema.setTsscStories(lista2);
		tema.setTsscCronograma(lista3);

		topicServiceImp.AnadirTopic(tema);
		gameImp.AnadirGameJuego2(gameOne, tema.getId());
		assertTrue(gameImp.existbyId(gameOne.getId()));
		assertNotNull(gameImp.AnadirGameJuego2(gameOne, tema.getId()));
		assertNotNull(gameImp.findGameById(gameOne.getId()).getTsscStories());
		assertNotNull(gameImp.findGameById(gameOne.getId()).getTsscTimecontrols());

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameConTemaJuego2Error() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(0);
		tema.setDefaultSprints(1);

		topicServiceImp.AnadirTopic(tema);

		assertNull(gameImp.AnadirGameJuego2(gameOne, tema.getId()));
		assertFalse(gameImp.existbyId(gameOne.getId()));
		assertNull(gameImp.findGameById(gameOne.getId()));

	}
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGameConTemaJuego2Falla() {
      
		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(1);
		tema.setDefaultSprints(1);

		topicServiceImp.AnadirTopic(tema);
		assertNull(gameImp.AnadirGameJuego2(null, tema.getId()));

	}
	
	

	

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGame1ConTema() {

		TsscGame gameOne = new TsscGame();
		
		ArrayList<TsscGame> lista= new ArrayList<TsscGame>();

		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(1);
		tema.setDefaultSprints(1);
		tema.setTsscGames(lista);

		topicServiceImp.AnadirTopic(tema);
		gameImp.AnadirGameConTema(gameOne, tema.getId());

		assertTrue(gameImp.existbyId(gameOne.getId()));
		assertNotNull(gameImp.findGameById(gameOne.getId()));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGame1ConTemaFalla() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(0);
		tema.setDefaultSprints(1);

		topicServiceImp.AnadirTopic(tema);
		gameImp.AnadirGameConTema(gameOne, tema.getId());

		assertFalse(topicServiceImp.existeById(tema.getId()));
		assertFalse(gameImp.existbyId(gameOne.getId()));
		assertNull(gameImp.findGameById(gameOne.getId()));
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGame1SinTema() {

		TsscGame gameOne = new TsscGame();
		// duda
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		gameImp.AnadirGameSinTema(gameOne);
		assertTrue(gameImp.existbyId(gameOne.getId()));
		assertNotNull(gameImp.findGameById(gameOne.getId()));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testAnadirGame1SinTemaFalla() {
//
//		TsscGame gameOne = new TsscGame();
//		// duda
//		gameOne.setNGroups(1);
//		gameOne.setNSprints(1);
//
//		gameImp.AnadirGameSinTema(gameOne);
//		assertFalse(gameImp.existbyId(gameOne.getId()));
//		assertNull(gameImp.findGameById(gameOne.getId()));
		
		assertNull(gameImp.AnadirGameSinTema(null));

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testActualizarGame() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Cambiando Nombre");
		gameImp.AnadirGameSinTema(gameOne);

		gameImp.ActualizarGame(gameOne, 2, "Historia");

		assertEquals("Historia", gameImp.findGameById(gameOne.getId()).getName());
		assertEquals(2, gameOne.getNGroups());

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testActualizarGameFalla() {

		TsscGame gameOne = new TsscGame();
		gameOne.setNGroups(1);
		gameOne.setNSprints(1);
		gameOne.setName("Cambiando Nombre");

		assertNull(gameImp.ActualizarGame(gameOne, 2, "Historia"));

	}

}
