package me.vik1395.PHPInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class GET 
{
	public String postinfo(String name, String setps, String tplayers, String URAM, String up, String pass)
	{
		String response="";
		try 
		{
			String server = URLEncoder.encode(name, "UTF-8");
			String tps = URLEncoder.encode(setps, "UTF-8");
            String players = URLEncoder.encode(tplayers, "UTF-8");
            String RAM = URLEncoder.encode(URAM, "UTF-8");
            String pw = URLEncoder.encode(pass, "UTF-8");
            String Uptime = URLEncoder.encode(up, "UTF-8");
            String postData = "?Server=" + server + "&" + "Players=" + players + "&" + "TPS=" + tps + "&" + "RAM=" + RAM + "&" + "Uptime=" + Uptime + "&" + "Password=" + pw;
            
            URL url = new URL(Main.URLPath+postData);
            InputStream is = url.openConnection().getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder responseSB = new StringBuilder();
            String line;
            
            while ( (line = br.readLine()) != null)
                responseSB.append(line);
            
            
            br.close();
            is.close();
            response = responseSB.toString();
        } 
		catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
		return response;
	}
}
