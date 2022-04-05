import java.lang.reflect.Array;
import java.util.ArrayList;

public class CafeUtil {
    public void sayHi() {
        System.out.println("Hello from the CafeUtil");
    }


    // sum total of all ints from 1-10
    public int getStreakGoal() {
        int sum = 0;
        for(int i=0; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

        // take in array of doubles sum all the prices in the array and return total
    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(double price : prices) {
            sum += price;
        }
        return sum;
    }

    // String name = myArray.get(0);


    public void displayMenu(ArrayList<String> menuItems) {
        int i = 0;
        for(String item : menuItems) {
            System.out.println(i + " " + item);
            i++;
        }

        // for(int a = 0; a < menuItems.size(); a++) {
        //     System.out.println(a + " " + menuItems.get(a));
        // }

        // System.out.println("Testing!");
    }

    void addCustomer(ArrayList<String> customers) {

        String userName = System.console().readLine();

        System.out.println("Hello" + " " + userName);
        customers.add(userName);
        System.out.println("hi " + userName + " there are " + (customers.size() -1) + " before you");
    }

}
