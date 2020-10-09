package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
	ScoreUI类：
	用户得分情况，返回用户分数；用户可选择继续答题或退出程序；
*/
public class ScoreUI extends JFrame {

	private JPanel m_contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreUI frame = new ScoreUI();
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
	public ScoreUI(int m_num,int m_rightnum) {
		
		super("得分情况");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);
		
		JLabel m_lblNewLabel = new JLabel("作答完成！");
		m_lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 30));
		m_lblNewLabel.setBounds(185, 10, 154, 34);
		m_contentPane.add(m_lblNewLabel);

//		用户得分情况
		float score = (float)m_rightnum/m_num*100;

		//System.out.println(score);

		JLabel m_scoreLabel = new JLabel("您的得分为："+String.format("%.0f",score));
		m_scoreLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		m_scoreLabel.setBounds(118, 72, 298, 41);
		m_contentPane.add(m_scoreLabel);

//		继续答题的按钮
		JButton m_continueButton = new JButton("继续答题");
		m_continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContinueQuestion();
			}
		});
		m_continueButton.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_continueButton.setBounds(163, 159, 176, 41);
		m_contentPane.add(m_continueButton);

//		退出程序的按钮
		JButton m_exitButton = new JButton("退出程序");
		m_exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);					//	程序退出
			}
		});
		m_exitButton.setFont(new Font("仿宋", Font.PLAIN, 24));
		m_exitButton.setBounds(163, 238, 176, 41);
		m_contentPane.add(m_exitButton);
	}

	/*
        NO:0
        功能：切换到选择试卷类型的界面，重新开始答题过程
        参数：无
        返回：无
    */
	public void ContinueQuestion()
	{
		this.setVisible(false);
		SelectTypeUI frame = new SelectTypeUI();
		frame.setVisible(true);
	}

}
