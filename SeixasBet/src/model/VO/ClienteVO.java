package model.VO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteVO {
	
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dt_nascimento;
	private double valor_depositado;
	
	
	public ClienteVO() {
		super();
	
	}
	public ClienteVO(int id, String nome, String cpf, String telefone, LocalDate dt_nascimento, double valor_depositado) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nascimento = dt_nascimento;
		this.valor_depositado = valor_depositado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public double getValor_depositado() {
		return valor_depositado;
	}
	public void setValor_depositado(double valor_depositado) {
		this.valor_depositado = valor_depositado;
	}
	
	public DateTimeFormatter getFormataDate() {
		return formataDate;
	}
	public void setFormataDate(DateTimeFormatter formataDate) {
		this.formataDate = formataDate;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "UsuarioVO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dt_nascimento=" + dt_nascimento
				+ ", valor_depositado=" + valor_depositado + "]";
	}
	

}
