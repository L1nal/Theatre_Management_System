public class Theatre {
    public static String [] row_1 = {"O","O","O","O","O","O","O","O","O","O","O","O"};
    public static String [] row_2 = {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"};
    public static String [] row_3 = {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"};

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre !");

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

    }
}
