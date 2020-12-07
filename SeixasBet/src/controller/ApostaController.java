package controller;

import java.util.ArrayList;

import model.BO.ApostaBO;
import model.VO.ApostaVO;

public class ApostaController {

	public String validarCamposSalvar(String valorDigitado) {

		String mensagem = "";

		if (valorDigitado.isEmpty() || valorDigitado.length() < 0.0) {
			mensagem += "Digite um valor maior que zero";
		}

		return mensagem;

	}

	public static int salva(ApostaVO novaAposta) {
		ApostaBO bo = new ApostaBO();
		return bo.salvar(novaAposta);

	}

	public void cadastrarApostaController(ApostaVO apostaVO) {
		ApostaBO apostaBO = new ApostaBO();
		apostaBO.cadastrarApostaBO(apostaVO);
	}

	public boolean excluirApostaController(ApostaVO apostaVO) {
		ApostaBO apostaBO = new ApostaBO();
		return apostaBO.excluirApostaBO(apostaVO);
	}

//	public void atualizarApostaController(ApostaVO apostaVO) {
		//ApostaBO apostaBO = new ApostaBO();
		//apostaBO.atualizarApostaBO(apostaVO);
	//}

	public ArrayList<ApostaVO> consultarTodasApostasController() {
		ApostaBO apostaBO = new ApostaBO();
		return apostaBO.consultarApostaBO();
	}

	public ApostaVO consultarApostaController(ApostaVO apostaVO) {
		ApostaBO apostaBO = new ApostaBO();
		return apostaBO.consultarApostasBO(apostaVO);
	}

//	public String atualizarValor() {
		//double valorAtualizado = 0;
	//	String mensagem = "";
	//ApostaBO bo = new ApostaBO();
		//valorAtualizado = bo.atualizarValor();
		
	//	if(valorAtualizado == 0.0) {
			
		//	mensagem ="0";
			
	//	}else {
		//	mensagem = String.valueOf(valorAtualizado);
			
	//	}
		
	//	return mensagem;
//	}
	public double subtotal(Double val1, Double val2, Double val3, Double val4) {
		Double soma = val1 + val2 +val3 +val4;
		ApostaVO aposta = new ApostaVO();
		ApostaBO controller = new ApostaBO();
		return soma;
	}

	public String validarAposta(String valorDigitado) {
		// TODO Auto-generated method stub
		return null;
	}

}
