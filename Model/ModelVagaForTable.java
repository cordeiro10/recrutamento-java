/*
 * Copyright (C) 2017 Andre Luis Zipf <andrezipf94 at gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andre Luis Zipf <andrezipf94 at gmail.com>
 */
public class ModelVagaForTable extends AbstractTableModel {

    private ArrayList<ModelVaga> listaVagas;
    private String[] colunas = {"ID", "Nome", "Descricao", "Estado"};

    public ModelVagaForTable(ArrayList<ModelVaga> listaVagas) {
        this.listaVagas = listaVagas;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return listaVagas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaVagas.get(rowIndex).getId();
            case 1:
                return listaVagas.get(rowIndex).getNome();
            case 2:
                return listaVagas.get(rowIndex).getDescricao();
            case 3:
                return listaVagas.get(rowIndex).getEstadoAsString();
        }
        return new ModelVaga();
    }

}
