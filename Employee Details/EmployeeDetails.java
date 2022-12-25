//Save the name of the file as "EmployeeDetails.java"
//Coder: Ashi777

package emailapp;

import java.util.*;                                          

import java.lang.Character;             //conversion of UpperCase character to LowerCase

public class EmployeeDetails
{
    public static void main (String[] args) throws Exception
    {
    	String newline = System.lineSeparator();
    	Scanner in = new Scanner(System.in);                //using scanner to take input from the user
		

        int choice;
        int i = 0;       //index for the inclusion of employee details

        EmployeeDetail defaultObj = new EmployeeDetail();      //creating object and initializing it with default type constructor

        defaultObj.arrValueNullProvider();                   //initializing the name array with null values

        //menu, using do while loop as want to print this menu at least once
        do
        {
            System.out.print(newline+"----------------------------------   MENU   -----------------------------------");
            System.out.print(newline+"(1) DISPLAY DATABASE OF EMPLOYEES");
            System.out.print(newline+"(2) DISPLAY YOUR DETAILS");
            System.out.print(newline+"(3) GENERATE A NEW EMAIL");
            System.out.print(newline+"(4) ADD EMPLOYEE DETAILS");
            System.out.print(newline+"(5) DELETE EMPLOYEE DETAILS");
            System.out.print(newline+"(6) UPDATE EMPLOYEE DETAILS");
            System.out.print(newline+"(7) EXIT");
            System.out.print(newline+"-------------------------------------------------------------------------------");
            System.out.print(newline+newline+"Enter your choice : ");
            choice = in.nextInt();      //taking integer at first index

            defaultObj.line();
            
            switch(choice)    //all methods are invoked based on the menu driven options
            {  
                case 1:
                	 defaultObj.showEmployeeDetails(i);
                     ++i;
                     break;
                	                   
                case 2:
                    defaultObj.viewYourDetails(i); 
                    Thread.sleep(3000);
                    break;

                case 3:
                    defaultObj.generateNewMail(i); 
                    ++i;
                    Thread.sleep(2000);
                    break;
                    
                case 4:
                	defaultObj.addEmployeeDetails(i);
                    ++i;             	
                    Thread.sleep(2000);
                    
                    break;
                                       
                case 5:
                    defaultObj.deleteEmployeeDetails();   
                    if (defaultObj.taskDeleteDetailsANS() == true)
                    {
                        --i;
                    }
                    else
                        continue;
                    Thread.sleep(2000);
                    break;
                 
                case 6:
                    defaultObj.updateEmployeeDetails();                	
                    Thread.sleep(3000);
                    break;

                case 7:                	
                    break;

                default:
                    System.out.println(newline+"Invalid input, Please enter a valid input"+newline);
                    break;                
            }

            defaultObj.line();
            
            Thread.sleep(3000);  
           //to pause the program for 3 seconds
           
    } while (choice != 7);    //if choice is 7, then exit the program
      
        System.out.print(newline+"********************   Thank you for using the application   ********************"+newline);

        System.out.print(newline+"*********************************************************************************"+newline+newline);

        Thread.sleep(1500);     //to pause the program for 1.5 seconds
    }  
}




class EmployeeDetail extends EmployeeDetails
{
    //private for internal use only, i.e. not accessible outside the class

    private String name;
    private int age;
    private static String company = "anycompany";       //static variable, common for all employees
    private String department; 
    private int salary;
    private String dob;
    private int employeeId;
    private String password;
    private String email;
    private int defaultPasswordLength = 10;
    private int administratorId = 37584767;                        //we have taken administrator's Id = 37584767
    private String administratorPassword = "%T6J!E@04P";               //we have taken administrator's password = "%T6J!E@04P"
    
    private int choice;

    public boolean updateDetailsANS;

    public EmployeeDetail[] arrDetails = new EmployeeDetail[1000];     //array of objects for employee details, with max entries of 1000
 
    static Scanner scannner;

    //default constructor
    public EmployeeDetail () {}

    
    //constructor for employee details, has been used internally in class
    public EmployeeDetail (String name, int age, String dob, int employeeId, String department,int salary, String email, String password)
    {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.password = password;
    }
    
    
    //Displaying the detail of a particular employee based on index provided
    public void showEmployeeDetails(int i)
    {
    	String newline = System.lineSeparator();

        System.out.print(newline+"Employee Details : "+newline+newline);

        //displaying the details of the employee, if the index is not null, i.e. as deletion of a detail make that index's value null       
        for (i=0; i<arrDetails.length; i++)
        {
            if (arrDetails[i] != null)    //if index's entry is not null, print the name of the employees in tabular form
            {
            	System.out.println("Name : "+arrDetails[i].name);
                System.out.println("Employee ID : "+arrDetails[i].employeeId);
                System.out.println("Age : "+arrDetails[i].age);
                System.out.println("Date of Birth : "+arrDetails[i].dob);
                System.out.println("Company : "+ company);
                System.out.println("Department : "+ arrDetails[i].department);
                System.out.println("Email : "+ arrDetails[i].email);
                
                line();
            }             
        }        
    }
     
    
    
    //displaying all employee names, i.e. the names of all employee whose details have been added
    public void displayAllEmployee ()
    {
        String newline = System.lineSeparator();

        line();

        for (int i=0; i<arrDetails.length; i++)
        {
            if (arrDetails[i] != null)    //if index's entry is not null, print the name of the employees in tabular form
            {
                System.out.println("("+i+") "+arrDetails[i].name+'\t');
            }           
        }
        
        line();   
    }
    
    
    
    public void viewYourDetails(int i)
    {
    	String newline = System.lineSeparator();
        Scanner in = new Scanner(System.in);
    	
    	System.out.println("Enter your Id: ");
        int idInserted = in.nextInt();
        System.out.println("Enter your Password: ");
        String passwordInserted = in.next();
        int b=idInserted;
        String c = passwordInserted;
 
        System.out.print(newline+"Employee Details : "+newline+newline);

        
        //displaying the details of the employee, if the index is not null, i.e. as deletion of a detail make that index's value null       
        for (i=0; i<arrDetails.length; i++)
        {	
            if (arrDetails[i] != null)    //if index's entry is not null, print the name of the employees in tabular form
            {
            	if(b == arrDetails[i].employeeId && c.equals(arrDetails[i].password))
    	        {
	            	
	            	System.out.println("Name : "+arrDetails[i].name);
	                System.out.println("Employee ID : "+arrDetails[i].employeeId);
	                System.out.println("Age : "+arrDetails[i].age);
	                System.out.println("Date of Birth : "+arrDetails[i].dob);
	                System.out.println("Company : "+ company);
	                System.out.println("Department : "+ arrDetails[i].department);
	                System.out.println("Salary : "+ arrDetails[i].salary);
	                System.out.println("Email : "+ arrDetails[i].email);
	                System.out.println("Password : "+ arrDetails[i].password);
	                
	                line();
	            }      	
	        }    
        }    
    }
    
    
    
    
    
    public void generateNewMail(int i)
	{
		String newline = System.lineSeparator();
        Scanner in = new Scanner(System.in);

        System.out.print(newline+"Enter the employee details : "+newline+newline);
        System.out.print("Enter the employee Name : ");
        String name = in.nextLine();
        System.out.print("Enter the employee Id : ");
        int employeeId = in.nextInt();
        System.out.print("Enter the employee Age : ");
        int age = in.nextInt();
        System.out.print("Enter the employee Date of Birth : ");
        String dob = in.next();
        System.out.print("Enter the employee Salary in Rupees : ");
        int salary = in.nextInt();
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("\nYour password is: " + this.password);
		
		// Combine elements to generate email
		email= name.toLowerCase().replaceAll("\\s", "") + "@" + department + "." + company;
		System.out.println("\nYour email is: " + this.email);
		
		//adding the input taken from user to the array of objects, using constructor
        arrDetails[i] = new EmployeeDetail (name, age, dob, employeeId, this.department, salary, this.email, this.password); 
	}
	
	
	// Ask for the department
	private String setDepartment() 
	{
		System.out.print("Enter the employee department : " + "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) { return "sales"; }
		else if(depChoice == 2) { return "dev"; }
		else if (depChoice ==3) { return "acct"; }
		else { return ""; }
	}
		
		
	// Generate a random password
	private String randomPassword(int length) 
	{
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char [] password = new char[length];
		for(int i=0; i<length; i++) 
		{
			int rand = (int) (Math.random( )* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}               
    
    
    
    
    public void addEmployeeDetails (int i)
    {
        String newline = System.lineSeparator();
        Scanner in = new Scanner(System.in);

        System.out.print(newline+"Enter the employee details : "+newline+newline);
        System.out.print("Enter the employee name : ");
        String name = in.nextLine();
        System.out.print("Enter the employee Id : ");
        int employeeId = in.nextInt();
        System.out.print("Enter the employee age : ");
        int age = in.nextInt();
        System.out.print("Enter the employee Date of Birth : ");
        String dob = in.next();
        System.out.print("Enter the employee Department : ");
        String department = in.next();
        System.out.print("Enter the employee Salary in Rupees : ");
        int salary = in.nextInt();
        System.out.print("Enter the employee Email : ");
        String email = in.next();
        System.out.print("Enter the employee Password : ");
        String password = in.next();

        System.out.println(newline+"#Employee details added successfully#"+newline);

        //adding the input taken from user to the array of objects, using constructor
        arrDetails[i] = new EmployeeDetail (name, age, dob, employeeId, department, salary, email, password);   
    }
    
    
	
        

    //delete the details of an employee
    public void deleteEmployeeDetails ()
    {
        String newline = System.lineSeparator();
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("Enter your Id: ");
        int idInserted = in.nextInt();
        System.out.println("Enter your Password: ");
        String passwordInserted = in.next();
        int b=idInserted;
        String c = passwordInserted;
        
        if(b == administratorId && c.equals(administratorPassword))
        {
        	
        	displayAllEmployee();

            System.out.print(newline+newline+"Enter your choice : ");
            choice = in.nextInt();
           
            
            if (arrDetails[choice] != null)
            {
                System.out.print(newline+arrDetails[choice].name+" details : "+newline);

                showEmployeeDetails(choice);

                System.out.print(newline+newline+"NOTE : Data of Employee "+arrDetails[choice].name+" will be deleted."+newline);
                System.out.print(newline+newline+"Are you sure you want to delete this employee details? (y/n) : ");
                char option = in.next().charAt(0);
                option = Character.toLowerCase(option);

                if (option == 'y')
                {
                    //delete the details of the employee
                    arrDetails[choice] = null;

                    //move all the elements of the array to the left, to fill the gap
                    allDetailsMoveUponDeletion(choice);

                    this.updateDetailsANS = true;
                    System.out.print(newline+"#Employee Details Deleted#"+newline);
                }

                else
                {
                    System.out.print(newline+"#Deletion cancelled#"+newline);
                    this.updateDetailsANS = false;
                }
                
                line();
            }

            else
            {
                System.out.println(newline+"#Employee with current Id don't exist, please enter a valid employee Id#"+newline);
            }	
        }
        
        else
        {
        	System.out.println(newline+"Invalid User Id and Password"+newline);
        }
    }


    
    
    //updating the details of an employee
    public void updateEmployeeDetails ()
    {
        String newline = System.lineSeparator();
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("Enter your Id: ");
        int idInserted = in.nextInt();
        System.out.println("Enter your Password: ");
        String passwordInserted = in.next();
        int b=idInserted;
        String c = passwordInserted;
        
        if(b == administratorId && c.equals(administratorPassword))
        {
        	
        	displayAllEmployee();
            
            System.out.print(newline+newline+"Enter your choice : ");
            choice = in.nextInt();

            if (arrDetails[choice] != null)
            {
                //display the details of employee whose index has been provided
                showEmployeeDetails(choice);

                System.out.print(newline+"Which detail you want to update?"+newline);
                System.out.print(newline+"1. Name");
                System.out.print(newline+"2. Age");
                System.out.print(newline+"3. Date of Birth");
                System.out.print(newline+"4. Department");
                System.out.print(newline+"5. Email");
                System.out.print(newline+"6. Cancel");

                //choose what to update
                System.out.print(newline+newline+"Enter your choice : ");
                int option = in.nextInt();
     
                switch (option)
                {
                    case 1:
                        System.out.print(newline+"Enter updated employee name : ");
                        String name = in.next();
                        arrDetails[choice].name = name;
                        System.out.print(newline+"#Employee Details Updated#");
                        break;

                    case 2:
                        System.out.print(newline+"Enter updated employee age : ");
                        int age = in.nextInt();
                        arrDetails[choice].age = age;
                        System.out.print(newline+"#Employee Details Updated#");
                        break;

                    case 3:
                        System.out.print(newline+"Enter updates employee Date of Birth : ");
                        String dob = in.next();
                        arrDetails[choice].dob = dob;
                        System.out.print(newline+"#Employee Details Updated#");
                        break;

                    case 4:
                        System.out.print(newline+"Enter updated employee department : ");
                        String department = in.next();
                        arrDetails[choice].department = department;
                        System.out.print(newline+"#Employee Details Updated#");
                        break;

                    case 5:
                        System.out.print(newline+"Enter updated employee email : ");
                        String email = in.next();
                        arrDetails[choice].email = email;
                        System.out.print(newline+"#Employee Details Updated#");
                        break;     
                                          
                    case 6:
                        System.out.print(newline+"#Update cancelled#"+newline);
                        break;
                                            
                    default:
                        System.out.print(newline+"#Invalid choice#"+newline);
                        break;
                }

            line(); 	
            }     
        }
        
        else
        {
        	System.out.println(newline+"Invalid User Id and Password"+newline);
        }       
    }


    
   
    //shift the elements of the array to the left, to fill the gap
    private void allDetailsMoveUponDeletion (int i)
    {
        for (int j = i; j < countEmployee()-i; j++)
        {
            arrDetails[j] = arrDetails[j+1];
        }     
    }

    
    //giving all the values of array as null, so that upon wrong entry in any field, the program doesn't crash
    //array is given null value using for loop, will use this in main method
    public void arrValueNullProvider ()
    {
        for (int i = 0; i < 1000; i++)
        {
            arrDetails[i] = null;
        }   
    }

    
    //the boolean value of updateDetailsANS is updated in deleteStudentDetails method, and is used here
    //this method will tell the value to user, whether the details of employee has been updated or not
    public boolean taskDeleteDetailsANS()
    {
        return updateDetailsANS;
    }


    //count the number of employees, and return the count
    private int countEmployee() 
    {
        int count = 0;

        for (int i = 0; i < 1000; i++)
        {
            if (arrDetails[i] != null)
            {
                count++;
            }  
        }
        
        return count;
    }

    
    //convert the char to lower case
    public static char toLowerCase(char ch)
    {
        if (ch >= 'A' && ch <= 'Z')
        {
            ch = (char)(ch + 'a' - 'A');
        }
        
        return ch;
    }

    
    //simple method to print line, result in better looking code and reusable code
    public void line ()
    {
        String newline = System.lineSeparator();
        System.out.println(newline+"---------------------------------------------------------------------------------"+newline);
    }   
}
            
            
           
