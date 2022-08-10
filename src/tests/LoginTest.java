package tests;

import org.testng.annotations.Test;

import data.datafile;
import pages.LoginPage;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	LoginPage lp = new LoginPage();
	datafile dp = new datafile();

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {

		lp.OpenBrowser();
		lp.OpenLoginpage();
		}

	@AfterMethod
	public void afterMethod() {

		lp.CloseBrowser();
	}

	@Test(priority = 1)
	public void FBsigninwithwrongEmail() throws InterruptedException {
		lp.login(dp.WrongEmail, dp.WrongPassword);
		Assert.assertEquals(lp.ReadEmailError(), dp.EmailError);

		/*
		 * System.out.println(WrongEmail); System.out.println(WrongPassword);
		 * System.out.println(EmailError); System.out.println(FindyourAccError);
		 */
	}

	@Test(priority = 2)
	public void FBFindyourAcc() throws InterruptedException {
		lp.login(dp.WrongEmail, dp.WrongPassword);

		String expectederror = dp.FindyourAccError;
		String actualerror = lp.ReadFindyourAccError();

		if (expectederror.equals(actualerror)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	@Test(priority = 3)
	public void CreateNewAcc() throws InterruptedException {

		lp.CreateNewAcc();
	}
}