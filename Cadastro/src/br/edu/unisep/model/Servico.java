package br.edu.unisep.model;

public class Servico {
    private String nomeServico;
    private String descricaoServico;
    private float valorServico;
    private int tempoServico;

    public Servico(){}

    public Servico(String nomeServico, String descricaoServico, float valorServico, int tempoServico)
    {
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
        this.valorServico = valorServico;
        this.tempoServico = tempoServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float valorServico) {
        this.valorServico = valorServico;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }
}
