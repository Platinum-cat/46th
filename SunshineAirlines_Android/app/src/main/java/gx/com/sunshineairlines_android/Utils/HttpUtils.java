package gx.com.sunshineairlines_android.Utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 77344 on 2020/1/2.
 */

public class HttpUtils {
    private static String RootURL = "http://192.168.72.128:8080";
    public static String ReturnJSONDataListOfSponsors = RootURL + "/api/sponsor/list";
    public static String UserLogin = RootURL + "/api/Login?Email=param1&Password=param2";
    public static String ReturnJSONDataListOfAirports = RootURL + "/api/airport/list";
    public static String ReturnJSONDataOfUserByEmail = RootURL + "/api/user/param1";
    public static String ReturnJSONDataOfFlight = RootURL + "/api/flight/list?From=param1&To=param2&CabinType=param3&Date=param4\n&isAsc=param5";
    public static String ReturnJSONDataOfOrderByFlightIdAndCabinType = RootURL + "/api/order";
    public static String AddOrder = RootURL + "/api/order?FlightId=param1&UserId=param2&CabinType=param3&\nColumnName=param4&RowNumber=param5";
    public static String ReturnJSONDataListOfMileagePointsByUserId = RootURL + "/api/mileagepoints/ param1";

    /**
     * 拼接参数,调用方法
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    public static String Login(String email, String password) {
        ///api/login?Email=tt@gmail.com&Password=123456
        return HttpUtils.getJsonCode(RootURL + "/api/login?Email=" + email + "&Password=" + password, "POST");
    }

    public static String getJsonCode(String url, String type) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url1 = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
            urlConnection.setRequestMethod(type);

            InputStream inputStream = urlConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String code = null;
            while ((code = bufferedReader.readLine()) != null) {
                stringBuffer.append(code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }


    public static String post(String urlPath) {
        URL url;
        URLConnection urlConnection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(urlPath);
            urlConnection = url.openConnection(); // 打开连接
            // 设置 POST 方式
            inputStream = urlConnection.getInputStream(); // 获取输入流

            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String line1 = bufferedReader.readLine();// 读取一行
            sb.append(line1);// 读取所有的行

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    /**
     * JSON 解析
     * @param json
     */
    public void jsonToString(String json) {

        try {
            JSONArray ja = new JSONArray();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = (JSONObject) ja.get(0);
                String str = (String) jo.get("name");
                Log.i("h", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
