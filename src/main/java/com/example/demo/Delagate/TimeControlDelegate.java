package com.example.demo.Delagate;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

public interface TimeControlDelegate {
	
	
	public TsscTimecontrol guardar(TsscTimecontrol entity);
	public TsscTimecontrol actualizar(TsscTimecontrol entity);
	public void eliminar(TsscTimecontrol entity);
	public TsscTimecontrol findById(long id);
	public Iterable<TsscTimecontrol> findAll();	
		

}
