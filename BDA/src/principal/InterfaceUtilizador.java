package principal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class InterfaceUtilizador {
	
	private JFrame janela;
	private JMenuBar barramenu;
	
	public InterfaceUtilizador(){
		janela = new JFrame("Bom Dia Academia");

		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		janela.setBounds(30,30,1500,950);
		
		AdicionarConteudo();
		
		janela.setVisible(true);
		
	}
	
	private void AdicionarConteudo() {
		ConteudoMenu();
	}
	
	private void ConteudoMenu() {
		
		barramenu = new JMenuBar();
		barramenu.setPreferredSize(new Dimension(30, 50));
		
		JMenu menuface = new JMenu("Facebook");
		menuface.setFont(new Font("sans-serif", Font.PLAIN, 20));
		FacebookLogin(menuface);
		barramenu.add(menuface);
		
		JMenu menutwitter = new JMenu("Twitter");
		menutwitter.setFont(new Font("sans-serif", Font.PLAIN, 20));
		TwitterLogin(menutwitter);
		barramenu.add(menutwitter);
		
		JMenu menuemail = new JMenu("E-mail");
		menuemail.setFont(new Font("sans-serif", Font.PLAIN, 20));
		EmailLogin(menuemail);
		barramenu.add(menuemail);
		
		janela.setJMenuBar(barramenu);
	}
	
	private void FacebookLogin(JMenu menu) {
		JMenuItem configface=new JMenuItem("Configurações");
		configface.setFont(new Font("sans-serif", Font.PLAIN, 15));
		configface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame facelogin;
				facelogin = new JFrame();
				facelogin.setBounds(400, 400, 400, 300);
				facelogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				facelogin.setVisible(true);
			}
		});
		menu.add(configface);
		
	}
	
	private void TwitterLogin(JMenu menu) {
		JMenuItem configtwitter=new JMenuItem("Configurações");
		configtwitter.setFont(new Font("sans-serif", Font.PLAIN, 15));
		configtwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame twitterlogin;
				twitterlogin = new JFrame();
				twitterlogin.setBounds(400, 400, 400, 300);
				twitterlogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				twitterlogin.setVisible(true);
			}
		});
		menu.add(configtwitter);
		
		
	}
	
	private void EmailLogin(JMenu menu) {
		JMenuItem configmail=new JMenuItem("Configurações");
		configmail.setFont(new Font("sans-serif", Font.PLAIN, 15));
		configmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame emaillogin;
				emaillogin = new JFrame();
				emaillogin.setBounds(400, 400, 400, 300);
				emaillogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				emaillogin.setVisible(true);
			}
		});
		menu.add(configmail);
		
	}
}
