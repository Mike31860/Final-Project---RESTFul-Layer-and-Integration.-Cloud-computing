package com.example.demo.Delagate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscConsulta2;
import com.example.demo.Model.TsscGame;
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
		TsscTopic encontrado= restTemplate.postForObject(SERVER +"api/topics", nuevo, TsscTopic.class);
		return encontrado;
	}

	@Override
	public void  actualizar(TsscTopic entity) {
		restTemplate.put(SERVER+"api/topics", entity, TsscTopic.class);
	
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



	@Override
	public List<TsscConsulta2> nuevaConsulta(String date) {
		TsscConsulta2[] ecnontrada=restTemplate.getForObject(SERVER+"api/topic/fecha/"+date,TsscConsulta2[].class );
		System.out.println(ecnontrada);
		List<TsscConsulta2> nueva= Arrays.asList(ecnontrada);
		return nueva;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
