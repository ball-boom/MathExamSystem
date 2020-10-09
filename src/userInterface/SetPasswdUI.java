package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

/*
 * SetPasswdUI类：
 * 设置用户名和密码，如果格式错误会调用SetPasswdErrorUI类，即一个提示错误的弹窗
 */
public class SetPasswdUI extends JFrame {

	private JPanel m_contentPane;
	private JTextField m_setIdText;			//设置用户名的文本框
	private JTextField m_firstPasswdText;	//第一次输入密码的文本框
	private JTextField m_secondPasswdText;	//第二次输入密码的文本框
	private JButton m_confirmButton;		//第三次输入密码的文本框

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPasswdUI frame = new SetPasswdUI();
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
	public SetPasswdUI() {
		super("设置账号");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_lblNewLabel_3 = new JLabel("请设置用户名");
		m_lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		m_lblNewLabel_3.setBounds(38, 49, 127, 30);
		m_contentPane.add(m_lblNewLabel_3);

//		设置用户名的文本框
		m_setIdText = new JTextField();
		m_setIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		m_setIdText.setColumns(10);
		m_setIdText.setBounds(175, 49, 261, 36);
		m_contentPane.add(m_setIdText);
		
		JLabel m_lblNewLabel = new JLabel("请设置密码");
		m_lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		m_lblNewLabel.setBounds(60, 101, 105, 30);
		m_contentPane.add(m_lblNewLabel);
		
		JLabel m_lblNewLabel_1 = new JLabel("请再次确认");
		m_lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		m_lblNewLabel_1.setBounds(60, 157, 105, 30);
		m_contentPane.add(m_lblNewLabel_1);

//		用户第一次输入密码
		m_firstPasswdText = new JTextField();
		m_firstPasswdText.setFont(new Font("宋体", Font.PLAIN, 20));
		m_firstPasswdText.setBounds(175, 98, 261, 36);
		m_contentPane.add(m_firstPasswdText);
		m_firstPasswdText.setColumns(10);

//		用户第二次输入密码
		m_secondPasswdText = new JTextField();
		m_secondPasswdText.setFont(new Font("宋体", Font.PLAIN, 20));
		m_secondPasswdText.setBounds(175, 154, 261, 36);
		m_contentPane.add(m_secondPasswdText);
		m_secondPasswdText.setColumns(10);
		
		JLabel m_lblNewLabel_2 = new JLabel("请注意：密码6-10位，必须含大小写字母和数字！");
		m_lblNewLabel_2.setForeground(Color.RED);
		m_lblNewLabel_2.setFont(new Font("楷体", Font.ITALIC, 18));
		m_lblNewLabel_2.setBounds(77, 197, 406, 38);
		m_contentPane.add(m_lblNewLabel_2);

//		点击确认的按钮
		m_confirmButton = new JButton("确认");
		m_confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsRight(m_firstPasswdText.getText(), m_secondPasswdText.getText(), m_setIdText.getText()))
				{
					String content = m_setIdText.getText() + " " + m_firstPasswdText.getText() + "\n" ;
					writeTxt("src/UserInformation.txt", content);
					SwitchSign();
				}
				else
				{
					PopSetPasswdError();
//					dispose();
				}
			}
		});
		m_confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		m_confirmButton.setBounds(202, 245, 151, 36);
		m_contentPane.add(m_confirmButton);
	}

	/*
        NO:0
        功能：切换到登录界面，进行登录
        参数：无
        返回：无
    */
	public void SwitchSign()
	{
		this.dispose();
		SignUI frame = new SignUI();
		frame.setVisible(true);
	}

	/*
        NO:1
        功能：弹出设置密码错误，重新设置密码
        参数：无
        返回：无
    */
	public void PopSetPasswdError()
	{
		SetPasswdErrorUI frame = new SetPasswdErrorUI();
		frame.setVisible(true);
	}

	/*
        NO:2
        功能：判断输入的密码是否规范
        参数：字符串
        返回：布尔
    */
	public boolean IsNormal(String password)
	{
		boolean flag;
		boolean capFlag = false;
		boolean lowFlag = false;
		boolean numFlag = false;

		if(password.length()<6 || password.length()>10)
			flag = false;
		else
		{
			for(int i=0; i<password.length(); i++)
			{
				if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' )
					capFlag = true;
				if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z' )
					lowFlag = true;
				if(password.charAt(i) >= '0' && password.charAt(i) <= '9' )
					numFlag = true;
			}

			if(capFlag==true && lowFlag==true && numFlag==true)
				flag = true;
			else
				flag = false;
		}
		return flag;
	}

	/*
        NO:3
        功能：判断两次密码是否一致
        参数：两个字符串
        返回：布尔
    */
	public boolean IsEqual(String firstPassword, String secondPassword)
	{
		return (firstPassword.equals(secondPassword));
	}

	/*
        NO:4
        功能：判断设置用户名是否为空,
        参数：字符串
        返回：布尔
    */
	public boolean IsNull(String account)
	{
		return (account.equals(""));
	}
	/*
        NO:5
        功能：判断设置用户名和密码是否合法
        参数：三个个字符串
        返回：布尔
    */
	public boolean IsRight(String firstPassword, String secondPassword, String account )
	{
		return (IsNormal(firstPassword) & IsEqual(firstPassword,secondPassword) & !IsNull(account) );
	}

	/*
        NO:6
        功能：将字符串写入文件中
        参数：文件路径、待写入内容
        返回：无
    */
	public static void writeTxt(String filePath, String Content)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath, true);
			fileWriter.write(Content);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
