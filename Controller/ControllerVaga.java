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
package Controller;

import Model.ModelVaga;
import Model.ModelVagaForTable;
import View.ViewConsultaVaga;
import View.ViewManutencaoVaga;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Andre Luis Zipf <andrezipf94 at gmail.com>
 */
public class ControllerVaga {

    private ViewConsultaVaga viewConsulta = new ViewConsultaVaga();
    private ViewManutencaoVaga viewManutencaoAdicionar = new ViewManutencaoVaga();
    private ViewManutencaoVaga viewManutencaoEditar = new ViewManutencaoVaga();
    private ArrayList<ModelVaga> arrayVagas = new ArrayList<ModelVaga>();
    private ModelVagaForTable modelVagasForTable = new ModelVagaForTable(arrayVagas);

    public ControllerVaga() {
        this.viewConsulta.getTabelaVagas().setModel(modelVagasForTable);
        this.viewConsulta.addActionListenerAcaoAdicionar(getActionListenerAcaoAdicionar());
        this.viewConsulta.addActionListenerAcaoEditar(getActionListenerAcaoEditar());
        this.viewConsulta.addActionListenerAcaoExcluir(getActionListenerAcaoExcluir());

        this.viewManutencaoAdicionar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarInclusao());
        this.viewManutencaoAdicionar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoAdicionar));

        this.viewManutencaoEditar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarEdicao());
        this.viewManutencaoEditar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoEditar));
    }

    public ViewConsultaVaga getView() {
        return viewConsulta;
    }

    /* Validações */
    protected boolean validaManutencao(ViewManutencaoVaga viewManutencao) {
        if (viewManutencao.getCampoNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um nome válido.");
            return false;
        }

        if (viewManutencao.getCampoDescricao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar uma descrição.");
            return false;
        }
        return true;
    }

    /* Action Listeners */
    protected ActionListener getActionListenerAcaoAdicionar() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!adicionado) {
                    JDesktopPane desktop = ControllerJanelaPrincipal.getDesktop();
                    desktop.add(viewManutencaoAdicionar);
                    adicionado = true;
                }
                viewManutencaoAdicionar.getCampoId().setText(String.valueOf(modelVagasForTable.getRowCount()));
                viewManutencaoAdicionar.setVisible(true);
            }
        };
    }

    protected ActionListener getActionListenerAcaoEditar() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaVagas();
                if (tabelaReg.getSelectedRow() != -1) {
                    if (!adicionado) {
                        JDesktopPane desktop = ControllerJanelaPrincipal.getDesktop();
                        desktop.add(viewManutencaoEditar);
                        adicionado = true;
                    }
                    int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                    viewManutencaoEditar.getCampoId().setText(String.valueOf(arrayVagas.get(id).getId()));
                    viewManutencaoEditar.getCampoNome().setText(arrayVagas.get(id).getNome());
                    viewManutencaoEditar.getCampoDescricao().setText(arrayVagas.get(id).getDescricao());
                    viewManutencaoEditar.getCampoEstado().setSelectedIndex(arrayVagas.get(id).getEstado());
                    viewManutencaoEditar.setVisible(true);
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoExcluir() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaVagas();

                if (tabelaReg.getSelectedRow() != -1) {
                    int result = JOptionPane.showInternalConfirmDialog(tabelaReg, "Deseja realmente excluir a vaga selecionada?");
                    if (result == JOptionPane.YES_OPTION) {
                        int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                        arrayVagas.remove(id);
                        viewConsulta.getTabelaVagas().revalidate();
                        viewConsulta.getTabelaVagas().repaint();
                    }
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoLimpar(ViewManutencaoVaga view) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCampoNome().setText("");
                view.getCampoDescricao().setText("");
                view.getCampoEstado().setSelectedIndex(0);
            }
        };
    }

    protected ActionListener getActionListenerAcaoSalvarInclusao() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validaManutencao(viewManutencaoAdicionar)) {
                    ModelVaga vaga = new ModelVaga();
                    vaga.setId(Integer.parseInt(viewManutencaoAdicionar.getCampoId().getText()));
                    vaga.setNome(viewManutencaoAdicionar.getCampoNome().getText());
                    vaga.setDescricao(viewManutencaoAdicionar.getCampoDescricao().getText());
                    vaga.setEstado(viewManutencaoAdicionar.getCampoEstado().getSelectedIndex());
                    arrayVagas.add(vaga);
                    viewConsulta.getTabelaVagas().revalidate();
                    viewConsulta.getTabelaVagas().repaint();
                    viewManutencaoAdicionar.getBotaoLimpar().doClick();
                    viewManutencaoAdicionar.setVisible(false);
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoSalvarEdicao() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validaManutencao(viewManutencaoEditar)) {
                    ModelVaga vaga = arrayVagas.get(Integer.parseInt(viewManutencaoEditar.getCampoId().getText()));
                    vaga.setNome(viewManutencaoEditar.getCampoNome().getText());
                    vaga.setDescricao(viewManutencaoEditar.getCampoDescricao().getText());
                    vaga.setEstado(viewManutencaoEditar.getCampoEstado().getSelectedIndex());
                    viewConsulta.getTabelaVagas().revalidate();
                    viewConsulta.getTabelaVagas().repaint();
                    viewManutencaoEditar.setVisible(false);
                }
            }
        };
    }

}
