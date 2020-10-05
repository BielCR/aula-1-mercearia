/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaMercearia;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gabri
 */
public class TabelaEstoque extends AbstractTableModel {

    private Vector<Produto> produtoEstoque;

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
        switch(coluna){
            case 0: return produtoEstoque.get(linha).getNome();
            case 1: return produtoEstoque.get(linha).getPrec();
            case 2: return produtoEstoque.get(linha).getQuant();
            case 3: return produtoEstoque.get(linha).getCod();
            default: return null;
        }
    }

}
