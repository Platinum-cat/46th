namespace SunshineAirLine
{
    partial class Office_User_Menu
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.seachFlightsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.foodSevrvicesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.fightStatusToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.logoutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.seachFlightsToolStripMenuItem,
            this.foodSevrvicesToolStripMenuItem,
            this.fightStatusToolStripMenuItem,
            this.logoutToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(984, 25);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // seachFlightsToolStripMenuItem
            // 
            this.seachFlightsToolStripMenuItem.Name = "seachFlightsToolStripMenuItem";
            this.seachFlightsToolStripMenuItem.Size = new System.Drawing.Size(95, 21);
            this.seachFlightsToolStripMenuItem.Text = "Seach Flights";
            // 
            // foodSevrvicesToolStripMenuItem
            // 
            this.foodSevrvicesToolStripMenuItem.Name = "foodSevrvicesToolStripMenuItem";
            this.foodSevrvicesToolStripMenuItem.Size = new System.Drawing.Size(107, 21);
            this.foodSevrvicesToolStripMenuItem.Text = "Food Sevrvices";
            // 
            // fightStatusToolStripMenuItem
            // 
            this.fightStatusToolStripMenuItem.Name = "fightStatusToolStripMenuItem";
            this.fightStatusToolStripMenuItem.Size = new System.Drawing.Size(87, 21);
            this.fightStatusToolStripMenuItem.Text = "Fight Status";
            // 
            // logoutToolStripMenuItem
            // 
            this.logoutToolStripMenuItem.Name = "logoutToolStripMenuItem";
            this.logoutToolStripMenuItem.Size = new System.Drawing.Size(61, 21);
            this.logoutToolStripMenuItem.Text = "Logout";
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(40, 21);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // Office_User_Menu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(984, 661);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Office_User_Menu";
            this.Text = "Office User Menu";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem seachFlightsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem foodSevrvicesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem fightStatusToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem logoutToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
    }
}