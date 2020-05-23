package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TsscStory;
import com.example.demo.Service.StoryService;

@RestController
public class StoryGameRestController implements StoryController{
	
	@Autowired
	private StoryService service;

	@Override
	@PostMapping("/api/games/{id}")
	public TsscStory AnadirStory(@RequestBody TsscStory Story, @PathVariable long id) {
		// TODO Auto-generated method stub
		return service.AnadirStory(Story, id);
	}

	@Override
	@PatchMapping("/api/stories")
	public TsscStory ActualizarStory(@RequestBody TsscStory Story) {
		// TODO Auto-generated method stub
		return service.ActualizarStory(Story, Story.getDescription(), Story.getAltDescripton());
	}

	@Override
	@GetMapping("/api/stories/{id}")
	public TsscStory findStoryById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return service.findStoryById(id);
	}

//	@Override
//	@GetMapping("/api/stories/{id}")
//	public boolean existbyId(@PathVariable long id) {
//		// TODO Auto-generated method stub
//		return service.existbyId(id);
//	}

	@Override
	@GetMapping("/api/stories")
	public Iterable<TsscStory> findAlll() {
		// TODO Auto-generated method stub
		return service.findAlll();
	}

	@Override
	@DeleteMapping("/api/stories/{id}")
	public TsscStory eliminarStory(@PathVariable long id) {
		
		TsscStory encontrado=service.findStoryById(id);
		// TODO Auto-generated method stub
		service.eliminarStory(encontrado);
		return encontrado;
	}

}
