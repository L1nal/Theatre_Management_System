import java.util.*;

public class Theatre {
    public static String [] row_1 = {"O","O","O","O","O","O","O","O","O","O","O","O"};
    public static String [] row_2 = {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"};
    public static String [] row_3 = {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"};

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the New Theatre !");

        boolean loop = false;

        while (!loop){

            for(int x = 1; x < 200; x++){
                System.out.print("-");
            }
            System.out.println();
            System.out.println();

            System.out.println("""
                Please select an option:


                1) Buy a ticket.

                2) Print seating area.

                3) Cancel ticket.

                4) List available seats.

                5) Save to file.

                6) Load from file.

                7) Print ticket information and total price.

                8) Sort tickets by price.

                      0) Quit.
                """);

            for(int x = 1; x < 200; x++){
                System.out.print("-");
            }
            System.out.println();

            int option = 0;
            while(true) {
                try {
                    System.out.print("Enter your option:");
                    option = input.nextInt();
                    break; // break out of the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    input.nextLine(); // consume the invalid input
                }

            }

            switch(option){
                case 1:
                    buy_ticket();
                    break;
                case 0:
                    System.out.println("Thank You, Enjoy the show.");
                    loop = true;
                    break;
                default:
                    System.out.println("Enter a valid input.");
            }
        }
    }

    public static int inputData_checker(int min,int max) {
        Scanner input = new Scanner(System.in);
        int data;
        while (true) {
            try {
                data = input.nextInt();
                if (min <= data && data <= max) {
                    return data;
                } else {
                    System.out.println("Out of range");
                    System.out.println();
                    System.out.print("Please enter a valid integer between "+ min +" - "+ max +" :");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid integer");
                input.nextInt();
            }
        }
    }

    public static void buy_ticket(){

        System.out.println("Enter the Row and Column Number of the seat you wish to reserve.");

        while(true) {
            try{
                System.out.print("Enter the row number:");
                int row_no = inputData_checker(1,3);
            } catch (Exception e) {
                System.out.println("\n");
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}
