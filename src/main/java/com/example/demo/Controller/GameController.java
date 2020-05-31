package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Delagate.GameDelegate;
import com.example.demo.Delagate.TimeControlDelegate;
import com.example.demo.Delagate.TimeControlDelegateImp;
import com.example.demo.Delagate.TopicDelegate;
import com.example.demo.Delagate.storyDelegate;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.GameService;
import com.example.demo.Service.GameServiceImpt;
import com.example.demo.Service.StoryService;
import com.example.demo.Service.TopicService;
import com.example.demo.Service.TopicServiceImpt;
import com.example.demo.Validate.GameValidar;
import com.example.demo.Validate.TopicValidar;

@Controller
public class GameController {

	private GameDelegate servicio;
	private TopicDelegate ServiceTopic;
	private storyDelegate serviceStorie;
	private TimeControlDelegate servicioTime;

	@Autowired
	public GameController(GameDelegate Service, TopicDelegate topic, storyDelegate serviceStorie, TimeControlDelegate time) {
		this.servicio = Service;
		this.ServiceTopic = topic;
		this.serviceStorie=serviceStorie;
		this.servicioTime=time;
	}

	@GetMapping("/gameCap/")
	public String principalGame(Model model) {
		model.addAttribute("games", servicio.findAll());
		return "gameCap/principalGame";
	}

	@GetMapping("/gameCap/add")
	public String agregarGamePrincipal(Model model) {
		model.addAttribute("tsscGame", new TsscGame());
		model.addAttribute("topics", ServiceTopic.findAll());
		return "gameCap/agregarGame";
	}

	@PostMapping("/gameCap/add")
	public String guardarJuegoMiguel(@Validated(GameValidar.class) TsscGame juego, BindingResult bind,
			Model modelPrincipal, @RequestParam(value = "action", required = true) String opcion) {
		if (!opcion.equals("Cancelar Operacion")) {
			if (bind.hasErrors()) {

				modelPrincipal.addAttribute("name", juego.getName());
				modelPrincipal.addAttribute("adminPassword", juego.getAdminPassword());
				modelPrincipal.addAttribute("scheduledDate", juego.getScheduledDate());
				modelPrincipal.addAttribute("scheduledTime", juego.getScheduledTime());
				modelPrincipal.addAttribute("nGroups", juego.getNGroups());
				modelPrincipal.addAttribute("nSprints", juego.getNSprints());
				modelPrincipal.addAttribute("userPassword", juego.getUserPassword());
				modelPrincipal.addAttribute("guestPassword", juego.getGuestPassword());
				modelPrincipal.addAttribute("topics", ServiceTopic.findAll());

				return "gameCap/agregarGame";
			} else if (!bind.hasErrors()) {

				if (juego.getTsscTopic() == null) {
					//servicio.AnadirGameSinTema(juego);
					servicio.guardar(juego);
				} else if (juego.getTsscTopic() != null) {
					servicio.guardar(juego);
				}

				return "redirect:/gameCap/";
			} else {
				return "redirect:/gameCap/";
			}
		} else {

			modelPrincipal.addAttribute("games", servicio.findAll());
			return "gameCap/principalGame";
		}

	}

	@GetMapping("/gameCap/edit/{id}")
	public String mostrarGameAEditarPrincipal(@PathVariable("id") long id, Model modelPrincipal) {
		TsscGame juego = servicio.encontrarPorId(id);
		if (juego == null)
			throw new IllegalArgumentException("Id del juego Invalido:" + id);

		modelPrincipal.addAttribute("tsscGame", juego);
		modelPrincipal.addAttribute("name", juego.getName());
		modelPrincipal.addAttribute("adminPassword", juego.getAdminPassword());
		modelPrincipal.addAttribute("scheduledDate", juego.getScheduledDate());
		modelPrincipal.addAttribute("scheduledTime", juego.getScheduledTime());
		modelPrincipal.addAttribute("nGroups", juego.getNGroups());
		modelPrincipal.addAttribute("nSprints", juego.getNSprints());
		modelPrincipal.addAttribute("userPassword", juego.getUserPassword());
		modelPrincipal.addAttribute("guestPassword", juego.getGuestPassword());
		modelPrincipal.addAttribute("topics", ServiceTopic.findAll());

		return "gameCap/EditarGame";
	}

	@PostMapping("/gameCap/edit/{id}")
	public String mostrarGameAEditar(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String opcion,  @Validated(GameValidar.class) TsscGame juego, 	BindingResult bind, Model modelPrincipal) {

		if (opcion.equals("Cancelar")) {

			modelPrincipal.addAttribute("games", servicio.findAll());
			return "redirect:/gameCap/";
		}
	

		if (bind.hasErrors()) {

		
			modelPrincipal.addAttribute("name", juego.getName());
			modelPrincipal.addAttribute("adminPassword", juego.getAdminPassword());
			modelPrincipal.addAttribute("scheduledDate", juego.getScheduledDate());
			modelPrincipal.addAttribute("scheduledTime", juego.getScheduledTime());
			modelPrincipal.addAttribute("nGroups", juego.getNGroups());
			modelPrincipal.addAttribute("nSprints", juego.getNSprints());
			modelPrincipal.addAttribute("userPassword", juego.getUserPassword());
			modelPrincipal.addAttribute("guestPassword", juego.getGuestPassword());
			modelPrincipal.addAttribute("topics", ServiceTopic.findAll());
			return "gameCap/EditarGame";
		}
		

		if (opcion != null && !opcion.equals("Cancelar")) {

//			if (juego.getTsscTopic() == null) {
//				//servicio.AnadirGameSinTema(juego);
//				servicio.guardar(juego);
//			} else if (juego.getTsscTopic() != null) {
//				//servicio.AnadirGameConTema(juego, juego.getTsscTopic().getId());
//				servicio.guardar(juego);
//			}
			
			servicio.actualizar(juego);

		}
		return "redirect:/gameCap/";
	
		
	}

	@GetMapping("/gameCap/del/{id}")
	public String deleteGame(@PathVariable("id") long id) {
		TsscGame juego = servicio.encontrarPorId(id);
	//	juego.getTsscStories().clear();
		
       
		
		if(juego.getTsscStories() != null) {
			for(int i = 0; i < juego.getTsscStories().size(); i++) {
				
				
				serviceStorie.eliminar(juego.getTsscStories().get(i));
				
			}
		}
		

	
		servicio.eliminar(juego.getId());
		return "redirect:/gameCap/";
	}

	@GetMapping("/gameCap/stories/{id}")
	public String historiasdeJuego(@PathVariable("id") long id, Model modelPrincipal) {
		//TsscGame juego = servicio.findGameById(id);
		TsscGame juego = servicio.encontrarPorId(id);
		List<TsscStory> st = new ArrayList<TsscStory>();
		juego.setTsscStories(st);
		
		for (int i = 0; i < serviceStorie.findAll().size(); i++) {
			
			if(serviceStorie.findAll().get(i).getTsscGame().getName().equals(juego.getName())) {
				
				juego.addTsscStory(serviceStorie.findAll().get(i));
			}
			
		}
		
		
		System.out.println(juego.getTsscStories());
		modelPrincipal.addAttribute("tsscGame", juego);
		modelPrincipal.addAttribute("stories", juego.getTsscStories());
		return "gameCap/storiesGame";
	}
	
	@GetMapping("/gameCap/Timecontrol/{id}")
	public String cronogramasdeJuego(@PathVariable("id") long id, Model modelPrincipal) {
		//TsscGame juego = servicio.findGameById(id);
		TsscGame juego = servicio.encontrarPorId(id);
		List<TsscTimecontrol> st = new ArrayList<TsscTimecontrol>();
		juego.setTsscTimecontrol(st);;
		
		for (int i = 0; i < servicioTime.findAll().size(); i++) {
			
			if(servicioTime.findAll().get(i).getTsscGame().getName().equals(juego.getName())) {
				
				juego.addTsscTimecontrol(servicioTime.findAll().get(i));
			}
			
		}
		
		
		System.out.println(juego.getTsscStories());
		modelPrincipal.addAttribute("tsscGame", juego);
		modelPrincipal.addAttribute("times", juego.getTsscTimecontrols());
		return "gameCap/timesGame";
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/gameCap/topic/{id}")
	public String mostrarTemaPrincipal(@PathVariable("id") long id, Model modelPrincipal) {
		
		List<TsscTopic> primero = new ArrayList<TsscTopic>();
		//TsscGame juego = servicio.findGameById(id);
		TsscGame juego = servicio.encontrarPorId(id);
		List<TsscGame> segundo = new ArrayList<TsscGame>();
		segundo.add(juego);
		if(juego.getTsscTopic()!=null) {
			primero.add(juego.getTsscTopic());
		}		
		
		
		modelPrincipal.addAttribute("tsscGame", segundo);
		modelPrincipal.addAttribute("tsscTopic", primero);

	

		return "gameCap/PrincipalTopic";
	}
	
	

}
