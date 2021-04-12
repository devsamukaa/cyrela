package br.com.gotech.cyrela.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_bandeira")
public class BandeiraEntity implements Serializable {

    @Id
    @Column(name = "pjo_bandeira_id")
    @SequenceGenerator(name = "bandeira", sequenceName = "sq_bandeira", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bandeira")
    private Long idBandeira;

    @Column(name = "nm_bandeira", nullable = false, length = 50)
    private String nome;

    public BandeiraEntity() {
    }

    public BandeiraEntity(Long idBandeira, String nome) {
        this.idBandeira = idBandeira;
        this.nome = nome;
    }

    public Long getIdBandeira() {
        return idBandeira;
    }

    public void setIdBandeira(Long idBandeira) {
        this.idBandeira = idBandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
