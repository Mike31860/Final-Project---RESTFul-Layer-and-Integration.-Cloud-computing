package com.example.demo.Delagate;

import java.util.List;

import com.example.demo.Model.TsscGame;

public interface GameDelegate {

	
	public TsscGame guardar(TsscGame entity);
	public void actualizar(TsscGame entity);
	public void eliminar(TsscGame entity);
	public TsscGame encontrarPorId(long id);
	public List<TsscGame> findAll();
	public boolean existsById(Long id);
	
	
	
	
	
	
	
}
