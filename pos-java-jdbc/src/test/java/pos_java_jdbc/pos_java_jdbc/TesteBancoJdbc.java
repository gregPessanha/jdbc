package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initiBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();

		/* SETANDO O OBJETO COM OS DADOS */
		userposjava.setNome("Reinilda Pinto");
		userposjava.setEmail("reinilda.pinto@hotmail.com");

		userPosDao.salvar(userposjava);
	}

	@Test
	public void initiListar() {
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava.toString());
				System.out.println("____________________________________________________________________________");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();

		try {
			Userposjava userposjava = dao.buscar(5L);
			System.out.println(userposjava);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initiUpdate() {
		try {
			UserPosDao dao = new UserPosDao();
			Userposjava objetoBanco = dao.buscar(10L);
			objetoBanco.setNome("Carlos Gregório");
			objetoBanco.setEmail("carlosgregoriopessanha@live.com");
			dao.update(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initiDelete() {
		try {

			UserPosDao dao = new UserPosDao();
			dao.delete(11L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(81) 998765432,");
		telefone.setTipo("celular");
		telefone.setUsuario(10L);

		UserPosDao userPosDao = new UserPosDao();
		userPosDao.salvarTelefone(telefone);

	}

	@Test
	public void testeCarregaFonesUser() {
		UserPosDao dao = new UserPosDao();

		try {
			List<BeanUserFone> beanUserFones = dao.listaUserFone(10L);

			for (BeanUserFone beanUserFone : beanUserFones) {
				System.out.println(beanUserFone.toString());
				System.out.println("---------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testeDeleteUserFone() {
		UserPosDao dao = new UserPosDao();
		dao.deleteFonesPorUsuarios(1L);
	}
}
