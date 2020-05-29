package com.example.demo.Service;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.TimeControllerDao;
import com.example.demo.DAOS.TopicDao;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

@Service
public class TimeControlServiceImpt implements TimeControlService {

	@Autowired
	private TimeControllerDao dao;
	
	@Autowired
	public TimeControlServiceImpt(TimeControllerDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscTimecontrol AnadirTimeControl(TsscTimecontrol time) {
	
	
		return dao.save(time);
		

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscTimecontrol ActualizarTimeControl(TsscTimecontrol time) {
		// TODO Auto-generated method stub
		return dao.merge(time);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public TsscTimecontrol findTimeById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public boolean existeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Iterable<TsscTimecontrol> findAlll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void eliminarTime(TsscTimecontrol time) {
		dao.delete(time);
		
	}

}
