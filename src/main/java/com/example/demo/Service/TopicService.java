package com.example.demo.Service;


import java.time.LocalDate;
import java.util.List;

import com.example.demo.Model.TsscConsulta2;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

public interface TopicService {
	
	public TsscTopic AnadirTopic(TsscTopic topic);
	public TsscTopic ActualizarTopic(TsscTopic topic, String name, String Description );
	public TsscTopic findTopicById(Long id); 
	public boolean existeById(Long id);
	public Iterable<TsscTopic> findAlll();
	public void actualizar(TsscTopic topic);
	public List<Object[]> buscarTopicByDate(LocalDate date);

	public void eliminarTopic(TsscTopic story);

}
