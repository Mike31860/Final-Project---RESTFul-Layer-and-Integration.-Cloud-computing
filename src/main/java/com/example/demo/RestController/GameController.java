package com.example.demo.RestController;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;

public interface GameController {
	
	public TsscGame ActualizarGame(TsscGame game, int Grupos, String name);
	public TsscGame AnadirGameConTema(TsscGame gameOne, long id) ;
	public TsscGame AnadirGameSinTema(TsscGame gameOne);
	public TsscGame AnadirGameJuego2(TsscGame gameOne, long id) ;
	public TsscGame findGameById(long id);  
	public boolean existbyId(long id);
	public TsscStory agregarStory(TsscGame game, TsscStory Story);
	public Iterable<TsscGame> findAlll();
	public void eliminarGame(TsscGame juego);
	public void actualizarGameDato(TsscGame game);

}
