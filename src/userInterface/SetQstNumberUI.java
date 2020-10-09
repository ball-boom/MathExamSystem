package userInterface;

import userInterface.QuestionUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

/*
	QstNumberUI类：
  	用户输入题目数量的界面
*/
public class SetQstNumberUI extends JFrame {

	private JPanel m_contentPane;
	private JTextField m_questionText;
	private JButton m_btnNewButton;
	private JLabel m_warningLabel;//输错题目数量时的警告框

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetQstNumberUI frame = new SetQstNumberUI();
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
	public SetQstNumberUI(String m_type) {
		super("题目数量");			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_questionLabel = new JLabel("请输入需要出题的数量(10~30)");
		m_questionLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		m_questionLabel.setBounds(99, 48, 338, 58);
		m_contentPane.add(m_questionLabel);
		
		m_questionText = new JTextField("10");
		m_questionText.setFont(new Font("宋体", Font.PLAIN, 20));
		m_questionText.setBounds(198, 143, 145, 39);
		m_contentPane.add(m_questionText);
		m_questionText.setColumns(10);

		//输错题目数量时的警告框
		m_warningLabel = new JLabel("");
		m_warningLabel.setForeground(Color.RED);
		m_warningLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		m_warningLabel.setBounds(175, 192, 253, 30);
		m_contentPane.add(m_warningLabel);
		
		m_btnNewButton = new JButton("确定");
		m_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = Integer.parseInt(m_questionText.getText());
				if(number<=30 && number>=10)
				{
					SwitchQuestion(m_type,number);
				}
				else
				{
					PopReSetNumber();
				}
				
			}
		});
		m_btnNewButton.setFont(new Font("仿宋", Font.PLAIN, 20));
		m_btnNewButton.setBounds(198, 232, 145, 39);
		m_contentPane.add(m_btnNewButton);
	}

	/*
        NO:0
        功能：切换到出题界面，开始出题
        参数：无
        返回：无
    */
	public void SwitchQuestion(String m_type,int m_number)
	{
		this.setVisible(false);
		QuestionUI frame = new QuestionUI(m_type,m_number);
		frame.setVisible(true);
	}

	/*
        NO:1
        功能：生成报错信息，提示重新输入题目数量
        参数：无
        返回：无
    */
	public void PopReSetNumber()
	{
		m_warningLabel.setText("请输入合法的题目数量！");
	}
}
