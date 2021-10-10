package RegistrationAndLogIn;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FilePutUserData extends UserInformation{

    public FilePutUserData()
    {
        super();
    }

    //file upload data

    @Override
    public void takeInfo()
    {
        ReadDataFroFromFile ob3 = new ReadDataFroFromFile();
        LogIn obj33 = new LogIn();

        try{
            // PrintWriter pw = new PrintWriter(new FileWriter("UserBioData.txt"));


            System.out.println("Enter your First name : ");
            firstName = input.nextLine();

            System.out.println("Enter your Last name : ");
            lastName = input.nextLine();

            System.out.println("Enter your Phone Number : ");
            phoneNumber= input.nextLine();

            System.out.println("Enter your email id  : ");
            email = input.nextLine();

            System.out.println("Set your Password : ");
            setPassword = input.nextLine();
            //data show directly from control input 
            showInfo( firstName,lastName,phoneNumber , email , setPassword);
            // Set from file
            fileInputUserData(firstName,lastName,phoneNumber , email , setPassword);
            //LogIn.dataKeepFromFile(firstName,lastName,setPassword);
            System.out.print("'1' for show set up data \n'2' for log in ");
            int n;
            n = input.nextInt();
            if(n ==  1)
                ob3.outputDataFromFile(firstName,lastName);//data show direct from file
            else if(n == 2)
            {
                //LogIn.dataKeepFromFile(firstName,lastName,setPassword);
               // System.out.println("Welcome again");
                if(obj33.takeDataFromFile()) //that means true
                {
                    System.out.println("Go Forward ");
                }
            }
            else
                System.out.println("Wrong Choice ");
            //sucessfully work Alhmadullilah


        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    //data show direct from console Input
    @Override
    public void showInfo(String firstName,String lastName,String phoneNumber , String email , String setPassword)
    {
        System.out.println("***************************************************************");
        System.out.println("Your First name : "+firstName);

        System.out.println("Your Last name : "+lastName);

        System.out.println("Your Phone Number : "+phoneNumber);

        System.out.println("Your email id  : "+email);

        System.out.println("Your Password : "+setPassword);

        System.out.println("***************************************************************");
    }

    public  void fileInputUserData(String firstName,String lastName,String phoneNumber , String email , String setPassword){

        //here create new file that consist of user first and last name
        try(PrintWriter pw = new PrintWriter(new FileWriter(firstName+lastName+".txt"))) {
            //PrintWriter pw = new PrintWriter(new FileWriter("UserBioData.txt"));
            pw.write(firstName +"\n");
            pw.write(lastName +"\n");
            pw.write(phoneNumber +"\n");
            pw.write(email +"\n");
            pw.write(setPassword +"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
