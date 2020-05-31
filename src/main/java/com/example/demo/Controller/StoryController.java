package com.example.demo.Controller;

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
import com.example.demo.Delagate.storyDelegate;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Service.GameService;
import com.example.demo.Service.StoryService;
import com.example.demo.Service.StoryServiceImpt;
import com.example.demo.Validate.GameValidar;
import com.example.demo.Validate.StoryValidar;

@Controller
public class StoryController {

	private storyDelegate servicio;
	private GameDelegate gameServicio;

	@Autowired
	public StoryController(storyDelegate Service, GameDelegate game) {
		this.servicio = Service;
		this.gameServicio = game;
	}

	@GetMapping("/storyCap/")
	public String indexSroyCap(Model modelPrincipal) {
		modelPrincipal.addAttribute("stories", servicio.findAll());
		return "storyCap/StoryPrincipal";
	}

	@GetMapping("/storyCap/add")
	public String agregarStoryPrincipal(Model modelPrincipal) {
		modelPrincipal.addAttribute("tsscStory", new TsscStory());
		modelPrincipal.addAttribute("games", gameServicio.findAll());
		modelPrincipal.addAttribute("stories", servicio.findAll());
		return "storyCap/agregarHistoria";
	}

	@PostMapping("/storyCap/add")
	public String guardarStoryMiguel(@Validated(StoryValidar.class) TsscStory story, BindingResult bind,
			Model modelPrincipal, @RequestParam(value = "action", required = true) String opcion) {
		if (!opcion.equals("Cancelar")) {
			if (bind.hasErrors()) {

				modelPrincipal.addAttribute("description", story.getDescription());
				modelPrincipal.addAttribute("businessValue", story.getBusinessValue());
				modelPrincipal.addAttribute("initialSprint", story.getInitialSprint());
				modelPrincipal.addAttribute("priority", story.getPriority());
				modelPrincipal.addAttribute("topics", servicio.findAll());
				modelPrincipal.addAttribute("games", gameServicio.findAll());

				return "storyCap/agregarHistoria";
			} else if (!bind.hasErrors()) {

//				TsscGame encontrado = gameServicio.encontrarPorId(story.getTsscGame().getId());
//				encontrado.addTsscStory(story);			
//				gameServicio.actualizar(encontrado);
				
				// gameServicio.encontrarPorId(story.getTsscGame().getId()).addTsscStory(story);
				// servicio.AnadirStory(story, encontrado.getId());
				// story.setTsscGame(encontrado);

				servicio.guardar(story);

				return "redirect:/storyCap/";
			} else {
				return "redirect:/storyCap/";
			}
		} else {

			modelPrincipal.addAttribute("stories", servicio.findAll());
			return "storyCap/StoryPrincipal";
		}

	}

	@GetMapping("/storyCap/edit/{id}")
	public String EditarStoryPrincipal(@PathVariable("id") long id, Model modelPrincipal) {
		// TsscStory story = servicio.findStoryById(id);
		TsscStory story = servicio.encontrarPorId(id);

		{
			if (story == null)
				throw new IllegalArgumentException("Id del juego Invalido:" + id);

			modelPrincipal.addAttribute("tsscStory", story);
			modelPrincipal.addAttribute("description", story.getDescription());
			modelPrincipal.addAttribute("businessValue", story.getBusinessValue());
			modelPrincipal.addAttribute("initialSprint", story.getInitialSprint());
			modelPrincipal.addAttribute("priority", story.getPriority());
			modelPrincipal.addAttribute("games", gameServicio.findAll());

			return "storyCap/EditarHistoria";
		}

	}

	@PostMapping("/storyCap/edit/{id}")
	public String mostrarStoryAEditar(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String opcion,
			@Validated(StoryValidar.class) TsscStory story, BindingResult bind, Model modelPrincipal) {

		if (!opcion.equals("CancelarOperacion")) {
			if (bind.hasErrors()) {

			  //  modelPrincipal.addAttribute("tsscStory", story);
				modelPrincipal.addAttribute("description", story.getDescription());
				modelPrincipal.addAttribute("businessValue", story.getBusinessValue());
				modelPrincipal.addAttribute("initialSprint", story.getInitialSprint());
				modelPrincipal.addAttribute("priority", story.getPriority());
				modelPrincipal.addAttribute("games", gameServicio.findAll());
				return "storyCap/EditarHistoria";
			}

			else {

				// TsscGame encontrado =
				// gameServicio.encontrarPorId(story.getTsscGame().getId());
				// servicio.AnadirStory(story, encontrado.getId());
				// gameServicio.encontrarPorId(story.getTsscGame().getId()).addTsscStory(story);;
				servicio.actualizar(story);
				return "redirect:/storyCap/";

			}
		}
		return "redirect:/storyCap/";
	}

	@GetMapping("/storyCap/del/{id}")
	public String deleteStory(@PathVariable("id") long id) {
		TsscStory story = servicio.encontrarPorId(id);
		servicio.eliminar(story);
		return "redirect:/storyCap/";
	}

}
