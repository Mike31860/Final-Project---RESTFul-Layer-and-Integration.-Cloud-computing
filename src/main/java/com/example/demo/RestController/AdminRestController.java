package com.example.demo.RestController;

import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscTopic;

public interface AdminRestController {
	
	public TsscAdmin AnadirAdmin(TsscAdmin admin);
	public TsscAdmin findAdminById(long id); 
	public Iterable<TsscAdmin> findAlll();
	public void actualizar(TsscAdmin topic);
	public TsscAdmin eliminarAdmin(long id);
	

}
