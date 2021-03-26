/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.bean.Contact;
import ConnectionFactory.Server;
import Model.bean.Authenticated;
import Model.bean.DownloadFile;
import javax.swing.table.DefaultTableModel;
import Model.bean.Message;
import Model.bean.SendMessage;
import Model.bean.TreatFiles;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.event.HyperlinkEvent.EventType.ACTIVATED;
import util.Communication;

/**
 *
 * @author William
 */
public final class Chat extends javax.swing.JFrame {

    private final Authenticated auth = new Authenticated();
    private List<Contact> contatos;
    private final List<String> campoTextos = new ArrayList<>();
    private final String nickName = auth.getLogin();
    private TreatFiles currentFile = new TreatFiles();
    private SendMessage sendMsg;
    private SelectorFile sf = new SelectorFile();
    private boolean selectedFile;
    Map<String, Object> process;

    public Chat() {
        initComponents();
        send.setEnabled(false);
        titleChat.setVisible(false);
        contatos();
        setIconTop();
        componentsToggle(false);
        setLocation(400, 150);
        process = new HashMap<>();
    }

    public Object getProcess(String key) {
        return process.get(key);
    }

    public void setProcess(String key, Object value) {
        process.put(key, value);
    }

    public void componentsToggle(boolean b) {
        titleChat.setVisible(b);
        characters.setVisible(b);
        send.setVisible(b);
        caixaDeEntradaScroll.setVisible(b);
        campoMensagemScroll.setVisible(b);
        emoji.setVisible(b);
        file.setVisible(b);
        chatIcon.setVisible(!b);
    }

    public TreatFiles getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(TreatFiles currentFile) {
        this.currentFile = currentFile;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        send = new javax.swing.JButton();
        caixaDeEntradaScroll = new javax.swing.JScrollPane();
        caixaDeEntrada = new javax.swing.JEditorPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        contatosJTable = new javax.swing.JTable();
        characters = new javax.swing.JLabel();
        campoMensagemScroll = new javax.swing.JScrollPane();
        campoMensagem = new javax.swing.JTextPane();
        titleChat = new javax.swing.JLabel();
        chatIcon = new javax.swing.JLabel();
        emoji = new javax.swing.JLabel();
        file = new javax.swing.JLabel();
        sendMessageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send.png"))); // NOI18N
        send.setBorder(null);
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        caixaDeEntrada.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                caixaDeEntradaHyperlinkUpdate(evt);
            }
        });
        caixaDeEntradaScroll.setViewportView(caixaDeEntrada);

        contatosJTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contatosJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Contatos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contatosJTable.setRowHeight(32);
        contatosJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                contatosJTableMouseReleased(evt);
            }
        });
        contatosJTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contatosJTableKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(contatosJTable);

        characters.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        characters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        characters.setText("000/500");
        characters.setToolTipText("");

        campoMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMensagemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoMensagemKeyTyped(evt);
            }
        });
        campoMensagemScroll.setViewportView(campoMensagem);

        titleChat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titleChat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        chatIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chat.png"))); // NOI18N

        emoji.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emoji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emoji.png"))); // NOI18N

        file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file.png"))); // NOI18N
        file.setToolTipText("nome do arquivo");
        file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emoji, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(campoMensagemScroll)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(characters, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addComponent(send, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chatIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleChat, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(sendMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(caixaDeEntradaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleChat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(caixaDeEntradaScroll)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emoji, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(characters, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(campoMensagemScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(chatIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        try {
            enviarMensagem();
            clearCurrenteFile();
            setCampoMensagem("");
            campoMensagem.setText("");
            send.setEnabled(false);
            Mensagens();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendActionPerformed

    private void caixaDeEntradaHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_caixaDeEntradaHyperlinkUpdate
        if (evt.getEventType() == ACTIVATED) {
            String splitURLName = ("" + evt.getURL()).split("/")[1];
            String splitURLHasName = ("" + evt.getURL()).split("/")[2];
            String hashName = splitURLHasName;
            String name = splitURLName;
            String[] splitFormat = name.split("[.]");
            String format = splitFormat[splitFormat.length - 1];
            boolean isFile = new File("Files\\Received\\" + format + "\\" + name).isFile();
            String pathName = new File("Files\\Received\\" + format + "\\" + name).getPath();
            if (!isFile) {
                pathName = downloadFile(hashName);
            }
            if (!isImage(hashName) && isFile) {
                try {
                    Runtime.getRuntime().exec("explorer.exe \"" + pathName + "\"");
                } catch (IOException ex) {
                    Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (isImage(hashName) && isFile) {
                Mensagens();
            }
        }
    }//GEN-LAST:event_caixaDeEntradaHyperlinkUpdate

    private String downloadFile(String hash) {
        DownloadFile downloadFile;
        Thread t;
        String pathName = "";
        try {
            t = (Thread) getProcess(hash);
            if (t.isAlive()) {
                JOptionPane.showMessageDialog(null, "Esse download já está em processo");
            }
        } catch (Exception ex) {
            downloadFile = new DownloadFile(hash);
            setProcess(hash, new Thread(downloadFile));
            t = (Thread) getProcess(hash);
            t.start();
            pathName = downloadFile.getPathName();
        }
        return pathName;
    }

    private boolean isImage(String fileName) {
        String[] spliPoint = fileName.split("[.]");
        String format = spliPoint[spliPoint.length - 1];
        return format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpge") || format.toLowerCase().equals("gif");
    }


    private void contatosJTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contatosJTableMouseReleased
        Mensagens();
        int row = contatosJTable.getSelectedRow();
        campoMensagem.setText(campoTextos.get(row));
        clearCurrenteFile();
        componentsToggle(true);
    }//GEN-LAST:event_contatosJTableMouseReleased

    private void contatosJTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contatosJTableKeyReleased
        Mensagens();
        int row = contatosJTable.getSelectedRow();
        campoMensagem.setText(campoTextos.get(row));
        clearCurrenteFile();
        componentsToggle(true);
    }//GEN-LAST:event_contatosJTableKeyReleased

    private void campoMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyReleased
        int count = campoMensagem.getText().length();
        if (count > 0 && count <= 500 || selectedFile) {
            send.setEnabled(true);
        } else if (send.isEnabled()) {
            send.setEnabled(false);
        }
        characters.setText(count + "/500");
    }//GEN-LAST:event_campoMensagemKeyReleased

    private void campoMensagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyTyped
        setCampoMensagem(campoMensagem.getText());
    }//GEN-LAST:event_campoMensagemKeyTyped

    private void fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileMouseClicked
        sf = new SelectorFile();
        sf.toggleSelectorWindows(true);
    }//GEN-LAST:event_fileMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            Mensagens();
            try {
                this.currentFile = sf.getCurrentFile();
                file.setToolTipText(currentFile.getFileName() + "." + currentFile.getFileFormat());
                file.setIcon(new ImageIcon(getClass().getResource("/Images/attachedFile.png")));
                this.selectedFile = true;
                send.setEnabled(true);
            } catch (NullPointerException ex) {
                file.setIcon(new ImageIcon(getClass().getResource("/Images/file.png")));
                currentFile = new TreatFiles();
            } catch (IOException ex) {
                System.out.println("Arquivo não selecionado : " + ex);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void clearCurrenteFile() {
        sf = new SelectorFile();
        this.selectedFile = false;
        file.setIcon(new ImageIcon(getClass().getResource("/Images/file.png")));
    }

    private void setCampoMensagem(String value) {
        int row = contatosJTable.getSelectedRow();
        campoTextos.set(row, value);
    }

    public void addCaixadeEntrada(String value) {
        caixaDeEntrada.setEditable(true);
        caixaDeEntrada.setText(caixaDeEntrada.getText() + value + "\n");
        caixaDeEntrada.setEditable(false);
    }

    public void setCaixadeEntrada(String value) {
        caixaDeEntrada.setEditable(true);
        caixaDeEntrada.setText(value + "\n");
        caixaDeEntrada.setEditable(false);
    }

    public List<Contact> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contact> contatos) {
        this.contatos = contatos;
    }

    public void enviarMensagem() throws IOException, ClassNotFoundException {
        int row = contatosJTable.getSelectedRow();
        String Message = campoMensagem.getText();
        String From = nickName;
        String To = getContatos().get(row).getNickName();
        Message msg = new Message(Message, From, To);
        sendMsg = new SendMessage(msg, currentFile);
        Thread t = new Thread(sendMsg);
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Mensagens() {
        try {
            int row = contatosJTable.getSelectedRow();
            String contactNickName = getContatos().get(row).getNickName();
            Server server = new Server();
            Communication communication = new Communication("MESSAGE");
            communication.setParam("nickName", nickName);
            communication.setParam("contactNickName", contactNickName);
            setTitle("Chat - @" + nickName + " - Contact - " + getContatos().get(row).getNome() + " : @" + contactNickName);
            titleChat.setText("  @" + getContatos().get(row).getNickName());
            communication = server.outPut_inPut(communication);
            List<Message> message = (List<Message>) communication.getParam("MESSAGEREPLY");
            String msg;
            caixaDeEntrada.setContentType("text/html");
            HtmlContent html = new HtmlContent();
            msg = "<!DOCTYPE html><html><head></head><body>";
            for (Message m : message) {
                if (m.getFrom().equals(nickName)) {
                    msg += html.htmlMsg("#383a59", "left", m.getMessage(), m.getNomeArquivo(), m.getHashArquivo(), m.getDate());
                } else {
                    msg += html.htmlMsg("#282a36", "right", m.getMessage(), m.getNomeArquivo(), m.getHashArquivo(), m.getDate());
                }
            }
            msg += "</body></html>";
            setCaixadeEntrada(msg);
        } catch (NullPointerException | NoClassDefFoundError | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contatos() {
        try {
            Server server = new Server();
            Communication message = new Communication("READ");
            message.setParam("nickName", nickName);
            message = server.outPut_inPut(message);
            setContatos((List<Contact>) message.getParam("READREPLY"));
            readContatosTable();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readContatosTable() throws IOException, ClassNotFoundException {
        DefaultTableModel modelo = (DefaultTableModel) contatosJTable.getModel();
        modelo.setNumRows(0);
        getContatos().forEach((c) -> {
            campoTextos.add("");
            modelo.addRow(new Object[]{
                c.getNome() + " : @" + c.getNickName(),});
        });
    }

    private void setIconTop() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/chat.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane caixaDeEntrada;
    private javax.swing.JScrollPane caixaDeEntradaScroll;
    private javax.swing.JTextPane campoMensagem;
    private javax.swing.JScrollPane campoMensagemScroll;
    private javax.swing.JLabel characters;
    private javax.swing.JLabel chatIcon;
    private javax.swing.JTable contatosJTable;
    private javax.swing.JLabel emoji;
    private javax.swing.JLabel file;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton send;
    private javax.swing.JLabel sendMessageLabel;
    private javax.swing.JLabel titleChat;
    // End of variables declaration//GEN-END:variables
}
