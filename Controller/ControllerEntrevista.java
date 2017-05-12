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

import Model.ModelEntrevista;
import Model.ModelEntrevistaForTable;
import View.ViewConsultaEntrevista;
import View.ViewManutencaoEntrevista;
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
public class ControllerEntrevista {

    private ViewConsultaEntrevista viewConsulta = new ViewConsultaEntrevista();
    private ViewManutencaoEntrevista viewManutencaoAdicionar = new ViewManutencaoEntrevista();
    private ViewManutencaoEntrevista viewManutencaoEditar = new ViewManutencaoEntrevista();
    private ArrayList<ModelEntrevista> arrayEntrevistas = new ArrayList<ModelEntrevista>();
    private ModelEntrevistaForTable modelEntrevistasForTable = new ModelEntrevistaForTable(arrayEntrevistas);
    private ControllerCandidato controllerCandidato = new ControllerCandidato();

    public ControllerEntrevista() {
        this.viewConsulta.getTabelaEntrevista().setModel(modelEntrevistasForTable);
        this.viewConsulta.addActionListenerAcaoAdicionar(getActionListenerAcaoAdicionar());
        this.viewConsulta.addActionListenerAcaoEditar(getActionListenerAcaoEditar());
        this.viewConsulta.addActionListenerAcaoExcluir(getActionListenerAcaoExcluir());

        this.viewManutencaoAdicionar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarInclusao());
        this.viewManutencaoAdicionar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoAdicionar));
        this.viewManutencaoAdicionar.addActionListenerBotaoSelecionarCandidato(controllerCandidato.getActionListenerSelecionarCandidato());

        this.viewManutencaoEditar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarEdicao());
        this.viewManutencaoEditar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoEditar));
        this.viewManutencaoEditar.addActionListenerBotaoSelecionarCandidato(controllerCandidato.getActionListenerSelecionarCandidato());
    }

    /* Validações */
    protected boolean validaManutencao(ViewManutencaoEntrevista viewManutencao) {
        if (viewManutencao.getCampoCandidato().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um candidato.");
            return false;
        }

        if (viewManutencao.getCampoDataInicio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar uma data de início.");
            return false;
        }

        if (viewManutencao.getCampoDataTermino().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar uma data de término.");
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
                viewManutencaoAdicionar.getCampoId().setText(String.valueOf(modelEntrevistasForTable.getRowCount()));
                viewManutencaoAdicionar.setVisible(true);

                controllerCandidato.getViewForUsoExterno().resetActionListenerAcaoSelecionar();
                controllerCandidato.getViewForUsoExterno().addActionListenerAcaoSelecionar(getActionListenerCandidatoSelecionado(viewManutencaoAdicionar));
            }
        };
    }

    protected ActionListener getActionListenerAcaoEditar() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaEntrevista();
                if (tabelaReg.getSelectedRow() != -1) {
                    if (!adicionado) {
                        JDesktopPane desktop = ControllerJanelaPrincipal.getDesktop();
                        desktop.add(viewManutencaoEditar);
                        adicionado = true;
                    }
                    int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                    viewManutencaoEditar.getCampoId().setText(String.valueOf(arrayEntrevistas.get(id).getId()));
                    viewManutencaoEditar.getCampoIdCandidato().setText(String.valueOf(arrayEntrevistas.get(id).getCandidato().getId()));
                    viewManutencaoEditar.getCampoCandidato().setText(arrayEntrevistas.get(id).getCandidato().getNome());
                    viewManutencaoEditar.getCampoDataInicio().setText(arrayEntrevistas.get(id).getDataInicio());
                    viewManutencaoEditar.getCampoDataTermino().setText(arrayEntrevistas.get(id).getDataTermino());
                    viewManutencaoEditar.getCampoNotas().setText(arrayEntrevistas.get(id).getNotas());
                    viewManutencaoEditar.getCampoEstado().setSelectedIndex(arrayEntrevistas.get(id).getEstado());
                    viewManutencaoEditar.setVisible(true);

                    controllerCandidato.getViewForUsoExterno().resetActionListenerAcaoSelecionar();
                    controllerCandidato.getViewForUsoExterno().addActionListenerAcaoSelecionar(getActionListenerCandidatoSelecionado(viewManutencaoEditar));
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoExcluir() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaEntrevista();
                if (tabelaReg.getSelectedRow() != -1) {
                    int result = JOptionPane.showInternalConfirmDialog(tabelaReg, "Deseja realmente excluir a entrevista selecionada?");
                    if (result == JOptionPane.YES_OPTION) {
                        int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                        arrayEntrevistas.remove(id);
                        viewConsulta.getTabelaEntrevista().revalidate();
                        viewConsulta.getTabelaEntrevista().repaint();
                    }
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoLimpar(ViewManutencaoEntrevista view) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCampoCandidato().setText("");
                view.getCampoDataInicio().setText("");
                view.getCampoDataTermino().setText("");
                view.getCampoNotas().setText("");
                view.getCampoEstado().setSelectedIndex(0);
            }
        };
    }

    protected ActionListener getActionListenerCandidatoSelecionado(ViewManutencaoEntrevista view) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controllerCandidato.getViewForUsoExterno().getTabelaCandidatos().getSelectedRow() != -1) {
                    view.getCampoIdCandidato().setText(String.valueOf(controllerCandidato.getCandidatoSelecionadoExterno().getId()));
                    view.getCampoCandidato().setText(controllerCandidato.getCandidatoSelecionadoExterno().getNome());
                    controllerCandidato.getViewForUsoExterno().setVisible(false);
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoSalvarInclusao() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validaManutencao(viewManutencaoAdicionar)) {
                    ModelEntrevista entrevista = new ModelEntrevista();
                    entrevista.setId(Integer.parseInt(viewManutencaoAdicionar.getCampoId().getText()));
                    entrevista.setCandidato(controllerCandidato.getCandidatoById(Integer.parseInt(viewManutencaoAdicionar.getCampoIdCandidato().getText())));
                    entrevista.setDataInicio(viewManutencaoAdicionar.getCampoDataInicio().getText().toString());
                    entrevista.setDataTermino(viewManutencaoAdicionar.getCampoDataTermino().getText().toString());
                    entrevista.setNotas(viewManutencaoAdicionar.getCampoNotas().getText());
                    entrevista.setEstado(viewManutencaoAdicionar.getCampoEstado().getSelectedIndex());
                    arrayEntrevistas.add(entrevista);
                    viewConsulta.getTabelaEntrevista().revalidate();
                    viewConsulta.getTabelaEntrevista().repaint();
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
                    ModelEntrevista entrevista = arrayEntrevistas.get(Integer.parseInt(viewManutencaoEditar.getCampoId().getText()));
                    entrevista.setDataInicio(viewManutencaoEditar.getCampoDataInicio().getText().toString());
                    entrevista.setCandidato(controllerCandidato.getCandidatoById(Integer.parseInt(viewManutencaoEditar.getCampoIdCandidato().getText())));
                    entrevista.setDataTermino(viewManutencaoEditar.getCampoDataTermino().getText().toString());
                    entrevista.setNotas(viewManutencaoEditar.getCampoNotas().getText());
                    entrevista.setEstado(viewManutencaoEditar.getCampoEstado().getSelectedIndex());
                    viewConsulta.getTabelaEntrevista().revalidate();
                    viewConsulta.getTabelaEntrevista().repaint();
                    viewManutencaoEditar.setVisible(false);
                }
            }
        };
    }

    public ViewConsultaEntrevista getView() {
        return viewConsulta;
    }
}
