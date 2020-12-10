package model.DAO;

 

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.VO.ClienteVO;

 

public class ClienteDAO {

 

    public int salvar(ClienteVO cliente) {
        Connection conn = Banco.getConnection();
        String sql = "INSERT INTO CLIENTE (NOME,TELEFONE,CPF ,DT_NASCIMENTO,VALOR) VALUES (?,?,?,?,?)";
        PreparedStatement Prepstmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
        int resultado = 0;
        try {
            Prepstmt.setString(1, cliente.getNome());            
            Prepstmt.setString(2, cliente.getTelefone());
            Prepstmt.setString(3, cliente.getCpf());
            Prepstmt.setDate(4, Date.valueOf(cliente.getDt_nascimento()));
            Prepstmt.setDouble(5, cliente.getValor_depositado());
            
            
            Prepstmt.execute();
            ResultSet rs = Prepstmt.getGeneratedKeys();
        
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                cliente.setId(idGerado);
            }
        } catch (SQLException e) {
            System.out.println("nao foi possivel salvar cliente no banco");
            System.out.println("Erro  " + e);
        } finally {
            Banco.closePreparedStatement(Prepstmt);
            Banco.closeConnection(conn);

 

        }
        
        return resultado;
    }

 

    public ArrayList<ClienteVO> consultarTodos() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet result = null;
        String sql = "SELECT * FROM USUARIO ORDER BY NOME ASC";
        ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();

 

        try {
            result = stmt.executeQuery(sql);

 

            while (result.next()) {
                ClienteVO cliente = construirDoResultSet(result);
                clientes.add(cliente);
            }

 

        } catch (SQLException e) {
            System.out.println("Erro ao Consultar Cliente");
            System.out.println("Erro " + e);
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);

 

        }

 

        return clientes;

 

    }

 

    private ClienteVO construirDoResultSet(ResultSet result) {
        ClienteVO novoCliente = new ClienteVO();
        try {
            novoCliente.setId(result.getInt("IDUSUARIO"));
            novoCliente.setNome(result.getString("NOME"));                       
            novoCliente.setCpf(result.getString("CPF"));
//            novoCliente.setDt_nascimento(result.getDate("DT_NASCIMENTO").toLocalDate());
            novoCliente.setValor_depositado(result.getDouble("VALOR"));
        } catch (SQLException e) {
            System.out.println("Erro ao construir a partir Do ResultSet. Causa: " + e.getMessage());
        }
        return novoCliente;
    }

 

    public ClienteVO consultarPorId(int idCliente) {
        Connection conexao = Banco.getConnection();
        String sql = " SELECT * FROM USUARIO WHERE IDUSUARIO=?";
        ResultSet resultadoDaConsulta = null;
        PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, idCliente);
        ClienteVO clienteSelecionado = null;
        try {
            stmt.setInt(1, idCliente);
            resultadoDaConsulta = stmt.executeQuery();

 

            if (resultadoDaConsulta.next()) {
                clienteSelecionado = construirDoResultSet(resultadoDaConsulta);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar profissional por id: " + idCliente);
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultadoDaConsulta);
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conexao);
        }

 

        return clienteSelecionado;

 

    }

 

    public boolean excluir(int id) {
        Connection conexao = Banco.getConnection();
        Statement statement = Banco.getStatement(conexao);
        String sql = " DELETE FROM USUARIO WHERE IDUSUARIO = " + id;

 

        int quantidadeRegistrosExcluidos = 0;
        try {
            quantidadeRegistrosExcluidos = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Cliente. ");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(statement);
            Banco.closeConnection(conexao);
        }

 

        return quantidadeRegistrosExcluidos > 0;
    }

 

    public boolean consultarCpfCliente(String cpfdigitado) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet result = null;
        String sql = "SELECT CPF FROM USUARIO WHERE CPF = " + "'" + cpfdigitado + "'";
        try {
            result = stmt.executeQuery(sql);
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar Cpf");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(result);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);

 

        }
        System.out.println(sql);
    
        return false;
    }

 

}













