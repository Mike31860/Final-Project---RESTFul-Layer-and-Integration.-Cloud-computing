package com.example.demo.RestController;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

public interface TopicController {
	
	public TsscTopic AnadirTopic(TsscTopic topic);
	public TsscTopic ActualizarTopic(TsscTopic topic, String name, String Description );
	public TsscTopic findTopicById(Long id); 
	public boolean existeById(Long id);
	public Iterable<TsscTopic> findAlll();
	public void actualizar(TsscTopic topic);
	public void eliminarTopic(TsscTopic story);
	
	
	

}
