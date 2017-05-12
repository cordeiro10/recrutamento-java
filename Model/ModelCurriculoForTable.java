package Model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriel Schmidt Cordeiro <gabrielscordeiro2012@gmail.com>
 */
public class ModelCurriculoForTable extends AbstractTableModel {

    private ArrayList<ModelCurriculo> listaCurriculos;
    private String[] colunas = {"ID", "Nome", "Endereço", "Telefone", "E-mail", "Objetivo", "Formação", "Experiência Profissional", "Qualificação Profissional"};

    public ModelCurriculoForTable(ArrayList<ModelCurriculo> listaCurriculos) {
        this.listaCurriculos = listaCurriculos;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return listaCurriculos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaCurriculos.get(rowIndex).getId();
            case 1:
                return listaCurriculos.get(rowIndex).getNome();
            case 2:
                return listaCurriculos.get(rowIndex).getEndereco();
            case 3:
                return listaCurriculos.get(rowIndex).getNumeroTelefone();
            case 4:
                return listaCurriculos.get(rowIndex).getEmail();
            case 5:
                return listaCurriculos.get(rowIndex).getObjetivo();
            case 6:
                return listaCurriculos.get(rowIndex).getFormacao();
            case 7:
                return listaCurriculos.get(rowIndex).getExperienciaProfissional();
            case 8:
                return listaCurriculos.get(rowIndex).getQualificacaoProfissional();
        }
        return new ModelCurriculo();
    }

}
