package me.vik1395.PHPInfo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	public final static long serverStart = System.currentTimeMillis();
	public static String URLPath = "http://localhost/index.php";
	public static String sname = "";
	public static String pass = "";
	
	public void onEnable()
	{
		
		URLPath = getConfig().getString("PHP Script");
		String Intr = getConfig().getString("Interval");
		sname = getConfig().getString("Server Name");
		pass = getConfig().getString("Password");
        int minTime = Integer.parseInt(Intr);
        if(minTime<=1)
        {
        	minTime = 1;
        	System.out.println("[PHPInfo] Minimum ping interval is 1 minutes.");
        	System.out.println("[PHPInfo] Setting interval to 1 minutes");
        }
		int time = minTime*60*20;
        Runnable ServerData = new ServerData();
        Bukkit.getScheduler().runTaskTimer(this, ServerData, 0, time);
        Runnable TPSCalcc = new TPSCalc();
        Bukkit.getScheduler().runTaskTimer(this, TPSCalcc, 0, 40l);
		getLogger().info("PHPInfo has successfully started!");
		getLogger().info("Created by Vik1395");
		saveDefaultConfig();
		
	}
	
	@Override
	public boolean onCommand (CommandSender s, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("sendinfo"))
		{
				Player p = (Player)s;
				if(p.hasPermission("PHPInfo.sendinfo"))
				{
					PCommand pcm = new PCommand();
					String res = pcm.send();
					p.sendMessage(ChatColor.GOLD + "[PHPInfo]" + ChatColor.GREEN + "Server Response:" + ChatColor.WHITE + res);
				}
		}
		
		return true;
	}
	
}
