package userInterface;

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
 * SignErrorUI类：
 * 登录错误的弹窗，提示“用户名或密码错误”
 */
public class SignErrorUI extends JFrame {

	private JPanel m_contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignErrorUI frame = new SignErrorUI();
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
	public SignErrorUI() {
		
		super("登陆失败！");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 173);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_lblNewLabel = new JLabel("用户名或密码错误！");
		m_lblNewLabel.setForeground(Color.RED);
		m_lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		m_lblNewLabel.setBounds(63, 26, 155, 30);
		m_contentPane.add(m_lblNewLabel);

//		重新登陆的按钮
		JButton m_registerButton = new JButton("重新登录");
		m_registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReSign();
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
        功能：切换到登录界面，重新登陆
        参数：无
        返回：无
    */
	public void ReSign()
	{
		this.setVisible(false);
		SignUI frame = new SignUI();
		frame.setVisible(true);
	}

}
