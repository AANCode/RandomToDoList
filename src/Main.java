import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean kjorer = true;
        Scanner sc  = new Scanner(System.in);


        while (kjorer) {
            // TODO: legg til en sjekk som validerer om et nummer ble skrevet
            printMenu();

            int valg = Integer.parseInt(sc.nextLine());
            switch (valg) {
                case 1:
                    printList();
                    break;
                case 2:
                    addIteam(sc);

                    break;
                case 3:
                    //deleteIteam(sc);

                    break;
                case 4:
                    kjorer = false;
                    break;
            }
        }

    }

    private static void printList() throws IOException {
        /*for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i));
        }*/

        try (BufferedReader br = new BufferedReader(new FileReader("task.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    /*private static void addIteam (List<Task> todo, Scanner sc) {
        System.out.print("Enter task tittle: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task newTask = new Task(title, description);

        todo.add(newTask);
    }*/

    private static void addIteam (Scanner sc) throws IOException {




        System.out.print("Enter task tittle: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task newTask = new Task(title, description);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("task.txt", true))) {
            bw.newLine();
            bw.write(newTask.toString());
        }
        catch (IOException e) {
            System.out.println("Error Writing to file");
        }
    }

    /*private static void deleteIteam(List<Task> todo, Scanner sc){
        System.out.println("What number the id of the iteam you want to delete?: ");
        int id = Integer.parseInt(sc.nextLine());
        todo.remove(id-1);
    }*/

    private static void printMenu() {
        System.out.println("1: Show the list \n" +
                "2: Add to the list \n" +
                "3: remove from list \n" +
                "4: End program");
        System.out.print("Enter your choice: ");
    }

    //BufferedWriter
    public static void saveTasks(List<Task> todo){

    }
}