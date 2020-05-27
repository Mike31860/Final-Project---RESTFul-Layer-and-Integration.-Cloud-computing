package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscGameAdmin;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.GameService;
import com.example.demo.Service.StoryService;
import com.example.demo.Service.TopicService;



@SpringBootApplication
public class MiguelRomero {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	
	public static void main(String[] args) {
		//SpringApplication.run(MiguelRomero.class, args);
		
		ConfigurableApplicationContext principal = SpringApplication.run(MiguelRomero.class, args);
		AdminService usuario = principal.getBean(AdminService.class);
		
		TsscAdmin nuevo= new TsscAdmin();
		nuevo.setPassword("{noop}123456");
		nuevo.setUsername("admin");
		nuevo.setSuperAdmin("admin");
		
		usuario.agregar(nuevo);
		
		TsscAdmin superAdmin= new TsscAdmin();
		superAdmin.setPassword("{noop}123456");
		superAdmin.setUsername("superAdmin");
		superAdmin.setSuperAdmin("superadmin");
		
		usuario.agregar(superAdmin);
		
		TopicService topicService = principal.getBean(TopicService.class);
		GameService gameService = principal.getBean(GameService.class);
		StoryService storyserv= principal.getBean(StoryService.class);

		
		TsscTopic temaOne = new TsscTopic();
		temaOne.setName("Guerras 24");
		temaOne.setDescription("Guerra mundial");
		temaOne.setDefaultGroups(12);
		temaOne.setDefaultSprints(20);
		temaOne.setGroupPrefix("RV");
	//	temaOne.setId((long) 5);
		
		
		TsscTopic temaTwo = new TsscTopic();
		temaTwo.setName("Pandemia Covid 19");
		temaTwo.setDescription("Historia ddel mundo");
		temaTwo.setDefaultGroups(20);
		temaTwo.setDefaultSprints(20);
		temaTwo.setGroupPrefix("RR");
	//	temaTwo.setId((long) 4);
		
		TsscTopic temaThree = new TsscTopic();
		temaThree.setName("Final 48");
		temaThree.setDescription("Historia");
		temaThree.setDefaultGroups(30);
		temaThree.setDefaultSprints(30);
		temaThree.setGroupPrefix("RC");
	//	temaThree.setId((long) 3);
		
		
		topicService.AnadirTopic(temaOne);
		topicService.AnadirTopic(temaTwo);
	
       TsscGame gameOne = new TsscGame();
		
		ArrayList<TsscGame> lista= new ArrayList<TsscGame>();

		gameOne.setNGroups(1);
		gameOne.setNSprints(1);

		TsscTopic tema = new TsscTopic();
		tema.setDefaultGroups(1);
		tema.setDefaultSprints(1);
		tema.setTsscGames(lista);

		//topicService.AnadirTopic(tema);
	    gameService.AnadirGameSinTema(gameOne);
		//gameService.AnadirGameConTema(gameOne, tema.getId()); 
	    List<TsscStory> st = new ArrayList<TsscStory>();
	    gameOne.setTsscStories(st);
	    TsscStory his = new TsscStory();
	    his.setBusinessValue(BigDecimal.valueOf(2));
	    his.setInitialSprint(BigDecimal.valueOf(1));
	    his.setPriority(BigDecimal.valueOf(1));
	    storyserv.AnadirStory(his, gameOne.getId());
	 
	    	
     
		
		ArrayList<TsscGameAdmin> lista2= new ArrayList<TsscGameAdmin>();
		TsscGame gameTwo = new TsscGame();
		gameTwo.setName("Miguel");
		gameTwo.setAdminPassword("123456");
		gameTwo.setScheduledDate(LocalDate.now());
		gameTwo.setStartTime(LocalTime.NOON);
		gameTwo.setUserPassword("456");
		gameTwo.setGuestPassword("123456");
		gameTwo.setTsscGameAdmins(lista2);
		gameService.AnadirGameSinTema(gameTwo);

	
		
	}

}
