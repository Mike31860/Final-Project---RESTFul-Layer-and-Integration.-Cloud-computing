package com.example.demo.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;


public interface GameService {

	
	
	public TsscGame ActualizarGame(TsscGame game, int Grupos, String name);
	public TsscGame AnadirGameConTema(TsscGame gameOne, long id) ;
	public TsscGame AnadirGameSinTema(TsscGame gameOne);
	public TsscGame AnadirGameJuego2(TsscGame gameOne, long id) ;
	public TsscGame findGameById(Long id);
	public List<TsscGame> encontrarPorDates(LocalDate date);
	public boolean existbyId(Long id);
	public TsscStory agregarStory(TsscGame game, TsscStory Story);
	public Iterable<TsscGame> findAlll();
	public void eliminarGame(TsscGame juego);
	public void actualizarGameDato(TsscGame game);
	
	
	
}
