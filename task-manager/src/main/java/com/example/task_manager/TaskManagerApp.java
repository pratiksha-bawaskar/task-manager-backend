package com.example.task_manager;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class TaskManagerApp implements CommandLineRunner {

    private final TaskService service = new TaskService();

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Task Manager Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Description: ");
                    String desc = scanner.nextLine();
                    service.addTask(new Task(id, desc));
                }
                case 2 -> service.viewTasks();
                case 3 -> {
                    System.out.print("Enter Task ID to delete: ");
                    int id = scanner.nextInt();
                    service.deleteTask(id);
                }
                case 4 -> {
                    running = false;
                    System.out.println("Exiting Task Manager...");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}