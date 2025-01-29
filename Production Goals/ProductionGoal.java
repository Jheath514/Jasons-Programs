import java.util.Scanner;

public class ProductionGoal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the production goal: ");
        int goal = scanner.nextInt();

        if (goal < 1000) {
            System.out.println("The goal has already been met.");
        } else {
            int currentMonth = 1; 
            int currentProduction = 1000;
            double growthRate = 0.06; 

            int monthsToGoal = calculateMonthsToGoal(currentMonth, currentProduction, growthRate, goal);
            
            System.out.println("The goal will be met in " + monthsToGoal + " months.");
        }

        scanner.close();
    }

    private static int calculateMonthsToGoal(int currentMonth, int currentProduction, double growthRate, int goal) {
        if (currentProduction >= goal) {
            return 0; 
        }

        int nextMonthProduction = (int) (currentProduction * (1 + growthRate));
        return 1 + calculateMonthsToGoal(currentMonth + 1, nextMonthProduction, growthRate, goal);
    }
}
