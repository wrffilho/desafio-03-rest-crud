package dto;

import java.time.LocalDate;

import com.devsuperior.desafio.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class ClientDTO {

	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String name;

	/*@CPF(message = "CPF inválido")
	@NotNull(message = "CPF é obrigatório")
	@Size(min = 11, max = 11, message = "CPF deve ter exatamente 11 dígitos")*/
	@NotBlank(message = "Campo requirido")
	private String cpf;

	private Double income;

	@PastOrPresent(message = "Data inválida: a data não pode ser maior que hoje")
	private LocalDate birthDate;

	private Integer children;

	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.income = client.getIncome();
		this.birthDate = client.getBirthDate();
		this.children = client.getChildren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

}
