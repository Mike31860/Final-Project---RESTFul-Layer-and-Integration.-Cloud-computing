package com.example.demo.Delagate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

@Component
public class storyDelegateImpt implements storyDelegate {

	
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	

	public storyDelegateImpt() {
		this.restTemplate = new RestTemplate();
	}
	
	
	@Override
	public TsscStory guardar(TsscStory nuevo) {
		TsscStory encontrado= restTemplate.postForObject(SERVER +"api/stories/"+nuevo.getTsscGame().getId(), nuevo, TsscStory.class);
		return encontrado;
	}

	@Override
	public void actualizar(TsscStory entity) {
		// TODO Auto-generated method stub
		restTemplate.put(SERVER+"api/stories", entity, TsscStory.class);
		
	}

	@Override
	public void eliminar(TsscStory nuevo) {
		restTemplate.delete(SERVER+"api/stories/"+nuevo.getId());
	
	}

	@Override
	public TsscStory encontrarPorId(long id) {
		TsscStory encontrado=restTemplate.getForObject(SERVER+"api/stories/"+id, TsscStory.class ); 
		return encontrado;
	}

	@Override
	public List<TsscStory> findAll() {
		TsscStory[] stories= restTemplate.getForObject(SERVER+"api/stories",TsscStory[].class );
		List<TsscStory> nueva= Arrays.asList(stories);
		return nueva;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
