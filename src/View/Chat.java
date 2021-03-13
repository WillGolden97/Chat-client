/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.bean.Contact;
import ConnectionFactory.Server;
import Model.bean.Authenticated;
import javax.swing.table.DefaultTableModel;
import Model.bean.Message;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JEditorPane;
import static javax.swing.event.HyperlinkEvent.EventType.ACTIVATED;
import util.Communication;

/**
 *
 * @author William
 */
public final class Chat extends javax.swing.JFrame {

    private Authenticated auth = new Authenticated();
    private List<Contact> contatos;
    private List<String> campoTextos = new ArrayList<>();

    private String nickName = auth.getLogin();

    public Chat() {
        initComponents();
        send.setEnabled(false);
        titleChat.setVisible(false);
        contatos();
        setIconTop();
        componentsToggle(false);
        setLocation(400, 150);
    }

    public void componentsToggle (boolean b) {
        titleChat.setVisible(b);
        characters.setVisible(b);
        send.setVisible(b);
        caixaDeEntradaScroll.setVisible(b);
        campoMensagemScroll.setVisible(b);  
        emoji.setVisible(b);
        file.setVisible(b);
        chatIcon.setVisible(!b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        caixaDeEntradaScroll = new javax.swing.JScrollPane();
        caixaDeEntrada = new javax.swing.JEditorPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        contatosJTable = new javax.swing.JTable();
        characters = new javax.swing.JLabel();
        campoMensagemScroll = new javax.swing.JScrollPane();
        campoMensagem = new javax.swing.JTextArea();
        titleChat = new javax.swing.JLabel();
        chatIcon = new javax.swing.JLabel();
        emoji = new javax.swing.JLabel();
        file = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(520, 400));
        setPreferredSize(new java.awt.Dimension(520, 400));
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
        if (contatosJTable.getColumnModel().getColumnCount() > 0) {
            contatosJTable.getColumnModel().getColumn(0).setResizable(false);
        }

        characters.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        characters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        characters.setText("000/500");
        characters.setToolTipText("");

        campoMensagem.setColumns(20);
        campoMensagem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoMensagem.setLineWrap(true);
        campoMensagem.setRows(5);
        campoMensagem.setAutoscrolls(false);
        campoMensagem.setMaximumSize(new java.awt.Dimension(300, 2147483647));
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
                        .addComponent(campoMensagemScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(characters, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addComponent(send, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(caixaDeEntradaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(titleChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chatIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {emoji, file});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleChat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
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
            setCampoMensagem("");
            campoMensagem.setText("");
            send.setEnabled(false);
            Mensagens();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendActionPerformed

    private void contatosJTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contatosJTableKeyReleased
        Mensagens();
        componentsToggle(true);  
    }//GEN-LAST:event_contatosJTableKeyReleased

    private void caixaDeEntradaHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_caixaDeEntradaHyperlinkUpdate
        if (evt.getEventType() == ACTIVATED) {
            try {
                Runtime.getRuntime().exec("explorer.exe \"" + evt.getURL() + "\"");
            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_caixaDeEntradaHyperlinkUpdate

    private void contatosJTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contatosJTableMouseReleased
        Mensagens();
        componentsToggle(true);          
    }//GEN-LAST:event_contatosJTableMouseReleased

    private void campoMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyReleased
        int count = campoMensagem.getText().length();
        if (count > 0 && count <= 500) {
            send.setEnabled(true);
        } else if (send.isEnabled()) {
            send.setEnabled(false);
        }
        characters.setText(count + "/500");
    }//GEN-LAST:event_campoMensagemKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            Mensagens();
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void campoMensagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyTyped
        setCampoMensagem(campoMensagem.getText());
    }//GEN-LAST:event_campoMensagemKeyTyped

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
        Server server = new Server("localhost", 2134);
        int row = contatosJTable.getSelectedRow();
        String Message = campoMensagem.getText();
        String From = nickName;
        String To = getContatos().get(row).getNickName();
        Message msg = new Message(Message, From, To);
        Communication communication = new Communication("CREATEMESSAGE");
        communication.setParam("SENDEDMESSAGE", msg);
        communication = server.outPut_inPut(communication);
        System.out.println(communication.getParam("STATUSMESSAGE"));
    }

    public void Mensagens() {      
        try {
            int row = contatosJTable.getSelectedRow();
            campoMensagem.setText(campoTextos.get(row));
            String contactNickName = getContatos().get(row).getNickName();
            Server server = new Server();
            Communication communication = new Communication("MESSAGE");
            communication.setParam("nickName", nickName);
            communication.setParam("contactNickName", contactNickName);
            setTitle("Chat - @" + nickName + " - Contact - " + getContatos().get(row).getNome() + " : @" + contactNickName);
            titleChat.setText("  @"+getContatos().get(row).getNickName());
            communication = server.outPut_inPut(communication);
            List<Message> message = (List<Message>) communication.getParam("MESSAGEREPLY");
            String msg = "";
            caixaDeEntrada.setContentType("text/html");
            HtmlContent html = new HtmlContent();
            msg = "<!DOCTYPE html><html><head></head><body>";
            for (Message m : message) {
                if (m.getFrom().equals(nickName)) {
                    msg += html.HtmlReplyMsg("#383a59", m.getMessage(), m.getDate());
                } else {
                    msg += html.HtmlContactMsg("#282a36", m.getFrom(), m.getMessage(), m.getDate());
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
            Server server = new Server("localhost", 2134);
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

//    public static void main(String args[]) {
//        try {
//            UIManager.setLookAndFeel(new FlatDarkLaf());
//        } catch (Exception ex) {
//            System.err.println("Failed to initialize LaF");
//        }
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Chat().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane caixaDeEntrada;
    private javax.swing.JScrollPane caixaDeEntradaScroll;
    private javax.swing.JTextArea campoMensagem;
    private javax.swing.JScrollPane campoMensagemScroll;
    private javax.swing.JLabel characters;
    private javax.swing.JLabel chatIcon;
    private javax.swing.JTable contatosJTable;
    private javax.swing.JLabel emoji;
    private javax.swing.JLabel file;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton send;
    private javax.swing.JLabel titleChat;
    // End of variables declaration//GEN-END:variables

}
