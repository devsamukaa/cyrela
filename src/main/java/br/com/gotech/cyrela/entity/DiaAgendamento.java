package br.com.gotech.cyrela.entity;

public class DiaAgendamento {

    private int dia;
    private boolean disponivel;

    public DiaAgendamento() {
    }

    public DiaAgendamento(int dia, boolean disponivel) {
        this.dia = dia;
        this.disponivel = disponivel;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
