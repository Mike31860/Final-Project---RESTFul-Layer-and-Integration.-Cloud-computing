package com.example.demo.RestController;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

public interface TimeRestController {
	
	public TsscTimecontrol AnadirTimeControl(TsscTimecontrol Time);
	//public TsscTopic ActualizarTopic(TsscTopic topic, String name, String Description );
	public TsscTimecontrol findTimeControlById(long id); 
	//public boolean existeById(long id);
	public Iterable<TsscTimecontrol> findAlll();
	public void actualizar(TsscTimecontrol time);
	public TsscTimecontrol eliminarTimeControl(long id);

}
