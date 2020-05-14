package com.example.demo.DAOS;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTimecontrol;

public interface TimeControllerDao {
	
	public TsscTimecontrol save(TsscTimecontrol  entity);
	public TsscTimecontrol  merge(TsscTimecontrol  entity);
	public void delete(TsscTimecontrol  entity);
	public TsscTimecontrol  findById(long id);

}
