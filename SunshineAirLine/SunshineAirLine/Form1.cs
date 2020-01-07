using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SunshineAirLine
{
    
    public partial class Form1 : Form
    {        
        int errorTimes = 0;
        public Form1()
        {            
            InitializeComponent();
           string sqlwrod = "select * from pssaved";
            SqlDataReader se =  AppTools.LoginTools.sql_con(sqlwrod,"读取");
            while (se.Read())
            {
                if ("1".Equals(se[0].ToString().Trim()))
                {
                    tb_email.Text = se[1].ToString().Trim();
                    tb_pwd.Text = se[2].ToString().Trim();
                    cb_7day.Checked = true;
                }
                else
                {
                    return;
                }
            }
        }

        private void lb_vc_Click(object sender, EventArgs e)
        {
            lb_vc.Text = AppTools.LoginTools.RandomWord();
        }

        
        private void bt_login_Click(object sender, EventArgs e)
        {
            string sqlword = "SELECT [Email]  ,[Password] ,[RoleId]FROM [Session1].[dbo].[Users]";
            string sqlwords = "update pssaved set checked = '1', email = '" + tb_email.Text.ToString().Trim() + "',pwd = '" + tb_pwd.Text.ToString().Trim() + "'";
            string email = tb_email.Text.Trim();
            string pwd = tb_pwd.Text.Trim();
            if (pl_vc.Visible == true && !lb_vc.Text.Equals(tb_vc.Text.Trim()))
            {
                MessageBox.Show("验证码错误!");
                return;
            }
            if (email == string.Empty || pwd == string.Empty) {
                MessageBox.Show("账号或密码不能为空!");
                return;
            }
            SqlDataReader sr = AppTools.LoginTools.sql_con(sqlword,"读取");
            while (sr.Read())
            {                
                string sr_em = sr[0].ToString().Trim();
                string sr_pwd = sr[1].ToString().Trim();
                string sr_ro = sr[2].ToString().Trim();
                if (sr_em.Equals(email) && sr_pwd.Equals(pwd))
                {
                    if ("1".Equals(sr_ro))
                    {
                        AppTools.LoginTools._7day(sqlwords, cb_7day.Checked);                        
                        MessageBox.Show("登陆成功!");
                        this.Hide();
                        new Office_User_Menu().Show();
                        return;
                    }
                    if ("2".Equals(sr_ro))
                    {
                        MessageBox.Show("管理员登陆成功！");
                        AppTools.LoginTools._7day(sqlwords, cb_7day.Checked);
                        this.Hide();
                        return;
                    }
                }
            }
            MessageBox.Show("用户名或密码错误！");
            errorTimes++;
            if (errorTimes == 3)
            {
                pl_vc.Visible = true;
            }            
        }

        

        private void bt_close_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
