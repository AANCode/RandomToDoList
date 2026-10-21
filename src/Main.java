import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean kjorer = true;
        Scanner sc  = new Scanner(System.in);

        List<String> todo = new ArrayList();

        String test = "test";
        todo.add("go to the gym");
        todo.add(test);


        System.out.println(todo);

        while (kjorer) {
            // TODO: legg til en sjekk som validerer om et nummer ble skrevet
            System.out.println("1: Show the list \n" +
                    "2: Add to the list \n" +
                    "3: remove from list \n" +
                    "4: End program");
            System.out.print("Enter your choice: ");

            int valg = Integer.parseInt(sc.nextLine());

            switch (valg) {
                case 1:
                    printList(todo);
                    break;
                case 2:
                    System.out.println("Write a goal in your list: ");
                    String goal = sc.nextLine();
                    todo.add(goal);
                    System.out.println(todo);
                    break;
                case 3:
                    System.out.print("Write which number iteam you want to remove: ");
                    int num = Integer.parseInt(sc.nextLine());
                    todo.remove(num - 1);
                    System.out.println(todo);
                    break;
                case 4:
                    kjorer = false;
                    break;
            }
        }

    }

    private static void printList(List<String> todo) {
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i));
        }
    }
}