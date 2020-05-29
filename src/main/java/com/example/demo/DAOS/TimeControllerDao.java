package com.example.demo.DAOS;

import java.util.List;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

public interface TimeControllerDao {
	
	public TsscTimecontrol save(TsscTimecontrol  entity);
	public TsscTimecontrol  merge(TsscTimecontrol  entity);
	public List<TsscTimecontrol> findAll();
	public void delete(TsscTimecontrol  entity);
	public TsscTimecontrol  findById(long id);

}
