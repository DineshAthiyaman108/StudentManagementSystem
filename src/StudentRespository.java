import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* StudentRespositary performs the CURD options, It has addStudent for Adding the data inthe MSQL DB and updateStudent for the update the student in the db
*  delete is used to delete the data according to the id and display details is used to display the details get Connection is used to connect the mysql db */
public class StudentRespository { 
	 private Connection con  =null;
 public Connection getConnection() throws ClassNotFoundException
 {
	    
	    String userName ="root";
        String userPassword = "Azarnanee008@";
        String url ="jdbc:mysql://localhost:3306/studentManagement?useSSL=false";
        try
        {
        con  = DriverManager.getConnection(url,userName ,userPassword);
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return con;
    }
	public boolean addStudent(int id , String name , double gpa , String university , String city) throws Exception
	{
	String insertQuery =" insert into StudentDetails values(?,?,?,?,?)";
    con = getConnection();
	if(con != null)
	{
      PreparedStatement insert = con.prepareStatement(insertQuery);
	  insert.setInt(1, id);
	  insert.setString(2,name);
	  insert.setDouble(3, gpa);
	  insert.setString(4, city);
	  insert.setString(5, university);
	  insert.executeUpdate();
	  return true;
	}
	return false;
	}
	public boolean updateStudent(int id , String name , double gpa , String city , String university) throws Exception
	{
    con = getConnection();
	if(con != null)
	{
		String updateQuery ="update  studentDetails set stu_name= ?,stu_gpa = ?,stu_city = ?,stu_university = ?  where stu_id = ?";
		PreparedStatement update = con.prepareStatement(updateQuery);
		update.setString(1, name);
		update.setDouble(2, gpa);
		update.setString(3, city);
		update.setString(4, university);
		update.setInt(5, id);
		update.executeUpdate();
		return true;
	}
  return false;


	}
    public boolean deleteStudent(int id) throws Exception
	{
		con = getConnection();
		String deleteQuery = "delete from studentDetails where stu_id = ?";
		PreparedStatement statement =  con.prepareStatement(deleteQuery);
		statement.setInt(1, id);
		int flag = statement.executeUpdate();
	return flag==1? true:false;
	}
     public void displayDetail() throws Exception
	{
		
		con = getConnection();
	String select = "select * from studentdetails";
	Statement statement  = con.createStatement();
	ResultSet result = statement.executeQuery(select);
	while (result.next()) {
		System.out.println(result.getInt("stu_id") + "\t\t" + result.getString("stu_name") + "\t\t" + result.getDouble("stu_gpa") + "\t\t" + result.getString("stu_university") + "\t\t" + result.getString("stu_city"));
	}
	}

 }
