package com.example.demo.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.TsscConsulta2;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

public interface TopicController {
	
	public TsscTopic AnadirTopic(TsscTopic topic);
	//public TsscTopic ActualizarTopic(TsscTopic topic, String name, String Description );
	public TsscTopic findTopicById(long id); 
	//public boolean existeById(long id);
	public Iterable<TsscTopic> findAlll();
	public void actualizar(TsscTopic topic);
	public TsscTopic eliminarTopic(long id);
	public List<TsscConsulta2> findGameByDate(String date);
	
	

}
