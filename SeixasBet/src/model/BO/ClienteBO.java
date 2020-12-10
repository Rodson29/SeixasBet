package model.BO;

 

import java.util.ArrayList;
import model.DAO.ClienteDAO;
import model.VO.ClienteVO;

 

public class ClienteBO {
    ClienteDAO dao = new ClienteDAO();

 

    public String salvar(ClienteVO cliente) {
        String msg = "";
        int resultado = 0;
        ClienteDAO dao = new ClienteDAO();
        if (dao.consultarCpfCliente(cliente.getCpf())) {
            msg += ("Este cpf ja foi utilizado ");
        } else {
            resultado = dao.salvar(cliente);
        }
        if (resultado > -1) {
            msg += ("Cliente cadastrado com sucesso.");
        } else {

 

        }
        System.out.println(resultado);
        return msg;
    }

 
    public ClienteVO consultarPorID(int pClienteId) {
    	
    	return dao.consultarPorId(pClienteId);
    }
    public ArrayList<ClienteVO> consultarTodos() {

 

        return dao.consultarTodos();
    }

 

    public String excluir(ClienteVO clienteSelecionado) {
        String mensagem = "";

 

        if (dao.excluir(clienteSelecionado.getId())) {
            mensagem = "Cliente Excluido com sucesso";
        } else {
            mensagem = "Erro ao excluir Cliente,";
                    
        }

 

        return mensagem;
    }

   
 

}
