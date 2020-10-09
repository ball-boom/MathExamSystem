package adminZone;

import java.util.ArrayList;
import java.util.HashSet;

public class CreateOptions {
    /*
        NO:0
        功能：生成一个范围内的随机数
        参数：m_range,范围
        返回：int，该范围内的随机数
     */
    public int CreateRandom(int m_range)
    {
        int m_max=100,m_min=1;
        int m_ran2 = (int) (Math.random()*(m_max-m_min)+m_min);
        return m_ran2%m_range+1;
    }
    /*
        NO：01
        功能：给定一个答案
        参数：String，一个确定的答案
        返回：String[]，五个String，前四个为选项，最后一个为正确答案
     */
    public String[] CreateFourOptions(String m_answer)
    {
        HashSet hashSet=new HashSet();
        //ArrayList arrayList=new ArrayList();
        String[] m_options=new String[5];
        m_options[0]="";
        m_options[1]="";
        m_options[2]="";
        m_options[3]="";
        switch (CreateRandom(4)-1)          //设置正确选项的位置
        {
            case 0:
                m_options[0]=m_answer;
                m_options[4]="A";
                hashSet.add(m_options[0]);
                break;
            case 1:
                m_options[1]=m_answer;
                m_options[4]="B";
                hashSet.add(m_options[1]);
                break;
            case 2:
                m_options[2]=m_answer;
                m_options[4]="C";
                hashSet.add(m_options[2]);
                break;
            case 3:
                m_options[3]=m_answer;
                m_options[4]="D";
                hashSet.add(m_options[3]);
        }
        for (int i = 0; i < 4; i++) {
            if(m_options[i]=="")
            {
                String m_str=CreateOneOption(m_answer);
                while(hashSet.contains(m_str))
                {
                    m_str=CreateOneOption(m_answer);
                    //System.out.println("NO");
                }
                m_options[i]=m_str;
                hashSet.add(m_options[i]);
            }
        }
        return m_options;
    }
    /*
        NO：02
        功能：模糊化答案的方法的方法
        参数：String，输入的正确答案
        返回：String，模糊化的答案
     */
    public String CreateOneOption(String m_answer)
    {
        double m_tmp=Double.parseDouble(m_answer);
        double m_tmp1=CreateRandom(4);
        double m_tmp2=CreateRandom(5);
        m_tmp=m_tmp/m_tmp1*m_tmp2+m_tmp1+m_tmp2;
        return String.format("%.2f", m_tmp);
    }
    /*
    public static void main(String[] args) {

        String m_str=new CreateSingleQuestion().ExamPrimary();
        m_str=new SolveQuestion().SolvePrimary(m_str);
        String[] str=new CreateOptions().CreateFourOptions(m_str);
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);
        System.out.println(str[3]);
        System.out.println(str[4]);
    }
    
     */




}
