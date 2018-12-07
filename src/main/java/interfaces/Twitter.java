package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import principal.TwitterApp;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Twitter {

	private JFrame frmEnviarTweet;
	private TwitterApp ttapp;

	/**
	 * Cria a aplicação.
	 * 
	 * @param ttapp a aplicação de Twitter
	 */
	public Twitter(TwitterApp ttapp) {
		this.ttapp = ttapp;
		initialize();
		frmEnviarTweet.setVisible(true);
	}

	/**
	 * Inicia o conteudo da janela.
	 */
	private void initialize() {
		frmEnviarTweet = new JFrame();
		frmEnviarTweet.setTitle("Enviar Tweet");
		frmEnviarTweet.setBounds(100, 100, 659, 465);
		frmEnviarTweet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEnviarTweet.getContentPane().setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		textPane.setBounds(15, 16, 607, 338);
		frmEnviarTweet.getContentPane().add(textPane);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		btnEnviar.setBounds(263, 364, 115, 29);
		frmEnviarTweet.getContentPane().add(btnEnviar);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ttapp.tweet(textPane.getText());
				JFrame parent = new JFrame();

				JOptionPane.showMessageDialog(parent, "Mensagem Enviada");
				frmEnviarTweet.dispose();

			}

		});
	}
}
