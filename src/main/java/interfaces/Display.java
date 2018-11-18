package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;

import principal.AbstractInfo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Display {

	private JFrame frmDetalhes;
	private JTextPane textPaneAut;
	private JTextPane textPaneDate;
	private JTextPane textPanePost;

	
	public Display(AbstractInfo info) {
		initialize();
		this.textPaneAut.setText(info.getAutor());
		this.textPanePost.setText(info.getPost());
		this.textPaneDate.setText(info.getData().toString());
		frmDetalhes.setVisible(true);
	}

	private void initialize() {
		frmDetalhes = new JFrame();
		frmDetalhes.setTitle("Detalhes");
		frmDetalhes.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmDetalhes.getContentPane().setForeground(SystemColor.textText);
		frmDetalhes.setBounds(100, 100, 800, 540);
		frmDetalhes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmDetalhes.getContentPane().setLayout(springLayout);
		
		JLabel lblAutor = new JLabel("Autor");
		springLayout.putConstraint(SpringLayout.WEST, lblAutor, 145, SpringLayout.WEST, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAutor, -430, SpringLayout.SOUTH, frmDetalhes.getContentPane());
		lblAutor.setFont(new Font("Lucida Fax", Font.BOLD, 24));
		frmDetalhes.getContentPane().add(lblAutor);
		
		JLabel lblData = new JLabel("Data");
		springLayout.putConstraint(SpringLayout.NORTH, lblData, 0, SpringLayout.NORTH, lblAutor);
		springLayout.putConstraint(SpringLayout.EAST, lblData, -228, SpringLayout.EAST, frmDetalhes.getContentPane());
		lblData.setFont(new Font("Lucida Fax", Font.BOLD, 24));
		frmDetalhes.getContentPane().add(lblData);
		
		textPaneAut = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPaneAut, 6, SpringLayout.SOUTH, lblAutor);
		springLayout.putConstraint(SpringLayout.EAST, textPaneAut, 355, SpringLayout.WEST, frmDetalhes.getContentPane());
		textPaneAut.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmDetalhes.getContentPane().add(textPaneAut);
		
		textPaneDate = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPaneDate, 6, SpringLayout.SOUTH, lblData);
		springLayout.putConstraint(SpringLayout.WEST, textPaneDate, 6, SpringLayout.EAST, textPaneAut);
		springLayout.putConstraint(SpringLayout.EAST, textPaneDate, -10, SpringLayout.EAST, frmDetalhes.getContentPane());
		textPaneDate.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmDetalhes.getContentPane().add(textPaneDate);
		
		textPanePost = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, textPaneAut, 0, SpringLayout.WEST, textPanePost);
		textPanePost.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, textPanePost, -374, SpringLayout.SOUTH, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textPanePost, 10, SpringLayout.WEST, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textPanePost, -10, SpringLayout.SOUTH, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textPanePost, 768, SpringLayout.WEST, frmDetalhes.getContentPane());
		frmDetalhes.getContentPane().add(textPanePost);
	}
}
