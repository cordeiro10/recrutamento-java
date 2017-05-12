package Controller;

import Model.ModelCurriculo;
import Model.ModelCurriculoForTable;
import View.ViewConsultaCurriculo;
import View.ViewManutencaoCurriculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Gabriel Schmidt Cordeiro <gabrielscordeiro2012@gmail.com>
 */
public class ControllerCurriculo {

    private ViewConsultaCurriculo viewConsulta = new ViewConsultaCurriculo();
    private ViewManutencaoCurriculo viewManutencaoAdicionar = new ViewManutencaoCurriculo();
    private ViewManutencaoCurriculo viewManutencaoEditar = new ViewManutencaoCurriculo();
    private ArrayList<ModelCurriculo> arrayCurriculos = new ArrayList<ModelCurriculo>();
    private ModelCurriculoForTable modelCurriculosForTable = new ModelCurriculoForTable(arrayCurriculos);

    public ControllerCurriculo() {
        this.viewConsulta.getTabelaCurriculos().setModel(modelCurriculosForTable);
        this.viewConsulta.addActionListenerAcaoAdicionar(getActionListenerAcaoAdicionar());
        this.viewConsulta.addActionListenerAcaoEditar(getActionListenerAcaoEditar());
        this.viewConsulta.addActionListenerAcaoExcluir(getActionListenerAcaoExcluir());

        this.viewManutencaoAdicionar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarInclusao());
        this.viewManutencaoAdicionar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoAdicionar));

        this.viewManutencaoEditar.addActionListenerBotaoSalvar(getActionListenerAcaoSalvarEdicao());
        this.viewManutencaoEditar.addActionListenerBotaoLimpar(getActionListenerAcaoLimpar(viewManutencaoEditar));
    }

    public ViewConsultaCurriculo getView() {
        return viewConsulta;
    }

    /* Validações */
    protected boolean validaManutencao(ViewManutencaoCurriculo viewManutencao) {
        if (viewManutencao.getCampoNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um nome válido.");
            return false;
        }

        if (viewManutencao.getCampoEndereco().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um endereço.");
            return false;
        }

        if (viewManutencao.getCampoTelefone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um número de telefone.");
            return false;
        }

        if (viewManutencao.getCampoEmail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar um endereço de e-mail.");
            return false;
        }

        if (viewManutencao.getCampoObjetivo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar o seu objetivo.");
            return false;
        }

        if (viewManutencao.getCampoFormacao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar a sua formação.");
            return false;
        }

        if (viewManutencao.getCampoExperiencia().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar sua experiência profissional.");
            return false;
        }

        if (viewManutencao.getCampoQualificacao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(viewManutencao, "É necessário informar sua qualificação profissional.");
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
                viewManutencaoAdicionar.getCampoId().setText(String.valueOf(modelCurriculosForTable.getRowCount()));
                viewManutencaoAdicionar.setVisible(true);
            }
        };
    }

    protected ActionListener getActionListenerAcaoEditar() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaCurriculos();
                if (tabelaReg.getSelectedRow() != -1) {
                    if (!adicionado) {
                        JDesktopPane desktop = ControllerJanelaPrincipal.getDesktop();
                        desktop.add(viewManutencaoEditar);
                        adicionado = true;
                    }
                    int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                    viewManutencaoEditar.getCampoId().setText(String.valueOf(arrayCurriculos.get(id).getId()));
                    viewManutencaoEditar.getCampoNome().setText(arrayCurriculos.get(id).getNome());
                    viewManutencaoEditar.getCampoEndereco().setText(arrayCurriculos.get(id).getEndereco());
                    viewManutencaoEditar.getCampoTelefone().setText(String.valueOf(arrayCurriculos.get(id).getNumeroTelefone()));
                    viewManutencaoEditar.getCampoEmail().setText(arrayCurriculos.get(id).getEmail());
                    viewManutencaoEditar.getCampoObjetivo().setText(arrayCurriculos.get(id).getObjetivo());
                    viewManutencaoEditar.getCampoFormacao().setText(arrayCurriculos.get(id).getFormacao());
                    viewManutencaoEditar.getCampoExperiencia().setText(arrayCurriculos.get(id).getExperienciaProfissional());
                    viewManutencaoEditar.getCampoQualificacao().setText(arrayCurriculos.get(id).getQualificacaoProfissional());
                    viewManutencaoEditar.setVisible(true);
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoExcluir() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabelaReg = viewConsulta.getTabelaCurriculos();
                if (tabelaReg.getSelectedRow() != -1) {
                    int result = JOptionPane.showInternalConfirmDialog(tabelaReg, "Deseja realmente excluir o currículo selecionado?");
                    if (result == JOptionPane.YES_OPTION) {
                        int id = tabelaReg.convertRowIndexToModel(tabelaReg.getSelectedRow());
                        arrayCurriculos.remove(id);
                        viewConsulta.getTabelaCurriculos().revalidate();
                        viewConsulta.getTabelaCurriculos().repaint();
                    }
                }
            }
        };
    }

    protected ActionListener getActionListenerAcaoLimpar(ViewManutencaoCurriculo view) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCampoNome().setText("");
                view.getCampoEndereco().setText("");
                view.getCampoTelefone().setText("");
                view.getCampoEmail().setText("");
                view.getCampoObjetivo().setText("");
                view.getCampoFormacao().setText("");
                view.getCampoExperiencia().setText("");
                view.getCampoQualificacao().setText("");
            }
        };
    }

    protected ActionListener getActionListenerAcaoSalvarInclusao() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validaManutencao(viewManutencaoAdicionar)) {
                    ModelCurriculo curriculo = new ModelCurriculo();
                    curriculo.setId(Integer.parseInt(viewManutencaoAdicionar.getCampoId().getText()));
                    curriculo.setNome(viewManutencaoAdicionar.getCampoNome().getText());
                    curriculo.setEndereco(viewManutencaoAdicionar.getCampoEndereco().getText());
                    curriculo.setNumeroTelefone(Integer.parseInt(viewManutencaoAdicionar.getCampoTelefone().getText()));
                    curriculo.setEmail(viewManutencaoAdicionar.getCampoEmail().getText());
                    curriculo.setObjetivo(viewManutencaoAdicionar.getCampoObjetivo().getText());
                    curriculo.setFormacao(viewManutencaoAdicionar.getCampoFormacao().getText());
                    curriculo.setExperienciaProfissional(viewManutencaoAdicionar.getCampoExperiencia().getText());
                    curriculo.setQualificacaoProfissional(viewManutencaoAdicionar.getCampoQualificacao().getText());
                    arrayCurriculos.add(curriculo);
                    viewConsulta.getTabelaCurriculos().revalidate();
                    viewConsulta.getTabelaCurriculos().repaint();
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
                    ModelCurriculo curriculo = arrayCurriculos.get(Integer.parseInt(viewManutencaoEditar.getCampoId().getText()));
                    curriculo.setNome(viewManutencaoEditar.getCampoNome().getText());
                    curriculo.setEndereco(viewManutencaoEditar.getCampoEndereco().getText());
                    curriculo.setNumeroTelefone(Integer.parseInt(viewManutencaoEditar.getCampoTelefone().getText()));
                    curriculo.setEmail(viewManutencaoEditar.getCampoEmail().getText());
                    curriculo.setObjetivo(viewManutencaoEditar.getCampoObjetivo().getText());
                    curriculo.setFormacao(viewManutencaoEditar.getCampoFormacao().getText());
                    curriculo.setExperienciaProfissional(viewManutencaoEditar.getCampoExperiencia().getText());
                    curriculo.setQualificacaoProfissional(viewManutencaoEditar.getCampoQualificacao().getText());
                    viewConsulta.getTabelaCurriculos().revalidate();
                    viewConsulta.getTabelaCurriculos().repaint();
                    viewManutencaoEditar.setVisible(false);
                }
            }
        };
    }

}
