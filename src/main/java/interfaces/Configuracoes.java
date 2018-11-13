package interfaces;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Configuracoes {

	private JFrame frmFacebook;
	private JTextField utilizador;
	private JTextField password;
	private String titulo;


	/**
	 * Create the application.
	 */
	public Configuracoes(String titulo) {
		this.titulo=titulo;
		initialize();
		frmFacebook.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFacebook = new JFrame(titulo);
		frmFacebook.setTitle(titulo);
		frmFacebook.setBounds(100, 100, 450, 300);
		frmFacebook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFacebook.setResizable(false);
		frmFacebook.setLocationRelativeTo(null); 
		SpringLayout springLayout = new SpringLayout();
		frmFacebook.getContentPane().setLayout(springLayout);
		
		utilizador = new JTextField();
		utilizador.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, utilizador, 49, SpringLayout.NORTH, frmFacebook.getContentPane());
		frmFacebook.getContentPane().add(utilizador);
		utilizador.setColumns(10);
		
		password = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, password, 22, SpringLayout.SOUTH, utilizador);
		springLayout.putConstraint(SpringLayout.WEST, utilizador, 0, SpringLayout.WEST, password);
		password.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.WEST, password, 183, SpringLayout.WEST, frmFacebook.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, password, -37, SpringLayout.EAST, frmFacebook.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, utilizador, 0, SpringLayout.EAST, password);
		frmFacebook.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		springLayout.putConstraint(SpringLayout.NORTH, lblUtilizador, 48, SpringLayout.NORTH, frmFacebook.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUtilizador, -19, SpringLayout.WEST, utilizador);
		lblUtilizador.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmFacebook.getContentPane().add(lblUtilizador);
		
		JLabel lblPw = new JLabel("Palavra-chave");
		springLayout.putConstraint(SpringLayout.NORTH, lblPw, -1, SpringLayout.NORTH, password);
		springLayout.putConstraint(SpringLayout.EAST, lblPw, -19, SpringLayout.WEST, password);
		lblPw.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmFacebook.getContentPane().add(lblPw);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, btnOk, 41, SpringLayout.SOUTH, password);
		springLayout.putConstraint(SpringLayout.WEST, btnOk, 177, SpringLayout.WEST, frmFacebook.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnOk, 79, SpringLayout.SOUTH, password);
		springLayout.putConstraint(SpringLayout.EAST, btnOk, 245, SpringLayout.WEST, frmFacebook.getContentPane());
		frmFacebook.getContentPane().add(btnOk);
	}
}
