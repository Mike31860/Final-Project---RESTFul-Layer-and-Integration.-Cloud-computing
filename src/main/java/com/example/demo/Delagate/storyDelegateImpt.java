package com.example.demo.Delagate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscStory;

@Component
public class storyDelegateImpt implements storyDelegate {

	
	
   private RestTemplate restTemplate;
	

	public storyDelegateImpt() {
		this.restTemplate = new RestTemplate();
	}
	
	
	@Override
	public TsscStory guardar(TsscStory entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TsscStory actualizar(TsscStory entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(TsscStory entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TsscStory encontrarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TsscStory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
