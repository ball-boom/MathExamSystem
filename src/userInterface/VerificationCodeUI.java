package userInterface;

import adminZone.GenerateCode;

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
 * VerificationCodeUI类：
 * 一个弹窗，返回用户注册用的验证码
 */
public class VerificationCodeUI extends JFrame {

	private JPanel m_contentPane;
	public String m_verificationCode = MakeVerificationCode();	//生成的验证码

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificationCodeUI frame = new VerificationCodeUI();
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
	public VerificationCodeUI() {
		super("验证码");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 173);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_lblNewLabel = new JLabel("您正在申请手机注册，验证码为：");
		m_lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		m_lblNewLabel.setBounds(21, 25, 244, 31);
		m_contentPane.add(m_lblNewLabel);

//		验证码提示信息
		JLabel m_verificationLabel = new JLabel(m_verificationCode);
		m_verificationLabel.setForeground(Color.BLUE);
		m_verificationLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		m_verificationLabel.setBounds(104, 66, 88, 25);
		m_contentPane.add(m_verificationLabel);

//		确认按钮
		JButton m_confirmButton = new JButton("知道了");
		
		m_confirmButton.setFont(new Font("仿宋", Font.PLAIN, 18));
		m_confirmButton.setBounds(73, 101, 119, 33);
		m_contentPane.add(m_confirmButton);
		
//		按下按钮就退出该窗口
		m_confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

//		如果点击叉号关闭窗口，那么会仅关闭当前窗口并释放资源，而不会退出整个程序
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	/*
        NO:0
        功能：得到四位数验证码
        参数：无
        返回：长度为4的字符串
    */
	public String MakeVerificationCode()
	{
		GenerateCode generateCode = new GenerateCode();
		return generateCode.GenerateVerificationCode();
	}

	public String getM_verificationCode() {
		return m_verificationCode;
	}
}
