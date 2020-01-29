using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApplication1
{
    class Tools
    {

        public static string sqlCon = "Data Source=DESKTOP-OC7Q0K5;Initial Catalog=Session1;Integrated Security=True";

        public static bool Login(string email , string pwd , bool @checked,bool yzmZt)
        {
            if (email.Equals("") || pwd.Equals(""))
                return false;
            
            //创建 LINQ to SQL 对象,并添加数据源
            Session1DataContext linq = new Session1DataContext(sqlCon);
            //查询语句
            var Sql = from sql in linq.Users where sql.Email == email && sql.Password == pwd select sql;
            //查看执行结果
            if ( Sql.Count()== 1&&yzmZt)
            {
                if (@checked)
                {
                    //向文件内写入
                    File.WriteAllText(@"login.cookin.txt", email + "\n" + pwd + "\n" + Sql.First().RoleId);
                }
                return true;
            }
            return false;
        }

    }
}
