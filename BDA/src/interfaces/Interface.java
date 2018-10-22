package interfaces;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.SpringLayout;


import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Interface {

	private JFrame frame;
	private final Action actionFB = new LoginAction("Facebook");
	private final Action actionTT = new LoginAction("Twitter");
	private final Action actionM = new LoginAction("E-mail");
	private JLabel lblFB=new JLabel("Ativo");
	private JLabel lblTT=new JLabel("Ativo");
	private JLabel lblM=new JLabel("Ativo");
	private boolean checkFB=true;
	private boolean checkTT=true;
	private boolean checkM=true;
	private DefaultListModel<String> modelPosts= new DefaultListModel<>();
	private DefaultListModel<String> modelFiltros= new DefaultListModel<>();
	private JTextField textFiltros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Interface window = new Interface();
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 1500, 974);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bom Dia Academia");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFacebook = new JMenu("Facebook");
		mnFacebook.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		menuBar.add(mnFacebook);
		
		JMenuItem mntmConfiguraesFB = new JMenuItem("Configuracoes");
		mntmConfiguraesFB.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmConfiguraesFB.setAction(actionFB);
		mnFacebook.add(mntmConfiguraesFB);
		
		
		JMenu mnTwitter = new JMenu("Twitter");
		mnTwitter.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		menuBar.add(mnTwitter);
		
		JMenuItem mntmConfiguraesTT = new JMenuItem("Configuracoes");
		mntmConfiguraesTT.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmConfiguraesTT.setAction(actionTT);
		mnTwitter.add(mntmConfiguraesTT);
		
		JMenu mnEmail = new JMenu("E-mail");
		mnEmail.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		menuBar.add(mnEmail);
		
		JMenuItem mntmConfiguraesM = new JMenuItem("Configuracoes");
		mntmConfiguraesM.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmConfiguraesM.setAction(actionM);
		mnEmail.add(mntmConfiguraesM);
		
		
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(SystemColor.textHighlight);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnFacebook = new JButton("");
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkFB==true){
					lblFB.setText("Desativo");
					checkFB=false;
					}
					else {
						lblFB.setText("  Ativo");
						checkFB=true;
						
					}
					frame.repaint();
			}
		});
		btnFacebook.setToolTipText("");
		sl_panel.putConstraint(SpringLayout.NORTH, btnFacebook, 35, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnFacebook, 91, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnFacebook, -301, SpringLayout.EAST, panel);
		btnFacebook.setIcon(new ImageIcon("BDA\\src\\facebook.png"));
		panel.add(btnFacebook);
		
		JButton btnTwitter = new JButton("");
		btnTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkTT==true){
					lblTT.setText("Desativo");
					checkTT=false;
					}
					else {
						lblTT.setText("  Ativo");
						checkTT=true;
						
					}
					frame.repaint();
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnTwitter, 73, SpringLayout.EAST, btnFacebook);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnTwitter, 0, SpringLayout.SOUTH, btnFacebook);
		sl_panel.putConstraint(SpringLayout.EAST, btnTwitter, -62, SpringLayout.EAST, panel);
		btnTwitter.setIcon(new ImageIcon("BDA\\src\\Twitter-icon.png"));
		panel.add(btnTwitter);
		
		JButton btnEmail = new JButton("");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkM==true){
				lblM.setText("Desativo");
				checkM=false;
				}
				else {
					lblM.setText("  Ativo");
					checkM=true;
					
				}
				frame.repaint();
				
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnEmail, 48, SpringLayout.SOUTH, btnFacebook);
		sl_panel.putConstraint(SpringLayout.WEST, btnEmail, 127, SpringLayout.WEST, btnFacebook);
		sl_panel.putConstraint(SpringLayout.EAST, btnEmail, -174, SpringLayout.EAST, panel);
		btnEmail.setIcon(new ImageIcon("BDA\\src\\Gmail-icon.png"));
		panel.add(btnEmail);
		
		lblFB = new JLabel("  Ativo");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFB, 6, SpringLayout.SOUTH, btnFacebook);
		sl_panel.putConstraint(SpringLayout.WEST, lblFB, 137, SpringLayout.WEST, panel);
		lblFB.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(lblFB);
		
		lblTT = new JLabel("  Ativo");
		sl_panel.putConstraint(SpringLayout.NORTH, lblTT, 3, SpringLayout.SOUTH, btnTwitter);
		sl_panel.putConstraint(SpringLayout.EAST, lblTT, -113, SpringLayout.EAST, panel);
		lblTT.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(lblTT);
		
		lblM = new JLabel("  Ativo");
		sl_panel.putConstraint(SpringLayout.NORTH, lblM, 6, SpringLayout.SOUTH, btnEmail);
		sl_panel.putConstraint(SpringLayout.EAST, lblM, -225, SpringLayout.EAST, panel);
		lblM.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(lblM);
		
		JList<String> listPosts = new JList<String>();
		springLayout.putConstraint(SpringLayout.WEST, listPosts, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, listPosts, -558, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.EAST, listPosts);
		listPosts.setModel(modelPosts);
		springLayout.putConstraint(SpringLayout.NORTH, listPosts, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listPosts, 0, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(listPosts);
		
		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		springLayout.putConstraint(SpringLayout.NORTH, lblBomDiaAcademia, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblBomDiaAcademia, -36, SpringLayout.WEST, panel);
		
		textFiltros = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFiltros, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFiltros, 442, SpringLayout.WEST, panel);
		textFiltros.setText("escreva aqui o filtro");
		sl_panel.putConstraint(SpringLayout.NORTH, textFiltros, 109, SpringLayout.SOUTH, lblM);
		textFiltros.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(textFiltros);
		textFiltros.setColumns(10);
		textFiltros.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    textFiltros.setText("");
			  }
			});
		
		JList<String> listFiltros = new JList<String>();
		listFiltros.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.WEST, listFiltros, 0, SpringLayout.WEST, textFiltros);
		sl_panel.putConstraint(SpringLayout.SOUTH, listFiltros, -10, SpringLayout.SOUTH, panel);
		String s1="lol";
		String s2="lol2";
		modelFiltros.addElement(s1);
		modelFiltros.addElement(s2);
		listFiltros.setModel(modelFiltros);
		panel.add(listFiltros);
		
		JButton btnOk = new JButton("Ok");
		sl_panel.putConstraint(SpringLayout.NORTH, listFiltros, 5, SpringLayout.SOUTH, btnOk);
		sl_panel.putConstraint(SpringLayout.EAST, listFiltros, 0, SpringLayout.EAST, btnOk);
		sl_panel.putConstraint(SpringLayout.NORTH, btnOk, -1, SpringLayout.NORTH, textFiltros);
		sl_panel.putConstraint(SpringLayout.WEST, btnOk, 1, SpringLayout.EAST, textFiltros);
		sl_panel.putConstraint(SpringLayout.EAST, btnOk, 106, SpringLayout.EAST, textFiltros);
		btnOk.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(btnOk);
		lblBomDiaAcademia.setFont(new Font("Lucida Fax", Font.BOLD, 84));
		frame.getContentPane().add(lblBomDiaAcademia);
	}
	private class LoginAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String config;
		public LoginAction(String config) {
			putValue(NAME, "Configuraçoes");
			putValue(SHORT_DESCRIPTION, "Configurações de Conta");
			this.config=config;
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println(this.config);
			Configuracoes facebook= new Configuracoes(this.config);
		}
	}
}
