package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * SetPasswdErrorUI类：
 * 设置密码出错时的一个弹窗
 */
public class SetPasswdErrorUI extends JFrame {

	private JPanel m_contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPasswdErrorUI frame = new SetPasswdErrorUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SetPasswdErrorUI() {
		super("密码格式错误！");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 173);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名为空或密码设置错误！");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 25, 265, 58);
		m_contentPane.add(lblNewLabel);

//		重新设置的按钮
		JButton m_resetButton = new JButton("重新设置");
		m_resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReSetPasswd();
			}
		});
		m_resetButton.setFont(new Font("仿宋", Font.PLAIN, 18));
		m_resetButton.setBounds(83, 94, 116, 32);
		m_contentPane.add(m_resetButton);

//		如果点击叉号关闭窗口，那么会仅关闭当前窗口并释放资源，而不会退出整个程序
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/*
        NO:0
        功能：回到设置密码界面，重新设置密码
        参数：无
        返回：无
    */
	public void ReSetPasswd()
	{
		this.dispose();
//		SetPasswdUI frame = new SetPasswdUI();
//		frame.setVisible(true);
	}

}
