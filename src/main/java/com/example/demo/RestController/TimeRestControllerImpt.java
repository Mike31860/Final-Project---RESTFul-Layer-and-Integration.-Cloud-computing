package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.TimeControlServiceImpt;
import com.example.demo.Service.TopicService;

@RestController
public class TimeRestControllerImpt implements TimeRestController{


	@Autowired
	private TimeControlServiceImpt service;
	
	@Override
	@PostMapping("/api/times")
	public TsscTimecontrol AnadirTimeControl( @RequestBody TsscTimecontrol Time) {
		// TODO Auto-generated method stub
		return service.AnadirTimeControl(Time);
	}

	@Override
	@GetMapping("/api/times/{id}")
	public TsscTimecontrol findTimeControlById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return service.findTimeById(id);
	}

	@Override
	@GetMapping("/api/times")
	public Iterable<TsscTimecontrol> findAlll() {
		// TODO Auto-generated method stub
		return service.findAlll();
	}

	@Override
	@PutMapping("/api/times")
	public void actualizar(@RequestBody TsscTimecontrol time) {
		// TODO Auto-generated method stub
		service.ActualizarTimeControl(time);
	}

	@Override
	@DeleteMapping("/api/times/{id}")
	public TsscTimecontrol eliminarTimeControl(@PathVariable long id) {
		// TODO Auto-generated method stub
		TsscTimecontrol encontrado=service.findTimeById(id);
		service.eliminarTime(encontrado);
		return encontrado;
	}

}
