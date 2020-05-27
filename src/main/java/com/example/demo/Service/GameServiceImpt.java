package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAOS.GameDao;
import com.example.demo.Model.TsscAdmin;
import com.example.demo.Model.TsscGame;
import com.example.demo.Model.TsscStory;
import com.example.demo.Model.TsscTimecontrol;
import com.example.demo.Model.TsscTopic;

@Service
public class GameServiceImpt implements GameService {

	@Autowired
	private GameDao game;
	@Autowired
	private TopicServiceImpt repo;

	@Autowired
	public GameServiceImpt(GameDao game, TopicServiceImpt repo) {
		super();
		this.game = game;
		this.repo = repo;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscGame AnadirGameConTema(TsscGame gameOne, long ids) {
		if (gameOne.getNGroups() > 0 && gameOne.getNSprints() > 0) {
			TsscTopic encontrado = repo.findTopicById(ids);
			if (encontrado != null) {

				gameOne.setTsscTopic(encontrado);
				game.guardar(gameOne);
				encontrado.getTsscGames().add(gameOne);
				repo.actualizar(encontrado);
				return gameOne;
			}

			else {

				// game.save(gameOne);
				return null;
			}

		}

		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscGame AnadirGameSinTema(TsscGame gameOne) {
		if (gameOne != null && gameOne.getNGroups() > 0 && gameOne.getNSprints() > 0) {

			game.guardar(gameOne);

			return gameOne;
		}

		return null;

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscGame ActualizarGame(TsscGame gameOne, int Grupos, String name) {

		if (gameOne != null && Grupos > 0 && name != null && !name.equals("") && game.existsById(gameOne.getId())) {
			gameOne.setName(name);
			gameOne.setNGroups(Grupos);
			game.actualizar(gameOne);
			return gameOne;
		}

		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscGame AnadirGameJuego2(TsscGame gameOne, long id) {

		if (gameOne != null && gameOne.getNGroups() > 0 && gameOne.getNSprints() > 0) {
			TsscTopic encontrado = repo.findTopicById(id);

			if (encontrado != null) {

				gameOne.setTsscStories(encontrado.getTsscStories());
				gameOne.setTsscTimecontrol(encontrado.getTsscCronograma());
				gameOne.setTsscTopic(encontrado);

				game.guardar(gameOne);
				encontrado.getTsscGames().add(gameOne);
				repo.actualizar(encontrado);

				return gameOne;

			}

		}
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscGame findGameById(Long id) {

		try {
			TsscGame encontrado = game.encontrarPorId(id);
			return encontrado;

		}

		catch (Exception a) {
			return null;
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean existbyId(Long id) {
		return game.existsById(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscStory agregarStory(TsscGame game1, TsscStory Story) {
		// TODO Auto-generated method stub
		game1.addTsscStory(Story);
		game.actualizar(game1);
		return Story;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Iterable<TsscGame> findAlll() {
		// TODO Auto-generated method stub
		return game.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void eliminarGame(TsscGame juego) {

		for (int i = 0; i < juego.getTsscGameAdmins().size(); i++) {
			TsscAdmin ecnontrado = juego.getTsscGameAdmins().get(i).getTsscAdmin();
			for (int j = 0; j < ecnontrado.getTsscGameAdmins().size(); j++) {

				if (ecnontrado.getTsscGameAdmins().get(j).getTsscGame().getName().equals(juego.getName())) {
					ecnontrado.getTsscGameAdmins().get(j).setTsscGame(null);
				}
			}
			juego.getTsscGameAdmins().set(i, null);

		}

		for (int i = 0; i < juego.getTsscTimecontrols().size(); i++) {

			TsscTimecontrol encontrado = juego.getTsscTimecontrols().get(i);
			encontrado.setTsscGame(juego);

		}
		juego.setTsscTimecontrol(null);

		game.eliminar(juego);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void actualizarGameDato(TsscGame game3) {
		game.actualizar(game3);

	}

//
//	@Autowired
//	private GameRepository game;
//	@Autowired
//	private TopicServiceImpt repo;
//
//	@Autowired
//	public GameServiceImpt(GameRepository game, TopicServiceImpt repo) {
//		super();
//		this.game = game;
//		this.repo = repo;
//	}
//
//	@Override
//	public TsscGame AnadirGameConTema(TsscGame gameOne, long ids) {
//		if (gameOne.getNGroups() > 0 && gameOne.getNSprints() > 0) {
//			TsscTopic encontrado = repo.findTopicById(ids);
//			if (encontrado != null) {
//
//				gameOne.setTsscTopic(encontrado);
//				game.save(gameOne);
//				return gameOne;
//			}
//
//			else {
//
//			//	game.save(gameOne);
//				return null;
//			}
//
//		}
//
//		return null;
//	}
//
//	@Override
//	public TsscGame AnadirGameSinTema(TsscGame gameOne) {
//		if (gameOne!=null&&gameOne.getNGroups() > 0 && gameOne.getNSprints() > 0) {
//
//			game.save(gameOne);
//			return gameOne;
//		}
//
//		return null;
//
//	}
//
//	@Override
//	public TsscGame ActualizarGame(TsscGame gameOne, int Grupos, String name) {
//
//		if (gameOne != null && Grupos > 0 && name != null && !name.equals("")&&game.existsById(gameOne.getId())) {
//			gameOne.setName(name);
//			gameOne.setNGroups(Grupos);
//			game.save(gameOne);
//			return gameOne;
//		}
//
//		return null;
//	}
//
//	@Override
//	public TsscGame AnadirGameJuego2(TsscGame gameOne, long id) {
//
//		if (gameOne!=null&&gameOne.getNGroups() > 0 && gameOne.getNSprints() > 0) {
//			TsscTopic encontrado = repo.findTopicById(id);
//
//			if (encontrado != null) {
//
//				gameOne.setTsscStories(encontrado.getTsscStories());
//				gameOne.setTsscTimecontrol(encontrado.getTsscCronograma());
//				gameOne.setTsscTopic(encontrado);
//				game.save(gameOne);
//				return gameOne;
//
//			}
//
//		}
//		return null;
//	}
//
//	@Override
//	public TsscGame findGameById(Long id) {
//
//		try {
//			TsscGame encontrado = game.findById(id).get();
//			return encontrado;
//
//		}
//
//		catch (Exception a) {
//			return null;
//		}
//
//	}
//	
//
//	
//	
//	
//	@Override
//	public boolean existbyId(Long id)
//	{
//		return game.existsById(id);
//	}
//
//	@Override
//	public TsscStory agregarStory(TsscGame game, TsscStory Story) {
//		// TODO Auto-generated method stub
//		return game.addTsscStory(Story);
//	}
//
//	@Override
//	public Iterable<TsscGame> findAlll() {
//		// TODO Auto-generated method stub
//		return game.findAll();
//	}
//
//	@Override
//	public void eliminarGame(TsscGame juego) {
//		game.delete(juego);
//		
//		
//	}

}
