package adminZone;

/*判断手机号是否正确，正确则返回验证码*/
public class GenerateCode {
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
    NO:1
    功能：根据输入的一个数字字符，生成相应的数字字符，或者是大小写字符
    参数：一个数字字符
    返回：一个字符
     */
    public char TransformNumToCode()
    {

        int m_tmp =0;
        switch (CreateRandom(3))             //根据一个随机数，来确定要返回的字符
        {
            case 1:                                             //数字字符
                m_tmp=CreateRandom(10)+47;
                break;
            case 2:                                             //小写字母字符
                m_tmp=CreateRandom(26)+96;
                break;
            case 3:                                             //大写字母字符
                m_tmp=CreateRandom(26)+64;
                break;
            default:
        }
        return (char)m_tmp;
    }
    /*
    NO:2
    功能：根据输入的11位手机号生成4位验证码（包含小写字母，大写字母，数字）
    参数：电话号码
    返回值：生成的验证码，若手机号不是有效的，返回"invalid"
     */
    public String GenerateVerificationCode()
    {
        String m_verifycode="";
        for (int i = 0; i < 4; i++)
        {
            m_verifycode+=TransformNumToCode();
        }

        return m_verifycode;
    }
    /*
    main函数，测试用
     */
/*
    public static void main(String[] args) {
        String str="18684867077";
        GenerateCode generateCode=new GenerateCode();
        System.out.println(generateCode.GenerateVerificationCode(str));

    }
*/


}
