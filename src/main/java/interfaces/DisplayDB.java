package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JScrollPane;

public class DisplayDB {

	private JFrame frmBaseDeDados;
	private String texto;
	
	/**
	 * Create the application.
	 */
	public DisplayDB(String texto) {
		this.texto=texto;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBaseDeDados = new JFrame();
		frmBaseDeDados.setTitle("Base de Dados");
		frmBaseDeDados.setBounds(100, 100, 780, 622);
		frmBaseDeDados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBaseDeDados.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		textArea.setText(texto);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 0, 758, 566);
		
		frmBaseDeDados.getContentPane().add(scrollPane);
		
		
		
		
		frmBaseDeDados.setVisible(true);
	}
}
