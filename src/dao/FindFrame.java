package mainmenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FindFrame extends JFrame implements ActionListener {

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               FindFrame frame = new FindFrame();
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
   public FindFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.NORTH);
      
      JLabel lblNewLabel = new JLabel("예매 확인");
      panel.add(lblNewLabel);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBorder(new EmptyBorder(0, 40, 0, 40));
      contentPane.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(new GridLayout(4, 2, 0, 0));
      
      JLabel lbl1 = new JLabel("영화 제목 : ");
      panel_1.add(lbl1);
      
      JLabel lblmname = new JLabel("");
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
      
      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.SOUTH);
      
      JButton btnok = new JButton("확인");
      btnok.addActionListener(this);
      panel_2.add(btnok);
      
      JButton btnout = new JButton("로그아웃");
      btnout.addActionListener(this);
      panel_2.add(btnout);
   }

   public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();
      
      if (cmd.equals("확인")) {
         new MainFrame().setVisible(true); // 메인화면 보이게
         setVisible(false); // 현재화면 안보이게
         
      } else if (cmd.equals("로그아웃")) {
         // 가진정보 지우고 로그인화면 띄우기
         new LoginFrame().setVisible(true); // 로그인화면 띄우기
         setVisible(false); // 현재화면 안보이게
      }
      
   }

}