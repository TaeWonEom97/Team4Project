package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import dto.UserDTO;
import java.awt.Toolkit;

public class JoinFrame extends JFrame implements ActionListener {

   private JPanel tfjoin;
   private JLabel lblJoin;
   private JTextField tfUsername;
   private JTextField tfPassword;
   private JTextField tfName;
   private JTextField tfPhone;
   private JButton tfjoin2;
   private JButton tfcancel;
   private JButton dbcheck;
   Scanner sc = new Scanner(System.in);
   UserDAO dao = new UserDAO();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      // JOptionPane.showMessageDialog(null, "로그인 성공");
      // JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인하세요.");
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               JoinFrame frame = new JoinFrame();

            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }


   /**
    * Create the frame.
    */
   public JoinFrame() {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(JoinFrame.class.getResource("/main/movie.png")));
      setTitle("JAVA CINEMA 회원가입");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(459, 490);
      setLocationRelativeTo(null);
      tfjoin = new JPanel();
      tfjoin.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(tfjoin);
      tfjoin.setLayout(null);

      lblJoin = new JLabel("회원가입");
      lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
      lblJoin.setFont(new Font("돋움", Font.BOLD, 25));
      lblJoin.setBounds(138, 26, 150, 35);
      tfjoin.add(lblJoin);

      JLabel lblUsername = new JLabel("비밀번호");
      lblUsername.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      lblUsername.setBounds(36, 168, 69, 20);
      tfjoin.add(lblUsername);

      JLabel label = new JLabel("아이디");
      label.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      label.setBounds(36, 118, 69, 20);
      tfjoin.add(label);

      JLabel lblName = new JLabel("이름");
      lblName.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      lblName.setBounds(36, 215, 69, 20);
      tfjoin.add(lblName);

      tfUsername = new JTextField();
      tfUsername.setColumns(10);
      tfUsername.setBounds(126, 111, 186, 35);
      tfjoin.add(tfUsername);
      // 버튼을 누르면 창 전환되는 것

      tfPassword = new JPasswordField();
      tfPassword.setColumns(10);
      tfPassword.setBounds(126, 161, 186, 35);
      tfjoin.add(tfPassword);

      tfName = new JTextField();
      tfName.setColumns(10);
      tfName.setBounds(126, 208, 186, 35);
      tfjoin.add(tfName);

      tfjoin2 = new JButton("\uD68C\uC6D0\uAC00\uC785");
      tfjoin2.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      tfjoin2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("회원가입")) {
               String userid = tfUsername.getText();
               String username = tfName.getText();
               String userpwd = tfPassword.getText();
               UserDTO dto = new UserDTO(userid, username, userpwd);
               // System.out.println(dao.insert(dto)?"가입성공" :"실패")

               if (dao.insert(dto) == true) {
                  JOptionPane.showMessageDialog(null, "가입성공");
                  new MainFrame().setVisible(true); // 메인화면 보이게
                  setVisible(false); // 현재화면 안보이게
               } else {
                  JOptionPane.showMessageDialog(null, "실패: 올바르게 작성해주세요");
               }
               System.out.println();
            }
         }
         // });
         // JOptionPane.showMessageDialog(null, "가입성공");
         // JOptionPane.showMessageDialog(null, "실패: 올바르게 작성해주세요");
      });
      tfjoin2.setBounds(75, 333, 141, 35);
      tfjoin.add(tfjoin2);

      tfcancel = new JButton("\uCDE8\uC18C");
      tfcancel.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      tfcancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new MainFrame().setVisible(true); // 조회화면 띄우기
            setVisible(false);
         }
      });
      tfcancel.setBounds(228, 333, 141, 35);
      tfjoin.add(tfcancel);

      dbcheck = new JButton("\uC911\uBCF5\uD655\uC778");
      dbcheck.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      dbcheck.setBounds(332, 112, 93, 35);
      dbcheck.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("중복확인")) {
               String userid = tfUsername.getText();

               if (userid.equals("")) {
                  JOptionPane.showMessageDialog(null, "id를 입력해주세요");
               } else {
                  if (dao.getRow2(userid) == true) {
                     JOptionPane.showMessageDialog(null, "중복입니다.다시 입력해주세요");
                  } else {
                     JOptionPane.showMessageDialog(null, "사용가능합니다.");
                  }
                  System.out.println();
               }
            }
         }

      });
      tfjoin.add(dbcheck);

      setVisible(true);
}

   @Override
   public void actionPerformed(ActionEvent e) {

   }
}