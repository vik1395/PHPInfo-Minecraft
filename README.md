PHPInfo collects server statistics like Ticks Per Second, Total players online, RAM Used, and the server Uptime. This data, along with the name of the server will be sent to a PHP web server repetitively with a user specified gap between each time. The plugin uses the GET method to send the data. It also has a password field that it sends to the PHP server, in case the user would like to password protect their PHP file.

This plugin is useful for PHP/Web developers who would like to mess around with their server stats on the interweb. There are various uses of this such as making applications that show the current status of the Server, and notify people if the it is experiencing downtime.

[jeff142](https://www.spigotmc.org/members/jeff142.199/) has written a simple php page that works as an api, saving the last 15 or so data lines received from the plugin in a html page.

If you like my work, please consider donating, I would greatly appreciate it. 

**Commands**
--------
    /sendinfo
    /si

These commands are used to send server stats to the PHP server manually. They do not affect the auto timer.

**Permissions**
-----------
    PHPInfo.sendinfo - Allows the player to use the /sendinfo command.

**Configuration**
----------
    PHP Script: http://localhost/index.php
    #link to the PHP script including the http:// tag.
    Interval: 5
    # Interval is the time in minutes before the plugin writes the Server Stats into Stats.txt. Minimum interval is 2 minutes.
    Server Name: A Minecraft Server
    #Name of this server goes here. This is used when posting to the webserver.
    Password: pass
    #You can use this field if you want to encrypt your php data with a password. The plugin sends the password a along with the other variables to the php server.



This plugin is licensed under **CC Attribution-NonCommercial-ShareAlike 4.0 International**. In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.
