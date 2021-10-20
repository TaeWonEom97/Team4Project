package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import dto.UserDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Toolkit;


public class FindFrame extends JFrame implements ActionListener {

   private JPanel contentPane;
   UserDAO dao = new UserDAO();
   private String userid;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               FindFrame frame = new FindFrame();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the frame.
    */
   public FindFrame(String userid) {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(FindFrame.class.getResource("/main/movie.png")));
   	setTitle("JAVA CINEMA-예매 확인");
	   
	   this.userid=userid;
	   
	   
	  UserDTO dto = dao.getRow1(userid);   
	   
	   
	   
	   
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
      
      JLabel lblmname = new JLabel(dto.getMvname());
      
      panel_1.add(lblmname);
      
      JLabel lbl2 = new JLabel("상영 지역 : ");
      panel_1.add(lbl2);
      
      JLabel lblloc = new JLabel(dto.getLoc());
      panel_1.add(lblloc);
      
      JLabel lbl3 = new JLabel("상영 시간 : ");
      panel_1.add(lbl3);
      
      JLabel lbltime = new JLabel(dto.getMvtime());
      panel_1.add(lbltime);
      
      JLabel lbl4 = new JLabel("좌석 번호 : ");
      panel_1.add(lbl4);
      
      JLabel lblsitnum = new JLabel(dto.getSitnum());
      panel_1.add(lblsitnum);
      
      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.SOUTH);
      
      JButton btnok = new JButton("확인");
      btnok.addActionListener(this);
      panel_2.add(btnok);
      
      JButton btnout = new JButton("예매취소");
      btnout.addActionListener(this);
      panel_2.add(btnout);
   }

   public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();
      
      if (cmd.equals("확인")) {
    	  MainFrame f=new MainFrame();
          f.getBtnLogin().setVisible(false);
          f.getBtnjoin().setVisible(false);
          f.setVisible(true);
          setVisible(false);
         
      } else if (cmd.equals("예매취소")) {
         // 가진정보 지우고 로그인화면 띄우기
    	  if(dao.deleteMv(userid)==true) {
    		  JOptionPane.showMessageDialog(null, "예매취소성공");
    		  MainFrame f=new MainFrame();
              f.getBtnLogin().setVisible(false);
              f.getBtnjoin().setVisible(false);
          
              f.setVisible(true);
           
    	         setVisible(false); // 현재화면 안보이게
    	  }else {
              JOptionPane.showMessageDialog(null, "예매취소실패");
           }
    	  
    	  
         
      }
      
   }

}