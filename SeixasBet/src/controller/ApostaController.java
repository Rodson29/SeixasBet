package controller;

import java.util.ArrayList;

import model.BO.ApostaBO;
import model.VO.ApostaVO;

public class ApostaController {

	public String validarCamposSalvar(String valorDigitado1, String valorDigitado2, String valorDigitado3, String valorDigitado4) {

		String mensagem = "";

		if (valorDigitado1.isEmpty() || valorDigitado1.length() < 0.0) {
			mensagem += "Digite um valor maior que zero";
		}
		if (valorDigitado2.isEmpty() || valorDigitado2.length() < 0.0) {
			mensagem += "Digite um valor maior que zero";
		}
		if (valorDigitado3.isEmpty() || valorDigitado3.length() < 0.0) {
			mensagem += "Digite um valor maior que zero";
		}
		if (valorDigitado4.isEmpty() || valorDigitado4.length() < 0.0) {
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


	public ArrayList<ApostaVO> consultarTodasApostasController() {
		ApostaBO apostaBO = new ApostaBO();
		return apostaBO.consultarApostaBO();
	}

	public ApostaVO consultarApostaController(ApostaVO apostaVO) {
		ApostaBO apostaBO = new ApostaBO();
		return apostaBO.consultarApostasBO(apostaVO);
	}



}
