package test;

public class Utility {
		public static String getQuestion(String SName,String TeacherUname) 
		{
			String num = TeacherUname.replaceAll("[a-zA-Z]","");
			return SName+num;
		}
	}

