import java.util.*;
class College
{
    static int count001;
    Scanner sc = new Scanner(System.in);
    static String default_password = "1234";
    static int count;
    Student student[];
    int total_Students;
    int total_Courses;
    Course course[];
    void login()
    {
        
        System.out.println("Enter password for login : ");
        String login_Password = sc.nextLine();
        if(login_Password.equals(default_password))
        {
            
            int choice=1000;
            Temp :while(choice!=0)
            {
   
                            System.out.println("0 : TO EXIT!!!");
                            System.out.println("1 : Change default Password");
                            System.out.println("2 : Initialize Courses");
                            System.out.println("3 : Initialize Students");
                            System.out.println("4 : Check And List Eligible Students");
                            System.out.println("5 : Find by merit");
                            System.out.println("6 : Find by enrollment number");
                            System.out.println("7 : Find by name");
                            System.out.println("8 : Find by course");
                            System.out.println("9 : Sort by Merit");
                            System.out.println("10 : Sort by roll number");
                            System.out.println("11 : Sort by enrollment number");
                            System.out.println("12 : Edit student details");
                            System.out.println("13 : Exit from Student Management");
                            System.out.println("14 : Exit from Program");
                            System.out.println("Enter your choice below :");
                            choice = sc.nextInt();
                            sc.nextLine();
                            switch(choice)
                            {
                                // CHANGING DEFAULT PASSWORD
                                case 1 :
                                System.out.println("do you want to change default password ???");
                                String s1 = sc.nextLine();
                                if(s1.equalsIgnoreCase("yes") || s1.equalsIgnoreCase("y"))
                                {
                                    changeDefaultPassword();
                                }
                                break;

                                // ADDING COURSES
                                case 2 :
                                System.out.println("Enter total number of courses you want to enter : ");
                                while(!sc.hasNextInt())
                                {
                                    sc.next();
                                    System.out.println("Please enter integer number only!!!");
                                }
                                    total_Courses = sc.nextInt();
                                    System.out.println("====================******====================");
                                    course = new Course[total_Courses];
                                    for(int i=0;i<total_Courses;i++)
                                    {
                                        System.out.println("ENTER DETAILS FOR COURSE"+(i+1));
                                        course[i] = new Course();
                                        System.out.println("====================******====================");
                                    }
                                    sc.nextLine();
                                break;
                                //ADDING STUDENTS
                                case 3 :
                                System.out.println("Enter total number of Students :");
                                while(!sc.hasNextInt())
                                {
                                    sc.next();
                                    System.out.println("Please enter integer number only!!!");
                                }
                                total_Students = sc.nextInt();
                                System.out.println("====================******====================");
                                student = new Student[total_Students];
                                for(int i=0;i<total_Students;i++)
                                {
                                    System.out.println("ENTER DETAILS FOR STUDENT "+(i+1));
                                    student[i] = new Student();
                                    student[i].setStudentData();
                                    System.out.println("====================******====================");
                                }
                                sc.nextLine();
                                break;

                                //ELIGIBLITY OF ALL STUDENTS ENTERED
                                
                                case 4 :
                                for(int i=0;i<total_Students;i++)
                                    {
                                        for(int j=0;j<total_Courses;j++)
                                        {
                                            if(student[i].course.equals(course[j].course_Name))
                                            {
                                                if(course[j].checkEligiblity(student[i]))
                                                {
                                                    System.out.println("Student "+(i+1)+" is eligible for "+course[j].course_Name);
                                                    System.out.println("====================******====================");
                                                    course[j].total_Eligible_Students++;
                                                }
                                                else
                                                {
                                                    System.out.println("Student "+(i+1)+" is not eligible for "+course[j].course_Name);
                                                    System.out.println("====================******====================");
                                                }
                                            }
                                        }
                                    }

                                    for (int j = 0; j < total_Courses; j++) 
                                    {
                                        course[j].eligible_students = new Student[course[j].total_Eligible_Students];
                                    }
                                    
                                    for (int i = 0; i < total_Courses; i++) 
                                    {
                                        int k=0;
                                        for (int j = 0; j < total_Students; j++) 
                                        {
                                            if (student[j].course.equals(course[i].course_Name)) 
                                            {
                                                if (course[i].checkEligiblity(student[j])) 
                                                {
                                                        course[i].eligible_students[k] = student[j];
                                                        k++;
                                                }
                                            }
                                        }
                                    }

                                    for (int i = 0; i < total_Courses; i++) 
                                    {
                                        for (int j = 0; j < course[i].total_Eligible_Students; j++) 
                                        {
                                            System.out.println("DETAILS FOR STUDENTS IN "+course[i].course_Name.toUpperCase());
                                            course[i].eligible_students[j].printStudentData();
                                            System.out.println("====================******====================");
                                        }
                                    }
                                    break;
                                    
                                case 5 :
                                System.out.println("Enter the merit you want to search :");
                                while(!sc.hasNextInt())
                                {
                                    sc.next();
                                    System.out.println("Please enter integer number only!!!");
                                }
                                int merit = sc.nextInt();
                                System.out.println("====================******====================");
                                for(int i=0;i<total_Courses;i++)
                                    {
                                        for(int j=0;j<course[i].total_Eligible_Students;j++)
                                        {
                                            course[i].eligible_students[j].searchByMerit(merit);
                                            System.out.println("====================******====================");
                                        }
                                    }
                                    sc.nextLine();
                                    break;
                                case 6 :
                                    System.out.println("Enter the enrollment number you want to search :");
                                    while(!sc.hasNextLong())
                                    {
                                        sc.next();
                                        System.out.println("Please enter integral(long) number only!!!");
                                    }
                                    long enrollment_No = sc.nextLong();
                                    System.out.println("====================******====================");
                                    for(int i=0;i<total_Courses;i++)
                                        {
                                            for(int j=0;j<course[i].total_Eligible_Students;j++)
                                            {
                                                course[i].eligible_students[j].searchByEnrollment(enrollment_No);
                                                System.out.println("====================******====================");
                                            }
                                        }
                                        sc.nextLine();
                                        break;

                                case 7 :
                                    System.out.println("Enter the name you want to search :");
                                    String name = sc.nextLine();
                                    for(int i=0;i<total_Courses;i++)
                                        {
                                            for(int j=0;j<course[i].total_Eligible_Students;j++)
                                            {
                                                course[i].eligible_students[j].searchByName(name);
                                                System.out.println("====================******====================");
                                            }
                                        }
                                       
                                    break;

                                case 8 :
                                    System.out.println("Enter the course you want to search :");
                                    String search_course = sc.nextLine();
                                    for(int i=0;i<total_Courses;i++)
                                        {
                                            for(int j=0;j<course[i].total_Eligible_Students;j++)
                                            {
                                                course[i].eligible_students[j].searchByCourse(search_course);
                                                System.out.println("====================******====================");
                                            }
                                        }
                                        
                                    break;

                                case 9 :
                                for(int i=0;i<total_Courses;i++)
                                {
                                        course[i].sortByMerit(course[i]);
                                        for(int j=0;j<course[i].total_Eligible_Students;j++)
                                        { 
                                            course[i].eligible_students[j].printStudentData();  
                                            System.out.println("====================******====================");                   
                                        }
                                }
                               
                                break;
                                case 10 :
                                for(int i=0;i<total_Courses;i++)
                                {
                                        course[i].sortByRoll(course[i]);
                                        for(int j=0;j<course[i].total_Eligible_Students;j++)
                                        { 
                                            course[i].eligible_students[j].printStudentData();  
                                            System.out.println("====================******====================");                   
                                        }
                                }
                                break;
                                case 11 :
                                for(int i=0;i<total_Courses;i++)
                                {
                                        course[i].sortByEnroll(course[i]);
                                        for(int j=0;j<course[i].total_Eligible_Students;j++)
                                        { 
                                            course[i].eligible_students[j].printStudentData();       
                                            System.out.println("====================******====================");              
                                        }
                                }
                                break;
                                case 12 :
                                    Student temp = new Student();
                                    temp.editStudentData(course);
                                    sc.nextLine();
                                    break;

                                case 13:
                                break Temp;

                                case 14:
                                count001++;
                                break Temp;

                        }
                }
        
        }   
        else
        {
            if(count==3)
            {
                System.out.println("Your account is freezed and you cannot access your account for 1 hour");
                CollegeManagementSystem.temp01++;
            }
            else
            {
                System.out.println("====================******====================");
                System.out.println("Invalid Password!!!");
                System.out.println("You have "+(3-count)+" try!!!");
                count++;
                login();
            }
        }
    }

    void changeDefaultPassword()
    {
        System.out.println("Enter new Password  of 4 digit only containing integer  :");
        String new_Password = sc.nextLine();
        if(new_Password.length()== 4)
        {
            int temp_count = 0;
            for(int i=0;i<4;i++)
            {
                if(new_Password.charAt(i)=='1' ||new_Password.charAt(i)=='2'||new_Password.charAt(i)=='3'||new_Password.charAt(i)=='4'||new_Password.charAt(i)=='5'||new_Password.charAt(i)=='6'||new_Password.charAt(i)=='7'||new_Password.charAt(i)=='8'||new_Password.charAt(i)=='9'||new_Password.charAt(i)=='0')
                {
                    temp_count++;
                }
                else
                {
                    System.out.println("Enter valid password!!!");
                    changeDefaultPassword();
                }
            }
            if(temp_count == 4)
            {
                default_password = new_Password;
                System.out.println("Your default password is changed to "+default_password);
            }
            else
            {
                System.out.println("Enter valid password!!!");
                changeDefaultPassword();
            }
        }
        else
        {
            System.out.println("Enter valid password!!!");
            changeDefaultPassword();
        }
    }

    class Student
    {
        long enrollment_No;
        String name;
        int roll_No;
        String course;
        int merit;
        
        void setStudentData()
        {
            sc.nextLine();
            System.out.println("Enter Student's name :");
            name = sc.nextLine();

            System.out.println("Enter Student's merit : ");
            while(!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Please enter integral number only!!!");
            }
            merit = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student's desired course :");
            course = sc.nextLine();
            course = course.toUpperCase();

            System.out.println("Enter Student's enrollment number : ");
            while(!sc.hasNextLong())
            {
                sc.next();
                System.out.println("Please enter integral(long) number only!!!");
            }
            enrollment_No = sc.nextLong();
            sc.nextLine();
            
            System.out.println("Enter Student's roll number : ");
            roll_No = sc.nextInt();
        }
        
        void editStudentData(Course c[])
        {
            System.out.println("Enter the Student's enrollment number to edit his/her data :");
            long editStudentDataEnrollment = sc.nextLong();

           Outer : for(int i=0;i<total_Students;i++)
                {
                    for(int j=0;j<total_Courses;j++)
                    {
                        if(c[j].eligible_students[i].enrollment_No == editStudentDataEnrollment)
                        {
                            c[j].eligible_students[i].printStudentData();
                            System.out.println("Enter the data again :");
                            c[j].eligible_students[i].setStudentData();
                            break Outer;
                        }
                    }
                }
            
        }
        void printStudentData()
        {
            System.out.println("Student's name ---> "+name );
            System.out.println("Student's enrollment number ---> "+enrollment_No );
            System.out.println("Student's course ---> "+course );
            System.out.println("Student's roll number ---> "+roll_No );
        }

        void searchByMerit(int merit)
        {
            int temp_count = 0;
            if(this.merit == merit)
            {
                temp_count++;
                printStudentData();       
            }
            if(temp_count == 0)
            {
                System.out.println("No Student found");
            }
        }

        void searchByEnrollment(long enrollment_No)
        {
            int temp_count = 0;
            if(this.enrollment_No == enrollment_No)
            {
                temp_count++;
                printStudentData();       
            }
            if(temp_count == 0)
            {
                System.out.println("No Student found");
            }
        }

        void searchByName(String name)
        {
            int temp_count = 0;
            if(this.name.equalsIgnoreCase(name))
            {
                temp_count++;
                printStudentData();       
            }
            if(temp_count == 0)
            {
                System.out.println("No Student found");
            }
        }

        void searchByCourse(String course)
        {
            int temp_count = 0;
            if(this.course.equalsIgnoreCase(course))
            {
                temp_count++;
                printStudentData();       
            }
            if(temp_count == 0)
            {
                System.out.println("No Student found");
            }
        }
	}

    class Course
    {
        String course_Name;
        int cutoff;
        int total_Eligible_Students;
        Student eligible_students[] = new Student[1000];
        Course()
        {
                sc.nextLine();
                System.out.println("Enter the name of the course :");
                course_Name = sc.nextLine();
                course_Name = course_Name.toUpperCase();
                System.out.println("Enter the cutoff for "+course_Name);
                cutoff = sc.nextInt();
        }  
        
        boolean checkEligiblity(Student s)
        {
            if(s.merit<cutoff)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        void sortByMerit(Course c)
        {
            for(int i=0;i<c.total_Eligible_Students;i++)
            {
                for(int j=i;j<c.total_Eligible_Students;j++)
                {
                    if(c.eligible_students[i].merit>c.eligible_students[j].merit)
                    {
                        Student temp;
                        temp = c.eligible_students[i];
                        c.eligible_students[i] = c.eligible_students[j];
                        c.eligible_students[j] = temp;
                    }
                }
            }
        }

        void sortByRoll(Course c)
        {
            for(int i=0;i<c.total_Eligible_Students;i++)
            {
                for(int j=i;j<c.total_Eligible_Students;j++)
                {
                    if(c.eligible_students[i].roll_No>c.eligible_students[j].roll_No)
                    {
                        Student temp;
                        temp = c.eligible_students[i];
                        c.eligible_students[i] = c.eligible_students[j];
                        c.eligible_students[j] = temp;
                    }
                }
            }
        }
        
        void sortByEnroll(Course c)
        {
            for(int i=0;i<c.total_Eligible_Students;i++)
            {
                for(int j=i;j<c.total_Eligible_Students;j++)
                {
                    if(c.eligible_students[i].enrollment_No>c.eligible_students[j].enrollment_No)
                    {
                        Student temp;
                        temp = c.eligible_students[i];
                        c.eligible_students[i] = c.eligible_students[j];
                        c.eligible_students[j] = temp;
                    }
                }
            }
        }
    }
}


class CollegeManagementSystem
{
    public static int temp01 = 0;
    static double fund = 1000000.0;
    static Scanner sc = new Scanner(System.in);
    static int choice = 0;
    static final int MAX_BOOKS = 100;
    static Book[] books = new Book[MAX_BOOKS];
    static int numBooks = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
       
        College c = new College();
        int temp_choice= 1;
        int choice0 = 1;
        Outer :while(true)
        {
            System.out.println("Enter the system you want to use : \ns---> student management\nf---> fund management\nl--->library management");
            String ans = sc.nextLine();
            if(ans.equalsIgnoreCase("s"))
            {
                c.login();
                if(College.count001 == 1)
                {
                    break Outer;
                }
            }
            else if(ans.equalsIgnoreCase("f"))
            {
                if(temp01==0)
                {
                    if(temp01 == 0)
                    {
                        Outer1 :while (true)
                        {
                            System.out.println("Welcome to the College Fund Management System!");
                            System.out.println("1. View college funds");
                            System.out.println("2. Add funds");
                            System.out.println("3. Spend funds");
                            System.out.println("4. Calculate salary for a full-time faculty member");
                            System.out.println("5. Calculate salary for an adjunct faculty member");
                            System.out.println("6. Calculate salary for a visiting faculty member");
                            System.out.println("7. Exit Fund management");
                            System.out.println("8. Exit Program");
                            System.out.println("Enter your choice: ");
                        // choice1 = input.nextInt();
                            choice0 = sc.nextInt();
                            
                            switch (choice0) {
                                case 1:
                                    checkFund();
                                    break;
                                case 2:
                                    add();
                                    break;
                                case 3:
                                    remove();
                                    break;
                                
                                case 4:
                                fullTimesalary();
                                    break;
                                case 5:
                                partTimeslary();
                                    break;
                                case 6:
                                visitingSalary();
                                    break;
                                case 7:
                                sc.nextLine();
                                    break Outer1;
                                case 8:
                                break Outer; 
                        
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                    }
            
                }
            }
            else if(ans.equalsIgnoreCase("l"))
            {
                    System.out.println("Welcome to the Library Management System");
                    Outer2 :while (true) {
                        System.out.println("Please choose an option:");
                        System.out.println("1. Add a new book");
                        System.out.println("2. Search for a book");
                        System.out.println("3. Display all books");
                        System.out.println("4. Delete a book");
                        System.out.println("5. Exit Library management");
                        System.out.println("6. Exit Program");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (choice) {
                            case 1:
                                addBook();
                                break;
                            case 2:
                                searchBook();
                                break;
                            case 3:
                                displayBooks();
                                break;
                            case 4:
                            deleteBook();
                                break;
                            case 5:
                                break Outer2;
                            case 6:
                            break Outer;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                            
                        }
                    }
            }
            else
            {
                break;
            }
        }
    }
    
    public static void checkFund() {
        System.out.println("Current college funds: ₹" + fund);
    }
    

    public static void add() {
        System.out.println("Enter amount to add: ");
        double amt = sc.nextDouble();
        fund += amt;
        System.out.println("₹" + amt + " added to college funds. New balance: ₹" + fund);
    }
    

    public static void remove() {
        System.out.println("Enter amount to spend: ");
        double amt = sc.nextDouble();
        
        if (fund >= amt) 
        {
            fund -= amt;
            System.out.println("$" + amt + " spent from college funds. New balance: ₹" + fund);
        } else {
            System.out.println("Insufficient funds in college account. Current balance: ₹" + fund);
        }
    }


        static void fullTimesalary() {
        
        System.out.println("Enter base salary: ");
        double baseSalary = sc.nextDouble();
        double totalSalary = baseSalary * 1.1;
        System.out.println("Total salary with benefits: ₹" + totalSalary);
    }
    

 static void partTimeslary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of hours worked: ");
        int work = sc.nextInt();
        System.out.println("Enter hourly rate: ");
        double rate = sc.nextDouble();
        double totalSalary = work * rate;
        System.out.println("Total salary: ₹" + totalSalary);
    }
    
 static void visitingSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of days worked: ");
        int dayWorked = sc.nextInt();
        System.out.println("Enter daily rate: ");
        double dailyRate = sc.nextDouble();
        double totalSalary = dayWorked * dailyRate;
        System.out.println("Total salary: ₹" + totalSalary);
    }
    static void addBook() {
        if (numBooks == MAX_BOOKS) {
            System.out.println("Sorry, the library is full.");
            return;
        }
        System.out.println("Please enter the title of the book:");
        String title = scanner.nextLine();
        System.out.println("Please enter the author of the book:");
        String author = scanner.nextLine();
        System.out.println("Please enter the year of publication of the book:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        books[numBooks++] = new Book(title, author, year);
        System.out.println("Book added successfully.");
    }
    
    static void searchBook() {
        System.out.println("Please enter the title or author of the book:");
        String query = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(query) || books[i].getAuthor().equalsIgnoreCase(query)) {
                books[i].printBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no books found.");
        }
    }
    
    static void displayBooks() {
        if (numBooks == 0) {
            System.out.println("Sorry, no books in the library.");
            return;
        }
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Details of book"+(i+1));
            books[i].printBook();
        }
    }
	
	static void deleteBook() {
        System.out.println("Please enter the title or author of the book to be deleted:");
        String query = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(query) || books[i].getAuthor().equalsIgnoreCase(query)) {
                found = true;
                for(int j = i; j < numBooks - 1; j++) {
                    books[j] = books[j+1];
                }
                books[numBooks-1] = null;
                numBooks--;
                System.out.println("Book deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Sorry, no books found.");
        }
    }
}
class Book {
    String title;
    String author;
    int year;
    
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    public void printBook()
    {
        System.out.println("Title = "+title);
        System.out.println("Author = "+author);
        System.out.println("Year = "+year);
}
}
