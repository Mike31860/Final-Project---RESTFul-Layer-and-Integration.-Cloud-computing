package com.example.demo.Delagate;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

@Component
public class TimeControlDelegateImp implements TimeControlDelegate  {

	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	public TimeControlDelegateImp() {
		this.restTemplate = new RestTemplate ();
	}
	
	@Override
	public TsscTimecontrol guardar(TsscTimecontrol entity) {
		TsscTimecontrol encontrado= restTemplate.postForObject(SERVER +"api/times", entity, TsscTimecontrol.class);
		return encontrado;
	}

	@Override
	public TsscTimecontrol actualizar(TsscTimecontrol entity) {
		TsscTimecontrol encontrado= restTemplate.patchForObject(SERVER+"api/times", entity, TsscTimecontrol.class);
		return encontrado;
	}

	@Override
	public void eliminar(TsscTimecontrol entity) {
		restTemplate.delete(SERVER+"api/times/"+entity.getId());
		
	}

	@Override
	public TsscTimecontrol findById(long id) {
		TsscTimecontrol encontrado= restTemplate.getForObject(SERVER+"api/times/"+id, TsscTimecontrol.class ); 
		return encontrado;
	}

	@Override
	public Iterable<TsscTimecontrol> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
