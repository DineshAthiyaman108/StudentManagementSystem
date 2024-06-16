import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* StudentServies performs the CURD options, It has addStudent for Adding the data inthe MSQL DB and updateStudent for the update the student in the db
*  delete is used to delete the data according to the id and display details is used to display the details with the help of Help of StudentRespositary*/
class StudentService
{
 private boolean flag = false;
 private StudentRespository respository = new StudentRespository();

/* addByStudentBYfile is used to read the file data and saved the data into the list*/

// 	// public void addByStudentByFile() throws Exception
// 	{
// 	try
// 	{
// 	BufferedReader studentRead = new BufferedReader(new FileReader("Ems\\src\\student.txt"));
// 	String line;
// 	while((line=studentRead.readLine())!=null)
// 	{
//     String[] data = line.split(",");
//      String name = data[0].trim();
//      int id = Integer.parseInt(data[1]);
//     double gpa = Double.parseDouble(data[2]);
//     String university = data[3].trim();
//      String city = data[4].trim();
//      Student student = new Student(id,name , gpa , university,city);
//      listOfStudent.add(student);
// 	}
// 	 System.out.println("Student is Successfully");
//     for(Student st  : listOfStudent)
//     {
//          System.out.println(st);
//      }
//     }
//  catch(IOException e)
// {
//  System.out.println(e.getMessage());
//  }
// 	catch(NumberFormatException e)
//     {
//     System.out.println(e.getMessage());
// 	}
   // }
    public void addStudent(Scanner input) throws Exception
    {
        try {
            input.nextLine();
            System.out.println("Enter Name");
            String name = input.nextLine().trim();
            System.out.println("Enter your Id"); 
            int id = input.nextInt();
            System.out.println("Enter your gpa");
            Double gpa = input.nextDouble();
            input.nextLine();
            System.out.println("Enter your University");
            String university = input.nextLine().trim();
            System.out.println("Enter Your City");
            String city = input.nextLine().trim();
            BigDecimal decimal = new BigDecimal(gpa).setScale(1,RoundingMode.DOWN);
            gpa = decimal.doubleValue();
            
            if(name!=null && id!=0 && gpa!=0.0 && university!=null && city!=null)
            {
                System.out.println( respository.addStudent(id, name, gpa, university, city));
                
            }
            else{
                throw new InputMismatchException("Enter the Correct Data");
            }

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    public void UpdateStudent(Scanner input) throws Exception
    {
    try {
        System.out.println("Enter your Id");
        int id =input.nextInt();
        if(id!=0)
        {
                input.nextLine();
                System.out.println("Enter Your name ");
                String name = input.nextLine().trim();
                System.out.println("Enter your gpa");
                double gpa = input.nextDouble();
                input.nextLine();
                System.out.println("Enter your City");
                String city = input.nextLine();
                input.nextLine();
                System.out.println("Enter Your University");
                String university = input.nextLine();
                BigDecimal decimal = new BigDecimal(gpa).setScale(1,RoundingMode.DOWN);
                gpa = decimal.doubleValue();
                respository.updateStudent(id, name, gpa, city, university);
                flag = true;   
        }  
         else{
            if(!flag)
            {
                System.out.println("Enter your Correct Id");
                UpdateStudent(input);
            }
         
          
        } 
    } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
    }
    }
    public void deleteStudent(Scanner input) throws Exception
    {
        flag=false;
        System.out.println("Enter the Id");
        int id = input.nextInt();
        if(id!=0)
        {

                    respository.deleteStudent(id);
                    flag=true;
            if(!flag)
            {
                System.out.println("Enter the Correct Details");
                deleteStudent(input);
            }
        }
        else{
            System.out.println("Enter the Correct Details");
        }
    
    } 
    public void displayDetail() throws Exception
 {
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("--------------------------STUDENT DETAILS--------------------------------");
    System.out.println("Student Name | " + "Student id | " +  "Student Gpa | " + " Stundet University | "  + " student city | ");
    respository.displayDetail();
 }
 
}