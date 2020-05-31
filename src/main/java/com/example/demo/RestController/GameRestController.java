package com.example.demo.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Service.GameService;

@RestController
public class GameRestController  implements GameController{
	
	@Autowired
	private GameService service;

	@Override
	@PutMapping("/api/games")
	public void ActualizarGame(@RequestBody TsscGame game) {
		//return service.ActualizarGame(game, game.getNGroups(), game.getName());
		 service.actualizarGameDato(game);
	}	
	
	@Override
	@PostMapping("/api/games")
	public TsscGame AnadirGame(@RequestBody TsscGame gameOne) {
		// TODO Auto-generated method stub
		if(gameOne.getTsscTopic()==null) {
		return service.AnadirGameSinTema(gameOne);
		}
		else{
			return service.AnadirGameConTema(gameOne, gameOne.getTsscTopic().getId());
		}
	}
	//funciona
	@Override
	@GetMapping("/api/games/{id}")
	public TsscGame findGameById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return service.findGameById(id);
	}
	//funciona
	@Override
	@GetMapping("/api/games")
	public Iterable<TsscGame> findAlll() {
		// TODO Auto-generated method stub
		return service.findAlll();
	}

	//funciona
	@Override
	@DeleteMapping("/api/games/{id}")
	public TsscGame eliminarGame(@PathVariable long id) {
		// TODO Auto-generated method stub
		TsscGame encontrado=service.findGameById(id);
		service.eliminarGame(encontrado);
		return encontrado;
	}

	@Override
	public Iterable<TsscStory> findHistorias() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	@GetMapping("/api/games/{date}")
	public List<TsscGame> findGameByDate(String date) {
		// TODO Auto-generated method stub
		
		return service.encontrarPorDates(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}

    //@Override
	//@PostMapping("/api/games/add")
	//public TsscGame AnadirGameConTema(@RequestBody TsscGame gameOne) {
		// TODO Auto-generated method stub
	//	return service.AnadirGameConTema(gameOne, gameOne.getTsscTopic().getId());
	//}

	

///	@Override
//	@PostMapping("/api/games/add")
//	public TsscGame AnadirGameJuego2(@RequestBody TsscGame gameOne) {
//		// TODO Auto-generated method stub
//		return service.AnadirGameJuego2(gameOne, gameOne.getTsscTopic().getId());
//	}

	

//	@Override
//	@GetMapping("/api/games/{id}")
//	public boolean existbyId(@PathVariable long id) {
//		// TODO Auto-generated method stub
//		return service.existbyId(id);
//	}

//	@Override
//	@PostMapping("/api/games/{id}")
//	public TsscStory agregarStory(@RequestBody TsscStory story, @PathVariable long id ) {
///		// TODO Auto-generated method stub	
//		return service.agregarStory(service.findGameById(id), story);
//	}

	

//	@Override
//	@PatchMapping("/api/games/edit")
//	public void actualizarGameDato(@RequestBody TsscGame game) {
//		// TODO Auto-generated method stub
//		service.actualizarGameDato(game);
		
////	}



}
