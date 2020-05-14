package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.TopicService;
import com.example.demo.Validate.TopicValidar;

@RestController
public class TopicRestController implements TopicController{

	@Autowired
	private TopicService service;

	@Override
	@GetMapping("/TemaCap/{id}")
	public TsscTopic findTopicById(@PathVariable Long id) {
		
		return service.findTopicById(id);
	}
	
	
	
	@Override
	
	public TsscTopic AnadirTopic(TsscTopic topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TsscTopic ActualizarTopic(TsscTopic topic, String name, String Description) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean existeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<TsscTopic> findAlll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(TsscTopic topic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTopic(TsscTopic story) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
