import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean kjorer = true;
        Scanner sc  = new Scanner(System.in);


        while (kjorer) {
            printMenu();

            try {
                int valg = Integer.parseInt(sc.nextLine());
                switch (valg) {
                    case 1:
                        printList();
                        break;
                    case 2:
                        addIteam(sc);

                        break;
                    case 3:
                        deleteIteam(sc);

                        break;
                    case 4:
                        kjorer = false;
                        break;

                    default:
                        System.out.println("############## \n" +
                                            "Invalid input \n" +
                                            "##############");
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("######################### \n" +
                                    "Invalid input, Enter a Number!! \n" +
                                    "#########################");
            }

        }

    }

    private static void printList() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("task.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: finner ikke fil: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: Not tasks yet");
        }
    }


    private static void addIteam (Scanner sc) throws IOException {

        System.out.print("Enter task tittle: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task newTask = new Task(title, description);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("task.txt", true))) {
            bw.write(newTask.toString());
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("Error Writing to file");
        }
    }

    private static void deleteIteam(Scanner sc){
        List<String> lineList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("task.txt"))) {
            String line;

            while ((line= br.readLine()) != null) {
                lineList.add(line);
            }
            if (lineList.size() == 0) {
                System.out.println("The file is Empty and there are no tasks to delete");
                return;
            }
            else {
                for (int i=0; i<lineList.size(); i++) {
                    String text = lineList.get(i);
                    int start = text.indexOf("Title: ");
                    int end = text.indexOf(", Description: ");
                    String printText = text.substring(start + 7, end);

                    System.out.println(i+1+": "+printText);
                }
                System.out.println("What number the id of the iteam you want to delete?: ");
                int id = Integer.parseInt(sc.nextLine());

                lineList.remove(id-1);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Error: finner ikke fil: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error: Not tasks yet");
            return;
        }
        catch (NumberFormatException e) {
            System.out.println("please enter a number " + e.getMessage());
            return;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("please enter a number between 1 and " + lineList.size() + "!");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("task.txt"))) {
            for (int i = 0; i < lineList.size(); i++) {
                bw.write(lineList.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error Writing to file "+ e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("######################### \n" +
                "1: Show the list \n" +
                "2: Add to the list \n" +
                "3: remove from list \n" +
                "4: End program \n" +
                "######################### \n");
        System.out.print("Enter your choice: ");
    }

}