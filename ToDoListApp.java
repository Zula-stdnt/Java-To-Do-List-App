
import java.util.Scanner;

public class ToDoListApp {
    static String[] tasks = new String[10]; 
    static boolean[] isCompleted = new boolean[10]; 
    static int taskCount = 0; 
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Comleted");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    viewTasks();
                    break;  
                case 5:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addTask() {
        if (taskCount >= tasks.length) {
            System.out.println("Task list is full!");
            return;
        }

        System.out.print("Enter task description: ");
        tasks[taskCount] = scanner.nextLine();
        isCompleted[taskCount] = false;
        taskCount++;
        System.out.println("Task added successfully!");
    }

    static void removeTask() {
        if (taskCount == 0) {
            System.out.println("No tasks to remove.");
            return;
        }

        viewTasks();
        System.out.print("Enter task number to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > taskCount) {
            System.out.println("Invalid task number.");
            return;
        }

        for (int i = index - 1; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
            isCompleted[i] = isCompleted[i + 1];
        }

        taskCount--;
        System.out.println("Task removed successfully!");
    }

    static void markTaskCompleted() {
        if (taskCount == 0) {
            System.out.println("No tasks to mark as completed.");
            return;
        }

        viewTasks();
        System.out.print("Enter task number to mark as completed: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > taskCount) {
            System.out.println("Invalid task number.");
            return;
        }

        isCompleted[index - 1] = true;
        System.out.println("Task marked as completed!");
    }

    static void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n-------------------------------------------------------");
        System.out.printf("| %-5s | %-30s | %-10s |\n", "No.", "Task", "Status");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < taskCount; i++) {
            String status = isCompleted[i] ? "Completed" : "Pending";
            System.out.printf("| %-5d | %-30s | %-10s |\n", (i + 1), tasks[i], status);
        }

        System.out.println("-------------------------------------------------------");
    }
}
