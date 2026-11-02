import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean kjorer = true;
        Scanner sc  = new Scanner(System.in);

        List<Task> todo = new ArrayList();

        Task task1 = new Task("Gå gym", "dra til gymmen idiot");
        todo.add(task1);

        while (kjorer) {
            // TODO: legg til en sjekk som validerer om et nummer ble skrevet
            printMenu();

            int valg = Integer.parseInt(sc.nextLine());
            switch (valg) {
                case 1:
                    printList(todo);
                    break;
                case 2:
                    addIteam(todo, sc);

                    break;
                case 3:
                    deleteIteam(todo, sc);

                    break;
                case 4:
                    kjorer = false;
                    break;
            }
        }

    }

    private static void printList(List<Task> todo) {
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i));
        }
    }

    private static void addIteam (List<Task> todo, Scanner sc) {
        System.out.print("Enter task tittle: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task newTask = new Task(title, description);

        todo.add(newTask);
    }

    private static void deleteIteam(List<Task> todo, Scanner sc){
        System.out.println("What number the id of the iteam you want to delete?: ");
        int id = Integer.parseInt(sc.nextLine());
        todo.remove(id-1);
    }

    private static void printMenu() {
        System.out.println("1: Show the list \n" +
                "2: Add to the list \n" +
                "3: remove from list \n" +
                "4: End program");
        System.out.print("Enter your choice: ");
    }

    public static void saveTasks(List<Task> todo){

    }
}