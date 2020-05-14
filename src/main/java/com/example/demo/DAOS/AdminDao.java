package com.example.demo.DAOS;

import com.example.demo.Model.TsscAdmin;

public interface AdminDao {
	
	public TsscAdmin guardar(TsscAdmin entity);
	public TsscAdmin actualizar(TsscAdmin entity);
	public void eliminar(TsscAdmin entity);
	public TsscAdmin findById(long id);

}
