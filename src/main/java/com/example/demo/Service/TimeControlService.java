package com.example.demo.Service;

import com.example.demo.Model.TsscTimecontrol;


public interface TimeControlService {
	
	
	public TsscTimecontrol AnadirTimeControl(TsscTimecontrol time);
	public TsscTimecontrol ActualizarTimeControl(TsscTimecontrol time);
	public TsscTimecontrol findTimeById(Long id); 
	public boolean existeById(Long id);
	public Iterable<TsscTimecontrol> findAlll();
	public void eliminarTime(TsscTimecontrol time);
	
	
	
	
	
	
	
	

}
