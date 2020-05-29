package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.TimeControlServiceImpt;
import com.example.demo.Service.TopicService;

public class TimeRestControllerImpt implements TimeRestController{


	@Autowired
	private TimeControlServiceImpt service;
	
	@Override
	@PostMapping("/api/times")
	public TsscTimecontrol AnadirTimeControl(TsscTimecontrol Time) {
		// TODO Auto-generated method stub
		return service.AnadirTimeControl(Time);
	}

	@Override
	@GetMapping("/api/topics/{id}")
	public TsscTimecontrol findTimeControlById(long id) {
		// TODO Auto-generated method stub
		return service.findTimeById(id);
	}

	@Override
	public Iterable<TsscTimecontrol> findAlll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PatchMapping("/api/times")
	public void actualizar(TsscTimecontrol time) {
		// TODO Auto-generated method stub
		service.ActualizarTimeControl(time);
	}

	@Override
	@DeleteMapping("/api/times/{id}")
	public TsscTimecontrol eliminarTimeControl(long id) {
		// TODO Auto-generated method stub
		TsscTimecontrol encontrado=service.findTimeById(id);
		service.eliminarTime(encontrado);
		return encontrado;
	}

}
