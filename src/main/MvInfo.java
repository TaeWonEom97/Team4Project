package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.UserDAO;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class MvInfo extends JFrame implements ActionListener , ListSelectionListener {
	private static final int String = 0;
	private JPanel contentPane;
	JList list;
	JLabel lblNewLabel;
	JButton btnNewButton;
	private ImageIcon icon1 = new ImageIcon(MainFrame.class.getResource("/main/007포스터.jpg"));
	Image img1 = icon1.getImage();
	Image updateImg1 = img1.getScaledInstance(400,520, Image.SCALE_SMOOTH);
    ImageIcon updateIcon1 = new ImageIcon(updateImg1);
    private ImageIcon icon2 = new ImageIcon(MainFrame.class.getResource("/main/miracleposter.jpg"));
    Image img2 = icon2.getImage();
    Image updateImg2 = img2.getScaledInstance(400,520, Image.SCALE_SMOOTH);
    ImageIcon updateIcon2 = new ImageIcon(updateImg2);
    private ImageIcon icon3 = new ImageIcon(MainFrame.class.getResource("/main/voiceposter.jpg"));
    Image img3 = icon3.getImage();
    Image updateImg3 = img3.getScaledInstance(400,520, Image.SCALE_SMOOTH);
    ImageIcon updateIcon3 = new ImageIcon(updateImg3);
    private ImageIcon icon4 = new ImageIcon(MainFrame.class.getResource("/main/zzangguposter.jpg"));
    Image img4 = icon4.getImage();
    Image updateImg4 = img4.getScaledInstance(400,520, Image.SCALE_SMOOTH);
    ImageIcon updateIcon4 = new ImageIcon(updateImg4);
    
    private UserDAO dao;
    String userid;
    public void setUserid(String userid) {
     	this.userid = userid;
     }
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MvInfo frame = new MvInfo();
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
	public MvInfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MvInfo.class.getResource("/main/movie.png")));
		setTitle("JAVA CINEMA-영화 조회");
		setTitle("JAVA CINEMA 영화 정보 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("처음으로");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"007 노 타임 투 다이", "", "기적", "", "보이스", "", "극장판 짱구는 못말려"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("굴림", Font.BOLD, 20));
		list.addListSelectionListener(this);
		panel_1.add(list);
		
		lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
	}
       


	@Override
	public void actionPerformed(ActionEvent e) {
	
		String cmd = e.getActionCommand();
		
		
	    if  (cmd.equals("처음으로")) {
	    	 MainFrame f=new MainFrame();
             f.setVisible(true);
             setVisible(false);
	    }
	}   

  
		
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList<String> select = (JList<String>) e.getSource();
		   if (e.getValueIsAdjusting()) {
		if (select.getSelectedValue().equals("007 노 타임 투 다이")) {
			lblNewLabel.setIcon(updateIcon1);
		   } else if (select.getSelectedValue().equals("기적")) {
		      lblNewLabel.setIcon(updateIcon2);
		   } else if (select.getSelectedValue().equals("보이스")) {
		      lblNewLabel.setIcon(updateIcon3);
		   } else if (select.getSelectedValue().equals("극장판 짱구는 못말려")) {
		      lblNewLabel.setIcon(updateIcon4);

		   }
		   }
		
	}
}
// 포토샵으로 화면 제작