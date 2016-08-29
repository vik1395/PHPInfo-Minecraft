<?php
	/**************************************************************************
	*  Copyright Jeffery Schefke May-9-2014 LegitPlay.net                     *
	*  Beta API 0.0.1 for PHPinfo plugin by Vik1395                           *
	*  Attribution-ShareAlike 4.0 International                               *
	*  http://creativecommons.org/licenses/by-sa/4.0/legalcode                *
	*  Basic terms http://creativecommons.org/licenses/by-sa/4.0/             *
	**************************************************************************/

	/*********************************
	*            Config              *
	*********************************/
	// Set our password
	$varPasswordset = 'pass';

	// This is the file we save to, it needs to be read and write able
	$saveFile = 'index.html';

	// Wrong password Message
	$wrongPassword = "Wrong Password! Check Config.";

	// Save message
	$Success = "Data has been saved!";



	/*********************************
	* Its all scary code form hear   *
	* to the end, don't poke with it *
	* unless you got backups of this *
	*********************************/


	// php can be wacky with get, put it to a var
	$varServer = $_GET["Server"];
	$varPlayers = $_GET["Players"];
	$varTps = $_GET["TPS"];
	$varRAM = $_GET["RAM"];
	$varUptime = $_GET["Uptime"];
	$varPassword  = $_GET["Password"];

	// We check the password and make sure that we 'GET' the correct one
	if($varPassword == $varPasswordset)
	{
		// Lets get the date, we will need this to see when the data was received from the plugin.
		$varDate = date('Y-m-d H:i:s');

		// Get the size of the save file
		$filesize = filesize($saveFile);

		// Opens the file for writing
		$fh = fopen($saveFile, 'a+') or die("can't open file");

		// Put all the info together
		$writeServer = $varDate." | Server: ".$varServer." | Players: ".$varPlayers." | TPS: ".$varTps." | Used Ram: ".$varRAM." | Uptime: ".$varUptime."</br> \n";

		// We check if the file is readable
		if(!is_readable($saveFile))
		{
			die("Cant read file");
		}

		// Now we actually read all the data in the file and save it in a var
		$saveFilecontents = fread($fh, $filesize);

		// we are done reading
		fclose($fh);

		// Reopen the file so that we can write the info back
		$fh = fopen($saveFile, 'w') or die("can't open file");

		// explode the data previously saved from the file, into an array
		$arraySaveFile = explode('</br>', $saveFilecontents);

		// Trim the first line off
		array_shift($arraySaveFile);

		// Implode the file
		$saveFilecontents = implode('</br>', $arraySaveFile);

		// Add the latest info from the plugin to the var
		$saveFileContents = $saveFilecontents.$writeServer;

		// Now save it all into the file.
		fwrite($fh, $saveFileContents);


		// Close the file
		fclose($fh);

		// Send a success message back to the plugin if everything went successfully.
		echo $Success;

		// Closing tag for the "if" statement
	}

	// Send a message to the plugin if the password given was didnt match.
	else
	{
		// Return this to the plugin if it is wrong.
		echo $wrongPassword;
	}
?>
