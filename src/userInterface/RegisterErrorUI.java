package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RegisterErrorUI extends JFrame {

	private JPanel m_contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterErrorUI frame = new RegisterErrorUI();
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
	public RegisterErrorUI() {
		
		super("注册失败！");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 173);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_lblNewLabel = new JLabel("验证码填写错误！");
		m_lblNewLabel.setForeground(Color.RED);
		m_lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		m_lblNewLabel.setBounds(71, 26, 155, 30);
		m_contentPane.add(m_lblNewLabel);

//		重新填写验证码的按钮
		JButton m_registerButton = new JButton("重新填写");
		m_registerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ReRegister();
			}
		});
		m_registerButton.setFont(new Font("宋体", Font.PLAIN, 14));
		m_registerButton.setBounds(80, 83, 109, 30);
		m_contentPane.add(m_registerButton);

//		如果点击叉号关闭窗口，那么会仅关闭当前窗口并释放资源，而不会退出整个程序
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/*
        NO:0
        功能：切换到注册界面，重新填写验证码
        参数：无
        返回：无
    */
	public void ReRegister()
	{
		this.dispose();
	}

}
