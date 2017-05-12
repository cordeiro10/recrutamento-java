package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel Schmidt Cordeiro <gabrielscordeiro2012@gmail.com>
 */
public class ViewManutencaoCurriculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewManutencaoCurriculo
     */
    public ViewManutencaoCurriculo() {
        initComponents();
    }

    /* Action Listeners */
    public void addActionListenerBotaoSalvar(ActionListener listener) {
        botaoSalvar.addActionListener(listener);
    }

    public void removeActionListenerBotaoSalvar(ActionListener listener) {
        botaoSalvar.removeActionListener(listener);
    }

    public void addActionListenerBotaoLimpar(ActionListener listener) {
        botaoLimpar.addActionListener(listener);
    }

    /* GETTERS */
    
    public JTextField getCampoId() {
        return campoId;
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoEmail() {
        return campoEmail;
    }

    public JTextField getCampoEndereco() {
        return campoEndereco;
    }

    public JTextArea getCampoExperiencia() {
        return campoExperiencia;
    }

    public JTextArea getCampoFormacao() {
        return campoFormacao;
    }

    public JTextField getCampoObjetivo() {
        return campoObjetivo;
    }

    public JTextArea getCampoQualificacao() {
        return campoQualificacao;
    }

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }
    
    public JButton getBotaoLimpar() {
        return botaoLimpar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoFormacao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        campoEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoObjetivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoExperiencia = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        campoQualificacao = new javax.swing.JTextArea();
        panelAcoes = new javax.swing.JPanel();
        botaoLimpar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manutenção de Currículo");

        panelCampos.setLayout(new java.awt.GridBagLayout());

        labelId.setLabelFor(campoId);
        labelId.setText("Identificacao");
        panelCampos.add(labelId, new java.awt.GridBagConstraints());

        campoId.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCampos.add(campoId, gridBagConstraints);

        labelNome.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelCampos.add(labelNome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCampos.add(campoNome, gridBagConstraints);

        labelDescricao.setText("Formação");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        panelCampos.add(labelDescricao, gridBagConstraints);

        campoFormacao.setColumns(20);
        campoFormacao.setRows(5);
        jScrollPane1.setViewportView(campoFormacao);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        panelCampos.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Endereço");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panelCampos.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCampos.add(campoEndereco, gridBagConstraints);

        jLabel3.setText("Telefone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panelCampos.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCampos.add(campoTelefone, gridBagConstraints);

        jLabel4.setText("E-mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        panelCampos.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCampos.add(campoEmail, gridBagConstraints);

        jLabel5.setText("Objetivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        panelCampos.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCampos.add(campoObjetivo, gridBagConstraints);

        jLabel6.setText("Experiencia Profissional");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        panelCampos.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Qualificação Profissional");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        panelCampos.add(jLabel7, gridBagConstraints);

        campoExperiencia.setColumns(20);
        campoExperiencia.setRows(5);
        jScrollPane2.setViewportView(campoExperiencia);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        panelCampos.add(jScrollPane2, gridBagConstraints);

        campoQualificacao.setColumns(20);
        campoQualificacao.setRows(5);
        jScrollPane3.setViewportView(campoQualificacao);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        panelCampos.add(jScrollPane3, gridBagConstraints);

        getContentPane().add(panelCampos, java.awt.BorderLayout.PAGE_START);

        botaoLimpar.setText("Limpar");

        botaoSalvar.setText("Salvar");

        javax.swing.GroupLayout panelAcoesLayout = new javax.swing.GroupLayout(panelAcoes);
        panelAcoes.setLayout(panelAcoesLayout);
        panelAcoesLayout.setHorizontalGroup(
            panelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAcoesLayout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(botaoLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSalvar)
                .addContainerGap())
        );
        panelAcoesLayout.setVerticalGroup(
            panelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAcoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoSalvar))
                .addContainerGap())
        );

        getContentPane().add(panelAcoes, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextArea campoExperiencia;
    private javax.swing.JTextArea campoFormacao;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoObjetivo;
    private javax.swing.JTextArea campoQualificacao;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel panelAcoes;
    private javax.swing.JPanel panelCampos;
    // End of variables declaration//GEN-END:variables
}