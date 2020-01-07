namespace SunshineAirLine
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.tb_email = new System.Windows.Forms.TextBox();
            this.bt_login = new System.Windows.Forms.Button();
            this.tb_pwd = new System.Windows.Forms.TextBox();
            this.tb_vc = new System.Windows.Forms.TextBox();
            this.bt_close = new System.Windows.Forms.Button();
            this.lb_vc = new System.Windows.Forms.Label();
            this.pl_vc = new System.Windows.Forms.Panel();
            this.cb_7day = new System.Windows.Forms.CheckBox();
            this.pl_vc.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 20F);
            this.label1.Location = new System.Drawing.Point(345, 50);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(82, 27);
            this.label1.TabIndex = 0;
            this.label1.Text = "Login";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("宋体", 15F);
            this.label2.Location = new System.Drawing.Point(149, 100);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(519, 20);
            this.label2.TabIndex = 1;
            this.label2.Text = "The system can logged in through email and password";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("宋体", 15F);
            this.label3.Location = new System.Drawing.Point(243, 192);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(69, 20);
            this.label3.TabIndex = 2;
            this.label3.Text = "Email:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("宋体", 15F);
            this.label4.Location = new System.Drawing.Point(213, 232);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(99, 20);
            this.label4.TabIndex = 3;
            this.label4.Text = "Password:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("宋体", 15F);
            this.label5.Location = new System.Drawing.Point(3, 10);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(189, 20);
            this.label5.TabIndex = 4;
            this.label5.Text = "Verification Code:";
            // 
            // tb_email
            // 
            this.tb_email.Location = new System.Drawing.Point(318, 191);
            this.tb_email.Name = "tb_email";
            this.tb_email.Size = new System.Drawing.Size(221, 21);
            this.tb_email.TabIndex = 5;
            // 
            // bt_login
            // 
            this.bt_login.Location = new System.Drawing.Point(247, 363);
            this.bt_login.Name = "bt_login";
            this.bt_login.Size = new System.Drawing.Size(105, 42);
            this.bt_login.TabIndex = 6;
            this.bt_login.Text = "Login";
            this.bt_login.UseVisualStyleBackColor = true;
            this.bt_login.Click += new System.EventHandler(this.bt_login_Click);
            // 
            // tb_pwd
            // 
            this.tb_pwd.Location = new System.Drawing.Point(318, 231);
            this.tb_pwd.Name = "tb_pwd";
            this.tb_pwd.Size = new System.Drawing.Size(221, 21);
            this.tb_pwd.TabIndex = 7;
            // 
            // tb_vc
            // 
            this.tb_vc.Location = new System.Drawing.Point(198, 8);
            this.tb_vc.Name = "tb_vc";
            this.tb_vc.Size = new System.Drawing.Size(168, 21);
            this.tb_vc.TabIndex = 8;
            // 
            // bt_close
            // 
            this.bt_close.Location = new System.Drawing.Point(469, 363);
            this.bt_close.Name = "bt_close";
            this.bt_close.Size = new System.Drawing.Size(105, 42);
            this.bt_close.TabIndex = 9;
            this.bt_close.Text = "Close";
            this.bt_close.UseVisualStyleBackColor = true;
            this.bt_close.Click += new System.EventHandler(this.bt_close_Click);
            // 
            // lb_vc
            // 
            this.lb_vc.AutoSize = true;
            this.lb_vc.BackColor = System.Drawing.Color.DarkGray;
            this.lb_vc.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.lb_vc.Font = new System.Drawing.Font("宋体", 15F);
            this.lb_vc.Location = new System.Drawing.Point(372, 8);
            this.lb_vc.Name = "lb_vc";
            this.lb_vc.Size = new System.Drawing.Size(51, 22);
            this.lb_vc.TabIndex = 10;
            this.lb_vc.Text = "1Af6";
            this.lb_vc.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.lb_vc.Click += new System.EventHandler(this.lb_vc_Click);
            // 
            // pl_vc
            // 
            this.pl_vc.Controls.Add(this.lb_vc);
            this.pl_vc.Controls.Add(this.tb_vc);
            this.pl_vc.Controls.Add(this.label5);
            this.pl_vc.Location = new System.Drawing.Point(118, 268);
            this.pl_vc.Name = "pl_vc";
            this.pl_vc.Size = new System.Drawing.Size(432, 44);
            this.pl_vc.TabIndex = 11;
            this.pl_vc.Visible = false;
            // 
            // cb_7day
            // 
            this.cb_7day.AutoSize = true;
            this.cb_7day.Location = new System.Drawing.Point(350, 332);
            this.cb_7day.Name = "cb_7day";
            this.cb_7day.Size = new System.Drawing.Size(144, 16);
            this.cb_7day.TabIndex = 12;
            this.cb_7day.Text = "Auto login in 7 days";
            this.cb_7day.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(801, 470);
            this.Controls.Add(this.cb_7day);
            this.Controls.Add(this.pl_vc);
            this.Controls.Add(this.bt_close);
            this.Controls.Add(this.tb_pwd);
            this.Controls.Add(this.bt_login);
            this.Controls.Add(this.tb_email);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Login";
            this.TopMost = true;
            this.pl_vc.ResumeLayout(false);
            this.pl_vc.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox tb_email;
        private System.Windows.Forms.Button bt_login;
        private System.Windows.Forms.TextBox tb_pwd;
        private System.Windows.Forms.TextBox tb_vc;
        private System.Windows.Forms.Button bt_close;
        private System.Windows.Forms.Label lb_vc;
        private System.Windows.Forms.Panel pl_vc;
        private System.Windows.Forms.CheckBox cb_7day;
    }
}

