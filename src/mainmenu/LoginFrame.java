package mainmenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;

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
      setTitle("JAVA CINEMA");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 600);
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
      
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      textField_2.setBounds(217, 167, 124, 37);
      contentPane.add(textField_2);
      
      JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
      btnNewButton.setBounds(228, 230, 112, 23);
      contentPane.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778");
      btnNewButton_1.setBounds(81, 230, 112, 23);
      contentPane.add(btnNewButton_1);
   }

}