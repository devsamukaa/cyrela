package br.com.gotech.cyrela.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_unidade")
public class UnidadeEntity implements Serializable {

    @Id
    @Column(name = "pjo_unidadeid")
    @SequenceGenerator(name = "unidade", sequenceName = "sq_unidade", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade")
    private Long idUnidade;

    @Column(name = "nr_apto", nullable = false, length = 50)
    private String numero;

    @ManyToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private BlocoEntity bloco;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private ClienteDaUnidadeEntity clienteDaUnidade;

    public UnidadeEntity() {
    }

    public UnidadeEntity(Long idUnidade, String numero, BlocoEntity bloco, ClienteDaUnidadeEntity cliente) {
        this.idUnidade = idUnidade;
        this.numero = numero;
        this.bloco = bloco;
        this.clienteDaUnidade = cliente;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BlocoEntity getBloco() {
        return bloco;
    }

    public void setBloco(BlocoEntity bloco) {
        this.bloco = bloco;
    }

    public ClienteDaUnidadeEntity getClienteDaUnidade() {
        return clienteDaUnidade;
    }

    public void setClienteDaUnidade(ClienteDaUnidadeEntity cliente) {
        this.clienteDaUnidade = cliente;
    }
}
