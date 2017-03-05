package com.yelook.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

public class KK {

	private JFrame frmKk;
	private JTextField txtLocalhost;
	private JTextField textField_2;
	private JTextField textField_3;
	//设置textarea为static，方便其他方法使用
	static JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KK window = new KK();
					window.frmKk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KK() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKk = new JFrame();
		frmKk.setResizable(false);
		frmKk.setTitle("KK局域网聊天软件");
		frmKk.setBounds(100, 100, 550, 450);
		frmKk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKk.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("IP地址：");
		lblNewLabel.setBounds(12, 286, 54, 15);
		frmKk.getContentPane().add(lblNewLabel);

		txtLocalhost = new JTextField();
		txtLocalhost.setBounds(62, 283, 105, 21);
		txtLocalhost.setText("localhost");
		frmKk.getContentPane().add(txtLocalhost);
		txtLocalhost.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("端口号：");
		lblNewLabel_1.setBounds(180, 286, 54, 15);
		frmKk.getContentPane().add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(230, 283, 66, 21);
		textField_2.setText("2221");
		frmKk.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("本机开启端口：");
		lblNewLabel_2.setBounds(301, 14, 90, 15);
		frmKk.getContentPane().add(lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setBounds(383, 11, 66, 21);
		textField_3.setText("2222");
		frmKk.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 310, 420, 102);
		frmKk.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 0, 420, 102);
		panel_1.add(scrollPane_1);
		textArea_1.setLineWrap(true);

		scrollPane_1.setViewportView(textArea_1);

		JLabel lblip = new JLabel("本机IP地址：");
		lblip.setBounds(12, 14, 90, 15);
		frmKk.getContentPane().add(lblip);

		JLabel benji = new JLabel("localhost");
		benji.setBounds(90, 14, 155, 15);
		frmKk.getContentPane().add(benji);
		// 显示本机IP地址
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		benji.setText(ip);
		JPanel panel = new JPanel();
		panel.setBounds(12, 39, 522, 237);
		frmKk.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 522, 237);
		panel.add(scrollPane);
		textArea.setLineWrap(true);

		scrollPane.setViewportView(textArea);
		textArea.setText("首先设置端口号才可以接收到消息");
		textArea.append("\r\n");
		JButton btnNewButton_1 = new JButton("开始");
		btnNewButton_1.setBounds(452, 10, 72, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击开始按钮之后，开启监听
				//获取端口号
				String port = textField_3.getText();
				//获取的端口号是string,转换为整形
				int intport = Integer.parseInt(port);
				// 启动监听
				try {
					//实例化收信
					Receiver re = new Receiver();
					//塞入端口号
					re.setPort(intport);
					//创建线程
					Thread th = new Thread(re);
					//启动线程
					th.start();
					//打印消息
					textArea.append("开启端口号:" + port + ",正在监听消息；");
					textArea.append("\r\n");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frmKk.getContentPane().add(btnNewButton_1);
		JButton btnNewButton = new JButton("发送");
		btnNewButton.setBounds(441, 351, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//发信按钮按下之后
				//获取对方ip、端口号，获取自己的端口号和消息内容
				String reip = txtLocalhost.getText();
				String report = textField_2.getText();
				String myport = textField_3.getText();
				String msg = textArea_1.getText();
				//判断输入的内容
				if ("".equals(reip)) {
					JOptionPane.showMessageDialog(null, "请输入ip地址", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if ("".equals(report)) {
					JOptionPane.showMessageDialog(null, "请输入端口号", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if ("".equals(myport)) {
					JOptionPane.showMessageDialog(null, "请输入我的端口号", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if ("".equals(msg)) {
					JOptionPane.showMessageDialog(null, "请输入要发送的消息", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(report.equals(myport)){
					JOptionPane.showMessageDialog(null, "请不要自己给自己发消息", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				//实例化发信
				Sender se = new Sender();
				//塞入值
				se.setMsg(msg);
				se.setHost(reip);
				se.setPort(Integer.parseInt(report));
				//创建线程
				Thread th = new Thread(se);
				//启动线程
				th.start();
				// 获取当前时间
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = df.format(date);
				//打印信息
				textArea.append(time + " 我说：");
				textArea.append("\r\n");
				textArea.append(msg);
				textArea.append("\r\n");
				//清空内容
				textArea_1.setText("");

			}
		});
		frmKk.getContentPane().add(btnNewButton);

	}

	// 静态方法，用来调用，往页面上添加消息
	public static void addmsg(String msg, int prot) {
		// 获取当前时间
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);
		textArea.append(time + " 来自端口号" + prot + "的消息");
		textArea.append("\r\n");
		textArea.append(msg);
		textArea.append("\r\n");
	}

	// 静态方法，用来调用 往页面上添加错误信息
	public static void msgerror(Exception e) {
		textArea.append("出现错误，错误原因" + e);
		textArea.append("\r\n");
	}
}
