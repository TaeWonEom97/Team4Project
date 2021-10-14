package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Color;

public class BookingFrame extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JList movie;
   private JList loc;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BookingFrame frame = new BookingFrame();
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
   public BookingFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      panel.setBorder(new EmptyBorder(20, 40, 20, 40));
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(0, 2, 40, 0));
      
      JScrollPane scrollPane1 = new JScrollPane();
      panel.add(scrollPane1);
      
      movie = new JList();
      movie.setBorder(new TitledBorder(null, "\uD604\uC7AC \uC0C1\uC601\uC791", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
      movie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      movie.setModel(new AbstractListModel() {
         String[] values = new String[] {"007 노 타임 투 다이", "보이스", "기적", "극장판 짱구는 못말려"};
         public int getSize() {
            return values.length;
         }
         public Object getElementAt(int index) {
            return values[index];
         }
      });
      scrollPane1.setViewportView(movie);
      
      JScrollPane scrollPane = new JScrollPane();
      panel.add(scrollPane);
      
      loc = new JList();
      loc.setBorder(new TitledBorder(null, "\uC0C1\uC601 \uC9C0\uC5ED \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
      loc.setModel(new AbstractListModel() {
         String[] values = new String[] {"종로점", "강남점", "홍대점"};
         public int getSize() {
            return values.length;
         }
         public Object getElementAt(int index) {
            return values[index];
         }
      });
      loc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      loc.setToolTipText("");
      scrollPane.setViewportView(loc);
      
      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.SOUTH);
      
      JButton btn1 = new JButton("시간선택");
      btn1.addActionListener(this);
      panel_2.add(btn1);
      
      JButton btn2 = new JButton("취소");
      btn2.addActionListener(this);
      panel_2.add(btn2);
      
      JButton btn3 = new JButton("처음으로");
      btn3.addActionListener(this);
      panel_2.add(btn3);
   }

   public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();

      if (cmd.equals("시간선택")) {
    	  new TimeFrame().setVisible(true);
         // 시간선택화면 띄우기(선택한거 정보가지고 이동)
         
         setVisible(false); // 현재화면 안보이게
         
      } else if (cmd.equals("취소")) {
         // 선택한거 취소
         movie.clearSelection();
         loc.clearSelection();
         
      } else if (cmd.equals("처음으로")) {
         // 선택한거 취소하고 메인화면으로
         movie.clearSelection();
         loc.clearSelection();
         new MainFrame().setVisible(true); // 메인화면 띄우기
         setVisible(false); // 현재화면 안보이게
      }
      
   }

}