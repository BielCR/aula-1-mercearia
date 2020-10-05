/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaMercearia;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gabri
 */
public class TabelaEstoque extends AbstractTableModel {

    private Vector<Produto> produtoEstoque;

    public TabelaEstoque() {
        this.produtoEstoque = new Vector<>();
        atualizaDadosTabela("");
    }

    @Override
    public int getRowCount() {
        return produtoEstoque.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return produtoEstoque.get(linha).getNome();
            case 1:
                return produtoEstoque.get(linha).getPrec();
            case 2:
                return produtoEstoque.get(linha).getQuant();
            case 3:
                return produtoEstoque.get(linha).getCod();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Nome";
            case 1:
                return "Preço";
            case 2:
                return "Quantidade";
            case 3:
                return "Cód.";
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna < 3) {
            return true;
        } else {
            return false;
        }
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
                return Integer.class;
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object novoValor, int linha, int coluna) {
        Produto prodTemp = produtoEstoque.get(linha);
        switch (coluna) {
            case 0:
                prodTemp.setNome((String) novoValor);
                break;
            case 1:
                prodTemp.setPrec((double) novoValor);
                break;
            case 2:
                prodTemp.setQuant((int) novoValor);
                break;
            default:
                break;
        }
    }

    public void atualizaDadosTabela(String consulta) {
        produtoEstoque = FakeBD.consultaNome(consulta);

        //ordena os produtos em ordem alfabética
        Collections.sort(produtoEstoque);
    }

    public void removeProduto(int ind) {
        Produto temp = produtoEstoque.remove(ind);

        FakeBD.delProduto(temp);
    }

}
