import java.util.Scanner;

 class StudyAbroadGuide {
   static String country;
   
    public static void main(String[] args) {
        String p = "";
        String p1 = "";
        String p2 = "";
        String p3 = "";
        Scanner sc = new Scanner(System.in);
        int cho  = 5;
        System.out.println("Welcome to the Study Abroad Guide!");
        System.out.println("Please enter the name of the country you want to study in:");
         country = sc.nextLine();
         
       
      while(cho > 4 ){
        System.out.println("Enter the name of the Exam the you have Given ");
        System.out.println("1. IELTS");
        System.out.println("2. GRE");
        System.out.println("3. SAT");
        System.out.println("4. TOFFEL");
        cho = sc.nextInt();
        switch(cho){
            case 1: 
            System.out.println("IELTS");
             p = "IELTS";
            break;
            case 2: 
            System.out.println("GRE");
            p1 = "GRE";
            break;
            case 3: 
            System.out.println("SAT");
             p2 = "SAT";
            break;
            case 4: 
            System.out.println("TOFFEL");
            p3 = "TOFFEL";
            break;
           
            default :
            System.out.println("Invalid Exam ");
            break;
        }
        
        
      }
      Boolean b = true;
      while(b){
        System.out.println("Enter the Score of the Exam ");
    Double score = sc.nextDouble();
    if((p).equalsIgnoreCase("IELTS") && score <=9){
        b = false;
    }
  else   if((p1).equalsIgnoreCase("GRE") && score <=340){
    b = false;
    }
  else  if((p2).equalsIgnoreCase("SAT")&& score <= 1600){
    b = false;
    }
    else if((p3).equalsIgnoreCase("TOFFEL")&& score <= 120){
        b = false;
    }
    else{
        System.out.println("Enter valid Score");
    }

    }
    
        Countries c = new Countries();
        if(country.equalsIgnoreCase("USA")){
        c.USA(); 
        } 
        else if(country.equalsIgnoreCase("UK")){
            c.UK();
        }

    
    }
}
class Countries{
    static  Scanner sc = new Scanner(System.in);
      void USA(){
        Boolean t = true;
        String STEM = "";
      
            System.out.println("Enter the course that you are looking for ");
             String course = sc.nextLine();
             while(t){
            System.out.println("Is your course is STEM Affiliated ");
            
             STEM = sc.nextLine();
        if(STEM.equalsIgnoreCase("yes") ){
            System.out.println("*********************************");
            System.out.println("Here are the list of the Universities including the course that you are looking for : ");
            System.out.println("1.  Harvard University Cambridge, MA ");
            System.out.println("2. Stanford University Stanford, CA");
            System.out.println("3. Princeton University Princeton, NJ");
            System.out.println("4. Yale University New Haven, CT");
            System.out.println("5. Williams College");
            System.out.println(" 6. Pomona College");
            System.out.println("7. Brown University");
            System.out.println(" 8. 	Swarthmore College");
            System.out.println(" 9. Amherst College");
            System.out.println("10. Massachusetts Institute of Technology");
            System.out.println("*********************************");
            t= false;
        }
       else  if(STEM.equalsIgnoreCase("no")) {
        System.out.println("*********************************");
            System.out.println("Here are the list of the Universities including the course that you are looking for : ");
            System.out.println("1.  University of California, Berkeley ");
            System.out.println("2. 	Middlebury College");
            System.out.println("3. California Institute of Technology");
            System.out.println("4. 	Washington and Lee University");
            System.out.println(" 5. Rice University");
            System.out.println(" 6. University of Chicago");
            System.out.println("7. University of California, Los Angeles");
            System.out.println(" 8. 	College of William & Mary");
            System.out.println(" 9. University of Michigan, Ann Arbo");
            System.out.println("10. Vanderbilt University");
            System.out.println("*********************************");
            t= false;
        }
        else{
            System.out.println("Enter Valid Input ");    
            }
        }
        
        int choice = 0;
        while (choice != 5){
            System.out.println("*********************************");
            System.out.println("You can also view more information about the University ");
            System.out.println("1. Ranking ");
            System.out.println("2. Accomodation ");
            System.out.println("3. On/off campus jobs");
            System.out.println("4. Scholarships Program");
            System.out.println("5. Quit");
            System.out.println("Enter your choice: ");
            System.out.println("*********************************");

            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    Ranking();
                    break;
                case 2:
                    Acmd();
                    break;
                case 3:
                    jobs();
                    break;
                
                 case 4:
                 Scholarships();
                    break;
                case 5:
                    System.out.println("Thank you for using the System");
                    break;
           
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
     }
    static void Ranking(){
        System.out.println("*********************************");
        System.out.println(" Rank 1 -   Harvard University Cambridge, MA ");
            System.out.println("Rank 2 - Stanford University Stanford, CA");
            System.out.println("Rank 3 -  Princeton University Princeton, NJ");
            System.out.println("Rank 4 -  Yale University New Haven, CT");
            System.out.println("Rank 5 -  Williams College");
            System.out.println(" Rank 15 - Pomona College");
            System.out.println("Rank  19 - Brown University");
            System.out.println("Rank  24 - Swarthmore College");
            System.out.println(" Rank 26 -  Amherst College");
            System.out.println("Rank 29 -  Massachusetts Institute of Technology");
            System.out.println("Rank 56  University of California, Berkeley ");
            System.out.println("Rank 72 	Middlebury College");
            System.out.println("Rank 110 California Institute of Technology");
            System.out.println(" Rank 129 - 	Washington and Lee University");
            System.out.println(" Rank 137 - Rice University");
            System.out.println(" Rank  145 -  University of Chicago");
            System.out.println("Rank 154 -  University of California, Los Angeles");
            System.out.println(" Rank 169 -  College of William & Mary");
            System.out.println(" Rank 189 -  University of Michigan, Ann Arbo");
            System.out.println("Rank 201 -  Vanderbilt University");
            System.out.println("*********************************");

    }
    static void Acmd(){
        System.out.println("Here are the best  contact for you ");
        System.out.println("1. Michael - +17542891345");
        System.out.println("2. Thomas - +13259874561 ");
        System.out.println("3. Richard - +1249874561");
    }
   static void jobs(){
         int c= 11;
      while(c > 10){
        System.out.println("Enter The respective number to know  about the job roles ");
        System.out.println("1. Campus ambassador");
        System.out.println("2. Barista");
        System.out.println("3. Teaching assistant");
        System.out.println("4. Library assistant");
        System.out.println("5. Receptionist");
        System.out.println("6. Research stu`dy assistant");
        System.out.println("7. Department assistant ");
        System.out.println("8. Food runner or catering assistant");
        System.out.println("9. Sales assistant");
        System.out.println("10. Tutor or peer mentor");
        c = sc.nextInt();
        switch(c){
            case 1: 
            System.out.println("Campus ambassadors are in charge of promoting the university and showing prospective students why they should apply. This is a great job for someone who likes interacting with new people and working in a team.");
            System.out.println("Average wage: $10.94 per hour");
            break;
            case 2: 
            System.out.println("If your university has an on-campus cafe, this can be a great place to work.Not only will you benefit from discounted (or even free!) coffee, but it is also a great place to meet new people");
             System.out.println("Average wage: $11.59 per hour");
           
            break;
            case 3: 
            System.out.println("An on-campus teaching assistant is expected to supervise classroom activities and work closely with any students who are struggling.");
             System.out.println("Average wage: $11.85 per hour");
            
            break;
            case 4:
            System.out.println("Working as a library assistant is a varied job, perfect for those hoping to study and work in the USA simultaneously.You will be responsible for shelving books, helping customers find books and other materials and making recommendations of useful books."); 
            System.out.println("Average wage: $13.24 per hour");
            break;
            case 5: 
            System.out.println("The duties of a university receptionist might include general office support and administration,customer service and communicating with students and staff via phone and emails.");
             System.out.println("Average wage: $13.31 per hour");
            
            break;
            case 6: 
            System.out.println("");
            System.out.println("    A research study assistant is one of the most well paid part-time jobs for international students on-campus.What the job entails will depend on which department you work for,but expect to work on various projects, carry out research, maintain lab equipment and collate results.");
              System.out.println("Average wage: $15.48");
            
            break;
            case 7: 
            System.out.println("A department assistant is one of the best on-campus jobs in the USA for international students,and you will gain lots of transferable skills for your CV");
            System.out.println("Average wage: $16.44");
            break;
            case 8: 
            System.out.println("Alternatively, if your university has cafes, restaurants or other dining facilities on-site that offer food to eat-in,  you may be able to find work as a front of house assistant or runner.");
            System.out.println("Average wage: $16.81 per hour");
            
            break;
            case 9: 
            System.out.println("If your university has a mini supermarket or corner shop on-campus, this is another great way to make some money alongside your studies.");
             System.out.println("Average wage: $20.00 per hour");
            
            break;
            case 10: 
            System.out.println("If you don't fancy becoming a teaching assistant, but would like to do something along the same lines,  tutoring or peer mentoring is a great job for international students working in the USA.");
            System.out.println("Average wage: $21.31 per hour");
            
            break;
           
            default :
            System.out.println("Please select valid Scholarship ");
            break;
        }
    }
 }
 static void Scholarships(){
    int c1= 9;
      while(c1 > 8){
        System.out.println("Enter The respective number to know  Grants of the Scholarship ");
        System.out.println("1. Inlaks Shivdasani Foundation Scholarship");
        System.out.println("2. Fullbright - Nehru Research Scholarship");
        System.out.println("3. The Hubert H.Humphrey Fellowship Programme");
        System.out.println("4. Stanford Reliance Dhirubhai fellowship fr Indian Students");
        System.out.println("5. The Indian trust Fellowship");
        System.out.println("6. Tata Scholarship for Cornell UNiversity ");
        System.out.println("7. Rotary Foundation Ambassadorial Scholarship");
        System.out.println("8. Akhtarali H. Taboccowala Fellowship");
        c1 = sc.nextInt();
        switch(c1){
            case 1: 
            System.out.println("USD 100,000(INR 80Lakhs)");
            
            break;
            case 2: 
            System.out.println("The Scholarship pays for all associated costs including tution , room and board , a stipend and air travel.");
             
           
            break;
            case 3: 
            System.out.println("VAriable amount approx.  INR 10 lakhs");
            
            
            break;
            case 4:
            System.out.println("USD 1,50,000 (INR 1.95 Cr) on the MBA tution fees"); 
            
            break;
            case 5: 
            System.out.println("USA 10,000 (INR 7 lakhs)");             
            
            break;
            case 6: 
            System.out.println("Vsriable amount approx ( INR 15 lakhs)");
            
            break;
            case 7: 
            System.out.println("USA 15,000 -30,000 (INR 11 - 23 lakhs)");
            break;
            case 8: 
            System.out.println("USD 25,000 (INR 19 Lakhs)");
             break;
         
             default :
            System.out.println("Please select valid Scholarship ");
            break;
            }
        }
    }
    void UK(){
        Boolean t = true;
        String STEM = "";
      
            System.out.println("Enter the course that you are looking for ");
             String course = sc.nextLine();
             while(t){
            System.out.println("Is your course is STEM Affiliated ");
            
             STEM = sc.nextLine();
        if(STEM.equalsIgnoreCase("yes") ){
            System.out.println("*********************************");
            System.out.println("Here are the list of the Universities including the course that you are looking for : ");
            System.out.println("1.  Harvard University Cambridge, MA ");
            System.out.println("2. Stanford University Stanford, CA");
            System.out.println("3. Princeton University Princeton, NJ");
            System.out.println("4. Yale University New Haven, CT");
            System.out.println("5. Williams College");
            System.out.println(" 6. Pomona College");
            System.out.println("7. Brown University");
            System.out.println(" 8. 	Swarthmore College");
            System.out.println(" 9. Amherst College");
            System.out.println("10. Massachusetts Institute of Technology");
            System.out.println("*********************************");
            t= false;
        }
       else  if(STEM.equalsIgnoreCase("no")) {
        System.out.println("*********************************");
            System.out.println("Here are the list of the Universities including the course that you are looking for : ");
            System.out.println("1.  University of California, Berkeley ");
            System.out.println("2. 	Middlebury College");
            System.out.println("3. California Institute of Technology");
            System.out.println("4. 	Washington and Lee University");
            System.out.println(" 5. Rice University");
            System.out.println(" 6. University of Chicago");
            System.out.println("7. University of California, Los Angeles");
            System.out.println(" 8. 	College of William & Mary");
            System.out.println(" 9. University of Michigan, Ann Arbo");
            System.out.println("10. Vanderbilt University");
            System.out.println("*********************************");
            t= false;
        }
        else{
            System.out.println("Enter Valid Input ");    
            }
        }
        
        int choice = 0;
        while (choice != 5){
            System.out.println("*********************************");
            System.out.println("You can also view more information about the University ");
            System.out.println("1. Ranking ");
            System.out.println("2. Accomodation ");
            System.out.println("3. On/off campus jobs");
            System.out.println("4. Scholarships Program");
            System.out.println("5. Quit");
            System.out.println("Enter your choice: ");
            System.out.println("*********************************");

            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    ukRanking();
                    break;
                case 2:
                    ukAcmd();
                    break;
                case 3:
                    ukjobs();
                    break;
                
                 case 4:
                 ukScholarships();
                    break;
                case 5:
                    System.out.println("Thank you for using the System");
                    break;
           
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
     }
    static void ukRanking(){
        System.out.println("*********************************");
        System.out.println(" Rank 1 -   Harvard University Cambridge, MA ");
            System.out.println("Rank 2 - Stanford University Stanford, CA");
            System.out.println("Rank 3 -  Princeton University Princeton, NJ");
            System.out.println("Rank 4 -  Yale University New Haven, CT");
            System.out.println("Rank 5 -  Williams College");
            System.out.println(" Rank 15 - Pomona College");
            System.out.println("Rank  19 - Brown University");
            System.out.println("Rank  24 - Swarthmore College");
            System.out.println(" Rank 26 -  Amherst College");
            System.out.println("Rank 29 -  Massachusetts Institute of Technology");
            System.out.println("Rank 56  University of California, Berkeley ");
            System.out.println("Rank 72 	Middlebury College");
            System.out.println("Rank 110 California Institute of Technology");
            System.out.println(" Rank 129 - 	Washington and Lee University");
            System.out.println(" Rank 137 - Rice University");
            System.out.println(" Rank  145 -  University of Chicago");
            System.out.println("Rank 154 -  University of California, Los Angeles");
            System.out.println(" Rank 169 -  College of William & Mary");
            System.out.println(" Rank 189 -  University of Michigan, Ann Arbo");
            System.out.println("Rank 201 -  Vanderbilt University");
            System.out.println("*********************************");

    }
    static void ukAcmd(){
        System.out.println("Here are the best  contact for you ");
        System.out.println("1. Michael - +17542891345");
        System.out.println("2. Thomas - +13259874561 ");
        System.out.println("3. Richard - +1249874561");
    }
   static void ukjobs(){
         int c= 11;
      while(c > 10){
        System.out.println("Enter The respective number to know  about the job roles ");
        System.out.println("1. Campus ambassador");
        System.out.println("2. Barista");
        System.out.println("3. Teaching assistant");
        System.out.println("4. Library assistant");
        System.out.println("5. Receptionist");
        System.out.println("6. Research study assistant");
        System.out.println("7. Department assistant ");
        System.out.println("8. Food runner or catering assistant");
        System.out.println("9. Sales assistant");
        System.out.println("10. Tutor or peer mentor");
        c = sc.nextInt();
        switch(c){
            case 1: 
            System.out.println("Campus ambassadors are in charge of promoting the university and showing prospective students why they should apply. This is a great job for someone who likes interacting with new people and working in a team.");
            System.out.println("Average wage: $10.94 per hour");
            break;
            case 2: 
            System.out.println("If your university has an on-campus cafe, this can be a great place to work.Not only will you benefit from discounted (or even free!) coffee, but it is also a great place to meet new people");
             System.out.println("Average wage: $11.59 per hour");
           
            break;
            case 3: 
            System.out.println("An on-campus teaching assistant is expected to supervise classroom activities and work closely with any students who are struggling.");
             System.out.println("Average wage: $11.85 per hour");
            
            break;
            case 4:
            System.out.println("Working as a library assistant is a varied job, perfect for those hoping to study and work in the USA simultaneously.You will be responsible for shelving books, helping customers find books and other materials and making recommendations of useful books."); 
            System.out.println("Average wage: $13.24 per hour");
            break;
            case 5: 
            System.out.println("The duties of a university receptionist might include general office support and administration,customer service and communicating with students and staff via phone and emails.");
             System.out.println("Average wage: $13.31 per hour");
            
            break;
            case 6: 
            System.out.println("");
            System.out.println("    A research study assistant is one of the most well paid part-time jobs for international students on-campus.What the job entails will depend on which department you work for,but expect to work on various projects, carry out research, maintain lab equipment and collate results.");
              System.out.println("Average wage: $15.48");
            
            break;
            case 7: 
            System.out.println("A department assistant is one of the best on-campus jobs in the USA for international students,and you will gain lots of transferable skills for your CV");
            System.out.println("Average wage: $16.44");
            break;
            case 8: 
            System.out.println("Alternatively, if your university has cafes, restaurants or other dining facilities on-site that offer food to eat-in,  you may be able to find work as a front of house assistant or runner.");
            System.out.println("Average wage: $16.81 per hour");
            
            break;
            case 9: 
            System.out.println("If your university has a mini supermarket or corner shop on-campus, this is another great way to make some money alongside your studies.");
             System.out.println("Average wage: $20.00 per hour");
            
            break;
            case 10: 
            System.out.println("If you don’t fancy becoming a teaching assistant, but would like to do something along the same lines,  tutoring or peer mentoring is a great job for international students working in the USA.");
            System.out.println("Average wage: $21.31 per hour");
            
            break;
           
            default :
            System.out.println("Please select valid Scholarship ");
            break;
        }
    }
 }
 static void ukScholarships(){
    int c1= 9;
      while(c1 > 8){
        System.out.println("Enter The respective number to know  Grants of the Scholarship ");
        System.out.println("1. Inlaks Shivdasani Foundation Scholarship");
        System.out.println("2. Fullbright - Nehru Research Scholarship");
        System.out.println("3. The Hubert H.Humphrey Fellowship Programme");
        System.out.println("4. Stanford Reliance Dhirubhai fellowship fr Indian Students");
        System.out.println("5. The Indian trust Fellowship");
        System.out.println("6. Tata Scholarship for Cornell UNiversity ");
        System.out.println("7. Rotary Foundation Ambassadorial Scholarship");
        System.out.println("8. Akhtarali H. Taboccowala Fellowship");
        c1 = sc.nextInt();
        switch(c1){
            case 1: 
            System.out.println("USD 100,000(INR 80Lakhs)");
            
            break;
            case 2: 
            System.out.println("The Scholarship pays for all associated costs including tution , room and board , a stipend and sir travel.");
             
           
            break;
            case 3: 
            System.out.println("VAriable amount approx.  INR 10 lakhs");
            
            
            break;
            case 4:
            System.out.println("USD 1,50,000 (INR 1.95 Cr) on the MBA tution fees"); 
            
            break;
            case 5: 
            System.out.println("USA 10,000 (INR 7 lakhs)");             
            
            break;
            case 6: 
            System.out.println("Vsriable amount approx ( INR 15 lakhs)");
            
            break;
            case 7: 
            System.out.println("USA 15,000 -30,000 (INR 11 - 23 lakhs)");
            break;
            case 8: 
            System.out.println("USD 25,000 (INR 19 Lakhs)");
             break;
         
             default :
            System.out.println("Please select valid Scholarship ");
            break;
            }
        }
    }
}
