package userInterface;

import adminZone.CreateOptions;
import adminZone.SolveQuestion;
import adminZone.CreateSingleQuestion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/*
	QuestionUI类：
	生成选择题界面，以及相关事件监听功能（选择选项、跳转下一题）
*/

public class QuestionUI extends JFrame {

	private JPanel m_contentPane;
	private JTextField m_textField;
	private JRadioButton m_AButton,m_BButton,m_CButton,m_DButton;
	ButtonGroup buttonGroup=new ButtonGroup();

	private String m_answer;
	private int m_num;								//题目数量
	private int m_num2;								//用于计数
	private int m_rightnum;							//答对的数量
	private String m_type="";
	private HashSet m_hashquestions=new HashSet();	//题目集合

	/**
	 * Create the frame.
	 */
	public QuestionUI(String m_type,int m_num) {
		super("题目");			
		this.m_num=m_num;
		this.m_num2=m_num;
		this.m_type=m_type;
		this.setVisible(true);
		buttonGroup.add(m_AButton);
		buttonGroup.add(m_BButton);
		buttonGroup.add(m_CButton);
		buttonGroup.add(m_DButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		m_textField = new JTextField();
		m_textField.setEditable(false);
		m_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		m_textField.setBounds(56, 38, 421, 49);
		m_contentPane.add(m_textField);
		m_textField.setColumns(10);
		//A选项按钮
		m_AButton = new JRadioButton();
		m_AButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(m_answer=="A")
				{
					m_rightnum++;
				}
				m_AButton.setSelected(false);
				NextUI();
			}
		});
		m_AButton.setFont(new Font("宋体", Font.PLAIN, 20));
		m_AButton.setBounds(76, 138, 191, 39);
		m_contentPane.add(m_AButton);

//B选项按钮
		m_BButton = new JRadioButton();
		m_BButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(m_answer=="B")
				{
					m_rightnum++;
				}
				m_BButton.setSelected(false);
				NextUI();
			}
		});
		m_BButton.setFont(new Font("宋体", Font.PLAIN, 20));
		m_BButton.setBounds(296, 138, 191, 39);
		m_contentPane.add(m_BButton);

//C选项按钮
		m_CButton = new JRadioButton();
		m_CButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(m_answer=="C")
				{
					m_rightnum++;
				}
				m_CButton.setSelected(false);
				NextUI();
			}
		});
		m_CButton.setFont(new Font("宋体", Font.PLAIN, 20));
		m_CButton.setBounds(76, 227, 191, 39);
		m_contentPane.add(m_CButton);

//D选项按钮
		m_DButton = new JRadioButton();
		m_DButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(m_answer=="D")
				{
					m_rightnum++;
				}
				m_DButton.setSelected(false);
				NextUI();
			}
		});
		m_DButton.setFont(new Font("宋体", Font.PLAIN, 20));
		m_DButton.setBounds(296, 227, 191, 39);
		m_contentPane.add(m_DButton);

		this.m_num++;	//初始化，出题目
		NextUI();
	}
	/*
		NO：01
		功能：设置4个选项
		参数：五个String，前四个为题目的选项，最后一个为答案
		返回：无
	 */
	public void SetOptions(String[] m_options)
	{
		m_AButton.setText(m_options[0]);
		m_BButton.setText(m_options[1]);
		m_CButton.setText(m_options[2]);
		m_DButton.setText(m_options[3]);
		m_answer=m_options[4];
	}
	/*
		NO：02
		功能：设置问题
		参数：String，问题
		返回：无
	 */
	public void SetQuestion(String m_question)
	{
		m_textField.setText(m_question);
	}
	/*
		NO：03
		功能：设置当前问题的题目和选项
		参数：无
		返回：无
	 */
	public void NextUI()
	{
		CreateSingleQuestion createSingleQuestion=new CreateSingleQuestion();
		CreateOptions createOptions=new CreateOptions();
		SolveQuestion solveQuestion=new SolveQuestion();
		String[] m_options=new String[5];
		if(m_type=="小学")
		{
//			查重部分，若之前的题目中包含了这道题，则生成新的题
			String m_str=createSingleQuestion.ExamPrimary();
			while(m_hashquestions.contains(m_str))
			{
				m_str=createSingleQuestion.ExamPrimary();
			}
			m_hashquestions.add(m_str);
			String m_answer=solveQuestion.SolvePrimary(m_str);
			m_options=createOptions.CreateFourOptions(m_answer);
			this.SetQuestion(m_str);
			this.SetOptions(m_options);
		}
		else if(m_type=="初中")
		{
//			查重部分，若之前的题目中包含了这道题，则生成新的题
			String m_str=createSingleQuestion.ExamJunior();
			while (m_hashquestions.contains(m_str))
			{
				m_str=createSingleQuestion.ExamJunior();
			}
			m_hashquestions.add(m_str);
			String m_answer=solveQuestion.SolveJunior(m_str);
			m_options=createOptions.CreateFourOptions(m_answer);
			this.SetQuestion(m_str);
			this.SetOptions(m_options);
		}
		else if(m_type=="高中")
		{
			String m_str=createSingleQuestion.ExamSenior();
//			查重部分，若之前的题目中包含了这道题，则生成新的题
			while (m_hashquestions.contains(m_str))
			{
				m_str=createSingleQuestion.ExamSenior();
			}
			m_hashquestions.add(m_str);
			String m_answer=solveQuestion.SolveSenior(m_str);
			m_options=createOptions.CreateFourOptions(m_answer);
			this.SetQuestion(m_str);
			this.SetOptions(m_options);
		}
		m_num--;
		if(m_num==0)
		{
			this.setVisible(false);
			ScoreUI scoreUI=new ScoreUI(m_num2,m_rightnum);
			scoreUI.setVisible(true);
		}
	}
	/*
	public static void main(String[] args) {
		new QuestionUI("高中",13);
	}

	 */
}
