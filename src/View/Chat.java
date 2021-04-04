/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.bean.Contact;
import ConnectionFactory.Server;
import Model.bean.Arquivos;
import Model.bean.Authenticated;
import Model.bean.Message;
import Model.bean.TreatFiles;
import Threads.PlayAudio;
import Threads.SaveProfileImage;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import static javax.swing.event.HyperlinkEvent.EventType.ACTIVATED;
import util.Communication;

/**
 *
 * @author William
 */
public final class Chat extends javax.swing.JFrame {

    private final Authenticated auth = new Authenticated();
    private List<Contact> contatos;
    private List<String> campoTextos = new ArrayList<>();
    private final String nickName = auth.getLogin();
    private TreatFiles currentFile = new TreatFiles();
    private SelectorFile sf = new SelectorFile();
    private boolean selectedFile;
    private final Map<String, Object> process;
    private DefaultListModel contactListDefaultListModel = new DefaultListModel();
    private String currentAudio = "";
    private Thread threadAudio;
    // DownloadFile 
    private String hashDownloadFileThread;
    private String nameDownloadFileThread;
    // Send message
    private Message msg;
    // Delete Message
    private int idDeleteThread;

    public Chat() {
        initComponents();
        send.setEnabled(false);
        setDefaultBorder(nameInfo);
        setDefaultBorder(nickNameInfo);
        setDefaultBorder(campoMensagem);
        contatos();
        setIconTop();
        componentsToggle(false);
        setLocation(400, 150);
        contactsList.setFixedCellHeight(40);
        process = new HashMap<>();
        pauseAudio.setVisible(false);
    }

    public void addContact(Contact contact) {
        campoTextos.add("");
        contatos.add(contact);
        contactListDefaultListModel.addElement(" " + contact.getNome());
        contactsList.setSelectedIndex(contactsList.getModel().getSize() - 1);
        componentsToggle(true);
        Mensagens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageOption = new javax.swing.JPopupMenu();
        deleteItem = new javax.swing.JMenu();
        chatIcon = new javax.swing.JLabel();
        chaTabbedPanel = new javax.swing.JTabbedPane();
        chatPanel = new javax.swing.JPanel();
        caixaDeEntradaScroll = new javax.swing.JScrollPane();
        caixaDeEntrada = new javax.swing.JEditorPane();
        profilePicLabel = new javax.swing.JLabel();
        titleChat = new javax.swing.JLabel();
        campoMensagemScroll = new javax.swing.JScrollPane();
        campoMensagem = new javax.swing.JTextPane();
        send = new javax.swing.JButton();
        characters = new javax.swing.JLabel();
        file = new javax.swing.JLabel();
        loadingLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        profileIconInfo = new javax.swing.JLabel();
        nameInfo1 = new javax.swing.JLabel();
        nickNameInfo2 = new javax.swing.JLabel();
        nameInfo = new javax.swing.JTextField();
        nickNameInfo = new javax.swing.JTextField();
        contatcsScrollPane = new javax.swing.JScrollPane();
        contactsList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        addClient = new javax.swing.JLabel();
        pauseAudio = new javax.swing.JLabel();
        editProfileLabel = new javax.swing.JLabel();

        messageOption.setToolTipText("");

        deleteItem.setText("apagar");
        deleteItem.setToolTipText("");
        messageOption.add(deleteItem);

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        chatIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chat.png"))); // NOI18N

        chaTabbedPanel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        caixaDeEntrada.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                caixaDeEntradaHyperlinkUpdate(evt);
            }
        });
        caixaDeEntradaScroll.setViewportView(caixaDeEntrada);

        profilePicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePicLabel.setAlignmentX(0.5F);
        profilePicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicLabelMouseClicked(evt);
            }
        });

        titleChat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titleChat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleChatMouseClicked(evt);
            }
        });

        campoMensagem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoMensagem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        campoMensagem.setMaximumSize(null);
        campoMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMensagemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoMensagemKeyTyped(evt);
            }
        });
        campoMensagemScroll.setViewportView(campoMensagem);

        send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send.png"))); // NOI18N
        send.setBorder(null);
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        characters.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        characters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        characters.setText("000/500");
        characters.setToolTipText("");

        file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file.png"))); // NOI18N
        file.setToolTipText("nome do arquivo");
        file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileMouseClicked(evt);
            }
        });

        loadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(caixaDeEntradaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(titleChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(loadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatPanelLayout.createSequentialGroup()
                .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(campoMensagemScroll)
                .addGap(5, 5, 5)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(characters, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(titleChat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilePicLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadingLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(caixaDeEntradaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(chatPanelLayout.createSequentialGroup()
                            .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(characters, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(campoMensagemScroll, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))))
        );

        chatPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {profilePicLabel, titleChat});

        chaTabbedPanel.addTab("Chat", chatPanel);

        profileIconInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileIconInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profileLarge.png"))); // NOI18N
        profileIconInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

        nameInfo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameInfo1.setForeground(new java.awt.Color(255, 255, 255));
        nameInfo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameInfo1.setText("Nome :  ");

        nickNameInfo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nickNameInfo2.setForeground(new java.awt.Color(255, 255, 255));
        nickNameInfo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nickNameInfo2.setText("Nick Name :  ");

        nameInfo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        nickNameInfo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nickNameInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nickNameInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nickNameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profileIconInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(127, 127, 127))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileIconInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nickNameInfo2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(nickNameInfo))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        chaTabbedPanel.addTab("Info", infoPanel);

        contactsList.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        contactsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Contacts" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        contactsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        contactsList.setToolTipText("Contatos");
        contactsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                contactsListMouseReleased(evt);
            }
        });
        contactsList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactsListKeyReleased(evt);
            }
        });
        contatcsScrollPane.setViewportView(contactsList);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("  Contatos");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 136, 199)));

        addClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AddCLient.png"))); // NOI18N
        addClient.setToolTipText("adicione novo contato");
        addClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addClientMouseClicked(evt);
            }
        });

        pauseAudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/audioIcon.png"))); // NOI18N
        pauseAudio.setToolTipText("");
        pauseAudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseAudioMouseClicked(evt);
            }
        });

        editProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editProfileLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nameIcon.png"))); // NOI18N
        editProfileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProfileLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contatcsScrollPane)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(editProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pauseAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addClient)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chaTabbedPanel))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {contatcsScrollPane, jLabel1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chaTabbedPanel)
                .addGap(0, 0, 0)
                .addComponent(chatIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addClient, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pauseAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editProfileLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contatcsScrollPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setDefaultBorder(JTextField label) {
        label.setBorder(BorderFactory.createCompoundBorder(
                label.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    private void setDefaultBorder(JTextPane label) {
        label.setBorder(BorderFactory.createCompoundBorder(
                label.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    public Object getProcess(String key) {
        return process.get(key);
    }

    public void setProcess(String key, Object value) {
        process.put(key, value);
    }

    public void componentsToggle(boolean b) {
        chatIcon.setVisible(!b);
        chaTabbedPanel.setVisible(b);
    }

    public TreatFiles getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(TreatFiles currentFile) {
        this.currentFile = currentFile;
    }

    private void sendActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        try {
            enviarMensagem();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendActionPerformed

    private void downloadFile(String hash, String name) {
        this.hashDownloadFileThread = hash;
        this.nameDownloadFileThread = name;
        Thread t;
        try {
            t = (Thread) getProcess(hash);
            if (t.isAlive()) {
                JOptionPane.showMessageDialog(null, "Esse download já está andamento");
            } else {
                setProcess(hash, null);
                downloadFile(hash, name);
            }
        } catch (NullPointerException ex) {
            setProcess(hash, new Thread(downloadFile));
            t = (Thread) getProcess(hash);
            t.start();
        }
    }

    private boolean isImage(String fileName) {
        String[] spliPoint = fileName.split("[.]");
        String format = spliPoint[spliPoint.length - 1];
        return format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpge") || format.toLowerCase().equals("gif");
    }

    private boolean isAudio(String fileName) {
        String[] spliPoint = fileName.split("[.]");
        String format = spliPoint[spliPoint.length - 1];
        return format.toLowerCase().equals("mp3");
    }

    private void campoMensagemKeyReleased(KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyReleased
        sendMessageControl();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && campoMensagem.getText().length() > 0) {
            try {
                if (campoMensagem.getText().length() == 2) {
                    try {
                        if (currentFile.getBytes() != null) {
                            campoMensagem.setText("");
                            enviarMensagem();
                        }
                    } catch (NullPointerException ex) {
                        campoMensagem.setText("");
                        send.setEnabled(false);
                    }
                } else {
                    if (campoMensagem.getText().length() <= 500) {
                        enviarMensagem();
                    } else if (campoMensagem.getText().length() <= 502) {
                        campoMensagem.setText(campoMensagem.getText().substring(0, 500));
                        enviarMensagem();
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyCode() == 40 && campoMensagem.getText().length() > 0) {
            campoMensagem.setText(campoMensagem.getText() + "\n");
        }
    }//GEN-LAST:event_campoMensagemKeyReleased


    private void campoMensagemKeyTyped(KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyTyped
        setCampoMensagem(campoMensagem.getText());
    }//GEN-LAST:event_campoMensagemKeyTyped

    private void fileMouseClicked(MouseEvent evt) {//GEN-FIRST:event_fileMouseClicked
        sf = new SelectorFile();
        sf.toggleSelectorWindows(true);
    }//GEN-LAST:event_fileMouseClicked

    private void formWindowGainedFocus(WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (!contactsList.isSelectionEmpty()) {
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
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void profilePicLabelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_profilePicLabelMouseClicked
        chaTabbedPanel.setSelectedIndex(1);
    }//GEN-LAST:event_profilePicLabelMouseClicked

    private void contactsListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactsListKeyReleased
        contactExchange();
    }//GEN-LAST:event_contactsListKeyReleased

    private void contactsListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactsListMouseReleased
        contactExchange();
    }//GEN-LAST:event_contactsListMouseReleased

    private void titleChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleChatMouseClicked
        chaTabbedPanel.setSelectedIndex(1);
    }//GEN-LAST:event_titleChatMouseClicked

    private void caixaDeEntradaHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_caixaDeEntradaHyperlinkUpdate
        if (evt.getEventType() == ACTIVATED) {
            try {
                String splitURLName = ("" + evt.getURL()).split("/")[1];
                String splitURLHasName = ("" + evt.getURL()).split("/")[2];
                String hashName = splitURLHasName;
                String hash = splitURLHasName.split("[.]")[0];
                String name = splitURLName;
                String[] splitFormat = name.split("[.]");
                String format = splitFormat[splitFormat.length - 1];
                String pathNameDestination = new File("Files\\Received\\" + format + "\\" + hash + "\\" + name).toString();
                boolean isFile = new File(pathNameDestination).isFile();
                if (!isFile) {
                    downloadFile(hashName, name);
                } else {
                    if (isAudio(hashName)) {
                        playAudio(pathNameDestination, name);
                    } else {
                        try {
                            Runtime.getRuntime().exec("explorer.exe \"" + pathNameDestination + "\"");
                        } catch (IOException ex) {
                            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane joptionPane = new JOptionPane();
                int i = joptionPane.showConfirmDialog(null, "Deseja apagar essa mensagem?");
                if (i == 0) {
                    deleteMessage(Integer.parseInt(("" + evt.getURL()).split("/")[1]));
                }
            }
        }
    }//GEN-LAST:event_caixaDeEntradaHyperlinkUpdate

    private void playAudio(String path, String name) {
        PlayAudio playAudio = new PlayAudio(path);
        try {
            threadAudio.stop();
        } catch (NullPointerException ex) {
            // Audio já parado ou já existe
        }
        if (!currentAudio.equals(path)) {
            threadAudio = new Thread(playAudio);
            threadAudio.start();
            this.currentAudio = path;
            pauseAudio.setVisible(true);
            pauseAudio.setToolTipText(name);
        } else {
            try {
                threadAudio.stop();
                this.currentAudio = "";
                pauseAudio.setVisible(false);
            } catch (NullPointerException ex) {
                // Audio já parado ou já existe
            }
        }
    }

    private void deleteMessage(int id) {
        this.idDeleteThread = id;
        Thread t = new Thread(deleteMessage);
        t.start();
    }

    private void addClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClientMouseClicked
        NewContact newContact = new NewContact();
        newContact.setVisible(true);
        newContact.setLocation(400, 150);
        playAudio(currentAudio, "");
        dispose();
    }//GEN-LAST:event_addClientMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            new Login().setVisible(true);
            playAudio(currentAudio, "");
            dispose();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void pauseAudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseAudioMouseClicked
        playAudio(currentAudio, "");
    }//GEN-LAST:event_pauseAudioMouseClicked

    private void editProfileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileLabelMouseClicked
        EditProfile editProfile = new EditProfile(nickName);
        editProfile.setVisible(true);
    }//GEN-LAST:event_editProfileLabelMouseClicked

    private void contactExchange() {
        Mensagens();
        int row = contactsList.getSelectedIndex();
        try {
            campoMensagem.setText(campoTextos.get(row));
        } catch (IndexOutOfBoundsException ex) {
            campoMensagem.setText("");
        }
        clearCurrenteFile();
        componentsToggle(true);
        sendMessageControl();
    }

    private void clearCurrenteFile() {
        sf = new SelectorFile();
        this.selectedFile = false;
        currentFile = null;
        file.setIcon(new ImageIcon(getClass().getResource("/Images/file.png")));
    }

    private void setCampoMensagem(String value) {
        int row;
        row = contactsList.getSelectedIndex();
        campoTextos.set(row, value);
    }

    private void sendMessageControl() {
        int count = campoMensagem.getText().length();
        if (count > 0 && count <= 500 || selectedFile) {
            send.setEnabled(true);
        } else if (send.isEnabled()) {
            send.setEnabled(false);
        }
        characters.setText(count + "/500");
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
        int row = contactsList.getSelectedIndex();
        Message message = new Message();
        message.setMessage(campoMensagem.getText());
        message.setFrom(nickName);
        message.setTo(getContatos().get(row).getNickName());
        this.msg = message;
        Thread t = new Thread(sendMessage);
        t.start();
    }

    public void Mensagens() {
        try {
            int row = contactsList.getSelectedIndex();
            String contactNickName = getContatos().get(row).getNickName();
            String contactName = getContatos().get(row).getNome();
            Server server = new Server();
            Communication communication = new Communication("MESSAGE");
            communication.setParam("nickName", nickName);
            communication.setParam("contactNickName", contactNickName);
            setProfileIcon(contactNickName, profilePicLabel);
            // Titulo do chat e janela
            setTitle("Chat - @" + nickName + " - Contact - @" + getContatos().get(row).getNickName());
            titleChat.setText(" " + getContatos().get(row).getNome());
            // Setando informações de usuário
            nameInfo.setEditable(true);
            nameInfo.setText(contactName);
            nameInfo.setEditable(false);
            nickNameInfo.setEditable(true);
            nickNameInfo.setText("@" + contactNickName);
            nickNameInfo.setEditable(false);
            setProfileIcon(contactNickName, profileIconInfo, "Large");
            communication = server.outPut_inPut(communication);
            List<Message> message = (List<Message>) communication.getParam("MESSAGEREPLY");
            String htmlMsg;
            caixaDeEntrada.setContentType("text/html");
            HtmlContent html = new HtmlContent();
            htmlMsg = "<!DOCTYPE html><html><head></head><body>";
            for (Message m : message) {
                if (m.getFrom().equals(nickName)) {
                    htmlMsg += html.htmlMsg("#383a59", "left", m.getIdMessage(), m.getMessage(), m.getNomeArquivo(), m.getHashArquivo(), m.getDate());
                } else {
                    htmlMsg += html.htmlMsg("#282a36", "right", m.getIdMessage(), m.getMessage(), m.getNomeArquivo(), m.getHashArquivo(), m.getDate());
                }
            }
            htmlMsg += "</body></html>";
            setCaixadeEntrada(htmlMsg);
        } catch (NullPointerException | NoClassDefFoundError | ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contatos() {
        try {
            Server server = new Server();
            Communication communication = new Communication("READ");
            communication.setParam("nickName", nickName);
            communication = server.outPut_inPut(communication);
            setContatos((List<Contact>) communication.getParam("READREPLY"));
            readContatosList();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readContatosList() throws IOException, ClassNotFoundException {
        campoTextos = new ArrayList<>();
        contactListDefaultListModel = new DefaultListModel<>();
        getContatos().forEach((c) -> {
            campoTextos.add("");
            contactListDefaultListModel.addElement(
                    " " + c.getNome());
        });
        contactsList.setModel(contactListDefaultListModel);
        SaveProfileImage sPI0;
        SaveProfileImage sPI1;

        for (Contact c : contatos) {
            sPI0 = new SaveProfileImage(c.getNickName());
            Thread t = new Thread(sPI0);
            t.start();
            sPI1 = new SaveProfileImage(c.getNickName(), 200, "Large");
            Thread t1 = new Thread(sPI1);
            t1.start();
        }
    }

    private void setProfileIcon(String nickName, JLabel label) {
        setProfileIcon(nickName, label, "Small");
    }

    private void setProfileIcon(String nickName, JLabel label, String sizeFolder) {
        boolean isFile = new File("Files/Contacts/ProfilePic/" + sizeFolder + "/" + nickName + "/" + nickName + ".jpg").isFile();
        String imgFile = new File("Images\\profile" + sizeFolder + ".png").toString();
        try {
            if (isFile) {
                imgFile = new File("Files/Contacts/ProfilePic/" + sizeFolder + "/" + nickName + "/" + nickName + ".jpg").toString();
            }
            byte[] imageBytes = java.nio.file.Files.readAllBytes(Paths.get(imgFile));
            InputStream is = new ByteArrayInputStream(imageBytes);
            BufferedImage bi = ImageIO.read(is);
            label.setIcon(new ImageIcon(bi));
        } catch (IOException | IndexOutOfBoundsException | NullPointerException ex) {
            System.out.print("Não localizada imagem!");
        }
    }

    private void setIconTop() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/chat.png")));
    }

    private final Runnable sendMessage = new Runnable() {
        @Override
        public void run() {
            TreatFiles file = currentFile;
            Message message = msg;
            Server server = new Server();
            Communication communication;
            communication = new Communication("CHECKFILE");
            String hashName = "";
            clearCurrenteFile();
            characters.setText("000/500");
            setCampoMensagem("");
            campoMensagem.setText("");
            send.setEnabled(false);
            String toolTipMgsList;
            try {
                toolTipMgsList = (loadingLabel.getToolTipText().length() == 0) ? ("") : (loadingLabel.getToolTipText());
            } catch (NullPointerException ex) {
                toolTipMgsList = "";
            }
            String toolTipMgs = "Enviando mensagem ...\n";
            toolTipMgsList = toolTipMgs + toolTipMgsList;
            loadingLabel.setIcon(new ImageIcon(getClass().getResource("/Images/loading.gif")));
            loadingLabel.setToolTipText(toolTipMgsList);
            try {
                message.setNomeArquivo(file.getFileName());
                hashName = file.getHashedNameFile() + "." + file.getFileFormat();
                message.setHashArquivo(hashName);

            } catch (NullPointerException ex) {
                System.out.println("Sem anexo");
            }
            communication.setParam("nomeHash", hashName);
            communication = server.outPut_inPut(communication);
            int checkFile = (int) communication.getParam("CHECKFILEREPLY");
            if (checkFile == 0) {
                try {
                    String[] spliPoint = message.getHashArquivo().split("[.]");
                    String format = spliPoint[spliPoint.length - 1];
                    boolean isImage = format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpge");
                    if (isImage) {
                        message.setArquivo(file.resizeImage(file.getBytes(), 1024, file.getFileFormat()));
                    } else {
                        message.setArquivo(file.getBytes());
                    }
                } catch (NullPointerException ex) {
                    System.out.println("Sem envio de arquivo");
                }
            }
            communication = new Communication("CREATEMESSAGE");
            communication.setParam("SENDEDMESSAGE", message);
            communication = server.outPut_inPut(communication);
            System.out.println(communication.getParam("STATUSMESSAGE"));
            try {
                Mensagens();
                contatos();
                contactsList.setSelectedIndex(0);
            } catch (NullPointerException ex) {
            }
            loadingLabel.setIcon(null);
            loadingLabel.setToolTipText(loadingLabel.getText().replace(toolTipMgs, ""));
            if (loadingLabel.getToolTipText().equals("")) {
                loadingLabel.setToolTipText(null);
            }
        }
    };

    private final Runnable downloadFile = new Runnable() {
        @Override
        public void run() {
            //Instanciando objeto que manipula arquivos
            TreatFiles tf = new TreatFiles();
            loadingLabel.setIcon(new ImageIcon(getClass().getResource("/Images/loading.gif")));
            String download = "Baixando : " + nameDownloadFileThread + "\n";
            String downloadList;
            try {
                downloadList = (loadingLabel.getToolTipText().length() == 0) ? ("") : (loadingLabel.getToolTipText());
            } catch (NullPointerException ex) {
                downloadList = "";
            }
            loadingLabel.setToolTipText(download + downloadList);
            try {
                // Abrir conexão socket
                Server server = new Server();
                // Instanciando objeto de comunicação com o servidor
                Communication communication = new Communication("DOWNLOADFILE");
                //Instanciando objeto que receber propriedade dos arquivo
                Arquivos arquivos;
                //Coletando nome hash do arquivo
                String hashName = hashDownloadFileThread;
                // Setando valor como paramento para coleta com o BD
                communication.setParam("nomeHash", hashName);
                // Enviado comunicação parametrada, para servidor
                communication = server.outPut_inPut(communication);
                // Coletando informações retornada do servidor
                arquivos = (Arquivos) communication.getParam("DOWNLOADFILEREPLY");
                // Setando valor retornado do para o objeto de manipulação de arquivos
                tf.setNomeArquivo(arquivos.getNomeArquivo());
                tf.setHashArquivo(arquivos.getHashArquivo());
                tf.setArquivo(arquivos.getArquivo());
                // Salvando arquivo em diretorio responsável pelo download de arquivo do cliente
                tf.saveRenomedFile();
                // Abrindo arquivo
                if (isImage(hashName)) {
                    Mensagens();
                } else if (isAudio(hashName)) {
                    playAudio(tf.getPathName(), tf.getFileName() + "." + tf.getFileFormat());
                }
                loadingLabel.setToolTipText(loadingLabel.getToolTipText().replace(download, ""));
                if (loadingLabel.getToolTipText().equals("")) {
                    loadingLabel.setToolTipText(null);
                }
                loadingLabel.setIcon(null);
            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    private final Runnable deleteMessage = new Runnable() {
        @Override
        public void run() {
            Server server = new Server();
            Communication communication = new Communication("DELETEMESSAGE");
            communication.setParam("idMessage", idDeleteThread);
            communication = server.outPut_inPut(communication);
            System.out.print(communication.getParam("STATUSMESSAGE"));
            Mensagens();
            clearCurrenteFile();
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addClient;
    private javax.swing.JEditorPane caixaDeEntrada;
    private javax.swing.JScrollPane caixaDeEntradaScroll;
    private javax.swing.JTextPane campoMensagem;
    private javax.swing.JScrollPane campoMensagemScroll;
    private javax.swing.JTabbedPane chaTabbedPanel;
    private javax.swing.JLabel characters;
    private javax.swing.JLabel chatIcon;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JList<String> contactsList;
    private javax.swing.JScrollPane contatcsScrollPane;
    private javax.swing.JMenu deleteItem;
    private javax.swing.JLabel editProfileLabel;
    private javax.swing.JLabel file;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JPopupMenu messageOption;
    private javax.swing.JTextField nameInfo;
    private javax.swing.JLabel nameInfo1;
    private javax.swing.JTextField nickNameInfo;
    private javax.swing.JLabel nickNameInfo2;
    private javax.swing.JLabel pauseAudio;
    private javax.swing.JLabel profileIconInfo;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton send;
    private javax.swing.JLabel titleChat;
    // End of variables declaration//GEN-END:variables
}
