package com.example.demo.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TsscConsulta2;
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
	@GetMapping("/api/topics/{id}")
	public TsscTopic findTopicById(@PathVariable long id) {
		return service.findTopicById(id);
	}
	
	@Override
	@PostMapping("/api/topics")
	public TsscTopic AnadirTopic(@RequestBody TsscTopic topic) {
		// TODO Auto-generated method stub
		return service.AnadirTopic(topic);
	}


//	@Override
//	@GetMapping("/topics")
//	public boolean existeById(@PathVariable long id) {
//		// TODO Auto-generated method stub
//		return service.existeById(id);
//	}

	@Override
	@GetMapping("/api/topics")
	public Iterable<TsscTopic> findAlll() {
		// TODO Auto-generated method stub
		return service.findAlll();
	}

	@Override
	@PutMapping("/api/topics")
	public void actualizar(@RequestBody TsscTopic topic) {
		// TODO Auto-generated method stub
		service.actualizar(topic);
	}

	@Override
	@DeleteMapping("/api/topics/{id}")
	public TsscTopic eliminarTopic(@PathVariable long id) {
		// TODO Auto-generated method stub
		TsscTopic encontrado=service.findTopicById(id);
		service.eliminarTopic(encontrado);
		return encontrado;
	}


	@Override
	@GetMapping("/api/topic/fecha/{date}")
	public List<TsscConsulta2> findGameByDate(@PathVariable  String date) {	
		List<Object[]> econtrado= service.buscarTopicByDate(LocalDate.parse(date));
		List<TsscConsulta2> nuevaLista= new ArrayList<TsscConsulta2>();
		for (int i = 0; i < econtrado.size(); i++) {
			
			long numero= (long) econtrado.get(i)[1];
			System.out.println(econtrado.get(i)[0]);
			TsscTopic temaPrimero= (TsscTopic) (econtrado.get(i)[0]);
		    TsscConsulta2 instancia= new TsscConsulta2(numero, temaPrimero);
		    nuevaLista.add(instancia);
			
		}
		
		
		return nuevaLista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
