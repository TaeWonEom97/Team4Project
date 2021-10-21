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
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class LoginFrame extends JFrame {

   private JPanel contentPane;
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
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 350);
      contentPane = new JPanel();
      
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));

      JPanel panel = new JPanel();
      panel.setBorder(new EmptyBorder(10, 0, 10, 0));
      panel.setBackground(Color.WHITE);
      contentPane.add(panel, BorderLayout.NORTH);
      
      JLabel lblNewLabel_1 = new JLabel("자바시네마 온라인 예매");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setFont(new Font("휴먼엑스포", Font.BOLD, 25));
      panel.add(lblNewLabel_1);
      
      JPanel panel_1 = new JPanel();
      FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
      flowLayout.setHgap(30);
      panel_1.setBorder(new EmptyBorder(5, 0, 25, 0));
      contentPane.add(panel_1, BorderLayout.SOUTH);
      
      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.CENTER);
      panel_2.setLayout(null);

      JLabel lblNewLabel = new JLabel("ID");
      lblNewLabel.setBounds(79, 27, 92, 45);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("휴먼엑스포", Font.BOLD, 17));
      panel_2.add(lblNewLabel);

      JLabel lblPw = new JLabel("PW");
      lblPw.setBounds(66, 87, 117, 52);
      lblPw.setHorizontalAlignment(SwingConstants.CENTER);
      lblPw.setFont(new Font("휴먼엑스포", Font.BOLD, 17));
      panel_2.add(lblPw);

      textField_1 = new JTextField();
      textField_1.setBounds(188, 32, 150, 35);
      panel_2.add(textField_1);
      textField_1.setColumns(10);

      textField_2 = new JPasswordField();
      textField_2.setBounds(188, 96, 150, 35);
      textField_2.setColumns(10);
      panel_2.add(textField_2);


      JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778");
      btnNewButton_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      panel_1.add(btnNewButton_1);
      
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
      JButton btnNewButton = new JButton("취소");
      btnNewButton.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      panel_1.add(btnNewButton);
      btnNewButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            new MainFrame().setVisible(true); // 조회화면 띄우기
            setVisible(false);
         }
      });
   }
}