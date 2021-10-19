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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.UserDAO;
import dto.UserDTO;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;

public class BookingFrame extends JFrame implements ActionListener, ListSelectionListener {

   private JPanel contentPane;
   JLabel lblNewLabel;
   JList movie;
   JList loc;
   JList time;
   JLabel lblmovie;
   JLabel lblmvcode;
   JLabel lblloc;
   JLabel lbltime;
   
   ImageIcon icon1 = new ImageIcon(MainFrame.class.getResource("/main/007.jpg"));
   Image img1 = icon1.getImage();
   Image updateImg1 = img1.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
   ImageIcon updateIcon1 = new ImageIcon(updateImg1);
   ImageIcon icon2 = new ImageIcon(MainFrame.class.getResource("/main/miracle.jpg"));
   Image img2 = icon2.getImage();
   Image updateImg2 = img2.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
   ImageIcon updateIcon2 = new ImageIcon(updateImg2);
   ImageIcon icon3 = new ImageIcon(MainFrame.class.getResource("/main/voice.jpg"));
   Image img3 = icon3.getImage();
   Image updateImg3 = img3.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
   ImageIcon updateIcon3 = new ImageIcon(updateImg3);
   ImageIcon icon4 = new ImageIcon(MainFrame.class.getResource("/main/zzanggu.jpg"));
   Image img4 = icon4.getImage();
   Image updateImg4 = img4.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
   ImageIcon updateIcon4 = new ImageIcon(updateImg4);
   private UserDAO dao;
   String mname;
   String mloc;
   String mtime;
   String mvcode;

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
      setBounds(100, 100, 800, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);

      JPanel panel = new JPanel();
      panel.setBorder(new EmptyBorder(10, 40, 10, 40));
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(0, 1, 40, 20));

      JScrollPane scrollPane1 = new JScrollPane();
      scrollPane1.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
            "\uD604\uC7AC \uC0C1\uC601\uC791", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
      panel.add(scrollPane1);

      movie = new JList();
      movie.setFont(new Font("굴림", Font.PLAIN, 22));
      movie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      movie.setModel(new AbstractListModel() {
         String[] values = new String[] { "007 노 타임 투 다이", "보이스", "기적", "극장판 짱구는 못말려" };

         public int getSize() {
            return values.length;
         }

         public Object getElementAt(int index) {
            return values[index];
         }
      });
      movie.addListSelectionListener(this);
      scrollPane1.setViewportView(movie);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setViewportBorder(new TitledBorder(null, "\uC0C1\uC601 \uC9C0\uC5ED \uC120\uD0DD",
            TitledBorder.LEADING, TitledBorder.TOP, null, null));

      panel.add(scrollPane);

      loc = new JList();
      loc.setFont(new Font("굴림", Font.PLAIN, 22));
      loc.setModel(new AbstractListModel() {
         String[] values = new String[] { "종로점", "강남점", "홍대점" };

         public int getSize() {
            return values.length;
         }

         public Object getElementAt(int index) {
            return values[index];
         }
      });
      loc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      loc.setToolTipText("");
      loc.addListSelectionListener(this);
      scrollPane.setViewportView(loc);

      JScrollPane scrollPane2 = new JScrollPane();
      scrollPane2.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
            "\uC2DC\uAC04 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
      panel.add(scrollPane2);

      time = new JList();
      time.setFont(new Font("굴림", Font.PLAIN, 22));
      time.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      time.setModel(new AbstractListModel() {
         String[] values = new String[] { "09:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00" };

         public int getSize() {
            return values.length;
         }

         public Object getElementAt(int index) {
            return values[index];
         }
      });
      time.addListSelectionListener(this);
      scrollPane2.setViewportView(time);

      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.SOUTH);

      JButton btn1 = new JButton("좌석선택");
      btn1.addActionListener(this);
      panel_2.add(btn1);

      JButton btn2 = new JButton("취소");
      btn2.addActionListener(this);
      panel_2.add(btn2);

      JButton btn3 = new JButton("처음으로");
      btn3.addActionListener(this);
      panel_2.add(btn3);

      JPanel panel_1 = new JPanel();
      contentPane.add(panel_1, BorderLayout.EAST);
      panel_1.setLayout(new GridLayout(0, 1, 0, 0));

      lblNewLabel = new JLabel("");
      lblNewLabel.setPreferredSize(new Dimension(400, 800));
      panel_1.add(lblNewLabel);

      JPanel panel_3 = new JPanel();
      panel_3.setBorder(new EmptyBorder(0, 50, 0, 0));
      panel_1.add(panel_3);
      panel_3.setLayout(new GridLayout(0, 1, 0, 0));

      lblmovie = new JLabel("");
      lblmovie.setFont(new Font("D2Coding", Font.BOLD, 25));
      panel_3.add(lblmovie);
      
      lblmvcode = new JLabel("");
      lblmvcode.setFont(new Font("D2Coding", Font.BOLD, 23));
      panel_3.add(lblmvcode);

      lblloc = new JLabel("");
      lblloc.setFont(new Font("D2Coding", Font.BOLD, 25));
      panel_3.add(lblloc);

      lbltime = new JLabel("");
      lbltime.setFont(new Font("D2Coding", Font.BOLD, 25));
      panel_3.add(lbltime);
   }

   public void actionPerformed(ActionEvent e) {

      String cmd = e.getActionCommand();


      if (cmd.equals("좌석선택")) {

         if (movie.getSelectedValue() == null || loc.getSelectedValue() == null || time.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "영화, 지점, 시간을 선택해 주세요");
         } else {
           SeatFrame f=new SeatFrame();
         f.setMvName(lblmovie.getText());
         f.setMvLoc(lblloc.getText());
         f.setMvTime(lbltime.getText());
         f.setMvCode(lblmvcode.getText());
         
         f.setVisible(true); // 시간선택화면 띄우기
            setVisible(false); // 현재화면 안보이게
         }

      } else if (cmd.equals("취소")) {
         // 선택한거 취소
         movie.clearSelection();
         loc.clearSelection();
         time.clearSelection();
         lblNewLabel.setIcon(null);
         lblmovie.setText("");
         lblloc.setText("");
         lbltime.setText("");
         lblmvcode.setText("");

      } else if (cmd.equals("처음으로")) {
         new MainFrame().setVisible(true); // 메인화면 띄우기
         setVisible(false); // 현재화면 안보이게
      }
      

   }
   
   @Override
   public void valueChanged(ListSelectionEvent e) {
      // 선택한 영화에 따라서 이미지 변경
      
      JList<String> select = (JList<String>) e.getSource();
      if (e.getValueIsAdjusting()) {
      if (select.getSelectedValue().equals("007 노 타임 투 다이")) {
         lblNewLabel.setIcon(updateIcon1);
         lblmovie.setText((select.getSelectedValue()));
         lblmvcode.setText("M1");
      } else if (select.getSelectedValue().equals("보이스")) {
         lblNewLabel.setIcon(updateIcon2);
         lblmovie.setText((select.getSelectedValue()));
         lblmvcode.setText("M2");
      } else if (select.getSelectedValue().equals("기적")) {
         lblNewLabel.setIcon(updateIcon3);
         lblmovie.setText((select.getSelectedValue()));
         lblmvcode.setText("M3");
      } else if (select.getSelectedValue().equals("극장판 짱구는 못말려")) {
         lblNewLabel.setIcon(updateIcon4);
         lblmovie.setText((select.getSelectedValue()));
         lblmvcode.setText("M4");
      }
   }
      if (e.getValueIsAdjusting()) {
      if (select.getSelectedValue().equals("종로점")) {
         lblloc.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("강남점")) {
         lblloc.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("홍대점")) {
         lblloc.setText((select.getSelectedValue()));
      }
      }
      // "09:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00"
      if (e.getValueIsAdjusting()) {
      if (select.getSelectedValue().equals("09:00")) {
         lbltime.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("11:00")) {
         lbltime.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("13:00")) {
         lbltime.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("15:00")) {
         lbltime.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("17:00")) {
         lbltime.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("19:00")) {
         lbltime.setText((select.getSelectedValue()));
      } else if (select.getSelectedValue().equals("21:00")) {
         lbltime.setText((select.getSelectedValue()));
      }
      
      }
   }
}