package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginInterface {

	private JFrame frmLogin;
	private JTextField txUser;
	private JButton btnLogin;
	private String password;
	private String username;
	private boolean valido;
	private JPasswordField txPassword;

	/**
	 * Create the application.
	 */
	public LoginInterface() {
		initialize();
		frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 511, 353);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblLogin.setBounds(45, 56, 69, 31);
		frmLogin.getContentPane().add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblPassword.setBounds(26, 111, 106, 20);
		frmLogin.getContentPane().add(lblPassword);

		txUser = new JTextField();
		txUser.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		txUser.setBounds(129, 56, 289, 30);
		frmLogin.getContentPane().add(txUser);
		txUser.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		btnLogin.setBounds(174, 184, 138, 29);
		frmLogin.getContentPane().add(btnLogin);

		txPassword = new JPasswordField();
		txPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		txPassword.setBounds(129, 105, 289, 31);
		frmLogin.getContentPane().add(txPassword);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean matchFound = false;

				username = txUser.getText();
				password = String.valueOf(txPassword.getPassword());
				Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
				Matcher m = p.matcher(username);
				matchFound = m.matches();
				if (!matchFound) {
					JPanel panel = new JPanel();
					JOptionPane.showMessageDialog(panel, "username inválido", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					valido = true;
					frmLogin.dispose();
				}

			}

		});
	}

	public String getUN() {
		return username;
	}

	public String getPW() {
		return password;
	}

	public boolean isValido() {
		return valido;
	}
}
