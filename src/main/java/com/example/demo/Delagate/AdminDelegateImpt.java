package com.example.demo.Delagate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTopic;
@Component
public class AdminDelegateImpt  implements AdminDelegate{

	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	
	@Override
	public TsscAdmin guardar(TsscAdmin entity) {
		TsscAdmin encontrado= restTemplate.postForObject(SERVER +"api/Admins", entity, TsscAdmin.class);
		return encontrado;

	}

	@Override
	public void actualizar(TsscAdmin entity) {
		restTemplate.put(SERVER+"api/Admins", entity, TsscTopic.class);
		
	}

	@Override
	public void eliminar(TsscAdmin entity) {
		restTemplate.delete(SERVER+"api/Admins/"+entity.getId());
		
	}

	@Override
	public TsscAdmin findById(long id) {
		TsscAdmin encontrado= restTemplate.getForObject(SERVER+"api/Admins/"+id, TsscAdmin.class ); 
		return encontrado;
	}

	@Override
	public Iterable<TsscAdmin> findAll() {
		TsscAdmin[] admins= restTemplate.getForObject(SERVER+"api/Admins",TsscAdmin[].class );
		List<TsscAdmin> nueva= Arrays.asList(admins);
		
		return nueva;
	}

}
