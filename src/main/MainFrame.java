package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


public class MainFrame extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private ImageIcon icon1 = new ImageIcon(MainFrame.class.getResource("/main/007.jpg"));
	Image img1 = icon1.getImage();
	Image updateImg1 = img1.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
    ImageIcon updateIcon1 = new ImageIcon(updateImg1);
    private ImageIcon icon2 = new ImageIcon(MainFrame.class.getResource("/main/miracle.jpg"));
    Image img2 = icon2.getImage();
    Image updateImg2 = img2.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
    ImageIcon updateIcon2 = new ImageIcon(updateImg2);
    private ImageIcon icon3 = new ImageIcon(MainFrame.class.getResource("/main/voice.jpg"));
    Image img3 = icon3.getImage();
    Image updateImg3 = img3.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
    ImageIcon updateIcon3 = new ImageIcon(updateImg3);
    private ImageIcon icon4 = new ImageIcon(MainFrame.class.getResource("/main/zzanggu.jpg"));
    Image img4 = icon4.getImage();
    Image updateImg4 = img4.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
    ImageIcon updateIcon4 = new ImageIcon(updateImg4);
    private String userid;
	private JTextField textField;
	private JButton btnLogin;
	private JButton btnjoin;
    public JButton getBtnjoin() {
		return btnjoin;
	}

	public void setBtnjoin(JButton btnjoin) {
		this.btnjoin = btnjoin;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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

	public MainFrame() {
	

		
		setTitle("JAVA CINEMA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JLabel lblNewLabel = new JLabel("자바시네마 온라인예매");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(updateIcon1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(updateIcon2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(updateIcon3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(updateIcon4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 60, 10, 60));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 1, 0, 20));
		
		JButton btn1 = new JButton("영화 정보");
		btn1.addActionListener(this);
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("영화 예매");
		btn2.addActionListener(this);
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("예매 조회");
		btn3.addActionListener(this);
		panel_1.add(btn3);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		setBtnLogin(new JButton("로그인"));
		getBtnLogin().addActionListener(this);
		panel_2.add(getBtnLogin());
		
		btnjoin = new JButton("회원가입");
		btnjoin.addActionListener(this);
		panel_2.add(btnjoin);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		panel_2.add(btnLogout);
		
		

		
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
	      if (cmd.equals("영화 정보")) {
			new MvInfo().setVisible(true);
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("영화 예매")) {
			BookingFrame f=new BookingFrame();
			f.setUserid(userid);
			f.setVisible(true); // 예매화면 띄우기
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("예매 조회")) {
			new MvFindFrame().setVisible(true); // 조회화면 띄우기
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("로그인")) {
			// 로그인상태 아닐때만 작동하게
			new LoginFrame().setVisible(true); // 로그인화면 띄우기
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("회원가입")) {
			// 로그인상태 아닐때만 작동하게
			
			new JoinFrame().setVisible(true); // 로그인화면 띄우기
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("로그아웃")) {
			// 로그인상태시 가진정보 지우고 로그인화면 가게하기
			
			new LoginFrame().setVisible(true); // 로그인화면 띄우기
			setVisible(false); // 현재화면 안보이게
		}
		
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

}