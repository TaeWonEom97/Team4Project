package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayFrame frame = new PayFrame();
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
	public PayFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("예매내용을 확인후 결제를 진행해 주세요.");
		panel.add(lblNewLabel);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 40, 0, 40));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lbl1 = new JLabel("영화 제목 : ");
		panel_1.add(lbl1);
		
		JLabel lblmname = new JLabel();
		panel_1.add(lblmname);
		
		JLabel lbl2 = new JLabel("상영 지역 : ");
		panel_1.add(lbl2);
		
		JLabel lblloc = new JLabel("");
		panel_1.add(lblloc);
		
		JLabel lbl3 = new JLabel("상영 시간 : ");
		panel_1.add(lbl3);
		
		JLabel lbltime = new JLabel("");
		panel_1.add(lbltime);
		
		JLabel lbl4 = new JLabel("좌석 번호 : ");
		panel_1.add(lbl4);
		
		JLabel lblsitnum = new JLabel("");
		panel_1.add(lblsitnum);
		
		JLabel lbl5 = new JLabel("결제 금액 : ");
		panel_1.add(lbl5);
		
		JLabel lblpay = new JLabel("");
		panel_1.add(lblpay);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btn1 = new JButton("카드결제");
		btn1.addActionListener(this);
		panel_2.add(btn1);
		
		JButton btn2 = new JButton("이전으로");
		btn2.addActionListener(this);
		panel_2.add(btn2);
		
		JButton btn3 = new JButton("처음으로");
		btn3.addActionListener(this);
		panel_2.add(btn3);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("카드결제")) {
			JOptionPane.showMessageDialog(null, "결제 완료"); // 팝업창 띄우기
			new MainFrame().setVisible(true); // 메인화면 띄우기
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("이전으로")) {
			// 좌석선택화면 띄우기
			
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("처음으로")) {
			// 현재까지 가진 정보 지우고 메인화면으로 이동
			
			new MainFrame().setVisible(true); // 메인화면 띄우기
			setVisible(false); // 현재화면 안보이게
		}
		
	}


}
