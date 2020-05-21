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
	final String SERVER="http://localhost:8080";
	

	public GameDelegateImpt() {
		super();
		this.restTemplate = new RestTemplate();
	}

	@Override
	public TsscGame guardar(TsscGame nuevo) {
		TsscGame encontrado= restTemplate.postForEntity(SERVER +"games", nuevo, TsscGame.class).getBody();
		return encontrado;
	}
	///hello

	@Override
	public TsscGame actualizar(TsscGame entity) {
		// TODO Auto-generated method stub
		restTemplate.patchForObject(SERVER+"games", entity, TsscGame.class);
		return null;
	}

	@Override
	public void eliminar(TsscGame entity) {
		restTemplate.delete(SERVER+"games/"+entity.getId());
		
	}

	@Override
	public TsscGame encontrarPorId(long id) {
		TsscGame encontrado= restTemplate.getForObject(SERVER+"games/"+id, TsscGame.class ); 
		return null;
	}

	@Override
	public List<TsscGame> findAll() {
		TsscGame[] games= restTemplate.getForObject(SERVER+"games",TsscGame[].class );
		List<TsscGame> nueva= Arrays.asList(games);
		return nueva;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
