package br.com.gotech.cyrela.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_empreendimento")
public class EmpreendimentoEntity implements Serializable {

    @Id
    @Column(name = "pjo_empreendimento_id", nullable = false)
    @SequenceGenerator(name = "empreendimento", sequenceName = "sq_empreendimento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empreendimento")
    private Long idEmpreendimento;

    @Column(name = "nm_empreendimento", nullable = false, length = 100)
    private String nome;

    @Column(name = "nm_logradouro", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "nr_residencial", nullable = false, length = 100)
    private String numero;

    @Column(name = "nm_bairro", nullable = false, length = 80)
    private String bairro;

    @Column(name = "nm_cidade", nullable = false, length = 80)
    private String cidade;

    @Column(name = "nm_uf", nullable = false, length = 2)
    private String uf;

    @Column(name = "nr_cep", nullable = false, length = 9)
    private String cep;

    @ManyToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private BandeiraEntity bandeira;

    public EmpreendimentoEntity() {
    }

    public EmpreendimentoEntity(Long idEmpreendimento, String nome, String logradouro, String numero, String bairro, String cidade, String uf, String cep, BandeiraEntity bandeira) {
        this.idEmpreendimento = idEmpreendimento;
        this.bandeira = bandeira;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Long getIdEmpreendimento() {
        return idEmpreendimento;
    }

    public void setIdEmpreendimento(Long idEmpreendimento) {
        this.idEmpreendimento = idEmpreendimento;
    }

    public BandeiraEntity getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraEntity bandeira) {
        this.bandeira = bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
