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
public class Tabela extends AbstractTableModel{
    private Vector<Produto> compras;
    

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
        switch(coluna){
            case 0: return compras.get(linha).getNome();
            case 1: return compras.get(linha).getPrec();
            case 2: return compras.get(linha).getQuant();
            case 3: return compras.get(linha).getQuant() * compras.get(linha).getPrec();
            default: return null;
        }
    }
    
}
