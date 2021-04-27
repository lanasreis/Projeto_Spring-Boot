package com.orangetalents.orangetalents.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="O nome é obrigatório.")
    private String nome;

    @Column(unique = true)
    @NotEmpty(message="O email é obrigatório.")
    @Email(message = "O formato de email está inválido.")
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "O CPF é obrigatório.")
    @Size(min=11, max=11, message="O CPF deve possuir 11 numeros.")
    @CPF
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "Data futura, portanto inválida.")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date dtNascimento;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "usuario", orphanRemoval = true)
    private List<Endereco> enderecos;

    public Long getId() {
        return id;
    }

    public void addEnderecos(Endereco endereco){
        this.enderecos.add(endereco);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", enderecos=" + enderecos +
                '}';
    }
}
