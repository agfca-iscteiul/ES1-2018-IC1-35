package principal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
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
				facelogin = new JFrame("Facebook");
				facelogin.setBounds(400, 400, 400, 250);
				facelogin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				ConstruirLogin(facelogin);
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
				twitterlogin = new JFrame("Twitter");
				twitterlogin.setBounds(400, 400, 400, 250);
				twitterlogin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				ConstruirLogin(twitterlogin);
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
				emaillogin = new JFrame("E-mail");
				emaillogin.setBounds(400, 400, 400, 250);
				emaillogin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				ConstruirLogin(emaillogin);
				emaillogin.setVisible(true);
			}
		});
		menu.add(configmail);
		
	}
	
	private void ConstruirLogin(JFrame janela) {
		SpringLayout layout=new SpringLayout();
		JPanel painel=new JPanel();
		painel.setLayout(layout);
		JLabel rotulout=new JLabel("Utilizador");
		rotulout.setFont(new Font("sans-serif", Font.PLAIN, 20));
		JTextField utilizador=new JTextField();
		utilizador.setFont(new Font("sans-serif", Font.PLAIN, 20));
		
		
		JLabel rotulopw=new JLabel("Palavra-Chave");
		rotulopw.setFont(new Font("sans-serif", Font.PLAIN, 20));
		JPasswordField password=new JPasswordField();
		password.setFont(new Font("sans-serif", Font.PLAIN, 20));
		
		JButton ok=new JButton("ok");
		ok.setSize(new Dimension(50,50));
		
		painel.add(rotulout);
		painel.add(utilizador);
		painel.add(rotulopw);
		painel.add(password);
		painel.add(ok);
		
		 layout.putConstraint(SpringLayout.WEST, rotulout,30, SpringLayout.WEST, janela);
	     layout.putConstraint(SpringLayout.NORTH, rotulout,20, SpringLayout.NORTH, janela);
	     layout.putConstraint(SpringLayout.WEST, utilizador,38, SpringLayout.EAST, rotulout);
	     layout.putConstraint(SpringLayout.NORTH, utilizador,20, SpringLayout.NORTH, 
	         janela);
	      
	     
	     layout.putConstraint(SpringLayout.WEST, rotulopw,10, SpringLayout.WEST, janela);
	     layout.putConstraint(SpringLayout.NORTH, rotulopw,40, SpringLayout.NORTH, rotulout);
	     layout.putConstraint(SpringLayout.WEST, password,10, SpringLayout.EAST, rotulopw);
	     layout.putConstraint(SpringLayout.NORTH, password,40, SpringLayout.NORTH, 
	         utilizador);
	     
	     layout.putConstraint(SpringLayout.EAST, painel,0, SpringLayout.EAST, password);
	     layout.putConstraint(SpringLayout.EAST, password,0, SpringLayout.EAST, utilizador);
	     
	     layout.putConstraint(SpringLayout.WEST, ok,20, SpringLayout.WEST, password);
	     layout.putConstraint(SpringLayout.NORTH, ok,70, SpringLayout.NORTH, rotulopw);
	     layout.putConstraint(SpringLayout.EAST, ok,-40, SpringLayout.EAST, password);
	     
	     
	      janela.add(painel);
		janela.setVisible(true);
		
		
		
	}
}
