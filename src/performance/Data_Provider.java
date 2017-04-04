package performance;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class Data_Provider {
		 @DataProvider(name = "Authentication" )
		  public static Object[][] credentials() {
			 Object data[][] = new Object[2][2];
			 return new Object[][] {
					{ "trainingstudent1", "123" },{ "trainingstudent2", "123" },{ "trainingstudent3", "123" }};
			  /*	{ "trainingstudent4", "123" },{ "trainingstudent5", "123" },{ "trainingstudent6", "123" },
					{ "trainingstudent7", "123" },{ "trainingstudent8", "123" },{ "trainingstudent9", "123" },
					{ "trainingstudent10", "123" },{ "trainingstudent11", "123" },{ "trainingstudent12", "123" },
					{ "trainingstudent13", "123" },{ "trainingstudent14", "123" },{ "trainingstudent15", "123" },
			        { "trainingstudent16", "123" },{ "trainingstudent17", "123" },{ "trainingstudent18", "123" },
					{ "trainingstudent19", "123" },{ "trainingstudent20", "123" },{ "trainingstudent21", "123" },
					{ "trainingstudent22", "123" },{ "trainingstudent23", "123" },{ "trainingstudent24", "123" },
					{ "trainingstudent25", "123" },{ "trainingstudent26", "123" },{ "trainingstudent27", "123" },
					{ "trainingstudent28", "123" },{ "trainingstudent29", "123" },{ "trainingstudent30", "123" },
					{ "trainingstudent31", "123" },{ "trainingstudent32", "123" },{ "trainingstudent33", "123" },
					{ "trainingstudent34", "123" },{ "trainingstudent35", "123" },{ "trainingstudent36", "123" },
					{ "trainingstudent37", "123" },{ "trainingstudent38", "123" },{ "trainingstudent39", "123" },
					{ "trainingstudent40", "123" },{ "trainingstudent41", "123" },{ "trainingstudent42", "123" },
					{ "trainingstudent43", "123" },{ "trainingstudent44", "123" },{ "trainingstudent45", "123" },
					{ "trainingstudent46", "123" },{ "trainingstudent47", "123" },{ "trainingstudent48", "123" },
					{ "trainingstudent49", "123" },{ "trainingstudent50", "123" }};*/
					 
		  }
	@DataProvider(name="TAuthentication")
	public static Object[][] Tcredentials() {
		 Object data[][] = new Object[2][2];
		 return new Object[][] { 
				 { "traineetutor1", "123" },{ "traineetutor2", "123" },{ "traineetutor3", "123" }};
				 /*{ "traineetutor4", "123" },{ "traineetutor5", "123" },{ "traineetutor6", "123" },
				 { "traineetutor7", "123" },{ "traineetutor8", "123" },{ "traineetutor9", "123" },
				 { "traineetutor10", "123" },{ "traineetutor11", "123" },{ "traineetutor12", "123" },
				 { "traineetutor13", "123" },{ "traineetutor14", "123" },{ "traineetutor15", "123" },
				 { "traineetutor16", "123" },{ "traineetutor17", "123" },{ "traineetutor18", "123" },
				 { "traineetutor19", "123" },{ "traineetutor20", "123" },{ "traineetutor21", "123" },
				 { "traineetutor22", "123" },{ "traineetutor23", "123" },{ "traineetutor24", "123" },
				 { "traineetutor25", "123" },{ "traineetutor26", "123" },{ "traineetutor27", "123" },
				 { "traineetutor28", "123" },{ "traineetutor29", "123" },{ "traineetutor30", "123" },
				 { "traineetutor31", "123" },{ "traineetutor32", "123" },{ "traineetutor33", "123" },
				 { "traineetutor34", "123" },{ "traineetutor35", "123" },{ "traineetutor36", "123" },
				 { "traineetutor37", "123" },{ "traineetutor38", "123" },{ "traineetutor39", "123" },
				 { "traineetutor40", "123" },{ "traineetutor41", "123" },{ "traineetutor42", "123" },
				 { "traineetutor43", "123" },{ "traineetutor44", "123" },{ "traineetutor45", "123" },
				 { "traineetutor46", "123" },{ "traineetutor47", "123" },{ "traineetutor48", "123" },
				 { "traineetutor49", "123" },{ "traineetutor50", "123" }};*/
	}
	/*@DataProvider
	public Object[][] common() {
	  List<Object[]> result = Lists.newArrayList();
	  result.addAll(Arrays.asList(credentials()));
	  result.addAll(Arrays.asList(Tcredentials()));
	  return result.toArray(new Object[result.size()][]);
	}
	@Test(dataProvider = "common")
	public void checkCommon(String a,String b)
	{
		System.out.println("Common S:"+a+"------ Common T :"+b);
		
	}*/


}
