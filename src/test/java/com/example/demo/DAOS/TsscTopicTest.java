package com.example.demo.DAOS;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscTopic;

@SpringBootTest
class TsscTopicTest {

	
	@Autowired
	private TopicDaoImpt TopicServiceImp;
	@Autowired
	private GameDaoImpt gameServiceImp;
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void GuardarTopictest() {
		
		TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		TopicServiceImp.guardar(nuevo);
		assertNotNull(TopicServiceImp.findById(nuevo.getId()));
		
		
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void EliminarTopictest() {
		
		TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		TopicServiceImp.guardar(nuevo);
		assertNotNull(TopicServiceImp.findById(nuevo.getId()));
		TopicServiceImp.eliminar(nuevo);
		assertNull(TopicServiceImp.findById(nuevo.getId()));
		
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void EditarTopictest() {
		
		TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		TopicServiceImp.guardar(nuevo);
		nuevo.setDefaultGroups(3);
		nuevo.setDefaultSprints(3);
		nuevo.setDescription("Otro Tema");
		nuevo.setName("Nelson");
		
		TopicServiceImp.actualizar(nuevo);
		
	
		assertEquals(nuevo.getName(),TopicServiceImp.findById(nuevo.getId()).getName());
		assertEquals(nuevo.getDescription(),TopicServiceImp.findById(nuevo.getId()).getDescription());
		assertEquals(nuevo.getDefaultGroups(),TopicServiceImp.findById(nuevo.getId()).getDefaultGroups());
		assertEquals(nuevo.getDefaultSprints(),TopicServiceImp.findById(nuevo.getId()).getDefaultSprints());
		
		
	}
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorNombreTest() {
		
		TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		TopicServiceImp.guardar(nuevo);
		assertTrue(TopicServiceImp.encontrarPorNombre(nuevo.getName()).size()>0);
	
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarPorDescriptionTest() {
		
		TsscTopic nuevo= new TsscTopic();
		
		nuevo.setDefaultGroups(2);
		nuevo.setDefaultSprints(2);
		nuevo.setDescription("Primer Tema");
		nuevo.setName("Miguel");
		TopicServiceImp.guardar(nuevo);
		assertTrue(TopicServiceImp.encontrarPorDescription(nuevo.getDescription()).size()>0);
	
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void encontrarTopicPorElDateGameTest() {
		
		List<TsscGame> listaJuegos = new ArrayList<TsscGame>();

		TsscTopic temaNumero1 = new TsscTopic();
		temaNumero1.setName("TEMA 1");
		temaNumero1.setDescription("MIGUEL DESCRIPCION");
		temaNumero1.setGroupPrefix("MIG");
		temaNumero1.setDefaultGroups(4);
		temaNumero1.setDefaultSprints(4);
		
		temaNumero1.setTsscGames(listaJuegos);

		TsscGame juegoNumero1 = new TsscGame();
		juegoNumero1.setNGroups(85);
		juegoNumero1.setNSprints(13);
		juegoNumero1.setName("Juego 1 Miguel");
		juegoNumero1.setAdminPassword("123486954");
		juegoNumero1.setGuestPassword("1234784515");
		juegoNumero1.setScheduledDate(LocalDate.of(2020, 4, 4));
		juegoNumero1.setScheduledTime(LocalTime.of(13, 20));
		juegoNumero1.setUserPassword("1895462456");
		
		juegoNumero1.setTsscTopic(temaNumero1);


		TsscGame juegoNumero2 = new TsscGame();
		juegoNumero2.setNGroups(56);
		juegoNumero2.setNSprints(74);
		juegoNumero2.setName("Juego Numero 2");
		juegoNumero2.setAdminPassword("1234784611");
		juegoNumero2.setGuestPassword("8adad4516648");
		juegoNumero2.setScheduledDate(LocalDate.of(2020, 4, 4));
		juegoNumero2.setScheduledTime(LocalTime.of(14, 1));
		juegoNumero2.setUserPassword("65448789d84asd");
		
		juegoNumero2.setTsscTopic(temaNumero1);


		TsscGame juegoNumero3 = new TsscGame();
		juegoNumero3.setNGroups(8);
		juegoNumero3.setNSprints(6);
		juegoNumero3.setName("Juego Numero 3");
		juegoNumero3.setAdminPassword("5465651651");
		juegoNumero3.setGuestPassword("546546445");
		juegoNumero3.setScheduledDate(LocalDate.of(2020, 4, 5));
		juegoNumero3.setScheduledTime(LocalTime.of(16, 34));
		juegoNumero3.setUserPassword("45564656545");
		
		juegoNumero3.setTsscTopic(temaNumero1);


		temaNumero1.getTsscGames().add(juegoNumero1);
		temaNumero1.getTsscGames().add(juegoNumero2);
		temaNumero1.getTsscGames().add(juegoNumero3);

		gameServiceImp.guardar(juegoNumero1);
		gameServiceImp.guardar(juegoNumero2);
		gameServiceImp.guardar(juegoNumero3);

		TopicServiceImp.guardar(temaNumero1);

		ArrayList<TsscGame> listaJuegos2 = new ArrayList<TsscGame>();

		TsscTopic temaNumero2 = new TsscTopic();
		temaNumero2.setName("TEMA 2");
		temaNumero2.setDescription("MIGUEL DESCRIPCION");
		temaNumero2.setGroupPrefix("MIG");
		temaNumero2.setDefaultGroups(45);
		temaNumero2.setDefaultSprints(74);
		
		temaNumero2.setTsscGames(listaJuegos2);

		TsscGame juegoNumero4 = new TsscGame();
		juegoNumero4.setNGroups(3);
		juegoNumero4.setNSprints(3);
		juegoNumero4.setName("Juego Numero 4");
		juegoNumero4.setAdminPassword("41516545sd");
		juegoNumero4.setGuestPassword("6546545sdas");
		juegoNumero4.setScheduledDate(LocalDate.of(2020, 4, 4));
		juegoNumero4.setScheduledTime(LocalTime.of(16, 34));
		juegoNumero4.setUserPassword("654564dasd");
		juegoNumero4.setTsscTopic(temaNumero2);
		
		gameServiceImp.guardar(juegoNumero4);

		TsscGame juegoNumero5 = new TsscGame();
		juegoNumero5.setNGroups(14);
		juegoNumero5.setNSprints(874);
		juegoNumero5.setName("Juego Numero 5");
		juegoNumero5.setAdminPassword("65465sd54sa");
		juegoNumero5.setGuestPassword("5445s54dsa");
		juegoNumero5.setScheduledDate(LocalDate.of(2020, 4, 4));
		juegoNumero5.setScheduledTime(LocalTime.of(16, 34));
		juegoNumero5.setUserPassword("5445sdasd");
		juegoNumero5.setTsscTopic(temaNumero2);
		
		gameServiceImp.guardar(juegoNumero5);

		temaNumero2.getTsscGames().add(juegoNumero5);
		temaNumero2.getTsscGames().add(juegoNumero4);
		
		juegoNumero3.setTsscTopic(temaNumero2);
		temaNumero2.getTsscGames().add(juegoNumero3);

		TopicServiceImp.guardar(temaNumero2);

		TsscTopic temaNumero3 = new TsscTopic();
		temaNumero3.setName("Tema Numero 3");
		temaNumero3.setDescription("Descripcion tema");
		temaNumero3.setGroupPrefix("Mig");
		temaNumero3.setDefaultGroups(8);
		temaNumero3.setDefaultSprints(9);

		TopicServiceImp.guardar(temaNumero3);

		LocalDate date = LocalDate.of(2020, 4, 4);

		System.out.println("**********************");
		List<Object[]> resultado = TopicServiceImp.encontrarTopicPorElDateGame(date);



		System.out.println("TOPIC");
		System.out.println(((TsscTopic) (resultado.get(0)[0])).getName());
		System.out.println(resultado.get(0)[1]);
		System.out.println("------------------------------------------------");
		System.out.println(((TsscTopic) (resultado.get(1)[0])).getName());
		System.out.println(resultado.get(1)[1]);




		assertTrue(TopicServiceImp.encontrarTopicPorElDateGame(date).size() == 2);
		assertEquals(((TsscTopic) (resultado.get(0)[0])).getName(), temaNumero1.getName());
		assertTrue(((Long)(resultado.get(0)[1])) == 2);
		assertEquals(((TsscTopic) (resultado.get(1)[0])).getName(), temaNumero2.getName());
		assertTrue(((Long)(resultado.get(1)[1])) == 2);
		
		
	}

	
	
	
	
	
	
	
	
	

}
