package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import principal.MailApp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Email {

	private JFrame frmEnviarEmail;
	private JTextField textDest;
	private JTextField textTema;
	private MailApp mapp;
	private JButton btnEnviar;


	/**
	 * Create the application.
	 */
	public Email(MailApp mapp) {
		this.mapp=mapp;
		initialize();
		frmEnviarEmail.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnviarEmail = new JFrame();
		frmEnviarEmail.getContentPane().setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmEnviarEmail.setTitle("Enviar e-mail");
		frmEnviarEmail.setBounds(100, 100, 756, 558);
		frmEnviarEmail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEnviarEmail.getContentPane().setLayout(null);
		
		textDest = new JTextField();
		textDest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDest.setBounds(151, 30, 568, 38);
		frmEnviarEmail.getContentPane().add(textDest);
		textDest.setColumns(10);
		
		JLabel lblDestinatrio = new JLabel("Destinatário");
		lblDestinatrio.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblDestinatrio.setBounds(15, 28, 136, 38);
		frmEnviarEmail.getContentPane().add(lblDestinatrio);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblTema.setBounds(45, 84, 62, 20);
		frmEnviarEmail.getContentPane().add(lblTema);
		
		textTema = new JTextField();
		textTema.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		textTema.setBounds(150, 78, 569, 38);
		frmEnviarEmail.getContentPane().add(textTema);
		textTema.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		btnEnviar.setBounds(285, 445, 115, 29);
		frmEnviarEmail.getContentPane().add(btnEnviar);
		
		JTextArea textTexto = new JTextArea();
		textTexto.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		textTexto.setBounds(15, 133, 704, 284);
		frmEnviarEmail.getContentPane().add(textTexto);
		
		btnEnviar.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  System.out.println(textDest.getText());
		    	  System.out.println(textTema.getText());
		    	  System.out.println(textTexto.getText());
		    	  mapp.sendEmail(textDest.getText(), textTema.getText(), textTexto.getText());
		          
		          
		      }


		    });
	}
}
