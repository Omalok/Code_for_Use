package com.QA.R_Auction.UtilityClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.QA.R_Auction.baseClass.Driver_Class;

public class ScreenShot extends Driver_Class{

	
	public static void takeScreenShot () throws Exception
	{
		Date setDate = new Date();
		setDate.getDate();
		setDate.getMonth();
		setDate.getYear();

		TakesScreenshot tc = (TakesScreenshot)driver;
		File source =tc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/ "+timestamp()+" Test.png"));

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
