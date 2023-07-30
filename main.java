public class Main {
    public static void main(String[] args) {

        int[] seats;
        seats = new int[6];
        
        seats[0] = 3;
        seats[1] = 15;
        seats[2] = 0;
        seats[3] = 8;
        seats[4] = 4;
        seats[5] = 4;

        double[] cost = new double[3];
        
        cost[0] = 231.67;
        cost[1] = 540.75;
        cost[2] = 399.10;
        
        String[] travelers = new String[]{"Alice", "Bob", "Carlos", "David", "Eve", "Frank"};
        
        double total = 0;
        for(double c : cost) {
            total += c;
        }
        System.out.println("The cost per person is $" + total/travelers.length);
        
        System.out.println("Road trip participants:");
        for (int person = 0; person < travelers.length; person++) {
            System.out.println((person + 1) +". " + travelers[person]);
        } 
            
        System.out.println("Car 1 old seat value: " + seats[1]);
        seats[1] = 5;
        System.out.println("New value: " + seats[1]);

        }
}
