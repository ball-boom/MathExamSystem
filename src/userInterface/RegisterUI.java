package userInterface;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import adminZone.*;

/*
	RegisterUI类：
	生成注册界面，用户输入手机号，发送验证码，填写验证码，完成注册
*/

public class RegisterUI extends JFrame {

	private JPanel m_contentPane;
	private JTextField m_phoneText;			// 用户输入的手机号文本框
	private JTextField m_verificationText;	//	用户输入的验证码文本框
	private JLabel m_warningLabel;			//输入非法手机号时的警告框
	private String m_verificationCode;		//验证码


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * 构造器，初始化这个界面
	 */
	public RegisterUI() {
		
		super("注册");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_PhoneLabel = new JLabel("手机号");
		m_PhoneLabel.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_PhoneLabel.setBounds(49, 82, 92, 36);
		m_contentPane.add(m_PhoneLabel);

//		用户填入手机号
		m_phoneText = new JTextField();
		m_phoneText.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		m_phoneText.setBounds(158, 81, 289, 46);
		m_contentPane.add(m_phoneText);
		m_phoneText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("验证码");
		lblNewLabel_1.setFont(new Font("仿宋", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(49, 160, 76, 36);
		m_contentPane.add(lblNewLabel_1);

//		用户填入验证码
		m_verificationText = new JTextField();
		m_verificationText.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		m_verificationText.setBounds(158, 150, 145, 46);
		m_contentPane.add(m_verificationText);
		m_verificationText.setColumns(10);

//		发送验证码的按钮
		JButton m_btnNewButton_1 = new JButton("发送验证码");
		m_btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//每次发送验证码前先清空警告框
				UnPopErrorPhone();
				if(IsPhoneNumber(m_phoneText.getText()))
					PopVerification();
				else
					PopErrorPhone();
			}
		});
		m_btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		m_btnNewButton_1.setBounds(334, 153, 138, 43);
		m_contentPane.add(m_btnNewButton_1);

//		确认的按钮
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!m_verificationText.getText().equals(m_verificationCode))
				{
					PopRegisterError();
				}
				else if(m_verificationText.getText().equals(m_verificationCode))
				{
					SwitchSetPasswd();
				}

			}
		});
		btnNewButton.setFont(new Font("仿宋", Font.PLAIN, 24));
		btnNewButton.setBounds(222, 245, 99, 46);
		m_contentPane.add(btnNewButton);

		//输入非法手机号时的警告框
		m_warningLabel = new JLabel("");
		m_warningLabel.setForeground(Color.RED);
		m_warningLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		m_warningLabel.setBounds(175, 192, 253, 30);
		m_contentPane.add(m_warningLabel);

	}

	/*
        NO:0
        功能：弹出验证码窗口,并且获得验证码
        参数：无
        返回：无
    */
	public void PopVerification()
	{

		VerificationCodeUI frame = new VerificationCodeUI();
		frame.setVisible(true);
		//获得验证码
		m_verificationCode = frame.getM_verificationCode();
	}

	/*
        NO:1
        功能：切换到设置密码界面
        参数：无
        返回：无
    */
	public void SwitchSetPasswd()
	{
		this.dispose();
		SetPasswdUI frame = new SetPasswdUI();
		frame.setVisible(true);
	}

	/*
        NO:2
        功能：弹出注册报错窗口
        参数：无
        返回：无
    */
	public void PopRegisterError()
	{

		RegisterErrorUI frame = new RegisterErrorUI();
		frame.setVisible(true);
	}
	/*
        NO:2
        功能：判断字符串是否是合法的手机号
        参数：字符串
        返回：布尔类型
    */
	public boolean IsPhoneNumber(String phoneNumber)
	{
		Pattern pattern = Pattern.compile("^(13|15|16|17|18|19)\\d{9}$");
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();
		return isMatch;
	}
	/*
        NO:3
        功能：生成报错信息，提示重新输入合法的手机号
        参数：无
        返回：无
    */
	public void PopErrorPhone()
	{
		m_warningLabel.setText("请输入合法的手机号！");
	}
	/*
        NO:4
        功能：清空报错警告框
        参数：无
        返回：无
    */
	public void UnPopErrorPhone()
	{
		m_warningLabel.setText("");
	}


}
