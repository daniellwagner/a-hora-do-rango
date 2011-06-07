/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIUsuarioCadastrado.java
 *
 * Created on 27/05/2011, 10:49:15
 */

package ahoradorango;

/**
 *
 * @author Daniell
 */
public class GUIUsuarioCadastrado extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeitorOpinioes leitor;

	/** Creates new form GUIUsuarioCadastrado */
    public GUIUsuarioCadastrado(LeitorOpinioes leitor) {
    	this.leitor = leitor;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        labelUsuariosCadastrados = new javax.swing.JLabel();
        comboUsuariosCadastrados = new javax.swing.JComboBox();
        labelAlgortimoDeRecomendacao = new javax.swing.JLabel();
        comboAlgoritmosRecomendacao = new javax.swing.JComboBox();
        labelQtdeItemsARecomendar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaRecomendacoes = new javax.swing.JTextArea();
        labelRecomendacoes = new javax.swing.JLabel();
        botaoOK = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuario Cadastrado");

        labelUsuariosCadastrados.setText("Selecione usuario:");

        comboUsuariosCadastrados.setModel(new javax.swing.DefaultComboBoxModel(leitor.getUsuarios()));

        labelAlgortimoDeRecomendacao.setText("Algoritmo de recomendacao:");

        comboAlgoritmosRecomendacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Popularidade Global", "Personalizado"}));
        comboAlgoritmosRecomendacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAlgoritmosRecomendacaoActionPerformed(evt);
            }
        });
        

        labelQtdeItemsARecomendar.setText("Quantidades de items a ser recomendado:");

        textAreaRecomendacoes.setColumns(20);
        textAreaRecomendacoes.setRows(5);
        jScrollPane1.setViewportView(textAreaRecomendacoes);

        labelRecomendacoes.setText("Recomendacoes:");

        botaoOK.setText("Ok");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	botaoCancelarActionPerformed(evt);
            	GUIUsuarioCadastrado.this.dispose();
            }
        });
        
        
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRecomendacoes)
                        .addContainerGap(489, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelQtdeItemsARecomendar)
                                    .addComponent(labelAlgortimoDeRecomendacao)
                                    .addComponent(labelUsuariosCadastrados))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                                        .addComponent(botaoOK)
                                        .addGap(18, 18, 18)
                                        .addComponent(botaoCancelar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboAlgoritmosRecomendacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboUsuariosCadastrados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField1, 0, 0, Short.MAX_VALUE))
                                        .addGap(3, 3, 3))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuariosCadastrados)
                    .addComponent(comboUsuariosCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlgortimoDeRecomendacao)
                    .addComponent(comboAlgoritmosRecomendacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQtdeItemsARecomendar)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelRecomendacoes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoOK)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    private void comboAlgoritmosRecomendacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAlgoritmosRecomendacaoActionPerformed
       
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
     
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoOK;
    private javax.swing.JComboBox comboAlgoritmosRecomendacao;
    private javax.swing.JComboBox comboUsuariosCadastrados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelAlgortimoDeRecomendacao;
    private javax.swing.JLabel labelQtdeItemsARecomendar;
    private javax.swing.JLabel labelRecomendacoes;
    private javax.swing.JLabel labelUsuariosCadastrados;
    private javax.swing.JTextArea textAreaRecomendacoes;
    // End of variables declaration//GEN-END:variables

}
