using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SunshineAirLine
{
    static class AppTools
    {
        //链接数据库
        public static SqlCommand connec(string sqlword)
        {
            SqlConnection sql = new SqlConnection("Data Source=wczy145;Initial Catalog=Session1;Integrated Security=True");
            sql.Open();
            return new SqlCommand(sqlword, sql);
        } 
        //Login里面的方法       
        public static class LoginTools
        {
            //返回随机验证码
            public static string RandomWord()
            {
                Random r = new Random();
                return Convert.ToChar(r.Next(97, 123)).ToString() +r.Next(0, 10).ToString() + Convert.ToChar(r.Next(65, 65)).ToString() + r.Next(0, 10).ToString();
            }
            //判断7天是否勾选
            public static void _7day(string sqlword, Boolean b)
            {
                if (b)
                {
                    sql_con(sqlword, "修改");
                }
                else
                {
                    sql_con("update pssaved set checked = '0'", "修改");
                }
            }
            //读取数据库或者修改数据库
            public static SqlDataReader sql_con(string sqlword, string sqlType)
            {
                SqlCommand sqlcmd = connec(sqlword);
                if ("读取".Equals(sqlType))
                {
                    return sqlcmd.ExecuteReader();
                }
                if ("修改".Equals(sqlType))
                {
                    SqlCommand sqlcmd1 = connec(sqlword);
                    sqlcmd1.ExecuteNonQuery();
                }
                return null;
            }

        }
        public static class Search_flights
        {
            public static string dateFormat(string date)
            {
                string[] dates = date.Split('年');
                string year = dates[0];
                string[] mAndd = dates[1].Split('月');
                string month = mAndd[0];
                int mon = (int)Convert.ToDecimal(month);
                if(mon < 10)
                {
                    month = "0" + mon;
                }                                
                string[] d = mAndd[1].Split('日');
                string day = d[0];
                int da = (int)Convert.ToDecimal(day);
                if (da < 10)
                {
                    day = "0" + da;
                }
                return year + "-" + month + "-" + day;
            }
        }
    }
}
