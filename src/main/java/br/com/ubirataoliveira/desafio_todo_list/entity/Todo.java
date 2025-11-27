package br.com.ubirataoliveira.desafio_todo_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // O uso do Long se dá pois é um tipo objeto da Wrapper Class que pode ser nulo, e aceita valores maiores que o int primitivo.
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;
    @NotBlank(message = "A descrição não pode ser vazia")
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Todo(String descricao, String nome, int prioridade, boolean realizado) {
        this.descricao = descricao;
        this.nome = nome;
        this.prioridade = prioridade;
        this.realizado = realizado;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }


}
