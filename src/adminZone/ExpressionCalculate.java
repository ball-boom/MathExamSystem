package adminZone;

import static java.lang.Double.parseDouble;

public class ExpressionCalculate {
    /*
    功能：计算^2，已确定含有^2,才调用
    参数：String
    返回：String
     */
    public String CalculateSquare(String expression) {
        int m_i=expression.length()-1;
        String m_option="";
        int m_operand=0;
        while(expression.charAt(m_i)!='^')
        {
            m_i--;
        }
        m_i--;
        while((expression.charAt(m_i)>='0'&&expression.charAt(m_i)<='9'&&m_i>=0)||expression.charAt(m_i)=='.')
        {
            m_option=expression.charAt(m_i)+m_option;
            m_i--;
        }
        m_operand=Integer.parseInt(m_option);
        m_operand*=m_operand;
        m_option="\\("+m_option+"\\^2\\)";
        expression=expression.replaceAll(m_option,""+m_operand);
        return expression;
    }
    /*
    功能：计算√,已确定含有√才调用
    参数：String
    返回：String,保留两位小数
     */
    public String CalculateRoot(String expression)
    {
        int m_length=expression.length();
        int m_i=0;
        String m_option="";
        double m_operand=0;

        while(expression.charAt(m_i)!='√')
        {
            m_i++;
        }
        m_i++;
        while((expression.charAt(m_i)>='0'&&expression.charAt(m_i)<='9'&&m_i<m_length)||expression.charAt(m_i)=='.')
        {
            m_option=m_option+expression.charAt(m_i);
            m_i++;
        }

        m_operand= parseDouble(m_option);//修改中
        m_operand=Math.sqrt(m_operand);
        m_option="\\(\\√"+m_option+"\\)";
        expression=expression.replaceAll(m_option,String.format("%.2f", m_operand));
        return expression;
    }
    /*
    功能：计算sin，确认含有sin时才调用
    参数：String
    返回：String,保留两位小数
     */
    public String CalculateSin(String expression)
    {
        int m_length=expression.length();
        int m_i=0;
        String m_option="";
        double m_operand=0;

        while(expression.charAt(m_i)!='i')
        {
            m_i++;
        }
        m_i+=2;
        while((expression.charAt(m_i)>='0'&&expression.charAt(m_i)<='9'&&m_i<m_length)||expression.charAt(m_i)=='.')
        {
            m_option=m_option+expression.charAt(m_i);
            m_i++;
        }

        m_operand= parseDouble(m_option);
        m_operand=Math.sin(m_operand);
        m_option="\\(sin"+m_option+"\\)";
        expression=expression.replaceAll(m_option,String.format("%.2f", m_operand));
        return expression;
    }
    /*
    功能：计算cos，确认含有cos时才调用
    参数：String
    返回：String,保留两位小数
     */
    public String CalculateCos(String expression)
    {
        int m_length=expression.length();
        int m_i=0;
        String m_option="";
        double m_operand=0;

        while(expression.charAt(m_i)!='o')
        {
            m_i++;
        }
        m_i+=2;
        while((expression.charAt(m_i)>='0'&&expression.charAt(m_i)<='9'&&m_i<m_length)||expression.charAt(m_i)=='.')
        {
            m_option=m_option+expression.charAt(m_i);
            m_i++;
        }

        m_operand= parseDouble(m_option);
        m_operand=Math.cos(m_operand);
        m_option="\\(cos"+m_option+"\\)";
        expression=expression.replaceAll(m_option,String.format("%.2f", m_operand));
        return expression;
    }
    /*
    功能：计算tan，确认含有tan时才调用
    参数：String
    返回：String,保留两位小数
     */
    public String CalculateTan(String expression)
    {
        int m_length=expression.length();
        int m_i=0;
        String m_option="";
        double m_operand=0;

        while(expression.charAt(m_i)!='a')
        {
            m_i++;
        }
        m_i+=2;
        while((expression.charAt(m_i)>='0'&&expression.charAt(m_i)<='9'&&m_i<m_length)||expression.charAt(m_i)=='.')
        {
            m_option=m_option+expression.charAt(m_i);
            m_i++;
        }

        m_operand= parseDouble(m_option);
        m_operand=Math.tan(m_operand);
        m_option="\\(tan"+m_option+"\\)";
        expression=expression.replaceAll(m_option,String.format("%.2f", m_operand));
        return expression;
    }
    /*
    public static void main(String[] args) {
        CreateSingleQuestion createSingleQuestion=new CreateSingleQuestion();
        String m_str=createSingleQuestion.ExamSenior();
        System.out.println(m_str);

        SolveQuestion solveQuestion=new SolveQuestion();
        String m_answer=solveQuestion.SolveSenior(m_str);
        System.out.println(m_answer);
    }

     */

}