using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SunshineAirLine
{
    
    public partial class tickets : UserControl
    {
        public tickets()
        {
            InitializeComponent();
        }
        public void gValue(string price, string cabinType, string flightNumber, string fromCity, string toCity, string fromDate, string toDate, string flightType, string tTime, string lastTicket)
        {
            lb_price.Text = "$"+price;
            lb_cabin_type.Text = cabinType;
            lb_f_num.Text = "Flight"+flightNumber;
            lb_from_city.Text = fromCity;
            lb_to_city.Text = toCity;
            lb_from_date.Text = fromDate.Split(' ')[0];
            lb_to_date.Text = toDate.Split(' ')[0];
            lb_flight_type.Text = flightType;
            lb_ttime.Text = tTime;
            lb_last_tickets.Text = lastTicket;
        }
    }
}
