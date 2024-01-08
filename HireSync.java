import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Final {
    Scanner sc = new Scanner(System.in);

    static Connection con = null;
    static PreparedStatement pst = null;

    public static void main(String[] args) throws Exception {
        // System.out.println("\u001B[3m");
        // System.out.println("\u001B[32m");
        Scanner sc = new Scanner(System.in);
        String dburl = "jdbc:mysql://localhost:3306/project1";
        String dbuser = "root";
        String dbpass = "";
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        con = DriverManager.getConnection(dburl, dbuser, dbpass);

        if (con != null) {
            System.out.println("Connection successfull");
        } else {
            System.out.println("Connection failed");
        }
        boolean f = true;
        String c = "";
        while (f) {
            System.out.println("Are you are ");
            System.out.println("1. Recurter");
            System.out.println("2. Job seeker");
            System.out.println("3. Exit");
            c = sc.nextLine();
            // sc.nextLine();
            switch (c) {
                case "1":
                    recruiter();
                    break;
                case "2":
                    jobseeker();
                    break;
                case "3":
                    System.out.println("Thank you");
                    f = false;
                    break;
                default:
                    System.out.println("Enter valid input");
            }
        }
    }

    public static void jobseeker() throws Exception {
        Scanner sc = new Scanner(System.in);
        String c = "";
        boolean f = true;
        while (f) {
            System.out.println("1. Create a account");
            System.out.println("2. Login ");
            System.out.println("3. Exit");
            c = sc.nextLine();
            // sc.nextLine();
            switch (c) {
                case "1":
                    signup();
                    break;
                case "2":
                    if (login()) {
                        forjob();
                    }
                    break;
                case "3":
                    System.out.println("Thank you");
                    f = false;
                    break;
            }
        }
    }

    public static void signup() throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean flag = true;
            System.out.println();
            System.out.print("Enter Your Name : ");
            String name = sc.nextLine();
            String email = "";
            System.out.println();
            while (true) {
                System.out.println("Enter Email : ");
                email = sc.next();
                String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
                // String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    break;
                } else {
                    System.out.println("   Enter Valid Email");
                }
            }

            System.out.println();
            System.out.print("Enter Your mobile Number : ");
            String mobile = "";
            sc.nextLine();
            while (true) {
                System.out.print("Enter Mobile Number(starts between 7-9): ");
                mobile = sc.next();
                if (mobile.matches("[987]\\d{9}")) {
                    break;
                } else {
                    System.out.println("  Enter Valid Number!!  ");
                }
            }
            try {
                verified();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Set Password");
            String psdw = sc.nextLine();
            String sql1 = "insert into data values('" + name + "','" + email + "','" + mobile + "','" + psdw + "')";
            pst = con.prepareStatement(sql1);
            int r1 = pst.executeUpdate();
            if (r1 > 0) {
                System.out.println("Inserted");
                break;
            } else {
                System.out.println("Entered mailID or Number already Exist");
            }
        }
    }

    public static boolean login() throws Exception {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        while (c != 1) {
            String sql = "select pswd  from data where name = ?";
            System.out.println("Enter Username");
            String name1 = sc.nextLine();
            pst = con.prepareStatement(sql);
            pst.setString(1, name1);
            ResultSet rs = pst.executeQuery();
            String check = "";
            while (rs.next()) {
                check = rs.getString("pswd");
            }
            System.out.println("Enter your password");
            String pswd1 = sc.nextLine();
            if (check.equals(pswd1)) {
                System.out.println("Successfuly Logedin");
                ar.add(name1);
                return true;
            }

            else {
                System.out.println("Wrong Username or password");
            }
            System.out.println("Type 1 for exit");

        }

        return false;

    }

    public static void recruiter() throws Exception {
        Scanner sc = new Scanner(System.in);
        String c = "";
        boolean f = true;
        while (f) {
            System.out.println("1. Create account as Recurter");
            System.out.println("2. Login as Recurter");
            c = sc.nextLine();
            switch (c) {
                case "1":
                    createacc();
                    break;
                case "2":
                    if (loginacc()) {
                        boolean f1 = true;
                        String c2 = "";
                        while (f1) {
                            System.out.println("1. View job application");
                            System.out.println("2. Add new Oppening's");
                            System.out.println("3. Update new Oppening's");
                            System.out.println("4. Delete new Oppening's");
                            System.out.println("5. Resume Detail's");

                            System.out.println("6. Display");
                            System.out.println("7. Exit");
                            c2 = sc.nextLine();
                            String position = "";
                            switch (c2) {
                                case "1":
                                    checkapplicant();
                                    break;
                                case "2":
                                    addnewopenning();
                                    break;
                                case "3":
                                    update();
                                    break;
                                case "4":
                                    delete();
                                    break;
                                case "5":
                                    printresume();
                                    break;
                                case "6":
                                    display();
                                    break;
                                case "7":
                                    System.out.println("Thank you");

                                    f1 = false;
                                    break;

                            }

                        }
                    }
                case "3":
                    System.out.println("Thank you");
                    f = false;
                    break;
                default:
                    System.out.println("Enter valid input");

            }
        }

    }

    public static void createacc() throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            System.out.println();
            System.out.print("Enter Your Name : ");
            String name = sc.nextLine();
            String email = "";
            System.out.println();
            while (true) {
                System.out.println("Enter Email : ");
                email = sc.next();
                String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
                // String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    break;
                } else {
                    System.out.println("   Enter Valid Email");
                }
            }
            sc.nextLine();
            System.out.println();
            System.out.print("Enter Your mobile Number : ");
            String mobile = "";
            while (true) {
                System.out.print("Enter Mobile Number(starts between 7-9): ");
                mobile = sc.next();
                if (mobile.matches("[987]\\d{9}")) {
                    break;
                } else {
                    System.out.println("  Enter Valid Number!!  ");
                }
            }
            try {
                verified();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Set Password");
            String psdw = sc.nextLine();
            String sql1 = "insert into Recruterdata values('" + name + "','" + email + "','" + mobile + "','" + psdw
                    + "')";
            pst = con.prepareStatement(sql1);
            int r1 = pst.executeUpdate();
            if (r1 > 0) {
                System.out.println("Inserted");
                break;
            } else {
                System.out.println("Email or number already exist");
            }
        }
    }

    public static void verified() throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean f = true;
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("Sending OTP To Your Device....");
        while (f) {

            Thread.sleep(2000);
            System.out.println();
            int r = (int) (Math.random() * 10000);
            System.out.println("OTP Received On Your Phone : " + r);
            System.out.println();
            System.out.print("Enter Your OTP : ");
            int r1 = sc.nextInt();
            sc.nextLine();
            if (r1 == r) {
                System.out.println();
                System.out.println("-------------------- VERIFIED ----------------------");
                System.out.println();
                f = false;
            } else {
                System.out.println();
                System.out.println("----------------------------------------------------");
                System.out.println();
                System.out.println("Entered OTP Is Wrong!");
                System.out.println();
                System.out.println("Re-sending the OTP...");
            }
        }

    }

    public static boolean loginacc() throws Exception {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        while (c != 1) {
            String sql = "select pswd  from recruterdata where name = ?";
            System.out.println("Enter Username");
            String name1 = sc.nextLine();
            pst = con.prepareStatement(sql);
            pst.setString(1, name1);
            ResultSet rs = pst.executeQuery();
            String check = "";
            while (rs.next()) {
                check = rs.getString("pswd");
            }
            System.out.println("Enter your password");
            String pswd1 = sc.nextLine();
            if (check.equals(pswd1)) {
                System.out.println("Successfuly Logedin");
                return true;
            }

            else {
                System.out.println("Wrong Username or password");
            }
            System.out.println("Type 1 for exit");

        }

        return false;

    }

    public static void printresume() throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!flag1) {
            String sql = "select * from forprofile where Name = ?";

            pst = con.prepareStatement(sql);
            String s = ar.get(0);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            boolean x = true;
            while (rs.next()) {
                x = false;
                System.out.println();
                System.out.println("Enter the FileName");
                String nam = sc.nextLine();
                System.out.println();
                Blob b = rs.getBlob(4);
                byte arr[] = b.getBytes(1, (int) b.length());
                String fname = "D://All_Project//" + nam + ".txt";
                FileOutputStream fos = new FileOutputStream(fname);
                fos.write(arr);
                fos.close();
                System.out.println("Resume has been downloaded");
                break;
            }
            if (x) {
                System.out.println("Resume Doesn't exist");
            }
        } else {
            System.out.println("no resume's are there");
        }

    }

    public static void checkapplicant() throws Exception {
        if (!flag1) {
            String n = ar.get(0);
            System.out.println("Person's detail");
            String sql1 = "select * from forprofile where name = ?";
            pst = con.prepareStatement(sql1);

            pst.setString(1, n);
            ResultSet rs1 = pst.executeQuery();
            // System.out.println(rs1);
            boolean y = true;
            while (rs1.next()) {
                y = false;
                System.out.println("--------------------------------------------------------------");
                System.out.println("|  Name    " + rs1.getString(1) + "                 |");
                System.out.println("|  Mail ID " + rs1.getString(2) + "                 |");
                System.out.println("|  Number  " + rs1.getString(3) + "                 |");
                System.out.println("|  Resume   " + rs1.getBlob(4) + "                  |");
                System.out.println("-------------------------------------------------------------");

            }
            if (y) {

            }
            System.out.println("Profile Doesn't Exist");
        } else {
            System.out.println("no applicant resume is there");
        }

    }

    static ArrayList<String> ar = new ArrayList<>();
    static HashMap<Integer, detail> m = new HashMap<>();
    static boolean flag1 = true;

    public static void jobappication(String name) throws Exception {
        // if (f) {
        if (!flag1) {
            String sql = "select * from recruter where position = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            String n = ar.get(0);
            ResultSet rs = pst.executeQuery();
            boolean x = true;
            while (rs.next()) {
                x = false;
                System.out.println("------------------------------------------------------------------");
                System.out.println("|  Company  " + rs.getString(1) + "                 |");
                System.out.println("|  Position " + rs.getString(2) + "                 |");
                System.out.println("|  Location " + rs.getString(3) + "                 |");
                System.out.println("|  Type     " + rs.getString(4) + "                 |");
                System.out.println("|  Salary   " + rs.getLong(5) + "                   |");
                System.out.println("------------------------------------------------------------------");
            }
            if (x) {
                System.out.println(" No such application's are there ");
            }
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Person's detail");
            String sql1 = "select * from forprofile where name = ?";
            pst = con.prepareStatement(sql1);

            pst.setString(1, n);
            ResultSet rs1 = pst.executeQuery();
            // System.out.println(rs1);
            boolean y = true;
            while (rs1.next()) {
                y = false;
                System.out.println("--------------------------------------------------------------");
                System.out.println("|  Name    " + rs1.getString(1) + "                 |");
                System.out.println("|  Mail ID " + rs1.getString(2) + "                 |");
                System.out.println("|  Number  " + rs1.getString(3) + "                 |");
                System.out.println("|  Resume   " + rs1.getBlob(4) + "                  |");
                System.out.println("-------------------------------------------------------------");

            }
            if (y) {

                System.out.println("Profile Doesn't Exist");
            }
        } else {
            System.out.println("no application's are there!!!");
        }
    }

    public static void update() throws Exception {
        Scanner sc = new Scanner(System.in);

        String sql = "update recruter set position = ? , type = ? , salary = ? , location  = ? where c_name = ?";

        System.out.println("Enter the Company name to Change");
        String name = sc.nextLine();
        System.out.println("Enter the New Position");
        String position = sc.nextLine();
        System.out.println("Enter the new Type");
        String type = sc.nextLine();
        System.out.println("Enter the new Salary");
        long salary = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the new Location");
        String location = sc.nextLine();
        pst = con.prepareStatement(sql);
        pst.setString(1, position);
        pst.setString(2, type);
        pst.setLong(3, salary);
        pst.setString(4, location);
        pst.setString(5, name);
        int r = pst.executeUpdate();
        if (r > 0) {
            System.out.println("Successfull");
        } else {
            System.out.println("Unsuccessfull");
        }

    }

    public static void delete() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Company name which you have to delete");
        String cname = sc.nextLine();
        System.out.println("Enter the position");
        String p = sc.nextLine();
        String sql = "delete from recruter where c_name =  ? AND position = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, cname);
        pst.setString(2, p);
        int r = pst.executeUpdate();
        if (r > 0) {
            System.out.println("Successfull");
        } else {
            System.out.println("Unsuccessfull");
        }

    }

    public static void display() throws Exception {
        String sql = "select * from recruter";
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("|\t\t  Company  " + rs.getString(1) + "              |");
            System.out.println("|\t\t  Position " + rs.getString(2) + "              |");
            System.out.println("|\t\t  Location " + rs.getString(3) + "              |");
            System.out.println("|\t\t  Type     " + rs.getString(4) + "              |");
            System.out.println("|\t\t  Salary   " + rs.getLong(5) + "              |");
            System.out.println("-------------------------------------------------------------");
        }
    }

    public static void addnewopenning() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Company name");
        String name = sc.nextLine();
        System.out.println("Enter the position");
        String position = sc.nextLine();
        System.out.println("Enter the location");
        String location = sc.nextLine();
        System.out.println("Enter the Type");
        String type = sc.nextLine();
        System.out.println("Enter the salary");
        long salary = sc.nextLong();
        detail d = new detail(name, position, location, type, salary);
        String sql = "insert into recruter values('" + name + "','" + position + "','" + location + "','" + type + "',"
                + salary + ")";
        pst = con.prepareStatement(sql);
        int r1 = pst.executeUpdate();
        if (r1 > 0) {
            System.out.println("successfull");
        } else {
            System.out.println("unsuccessfull");
        }

        m.put(id, d);
    }

    public static void forjob() throws Exception {
        Scanner sc = new Scanner(System.in);

        String c2 = "";
        boolean f = true;
        while (f) {
            System.out.println("1. Create your Job profile");
            System.out.println("2. View Jobs");
            System.out.println("3. Exit");
            c2 = sc.nextLine();

            switch (c2) {
                case "1":
                    createprofile();
                    break;
                case "2":
                    viewjobs();
                    break;
                case "3":
                    System.out.println("Thank you");
                    f = false;
                    break;

            }

        }
    }

    public static void createprofile() throws Exception {
        Scanner sc = new Scanner(System.in);
        String sql = "insert into  forprofile values (?,?,?,?)";
        pst = con.prepareStatement(sql);
        System.out.println("Enter Your Resume's name");
        String path = sc.nextLine();
        File f = new File("D://RP//" + path + ".txt");
        boolean flag = true;
        System.out.println();
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        String email = "";
        System.out.println();
        while (true) {
            System.out.println("Enter Email : ");
            email = sc.next();
            String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
            // String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("   Enter Valid Email");
            }
        }
        System.out.println();
        System.out.print("Enter Your mobile Number : ");
        String mobile = "";
        while (true) {
            System.out.print("Enter Mobile Number(starts between 7-9): ");
            mobile = sc.next();
            if (mobile.matches("[987]\\d{9}")) {
                break;
            } else {
                System.out.println("  Enter Valid Number!!  ");
            }
        }
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, mobile);
        FileInputStream fis = new FileInputStream(f);
        pst.setBinaryStream(4, fis, f.length());
        int res = pst.executeUpdate();
        if (res > 0) {
            System.out.println("Binary File storage success");
        } else {
            System.out.println("Binary File Storage Failed");
        }

    }

    public static void viewjobs() throws Exception {
        Scanner sc = new Scanner(System.in);
        String c = "";
        while (!c.equalsIgnoreCase("NO")) {
            display();
            System.out.println("Enter the Position that you are looking for");
            String pos = sc.nextLine();
            System.out.println("Enter the Name of the Company");
            String cname = sc.nextLine();
            String sql = "select * from recruter where position = ? AND c_name = ?";
            pst = con.prepareStatement(sql);
            try {
                pst.setString(1, pos);
                pst.setString(2, cname);

            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            ResultSet rs2 = pst.executeQuery();
            if (rs2.next()) {
                System.out.println();
                System.out.println("Resume has been sent to the Recruter!!");
                System.out.println();
                flag1 = false;

                jobappication(pos);
                break;
            } else {
                System.out.println("Position or Company Doesn't Exist");
            }
            System.out.println("Want to continue YES / NO");
            c = sc.nextLine();

        }
    }
}

class detail {
    String name, position, locaiton, type;
    long salary;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public String getType() {
        return type;
    }

    public long getSalary() {
        return salary;
    }

    detail(String name, String position, String locaition, String type, long salary) {
        this.name = name;
        this.position = position;
        this.locaiton = locaition;
        this.type = type;
        this.salary = salary;
    }

}
