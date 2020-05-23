package com.example.demo.Delagate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscTopic;

@Component
public class TopicDelegateImpt implements TopicDelegate {
	
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";

	public TopicDelegateImpt() {
		this.restTemplate = new RestTemplate ();
	}

	@Override
	public TsscTopic guardar(TsscTopic nuevo) {
		TsscTopic encontrado= restTemplate.postForEntity(SERVER +"api/topics", nuevo, TsscTopic.class).getBody();
		return encontrado;
	}

	@Override
	public TsscTopic actualizar(TsscTopic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(TsscTopic encontrado) {
		restTemplate.delete(SERVER+"api/topics/"+encontrado.getId());
		
	}

	@Override
	public TsscTopic findById(long id) {
		TsscTopic encontrado= restTemplate.getForObject(SERVER+"api/topics/"+id, TsscTopic.class ); 
		return encontrado;
	}

	@Override
	public Iterable<TsscTopic> findAll() {

		
		TsscTopic[] topics= restTemplate.getForObject(SERVER+"api/topics",TsscTopic[].class );
		List<TsscTopic> nueva= Arrays.asList(topics);
		
		return nueva;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
