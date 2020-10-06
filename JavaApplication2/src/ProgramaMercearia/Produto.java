/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaMercearia;

/**
 *
 * @author gabri
 */
public class Produto implements Comparable<Produto> {

    //definindo variáveis
    private int cod, quant;
    private String nome;
    private double prec;

    //construtor com código
    public Produto(int cod, int quant, String nome, double prec) {
        this.cod = cod;
        this.quant = quant;
        this.nome = nome;
        this.prec = prec;
    }

    //construtor sem codigo
    public Produto(int quant, String nome, double prec) {
        this.quant = quant;
        this.nome = nome;
        this.prec = prec;
    }

    //geters e seters
    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getNome() {
        return nome;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.cod + ";" + this.nome + ";" + this.prec + ";" + this.quant;
    }

    //compara os nomes e retorna a em ordem alfabética
    @Override
    public int compareTo(Produto o) {
        return this.nome.toLowerCase().compareTo(o.getNome().toLowerCase());
    }

}
