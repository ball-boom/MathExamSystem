package adminZone;


import adminZone.ExpressionCalculate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SolveQuestion {
    /*
    功能：解决小学问题，即包含+，-，*，/，（，）的算式。保留两位小数。
    参数：String
    返回：String类型的计算结果
     */
    public String SolvePrimary(String expression)
    {
        expression=expression.replaceAll("--","+");        //把负负变为正
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        String m_result;

        try {
            m_result = String.valueOf(scriptEngine.eval(expression));
            double m_tmp=Double.parseDouble(m_result);
            m_result=String.format("%.2f",m_tmp);
            return m_result;
        } catch (ScriptException e) {
            e.printStackTrace();
            return "It's wrong!";
        }
    }
    /*
    功能：解决初中问题，即包含+，-，*，/，（，），^2,√的算式
    参数：String
    返回：String
     */
    public String SolveJunior(String expression)
    {
        ExpressionCalculate expressionCalculate=new ExpressionCalculate();
        while(expression.contains("^2"))
        {
            expression=expressionCalculate.CalculateSquare(expression);
        }
        while(expression.contains("√"))
        {
            expression=expressionCalculate.CalculateRoot(expression);
        }
        expression=SolvePrimary(expression);
        return expression;
    }
    /*
    功能：解决高中问题，即包含+，-，*，/，（，），^2,√，三角函数的算式
    参数：String
    返回：String
     */
    public String SolveSenior(String expression)
    {
        ExpressionCalculate expressionCalculate=new ExpressionCalculate();
        while(expression.contains("^2"))
        {
            expression=expressionCalculate.CalculateSquare(expression);
        }
        while(expression.contains("√"))
        {
            expression=expressionCalculate.CalculateRoot(expression);
        }
        while(expression.contains("tan"))
        {
            expression=expressionCalculate.CalculateTan(expression);
        }
        while(expression.contains("sin"))
        {
            expression=expressionCalculate.CalculateSin(expression);
        }
        while(expression.contains("cos"))
        {
            expression=expressionCalculate.CalculateCos(expression);
        }
        expression=SolvePrimary(expression);
        return expression;
    }
}
