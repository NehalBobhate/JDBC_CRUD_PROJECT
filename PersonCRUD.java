package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {

	//1.Register and Establish Connection
	public Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb","root","root");
		return connection;
	}
	//2.Insert Data Method
	public void savePerson(int id,String name,int age,long phone,String address) throws Exception {
		
	Connection connection= getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2,name);
		preparedStatement.setInt(3, age);
		preparedStatement.setLong(4, phone);
		preparedStatement.setString(5, address);
		
		int result=preparedStatement.executeUpdate();
		if (result!=0) {
			System.out.println("DATA INSERTED SUCCESSLLY!!");
		} else {
				System.out.println("DATA INSERTION FAILED!!");
		}
		connection.close();
	}
	//3.Read Data Method
	public void readData(int id) throws Exception{
		
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
		
		preparedStatement.setInt(1, id);
		
		ResultSet rs=preparedStatement.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Id:-"+rs.getInt("id"));
			System.out.println("Name:-"+rs.getString("name"));
			System.out.println("Phone:-"+rs.getLong("phone"));
			System.out.println("Age:-"+rs.getInt("age"));
			System.out.println("Address:-"+rs.getString("address"));
		}
		connection.close();
	}
	//4.Update Data Method
	public void updateData(String name,int age,long phone,String address,int id) throws Exception {
				
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE PERSON SET  NAME=?, AGE=?, PHONE=?, ADDRESS=? WHERE ID=? ");
		
		preparedStatement.setString(1,name);
		preparedStatement.setInt(2, age);
		preparedStatement.setLong(3,phone);
		preparedStatement.setString(4,address);
		preparedStatement.setInt(5, id);
		int ct=preparedStatement.executeUpdate();
		if (ct!=0) {
			System.out.println("Data Updated Successfully!");
		}
		else
		{
			System.out.println("Data Updation Failed!");
		}
		 connection.close();
		
	}
	
	//4.Delete Data Method
	public void deleteData(int id) throws Exception {
		
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		
		preparedStatement.setInt(1,id);
		
		int ct=preparedStatement.executeUpdate();
		if (ct!=0) {
			System.out.println("Data Deleted Successfully!");
		}
		else
		{
			System.out.println("Data Deletion Failed");
		}
		
		connection.close();
	}
	
}
