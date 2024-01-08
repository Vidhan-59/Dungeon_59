import java.io.IOException;
import java.util.*;

public class DS12 {
    static class Route{
        String source;
        String destination;
        int distance;
        int time;

        Route(String s,String d,int d1,int time){
           this.source = s;
           this.destination = d;
           this.distance = d1;
           this.time = time;
        }

        public String getDestination(){
            return destination;
        }

        public int getDistance(){
            return distance;
        }
    }

    Scanner sc = new Scanner(System.in);
    public static final int v = 20;
    static String[] station = {"SCIENCE CITY","ISKON CROSS ROAD","MAKARBA","RAMDEVNAGAR","STAR BAZARA",
    "SHIVRANJINI","NEHRUNAGAR","DHARNIDHAR","CHANDARNAGAR","SANAD CIRCLE(SARKHEJ)","SOLA BRIDGE",
    "BHUYANGDEV","PARSNAGAR","NARAYANAPUR","JAIMAGAL","SOLA CROSS ROAD","GUJARAT UNIVERSITY","LD ENGINEERING COLLEGE",
    "LAW GARDEN","MJ LIBRARY"};
    public static Thread t = new Thread();

    public static void list() {
        try{
        t.sleep(300);
        }catch(Exception e){
            System.out.println(e);
        }
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
         System.out.println();
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
         System.out.println();
         System.out.println("                                        List Of Stations                   ");
         System.out.println();
         ArrayList<String> a = new ArrayList<>();
         a.addAll(Arrays.asList("Science City","ISKON Cross Road","Makarba","Ramdevnagar","Star Bazara",
         "Shivranjini","Nehrunagar","Dharnidhar","Chandarnagar","Sanad Circle(Sarkhej)","Sola Bridge",
         "Bhuyangdev","Parsnagar","Narayanapur","Jaimagal","Sola Cross Road","Gujarat University","LD Engineering College",
         "Law Garden","MJ Library"));
         for(int i = 0;i<a.size();i++){
             System.out.println((1+i)+". "+a.get(i));
         }
    }

    public static void create(ArrayList<Route> g[]){
          
        for(int i = 0 ;i<g.length;i++){
            g[i] = new ArrayList<Route>();
        }

        g[0].add(new Route(station[0],station[1],7,10));
        g[0].add(new Route(station[0],station[10],5,7));

        g[1].add(new Route(station[1],station[3],1,2));
        g[1].add(new Route(station[1],station[2],3,4));
        g[1].add(new Route(station[1],station[0],7,10));         

        g[2].add(new Route(station[2],station[1],3,4));
        g[2].add(new Route(station[2],station[9],2,3));   
            
        g[3].add(new Route(station[3],station[4],3,4));
        g[3].add(new Route(station[3],station[1],1,2));

        g[4].add(new Route(station[4],station[5],2,2));
        g[4].add(new Route(station[4],station[3],3,4));

        g[5].add(new Route(station[5],station[6],2,2));
        g[5].add(new Route(station[5],station[4],2,2));

        g[6].add(new Route(station[6],station[7],4,6));
        g[6].add(new Route(station[6],station[5],2,2));

        g[7].add(new Route(station[7],station[8],3,4));
        g[7].add(new Route(station[7],station[6],4,6));

        g[8].add(new Route(station[8],station[7],3,4));

        g[9].add(new Route(station[9],station[2],2,3));

        g[10].add(new Route(station[10],station[11],3,4));
        g[10].add(new Route(station[10],station[0],5,7));

        g[11].add(new Route(station[11],station[10],3,4));
        g[11].add(new Route(station[11],station[12],1,2));
        g[11].add(new Route(station[11],station[13],3,4));

        g[12].add(new Route(station[12],station[11],1,2));
        g[12].add(new Route(station[12],station[15],4,6));

        g[13].add(new Route(station[13],station[11],3,4));
        g[13].add(new Route(station[13],station[14],2,3));

        g[14].add(new Route(station[14],station[13],2,3));
        g[14].add(new Route(station[14],station[15],2,3));


        g[15].add(new Route(station[15],station[12],4,6));
        g[15].add(new Route(station[15],station[14],2,3));
        g[15].add(new Route(station[15],station[16],3,5));

        g[16].add(new Route(station[16],station[15],3,5));
        g[16].add(new Route(station[16],station[17],4,6));


        g[17].add(new Route(station[17],station[18],3,5));
        g[17].add(new Route(station[17],station[19],2,3));
        g[17].add(new Route(station[17],station[16],4,6));

        g[18].add(new Route(station[18],station[17],3,5));

        g[19].add(new Route(station[19],station[17],2,3));
    }

    static int w;
    public static void des(String d){
         for(int i = 0;i<station.length;i++){
             if(d.equalsIgnoreCase(station[i])){
                    w = i;
                    break;
             }
         }
    }

    public static void path(ArrayList<Route> g[],int c,int t,boolean vist[],String p){   
        // DFS
        Thread t1 = new Thread();   
      if(c == t){
        try{
            t1.sleep(800);
        }catch(Exception e){
            System.out.println(e);
        }
         System.out.println(p);
         return;
     }
     for(int i = 0;i<g[c].size();i++){
           Route r = g[c].get(i);
           des(r.destination);
           if(!vist[w]){
             vist[c] = true;
              path(g,w,t,vist,p+" --> "+r.destination);
              vist[c] = false;
           }
     }
    }

   public static class Pair implements Comparable<Pair>{
     int index;
     int dist;

     public Pair(int index , int dis){
         this.index = index;
         this.dist = dist;
     }
     
     @Override
     public int compareTo(Pair p2){
         return this.dist - p2.dist;
     }
 }

   public static class Pair1 implements Comparable<Pair1>{
        int index;
        int time;

        public Pair1(int index , int time){
            this.index = index;
            this.time = time;
        }
        
        @Override
        public int compareTo(Pair1 p2){
            return this.time - p2.time;
        }
    }     

    public static void shortest(ArrayList<Route> g[],int s,int d,int v){
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       int dis[] = new int[v];
      
        for(int i = 0;i<g.length;i++){
                if(i != s){
                dis[i] = Integer.MAX_VALUE;
                }
        }
        boolean b[] = new boolean[v];
        pq.add(new Pair(s,0));
        
        while(!pq.isEmpty()){
            Pair c = pq.remove();
            if(!b[c.index]){
                b[c.index] = true;
            for(int i = 0;i<g[c.index].size();i++){
                Route r = g[c.index].get(i);
                String u = r.source;
                String v1 = r.destination;
                for(int j = 0;j<station.length;j++){
                if(u.equalsIgnoreCase(station[j])){
                        q = j;
                        break;
                } 
                }
                for(int t = 0;t<station.length;t++){
                if(v1.equalsIgnoreCase(station[t])){
                        p = t;
                        break;
                }
                }
                if((dis[q]+r.distance) < dis[p]){
                    dis[p] = dis[q] +r.distance;
                    pq.add(new Pair(p,dis[p]));
                }
            }
        }   
        }

        for(int i = 0;i<v;i++){
            for(int j=0;j<station.length;j++){
                if(s == j)
                {
                    a1 = station[j];
                }
                if(d == j){
                    a2 = station[j];
                }
            }
                if(i == d){
                System.out.println();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
                System.out.println();
                try{
                    t.sleep(800);
                }catch(Exception e){}
                System.out.print("Shortest distance between "+a1+" to "+a2+" : "+dis[i]+" km ");
                System.out.println();
                }
            }
    } 

    private static int find_index(String stop) {
        for (int i = 0; i < station.length; i++) {
            if (station[i].equalsIgnoreCase(stop)){
                return i;
            }
        }
        return -1;
    }

     public static class Pair2 implements Comparable<Pair2> {
        String node;
        int dist;

        public Pair2(String node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair2 p2) {
            return this.dist - p2.dist;
        }
    }

    public static void findShortestPath(ArrayList<Route>[] graph, String src, String dst) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();

        // Initialize the distance map with infinity for all nodes except the start node
        for(String node : station) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(src, 0);

        // Create a priority queue to keep track of nodes with minimum
        // distance
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        queue.add(src);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            visited.add(currentNode);

            int nodeIndex = find_index(currentNode);
            ArrayList<Route> neighbors = graph[nodeIndex];
            for (Route neighborEdge : neighbors) {
                String neighborNode = neighborEdge.destination;
                int edgeWeight = neighborEdge.distance;
                int newDistance = distance.get(currentNode) + edgeWeight;

                if (newDistance < distance.get(neighborNode)){
                    distance.put(neighborNode, newDistance);
                    previous.put(neighborNode, currentNode);
                    if (!visited.contains(neighborNode)){
                        queue.add(neighborNode);
                    }
                }
            }
        }

        List<String> shortestPath = new ArrayList<>();
        String currentNode = dst;
        while (previous.containsKey(currentNode)) {
            shortestPath.add(currentNode);
            currentNode = previous.get(currentNode);
        }
        shortestPath.add(src);
        Collections.reverse(shortestPath);
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
         try{
            t.sleep(800);
        }catch(Exception e){}
        System.out.println("Shortest Path from " + src + " to " + dst + ": ");
        System.out.println();
        for (String s : shortestPath) {
            System.out.print(s + " --> ");
        }
        System.out.println(distance.get(dst) + " km");
    }

   static String a1;
   static String a2;
   static int q;
   static int x;
   static int y;
   static int p;

    public static void findShortestPath_time(ArrayList<Route>[] graph, String src, String dst) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();

        // Initialize the distance map with infinity for all nodes except the start node
        for(String node : station) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(src, 0);

        // Create a priority queue to keep track of nodes with minimum
        // distance
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        queue.add(src);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            visited.add(currentNode);

            int nodeIndex = find_index(currentNode);
            ArrayList<Route> neighbors = graph[nodeIndex];
            for (Route neighborEdge : neighbors) {
                String neighborNode = neighborEdge.destination;
                int edgeWeight = neighborEdge.time;
                int newDistance = distance.get(currentNode) + edgeWeight;

                if (newDistance < distance.get(neighborNode)){
                    distance.put(neighborNode, newDistance);
                    previous.put(neighborNode, currentNode);
                    if (!visited.contains(neighborNode)){
                        queue.add(neighborNode);
                    }
                }
            }
        }

        List<String> shortestPath = new ArrayList<>();
        String currentNode = dst;
        while (previous.containsKey(currentNode)) {
            shortestPath.add(currentNode);
            currentNode = previous.get(currentNode);
        }
        shortestPath.add(src);
        Collections.reverse(shortestPath);
         try{
                t.sleep(800);
          }catch(Exception e){}
        System.out.println("Shortest Path from " + src + " to " + dst + ": ");
        System.out.println();
        for (String s : shortestPath) {
            System.out.print(s + " --> ");
        }
        System.out.println(distance.get(dst) + " min");
    }

   public static void shortest_time(ArrayList<Route> g[],int s,int d,int v){
      PriorityQueue<Pair> pq = new PriorityQueue<>();   
       int dis[] = new int[v];
      
     for(int i = 0;i<g.length;i++){
             if(i != s){
             dis[i] = Integer.MAX_VALUE;
             }
     }
     boolean b[] = new boolean[v];
     pq.add(new Pair(s,0));
     
     while(!pq.isEmpty()){
         Pair c = pq.remove();
         if(!b[c.index]){
            b[c.index] = true;
         for(int i = 0;i<g[c.index].size();i++){
             Route r = g[c.index].get(i);
             String u = r.source;
             String v1 = r.destination;
             for(int j = 0;j<station.length;j++){
             if(u.equalsIgnoreCase(station[j])){
                    q = j;
                    break;
             } 
            }
            for(int t = 0;t<station.length;t++){
             if(v1.equalsIgnoreCase(station[t])){
                    p = t;
                    break;
             }
             }
             if((dis[q]+r.time) < dis[p]){
                  dis[p] = dis[q] +r.time;
                 pq.add(new Pair(p,dis[p]));
             }
         }
     }   
    }
    for(int i = 0;i<v;i++){
     for(int j=0;j<station.length;j++){
         if(s == j)
         {
             a1 = station[j];
         }
         if(d == j){
              a2 = station[j];
          }
        }
         if(i == d){
         System.out.println();
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
         System.out.println();
          try{
                    t.sleep(500);
         }catch(Exception e){}
         System.out.print("Shortest time between "+a1+" to "+a2+" : "+dis[i]+" min ");
         System.out.println();
         }
      }
    }

    public void nearest(ArrayList<Route> g[]){
         System.out.println();
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
         boolean f = true;
         String s1;
         while(f){
         System.out.println();
         System.out.print("Enter Source Station : ");
         s1 = sc.nextLine().toUpperCase();
         for(int i=0;i<station.length;i++){
         if(s1.equalsIgnoreCase(station[i])){
                 x = i;
                 f = false;
                 a1 = s1;
                 break;
           }
          }
        }
         System.out.println();
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
         System.out.println();
         System.out.println("Nearest Stations From "+a1+" : ");
         System.out.println();
         for(int i = 0;i<g[x].size();i++){
         Route e = g[x].get(i);
         System.out.println(e.source+" ---> "+e.destination+" ---> "+e.distance+" km ,"+e.time+" min");
         }
    }   

   private static void displaySorted(ArrayList<Route> graph) {
        System.out.println();
        try{
                    t.sleep(800);
            }catch(Exception e){}
        for (Route e : graph) {
            System.out.printf("%-20s == %3s km , %1s min\n", e.destination, e.distance,e.time);
        }
}

    static String s6;
    static String s7;

   public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     DS12 d =  new DS12();
       ArrayList<Route> g[] = new ArrayList[v];
       create(g);
       boolean b = true;
       System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
       System.out.println("|                                                                                               |");
       System.out.println("|                                  *  BUS ROUTE NAVIGATOR *                                     |");
       System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
       while(b){
       System.out.println();
       System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
       System.out.println("|                                                                                               |");
       System.out.println("|        Press 1. List of Station.                                                              |");
       System.out.println("|        Press 2. Get Nearest Station from 'SOURCE' Station Alphabetically.                     |");
       System.out.println("|        Press 3. Get Nearest Station from 'SOURCE' Station With Respect To Distance.           |");
       System.out.println("|        Press 4. All path from 'SOURCE' to 'DESTINATON' Station.                               |");
       System.out.println("|        Press 5. Shortest Distance from 'SOURCE' to 'DESTINATON' Station.                      |");  
       System.out.println("|        Press 6. Shortest Time from 'SOURCE' to 'DESTINATON' Station.                          |");  
       System.out.println("|        Press 7. Shortest Path (Distance Wise) from 'SOURCE' to 'DESTINATON' Station.          |");
       System.out.println("|        Press 8. Shortest Path (Time Wise) from 'SOURCE' to 'DESTINATON' Station.              |");  
       System.out.println("|        Press 9. Exit                                                                          |");
       System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
       System.out.println();
       System.out.print("Enter your choice : ");
       int ch;
       try{
        ch = sc.nextInt();
        sc.nextLine();
       }catch(Exception e){
        ch = -1;
        sc.nextLine();
       }
       System.out.println();
       switch(ch){
          case 1:{
               list();
               System.out.println();
               System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
               System.out.println();
               break;
          }
          case 2:{
            list();
            System.out.println();
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            boolean f = true;
            System.out.println();
            while(f){
            System.out.print("Enter source station : ");
             s6 = sc.nextLine().toUpperCase().trim();
             for(int i = 0;i<station.length;i++){
                if(s6.equalsIgnoreCase(station[i]))
                {
                    g[i].sort(Comparator.comparing(Route::getDestination));
                    displaySorted(g[i]);
                    f = false;
                }
             }
            System.out.println();
             }
            break;
          }
          case 3:{
            //  d.nearest(g);
            //  System.out.println();
            //  System.out.println("*****************************************************");
            //  System.out.println();
            list();
            System.out.println();
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            boolean f = true;
            System.out.println();
            while(f){
            System.out.print("Enter source station : ");
             s6 = sc.nextLine().toUpperCase().trim();
             for(int i = 0;i<station.length;i++){
                if(s6.equalsIgnoreCase(station[i]))
                {
                    g[i].sort(Comparator.comparing(Route::getDistance));
                    displaySorted(g[i]);
                    f = false;
                }
             }
             System.out.println();
             }
             break;
          }
         case 4 :{            
            list();
            System.out.println();
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
             boolean f = true;
             String s;
             while(f){
             System.out.println();
             System.out.print("Enter source station : ");
                s = sc.nextLine().toUpperCase().trim();
             for(int i = 0;i<station.length;i++){
                     if(s.equalsIgnoreCase(station[i])){
                         x = i;
                         f = false;
                         a1 = s;
                         break;
                     }
                 }
             }
             boolean f1 = true;
             while(f1){
             System.out.println();
             System.out.print("Enter destination station : ");
             String s1 = sc.nextLine().toUpperCase().trim();
             for(int i = 0;i<station.length;i++){
                 if(s1.equalsIgnoreCase(station[i])){
                     y = i;
                     f1 = false;
                     a2 = s1;
                     break;
                 }
             }
             }
             System.out.println();
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
             System.out.println();
             System.out.println("All Possible Ways To Go From "+a1+" To "+a2+" : ");
             String p = a1+" ";
             System.out.println();
             boolean b1[] = new boolean[v];
             path(g, x, y, b1, p);
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
             System.out.println();
             break;
     }
     case 5:{
        list();
        System.out.println();
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
         String s4;
            boolean f = true;
            while(f){
            System.out.println();
            System.out.print("Enter source station : ");
             s4 = sc.nextLine().toUpperCase().trim();
             for(int i =0 ;i<station.length;i++){
                if(s4.equalsIgnoreCase(station[i])){
                    x = i;
                    f = false;
                }
             }
            }
            boolean f2 = true;
            while(f2){
            System.out.println();
            System.out.print("Enter destination station : ");
            String s5 = sc.nextLine().toUpperCase().trim();
            for(int i = 0;i<station.length;i++){
                if(s5.equalsIgnoreCase(station[i])){
                       y = i;
                       f2 = false;
                       break;
                }
            }
           }
         shortest(g, x, y, v);
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
         System.out.println();
         break;
     }
     case 6:{
        list();
        System.out.println();
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            String s4;
            boolean f = true;
            while(f){
            System.out.println();
            System.out.print("Enter source station : ");
             s4 = sc.nextLine().toUpperCase().trim();
             for(int i =0 ;i<station.length;i++){
                if(s4.equalsIgnoreCase(station[i])){
                    x = i;
                    f = false;
                }
             }
            }

            boolean f2 = true;
            while(f2){
            System.out.println();
            System.out.print("Enter destination station : ");
            String s5 = sc.nextLine().toUpperCase().trim();
            for(int i = 0;i<station.length;i++){
                if(s5.equalsIgnoreCase(station[i])){
                       y = i;
                       f2 = false;
                       break;
                }
            }
         }
        shortest_time(g, x, y, v);
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
         break;
     }
     case 7:{
        list();
        System.out.println();
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            boolean f = true;
            while(f){
            System.out.println();
            System.out.print("Enter source station : ");
             s6 = sc.nextLine().toUpperCase().trim();
             for(int i = 0;i<station.length;i++){
                if(s6.equalsIgnoreCase(station[i]))
                {
                    f = false;
                }
             }
             }
            boolean f2 = true;
            while(f2){
            System.out.println();
            System.out.print("Enter destination station : ");
            s7 = sc.nextLine().toUpperCase().trim();
            for(int i = 0;i<station.length;i++){
                if(s7.equalsIgnoreCase(station[i]))
                {
                    f2 = false;
                }
            }
        }
        System.out.println();
        findShortestPath(g,s6,s7);
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        break;
    }
    case 8:{
        list();
        System.out.println();
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            boolean f = true;
            while(f){
            System.out.println();
            System.out.print("Enter source station : ");
             s6 = sc.nextLine().toUpperCase().trim();
             for(int i = 0;i<station.length;i++){
                if(s6.equalsIgnoreCase(station[i]))
                {
                    f = false;
                }
             }
             }
            boolean f2 = true;
            while(f2){
            System.out.println();
            System.out.print("Enter destination station : ");
            s7 = sc.nextLine().toUpperCase().trim();
            for(int i = 0;i<station.length;i++){
                if(s7.equalsIgnoreCase(station[i]))
                {
                    f2 = false;
                }
            }
        }
        System.out.println();
        findShortestPath_time(g,s6,s7);
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        break;
     }
     case 9:{
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        System.out.println("Exiting....");
     //   System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        System.exit(0);
     }
     default:
     {  
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        System.out.println("Enter your choice in between 0 to 9 number. ");
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
     }
   }
  }
 }
}