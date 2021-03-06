/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorrentRMI.GUIs;

import TorrentRMI.Cliente;
import TorrentRMI.InterfaceCli;
import TorrentRMI.InterfaceServ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Salet Pc
 */
public class TelaInicialCliente extends javax.swing.JFrame {

    private InterfaceCli cliente;
    private InterfaceServ servidor;
    private File file;
    private ArrayList<String> listaDeArquivos;
    private ArrayList<String> listaDeInteresses;
    
    public TelaInicialCliente(InterfaceCli cliente, InterfaceServ servidor) throws RemoteException {
        this.cliente = cliente;
        this.servidor = servidor;
        this.file = new File(".\\SHARE\\");
        listaDeArquivos = new ArrayList<>();
        listaDeInteresses = new ArrayList<>();
        initComponents();
        this.setVisible(true);
        atualizaListaServidor();
        atualizaListaCliente();
        atualizaListaInteresses();
    }
    
    /*
    private TelaInicialCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    private void atualizaListaServidor() throws RemoteException{
        DefaultListModel listModel = new DefaultListModel();
        for (String percorrer : servidor.consultarArquivos(cliente)) {
            listModel.addElement(percorrer);
        }
        this.listaArquivosServidor.removeAll();
        this.listaArquivosServidor.setModel(listModel);
    }
    
    private void atualizaListaCliente() throws RemoteException{
        DefaultListModel listModel = new DefaultListModel();
        this.listaDeArquivos.clear();
        this.listaDeArquivos.addAll(Arrays.asList(file.list()));
        for (String a : this.listaDeArquivos) {
            listModel.addElement(a);
        }
        this.listaDosMeusArquivos.removeAll();
        this.listaDosMeusArquivos.setModel(listModel);
    }

    private void atualizaListaInteresses() {
        DefaultListModel listModel = new DefaultListModel();
        try {
            ArrayList<String> interesses = servidor.getMeusInteresses(cliente);
            for (String a : interesses) {
                listModel.addElement(a);
            }
            this.listaDeInteressesPainel.removeAll();
            this.listaDeInteressesPainel.setModel(listModel);
            
        } catch (RemoteException ex) {
            Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        geral = new javax.swing.JPanel();
        listaArquivosServidorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArquivosServidor = new javax.swing.JList<>();
        AtualizarListaServidor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDosMeusArquivos = new javax.swing.JList<>();
        listaDosMeusArquivosLabel = new javax.swing.JLabel();
        AtualizarListaCliente = new javax.swing.JButton();
        Upload = new javax.swing.JButton();
        Download = new javax.swing.JButton();
        arquivoParaDownloadField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDeInteressesPainel = new javax.swing.JList<>();
        interessesLabel = new javax.swing.JLabel();
        arquivoLabel = new javax.swing.JLabel();
        removerInteresseButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("HP Simplified", 1, 24)); // NOI18N
        titulo.setText("SONIN BLEININ TORRENT");
        titulo.setToolTipText("");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        listaArquivosServidorLabel.setText("Lista de Arquivos do Servidor");

        listaArquivosServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaArquivosServidorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaArquivosServidor);

        AtualizarListaServidor.setText("Atualizar");
        AtualizarListaServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtualizarListaServidorMouseClicked(evt);
            }
        });
        AtualizarListaServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarListaServidorActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaDosMeusArquivos);

        listaDosMeusArquivosLabel.setText("Lista dos Meus Arquivos");

        AtualizarListaCliente.setText("Atualizar");
        AtualizarListaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtualizarListaClienteMouseClicked(evt);
            }
        });
        AtualizarListaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarListaClienteActionPerformed(evt);
            }
        });

        Upload.setText("Upload");
        Upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadMouseClicked(evt);
            }
        });
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        Download.setText("Download");
        Download.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DownloadMouseClicked(evt);
            }
        });

        jScrollPane3.setViewportView(listaDeInteressesPainel);

        interessesLabel.setText("Lista de Interesses");

        arquivoLabel.setText("Arquivo:");

        removerInteresseButton.setText("Remover");
        removerInteresseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removerInteresseButtonMouseClicked(evt);
            }
        });

        jButton1.setText("Atualizar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout geralLayout = new javax.swing.GroupLayout(geral);
        geral.setLayout(geralLayout);
        geralLayout.setHorizontalGroup(
            geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralLayout.createSequentialGroup()
                .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(geralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, geralLayout.createSequentialGroup()
                                .addComponent(arquivoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arquivoParaDownloadField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(listaArquivosServidorLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(geralLayout.createSequentialGroup()
                                    .addComponent(AtualizarListaCliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Upload))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(listaDosMeusArquivosLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(geralLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removerInteresseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(geralLayout.createSequentialGroup()
                                .addComponent(interessesLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(geralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AtualizarListaServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Download, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(geralLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(titulo)))
                .addContainerGap())
        );
        geralLayout.setVerticalGroup(
            geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaArquivosServidorLabel)
                    .addComponent(listaDosMeusArquivosLabel)
                    .addComponent(interessesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AtualizarListaCliente)
                    .addComponent(Upload)
                    .addComponent(arquivoParaDownloadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arquivoLabel)
                    .addComponent(removerInteresseButton)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AtualizarListaServidor)
                    .addComponent(Download))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarListaServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarListaServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AtualizarListaServidorActionPerformed

    private void AtualizarListaServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtualizarListaServidorMouseClicked
        try {
            atualizaListaServidor();
        } catch (RemoteException ex) {
            Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AtualizarListaServidorMouseClicked

    private void AtualizarListaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtualizarListaClienteMouseClicked
        try {
            atualizaListaCliente();
        } catch (RemoteException ex) {
            Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AtualizarListaClienteMouseClicked

    private void AtualizarListaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarListaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AtualizarListaClienteActionPerformed

    private void UploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseClicked
        String upload = this.listaDosMeusArquivos.getSelectedValue();
        if(upload!=null)
        {    
            Path path = Paths.get(file.getName()+"\\"+upload);
            try {
                byte[] arq = Files.readAllBytes(path);
                servidor.fazerUpload(arq, upload, cliente);
            } catch (IOException ex) {
                Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            PopUp popup = new PopUp("SELECIONE UM ARQUIVO");
        }
    }//GEN-LAST:event_UploadMouseClicked

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UploadActionPerformed

    private void DownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DownloadMouseClicked
        String download = this.arquivoParaDownloadField.getText();
        if(!download.equals("") && !listaDeArquivos.contains(download))
        {    
            try {
                byte[] arq = servidor.fazerDownload(download, cliente);
                for(int i=0 ; i<10000000 ; i++){}
                if(arq == null)
                {
                    PopUpInteresse regInteresse = new PopUpInteresse(download, cliente, servidor);
                    this.atualizaListaInteresses();
                }
                else{
                    FileOutputStream fileOS = new FileOutputStream(file.getName()+"\\"+download);
                    fileOS.write(arq);
                    fileOS.close();
                    this.atualizaListaCliente();
                    if(servidor.getMeusInteresses(cliente).contains(download)){
                        servidor.cancelarInteresse(download, cliente);
                        atualizaListaInteresses();
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DownloadMouseClicked

    private void listaArquivosServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaArquivosServidorMouseClicked
        String arqDownload = listaArquivosServidor.getSelectedValue();
        if(arqDownload != null)
            this.arquivoParaDownloadField.setText(arqDownload);
        else
            this.arquivoParaDownloadField.setText("");
    }//GEN-LAST:event_listaArquivosServidorMouseClicked

    private void removerInteresseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerInteresseButtonMouseClicked
        try {
            servidor.cancelarInteresse(listaDeInteressesPainel.getSelectedValue(), cliente);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaInicialCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizaListaInteresses();
    }//GEN-LAST:event_removerInteresseButtonMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        atualizaListaInteresses();
    }//GEN-LAST:event_jButton1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarListaCliente;
    private javax.swing.JButton AtualizarListaServidor;
    private javax.swing.JButton Download;
    private javax.swing.JButton Upload;
    private javax.swing.JLabel arquivoLabel;
    private javax.swing.JTextField arquivoParaDownloadField;
    private javax.swing.JPanel geral;
    private javax.swing.JLabel interessesLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaArquivosServidor;
    private javax.swing.JLabel listaArquivosServidorLabel;
    private javax.swing.JList<String> listaDeInteressesPainel;
    private javax.swing.JList<String> listaDosMeusArquivos;
    private javax.swing.JLabel listaDosMeusArquivosLabel;
    private javax.swing.JButton removerInteresseButton;
    protected final javax.swing.JLabel titulo = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables

}
