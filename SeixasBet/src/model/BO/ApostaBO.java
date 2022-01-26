package model.BO;

import java.util.ArrayList;

import model.DAO.ApostaDAO;
import model.VO.ApostaVO;

public class ApostaBO {

	public void cadastrarApostaBO(ApostaVO apostaVO) {
		  ApostaDAO apostaDAO = new ApostaDAO();
		  			apostaDAO.salvar(apostaVO);
		 
            
	}

	public boolean excluirApostaBO(ApostaVO apostaVO) {

		ApostaDAO apostaDAO = new ApostaDAO();
		return apostaDAO.excluir(apostaVO.getId());
	}
 
	public int atualizarApostaBO(ApostaVO apostaVO) {
		
		  ApostaDAO apostaDAO = new ApostaDAO();
                  ApostaVO aposta = null;
		  return apostaDAO.alterar(aposta);
	}

	public ApostaVO consultarApostasBO(ApostaVO apostaVO) {

		ApostaDAO apostaDAO = new ApostaDAO();
		apostaVO = apostaDAO.consultarPorId(apostaVO.getId());
		
		return apostaVO;
	}

	public java.util.ArrayList<ApostaVO> consultarApostaBO() {


		ApostaDAO petDAO = new ApostaDAO();

		ArrayList<ApostaVO> apostaVO = petDAO.consultarTodos();

		if (apostaVO.isEmpty()) {
			System.out.println("\n Lista de apostas est� vazia.");
		}

		return apostaVO;
	}

	public int salvar(ApostaVO novaAposta) {

		ApostaDAO dao = new ApostaDAO();
		return dao.salvar(novaAposta);
	}

	//public double atualizarValor() {
	//	ApostaDAO dao = new ApostaDAO();
	//	ApostaVO apostaVO = new ApostaVO();

//		return dao.atualizaValor(apostaVO);
	//}
	
//	public String validarAposta(Double saldo, double valor) {
	//	ApostaVO aposta = new ApostaVO();
	//	ApostaDAO dao = new ApostaDAO();
		//dao.validarAposta(aposta);
	//	saldo = 0.0;
	//	String mensagem = "";
		
	//	if(saldo > 0) {
			
	//		mensagem ="Aposta � v�lida";
	//	} else {
			
	//		mensagem = "Saldo insuficiente para apostar";
	//	}
		
	//	return mensagem;
//	}

	//private Double subtotal(Double val1, Double val2, Double val3, Double val4) {
	//	Double soma = val1 + val2 +val3 +val4;
	//	ApostaVO aposta = new ApostaVO();
	//	ApostaDAO controller = new ApostaDAO();
		//return soma;
	//}
}
