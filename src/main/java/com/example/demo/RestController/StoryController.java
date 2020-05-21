package com.example.demo.RestController;

import com.example.demo.Model.TsscStory;

public interface StoryController {

	public TsscStory AnadirStory(TsscStory Story, long id);
	public TsscStory ActualizarStory(TsscStory Story);
	public TsscStory findStoryById(long id);
	public boolean existbyId(long id);
	
	public Iterable<TsscStory> findAlll();
	public void eliminarStory(long id);
}
