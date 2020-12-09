package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.VO.ApostaVO;
import model.VO.ClienteVO;


public class ApostaDAO implements Base<ApostaVO> {

	DateTimeFormatter formataDate2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	@Override
	public int salvar(ApostaVO novaAposta) {

		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		String query = "INSERT INTO aposta (valor,idusuario) " + " VALUES ('" + novaAposta.getValor1() +
				"','" + novaAposta.getValor2() +
				"','" + novaAposta.getValor3() +
				"','" + novaAposta.getValor4() +
				+ novaAposta.getUsuario().getId() + "')";
		
//		String query = "INSERT INTO aposta (valor, dt_aposta, idusuario) " + " VALUES ('" 
//				+ "','" + novaAposta.getValor1() + "','"
//				+ novaAposta.getUsuario().getId() + "')";

		int resultado = 0;
		try {

			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de cadastro da aposta");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return resultado;

	}

	@Override
	public boolean excluir(int id) {

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM APOSTA WHERE id = " + id;
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclus�o da aposta.");
			System.out.println("Erro: " + e.getMessage());
		}

		return (resultado > 0);
	}

	@Override
	public int alterar(ApostaVO aposta) {

		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		int resultado = 0;

		String query = "UPDATE  aposta SET idaposta = " + aposta.getId() + ", idusuario = "
				+ aposta.getUsuario().getId() + "', valor = "
				+ aposta.getValor1() + ",'WHERE idaposta = " + aposta.getId();

		try {

			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de atualiza��o de aposta");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return resultado;
	}

	@Override
	public ApostaVO consultarPorId(int id) {
		
		ApostaVO aposta = new ApostaVO();

		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;

		String query = "SELECT idaposta FROM aposta WHERE idaposta = '" + id + "'";

		try {

			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return aposta;

			}
		} catch (SQLException e) {

			System.out.println("Erro ao executar a query que verifica a exist�ncia de uma aposta por Id");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return aposta;
	}

	@Override
	public ArrayList<ApostaVO> consultarTodos() {

		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;

		ArrayList<ApostaVO> apostasVO = new ArrayList<ApostaVO>();

		String query = "SELECT * FROM aposta";

		try {

			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				ApostaVO apostaVO = new ApostaVO();

				apostaVO.setId(resultado.getInt(1));
				apostaVO.setValor1(resultado.getDouble(2));

				ClienteDAO usuario = new ClienteDAO();
				ClienteVO user = usuario.consultarPorId(resultado.getInt("id"));

				apostaVO.setUsuario(user);

				apostasVO.add(apostaVO);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de consulta de todas as Receitas");
			System.out.println("Erro:   " + e.getMessage());
		} finally {

			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return apostasVO;
	}

	//public double atualizaValor(ApostaVO apostaVO) {
		
	//	Connection conn = Banco.getConnection();

	//	Statement stmt = Banco.getStatement(conn);

	//	ResultSet resultado = null;
		
	//	String query = "SELECT VALOR FROM APOSTA WHERE VALOR = ?";
		
	//	try {

		//	resultado = stmt.executeQuery(query);

	//	} catch (SQLException e) {

		//	System.out.println("Erro ao executar a query de atualiza��o da aposta");
		//	System.out.println("Erro: " + e.getMessage());

//		} finally {

	//		Banco.closeStatement(stmt);
		//	Banco.closeConnection(conn);

		//}

	//	return 0;
//	}

//	private double subtotal(Double soma) {
		
	//	Connection conn = Banco.getConnection();

	//	Statement stmt = Banco.getStatement(conn);
	//	ResultSet resultado = null;
	//	String query ="SELECT SUM(VALOR) FROM APOSTA";
	//	try {

		//	resultado = stmt.executeQuery(query);

	//	} catch (SQLException e) {
//
	//		System.out.println("Erro ao executar a query de soma da aposta");
	//		System.out.println("Erro: " + e.getMessage());

	//	} finally {

	//		Banco.closeStatement(stmt);
		//	Banco.closeConnection(conn);

		//}

		//return soma;
//	}

	
}
