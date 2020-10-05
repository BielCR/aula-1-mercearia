/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaMercearia;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gabri
 */
public class TabelaCompra extends AbstractTableModel {

    private Vector<Produto> compras;
    private CompraGUI painel;

    public TabelaCompra(CompraGUI p) {
        compras = new Vector<>();
        this.painel = p;
    }

    @Override
    public int getRowCount() {
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return compras.get(linha).getNome();
            case 1:
                return compras.get(linha).getPrec();
            case 2:
                return compras.get(linha).getQuant();
            case 3:
                return compras.get(linha).getQuant() * compras.get(linha).getPrec();
            default:
                return null;
        }
    }

    public void addProduto(Produto vendido) {
        this.compras.add(vendido);
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Nome";
            case 1:
                return "Preço unitário";
            case 2:
                return "Quantidade";
            case 3:
                return "Parcial";
            default:
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        if (coluna == 2) {
            String senha = JOptionPane.showInputDialog(null, "Informe a senha", "Senha de segurança",
                    JOptionPane.INFORMATION_MESSAGE);
            if (senha != null && senha.equalsIgnoreCase("ifmg")) {
                compras.get(linha).setQuant((int) valor);
                this.painel.atualizaTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Senha inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void removeProduto(int indice) {
        this.compras.remove(indice);
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return null;
        }
    }

    //metodo de cálculo de preço
    public double calculaPrec() {
        double valor = 0.0;
        for (Produto p : compras) {
            valor += p.getQuant() * p.getPrec();
        }
        return valor;
    }

    public Vector<Produto> getProdutos() {
        return compras;
    }

    //metodo de limpar a tabla 
    public void limpaCarrinh() {
        this.compras.clear();
    }

}
