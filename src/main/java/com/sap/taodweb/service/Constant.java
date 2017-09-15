package com.sap.taodweb.service;

public class Constant {
	public static final int MaxWaitSecond = 10;
	public static final String URL = "http://10.58.114.34/TAoD/LoginForm.aspx";

	// below fields need rewrite by user
	public static final String Username = "I311407";
	public static final String Passwrod = "I311407";
	// ToT name: DragonBoat;Bingo;CERES...
	public static final String ToTGroup = "DragonBoat";
	public static final String[] ToTGroups = { "Kappa", "Mikro", "Delta", "Laika", "Epsilon", "Aurora", "Bingo",
			"CERES", "DragonBoat", "McQueen", "Plato", "Venus", "Architect", "Atlas" };

	public static final boolean BookVM = true;

	// Project selection: 9.2_DEV;9.2_HANA_DEV;9.3_DEV;9.3_HANA_DEV
	public static final String Project = "9.2_DEV";
	// Install Project selection: 9.2_DEV;9.2_COR;9.3_DEV;9.3_COR
	public static final String InstallProject = "9.2_COR";

	// public static final ArrayList<String> TestCaseList = new
	// ArrayList<String>(Arrays.asList(
	// //
	// "//BUSMB_B1/TestAutomation_B1/9.2_DEV/9.2/Patch/PL07/BUB_486_GSTForIndiaIntroduction/",
	// "//BUSMB_B1/TestAutomation_B1/9.2_DEV/9.2/Patch/PL07/BUB_486_GSTForIndiaIntroduction/TestData/"));
	public static final String[] TestCaseList = {
			// "//BUSMB_B1/TestAutomation_B1/9.2_DEV/9.2/Patch/PL07/BUB_486_GSTForIndiaIntroduction/",
			"//BUSMB_B1/TestAutomation_B1/9.2_DEV/9.2/Patch/PL07/BUB_486_GSTForIndiaIntroduction/TestData/" };

	public static final String TestCasePath = "//BUSMB_B1/TestAutomation_B1/9.2_DEV/9.2/Patch/PL07/BUB_486_GSTForIndiaIntroduction/TestData/";
}
