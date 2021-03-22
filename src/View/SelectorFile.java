package View;

import Model.bean.TreatFiles;
import java.io.IOException;

public class SelectorFile extends javax.swing.JFrame {

    TreatFiles currentFile = new TreatFiles();

    SelectorFile() {
        initComponents();
    }

    public void toggleSelectorWindows(boolean b) {
        setVisible(b);
    }

    public void setCurrentFile(TreatFiles currentFile) {
        this.currentFile = currentFile;
    }

    public TreatFiles getCurrentFile() throws IOException {
        System.out.println(filleChooser.getSelectedFile());
        System.out.println("Nome do arquivo :" + filleChooser.getSelectedFile().getName());
        currentFile.setBytes(filleChooser.getSelectedFile().toString());
        currentFile.setFileName(filleChooser.getSelectedFile().getName());
        return currentFile;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filleChooser = new javax.swing.JFileChooser();

        filleChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        filleChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filleChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(filleChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(filleChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void filleChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filleChooserActionPerformed
        setVisible(false);
    }//GEN-LAST:event_filleChooserActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser filleChooser;
    // End of variables declaration//GEN-END:variables

}
