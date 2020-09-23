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
public class Produto {
    private int cod, quant;
    private String nome;
    private double prec;

    public Produto(int cod, int quant, String nome, double prec) {
        this.cod = cod;
        this.quant = quant;
        this.nome = nome;
        this.prec = prec;
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

    @Override
    public String toString() {
        return this.cod+";"+this.nome+";"+this.prec+";"+this.quant;
    }
    
    
}

