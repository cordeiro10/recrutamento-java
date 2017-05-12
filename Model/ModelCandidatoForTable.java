/*
 * Copyright (C) 2017 Gabriel Batista Alves <Gabrieltanasia at bitbucket.org>
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
 * @author Gabriel Batista Alves <Gabrieltanasia at bitbucket.org>
 */
public class ModelCandidatoForTable extends AbstractTableModel{
    private ArrayList<ModelCandidato> listaCandidatos;
    private String[] colunas = {"ID", "Nome", "Idade", "Status"};
    
    public ModelCandidatoForTable(ArrayList<ModelCandidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return listaCandidatos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaCandidatos.get(rowIndex).getId();
            case 1:
                return listaCandidatos.get(rowIndex).getNome();
            case 2:
                return listaCandidatos.get(rowIndex).getIdade();
            case 3:
                return listaCandidatos.get(rowIndex).getEstadoAsString();
        }
        return new ModelCandidato();
    }
}
