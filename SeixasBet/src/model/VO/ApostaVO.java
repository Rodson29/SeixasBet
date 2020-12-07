package model.VO;

import javax.swing.JTextField;

public class ApostaVO {
	private int id;
	private double valor;
	private double valor1;
	private double valor2;
	private double valor3;
	private ClienteVO usuario;

	
	public ApostaVO() {
		super();
		
	}
	public ApostaVO(int id, double valor, double valor1, double valor2, double valor3,ClienteVO usuario) {
		super();
		this.id = id;
		this.valor = valor;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public ClienteVO getUsuario() {
		return usuario;
	}
	public void setUsuario(ClienteVO usuario) {
		this.usuario = usuario;
	}
	public double getValor1() {
		return valor1;
	}
	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}
	public double getValor2() {
		return valor2;
	}
	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}
	public double getValor3() {
		return valor3;
	}
	public void setValor3(double valor3) {
		this.valor3 = valor3;
	}
	@Override
	public String toString() {
		return "ApostaVO [id=" + id + ", valor=" + valor + ", valor1=" + valor1 + ", valor2=" + valor2 + ", valor3="
				+ valor3 + ", usuario=" + usuario + "]";
	}
	

}
