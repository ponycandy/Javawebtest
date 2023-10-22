package miscellaneous;
import java.util.ArrayList;

import miscellaneous.PieceOfdata;
import java.util.HashMap;
import java.util.Map;

public class DataOfaPerson {

	public Map<String, Integer> map;
	public int codec;
	public ArrayList<PieceOfdata> Datalist;
	public void addSubmitRecord(PieceOfdata somerecord)
	{
		map.put(somerecord.datekey, Datalist.size());
		Datalist.add(somerecord);
		
	}
	public DataOfaPerson() {
		super();
		Datalist = new ArrayList<>();
		map = new HashMap<>();
	}
}
