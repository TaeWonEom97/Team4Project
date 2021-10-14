package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class TimeFrame extends JFrame {

   private JPanel contentPane;

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
      
      JButton btnNewButton = new JButton("8:30~");
      btnNewButton.setBounds(32, 46, 113, 31);
      contentPane.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("10:00~");
      btnNewButton_1.setBounds(170, 46, 113, 31);
      contentPane.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("11:45~");
      btnNewButton_2.setBounds(311, 46, 113, 31);
      contentPane.add(btnNewButton_2);
      
      JButton btnNewButton_3 = new JButton("14:00~");
      btnNewButton_3.setBounds(32, 101, 113, 31);
      contentPane.add(btnNewButton_3);
      
      JButton btnNewButton_4 = new JButton("15:30~");
      btnNewButton_4.setBounds(32, 156, 113, 31);
      contentPane.add(btnNewButton_4);
      
      JButton btnNewButton_5 = new JButton("17:45~");
      btnNewButton_5.setBounds(170, 101, 113, 31);
      contentPane.add(btnNewButton_5);
      
      JButton btnNewButton_6 = new JButton("19:15~");
      btnNewButton_6.setBounds(170, 156, 113, 31);
      contentPane.add(btnNewButton_6);
      
      JButton btnNewButton_7 = new JButton("21:00~");
      btnNewButton_7.setBounds(311, 101, 113, 31);
      contentPane.add(btnNewButton_7);
      
      JButton btnNewButton_8 = new JButton("23:00~");
      btnNewButton_8.setBounds(311, 156, 113, 31);
      contentPane.add(btnNewButton_8);
      
      JButton btnNewButton_9 = new JButton("\uC88C\uC11D\uC120\uD0DD");
      btnNewButton_9.setBounds(45, 211, 100, 31);
      contentPane.add(btnNewButton_9);
      
      JButton btnNewButton_10 = new JButton("\uC774\uC804\uC73C\uB85C");
      btnNewButton_10.setBounds(183, 211, 100, 31);
      contentPane.add(btnNewButton_10);
      
      JButton btnNewButton_11 = new JButton("\uCC98\uC74C\uC73C\uB85C");
      btnNewButton_11.setBounds(311, 211, 100, 31);
      contentPane.add(btnNewButton_11);
   }
   

}