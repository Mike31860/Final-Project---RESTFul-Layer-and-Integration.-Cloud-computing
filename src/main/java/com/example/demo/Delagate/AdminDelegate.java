package com.example.demo.Delagate;

import java.util.List;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscConsulta2;
import com.example.demo.Model.TsscTopic;

public interface AdminDelegate {
	
	public TsscAdmin guardar(TsscAdmin entity);
	public void actualizar(TsscAdmin entity);
	public void eliminar(TsscAdmin entity);
	public TsscAdmin findById(long id);
	public Iterable<TsscAdmin> findAll();
	
	

}
