package br.com.gotech.cyrela.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_tipo_atividade")
public class TipoAtividadeEntity implements Serializable {

    @Id
    @Column(name = "pjo_tipo_atividade_id", nullable = false)
    @SequenceGenerator(name = "tipo_atividade", sequenceName = "sq_tipo_atividade", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_atividade")
    private Long idTipoAtividade;

    @Column(name = "nm_tipo_atividade", nullable = false, length = 50)
    private String nome;

    public TipoAtividadeEntity() {

    }

    public TipoAtividadeEntity(Long idTipoAtividade, String nome) {
        this.idTipoAtividade = idTipoAtividade;
        this.nome = nome;
    }

    public Long getIdTipoAtividade() {
        return idTipoAtividade;
    }

    public void setIdTipoAtividade(Long idTipoAtividade) {
        this.idTipoAtividade = idTipoAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
