import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int option;
        StudentService service = new StudentService();
        Scanner input = new Scanner(System.in);
      while (true) {
        System.out.println("Enter the Option : \n 1.New Student \n 2.Update Student \n 3.delete Student \n 4.display Details \n 5 exit");
        option = input.nextInt();
        switch (option) {
            case 1:
                service.addStudent(input);
                break;
                case 2:
                service.UpdateStudent(input);
                break;
                case 3:
                service.deleteStudent(input);
                break;
                case 4: 
                service.displayDetail();
                break;
                case 5:
                System.exit(0);
            default:
                System.out.println("Enter Correct Option");
        }

      }

    }
}
