package com.example.demo.DAOS;

import java.util.List;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTopic;

public interface AdminDao {
	
	public TsscAdmin guardar(TsscAdmin entity);
	public TsscAdmin actualizar(TsscAdmin entity);
	public void eliminar(TsscAdmin entity);
	public TsscAdmin findById(long id);
	public List<TsscAdmin> findAll();
	public TsscAdmin findByUser(String user);

}
