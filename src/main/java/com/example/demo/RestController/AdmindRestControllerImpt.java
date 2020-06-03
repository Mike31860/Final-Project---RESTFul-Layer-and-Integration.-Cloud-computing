package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscConsulta2;
import com.example.demo.Model.TsscTopic;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.TopicService;


@RestController
public class AdmindRestControllerImpt implements AdminRestController{

	
	@Autowired
	private AdminService service;
	
	@Override
	@PostMapping("/api/Admins")
	public TsscAdmin AnadirAdmin(TsscAdmin admin) {
		// TODO Auto-generated method stub
		return service.agregar(admin);
	}

	@Override
	@GetMapping("/api/Admins/{id}")
	public TsscAdmin findAdminById(long id) {
		// TODO Auto-generated method stub
		return service.findById(id);
	}

	@Override
	@GetMapping("/api/Admins")
	public Iterable<TsscAdmin> findAlll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	@PutMapping("/api/Admins")
	public void actualizar(TsscAdmin admin) {
		// TODO Auto-generated method stub
		service.editar(admin);
	}

	@Override
	@DeleteMapping("/api/Admins/{id}")
	public TsscAdmin eliminarAdmin(@PathVariable long id) {
		TsscAdmin encontrado=service.findById(id);
		service.eliminar(encontrado);;
		return encontrado;
	}
	

	

}
