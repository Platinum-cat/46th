using System;
using System.Collections;
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
    public partial class Seach_Flights : Form
    {
        public Seach_Flights()
        {
            InitializeComponent();
            dtp_dd.MinDate = dtp_dd.Value;
            dtp_rd.MinDate = dtp_dd.Value;
        }

        private void Seach_Flights_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“session1DataSet4.City”中。您可以根据需要移动或删除它。
            this.cityTableAdapter3.Fill(this.session1DataSet4.City);
            // TODO: 这行代码将数据加载到表“session1DataSet3.City”中。您可以根据需要移动或删除它。
            this.cityTableAdapter2.Fill(this.session1DataSet3.City);
            // TODO: 这行代码将数据加载到表“session1DataSet2.CabinType”中。您可以根据需要移动或删除它。
            this.cabinTypeTableAdapter.Fill(this.session1DataSet2.CabinType);
            // TODO: 这行代码将数据加载到表“session1DataSet1.City”中。您可以根据需要移动或删除它。
            this.cityTableAdapter1.Fill(this.session1DataSet1.City);
            // TODO: 这行代码将数据加载到表“session1DataSet.City”中。您可以根据需要移动或删除它。
            this.cityTableAdapter.Fill(this.session1DataSet.City);

        }

        int clickTimes = 0;
        Boolean flag = false;

        private void bt_search_Click(object sender, EventArgs e)
        {
            MessageBox.Show(AppTools.Search_flights.dateFormat(dtp_dd.Text));
            clickTimes++;
            //生成查询语句
            string sqlword = "select Schedule.EconomyPrice, Schedule.FlightNumber, Route.DepartureAirportIATA, Route.ArrivalAirportIATA, Schedule.Date, FlightStatus.ActualArrivalTime from Schedule, Route, FlightStatus, City as c_dep, Airport as ap1, City as c_arr, Airport as ap2 where Schedule.ScheduleId = FlightStatus.ScheduleId and Schedule.RouteId = Route.RouteId and c_dep.CityCode = ap1.CityCode and Route.DepartureAirportIATA = ap1.IATACode and c_arr.CityCode = ap2.CityCode and Route.ArrivalAirportIATA = ap2.IATACode and c_dep.CityName = '" + cb_from.Text.ToString().Trim() + "'and c_arr.CityName = '" + cb_to.Text.ToString().Trim() + "'";
            //链接数据库
            SqlDataReader sr = AppTools.connec(sqlword).ExecuteReader();
            //获取数据库的相关信息
            while (sr.Read())
            {
                flag = true;
                if (clickTimes >= 2)
                {
                    MessageBox.Show("已经显示所有剩余的票！");
                    return;
                }
                tickets ts = new tickets();
                //动态更改机票信息
                ts.gValue(sr[0].ToString().Trim(), Text = cb_ct.Text.ToString(), sr[1].ToString().Trim(), cb_from.Text.ToString().Trim() + "/" + sr[2].ToString().Trim(), cb_to.Text.ToString().Trim() + "/" + sr[3].ToString().Trim(), dtp_dd.Value.ToString(), dtp_rd.Value.ToString(), cb_ft.Text.ToString(), sr[5].ToString().Trim(), "12");
                flp_tickets.Controls.Add(ts);
            }
            if (flag == false)
            {
                string fromCity = "select Schedule.EconomyPrice, Schedule.FlightNumber, Route.DepartureAirportIATA, Route.ArrivalAirportIATA, Schedule.Date, FlightStatus.ActualArrivalTime from Schedule, Route, FlightStatus, City as c_dep, Airport as ap1, City as c_arr, Airport as ap2 where Schedule.ScheduleId = FlightStatus.ScheduleId and Schedule.RouteId = Route.RouteId and c_dep.CityCode = ap1.CityCode and Route.DepartureAirportIATA = ap1.IATACode and c_arr.CityCode = ap2.CityCode and Route.ArrivalAirportIATA = ap2.IATACode and c_dep.CityName = '"+cb_from.Text.ToString()+"'";
                string toCity = "select Schedule.EconomyPrice, Schedule.FlightNumber, Route.DepartureAirportIATA, Route.ArrivalAirportIATA, Schedule.Date, FlightStatus.ActualArrivalTime from Schedule, Route, FlightStatus, City as c_dep, Airport as ap1, City as c_arr, Airport as ap2 where Schedule.ScheduleId = FlightStatus.ScheduleId and Schedule.RouteId = Route.RouteId and c_dep.CityCode = ap1.CityCode and Route.DepartureAirportIATA = ap1.IATACode and c_arr.CityCode = ap2.CityCode and Route.ArrivalAirportIATA = ap2.IATACode and c_arr.CityName = '"+cb_to.Text.ToString()+"'";
                SqlDataReader sql_from = AppTools.connec(fromCity).ExecuteReader();
                SqlDataReader sql_to = AppTools.connec(toCity).ExecuteReader();
                while (sql_from.Read() && sql_to.Read())
                {
                    string s_f_rCity = sql_from[3].ToString().Trim();
                    string s_t_dCity = sql_to[2].ToString().Trim();
                    if (s_f_rCity == s_t_dCity)
                    {

                    }
                }
            }
        }

        private void dtp_rd_ValueChanged(object sender, EventArgs e)
        {
            dtp_rd.MinDate = dtp_dd.Value;
        }

        private void rb_oneway_CheckedChanged(object sender, EventArgs e)
        {
            pl_rd.Visible = false;

        }

        private void rb_roway_CheckedChanged(object sender, EventArgs e)
        {
            pl_rd.Visible = true;
        }
    }
}
