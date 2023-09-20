import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Theatre {
//    public static String [] row_1 = {"O","O","O","O","O","O","O","O","O","O","O","O"};
//    public static String [] row_2 = {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"};
//    public static String [] row_3 = {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"};
    static int[] row_1 = new int[12];
    static int[] row_2 = new int[16];
    static int[] row_3 = new int[20];
     static void main(String[] args) {

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
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
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

    static int inputData_checker(int min,int max) {
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

    static void buyTicket_dataCheck(int min, int max, String arr[]){
        int seat_no = inputData_checker(min, max);
        if (arr[seat_no - 1].equals("X")) {
            System.out.println("This Seat is already occupied.");
        }else if (arr[seat_no-1].equals("O")) {
            arr[seat_no-1] = "X";
            System.out.println("Seat reserved successfully.");
        }
    }

   static void cancelTicket_dataCheck(int min, int max){
        int seat_no = inputData_checker(min, max);
        if (row_1[seat_no-1].equals("O")) {
            System.out.println("Unoccupied seat");
        }else if (row_1[seat_no-1].equals("X")) {
            row_1[seat_no-1] = "O";
            System.out.println("Seat cancelled successfully.");
        }
    }

   static void available(String[] arr, int end){
        for(int i = 0; i < end; i++){
            if(arr[i].equals("O")){
                System.out.println(i+1);
                if (i < end - 1){
                    System.out.println(", ");
                }
            }
        }System.out.println(",");
    }


    static void buy_ticket(){

        System.out.println("Enter the Row and Column Number of the seat you wish to reserve.");

        while(true) {
            try {
                System.out.print("Enter the row number:");
                int row_no = inputData_checker(1,3);
                System.out.print("Enter the Seat number:");
                if (row_no == 1) {
                    buyTicket_dataCheck(1, 12, row_1);
                } else if (row_no == 2) {
                    buyTicket_dataCheck(1, 16, row_2);
                } else if (row_no == 3) {
                    buyTicket_dataCheck(1, 20, row_3);
                }
                break;

            } catch (Exception e) {
                System.out.println("\n");
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    static void print_seating_area(){

        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*************");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*" + "   STAGE   " + "*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*************");

        System.out.print("\t");
        System.out.print("\t");
        for(int i = 0; i < row_1.length; i++){
            if(i == 6){
                System.out.print(" ");
                System.out.print(row_1[6]);
            }else{
                System.out.print(row_1[i]);
            }
        }

        System.out.println();

        for(int j = 0; j < row_2.length; j++){
            if(j == 0){
                System.out.print("      ");
                System.out.print(row_2[0]);
            }else if(j == 8){
                System.out.print(" ");
                System.out.print(row_2[8]);
            }else{
                System.out.print(row_2[j]);
            }
        }

        System.out.println();

        for(int k = 0; k < row_3.length; k++){
            if(k == 0){
                System.out.print("    ");
                System.out.print(row_3[0]);
            }else if(k == 10){
                System.out.print(" ");
                System.out.print(row_3[10]);
            }else {
                System.out.print(row_3[k]);
            }
        }
        System.out.println();
    }

    static void cancel_ticket(){

        System.out.println("Enter the Row and Column Number of the seat you wish to cancel.");

        while(true) {

            try{
                System.out.println( );
                System.out.print("Enter the row number:");
                int row_no = inputData_checker(0, 3);
                System.out.print("Enter the Seat number:");
                if(row_no == 1){
                    cancelTicket_dataCheck(1, 12);
                }else if(row_no == 2){
                    cancelTicket_dataCheck(1, 16);
                }else if(row_no == 3){
                    cancelTicket_dataCheck(1, 20);
                }break;
            } catch (Exception e) {
                System.out.println("\n");
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

   static void show_available(){
        System.out.println("Seats available in row 1: ");
        available(row_1, row_1.length);
        System.out.println();

        System.out.println("Seats available in row 2: ");
        available(row_2, row_2.length);
        System.out.println();

        System.out.println("Seats available in row 3: ");
        available(row_3, row_3.length);
        System.out.println();
    }

    static void save(){
        try {
            File file = new File("text.txt");
            boolean file_created = file.createNewFile();
            if (file_created) {
                System.out.println("\nFile created: " + file.getName());
            }
            FileWriter writer = new FileWriter(file);
            writer.write(" ◆ O indicates a free seat. \n ◆ X indicates an occupied (sold) seat.\n");
            writer.write("Seats available in row 1:");

            for (String s : row_1) {
                writer.write(s + " ");
            }
            writer.write("\n");
            writer.write("Seats available in row 2:");

            for (String s : row_2) {
                writer.write(s + " ");
            }
            writer.write("\n");
            writer.write("Seats available in row 3:");

            for (String s : row_3) {
                writer.write(s + " ");
            }
            writer.write("\n");

            writer.close();
            System.out.println("Array written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

   static void load() {
       try {
           File file = new File("text.txt");
           Scanner rf = new Scanner(file);

           String fileLine;
           int linecount = 0;
           while (rf.hasNext()) {
               fileLine = rf.nextLine();
               System.out.println(fileLine);
               linecount++;
           }
           rf.close();
           System.out.print("\nSuccessfully restored the 3 arrays with the row's information.\n");
       } catch (IOException e) {
           System.out.println(e);
       }
   }

}
