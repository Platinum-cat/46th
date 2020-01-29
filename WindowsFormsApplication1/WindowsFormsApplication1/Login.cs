using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Login : Form
    {
        public static int login_error = 0;
        public Login()
        {
            InitializeComponent();
        }
        //登录按钮事件
        private void button_login_Click(object sender, EventArgs e)
        {
            if (login_error <= 3)
            {
                panel_yzm.Visible = true;
                button_yzm.Text = "25pl";
            }

            //获取CheckBox的选中状态  Checked
            if ( Tools.Login(textBox_email.Text,textBox_pwd.Text,checkBox_zddl.Checked, panel_yzm.Visible) != false)
            {
                MessageBox.Show("登录");
                login_error = 0;
            }
            else
            {
                MessageBox.Show("账号,密码或验证码有误");
                login_error++;
            }
        }

        private void button__Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

    }
}
