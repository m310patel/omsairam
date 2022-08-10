package data;

import utilities.Xls_Reader;

public class datafile {
	
	Xls_Reader d = new Xls_Reader("C:\\SeleniumJars\\NikulTest.xlsx");

	public String WrongEmail = d.getCellData("Data1", "UserName", 3);
	public String WrongPassword = d.getCellData("Data1", "Password", 2);
	public String EmailError = d.getCellData("Data1", "Email Error", 6);
	public String FindyourAccError = d.getCellData("Data1", "Global Error", 6);


}
