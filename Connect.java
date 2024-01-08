import java.util.ArrayList;
import java.util.Scanner;

class DS11 {

    static ArrayList<user> users = new ArrayList<user>();
    static String name;
    static String Branch;
    static String curr_status;
    static String password;
    static String area;
    static int conn = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\u001B[3m");
        System.out.println("\u001B[35m");

        String input = new String();
        int index;
        users.add(new user("Gunjan", "CE", "Undergrad", "bopal", "123"));
        users.add(new user("Khush", "CE", "Post-Grad", "satellite", "123"));
        users.add(new user("Namra", "IT", "Post-Grad", "shela", "123"));
        users.add(new user("Devansh", "IT", "Working Proffessional", "shela", "123"));
        users.add(new user("Samay", "CSE", "Working Proffessional", "bopal", "123"));
        users.add(new user("Rishi", "CSE", "Undergrad", "satellite", "123"));

        addf(users.get(0), users.get(1));
        addf(users.get(1), users.get(0));

        addf(users.get(0), users.get(2));
        addf(users.get(2), users.get(0));

        addf(users.get(0), users.get(3));
        addf(users.get(3), users.get(0));

        addf(users.get(1), users.get(3));
        addf(users.get(3), users.get(1));

        addf(users.get(0), users.get(5));
        addf(users.get(5), users.get(0));

        addf(users.get(1), users.get(5));
        addf(users.get(5), users.get(1));

        addf(users.get(1), users.get(4));
        addf(users.get(4), users.get(1));

        addf(users.get(4), users.get(5));
        addf(users.get(5), users.get(4));

        addf(users.get(4), users.get(2));
        addf(users.get(2), users.get(4));
        // showall(users, input);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\t\t\t\t\t\t Hey user " + "\n \t\t\t\t\t\t Welcome to CONNECT");
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t\t\t 1. Creat new acount" + " \n \t\t\t\t\t\t 2.Log in");
            System.out.print("Please select 1, 2 : ");
            input = in.next();
            switch (input) {
                case "1":
                    System.out.print("Name: ");
                    name = in.next();
                    System.out.print("Branch: ");
                    Branch = in.next();
                    System.out.println("curr_status: ");
                    int a;
                    int x = 0;
                    while (x == 0) {
            System.out.println("--------------------------------------------");
            System.out.println("|            1. Undergrad                   |");
            System.out.println("|            2. Post-Grad                   |");
            System.out.println("|            3.Working Proffessional        |");
            System.out.println("-----------------------------------------------");
                        System.out.println();
                        a = sc.nextInt();
                        switch (a) {
                            case 1:
                                curr_status = "Undergrad";
                                x++;

                                break;
                            case 2:
                                curr_status = "Post-Grad";
                                x++;
                                break;
                            case 3:
                                curr_status = "Working Proffessional";
                                x++;
                                break;
                            case 4:
                                break;
                        }
                    }
                    in.nextLine();
                    System.out.print("Enter Location ");
                    area = in.nextLine();
                    System.out.print("password: ");
                    password = in.next();
                    users.add(new user(name, Branch, curr_status, area, password));
                    break;
                case "2":
                    System.out.print("Please input name: ");
                    name = in.next();
                    index = find(name);
                    if (index == -1) {
                        System.out.println("The user not fount");
                    } else {
                        System.out.print("Please input password: ");
                        password = in.next();
                        if (users.get(index).password.equals(password)) {
                            login(index);
                        } else {
                            System.out.println("Password is not true, try again ");
                        }
                    }
                    break;
                default:
                    break;
            }
            if (input.equals("exit")) {
                break;
            }
        }
        showall(users, "friends");

    }

    public static void login(int index) {
        acceptorreject(index, users.get(index)); // notify the user for Friend Request
        String input;
        int num;
        while (true) {
            System.out.println("------------------------------------------");

            System.out.println("--------------------------------------------"
                    + "\n \t\t\t\t\t\t 1: Show my Connecton" + " \n \t\t\t\t\t\t  2: Connection request"
                    + "\n \t\t\t\t\t\t 3: Block" + "\n \t\t\t\t\t\t 4: Connection"
                    + "\n \t\t\t\t\t\t 5: Search by Branch"
                    + "\n \t\t\t\t\t\t 6: Search by Location" + "\n \t\t\t\t\t\t 7: Serch by Education"
                    + "\n \t\t\t\t\t\t logout"
                    + "\t\n---------------------------------------");
            System.out.println(users.get(index).name);
            System.out.print("Please select 1, 2, ..., 6 : ");
            input = in.next();
            switch (input) {
                case "1":
                    show(users.get(index), "'s Connections: ", "Connections");
                    System.out.println();
                    break;
                case "2":
                    System.out.print("Please input name: ");
                    name = in.next();
                    num = find(name);
                    if (num == -1) {
                        System.out.println("The user not fount");
                    } else {
                        if (!search(users.get(num), users.get(index), "friends")
                                && !search(users.get(num), users.get(index), "friendrequest")
                                && !search(users.get(num), users.get(index), "block")
                                && !search(users.get(index), users.get(num), "block")) {
                            friendrequest(users.get(num), users.get(index));
                            System.out.println("Your friend request has been sent");
                        } else {
                            System.out.println("Is not possible");
                        }
                    }
                    break;

                case "3":
                    System.out.print("Please input name: ");
                    name = in.next();
                    num = find(name);
                    if (num == -1) {
                        System.out.println("The user not fount");
                    } else {
                        deletefriend(users.get(index), users.get(num));
                        deletefriend(users.get(num), users.get(index));
                        block(users.get(index), users.get(num));
                        showall(users, "block");
                    }
                    break;
                case "4":
                    System.out.print("Please input name to find connection: ");
                    name = in.next();
                    num = find(name);
                    if (num == -1) {
                        System.out.println("The user not fount");
                    } else {
                        if (!searchname(users.get(index), name)) {
                            conn = 0;
                            users.get(index).suggestfriend = null;
                            connection(users.get(index), index, name);
                            if (conn == 0) {
                                System.out.println("No connection between you and " + name + " exist");
                            } else {
                                System.out.println(conn + " connection between you and " + name + " exist");
                            }
                        } else {
                            System.out.println(name + " is your friend");
                        }
                    }
                    break;
                case "5":
                    searchbybranch();
                    break;
                case "6":
                    searchbyarea();
                    break;
                case "7":
                    searchbyCurr();
                    break;
                default:
                    break;
            }
            if (input.equals("logout")) {
                break;
            }
        }
    }

    public static void searchbybranch() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Branch that you want to search");
        String s = sc.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).Branch.equalsIgnoreCase(s)) {
                System.out.println(users.get(i).name + "               " + users.get(i).curr_status + "           "
                        + users.get(i).Branch + "                 "
                        + users.get(i).area);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Not found");
        }
    }

    public static void searchbyarea() {
        boolean flag = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Area that you want to search");
        String s = sc.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).area.equalsIgnoreCase(s)) {
                System.out.println(users.get(i).name + "            " + users.get(i).curr_status + "            "
                        + users.get(i).Branch + "                   "
                        + users.get(i).area);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Not found");
        }
    }

    public static void searchbyCurr() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Educational Status that you want to search");
        String s = "";
        int a;
        int x = 0;
        while (x == 0) {
            System.out.println("--------------------------------------------");
            System.out.println("|            1. Undergrad                   |");
            System.out.println("|            2. Post-Grad                   |");
            System.out.println("|            3.Working Proffessional        |");
            System.out.println("|            4. Exit                        |");
            System.out.println("-----------------------------------------------");

            a = sc.nextInt();
            switch (a) {
                case 1:
                    s = "Undergrad";
                    x++;

                    break;
                case 2:
                    s = "Post-Grad";
                    x++;
                    break;
                case 3:
                    s = "Working Proffessional";
                    x++;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter valid input");
                    break;
            }
        }
        sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).curr_status.equalsIgnoreCase(s)) {
                System.out.println(users.get(i).name + " " + users.get(i).curr_status + " " + users.get(i).Branch + " "
                        + users.get(i).area);
                flag = true;
            }

        }
        if (!flag) {
            System.out.println("Not found");
        }
    }// FIND

    public static int find(String name) {
        int j = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.equals(name)) {
                j = i;
                break;
            }
        }
        return j;
    }

    public static void addf(user next, user friend) {
        if (next.friends != null) {
            addf(next.friends, friend);
        } else {
            next.friends = new user(friend.name);
        }
    }

    public static void friendrequest(user next, user friend) {
        if (next.friendrequest != null) {
            friendrequest(next.friendrequest, friend);
        } else {
            next.friendrequest = new user(friend.name);
        }
    }

    public static void acceptorreject(int index, user next) {
        String input;
        int num;
        if (next.friendrequest != null) {
            num = find(next.friendrequest.name);
            System.out.println("Request Pending " + next.friendrequest.name + " ?(Y/N/ignore)");
            input = in.next();
            switch (input) {
                case "y":
                    addf(users.get(index), users.get(num));
                    addf(users.get(num), users.get(index));
                    acceptorreject(index, next.friendrequest);
                    dfr(users.get(index), users.get(num));
                    break;
                case "Y":
                    addf(users.get(index), users.get(num));
                    addf(users.get(num), users.get(index));
                    acceptorreject(index, next.friendrequest);
                    dfr(users.get(index), users.get(num));
                    break;
                case "N":
                    acceptorreject(index, next.friendrequest);
                    dfr(users.get(index), users.get(num));
                    break;
                case "n":
                    acceptorreject(index, next.friendrequest);
                    dfr(users.get(index), users.get(num));
                    break;
                default:
                    acceptorreject(index, next.friendrequest);
                    break;
            }

        }
    }

    public static void block(user next, user block) {
        if (next.block != null) {
            block(next.block, block);
        } else {
            next.block = new user(block.name);
        }
    }// DEL

    public static void deletefriend(user next, user friend) {
        if (next.friends != null) {
            if (next.friends.name.equals(friend.name)) {
                user temp = new user();
                temp = next.friends.friends;
                next.friends = temp;
            } else {
                deletefriend(next.friends, friend);
            }
        }
    }

    public static void dfr(user next, user friend) {
        if (next.friendrequest != null) {
            if (next.friendrequest.name.equals(friend.name)) {
                user temp = new user();
                temp = next.friendrequest.friendrequest;
                next.friendrequest = temp;
            } else {
                dfr(next.friendrequest, friend);
            }
        }
    }

    public static void suggestfriend(user next, String name) {
        if (next.suggestfriend != null) {
            suggestfriend(next.suggestfriend, name);
        } else {
            next.suggestfriend = new user(name);
        }
    }

    public static void deletesuggestfriend(user next, user friend) {
        if (next.suggestfriend != null) {
            if (next.suggestfriend.name.equals(friend.name)) {
                user temp = new user();
                temp = next.suggestfriend.suggestfriend;
                next.suggestfriend = temp;
            } else {
                deletesuggestfriend(next.suggestfriend, friend);
            }
        }
    }

    public static void connection(user u1, int index, String name) {

        if (u1.friends != null) {
            if (!search(users.get(index), u1.friends, "suggestfriend")) {
                suggestfriend(users.get(index), u1.friends.name);
                if (!u1.friends.name.equals(name)) {
                    connection(users.get(find(u1.friends.name)), index, name);
                    if (!search(users.get(index), users.get(find(name)), "suggestfriend")) {
                        deletesuggestfriend(users.get(index), users.get(find(u1.friends.name)));
                        connection(u1.friends, index, name);
                    } else {
                        show(users.get(index), ",", "suggestfriend");
                        System.out.print("(" + findlength(users.get(index)) + ")");
                        conn++;
                        System.out.println("");
                        deletesuggestfriend(users.get(index), users.get(find(name)));
                        deletesuggestfriend(users.get(index), users.get(find(u1.friends.name)));
                        connection(u1.friends, index, name);
                    }
                }
            } else {
                connection(u1.friends, index, name);
            }
        }

    }

    public static int findlength(user u1) {
        int count = 0;
        user temp = new user();
        temp = u1;
        while (temp.suggestfriend != null) {
            count++;
            temp = temp.suggestfriend;
        }

        return count;
    }

    public static int samefriends(user u1, user u2, boolean mode) {
        user temp = new user();
        temp = u2;
        int i = 0;
        boolean flag = false;
        while (temp.friends != null) {
            if (searchname(u1, temp.friends.name)) {
                i++;
                if (mode) {
                    System.out.println(temp.friends.name);
                }
                flag = true;
            }
            temp = temp.friends;
        }
        if (!flag) {
            if (mode) {
                System.out.println("Not Found");
            }
        }
        return i;
    }

    public static boolean searchname(user u1, String name) {
        user temp = new user();
        temp = u1;
        boolean flag = false;
        while (temp.friends != null) {
            if (temp.friends.name.equals(name)) {
                flag = true;
                break;
            }
            temp = temp.friends;

        }
        return flag;
    }

    public static boolean search(user u1, user u2, String s) {
        user temp = new user();
        temp = u1;
        boolean flag = false;
        while (temp != null) {
            if (temp.name.equals(u2.name)) {
                flag = true;
                break;
            }
            switch (s) {
                case "friends":
                    temp = temp.friends;
                    break;
                case "friendrequest":
                    temp = temp.friendrequest;
                    break;
                case "block":
                    temp = temp.block;
                    break;
                case "suggestfriend":
                    temp = temp.suggestfriend;
                    break;
                default:
            }
        }
        return flag;
    }

    public static void show(user person, String n, String s) {
        if (person != null) {
            System.out.print(person.name + n);
            switch (s) {
                case "friends":
                    show(person.friends, ", ", s);
                    break;
                case "friendrequest":
                    show(person.friendrequest, ", ", s);
                    break;
                case "block":
                    show(person.block, ", ", s);
                    break;
                case "suggestfriend":
                    show(person.suggestfriend, ", ", s);
                    break;
                default:
                    break;
            }
        }
    }

    public static void showall(ArrayList<user> list, String s) {
        for (user user : list) {
            show(user, " : ", s);
            System.out.println();
        }
    }
}

class user {
    String name;
    String Branch;
    String curr_status;
    String password;
    String area;
    user friends;
    user block;
    user friendrequest;
    user suggestfriend;

    public user() {
        name = "";
        friends = null;
        block = null;
        friendrequest = null;
        suggestfriend = null;
    }

    public user(String name) {
        this.name = name;
        friends = null;
        block = null;
        friendrequest = null;
        suggestfriend = null;
    }

    public user(String name, String Branch, String curr_status, String area, String password) {
        this.name = name;
        this.Branch = Branch;
        this.curr_status = curr_status;
        this.area = area;
        this.password = password;
        friends = null;
        block = null;
        friendrequest = null;
        suggestfriend = null;
    }
}