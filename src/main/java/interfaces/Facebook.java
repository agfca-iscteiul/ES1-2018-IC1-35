package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import principal.FacebookApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Facebook {

	private JFrame frmPostFacebook;
	private FacebookApp fbapp;

	/**
	 * Cria a aplicação.
	 * 
	 * @param a aplicação do Facebook.
	 */
	public Facebook(FacebookApp fbapp) {
		this.fbapp = fbapp;
		initialize();
		frmPostFacebook.setVisible(true);
	}

	/**
	 * Inicia o conteudo da janela.
	 */
	private void initialize() {
		frmPostFacebook = new JFrame();
		frmPostFacebook.setTitle("Post Facebook");
		frmPostFacebook.setBounds(100, 100, 645, 451);
		frmPostFacebook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPostFacebook.getContentPane().setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		textPane.setBounds(15, 16, 593, 318);
		frmPostFacebook.getContentPane().add(textPane);

		JButton btnPostar = new JButton("Postar");
		btnPostar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		btnPostar.setBounds(251, 350, 115, 29);
		frmPostFacebook.getContentPane().add(btnPostar);

		btnPostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fbapp.publicGroup(textPane.getText());
				JFrame parent = new JFrame();

				JOptionPane.showMessageDialog(parent, "Mensagem Enviada");
				frmPostFacebook.dispose();

			}

		});
	}

}
