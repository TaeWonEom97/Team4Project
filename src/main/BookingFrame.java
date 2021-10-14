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

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;

public class BookingFrame extends JFrame implements ActionListener, ListSelectionListener{

	private JPanel contentPane;
	private JList movie;
	private JList loc;
	ImageIcon icon1 = new ImageIcon(MainFrame.class.getResource("/main/007.jpg"));
	Image img1 = icon1.getImage();
	Image updateImg1 = img1.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
    ImageIcon updateIcon1 = new ImageIcon(updateImg1);
    ImageIcon icon2 = new ImageIcon(MainFrame.class.getResource("/main/miracle.jpg"));
    Image img2 = icon2.getImage();
    Image updateImg2 = img2.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
    ImageIcon updateIcon2 = new ImageIcon(updateImg2);
    ImageIcon icon3 = new ImageIcon(MainFrame.class.getResource("/main/voice.jpg"));
    Image img3 = icon3.getImage();
    Image updateImg3 = img3.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
    ImageIcon updateIcon3 = new ImageIcon(updateImg3);
    ImageIcon icon4 = new ImageIcon(MainFrame.class.getResource("/main/zzanggu.jpg"));
    Image img4 = icon4.getImage();
    Image updateImg4 = img4.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
    ImageIcon updateIcon4 = new ImageIcon(updateImg4);
    JLabel lblNewLabel;

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
		panel.setBorder(new EmptyBorder(20, 40, 20, 40));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 40, 20));
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD604\uC7AC \uC0C1\uC601\uC791", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(scrollPane1);
		
		movie = new JList();
		movie.setFont(new Font("굴림", Font.PLAIN, 22));
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
		movie.addListSelectionListener(this);
		scrollPane1.setViewportView(movie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "\uC0C1\uC601 \uC9C0\uC5ED \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel.add(scrollPane);
		
		loc = new JList();
		loc.setFont(new Font("굴림", Font.PLAIN, 22));
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
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, BorderLayout.EAST);
		lblNewLabel.setPreferredSize(new Dimension(400, 800));
	}

	public void actionPerformed(ActionEvent e) {

		
		
		String cmd = e.getActionCommand();

		if (cmd.equals("시간선택")) {
			// 시간선택화면 띄우기(선택한거 정보가지고 이동)
			new TimeFrame().setVisible(true); // 시간선택화면 띄우기
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// 선택한 영화에 따라서 이미지 변경
		
		JList<String> movie = (JList<String>) e.getSource();
		if (e.getValueIsAdjusting()) {
		if (movie.getSelectedValue().equals("007 노 타임 투 다이")) {
			lblNewLabel.setIcon(updateIcon1);
		} else if (movie.getSelectedValue().equals("기적")) {
			lblNewLabel.setIcon(updateIcon2);
		} else if (movie.getSelectedValue().equals("보이스")) {
			lblNewLabel.setIcon(updateIcon3);
		} else if (movie.getSelectedValue().equals("극장판 짱구는 못말려")) {
			lblNewLabel.setIcon(updateIcon4);
		} else if (movie.getSelectedValue().equals("")) {
			lblNewLabel.setIcon(null);
		}
	}
	}
}
