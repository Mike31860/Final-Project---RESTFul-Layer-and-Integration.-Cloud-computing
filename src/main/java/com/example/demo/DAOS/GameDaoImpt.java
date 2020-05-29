package com.example.demo.DAOS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscTopic;

@Repository
@Scope("singleton")
public class GameDaoImpt implements GameDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TsscGame guardar(TsscGame entity) {
		
		entityManager.persist(entity);
		//entityManager.merge(entity);
		return entity;
	}

	@Override
	public TsscGame actualizar(TsscGame entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void eliminar(TsscGame entity) {
		entityManager.remove(entity);
		
	}

	@Override
	public TsscGame encontrarPorId(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(TsscGame.class, id);
	}

	@Override
	public List<TsscGame> findAll() {
		String resultado = "Select m FROM TsscGame m";
		return entityManager.createQuery(resultado).getResultList();
	}

	@Override
	public List<TsscGame> encontrarPorNameTopic(String name) {
		
		String quary = "SELECT m FROM TsscGame m "
				+ "where m.tsscTopic.name = :name";
		Query resultado = entityManager.createQuery(quary).setParameter("name", name);
		return resultado.getResultList();
		
	}

	@Override
	public List<TsscGame> encontrarPorDescriptionTopic(String description) {
		
		String quary = "SELECT m FROM TsscGame m "
				+ "where m.tsscTopic.description = :description";
		Query resultado = entityManager.createQuery(quary);
		resultado.setParameter("description", description);
		return resultado.getResultList();
		
	}

	@Override
	public List<TsscGame> encontrarPorIdTopic(long idTopic) {

		String quary = "Select m FROM TsscGame m "
				+ "where m.tsscTopic.id = :id";
		Query resultado = entityManager.createQuery(quary);
		resultado.setParameter("id", idTopic);
		return resultado.getResultList();
	}

	//1c) 
	
	@Override
	public List<TsscGame> encontrarPorDates(LocalDate date1, LocalDate date2) {

		String quary = "SELECT m FROM TsscGame m "
				+ "where m.scheduledDate between "
				+ ":date1 and :date2";
		Query resultado = entityManager.createQuery(quary);
		resultado.setParameter("date1", date1);
		resultado.setParameter("date2", date2);
		return resultado.getResultList();
	}

	@Override
	public List<TsscGame> encontrarPorDateHours(LocalDate date, LocalTime h1, LocalTime h2) {

		String quary = "SELECT m FROM TsscGame m"
				+ " where m.scheduledDate = :date "
				+ "and  m.scheduledTime"
				+ " between :h1 and :h2";
		Query resultado = entityManager.createQuery(quary);
		resultado.setParameter("date", date);
		resultado.setParameter("h1", h1);
		resultado.setParameter("h2", h2);
		return resultado.getResultList();
	}


	@Override
	public List<TsscGame> encontrarPorDateStoryTime(LocalDate date) {
		
		String quary = "SELECT m FROM TsscGame m "
				+ "where m.scheduledDate = :date "
				+ "and (size(m.tsscStories) < 10 "
				+ "or size(m.tsscTimecontrols)>0)";
		Query resultado = entityManager.createQuery(quary);
		resultado.setParameter("date", date);
		return resultado.getResultList();
	}
	

	@Override
	public boolean existsById(Long id) {
		TsscGame Game= entityManager.find(TsscGame.class, id);
		if(Game==null)
		{
			return false;
		}
		else {return true;}
		
	}


}
