package br.com.gotech.cyrela.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_bloco")
public class BlocoEntity implements Serializable {

    @Id
    @Column(name = "pjo_bloco_id")
    @SequenceGenerator(name = "bloco", sequenceName = "sq_bloco", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloco")
    private Long idBloco;

    @Column(name = "nm_bloco", nullable = false, length = 50)
    private String nome;

    @ManyToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private EmpreendimentoEntity empreendimento;

    public BlocoEntity() {
    }

    public BlocoEntity(Long idBloco, String nome, EmpreendimentoEntity empreendimento) {
        this.idBloco = idBloco;
        this.empreendimento = empreendimento;
        this.nome = nome;
    }

    public Long getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Long idBloco) {
        this.idBloco = idBloco;
    }

    public EmpreendimentoEntity getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(EmpreendimentoEntity empreendimento) {
        this.empreendimento = empreendimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
