package com.example.demo.DAOS;

import java.util.List;

import com.example.demo.Model.TsscStory;

public interface StoryDao {
	
	public TsscStory guardar(TsscStory entity);
	public TsscStory actualizar(TsscStory entity);
	public void eliminar(TsscStory entity);
	public TsscStory encontrarPorId(long id);
	public List<TsscStory> findAll();
	public boolean existsById(Long id);

}
