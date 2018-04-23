package com.smartacademic.myapplication.activitys;

public class Certificado {

    private int imagem;
    private String nomeEvento;
    private Double hora;

    public Certificado() { }

    public Certificado(Double hora, int imagem, String nomeEvento) {
        this.hora = hora;
        this.imagem = imagem;
        this.nomeEvento = nomeEvento;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Double getHora() {
        return hora;
    }

    public void setHora(Double hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "imagem=" + imagem +
                ", nomeEvento='" + nomeEvento + '\'' +
                ", hora=" + hora +
                '}';
    }
}
