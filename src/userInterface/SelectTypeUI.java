package userInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
	SelectTypeUI类：
	用户选择试卷类型：小学、初中或高中
 */
public class SelectTypeUI extends JFrame {

	private JPanel m_contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTypeUI frame = new SelectTypeUI();
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
	public SelectTypeUI() {
		super("请选择试卷类型");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);

		//选择小学试卷的按钮
		JButton m_primaryButton = new JButton("小学试卷");
		m_primaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPrimaryQuestion();
			}
		});
		m_primaryButton.setFont(new Font("宋体", Font.PLAIN, 24));
		m_primaryButton.setBounds(177, 47, 152, 43);
		m_contentPane.add(m_primaryButton);

		//选择初中试卷的按钮
		JButton m_middle = new JButton("初中试卷");
		m_middle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SwitchMiddleQuestion();
			}
		});
		m_middle.setFont(new Font("宋体", Font.PLAIN, 24));
		m_middle.setBounds(177, 136, 152, 43);
		m_contentPane.add(m_middle);

		//选择高中试卷的按钮
		JButton m_high = new JButton("高中试卷");
		m_high.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchHighQuestion();
			}
		});
		m_high.setFont(new Font("宋体", Font.PLAIN, 24));
		m_high.setBounds(177, 227, 152, 43);
		m_contentPane.add(m_high);
	}

	/*
        NO:0
        功能：将试卷类型切换为小学，并且切换到选择题目数量界面
        参数：无
        返回：无
    */
	public void SwitchPrimaryQuestion()
	{
//		试卷类型切换到小学
//		g_type = "小学";
		this.setVisible(false);
		SetQstNumberUI frame = new SetQstNumberUI("小学");
		frame.setVisible(true);
	}

	/*
        NO:1
        功能：将试卷类型切换为初中，并且切换到选择题目数量界面
        参数：无
        返回：无
    */
	public void SwitchMiddleQuestion()
	{
//		试卷类型切换到初中
//		g_type = "初中";
		this.setVisible(false);
		SetQstNumberUI frame = new SetQstNumberUI("初中");
		frame.setVisible(true);
	}

	/*
        NO:2
        功能：将试卷类型切换为高中，并且切换到选择题目数量界面
        参数：无
        返回：无
    */
	public void SwitchHighQuestion()
	{
//		试卷类型切换到高中
//		g_type = "高中";
		this.setVisible(false);
		SetQstNumberUI frame = new SetQstNumberUI("高中");
		frame.setVisible(true);
	}

}
