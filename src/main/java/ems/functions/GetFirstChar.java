package ems.functions;

public class GetFirstChar {

	public static String getString(String s)
	{
		StringBuffer sb=new StringBuffer(s);
		s.trim();
		String t="";
		int len=s.length(),k=0;
		while(k<len)
		{
			if(k==0)
			t=t+sb.charAt(k);
			if((sb.charAt(k)+"").equals(" "))
			{
				t=t+sb.charAt(k+1);
			}
			k++;
		}
		return t;
	}
//	public static void main(String args[])
//	{
//		GetFirstChar gf=new GetFirstChar("computer science department");
//		System.out.println(gf.getString());
//	}

}
