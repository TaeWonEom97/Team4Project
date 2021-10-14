package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TimeFrame extends JFrame implements ActionListener{

   private JPanel contentPane;
   JButton btntime1;
   JButton btntime2;
   JButton btntime3;
   JButton btntime4;
   JButton btntime5;
   JButton btntime6;
   JButton btntime7;
   JButton btntime8;
   JButton btntime9;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               TimeFrame frame = new TimeFrame();
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
   public TimeFrame() {
      setTitle("JAVA CINEMA");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uC6D0\uD558\uB294 \uC2DC\uAC04\uB300\uB97C \uC120\uD0DD \uD574 \uC8FC\uC138\uC694.");
      lblNewLabel.setFont(new Font("돋움", Font.BOLD, 12));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(86, 10, 275, 31);
      contentPane.add(lblNewLabel);
      
      btntime1 = new JButton("8:30~");
      btntime1.setBounds(32, 46, 113, 31);
      btntime1.addActionListener(this);
      contentPane.add(btntime1);
      
      btntime2 = new JButton("10:00~");
      btntime2.setBounds(170, 46, 113, 31);
      btntime2.addActionListener(this);
      contentPane.add(btntime2);
      
      btntime3 = new JButton("11:45~");
      btntime3.setBounds(311, 46, 113, 31);
      btntime3.addActionListener(this);
      contentPane.add(btntime3);
      
      btntime4 = new JButton("14:00~");
      btntime4.setBounds(32, 101, 113, 31);
      btntime4.addActionListener(this);
      contentPane.add(btntime4);
      
      btntime5 = new JButton("15:30~");
      btntime5.setBounds(170, 101, 113, 31);
      btntime5.addActionListener(this);
      contentPane.add(btntime5);
      
      btntime6 = new JButton("17:45~");
      btntime6.setBounds(311, 101, 113, 31);
      btntime6.addActionListener(this);
      contentPane.add(btntime6);
      
      btntime7 = new JButton("19:15~");
      btntime7.setBounds(32, 156, 113, 31);
      btntime7.addActionListener(this);
      contentPane.add(btntime7);
      
      btntime8 = new JButton("21:00~");
      btntime8.setBounds(170, 156, 113, 31);
      btntime8.addActionListener(this);
      contentPane.add(btntime8);
      
      btntime9 = new JButton("23:00~");
      btntime9.setBounds(311, 156, 113, 31);
      btntime9.addActionListener(this);
      contentPane.add(btntime9);
      
      JButton btnNewButton_9 = new JButton("\uC88C\uC11D\uC120\uD0DD");
      btnNewButton_9.setBounds(45, 211, 100, 31);
      btnNewButton_9.addActionListener(this);
      contentPane.add(btnNewButton_9);
      
      JButton btnNewButton_10 = new JButton("\uC774\uC804\uC73C\uB85C");
      btnNewButton_10.setBounds(183, 211, 100, 31);
      btnNewButton_10.addActionListener(this);
      contentPane.add(btnNewButton_10);
      
      JButton btnNewButton_11 = new JButton("\uCC98\uC74C\uC73C\uB85C");
      btnNewButton_11.setBounds(311, 211, 100, 31);
      btnNewButton_11.addActionListener(this);
      contentPane.add(btnNewButton_11);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   String cmd = e.getActionCommand();
	   
	   switch (cmd) {
	case "8:30~":
		btntime1.setEnabled(false);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "10:00~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(false);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "11:45~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(false);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "14:00~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(false);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "15:30~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(false);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "17:45~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(false);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "19:15~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(false);
		btntime8.setEnabled(true);
		btntime9.setEnabled(true);
		break;
	case "21:00~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(false);
		btntime9.setEnabled(true);
		break;
	case "23:00~":
		btntime1.setEnabled(true);
		btntime2.setEnabled(true);
		btntime3.setEnabled(true);
		btntime4.setEnabled(true);
		btntime5.setEnabled(true);
		btntime6.setEnabled(true);
		btntime7.setEnabled(true);
		btntime8.setEnabled(true);
		btntime9.setEnabled(false);
		break;
		
	default:
		break;
	}
	   
	   if (cmd.equals("좌석선택")) {
		   // 좌석선택 화면 띄우기

			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("이전으로")) {
			// 영화예매화면 띄우기
			new BookingFrame().setVisible(true);
			setVisible(false); // 현재화면 안보이게
			
		} else if (cmd.equals("처음으로")) {
			// 현재까지 가진 정보 지우고 메인화면으로 이동
			
			new MainFrame().setVisible(true); // 메인화면 띄우기
			setVisible(false); // 현재화면 안보이게
		}
	   
   }

}
