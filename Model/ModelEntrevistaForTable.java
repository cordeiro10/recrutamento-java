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
import java.util.Calendar;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andre Luis Zipf <andrezipf94 at gmail.com>
 */
public class ModelEntrevistaForTable extends AbstractTableModel {

    private ArrayList<ModelEntrevista> listaEntrevistas;
    private String[] colunas = {"ID", "Candidato", "Data Inicio", "Data Termino", "Estado", "Notas"};

    public ModelEntrevistaForTable(ArrayList<ModelEntrevista> listaEntrevistas) {
        this.listaEntrevistas = listaEntrevistas;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return listaEntrevistas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaEntrevistas.get(rowIndex).getId();
            case 1:
                return listaEntrevistas.get(rowIndex).getCandidato().getNome();
            case 2:
                return listaEntrevistas.get(rowIndex).getDataInicio();
            case 3:
                return listaEntrevistas.get(rowIndex).getDataTermino();
            case 4:
                return listaEntrevistas.get(rowIndex).getEstadoAsString();
            case 5:
                return listaEntrevistas.get(rowIndex).getNotas();
        }
        return new ModelEntrevista();
    }

}
