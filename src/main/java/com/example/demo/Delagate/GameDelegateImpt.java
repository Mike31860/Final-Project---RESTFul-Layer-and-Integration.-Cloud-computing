package com.example.demo.Delagate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscGame;


@Component
public class GameDelegateImpt implements GameDelegate{
	
	
	private RestTemplate restTemplate;
	

	public GameDelegateImpt() {
		super();
		this.restTemplate = new RestTemplate();
	}

	@Override
	public TsscGame guardar(TsscGame entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TsscGame actualizar(TsscGame entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(TsscGame entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TsscGame encontrarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TsscGame> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
