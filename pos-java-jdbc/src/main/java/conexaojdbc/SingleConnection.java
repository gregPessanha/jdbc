package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection { /* CLASSE DE CONEXÃO COM O BANCO DE DADOS;  1º PASSO*/

	private static String url = "jdbc:postgresql://localhost:5432/posjava"; 
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;

	static {
		conectar();
	}

	private static void conectar() {
		try {
			
			if (connection == null) { /* SE A CONEXÃO FOR NULA, OU SEJA, NÃO TIVER CONEXÃO, CONECTA */
				Class.forName("org.postgresql.Driver"); /* CARREGAMENTO DO DRIVER QUE SERÁ USADO; */
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false); /* NÃO SALVA AUTOMATICAMENTE; */
				System.out.println("Conexão bem-Sucedida");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SingleConnection() { /* CONSTRUTOR QUE CHAMA O MÉTODO CONECTAR */
		conectar();
	}
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	
	
}
