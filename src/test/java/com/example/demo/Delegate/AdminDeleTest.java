package com.example.demo.Delegate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Delagate.AdminDelegate;
import com.example.demo.Delagate.TopicDelegateImpt;
import com.example.demo.Model.TsscAdmin;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AdminDeleTest {

	
	
		
	    final String SERVER="http://localhost:8080/";
		
		@Mock
		private RestTemplate restTemplate;


		
		@InjectMocks
		private AdminDelegate AdminServiceImp;


	    @Autowired
		public AdminDeleTest(AdminDelegate adminServiceImp) {
			super();
			AdminServiceImp = adminServiceImp;
		}
		
	    @Test
		void TestAgregarAdmin() {

			TsscAdmin administrador = new TsscAdmin();
			administrador.setPassword("{noop}123456");
			administrador.setUsername("admin");
			administrador.setSuperAdmin("admin");
			when(restTemplate.postForObject(SERVER + "api/Admins", administrador, TsscAdmin.class)).thenReturn(administrador);
			assertNotNull(AdminServiceImp.guardar(administrador));

		}

		@Test
		public void TestActualizarAdmin() {


			TsscAdmin administrador = new TsscAdmin();
			administrador.setPassword("{noop}123456");
			administrador.setUsername("admin");
			administrador.setSuperAdmin("admin");
			when(restTemplate.postForObject(SERVER + "api/Admins", administrador, TsscAdmin.class)).thenReturn(administrador);
			assertNotNull(AdminServiceImp.guardar(administrador));
			administrador.setUsername("Miguel");
			AdminServiceImp.actualizar(administrador);
			when(restTemplate.getForObject(SERVER+"api/Admins/" + administrador.getId(), TsscAdmin.class)).thenReturn(administrador);
			assertEquals(AdminServiceImp.findById(administrador.getId()).getUsername(), "Miguel");


		}


		@Test
		public void TestEliminarAdmin() {
			
	
			TsscAdmin administrador = new TsscAdmin();
			administrador.setPassword("{noop}123456");
			administrador.setUsername("admin");
			administrador.setSuperAdmin("admin");
	
			
			when(restTemplate.postForObject(SERVER + "api/Admins", administrador, TsscAdmin.class)).thenReturn(administrador);
			assertNotNull(AdminServiceImp.guardar(administrador));
			
			restTemplate.delete(SERVER+"api/Admins/" + administrador.getId());
			
			when(restTemplate.getForObject(SERVER+"api/Admins/" + administrador.getId(), TsscAdmin.class)).thenReturn(null);
			assertNull(AdminServiceImp.findById(administrador.getId()));
	
		}

		@Test
		public void TestFindById() {
	
	
			TsscAdmin administrador = new TsscAdmin();
			administrador.setPassword("{noop}123456");
			administrador.setUsername("admin");
			administrador.setSuperAdmin("admin");		
			when(restTemplate.postForObject(SERVER + "api/Admins", administrador, TsscAdmin.class)).thenReturn(administrador);
			assertNotNull(AdminServiceImp.guardar(administrador));		
			when(restTemplate.getForObject(SERVER+"api/Admins/" + administrador.getId(), TsscAdmin.class)).thenReturn(administrador);
			assertNotNull(AdminServiceImp.findById(administrador.getId()));
	
		}
	

	}
