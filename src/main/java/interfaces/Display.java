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
import javax.swing.JScrollPane;

public class Display {

	private JFrame frmDetalhes;
	private JTextPane textPaneAut;
	private JTextPane textPaneDate;
	private JTextPane textPanePost;
	private SpringLayout springLayout;
	private JScrollPane scrollPane_1;

	
	public Display(AbstractInfo info) {
		initialize();
		this.textPaneAut.setText(info.getAutor());
		this.textPanePost.setText(info.getPost());
		this.textPaneDate.setText(info.getData().toString());
		
		
	}

	private void initialize() {
		frmDetalhes = new JFrame();
		frmDetalhes.setTitle("Detalhes");
		frmDetalhes.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmDetalhes.getContentPane().setForeground(SystemColor.textText);
		frmDetalhes.setBounds(100, 100, 800, 540);
		frmDetalhes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		springLayout = new SpringLayout();
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
		springLayout.putConstraint(SpringLayout.WEST, textPaneAut, 0, SpringLayout.WEST, frmDetalhes.getContentPane());
		textPaneAut.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmDetalhes.getContentPane().add(textPaneAut);
		
		textPaneDate = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, textPaneDate, 361, SpringLayout.WEST, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textPaneAut, -6, SpringLayout.WEST, textPaneDate);
		springLayout.putConstraint(SpringLayout.NORTH, textPaneDate, 6, SpringLayout.SOUTH, lblData);
		springLayout.putConstraint(SpringLayout.EAST, textPaneDate, -10, SpringLayout.EAST, frmDetalhes.getContentPane());
		textPaneDate.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		frmDetalhes.getContentPane().add(textPaneDate);
		
		textPanePost = new JTextPane();
		textPanePost.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		
		scrollPane_1 = new JScrollPane(textPanePost);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 8, SpringLayout.SOUTH, textPaneAut);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 0, SpringLayout.WEST, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 0, SpringLayout.SOUTH, frmDetalhes.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 0, SpringLayout.EAST, textPaneDate);
		frmDetalhes.getContentPane().add(scrollPane_1);
		frmDetalhes.setVisible(true);
	}
}
