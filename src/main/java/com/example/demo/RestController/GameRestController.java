package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PatchMapping("/api/games")
	public TsscGame ActualizarGame(@RequestBody TsscGame game, int Grupos, String name) {
		
		return service.ActualizarGame(game, Grupos, name);
	}

	@Override
	@PostMapping("/api/games/{id}")
	public TsscGame AnadirGameConTema(@RequestBody TsscGame gameOne, @PathVariable long id) {
		// TODO Auto-generated method stub
		return service.AnadirGameConTema(gameOne, id);
	}

	@Override
	@PostMapping("/api/games")
	public TsscGame AnadirGameSinTema(@RequestBody TsscGame gameOne) {
		// TODO Auto-generated method stub
		return service.AnadirGameSinTema(gameOne);
	}

	@Override
	@PostMapping("/api/games/{id}")
	public TsscGame AnadirGameJuego2(@RequestBody TsscGame gameOne, @PathVariable long id) {
		// TODO Auto-generated method stub
		return service.AnadirGameJuego2(gameOne, id);
	}

	@Override
	@GetMapping("/api/games/{id}")
	public TsscGame findGameById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return service.findGameById(id);
	}

	@Override
	@GetMapping("/api/games/{id}")
	public boolean existbyId(@PathVariable long id) {
		// TODO Auto-generated method stub
		return service.existbyId(id);
	}

	@Override
	@PostMapping("/api/games")
	public TsscStory agregarStory(@RequestBody TsscGame game, @RequestBody TsscStory Story) {
		// TODO Auto-generated method stub
		return service.agregarStory(game, Story);
	}

	@Override
	@GetMapping("/api/games")
	public Iterable<TsscGame> findAlll() {
		// TODO Auto-generated method stub
		return service.findAlll();
	}

	@Override
	@DeleteMapping("/api/games")
	public void eliminarGame(@RequestBody TsscGame juego) {
		// TODO Auto-generated method stub
		service.eliminarGame(juego);
	}

	@Override
	@PatchMapping("/api/games")
	public void actualizarGameDato(@RequestBody TsscGame game) {
		// TODO Auto-generated method stub
		service.actualizarGameDato(game);
		
	}

}
