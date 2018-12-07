package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.SpringLayout;

import principal.AbstractInfo;
import principal.DateComparator;
import principal.FacebookApp;
import principal.MailApp;
import principal.TwitterApp;
import principal.XMLEditor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Interface {

	private JFrame frame;
	private JPanel panel;
	private SpringLayout sl_panel;
	private JLabel lblFB;
	private JLabel lblTT;
	private JLabel lblM;
	private boolean checkFB=true;
	private boolean checkTT=true;
	private boolean checkM=true;
	JList<AbstractInfo> listPosts;
	DefaultListModel<AbstractInfo> modelPosts= new DefaultListModel<>();
	private JTextField txtFiltros;
	private JTextField txtOrigem;
	private JButton btnFacebook;
	private JButton btnEmail;
	private JButton btnTwitter;
	private TwitterApp ttapp;
	private MailApp mapp;
	private FacebookApp fbapp;
	private JCheckBox chckbxPC;
	private JCheckBox chckbxOrigem;
	private JCheckBox chckbxData;

	private String filtroPC;
	private String filtroOrigem;
	private Date dateIn;
	private Date dateFim;

	private ArrayList<AbstractInfo> aListMain;
	private ArrayList<AbstractInfo> aListRepresent= new ArrayList<AbstractInfo>();
	private ArrayList<AbstractInfo> aListFiltrada=new ArrayList<AbstractInfo>();
	private JMenuItem mntmRemover;
	private JMenu mnApagar;
	private JMenuItem mntmFacebook;
	private JMenuItem mntmTwitter;
	private JMenuItem mntmOutlook;
	private XMLEditor xml= new XMLEditor();
	private JMenuItem mntmCriar;
	private JMenuBar menuBar_1;
	private JMenu mnAdicionar;
	private JMenuItem mntmFacebook_1;
	private JMenuItem mntmTwitter_1;
	private JMenuItem mntmOutlook_1;
	private JMenuItem mntmMostrar;


	/**
	 * Cria a Interface
	 * Associa as variaveis locais
	 * @param ttapp é uma instância do TwitterApp que contém todos os métodos relativos ao twitter
	 * @param mapp é uma instância do MailApp que contém todos os métodos relativos ao mail
	 * @param fbapp é uma instância do FacebookApp que contém todos os métodos relativos ao facebook
	 */
	public Interface(TwitterApp ttapp,MailApp mapp,FacebookApp fbapp) {
		this.ttapp=ttapp;
		this.mapp=mapp;
		this.fbapp=fbapp;
		addToListMain();
		optionList();
		filtrList();
		showList();
		initialize();
		initializeAux();
		frame.setVisible(true);
	}

	/**
	 * Cria a frame inicial e inicia o conteudo da janela
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 1500, 1007);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bom Dia Academia");


		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(SystemColor.textHighlight);
		frame.getContentPane().add(panel);
		sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		btnFacebook = new JButton("");
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
				optionList();
				showList();
				frame.repaint();
			}
		});
		btnFacebook.setToolTipText("");
		sl_panel.putConstraint(SpringLayout.NORTH, btnFacebook, 35, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnFacebook, 91, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnFacebook, -301, SpringLayout.EAST, panel);
		btnFacebook.setIcon(new ImageIcon("src\\main\\java\\facebook.png"));
		panel.add(btnFacebook);

		btnTwitter = new JButton("");
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

				optionList();
				showList();
				frame.repaint();
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnTwitter, 73, SpringLayout.EAST, btnFacebook);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnTwitter, 0, SpringLayout.SOUTH, btnFacebook);
		sl_panel.putConstraint(SpringLayout.EAST, btnTwitter, -62, SpringLayout.EAST, panel);
		btnTwitter.setIcon(new ImageIcon("src\\main\\java\\Twitter-icon.png"));
		panel.add(btnTwitter);

		btnEmail = new JButton("");
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
				optionList();
				showList();
				frame.repaint();

			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnEmail, 48, SpringLayout.SOUTH, btnFacebook);
		sl_panel.putConstraint(SpringLayout.WEST, btnEmail, 127, SpringLayout.WEST, btnFacebook);
		sl_panel.putConstraint(SpringLayout.EAST, btnEmail, -174, SpringLayout.EAST, panel);
		btnEmail.setIcon(new ImageIcon("src\\main\\java\\Gmail-icon.png"));
		panel.add(btnEmail);

		initializeLabel(btnFacebook,btnTwitter,btnEmail);


		listPosts = new JList<AbstractInfo>();
		listPosts.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		listPosts.setModel(modelPosts);

		addListenerLista();

		JScrollPane scrollPane = new JScrollPane(listPosts);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -558, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(scrollPane);

		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		springLayout.putConstraint(SpringLayout.NORTH, lblBomDiaAcademia, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblBomDiaAcademia, -32, SpringLayout.WEST, panel);


		lblBomDiaAcademia.setFont(new Font("Lucida Fax", Font.BOLD, 84));
		frame.getContentPane().add(lblBomDiaAcademia);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnXml = new JMenu("XML");
		mnXml.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		menuBar.add(mnXml);
		
		mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.setAction(new MostrarAction(this));
		mntmMostrar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnXml.add(mntmMostrar);

		mntmCriar = new JMenuItem("Criar");
		mntmCriar.setFont(new Font("Lucida Fax", mntmCriar.getFont().getStyle(), 20));
		mntmCriar.setAction(new CriarAction(this));
		mnXml.add(mntmCriar);

		mntmRemover = new JMenuItem("Remover");
		mntmRemover.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmRemover.setAction(new RemoverAction(this));
		mnXml.add(mntmRemover);

		mnApagar = new JMenu("Apagar");
		mnApagar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnXml.add(mnApagar);

		mntmFacebook = new JMenuItem("Facebook");
		mntmFacebook.setAction(new AuxAction(this, 1));
		mntmFacebook.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnApagar.add(mntmFacebook);

		mntmTwitter = new JMenuItem("Twitter");
		mntmTwitter.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmTwitter.setAction(new AuxAction(this,2));
		mnApagar.add(mntmTwitter);

		mntmOutlook = new JMenuItem("Outlook");
		mntmOutlook.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmOutlook.setAction(new AuxAction(this,3));
		mnApagar.add(mntmOutlook);
		
		mnAdicionar = new JMenu("Adicionar");
		mnAdicionar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnXml.add(mnAdicionar);
		
		mntmFacebook_1 = new JMenuItem("Facebook");
		mntmFacebook_1.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmFacebook_1.setAction(new AuxAction(this,4));
		mnAdicionar.add(mntmFacebook_1);
		
		mntmTwitter_1 = new JMenuItem("Twitter");
		mntmTwitter_1.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmTwitter_1.setAction(new AuxAction(this,5));
		mnAdicionar.add(mntmTwitter_1);
		
		mntmOutlook_1 = new JMenuItem("Outlook");
		mntmOutlook_1.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mntmOutlook_1.setAction(new AuxAction(this,6));
		mnAdicionar.add(mntmOutlook_1);
		
		JMenu mnEnviar = new JMenu("Enviar");
		mnEnviar.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		menuBar.add(mnEnviar);
		
		JMenuItem mntmFacebook_2 = new JMenuItem("Facebook");
		mntmFacebook_2.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnEnviar.add(mntmFacebook_2);
		
		JMenuItem mntmTwitter_2 = new JMenuItem("Twitter");
		mntmTwitter_2.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnEnviar.add(mntmTwitter_2);
		
		JMenuItem mntmOutlook_2 = new JMenuItem("Outlook");
		mntmOutlook_2.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		mnEnviar.add(mntmOutlook_2);

	}


	/**
	 * Adiciona as listas dos pots/tweets/emails à lista main da classe.
	 */
	private void addToListMain() {
		aListMain=new ArrayList<AbstractInfo>();
		aListMain.addAll(ttapp.getList());
		aListMain.addAll(mapp.getMailList());
		aListMain.addAll(fbapp.getList());
		aListMain.sort(new DateComparator());

	}

	/**
	 * Percorre a lista main, adicionando os post ,das fontes de informaçao que se encontram selecionadas
	 * na pesquisa, na lista de representacao
	 */
	public void optionList() {
		if(!aListRepresent.isEmpty())
			aListRepresent.clear();
		for(AbstractInfo info: aListMain) {
			if(checkFB && info.checkFacebook()) {
				aListRepresent.add(info);
			}
			else if(checkM && info.checkEmail()) {
				aListRepresent.add(info);
			}
			else if(checkTT && info.checkTwitter()) {
				aListRepresent.add(info);
			}
		}
		aListRepresent.sort(new DateComparator());
	}

	/**
	 * Percorre a lista main, adicionando os post conforme os filros, à lista filtrada
	 */
	public void filtrList() {
		if(!aListFiltrada.isEmpty())
			aListFiltrada.clear();
		if(filtroPC==null && filtroOrigem==null && dateIn==null && dateFim==null) {
			aListFiltrada.addAll(aListMain);
		}
		else {
			aListFiltrada.addAll(aListMain);
			ArrayList<AbstractInfo> aux=new ArrayList<AbstractInfo>();
			for(AbstractInfo info:aListFiltrada) {
				if(chckbxPC.isSelected()==true && !info.getPost().toString().contains(filtroPC)) {
					aux.add(info);
				}
				if(chckbxOrigem.isSelected()==true && !info.getAutor().toString().equals(filtroOrigem)) {
					aux.add(info);
				}
				if(chckbxData.isSelected()==true && !(info.getData().after(dateIn) && info.getData().before(dateFim)))
					aux.add(info);
			}
			aListFiltrada.removeAll(aux);
		}
	}

	/**
	 * Percorre a lista de representação e seleciona os posts que se encontram
	 * simultâneamente na lista de representação e na lista filtrada
	 */
	private void showList() {
		modelPosts.removeAllElements();
		for(AbstractInfo info: aListRepresent) {
			if(aListFiltrada.contains(info)) {
				modelPosts.add(modelPosts.size(),info);
			}
		}
	}


	/**
	 * Adiciona um listener à lista dos posts para que ao clicar seja aberta uma janela de detalhes
	 */
	private void addListenerLista() {
		listPosts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				@SuppressWarnings({ "unchecked", "rawtypes" })
				JList<AbstractInfo> list = (JList)evt.getSource();
				if (evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
					new Display(modelPosts.getElementAt(index));
				}
			}
		});
	}


	/**
	 * Função que permite ativar os campos dos filtros quando este são selecionados
	 *  @param chcbox para activar ou desactivar componentes
	 *  @param component primeiro componente do filtro
	 *  @param componente2 segundo componente do filtro
	 */
	private void enableComponents(JCheckBox chcbox,JComponent component,JComponent component2) {
		chcbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(component.isEnabled()==false && component2.isEnabled()==false) {
					component.setEnabled(true);
					component2.setEnabled(true);
				}
				else {
					component.setEnabled(false);
					component2.setEnabled(false);
				}


			}});


	}


	/**
	 * Função que permite ativar os campos dos filtros quando este são selecionados
	 *  @param chcbox para activar ou desactivar componentes
	 *  @param component primeiro componente do filtro
	 */
	private void enableComponents(JCheckBox chcbox,JComponent component) {
		chcbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(component.isEnabled()==false) {
					component.setEnabled(true);
				}
				else {
					component.setEnabled(false);
				}


			}});


	}


	/**
	 * Incializar os botões que permitem filtrar as fontes dos posts
	 *  @param btnFacebook botão do Facebook
	 *  @param btnTwitter botão do Twitter
	 *  @param btnEmail botão do Email
	 */
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

	/**
	 * Obter o xml da interface
	 */
	public XMLEditor getXml() {
		return xml;
	}

	/**
	 * Criar a base de dados da Aplicação
	 */
	public void criarXml() {
		xml.createXMLFile(this.fbapp,this.ttapp,this.mapp); 
	}
	
	/**
	 * Remover a base de dados da Aplicação
	 */
	public void removerXml() {
		xml.removeXMLFile();
	}
	
	/**
	 * Incializar os botões do menu de Adicionar/Remover conteúdo da base de dados
	 * @param opcao botão do Email
	 */
	public void auxXml(int opcao) {
		 switch (opcao) {
         case 1:
        	 xml.removeFacebook();
             break;
         case 2:
             xml.removeTwitter();
             break;
         case 3:
             xml.removeOutlook();
             break;
         case 4:
             xml.addFacebookInfo();;
             break;
         case 5:
             xml.addTwitterInfo();;
             break;
         case 6:
             xml.addOutlookInfo();;
             break;
         default:
             break;
         }
	}

	/**
	 * Inicializa o painel auxiliar que vai conter os botes para selecionar as fontes e os filtros.
	 */
	private void initializeAux() {

		txtFiltros = new JTextField();
		txtFiltros.setEnabled(false);
		txtFiltros.setText("escreva aqui o filtro");
		txtFiltros.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(txtFiltros);
		txtFiltros.setColumns(10);
		txtFiltros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtFiltros.isEnabled())
					txtFiltros.setText("");
			}
		});

		JButton btnOk = new JButton("Ok");
		sl_panel.putConstraint(SpringLayout.WEST, btnOk, 206, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnOk, -247, SpringLayout.EAST, panel);
		btnOk.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(btnOk);

		chckbxPC = new JCheckBox("Palavra-chave");
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxPC, -6, SpringLayout.NORTH, txtFiltros);
		chckbxPC.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(chckbxPC);

		chckbxOrigem = new JCheckBox("Origem");
		sl_panel.putConstraint(SpringLayout.WEST, chckbxOrigem, 44, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, chckbxOrigem, -343, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, chckbxPC, 0, SpringLayout.WEST, chckbxOrigem);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtFiltros, -12, SpringLayout.NORTH, chckbxOrigem);
		chckbxOrigem.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(chckbxOrigem);

		txtOrigem = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, txtFiltros, 0, SpringLayout.WEST, txtOrigem);
		sl_panel.putConstraint(SpringLayout.EAST, txtFiltros, 0, SpringLayout.EAST, txtOrigem);
		sl_panel.putConstraint(SpringLayout.WEST, txtOrigem, 105, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtOrigem, -35, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxOrigem, -6, SpringLayout.NORTH, txtOrigem);
		sl_panel.putConstraint(SpringLayout.NORTH, txtOrigem, 566, SpringLayout.NORTH, panel);
		txtOrigem.setEnabled(false);
		txtOrigem.setText("escreva aqui a origem");
		txtOrigem.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(txtOrigem);
		txtOrigem.setColumns(10);
		txtOrigem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtOrigem.isEnabled())
					txtOrigem.setText("");
			}
		});

		chckbxData = new JCheckBox("Data");
		sl_panel.putConstraint(SpringLayout.WEST, chckbxData, 44, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, chckbxData, -343, SpringLayout.EAST, panel);
		chckbxData.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(chckbxData);

		JLabel lblIncio = new JLabel("Início");
		sl_panel.putConstraint(SpringLayout.NORTH, lblIncio, 646, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxData, -6, SpringLayout.NORTH, lblIncio);
		sl_panel.putConstraint(SpringLayout.WEST, lblIncio, 125, SpringLayout.WEST, panel);
		lblIncio.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(lblIncio);

		JLabel lblFim = new JLabel("Fim");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFim, 0, SpringLayout.NORTH, lblIncio);
		sl_panel.putConstraint(SpringLayout.EAST, lblFim, 0, SpringLayout.EAST, btnEmail);
		lblFim.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		panel.add(lblFim);

		JCalendar calendarIn = new JCalendar();
		sl_panel.putConstraint(SpringLayout.NORTH, btnOk, 6, SpringLayout.SOUTH, calendarIn);
		calendarIn.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendarIn.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, calendarIn, 5, SpringLayout.SOUTH, lblIncio);
		sl_panel.putConstraint(SpringLayout.WEST, calendarIn, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, calendarIn, 206, SpringLayout.SOUTH, lblIncio);
		sl_panel.putConstraint(SpringLayout.EAST, calendarIn, 270, SpringLayout.WEST, panel);
		panel.add(calendarIn);

		JCalendar calendarFim = new JCalendar();
		sl_panel.putConstraint(SpringLayout.WEST, calendarFim, 6, SpringLayout.EAST, calendarIn);
		sl_panel.putConstraint(SpringLayout.EAST, calendarFim, -35, SpringLayout.EAST, panel);
		calendarFim.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendarFim.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, calendarFim, 6, SpringLayout.SOUTH, lblFim);
		sl_panel.putConstraint(SpringLayout.SOUTH, calendarFim, 0, SpringLayout.SOUTH, calendarIn);
		panel.add(calendarFim);

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calendarIn.getDate().after(calendarFim.getDate())) {
					filtroPC=txtFiltros.getText();
					filtroOrigem=txtOrigem.getText();
					dateIn=calendarIn.getDate();
					dateFim=calendarFim.getDate();
					filtrList();
					showList();
				}
				else {
					JOptionPane.showMessageDialog(panel, "A data de fim não pode ser inferior a de inicio", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		enableComponents(chckbxPC, txtFiltros);
		enableComponents(chckbxOrigem,txtOrigem);
		enableComponents(chckbxData,calendarIn,calendarFim);

	}

	
	/**
	 * Ação para criar a base de dados
	 */
	private class CriarAction extends AbstractAction {
		Interface inface;

		public CriarAction(Interface inface) {
			putValue(NAME, "Criar");
			putValue(SHORT_DESCRIPTION, "Cria a base de dados");
			this.inface=inface;
		}
		public void actionPerformed(ActionEvent e) {
			inface.criarXml();
			inface.xml.getContent();
		}
	}

	
	/**
	 * Ação para remover a base de dados
	 */
	private class RemoverAction extends AbstractAction {
		Interface inface;

		public RemoverAction(Interface inface) {
			this.inface=inface;
			putValue(NAME, "Remover");
			putValue(SHORT_DESCRIPTION, "Remover a base de dados");
		}
		public void actionPerformed(ActionEvent e) {
			this.inface.removerXml();
		}
	}
	
	/**
	 * Ação para criar os elementos do menu de barra
	 */
	private class AuxAction extends AbstractAction {
		Interface inface;
		int opcao;
		
		public AuxAction(Interface inface,int opcao) {
			this.inface=inface;
			this.opcao=opcao;
			 switch (opcao) {
	         case 1:
	        	 putValue(NAME, "Facebook");
	             break;
	         case 2:
	        	 putValue(NAME, "Twitter");
	             break;
	         case 3:
	        	 putValue(NAME, "Outlook");
	             break;
	         case 4:
	        	 putValue(NAME, "Facebook");
	             break;
	         case 5:
	        	 putValue(NAME, "Twitter");
	             break;
	         case 6:
	        	 putValue(NAME, "Outlook");
	             break;
	         default:
	             break;
	         }
		}
		public void actionPerformed(ActionEvent e) {
			inface.auxXml(opcao);
		}
	}
	
	/**
	 * Ação para mostrar a base de dados
	 */
	private class MostrarAction extends AbstractAction {
		Interface inface;
		
		public MostrarAction(Interface inface) {
			this.inface=inface;
			putValue(NAME, "Mostrar");
			putValue(SHORT_DESCRIPTION, "Mostra a base de dados");
		}
		public void actionPerformed(ActionEvent e) {
			DisplayDB displaydbs=new DisplayDB(inface.getXml().getContent());
		}
	}
}
