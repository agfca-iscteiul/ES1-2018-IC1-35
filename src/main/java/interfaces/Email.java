package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Email {

	private JFrame frmEnviarEmail;
	private JTextField textDest;
	private JTextField textTema;
	private JTextField textField_2;


	/**
	 * Create the application.
	 */
	public Email() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnviarEmail = new JFrame();
		frmEnviarEmail.getContentPane().setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmEnviarEmail.setTitle("Enviar e-mail");
		frmEnviarEmail.setBounds(100, 100, 756, 558);
		frmEnviarEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnviarEmail.getContentPane().setLayout(null);
		
		textDest = new JTextField();
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
		textTema.setBounds(150, 78, 569, 38);
		frmEnviarEmail.getContentPane().add(textTema);
		textTema.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 130, 704, 356);
		frmEnviarEmail.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
