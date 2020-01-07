namespace SunshineAirLine
{
    partial class Seach_Flights
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
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.bt_search = new System.Windows.Forms.Button();
            this.cb_ft = new System.Windows.Forms.ComboBox();
            this.cb_ct = new System.Windows.Forms.ComboBox();
            this.cabinTypeBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.session1DataSet2 = new SunshineAirLine.Session1DataSet2();
            this.dtp_rd = new System.Windows.Forms.DateTimePicker();
            this.dtp_dd = new System.Windows.Forms.DateTimePicker();
            this.cb_to = new System.Windows.Forms.ComboBox();
            this.cityBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.session1DataSet1 = new SunshineAirLine.Session1DataSet1();
            this.cb_from = new System.Windows.Forms.ComboBox();
            this.cityBindingSource2 = new System.Windows.Forms.BindingSource(this.components);
            this.session1DataSet3 = new SunshineAirLine.Session1DataSet3();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.rb_roway = new System.Windows.Forms.RadioButton();
            this.rb_oneway = new System.Windows.Forms.RadioButton();
            this.cityBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.session1DataSet = new SunshineAirLine.Session1DataSet();
            this.cityTableAdapter = new SunshineAirLine.Session1DataSetTableAdapters.CityTableAdapter();
            this.cityTableAdapter1 = new SunshineAirLine.Session1DataSet1TableAdapters.CityTableAdapter();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.cabinTypeTableAdapter = new SunshineAirLine.Session1DataSet2TableAdapters.CabinTypeTableAdapter();
            this.flp_tickets = new System.Windows.Forms.FlowLayoutPanel();
            this.cityTableAdapter2 = new SunshineAirLine.Session1DataSet3TableAdapters.CityTableAdapter();
            this.pl_rd = new System.Windows.Forms.Panel();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.session1DataSet4 = new SunshineAirLine.Session1DataSet4();
            this.cityBindingSource3 = new System.Windows.Forms.BindingSource(this.components);
            this.cityTableAdapter3 = new SunshineAirLine.Session1DataSet4TableAdapters.CityTableAdapter();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cabinTypeBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet)).BeginInit();
            this.pl_rd.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource3)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 20F);
            this.label1.Location = new System.Drawing.Point(417, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(208, 27);
            this.label1.TabIndex = 1;
            this.label1.Text = "Search Flights";
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.pl_rd);
            this.panel1.Controls.Add(this.bt_search);
            this.panel1.Controls.Add(this.cb_ft);
            this.panel1.Controls.Add(this.cb_ct);
            this.panel1.Controls.Add(this.dtp_dd);
            this.panel1.Controls.Add(this.cb_to);
            this.panel1.Controls.Add(this.cb_from);
            this.panel1.Controls.Add(this.label7);
            this.panel1.Controls.Add(this.label6);
            this.panel1.Controls.Add(this.label4);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.rb_roway);
            this.panel1.Controls.Add(this.rb_oneway);
            this.panel1.Location = new System.Drawing.Point(12, 114);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1051, 105);
            this.panel1.TabIndex = 2;
            // 
            // bt_search
            // 
            this.bt_search.Location = new System.Drawing.Point(909, 39);
            this.bt_search.Name = "bt_search";
            this.bt_search.Size = new System.Drawing.Size(106, 37);
            this.bt_search.TabIndex = 3;
            this.bt_search.Text = "Search";
            this.bt_search.UseVisualStyleBackColor = true;
            this.bt_search.Click += new System.EventHandler(this.bt_search_Click);
            // 
            // cb_ft
            // 
            this.cb_ft.FormattingEnabled = true;
            this.cb_ft.Items.AddRange(new object[] {
            "All",
            "Non_stop",
            "stop"});
            this.cb_ft.Location = new System.Drawing.Point(761, 56);
            this.cb_ft.Name = "cb_ft";
            this.cb_ft.Size = new System.Drawing.Size(94, 20);
            this.cb_ft.TabIndex = 13;
            // 
            // cb_ct
            // 
            this.cb_ct.DataSource = this.cabinTypeBindingSource;
            this.cb_ct.DisplayMember = "CabinTypeName";
            this.cb_ct.FormattingEnabled = true;
            this.cb_ct.Location = new System.Drawing.Point(636, 56);
            this.cb_ct.Name = "cb_ct";
            this.cb_ct.Size = new System.Drawing.Size(94, 20);
            this.cb_ct.TabIndex = 11;
            this.cb_ct.ValueMember = "CabinTypeName";
            // 
            // cabinTypeBindingSource
            // 
            this.cabinTypeBindingSource.DataMember = "CabinType";
            this.cabinTypeBindingSource.DataSource = this.session1DataSet2;
            // 
            // session1DataSet2
            // 
            this.session1DataSet2.DataSetName = "Session1DataSet2";
            this.session1DataSet2.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // dtp_rd
            // 
            this.dtp_rd.Location = new System.Drawing.Point(3, 42);
            this.dtp_rd.Name = "dtp_rd";
            this.dtp_rd.Size = new System.Drawing.Size(107, 21);
            this.dtp_rd.TabIndex = 12;
            this.dtp_rd.ValueChanged += new System.EventHandler(this.dtp_rd_ValueChanged);
            // 
            // dtp_dd
            // 
            this.dtp_dd.Location = new System.Drawing.Point(345, 50);
            this.dtp_dd.Name = "dtp_dd";
            this.dtp_dd.Size = new System.Drawing.Size(126, 21);
            this.dtp_dd.TabIndex = 11;
            // 
            // cb_to
            // 
            this.cb_to.DataSource = this.cityBindingSource1;
            this.cb_to.DisplayMember = "CityName";
            this.cb_to.FormattingEnabled = true;
            this.cb_to.Location = new System.Drawing.Point(232, 53);
            this.cb_to.Name = "cb_to";
            this.cb_to.Size = new System.Drawing.Size(94, 20);
            this.cb_to.TabIndex = 10;
            this.cb_to.ValueMember = "CityName";
            // 
            // cityBindingSource1
            // 
            this.cityBindingSource1.DataMember = "City";
            this.cityBindingSource1.DataSource = this.session1DataSet1;
            // 
            // session1DataSet1
            // 
            this.session1DataSet1.DataSetName = "Session1DataSet1";
            this.session1DataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // cb_from
            // 
            this.cb_from.DataSource = this.cityBindingSource2;
            this.cb_from.DisplayMember = "CityName";
            this.cb_from.FormattingEnabled = true;
            this.cb_from.Location = new System.Drawing.Point(121, 53);
            this.cb_from.Name = "cb_from";
            this.cb_from.Size = new System.Drawing.Size(94, 20);
            this.cb_from.TabIndex = 9;
            this.cb_from.ValueMember = "CityName";
            // 
            // cityBindingSource2
            // 
            this.cityBindingSource2.DataMember = "City";
            this.cityBindingSource2.DataSource = this.session1DataSet3;
            // 
            // session1DataSet3
            // 
            this.session1DataSet3.DataSetName = "Session1DataSet3";
            this.session1DataSet3.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("宋体", 15F);
            this.label7.Location = new System.Drawing.Point(757, 13);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(129, 20);
            this.label7.TabIndex = 8;
            this.label7.Text = "Flight Type:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("宋体", 15F);
            this.label6.Location = new System.Drawing.Point(632, 13);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(119, 20);
            this.label6.TabIndex = 7;
            this.label6.Text = "Cabin Type:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("宋体", 15F);
            this.label5.Location = new System.Drawing.Point(0, 2);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(129, 20);
            this.label5.TabIndex = 6;
            this.label5.Text = "Return Date:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("宋体", 15F);
            this.label4.Location = new System.Drawing.Point(332, 13);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(159, 20);
            this.label4.TabIndex = 5;
            this.label4.Text = "Departure Date:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("宋体", 15F);
            this.label2.Location = new System.Drawing.Point(237, 13);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 20);
            this.label2.TabIndex = 4;
            this.label2.Text = "To city:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("宋体", 15F);
            this.label3.Location = new System.Drawing.Point(122, 13);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(109, 20);
            this.label3.TabIndex = 3;
            this.label3.Text = "From City:";
            // 
            // rb_roway
            // 
            this.rb_roway.AutoSize = true;
            this.rb_roway.Location = new System.Drawing.Point(32, 66);
            this.rb_roway.Name = "rb_roway";
            this.rb_roway.Size = new System.Drawing.Size(83, 16);
            this.rb_roway.TabIndex = 1;
            this.rb_roway.TabStop = true;
            this.rb_roway.Text = "Round Ways";
            this.rb_roway.UseVisualStyleBackColor = true;
            this.rb_roway.CheckedChanged += new System.EventHandler(this.rb_roway_CheckedChanged);
            // 
            // rb_oneway
            // 
            this.rb_oneway.AutoSize = true;
            this.rb_oneway.Location = new System.Drawing.Point(32, 29);
            this.rb_oneway.Name = "rb_oneway";
            this.rb_oneway.Size = new System.Drawing.Size(71, 16);
            this.rb_oneway.TabIndex = 0;
            this.rb_oneway.Text = "Onew Way";
            this.rb_oneway.UseVisualStyleBackColor = true;
            this.rb_oneway.CheckedChanged += new System.EventHandler(this.rb_oneway_CheckedChanged);
            // 
            // cityBindingSource
            // 
            this.cityBindingSource.DataMember = "City";
            this.cityBindingSource.DataSource = this.session1DataSet;
            // 
            // session1DataSet
            // 
            this.session1DataSet.DataSetName = "Session1DataSet";
            this.session1DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // cityTableAdapter
            // 
            this.cityTableAdapter.ClearBeforeFill = true;
            // 
            // cityTableAdapter1
            // 
            this.cityTableAdapter1.ClearBeforeFill = true;
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            // 
            // cabinTypeTableAdapter
            // 
            this.cabinTypeTableAdapter.ClearBeforeFill = true;
            // 
            // flp_tickets
            // 
            this.flp_tickets.AutoScroll = true;
            this.flp_tickets.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.flp_tickets.Location = new System.Drawing.Point(12, 245);
            this.flp_tickets.Name = "flp_tickets";
            this.flp_tickets.Size = new System.Drawing.Size(1047, 204);
            this.flp_tickets.TabIndex = 4;
            // 
            // cityTableAdapter2
            // 
            this.cityTableAdapter2.ClearBeforeFill = true;
            // 
            // pl_rd
            // 
            this.pl_rd.Controls.Add(this.label5);
            this.pl_rd.Controls.Add(this.dtp_rd);
            this.pl_rd.Location = new System.Drawing.Point(497, 11);
            this.pl_rd.Name = "pl_rd";
            this.pl_rd.Size = new System.Drawing.Size(133, 71);
            this.pl_rd.TabIndex = 14;
            this.pl_rd.Visible = false;
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.AutoScroll = true;
            this.flowLayoutPanel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.flowLayoutPanel1.Location = new System.Drawing.Point(12, 470);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(1047, 179);
            this.flowLayoutPanel1.TabIndex = 5;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("宋体", 15F);
            this.label8.Location = new System.Drawing.Point(19, 232);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(179, 20);
            this.label8.TabIndex = 6;
            this.label8.Text = "Deparyure Flights";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("宋体", 15F);
            this.label9.Location = new System.Drawing.Point(19, 452);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(149, 20);
            this.label9.TabIndex = 7;
            this.label9.Text = "Return Flights";
            // 
            // session1DataSet4
            // 
            this.session1DataSet4.DataSetName = "Session1DataSet4";
            this.session1DataSet4.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // cityBindingSource3
            // 
            this.cityBindingSource3.DataMember = "City";
            this.cityBindingSource3.DataSource = this.session1DataSet4;
            // 
            // cityTableAdapter3
            // 
            this.cityTableAdapter3.ClearBeforeFill = true;
            // 
            // Seach_Flights
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1074, 661);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Controls.Add(this.flp_tickets);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.label1);
            this.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
            this.Name = "Seach_Flights";
            this.Text = "Search Flights";
            this.Load += new System.EventHandler(this.Seach_Flights_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cabinTypeBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet)).EndInit();
            this.pl_rd.ResumeLayout(false);
            this.pl_rd.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.session1DataSet4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource3)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.RadioButton rb_roway;
        private System.Windows.Forms.RadioButton rb_oneway;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox cb_to;
        private System.Windows.Forms.ComboBox cb_from;
        private System.Windows.Forms.Button bt_search;
        private System.Windows.Forms.ComboBox cb_ft;
        private System.Windows.Forms.ComboBox cb_ct;
        private System.Windows.Forms.DateTimePicker dtp_rd;
        private System.Windows.Forms.DateTimePicker dtp_dd;
        private Session1DataSet session1DataSet;
        private System.Windows.Forms.BindingSource cityBindingSource;
        private Session1DataSetTableAdapters.CityTableAdapter cityTableAdapter;
        private Session1DataSet1 session1DataSet1;
        private System.Windows.Forms.BindingSource cityBindingSource1;
        private Session1DataSet1TableAdapters.CityTableAdapter cityTableAdapter1;
        private System.Windows.Forms.Timer timer1;
        private Session1DataSet2 session1DataSet2;
        private System.Windows.Forms.BindingSource cabinTypeBindingSource;
        private Session1DataSet2TableAdapters.CabinTypeTableAdapter cabinTypeTableAdapter;
        private System.Windows.Forms.FlowLayoutPanel flp_tickets;
        private Session1DataSet3 session1DataSet3;
        private System.Windows.Forms.BindingSource cityBindingSource2;
        private Session1DataSet3TableAdapters.CityTableAdapter cityTableAdapter2;
        private System.Windows.Forms.Panel pl_rd;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private Session1DataSet4 session1DataSet4;
        private System.Windows.Forms.BindingSource cityBindingSource3;
        private Session1DataSet4TableAdapters.CityTableAdapter cityTableAdapter3;
    }
}