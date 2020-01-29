using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            //判断是否记住密码
            string[] logins = File.ReadAllLines(@"login.cookin.txt");
            if (logins!=null && Tools.Login(logins[0], logins[1], true,true))
                if (logins[2] .Equals( "1"))
                    Application.Run(new Office_User_Menu());
                else if(logins[2].Equals("2"))
                    Application.Run(new Administrator_Menu());
            Application.Run(new Login());
        }
    }
}
