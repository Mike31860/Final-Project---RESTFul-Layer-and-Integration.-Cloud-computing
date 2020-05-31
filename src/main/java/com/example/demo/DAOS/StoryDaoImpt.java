package com.example.demo.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTopic;

@Repository
@Scope("singleton")
public class StoryDaoImpt implements StoryDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TsscStory guardar(TsscStory entity) {
	   entityManager.persist(entity);
	//entityManager.merge(entity);
		return entity;
	}

	@Override
	public TsscStory actualizar(TsscStory entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void eliminar(TsscStory entity) {
		entityManager.remove(entity);
		
		
	}

	@Override
	public TsscStory encontrarPorId(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(TsscStory.class, id);
	}

	@Override
	public List<TsscStory> findAll() {
		String resultado = "Select m FROM TsscStory m";
		return entityManager.createQuery(resultado).getResultList();
	}


	@Override
	public boolean existsById(Long id) {
		TsscStory story= entityManager.find(TsscStory.class, id);
		if(story==null)
		{
			return false;
		}
		else {return true;}
		
	}
	
	

}
