package com.orangetalents.orangetalents.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotEmpty(message = "O logradouro é obrigatório.")
    public String logradouro;

    @NotNull(message = "O número é obrigatório")
    public long numero;

    public String complemento;

    @NotEmpty(message = "O bairro é obrigatório.")
    public String bairro;

    @NotEmpty(message = "A cidade é obrigatória.")
    public String cidade;

    @NotEmpty(message = "O Estado é obrigatório")
    public String estado;

    @NotEmpty(message = "O CEP é obrigatório.")
    public String cep;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
/*
    public Usuario getUsuario() {
        return usuario;
    }*/

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
