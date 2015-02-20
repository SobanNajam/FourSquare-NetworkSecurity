package classes;

import java.awt.Color;
import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Window extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Window Components">
    
    Color selective = new Color(29,176,236);
    Color to = new Color(237,245,250);
    Color back = new Color(29,137,227);
   
    ImageIcon icon;
    private PrintWriter nfcFile;
    private  PrintWriter userpublickey;
    private String userId;
    private String venueID;
    private PrintWriter dataFile;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Security Components">
    KeyPair pair1;
    static PrivateKey userPrivate;
    static PublicKey userPublic;
    KeyPair pair2;
    static PrivateKey fsPrivate;
    static PublicKey fsPublic;
    static PublicKey pub2;
    //</editor-fold>
    
     //<editor-fold defaultstate="collapsed" desc="Socket Attributes 1">
    public Socket socket;
    public InputStream sin;
    public OutputStream sout;
    public DataInputStream in;
    public DataOutputStream out;
    public String line;
    //</editor-fold>
    
    
            
    public Window(String user) throws NoSuchProviderException {
    initComponents();
    System.out.println("here");
    userId = user;
    jScrollPane2.getVerticalScrollBar().setValue(1000);
    jScrollPane2.getHorizontalScrollBar().setValue(450);
            
           try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");

            keyGen.initialize(1024, random);
            
            pair1 = keyGen.generateKeyPair();
            userPrivate = pair1.getPrivate();            
            userPublic = pair1.getPublic();
            
             try {
                    userpublickey = new PrintWriter("S:\\CN Common space\\file", "UTF-8");

                } catch (Exception ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                userpublickey.println(pair1.getPublic());
                userpublickey.close();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        map = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        oceanTower = new javax.swing.JLabel();
        dhaGolfClub = new javax.swing.JLabel();
        dolmenMall = new javax.swing.JLabel();
        kolachi = new javax.swing.JLabel();
        espresso = new javax.swing.JLabel();
        barBQTonight = new javax.swing.JLabel();
        gloriaJeans = new javax.swing.JLabel();
        theForum = new javax.swing.JLabel();
        ginsoyExtreme = new javax.swing.JLabel();
        sattarBuksh = new javax.swing.JLabel();
        southendClub = new javax.swing.JLabel();
        allkarachi = new javax.swing.JLabel();
        checkin = new javax.swing.JButton();
        venue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bgpanel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1120, 740));
        setMinimumSize(new java.awt.Dimension(1120, 740));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setInheritsPopupMenu(true);

        map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/abc.jpg"))); // NOI18N
        jScrollPane2.setViewportView(map);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 0, 920, 710);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(190, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(190, 768));
        jPanel1.setLayout(null);

        oceanTower.setBackground(new java.awt.Color(237, 245, 250));
        oceanTower.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        oceanTower.setForeground(new java.awt.Color(29, 137, 227));
        oceanTower.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        oceanTower.setText("Ocean Tower");
        oceanTower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oceanTowerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oceanTowerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oceanTowerMousePressed(evt);
            }
        });
        jPanel1.add(oceanTower);
        oceanTower.setBounds(10, 460, 160, 20);

        dhaGolfClub.setBackground(new java.awt.Color(237, 245, 250));
        dhaGolfClub.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        dhaGolfClub.setForeground(new java.awt.Color(29, 137, 227));
        dhaGolfClub.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dhaGolfClub.setText("DHA Golf Club");
        dhaGolfClub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dhaGolfClubMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dhaGolfClubMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dhaGolfClubMousePressed(evt);
            }
        });
        jPanel1.add(dhaGolfClub);
        dhaGolfClub.setBounds(10, 160, 160, 20);

        dolmenMall.setBackground(new java.awt.Color(237, 245, 250));
        dolmenMall.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        dolmenMall.setForeground(new java.awt.Color(29, 137, 227));
        dolmenMall.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dolmenMall.setText("Dolmnen Mall");
        dolmenMall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dolmenMallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dolmenMallMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dolmenMallMousePressed(evt);
            }
        });
        jPanel1.add(dolmenMall);
        dolmenMall.setBounds(10, 190, 160, 20);

        kolachi.setBackground(new java.awt.Color(237, 245, 250));
        kolachi.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        kolachi.setForeground(new java.awt.Color(29, 137, 227));
        kolachi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kolachi.setText("Kolachi");
        kolachi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kolachiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kolachiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kolachiMousePressed(evt);
            }
        });
        jPanel1.add(kolachi);
        kolachi.setBounds(10, 220, 160, 20);

        espresso.setBackground(new java.awt.Color(237, 245, 250));
        espresso.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        espresso.setForeground(new java.awt.Color(29, 137, 227));
        espresso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        espresso.setText("Espresso");
        espresso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                espressoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                espressoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espressoMousePressed(evt);
            }
        });
        jPanel1.add(espresso);
        espresso.setBounds(10, 250, 160, 20);

        barBQTonight.setBackground(new java.awt.Color(237, 245, 250));
        barBQTonight.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        barBQTonight.setForeground(new java.awt.Color(29, 137, 227));
        barBQTonight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        barBQTonight.setText("Bar BQ Tonight");
        barBQTonight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barBQTonightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barBQTonightMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barBQTonightMousePressed(evt);
            }
        });
        jPanel1.add(barBQTonight);
        barBQTonight.setBounds(10, 280, 160, 20);

        gloriaJeans.setBackground(new java.awt.Color(237, 245, 250));
        gloriaJeans.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        gloriaJeans.setForeground(new java.awt.Color(29, 137, 227));
        gloriaJeans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gloriaJeans.setText("Gloria Jeans");
        gloriaJeans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gloriaJeansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gloriaJeansMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gloriaJeansMousePressed(evt);
            }
        });
        jPanel1.add(gloriaJeans);
        gloriaJeans.setBounds(10, 310, 160, 20);

        theForum.setBackground(new java.awt.Color(237, 245, 250));
        theForum.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        theForum.setForeground(new java.awt.Color(29, 137, 227));
        theForum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        theForum.setText("The Forum");
        theForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                theForumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                theForumMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                theForumMousePressed(evt);
            }
        });
        jPanel1.add(theForum);
        theForum.setBounds(10, 340, 160, 20);

        ginsoyExtreme.setBackground(new java.awt.Color(237, 245, 250));
        ginsoyExtreme.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        ginsoyExtreme.setForeground(new java.awt.Color(29, 137, 227));
        ginsoyExtreme.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ginsoyExtreme.setText("Ginsoy Extreme");
        ginsoyExtreme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ginsoyExtremeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ginsoyExtremeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ginsoyExtremeMousePressed(evt);
            }
        });
        jPanel1.add(ginsoyExtreme);
        ginsoyExtreme.setBounds(10, 370, 160, 20);

        sattarBuksh.setBackground(new java.awt.Color(237, 245, 250));
        sattarBuksh.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        sattarBuksh.setForeground(new java.awt.Color(29, 137, 227));
        sattarBuksh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sattarBuksh.setText("Sattar Buksh");
        sattarBuksh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sattarBukshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sattarBukshMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sattarBukshMousePressed(evt);
            }
        });
        jPanel1.add(sattarBuksh);
        sattarBuksh.setBounds(10, 400, 160, 20);

        southendClub.setBackground(new java.awt.Color(237, 245, 250));
        southendClub.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        southendClub.setForeground(new java.awt.Color(29, 137, 227));
        southendClub.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        southendClub.setText("Southend Club");
        southendClub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                southendClubMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                southendClubMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                southendClubMousePressed(evt);
            }
        });
        jPanel1.add(southendClub);
        southendClub.setBounds(10, 430, 160, 20);

        allkarachi.setBackground(new java.awt.Color(237, 245, 250));
        allkarachi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        allkarachi.setForeground(new java.awt.Color(29, 137, 227));
        allkarachi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        allkarachi.setText("All of Karachi");
        allkarachi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                allkarachiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                allkarachiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allkarachiMousePressed(evt);
            }
        });
        jPanel1.add(allkarachi);
        allkarachi.setBounds(10, 100, 160, 20);

        checkin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkin.setText("Check-In");
        checkin.setOpaque(false);
        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });
        jPanel1.add(checkin);
        checkin.setBounds(10, 530, 100, 25);

        venue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(venue);
        venue.setBounds(10, 500, 150, 23);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/logo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 190, 80);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("replica");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 40, 70, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Logout");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 680, 90, 25);

        bgpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Untitled-1.png"))); // NOI18N
        jPanel1.add(bgpanel1);
        bgpanel1.setBounds(0, 0, 190, 740);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 190, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinActionPerformed

        try {
            socket = new Socket("172.16.1.83", 6789);
            System.out.println("Connected to NFCDevice");
            sin = socket.getInputStream();
            sout = socket.getOutputStream();
            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);

            String ven = in.readUTF();
            System.out.println(ven);

             
            if (venueID.equals(ven)) {
                System.out.println("true here");
                userThread thr = new userThread(userPrivate, userPublic, userId,socket);

            } else {
                JOptionPane.showMessageDialog(null, "Reason:\nUser is not present at this venue.", "Check-in Request Denied", JOptionPane.ERROR_MESSAGE);
            }



        } catch (Exception ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_checkinActionPerformed

   
    
    private void oceanTowerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oceanTowerMouseEntered
        // TODO add your handling code here:
        oceanTower.setBackground(selective);        
        oceanTower.setForeground(Color.white);
        oceanTower.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\ocean.jpg"));
        setscroll(500,0);
    }//GEN-LAST:event_oceanTowerMouseEntered

    private void oceanTowerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oceanTowerMouseExited
        // TODO add your handling code here:
        oceanTower.setBackground(to);        
        oceanTower.setForeground(back);       
        oceanTower.setHorizontalAlignment(2);        
    }//GEN-LAST:event_oceanTowerMouseExited

    private void oceanTowerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oceanTowerMousePressed
        // TODO add your handling code here:
        oceanTower.setBackground(selective);
        venueID = "202";
        venue.setText("Ocean Tower");

    }//GEN-LAST:event_oceanTowerMousePressed
   
    private void dhaGolfClubMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dhaGolfClubMouseEntered
        
        dhaGolfClub.setBackground(selective);        
        dhaGolfClub.setForeground(Color.white);
        dhaGolfClub.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\dhagolfclub.jpg"));
        setscroll(1000,1000);
    }//GEN-LAST:event_dhaGolfClubMouseEntered

    private void dhaGolfClubMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dhaGolfClubMouseExited
        // TODO add your handling code here:
        dhaGolfClub.setBackground(to);        
        dhaGolfClub.setForeground(back);
        dhaGolfClub.setHorizontalAlignment(2);
        //reset();
    }//GEN-LAST:event_dhaGolfClubMouseExited

    private void dhaGolfClubMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dhaGolfClubMousePressed
        
        dhaGolfClub.setBackground(selective);
        venueID = "102";
        venue.setText("DHA Golf Course");
                
    }//GEN-LAST:event_dhaGolfClubMousePressed

    private void dolmenMallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dolmenMallMouseEntered
        
        dolmenMall.setBackground(selective);        
        dolmenMall.setForeground(Color.white);
        dolmenMall.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\dolmen.jpg"));
        setscroll(500,0);
    }//GEN-LAST:event_dolmenMallMouseEntered

    private void dolmenMallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dolmenMallMouseExited
        
        dolmenMall.setBackground(to);        
        dolmenMall.setForeground(back);
        dolmenMall.setHorizontalAlignment(2);        
    }//GEN-LAST:event_dolmenMallMouseExited

    private void dolmenMallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dolmenMallMousePressed
        
        dolmenMall.setBackground(selective);
        venueID = "103";
        venue.setText("Dolmen Mall Tariq Road");
    }//GEN-LAST:event_dolmenMallMousePressed

    private void kolachiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolachiMouseEntered
        kolachi.setBackground(selective);        
        kolachi.setForeground(Color.white);// TODO add your handling code here:
        kolachi.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\kolachi.jpg"));
        setscroll(1100,800);
    }//GEN-LAST:event_kolachiMouseEntered

    private void kolachiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolachiMouseExited
        // TODO add your handling code here:
        kolachi.setBackground(to);        
        kolachi.setForeground(back);
        kolachi.setHorizontalAlignment(2);        
    }//GEN-LAST:event_kolachiMouseExited

    private void kolachiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolachiMousePressed
        
        kolachi.setBackground(selective);
        venueID = "104";
        venue.setText("Kolachi");
        
    }//GEN-LAST:event_kolachiMousePressed

    private void espressoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_espressoMouseEntered
        
        espresso.setBackground(selective);        
        espresso.setForeground(Color.white);
        espresso.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\espresso.jpg"));
        setscroll(650,0);
        
    }//GEN-LAST:event_espressoMouseEntered

    private void espressoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_espressoMouseExited
        
        espresso.setBackground(to);        
        espresso.setForeground(back);
        espresso.setHorizontalAlignment(2);
    }//GEN-LAST:event_espressoMouseExited

    private void espressoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_espressoMousePressed
        
        espresso.setBackground(selective);
        venueID = "105";
        venue.setText("Espresso");
        
    }//GEN-LAST:event_espressoMousePressed

    private void barBQTonightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barBQTonightMouseEntered
        
        barBQTonight.setBackground(selective);        
        barBQTonight.setForeground(Color.white);
        barBQTonight.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\barbq.jpg"));
        setscroll(500,0);
    }//GEN-LAST:event_barBQTonightMouseEntered

    private void barBQTonightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barBQTonightMouseExited
        // TODO add your handling code here:
        barBQTonight.setBackground(to);        
        barBQTonight.setForeground(back);
        barBQTonight.setHorizontalAlignment(2);        
    }//GEN-LAST:event_barBQTonightMouseExited

    private void barBQTonightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barBQTonightMousePressed
        
        barBQTonight.setBackground(selective);
        venueID = "108";
        venue.setText("BAR BQ Tonight");
                
    }//GEN-LAST:event_barBQTonightMousePressed

    private void gloriaJeansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gloriaJeansMouseEntered
                gloriaJeans.setBackground(selective);        
        gloriaJeans.setForeground(Color.white);// TODO add your handling code here:
        gloriaJeans.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\gloria.jpg"));
        setscroll(650,0);
    }//GEN-LAST:event_gloriaJeansMouseEntered

    private void gloriaJeansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gloriaJeansMouseExited
        // TODO add your handling code here:
        gloriaJeans.setBackground(to);        
        gloriaJeans.setForeground(back);
        gloriaJeans.setHorizontalAlignment(2);        
    }//GEN-LAST:event_gloriaJeansMouseExited

    private void gloriaJeansMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gloriaJeansMousePressed
        // TODO add your handling code here:
        gloriaJeans.setBackground(selective);
        venueID = "107";
        venue.setText("Gloria Jeans");
    }//GEN-LAST:event_gloriaJeansMousePressed

    private void theForumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_theForumMouseEntered
        
        theForum.setBackground(selective);        
        theForum.setForeground(Color.white);
        theForum.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\forum.jpg"));
        setscroll(300,0);
        
    }//GEN-LAST:event_theForumMouseEntered

    private void theForumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_theForumMouseExited
        // TODO add your handling code here:
        theForum.setBackground(to);        
        theForum.setForeground(back);
        theForum.setHorizontalAlignment(2);        
    }//GEN-LAST:event_theForumMouseExited

    private void theForumMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_theForumMousePressed
        // TODO add your handling code here:
        theForum.setBackground(selective);
        venueID = "201";
        venue.setText("The Forum");

    }//GEN-LAST:event_theForumMousePressed

    private void ginsoyExtremeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ginsoyExtremeMouseEntered
        ginsoyExtreme.setBackground(selective);        
        ginsoyExtreme.setForeground(Color.white);
        ginsoyExtreme.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\ginsoy.jpg"));
        setscroll(500,450);
        
    }//GEN-LAST:event_ginsoyExtremeMouseEntered

    private void ginsoyExtremeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ginsoyExtremeMouseExited
        // TODO add your handling code here:
        ginsoyExtreme.setBackground(to);        
        ginsoyExtreme.setForeground(back);
        ginsoyExtreme.setHorizontalAlignment(2);  
        //reset();
    }//GEN-LAST:event_ginsoyExtremeMouseExited

    private void ginsoyExtremeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ginsoyExtremeMousePressed
        // TODO add your handling code here:
        ginsoyExtreme.setBackground(selective);
        venueID = "101";
        venue.setText("Ginsoy Extreme");
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\ginsoy.jpg"));
        setscroll(500,450);

    }//GEN-LAST:event_ginsoyExtremeMousePressed

    private void sattarBukshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sattarBukshMouseEntered
        sattarBuksh.setBackground(selective);        
        sattarBuksh.setForeground(Color.white);
        sattarBuksh.setHorizontalAlignment(0);// TODO add your handling code here:
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\sattar.jpg"));
        setscroll(500,0);
         
        
        
    }//GEN-LAST:event_sattarBukshMouseEntered

    private void sattarBukshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sattarBukshMouseExited
        // TODO add your handling code here:
        sattarBuksh.setBackground(to);        
        sattarBuksh.setForeground(back);
        sattarBuksh.setHorizontalAlignment(2);
        //reset();
    }//GEN-LAST:event_sattarBukshMouseExited

    private void sattarBukshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sattarBukshMousePressed
        // TODO add your handling code here:
        sattarBuksh.setBackground(selective);
        venueID = "106";
        venue.setText("Sattar Buksh");

    }//GEN-LAST:event_sattarBukshMousePressed

    private void southendClubMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_southendClubMouseEntered
        southendClub.setBackground(selective);        
        southendClub.setForeground(Color.white);
        southendClub.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\southend.jpg"));
        setscroll(800,500);
        
        
    }//GEN-LAST:event_southendClubMouseEntered

    private void southendClubMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_southendClubMouseExited
       
        southendClub.setBackground(to);        
        southendClub.setForeground(back);
        southendClub.setHorizontalAlignment(2);
        //reset();
    }//GEN-LAST:event_southendClubMouseExited

    private void southendClubMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_southendClubMousePressed
      
        southendClub.setBackground(selective);
        venueID = "109";
        venue.setText("Southend Club");

    }//GEN-LAST:event_southendClubMousePressed

    private void allkarachiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allkarachiMouseEntered
        allkarachi.setBackground(selective);        
        allkarachi.setForeground(Color.white);
        allkarachi.setHorizontalAlignment(0);
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\allkhi.jpg"));
        setscroll(800,500);
    }//GEN-LAST:event_allkarachiMouseEntered

    private void allkarachiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allkarachiMouseExited
        allkarachi.setBackground(to);        
        allkarachi.setForeground(back);
        allkarachi.setHorizontalAlignment(2);
    }//GEN-LAST:event_allkarachiMouseExited

    private void allkarachiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allkarachiMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_allkarachiMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        login obj = new login();
        obj.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allkarachi;
    private javax.swing.JLabel barBQTonight;
    private javax.swing.JLabel bgpanel1;
    private javax.swing.JButton checkin;
    private javax.swing.JLabel dhaGolfClub;
    private javax.swing.JLabel dolmenMall;
    private javax.swing.JLabel espresso;
    private javax.swing.JLabel ginsoyExtreme;
    private javax.swing.JLabel gloriaJeans;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kolachi;
    private javax.swing.JLabel map;
    private javax.swing.JLabel oceanTower;
    private javax.swing.JLabel sattarBuksh;
    private javax.swing.JLabel southendClub;
    private javax.swing.JLabel theForum;
    private javax.swing.JTextField venue;
    // End of variables declaration//GEN-END:variables

    public void reset() 
    {
        map.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCES-Soban11-2051\\Documents\\NetBeansProjects\\user\\src\\gui\\abc.jpg"));
        setscroll(0,0);
    }

    public void setscroll(final int x,final int y) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jScrollPane2.getVerticalScrollBar().setValue(x);
                    jScrollPane2.getHorizontalScrollBar().setValue(y);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private static void regenerateKey2() throws InvalidKeySpecException, NoSuchAlgorithmException, FileNotFoundException 
    {
        Scanner in = new Scanner(new File("S:\\CN Common space\\file2"));
        in.nextLine();
        in.next();

        String modulusString = in.nextLine();
        //String exponentString = "18bc01730656bde47476f7cfbd3d8f9e15ede9c389814672dc161e349b08627fc885fe9d2442ae92f0214c7e97cf0b9a9fc876df4f53517ab63d710f997b2779";

        in.next();
        in.next();
        String publicExponentString = in.nextLine();

        // Load the key into BigIntegers
        BigInteger modulus = new BigInteger(modulusString.replace(" ", ""));
        //BigInteger exponent = new BigInteger(exponentString, 16);
        BigInteger pubExponent = new BigInteger(publicExponentString.replace(" ", ""));
        // Create private and public key specs
        //RSAPrivateKeySpec privateSpec = new RSAPrivateKeySpec(modulus, exponent);
        RSAPublicKeySpec publicSpec = new RSAPublicKeySpec(modulus, pubExponent);
        // Create a key factory
        KeyFactory factory = KeyFactory.getInstance("RSA");
        // Create the RSA private and public keys
        //PrivateKey priv = factory.generatePrivate(privateSpec);
        pub2 = factory.generatePublic(publicSpec);


    }

    private String serializeData(byte[] encryptedData){
        StringBuilder str = new StringBuilder();
        
        for(byte x:encryptedData){str.append(x+" ");System.out.print(x+" ");}
        System.out.println();
        
        return str.toString();
    }
 
}
