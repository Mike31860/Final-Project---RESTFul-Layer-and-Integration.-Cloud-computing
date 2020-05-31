package com.example.demo.Delagate;

import java.util.List;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

public interface TimeControlDelegate {
	
	
	public TsscTimecontrol guardar(TsscTimecontrol entity);
	public void actualizar(TsscTimecontrol entity);
	public void eliminar(TsscTimecontrol entity);
	public TsscTimecontrol findById(long id);
	public List<TsscTimecontrol> findAll();	
		

}
