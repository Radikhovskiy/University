package bots.crew.juniortask;

import static bots.crew.juniortask.JuniorTaskApplication.exit;

import bots.crew.juniortask.entity.Department;
import bots.crew.juniortask.entity.Lector;
import bots.crew.juniortask.service.DepartmentService;
import bots.crew.juniortask.service.LectorService;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {
    private Initializer initializer;
    private LectorService lectorService;
    private DepartmentService departmentService;

    @Autowired
    public App(Initializer initializer, DepartmentService departmentService,
                                 LectorService lectorService) {
        this.initializer = initializer;
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public App() {
    }

    public void run() {
        initializer.initialize();
        Set<String> departments = new HashSet<>();
        for (Department department: departmentService.getAll()) {
            departments.add(department.getName());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("You want to get info about department or find lector?");
        System.out.println("Enter: department/lector");
        System.out.println("To close the program, enter the 'exit'");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("department")) {
            System.out.println("What operation do you want to perform? Enter:");
            System.out.println("Get a head of department");
            System.out.println("Get statistic");
            System.out.println("Show the average salary");
            System.out.println("Show count of employee");
            System.out.println("To close the program, enter the 'exit'");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Get a head of department")) {
                System.out.println("Enter one of the departments: "
                                + departments);
                System.out.println("To close the program, enter the 'exit'");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    exit = false;
                }
                if (departmentService.getByName(input) != null) {
                    Department department = departmentService.getByName(input);
                    System.out.println(departmentService.getHeadOfDepartment(department) + "\n");
                } else if (exit) {
                    System.out.println("Such a department doesn't exist.");
                }
            } else if (input.equalsIgnoreCase("Get statistic")) {
                System.out.println("Enter one of the departments: "
                        + departments);
                System.out.println("To close the program, enter the 'exit'");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    exit = false;
                }
                if (departmentService.getByName(input) != null) {
                    Department department = departmentService.getByName(input);
                    System.out.println(departmentService.getStatistic(department) + "\n");
                } else if (exit) {
                    System.out.println("Such a department doesn't exist.");
                }
            } else if (input.equalsIgnoreCase("Show the average salary")) {
                System.out.println("Enter one of the departments: "
                        + departments);
                System.out.println("To close the program, enter the 'exit'");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    exit = false;
                }
                if (departmentService.getByName(input) != null) {
                    Department department = departmentService.getByName(input);
                    System.out.println(departmentService.getAverageSalary(department) + "\n");
                } else if (exit) {
                    System.out.println("Such a department doesn't exist.");
                }
            } else if (input.equalsIgnoreCase("Show count of employee")) {
                System.out.println("Enter one of the departments: "
                        + departments);
                System.out.println("To close the program, enter the 'exit'");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    exit = false;
                }
                if (departmentService.getByName(input) != null) {
                    Department department = departmentService.getByName(input);
                    System.out.println(departmentService.getCountOfEmployee(department) + "\n");
                } else if (exit) {
                    System.out.println("Such a department doesn't exist.");
                }
            } else if (input.equals("exit")) {
                exit = false;
            } else {
                System.out.println("Incorrect input. "
                        + "Enter commands above or 'exit' to close the program.");
                System.out.println("Press enter");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    exit = false;
                }
            }
        } else if (input.equalsIgnoreCase("lector")) {
            System.out.println("To find a lecturer by name or surname, enter template.");
            System.out.println("To close the program, enter the 'exit'");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                exit = false;
            }
            if (lectorService.getLectorsByTemplate(input).isEmpty() && exit) {
                System.out.println("No lecturers found by template " + input);
            }
            for (Lector lector : lectorService.getLectorsByTemplate(input)) {
                System.out.println(lector.getName() + " " + lector.getLastName());
            }
        } else if (input.equals("exit")) {
            exit = false;
        } else {
            System.out.println("Incorrect input. "
                    + "Enter commands above or 'exit' to close the program.");
            System.out.println("Press enter");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                exit = false;
            }
        }
    }
}
