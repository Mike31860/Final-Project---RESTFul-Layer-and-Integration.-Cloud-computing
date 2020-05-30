package com.example.demo.Delagate;

import java.util.List;

import com.example.demo.Model.TsscTopic;

public interface TopicDelegate {

	public TsscTopic guardar(TsscTopic entity);
	public void actualizar(TsscTopic entity);
	public void eliminar(TsscTopic entity);
	public TsscTopic findById(long id);
	public Iterable<TsscTopic> findAll();	
	
}
