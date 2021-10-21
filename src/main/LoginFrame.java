package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JButton btnLogin;
	private JButton btnjoin;

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnjoin() {
		return btnjoin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public void setBtnjoin(JButton btnjoin) {
		this.btnjoin = btnjoin;
	}

	UserDAO dao = new UserDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/main/movie.png")));
		setTitle("JAVA CINEMA-로그인");
		setTitle("JAVA CINEMA 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("돋움", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\uC790\uBC14\uC2DC\uB124\uB9C8 \uC628\uB77C\uC778 \uC601\uD654 \uC608\uC57D");
		textField.setBounds(0, 0, 436, 83);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("돋움", Font.BOLD, 15));
		lblNewLabel.setBounds(81, 106, 124, 37);
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("돋움", Font.BOLD, 15));
		lblPw.setBounds(81, 167, 124, 37);
		contentPane.add(lblPw);

		textField_1 = new JTextField();
		textField_1.setBounds(217, 106, 124, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(217, 167, 124, 37);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(228, 230, 112, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MainFrame().setVisible(true); // 조회화면 띄우기
				setVisible(false);
			}
		});

		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778");
		btnNewButton_1.setBounds(81, 230, 112, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String userid = textField_1.getText();
				String userpwd = textField_2.getText();
//            UserDTO dto = new UserDTO(userid,userpwd);
				if (dao.getRow(userid, userpwd) != null) {
					JOptionPane.showMessageDialog(null, "로그인성공\n" + userid + "님 환영합니다.");
					MainFrame f = new MainFrame();
					f.getBtnLogin().setVisible(false);
					f.getBtnjoin().setVisible(false);
					f.setUserid(userid);
					f.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				System.out.println();

			}
		});
	}

}