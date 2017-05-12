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
package Controller;

import Model.ModelCandidato;
import Model.ModelCandidatoForTable;
import View.ViewConsultaCandidato;
import View.ViewManutencaoCandidato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Gabriel Batista Alves <Gabrieltanasia at bitbucket.org>
 */
public class ControllerCandidato {

    private ViewConsultaCandidato viewConsulta = new ViewConsultaCandidato();
    private ViewConsultaCandidato viewExterno = new ViewConsultaCandidato(true);
    private ViewManutencaoCandidato viewManutencaoAdicionar = new ViewManutencaoCandidato();
    private ViewManutencaoCandidato viewManutencaoEditar = new ViewManutencaoCandidato();
    private static ArrayList<ModelCandidato> arrayCandidatos = new ArrayList<ModelCandidato>();
    private static ModelCandidatoForTable modelCandidatosForTable = new ModelCandidatoForTable(arrayCandidatos);

    public ControllerCandidato() {
        this.viewConsulta.getTabelaCandidatos().setModel(modelCandidatosForTable);
        this.viewConsulta.addActionListenerAcaoAdicionar(getActionListenerAcaoAdicionar());
        this.viewConsulta.addActionListenerAcaoEditar(getActionListenerAcaoEditar());
        this.viewConsulta.addActionListenerAcaoExcluir(getActionListenerAcaoExcluir());

        this.viewExterno.getTabelaCandidatos().setModel(modelCandidatosForTable);

        this.viewManutencaoAdicionar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarInclusao());
        this.viewManutencaoAdicionar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoAdicionar));

        this.viewManutencaoEditar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarEdicao());
        this.viewManutencaoEditar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoEditar));
    }

    public ViewConsultaCandidato getView() {
        return viewConsulta;
    }

    public ViewConsultaCandidato getViewForUsoExterno() {
        return viewExterno;
    }

    public ModelCandidato getCandidatoSelecionadoExterno() {
        JTable tabelaReg = viewExterno.getTabelaCandidatos();
        if (tabelaReg.getSelectedRow() != -1) {
            int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
            return arrayCandidatos.get(id);
        }
        return new ModelCandidato();
    }

    public ModelCandidato getCandidatoById(int id) {
        for (Iterator<ModelCandidato> iterator = arrayCandidatos.iterator(); iterator.hasNext();) {
            ModelCandidato candidato = iterator.next();
            if (candidato.getId() == id) {
                return candidato;
            }
        }
        return new ModelCandidato();
    }

    /* Validações */
    protected boolean validaManutencao(ViewManutencaoCandidato viewManutencao) {
        if (viewManutencao.getCampoNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um nome válido.");
            return false;
        }

        if (viewManutencao.getCampoIdade().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar uma idade válida.");
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
                viewManutencaoAdicionar.getCampoId().setText(String.valueOf(modelCandidatosForTable.getRowCount()));
                viewManutencaoAdicionar.setVisible(true);
            }
        };
    }

    protected ActionListener getActionListenerAcaoEditar() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaCandidatos();
                if (tabelaReg.getSelectedRow() != -1) {
                    if (!adicionado) {
                        JDesktopPane desktop = ControllerJanelaPrincipal.getDesktop();
                        desktop.add(viewManutencaoEditar);
                        adicionado = true;
                    }
                    int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                    viewManutencaoEditar.getCampoId().setText(String.valueOf(arrayCandidatos.get(id).getId()));
                    viewManutencaoEditar.getCampoNome().setText(arrayCandidatos.get(id).getNome());
                    viewManutencaoEditar.getCampoIdade().setText(Integer.toString(arrayCandidatos.get(id).getIdade()));
                    viewManutencaoEditar.getCampoEstado().setSelectedIndex(arrayCandidatos.get(id).getEstado());
                    viewManutencaoEditar.setVisible(true);
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoExcluir() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaCandidatos();
                if (tabelaReg.getSelectedRow() != -1) {
                    int result = JOptionPane.showInternalConfirmDialog(tabelaReg, "Deseja realmente excluir o candidato selecionado?");
                    if (result == JOptionPane.YES_OPTION) {
                        int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                        arrayCandidatos.remove(id);
                        viewConsulta.getTabelaCandidatos().revalidate();
                        viewConsulta.getTabelaCandidatos().repaint();
                    }
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoSalvarInclusao() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validaManutencao(viewManutencaoAdicionar)) {
                    ModelCandidato candidato = new ModelCandidato();
                    candidato.setId(Integer.parseInt(viewManutencaoAdicionar.getCampoId().getText()));
                    candidato.setNome(viewManutencaoAdicionar.getCampoNome().getText());
                    candidato.setIdade(Integer.parseInt(viewManutencaoAdicionar.getCampoIdade().getText()));
                    candidato.setEstado(viewManutencaoAdicionar.getCampoEstado().getSelectedIndex());
                    arrayCandidatos.add(candidato);
                    viewConsulta.getTabelaCandidatos().revalidate();
                    viewConsulta.getTabelaCandidatos().repaint();
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
                    ModelCandidato candidato = arrayCandidatos.get(Integer.parseInt(viewManutencaoEditar.getCampoId().getText()));
                    candidato.setNome(viewManutencaoEditar.getCampoNome().getText());
                    candidato.setIdade(Integer.parseInt(viewManutencaoEditar.getCampoIdade().getText()));
                    candidato.setEstado(viewManutencaoEditar.getCampoEstado().getSelectedIndex());
                    viewConsulta.getTabelaCandidatos().revalidate();
                    viewConsulta.getTabelaCandidatos().repaint();
                    viewManutencaoEditar.setVisible(false);
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoLimpar(ViewManutencaoCandidato view) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCampoNome().setText("");
                view.getCampoIdade().setText("");
                view.getCampoEstado().setSelectedIndex(0);
            }
        };
    }

    public ActionListener getActionListenerSelecionarCandidato() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!adicionado) {
                    JDesktopPane desktop = ControllerJanelaPrincipal.getDesktop();
                    desktop.add(viewExterno);
                    adicionado = true;
                }
                viewExterno.setVisible(true);
            }
        };
    }
}
