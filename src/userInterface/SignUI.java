package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
 * SignUI类：
 * 登陆界面，可输入用户名、密码；
 * 可以登录或者注册
 */
public class SignUI extends JFrame {

	private JPanel m_contentPane;
	private JTextField m_idText;		//	输入用户名的文本框
	private JTextField m_passwdText;	//	输入密码的文本框

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUI frame = new SignUI();
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
	public SignUI() {
		
		super("小初高中试卷生成系统");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_lblNewLabel = new JLabel("用户名");
		m_lblNewLabel.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_lblNewLabel.setBounds(49, 82, 92, 36);
		m_contentPane.add(m_lblNewLabel);

//		输入用户名的文本框
		m_idText = new JTextField();
		m_idText.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		m_idText.setBounds(158, 81, 289, 46);
		m_contentPane.add(m_idText);
		m_idText.setColumns(10);
		
		JLabel m_lblNewLabel_1 = new JLabel("密码");
		m_lblNewLabel_1.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_lblNewLabel_1.setBounds(49, 160, 76, 36);
		m_contentPane.add(m_lblNewLabel_1);

//		输入密码的文本框
		m_passwdText = new JTextField();
		m_passwdText.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		m_passwdText.setBounds(158, 150, 289, 46);
		m_contentPane.add(m_passwdText);
		m_passwdText.setColumns(10);

//		登录按钮
		JButton m_signButton = new JButton("登录");
		m_signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					if(!UserIsExist("src/UserInformation.txt", m_idText.getText(), m_passwdText.getText()) )
					{

						PopSignError();
					}
					else
						SwitchSelectType();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
		m_signButton.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_signButton.setBounds(136, 244, 99, 46);
		m_contentPane.add(m_signButton);

//		注册按钮
		JButton m_registerButton = new JButton("注册");
		m_registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchRegister();
			}
		});

		m_registerButton.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_registerButton.setBounds(327, 244, 99, 46);
		m_contentPane.add(m_registerButton);

	}

	/*
        NO:0
        功能：切换到注册界面
        参数：无
        返回：无
    */
	public void SwitchRegister()
	{
		this.dispose();
		RegisterUI frame = new RegisterUI();
		frame.setVisible(true);
	}

	/*
        NO:1
        功能：切换到选择试卷类型界面
        参数：无
        返回：无
    */
	public void SwitchSelectType()
	{
		this.dispose();
		SelectTypeUI frame = new SelectTypeUI();
		frame.setVisible(true);
	}

	/*
        NO:2
        功能：弹出登录错误界面
        参数：无
        返回：无
    */
	public void PopSignError()
	{
		this.dispose();
		SignErrorUI frame = new SignErrorUI();
		frame.setVisible(true);
	}

	/*
        NO:3
        功能：判断用户是否存在
        参数：文件路径、用户名、密码
        返回：布尔
    */
	private static boolean UserIsExist(String filePath, String id, String password) throws IOException
	{
		InputStreamReader in = null;
		BufferedReader br = null;
		String judgeStr = id + " " + password;

		File file = new File(filePath);
		in = new InputStreamReader(new FileInputStream(file), "UTF-8");
		br = new BufferedReader(in);
		String s;
		// 逐行读取
		while ((s = br.readLine()) != null)
		{
//			System.out.println(s);
//			System.out.println(judgeStr);
			if(s.equals(judgeStr))
			{
				br.close();
				in.close();
				return true;
			}
		}
		br.close();
		in.close();
		return false;
		}


}
