package me.vik1395.PHPInfo;

import org.bukkit.Bukkit;

public class ServerData implements Runnable
{
	
	@Override
	public void run() 
	{
		String onpl = Integer.toString(Bukkit.getOnlinePlayers().length);
        GET Pinfo = new GET();
        String retv = Pinfo.postinfo(Main.sname, Float.toString(TPSCalc.getTps()), onpl, URAM(), uptime(), Main.pass);
        System.out.print("[PHPInfo] Response: " + retv);
        
	}
	
	private String uptime()
    {
        long diff = System.currentTimeMillis() - Main.serverStart;
        final String msg = (int)(diff / 86400000) + "d " + (int)(diff / 3600000 % 24) + "h " + (int)(diff / 60000 % 60) + "m " + (int)(diff / 1000 % 60) + "s";
        return msg;
        
    }
	
	private String URAM()
	{
		final Runtime runtime = Runtime.getRuntime();
        double TotalRAM = runtime.totalMemory() / 1024 / 1024;
        double FreeRAM = runtime.freeMemory() / 1024 / 1024;
        double UsedRAM = TotalRAM - FreeRAM;
		return Double.toString(UsedRAM);
	}
}
