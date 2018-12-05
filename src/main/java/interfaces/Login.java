package interfaces;

import javax.swing.*;

import principal.FacebookApp;
import principal.MailApp;
import principal.TwitterApp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame {
  JButton blogin;
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton newUSer;
  JLabel username;
  JLabel password;
  String UN;
  String PW;

  public Login(){
    super("Login BDA");

    blogin = new JButton("Login");
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    username = new JLabel("Email - ");
    password = new JLabel("Pass - ");

    setSize(300,200);
    setLocation(500,280);
    loginpanel.setLayout (null); 


    txuser.setBounds(70,30,150,20);
    pass.setBounds(70,65,150,20);
    blogin.setBounds(110,100,80,20);
    username.setBounds(20,28,80,20);
    password.setBounds(20,63,80,20);

    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(username);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;




    blogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {


          String usertxt = " ";
          String passtxt = " ";
          MailApp.username=txuser.getText();
          MailApp.password=pass.getText();
          
         
        TwitterApp ttapp=new TwitterApp();
  		MailApp mapp=new MailApp();
  		FacebookApp fbapp=new FacebookApp();
  		ttapp.runTwitter();
  		mapp.runMail();
  		fbapp.runFacebook();
        
      	Interface i=new Interface(ttapp,mapp,fbapp); 
          
      }


    });


  } 
  
  public String getUN() {
	  return UN;
  }
  
  public String getPW() {
	  return PW;
  }

}