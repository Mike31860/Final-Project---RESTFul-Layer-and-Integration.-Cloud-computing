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
import com.example.demo.Delagate.TimeControlDelegateImp;
import com.example.demo.Delagate.storyDelegate;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Validate.TimeValidar;

@Controller
public class TimeControlController {
	
	private TimeControlDelegateImp servicio;
	private GameDelegate gameServicio;

	@Autowired
	public TimeControlController(TimeControlDelegateImp Service, GameDelegate game) {
		this.servicio = Service;
		this.gameServicio = game;
	}

	@GetMapping("/Cronograma/")
	public String indexCronoCap(Model modelPrincipal) {
		modelPrincipal.addAttribute("times", servicio.findAll());
		return "Cronograma/cronoPrincipal";
	}

	@GetMapping("/Cronograma/add")
	public String agregarCronogramaPrincipal(Model modelPrincipal) {
		modelPrincipal.addAttribute("tsscTimecontrol", new TsscTimecontrol());
		modelPrincipal.addAttribute("games", gameServicio.findAll());
		modelPrincipal.addAttribute("times", servicio.findAll());
		return "Cronograma/agregarCrono";
	}

	@PostMapping("/Cronograma/add")
	public String guardarStoryMiguel(@Validated(TimeValidar.class) TsscTimecontrol tsscTimecontrol, BindingResult bind,
			Model modelPrincipal, @RequestParam(value = "action", required = true) String opcion) {
		if (!opcion.equals("Cancelar")) {
			if (bind.hasErrors()) {

				modelPrincipal.addAttribute("name", tsscTimecontrol.getName());
				modelPrincipal.addAttribute("order", tsscTimecontrol.getOrder());
				modelPrincipal.addAttribute("intervalRunning", tsscTimecontrol.getIntervalRunning());
				modelPrincipal.addAttribute("timeInterval", tsscTimecontrol.getTimeInterval());
				modelPrincipal.addAttribute("times", servicio.findAll());
				modelPrincipal.addAttribute("games", gameServicio.findAll());

				return "Cronograma/agregarCrono";
			} else if (!bind.hasErrors()) {

				TsscGame encontrado = gameServicio.encontrarPorId(tsscTimecontrol.getTsscGame().getId());
				encontrado.addTsscTimecontrol(tsscTimecontrol);			
			
			System.out.println(encontrado.getName());

				
				servicio.guardar(tsscTimecontrol);

				return "redirect:/Cronograma/";
			} else {
				return "redirect:/Cronograma/";
			}
		} else {

			modelPrincipal.addAttribute("times", servicio.findAll());
			return "Cronograma/cronoPrincipal";
		}

	}

	@GetMapping("/Cronograma/edit/{id}")
	public String EditarStoryPrincipal(@PathVariable("id") long id, Model modelPrincipal) {
		// TsscStory story = servicio.findStoryById(id);
		TsscTimecontrol tsscTimecontrol = servicio.findById(id);

		{
			if (tsscTimecontrol == null)
				throw new IllegalArgumentException("Id del juego Invalido:" + id);

			modelPrincipal.addAttribute("tsscTimecontrol", tsscTimecontrol);
			modelPrincipal.addAttribute("name", tsscTimecontrol.getName());
			modelPrincipal.addAttribute("order", tsscTimecontrol.getOrder());
			modelPrincipal.addAttribute("intervalRunning", tsscTimecontrol.getIntervalRunning());
			modelPrincipal.addAttribute("timeInterval", tsscTimecontrol.getTimeInterval());
			modelPrincipal.addAttribute("games", gameServicio.findAll());

			return "Cronograma/editarCrono";
		}

	}

	@PostMapping("/Cronograma/edit/{id}")
	public String mostrarStoryAEditar(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String opcion,
			@Validated(TimeValidar.class) TsscTimecontrol tsscTimecontrol, BindingResult bind, Model modelPrincipal) {

		if (!opcion.equals("CancelarOperacion")) {
			if (bind.hasErrors()) {

			  //  modelPrincipal.addAttribute("tsscStory", story);
				modelPrincipal.addAttribute("name", tsscTimecontrol.getName());
				modelPrincipal.addAttribute("order", tsscTimecontrol.getOrder());
				modelPrincipal.addAttribute("intervalRunning", tsscTimecontrol.getIntervalRunning());
				modelPrincipal.addAttribute("timeInterval", tsscTimecontrol.getTimeInterval());
				modelPrincipal.addAttribute("games", gameServicio.findAll());
				return "Cronograma/editarCrono";
			}

			else {

				// TsscGame encontrado =
				// gameServicio.encontrarPorId(story.getTsscGame().getId());
				// servicio.AnadirStory(story, encontrado.getId());
				// gameServicio.encontrarPorId(story.getTsscGame().getId()).addTsscStory(story);;
				servicio.actualizar(tsscTimecontrol);
				return "redirect:/Cronograma/";

			}
		}
		return "redirect:/Cronograma/";
	}

	@GetMapping("/Cronograma/del/{id}")
	public String deleteCrono(@PathVariable("id") long id) {
		TsscTimecontrol tsscTimecontrol = servicio.findById(id);
		servicio.eliminar(tsscTimecontrol);
		return "redirect:/Cronograma/";
	}

}
