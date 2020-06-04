package com.example.demo.DAOS;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.util.Pair;

import com.example.demo.Model.TsscTopic;

public interface TopicDao {
	
	public TsscTopic guardar(TsscTopic entity);
	public TsscTopic actualizar(TsscTopic entity);
	public void eliminar(TsscTopic entity);
	public TsscTopic findById(long id);
	public List<TsscTopic> findAll();
	public List<TsscTopic> encontrarPorNombre(String name);
	public List<TsscTopic> encontrarPorDescription(String description);
	public boolean existsById(Long id);
	public List<Object[]> encontrarTopicPorElDateGame(LocalDate date);

}
