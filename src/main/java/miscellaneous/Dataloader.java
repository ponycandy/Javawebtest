package miscellaneous;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import miscellaneous.DataOfaPerson;
import miscellaneous.PieceOfdata;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;
public class Dataloader {

	String url = "jdbc:mysql://localhost:3306/ponycandydatabase";
	String username = "root";
	String password = "138797";
	String jdbcDriver = "com.mysql.jdbc.Driver";
	
	public int headerNums;
	public ArrayList<String> headerList;
	public ArrayList<PieceOfdata> PieceDatalist;
	public ArrayList<DataOfaPerson> PersonDataList;
	public Map<Integer, Integer> namemap;
	public Mysqloperator sqlop;
	public Dataloader() {
		super();
		headerList = new ArrayList<>();

		headerList.add("编号");//codec
		headerList.add("姓名");//name
		headerList.add("款项");//paid
		headerList.add("日期");//date
		headerList.add("备注");//notation
		headerList.add("其它");//others
		headerNums=headerList.size();
		namemap = new HashMap<>();
		initPersonOfdata();
	}
	public ArrayList<PieceOfdata> searchDatekey(String searchkey)
	{
		ArrayList<PieceOfdata> list2return=new ArrayList<>();
		for (int i = 0; i < PersonDataList.size(); i++)
		{
			DataOfaPerson persondata=PersonDataList.get(i);
			if(persondata.map.containsKey(searchkey))
			{
				//				遍历此人的所有数据，直到当天的全部数据取出

				for (int j = 0; j < persondata.Datalist.size(); j++)
				{
					PieceOfdata pdata=persondata.Datalist.get(j);

					if(pdata.datekey.equals(searchkey))
					{
						//						遍历此人的所有数据，直到当天的全部数据取出
						list2return.add(pdata);
					}

				}

			}

		}
		return list2return;
	}
	public ArrayList<PieceOfdata> searchCodeckey(Integer searchkey)
	{
		ArrayList<PieceOfdata> list2return=new ArrayList<>();
		if(namemap.containsKey(searchkey))
		{
			int codec=namemap.get(searchkey);
			DataOfaPerson persondata=PersonDataList.get(codec);

			return persondata.Datalist;
		}
		else
		{
			return list2return;
		}


	}
	public int getSize()
	{


		return 2;
	}
	public void initPersonOfdata()
	{
		PersonDataList= new ArrayList<>();
		int i=0;
		int flag=0;
		int initcodec=-100;
		try 
		{
			// Register JDBC driver
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//这里报的是ClassNotFoundException错误，说明编译通过了，运行的时候找不到库
			//需要将库加到运行路径中！！
		//	https://blog.csdn.net/buckrook/article/details/131157540#:~:text=%E4%BD%A0%E5%8F%AF%E4%BB%A5%E6%8C%89%E7%85%A7%E4%BB%A5%E4%B8%8B%E6%AD%A5%E9%AA%A4%E6%93%8D%E4%BD%9C%EF%BC%9A%20%E5%9C%A8Eclipse%E4%B8%AD%EF%BC%8C%E9%80%89%E6%8B%A9%22Run%22%EF%BC%88%E8%BF%90%E8%A1%8C%EF%BC%89%E8%8F%9C%E5%8D%95%EF%BC%8C%E7%84%B6%E5%90%8E%E9%80%89%E6%8B%A9%22Run%20Configurations%22%EF%BC%88%E8%BF%90%E8%A1%8C%E9%85%8D%E7%BD%AE%EF%BC%89%E3%80%82%20%E5%9C%A8%E5%B7%A6%E4%BE%A7%E7%9A%84%E5%88%97%E8%A1%A8%E4%B8%AD%EF%BC%8C%E6%89%BE%E5%88%B0%E4%BD%A0%E7%9A%84Java%E5%BA%94%E7%94%A8%E7%A8%8B%E5%BA%8F%E9%85%8D%E7%BD%AE%E3%80%82,%E5%9C%A8%22Classpath%22%EF%BC%88%E7%B1%BB%E8%B7%AF%E5%BE%84%EF%BC%89%E9%80%89%E9%A1%B9%E5%8D%A1%E4%B8%8B%EF%BC%8C%E7%A1%AE%E4%BF%9D%E5%B7%B2%E9%80%89%E4%B8%AD%22User%20Entries%22%EF%BC%88%E7%94%A8%E6%88%B7%E6%9D%A1%E7%9B%AE%EF%BC%89%E3%80%82%20%E7%82%B9%E5%87%BB%22Add%20External%20JARs%22%EF%BC%88%E6%B7%BB%E5%8A%A0%E5%A4%96%E9%83%A8JAR%EF%BC%89%E6%8C%89%E9%92%AE%E3%80%82
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);

			// Create the SQL statement
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM ponycandytable ORDER BY codec ASC";
			//这里按照序号升序排列，这样就可以保证下面的数据读取是按照显示逻辑读取的了

			// Execute the query
			ResultSet resultSet = statement.executeQuery(query);

			// Process the result set
			DataOfaPerson newperson=new DataOfaPerson();
			PieceOfdata newpiece1=new PieceOfdata();
			newperson.addSubmitRecord(newpiece1);	
			while (resultSet.next())
			{
				// Retrieve the data from each column
				int codec = resultSet.getInt("codec");
				if(initcodec!=codec)
				{
					if(flag>0)
					{
						PersonDataList.add(newperson);

					}
					else
					{
						flag=1;
					}
					initcodec=codec;
					newperson=new DataOfaPerson();
					newpiece1=new PieceOfdata();
					namemap.put(codec, i);
					i+=1;

				}
				else

				{


				}



				int money = resultSet.getInt("paid");
				
				String datetoday = resultSet.getString("date");
				String[] numbers = datetoday.split("[^0-9]+");
				
				int day = Integer.parseInt(numbers[2]);
				int month = Integer.parseInt(numbers[1]);
				int year =Integer.parseInt(numbers[0]);

				

				
				
				String name = resultSet.getString("name");
				String notation = resultSet.getString("notation");
				String others = resultSet.getString("others");
				newpiece1.setAttribute(codec,name,money, day, month, year,notation,others);
				newperson.addSubmitRecord(newpiece1);	
				//数据库中必须首先进行排序


			}
			PersonDataList.add(newperson);

			// Close the resources
			resultSet.close();
			statement.close();
			connection.close();

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}




	}
	public void addRecord(PieceOfdata datas)
	{

		if(namemap.containsKey(Integer.parseInt(datas.codec)))
		{
			int order=namemap.get(Integer.parseInt(datas.codec));
			DataOfaPerson newperson=PersonDataList.get(order);
			newperson.addSubmitRecord(datas);
		}
		else

		{
			DataOfaPerson newperson=new DataOfaPerson();
			newperson.addSubmitRecord(datas);
			PersonDataList.add(newperson);
			namemap.put(Integer.parseInt(datas.codec), namemap.size());

		}

		try {
			// Establish the database connection
			Connection connection = DriverManager.getConnection(url, username, password);

			// Create the SQL statement with parameters
			String query = "insert into ponycandytable(codec,name,paid,date,notation,others,backup_1,backup_2 ) values (?,?,?,?,?,?,?,?)";

			// Create a prepared statement
			PreparedStatement statement = connection.prepareStatement(query);

			// Set the parameter values
			statement.setString(1, datas.codec); // codec
			statement.setString(2, datas.AttributeList.get(1)); //name
			statement.setString(3, datas.AttributeList.get(2)); // paid
			statement.setString(4, datas.AttributeList.get(3)); // date
			statement.setString(5, datas.AttributeList.get(4)); // notation
			statement.setString(6, datas.AttributeList.get(5)); // others
			statement.setString(7, "NULL blank"); // bakcup1
			statement.setString(8, "NULL blank"); // bakcup2


			// Execute the statement
			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) 
			{
				System.out.println("Data inserted successfully!");
			}

			// Close the resources
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
