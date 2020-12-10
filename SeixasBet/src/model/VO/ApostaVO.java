package model.VO;

public class ApostaVO {
	
	
	private int id;
	private double valor1;
	private double valor2;
	private double valor3;
	private double valor4;
	private ClienteVO usuario;

	
	public ApostaVO() {
		super();
		
	}
	public ApostaVO(int id, double valor1, double valor2, double valor3, double valor4,ClienteVO usuario) {
		super();
		this.id = id;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getValor4() {
		return valor4;
	}
	public void setValor4(double valor4) {
		this.valor4 = valor4;
	}
	public ClienteVO getUsuario() {
		return usuario;
	}
	public void setUsuario(ClienteVO usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "ApostaVO [id=" + id + ", valor1=" + valor1 + ", valor2=" + valor2 + ", valor3=" + valor3 + ", valor4="
				+ valor4 + ", usuario=" + usuario + "]";
	}

}
