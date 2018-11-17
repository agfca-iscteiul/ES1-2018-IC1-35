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
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.SpringLayout;

import principal.AbstractInfo;
import principal.TwitterApp;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Interface {

	private JFrame frame;
	private final Action actionFB = new LoginAction("Facebook");
	private final Action actionTT = new LoginAction("Twitter");
	private final Action actionM = new LoginAction("E-mail");
	private JLabel lblFB;
	private JLabel lblTT;
	private JLabel lblM;
	private boolean checkFB=true;
	private boolean checkTT=true;
	private boolean checkM=true;
	private DefaultListModel<AbstractInfo> modelPosts= new DefaultListModel<>();
	private ArrayList<String> filtros=new ArrayList<String>();
	private JTextField textFiltros;
	private JPanel panel;
	private SpringLayout sl_panel;
	private JTextField txtOrigem;

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
		barmenu();
		initializeAux();
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
		
		
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(SystemColor.textHighlight);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(panel);
		sl_panel = new SpringLayout();
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
		btnFacebook.setIcon(new ImageIcon("src\\main\\java\\facebook.png"));
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
		btnTwitter.setIcon(new ImageIcon("src\\main\\java\\Twitter-icon.png"));
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
		btnEmail.setIcon(new ImageIcon("src\\main\\java\\Gmail-icon.png"));
		panel.add(btnEmail);
		
		initializeLabel(btnFacebook,btnTwitter,btnEmail);
		
		
		JList<AbstractInfo> listPosts = new JList<AbstractInfo>();
		springLayout.putConstraint(SpringLayout.WEST, listPosts, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, listPosts, -558, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.EAST, listPosts);
		listPosts.setModel(modelPosts);
		TwitterApp ttapp=new TwitterApp();
		ttapp.runTwitter();
		
		modelPosts.addElement(ttapp.getList().get(1));
		springLayout.putConstraint(SpringLayout.NORTH, listPosts, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listPosts, 0, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(listPosts);
		
		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		springLayout.putConstraint(SpringLayout.NORTH, lblBomDiaAcademia, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblBomDiaAcademia, -36, SpringLayout.WEST, panel);
		
		
		lblBomDiaAcademia.setFont(new Font("Lucida Fax", Font.BOLD, 84));
		frame.getContentPane().add(lblBomDiaAcademia);
		
	}
	
	
	private void barmenu() {
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
	}
	

	
	private void initializeLabel(JButton btnFacebook,JButton btnTwitter,JButton btnEmail) {
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
	}
	
	private void initializeAux() {
		
		textFiltros = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFiltros, 105, SpringLayout.WEST, panel);
		textFiltros.setText("escreva aqui o filtro");
		textFiltros.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(textFiltros);
		textFiltros.setColumns(10);
		textFiltros.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    textFiltros.setText("");
			  }
			});
//		textFiltros.addActionListener(new ActionListener(){
//
//            public void actionPerformed(ActionEvent e){
//
//            	 modelFiltros.addElement(textFiltros.getText());
//            	 filtros.add(textFiltros.getText());
//            	
//            	}});
		
		JButton btnOkPC = new JButton("Ok");
		sl_panel.putConstraint(SpringLayout.EAST, textFiltros, -6, SpringLayout.WEST, btnOkPC);
		sl_panel.putConstraint(SpringLayout.NORTH, btnOkPC, -1, SpringLayout.NORTH, textFiltros);
		sl_panel.putConstraint(SpringLayout.WEST, btnOkPC, 418, SpringLayout.WEST, panel);
		btnOkPC.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(btnOkPC);
		
		JCheckBox chckbxPC = new JCheckBox("Palavra-chave");
		sl_panel.putConstraint(SpringLayout.WEST, chckbxPC, 44, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxPC, -453, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textFiltros, 6, SpringLayout.SOUTH, chckbxPC);
		chckbxPC.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(chckbxPC);
		
		JCheckBox chckbxOrigem = new JCheckBox("Origem");
		sl_panel.putConstraint(SpringLayout.WEST, chckbxOrigem, 0, SpringLayout.WEST, chckbxPC);
		sl_panel.putConstraint(SpringLayout.EAST, chckbxOrigem, -343, SpringLayout.EAST, panel);
		chckbxOrigem.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(chckbxOrigem);
		
		txtOrigem = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxOrigem, -6, SpringLayout.NORTH, txtOrigem);
		sl_panel.putConstraint(SpringLayout.WEST, txtOrigem, 0, SpringLayout.WEST, textFiltros);
		sl_panel.putConstraint(SpringLayout.EAST, txtOrigem, 0, SpringLayout.EAST, textFiltros);
		txtOrigem.setText("escreva aqui a origem");
		txtOrigem.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(txtOrigem);
		txtOrigem.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		sl_panel.putConstraint(SpringLayout.NORTH, txtOrigem, 1, SpringLayout.NORTH, btnOk);
		sl_panel.putConstraint(SpringLayout.NORTH, btnOk, 62, SpringLayout.SOUTH, btnOkPC);
		sl_panel.putConstraint(SpringLayout.WEST, btnOk, 418, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnOk, -35, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnOkPC, 0, SpringLayout.EAST, btnOk);
		btnOk.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(btnOk);
		
		JCheckBox chckbxData = new JCheckBox("Data");
		sl_panel.putConstraint(SpringLayout.NORTH, chckbxData, 586, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, chckbxData, 44, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, chckbxData, -343, SpringLayout.EAST, panel);
		chckbxData.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(chckbxData);
		
		}
	
	private class LoginAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String config;
		public LoginAction(String config) {
			putValue(NAME, "Configura�oes");
			putValue(SHORT_DESCRIPTION, "Configura��es de Conta");
			this.config=config;
		}
		public void actionPerformed(ActionEvent e) {
			Configuracoes facebook= new Configuracoes(this.config);
		}
	}
}
