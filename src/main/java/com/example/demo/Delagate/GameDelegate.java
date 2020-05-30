package com.example.demo.Delagate;

import java.util.List;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;

public interface GameDelegate {

	
	public TsscGame guardar(TsscGame entity);
	public void actualizar(TsscGame entity);
	public void eliminar(Long id);
	public TsscGame encontrarPorId(long id);
	public List<TsscGame> findAll();
	public List<TsscStory> findAllStories();
	public boolean existsById(Long id);
	
	
	
	
	
	
	
}
