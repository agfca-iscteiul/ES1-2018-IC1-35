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
    blogin.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    username = new JLabel("Email - ");
    username.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
    password = new JLabel("Pass - ");
    password.setFont(new Font("Lucida Fax", Font.PLAIN, 20));

    setSize(406,283);
    setLocation(500,280);
    loginpanel.setLayout (null); 


    txuser.setBounds(99,45,270,29);
    pass.setBounds(99,94,270,29);
    blogin.setBounds(140,170,96,29);
    username.setBounds(20,47,80,20);
    password.setBounds(20,101,80,20);

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
        //ttapp.tweet("");
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