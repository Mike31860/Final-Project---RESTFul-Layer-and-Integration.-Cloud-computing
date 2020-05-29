package com.example.demo.Service;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DAOS.TimeControllerDao;
import com.example.demo.DAOS.TopicDao;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

public class TimeControlServiceImpt implements TimeControlService {

	@Autowired
	private TimeControllerDao dao;
	
	public TimeControlServiceImpt(TimeControllerDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public TsscTimecontrol AnadirTimeControl(TsscTimecontrol time) {
		
		TsscTimecontrol as = null;

		if (time!=null&&!time.getName().equals("") && time.getTsscGame()!=null) {
			dao.save(as);
			as = time;
		}

		return as;
		

	}

	@Override
	public TsscTimecontrol ActualizarTimeControl(TsscTimecontrol time) {
		// TODO Auto-generated method stub
		return dao.merge(time);
	}

	@Override
	public TsscTimecontrol findTimeById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public boolean existeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<TsscTimecontrol> findAlll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}



	@Override
	public void eliminarTime(TsscTimecontrol time) {
		dao.delete(time);
		
	}

}
