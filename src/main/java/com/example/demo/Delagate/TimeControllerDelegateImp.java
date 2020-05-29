package com.example.demo.Delagate;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

public class TimeControllerDelegateImp implements TimeControllerDelegate  {

	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	public TimeControllerDelegateImp() {
		this.restTemplate = new RestTemplate ();
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscTimecontrol guardar(TsscTimecontrol entity) {
		TsscTimecontrol encontrado= restTemplate.postForEntity(SERVER +"api/times", entity, TsscTimecontrol.class).getBody();
		return encontrado;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscTimecontrol actualizar(TsscTimecontrol entity) {
		TsscTimecontrol encontrado= restTemplate.patchForObject(SERVER+"api/times", entity, TsscTimecontrol.class);
		return encontrado;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void eliminar(TsscTimecontrol entity) {
		restTemplate.delete(SERVER+"api/times/"+entity.getId());
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscTimecontrol findById(long id) {
		TsscTimecontrol encontrado= restTemplate.getForObject(SERVER+"api/times/"+id, TsscTimecontrol.class ); 
		return encontrado;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Iterable<TsscTimecontrol> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
