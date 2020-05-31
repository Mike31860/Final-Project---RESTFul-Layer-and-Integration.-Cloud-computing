package com.example.demo.Delagate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;


@Component
public class GameDelegateImpt implements GameDelegate{
	
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	

	public GameDelegateImpt() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public TsscGame guardar(TsscGame nuevo) {
		TsscGame encontrado= restTemplate.postForObject(SERVER +"api/games", nuevo, TsscGame.class);
		return encontrado;
	}
	///hello

	@Override
	public void actualizar(TsscGame entity) {
		// TODO Auto-generated method stub
		 restTemplate.put(SERVER+"api/games", entity, TsscGame.class);
	
	}

	@Override
	public void eliminar(Long id) {
		restTemplate.delete(SERVER+"api/games/"+id);
		
	}

	@Override
	public TsscGame encontrarPorId(long id) {
		TsscGame encontrado= restTemplate.getForObject(SERVER+"api/games/"+id, TsscGame.class ); 
		return encontrado;
	}

	@Override
	public List<TsscGame> findAll() {
		TsscGame[] games= restTemplate.getForObject(SERVER+"api/games",TsscGame[].class );
		List<TsscGame> nueva= Arrays.asList(games);
		return nueva;
	}
	
	@Override
	public List<TsscStory> findAllStories() {
		TsscStory[] games= restTemplate.getForObject(SERVER+"api/games",TsscStory[].class );
		List<TsscStory> nueva= Arrays.asList(games);
		return nueva;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TsscGame> encontrarPorFecha(String date) {
		// TODO Auto-generated method stub
		TsscGame[] encontrado= restTemplate.getForObject(SERVER+"api/games/"+date, TsscGame[].class ); 
		List<TsscGame> nueva= Arrays.asList(encontrado);
		return nueva;
	}
	
	
	
	

}
