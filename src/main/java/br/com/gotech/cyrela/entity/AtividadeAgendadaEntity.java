package br.com.gotech.cyrela.entity;

import br.com.gotech.cyrela.helper.DateHelper;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "tb_atividade_agendada")
public class AtividadeAgendadaEntity implements Serializable {

    @Id
    @Column(name = "pjo_atividade_agendada_id")
    @SequenceGenerator(name = "atividade_agendada", sequenceName = "sq_atividade_agendada", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    private Long idAtividadeAgendada;

    @Column(name = "actualstart", nullable = false)
    private Date dataInicio;

    @Column(name = "actualend")
    private Date dataTermino;

    @Column(name = "ds_assunto", nullable = false, length = 150)
    private String assunto;

    @ManyToOne(optional = false)
    private TipoAtividadeEntity tipoAtividade;

    @OneToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private OcorrenciaEntity ocorrencia;

    public AtividadeAgendadaEntity() {
    }

    public AtividadeAgendadaEntity(Long idAtividadeAgendada, Date dataInicio, Date dataTermino, TipoAtividadeEntity tipoAtividade, String assunto, OcorrenciaEntity ocorrencia) {
        this.idAtividadeAgendada = idAtividadeAgendada;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.tipoAtividade = tipoAtividade;
        this.assunto = assunto;
        this.ocorrencia = ocorrencia;
    }

    public Long getIdAtividadeAgendada() {
        return idAtividadeAgendada;
    }

    public void setIdAtividadeAgendada(Long idAtividadeAgendada) {
        this.idAtividadeAgendada = idAtividadeAgendada;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = DateHelper.parseDate(dataInicio);
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = DateHelper.parseDate(dataTermino);
    }

    public TipoAtividadeEntity getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividadeEntity tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public OcorrenciaEntity getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(OcorrenciaEntity ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}
