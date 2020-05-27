package com.example.demo.Delagate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscTopic;


@Component
public class GameDelegateImpt implements GameDelegate{
	
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	

	public GameDelegateImpt() {
		super();
		this.restTemplate = new RestTemplate();
	}

	@Override
	public TsscGame guardar(TsscGame nuevo) {
		TsscGame encontrado= restTemplate.postForEntity(SERVER +"api/games", nuevo, TsscGame.class).getBody();
		return encontrado;
	}
	///hello

	@Override
	public TsscGame actualizar(TsscGame entity) {
		// TODO Auto-generated method stub
		TsscGame encontrado= restTemplate.patchForObject(SERVER+"api/games", entity, TsscGame.class);
		return encontrado;
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
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
