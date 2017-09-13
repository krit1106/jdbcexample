import java.sql.*;
import java.util.Scanner;

public class MysqlCon {
	
	void getData(){	//fetch the data from the database
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root", "consultadd505");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student");
			
			while(rs.next()){
				System.out.println("id is: " + rs.getInt(1));
				System.out.println("age is: " + rs.getInt(3));
				System.out.println("name is: " + rs.getString(2));
				
				System.out.println("-----------------------------------------------");
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void insertData(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root", "consultadd505");
			
			Statement st = con.createStatement();
			
			String query = "insert into student(id, name, age) values(?, ?, ?)";
			
			PreparedStatement p = con.prepareStatement(query);
			
			System.out.println("Enter student's id, name and age:");
			Scanner sc = new Scanner(System.in);
			int stud_id = sc.nextInt();
			String stud_name = sc.next();
			int stud_age = sc.nextInt();
			
			p.setInt(1, stud_id);
			p.setString(2, stud_name);
			p.setInt(3, stud_age);
			
			p.execute();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void deleteData(int stud_id){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root", "consultadd505");
			
			Statement st = con.createStatement();
			
			String query = "delete from student where id = ?";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1, stud_id);
			
			p.execute();
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		MysqlCon c = new MysqlCon();
		c.getData();
//		for(int i=0; i<2;i++){
//		c.insertData();
//		}
//		
//		System.out.println("After insertion:");
//		c.getData();
		
		c.deleteData(5);
		
		c.getData();
	}

}


