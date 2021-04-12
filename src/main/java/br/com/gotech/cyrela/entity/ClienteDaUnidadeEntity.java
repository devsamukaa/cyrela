package br.com.gotech.cyrela.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_cliente_da_unidade")
public class ClienteDaUnidadeEntity implements Serializable {

    @Id
    @Column(name = "pjo_cliente_da_unidade_id")
    @SequenceGenerator(name = "cliente_da_unidade", sequenceName = "sq_cliente_da_unidade", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_da_unidade")
    private Long idClienteDaUnidade;

    @Column(name = "nr_cpf", nullable = false, length = 15)
    private String cpf;

    @Column(name = "nm_cliente", nullable = false, length = 100)
    private String nome;

    public ClienteDaUnidadeEntity() {
    }

    public ClienteDaUnidadeEntity(Long idClienteDaUnidade, String cpf, String nome) {
        this.idClienteDaUnidade = idClienteDaUnidade;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getIdClienteDaUnidade() {
        return idClienteDaUnidade;
    }

    public void setIdClienteDaUnidade(Long idClienteDaUnidade) {
        this.idClienteDaUnidade = idClienteDaUnidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
