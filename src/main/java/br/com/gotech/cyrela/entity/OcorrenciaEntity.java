package br.com.gotech.cyrela.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_ocorrencia")
public class OcorrenciaEntity implements Serializable {

    @Id
    @Column(name = "ticketnumber")
    @SequenceGenerator(name = "ocorrencia", sequenceName = "sq_ocorrencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocorrencia")
    private Long idOcorrencia;

    @Column(name = "ds_description", nullable = false, length = 500)
    private String descricao;

    @ManyToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private UnidadeEntity unidade;

    public OcorrenciaEntity() {
    }

    public OcorrenciaEntity(Long idOcorrencia, UnidadeEntity unidade, String descricao) {
        this.idOcorrencia = idOcorrencia;
        this.unidade = unidade;
        this.descricao = descricao;
    }

    public Long getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Long idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public UnidadeEntity getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeEntity unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
