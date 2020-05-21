package com.example.demo.Delagate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

@Component
public class storyDelegateImpt implements storyDelegate {

	
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080";
	

	public storyDelegateImpt() {
		this.restTemplate = new RestTemplate();
	}
	
	
	@Override
	public TsscStory guardar(TsscStory nuevo) {
		TsscStory encontrado= restTemplate.postForEntity(SERVER +"TemaCap", nuevo, TsscStory.class).getBody();
		return encontrado;
	}

	@Override
	public TsscStory actualizar(TsscStory entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(TsscStory nuevo) {
		restTemplate.delete(SERVER+"StoryCap/"+nuevo.getId());
		
		
	}

	@Override
	public TsscStory encontrarPorId(long id) {
		TsscStory encontrado=restTemplate.getForObject(SERVER+"StoryCap/"+id, TsscStory.class ); 
		return null;
	}

	@Override
	public List<TsscStory> findAll() {
		TsscStory[] stories= restTemplate.getForObject(SERVER+"StoryCap",TsscStory[].class );
		List<TsscStory> nueva= Arrays.asList(stories);
		return nueva;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
