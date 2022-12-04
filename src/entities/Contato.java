package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contato {
	
	private String name;
	private Endereco endereco;
	private Date dataNascimento;
	private String email;
	private Integer telefone;
	private String cpf;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Contato () {
		
	}

	public Contato(String name, Endereco endereco, Date dataNascimento, String email, Integer telefone, String cpf) {
		this.name = name;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		
		return "\nNome : " + name + 
			   " Endereco : " + endereco.getRua() + " " + endereco.getCidade() + " " + endereco.getEstado() +  
			   " Dt Nascimento: " + sdf.format(dataNascimento) + 
			   " Email : " + email +
			   " Fone : " + telefone + 
			   " CPF  : " + cpf + "\n";
	}
	
	
	

}
