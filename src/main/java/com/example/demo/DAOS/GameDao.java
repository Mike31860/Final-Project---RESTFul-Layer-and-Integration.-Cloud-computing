package com.example.demo.DAOS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.example.demo.Model.TsscGame;



public interface GameDao {
	
	public TsscGame guardar(TsscGame entity);
	public TsscGame actualizar(TsscGame entity);
	public void eliminar(TsscGame entity);
	public TsscGame encontrarPorId(long id);
	
	public List<TsscGame> findAll();
	public boolean existsById(Long id);
	//1b)nombre, descripcion , id del tema PREGUNTAR
	//*****************************************
	public List<TsscGame> encontrarPorNameTopic(String name);
	public List<TsscGame> encontrarPorDescriptionTopic(String description);
	public List<TsscGame> encontrarPorIdTopic(long idTopic);
	
	//1c) juntos o separados??
	public List<TsscGame> encontrarPorDates(LocalDate date1, LocalDate date2);
	public List<TsscGame> encontrarPorDateHours(LocalDate date, LocalTime h1, LocalTime h2);
	public List<TsscGame> encontrarPorDateStoryTime(LocalDate date);

}
