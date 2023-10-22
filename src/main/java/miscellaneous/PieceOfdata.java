package miscellaneous;

import java.util.ArrayList;

public class PieceOfdata {
	public int year;
	public int day;
	public int month;
	public int money;
	public String words;
	public String codec;
	public String datekey;
	public ArrayList<String> AttributeList;
	
	public PieceOfdata() {
		super();
		year=2023;
		day=5;
		month=10;
		money=100;
		words="Demo";
		setAttribute(-100,"表头",0,1,1,1,"NULL","NULL");
	}
	public void makeAttribute()
	{
		AttributeList= new ArrayList<>();
		AttributeList.add("1457");
		AttributeList.add("Demo");
		AttributeList.add(Integer.toString(money));
		datekey=Integer.toString(year)+"/"+Integer.toString(month)+"/"+Integer.toString(day)+"/";
		AttributeList.add(datekey);
		AttributeList.add("None");
		AttributeList.add("NULL");

	}
	public void setAttribute(int codecs,String name,int money,int day,int month,int year,String Notation,String others)
	{
		AttributeList= new ArrayList<>();
		codec=Integer.toString(codecs);
		AttributeList.add(codec);
		AttributeList.add(name);
		AttributeList.add(Integer.toString(money));
		datekey=Integer.toString(year)+"/"+Integer.toString(month)+"/"+Integer.toString(day)+"/";
		AttributeList.add(datekey);
		AttributeList.add(Notation);
		AttributeList.add(others);

	}
	

}
