package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener{

   private JPanel contentPane;

   /**
    * Launch the application.
    */
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
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.NORTH);
      
      JLabel lblNewLabel = new JLabel("자바시네마 온라인예매");
      panel.add(lblNewLabel);
      
      JPanel panel_1 = new JPanel();
      contentPane.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(new GridLayout(3, 1, 0, 0));
      
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
      
      JButton btnLogin = new JButton("로그인");
      btnLogin.addActionListener(this);
      panel_2.add(btnLogin);
      
      JButton btnLogout = new JButton("로그아웃");
      btnLogout.addActionListener(this);
      panel_2.add(btnLogout);
   }

   public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();
      
      if (cmd.equals("영화정보")) {
         // 영화정보화면 띄우기
         
         setVisible(false); // 현재화면 안보이게
         
      } else if (cmd.equals("영화 예매")) {
         new BookingFrame().setVisible(true); // 예매화면 띄우기
         setVisible(false); // 현재화면 안보이게
         
      } else if (cmd.equals("예매 조회")) {
         new MvFindFrame().setVisible(true); // 조회화면 띄우기
         setVisible(false); // 현재화면 안보이게
         
      } else if (cmd.equals("로그인")) {
         // 로그인화면 띄우기(로그인상태 아닐때만)
         new LoginFrame().setVisible(true);
         setVisible(false); // 현재화면 안보이게
         
      } else if (cmd.equals("로그아웃")) {
         // 로그인화면 띄우기(로그인상태시 가진정보 지우고)
         
         setVisible(false); // 현재화면 안보이게
      }
      
   }

}