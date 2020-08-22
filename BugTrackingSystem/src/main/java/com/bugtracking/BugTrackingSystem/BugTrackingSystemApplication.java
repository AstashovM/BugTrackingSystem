package com.bugtracking.BugTrackingSystem;

import com.bugtracking.BugTrackingSystem.entity.Project;
import com.bugtracking.BugTrackingSystem.entity.Task;
import com.bugtracking.BugTrackingSystem.entity.User;
import com.bugtracking.BugTrackingSystem.service.ProjectServiceImpl;
import com.bugtracking.BugTrackingSystem.service.TaskServiceImpl;
import com.bugtracking.BugTrackingSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class BugTrackingSystemApplication implements CommandLineRunner {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ProjectServiceImpl projectService;

	@Autowired
	private TaskServiceImpl taskService;

	@Autowired
	private ConfigurableApplicationContext context;

	private static String projectName;
	private static String userName;
	private boolean isWork = true;
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(BugTrackingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		while (isWork) {
			System.out.println("Write number of the action:\n" +
					"1. Create user\n" +
					"2. Create project\n" +
					"3. Add task\n" +
					"4. Delete project\n" +
					"5. Delete user\n" +
					"6. Delete task\n" +
					"7. Get list of users\n" +
					"8. Get list of projects\n" +
					"9. Get list of tasks in the project\n" +
					"10. Get user's task list\n" +
					"11. Exit");

			String action = scanner.nextLine();
			switch (action) {
				case ("1"):
					System.out.println("Write username");
					userName = scanner.nextLine();
					if (userService.findByUserName(userName) == null) {
						userService.createUser(new User(userName));
						System.out.println("User" + userName + " saved.\n");
					}
					break;
				case ("2"):
					System.out.println("Write name of the project");
					projectName = scanner.nextLine();
					if (projectService.findByProjectName(projectName) == null) {
						projectService.createProject(new Project(projectName));
						System.out.println("Project " + projectName + " saved.\n");
					}
					break;
				case ("3"):
					System.out.println("Write name of the project");
					projectName = scanner.nextLine();
					if (projectService.findByProjectName(projectName) != null) {
						System.out.println("Write theme");
						String theme = scanner.nextLine();
						System.out.println("Write type");
						String type = scanner.nextLine();
						System.out.println("Write priority");
						String priority = scanner.nextLine();
						System.out.println("Write username");
						String userName = scanner.nextLine();
						if (userService.findByUserName(userName) != null) {
							System.out.println("Write description");
							String description = scanner.nextLine();
							taskService.createTask(new Task(projectService.findByProjectName(projectName), theme, type, priority, userService.findByUserName(userName), description));
							System.out.println("Task added.\n");
						}
					}
					System.out.println();
					break;
				case ("4"):
					System.out.println("Write name of the project");
					projectName = scanner.nextLine();
					if (projectService.findByProjectName(projectName) != null) {
						projectService.deleteProject(projectService.findByProjectName(projectName));
						System.out.println("Project " + projectName + " deleted.\n");
					}
					break;
				case ("5"):
					System.out.println("Write username");
					userName = scanner.nextLine();
					if (userService.findByUserName(userName) != null) {
						userService.deleteUser(userService.findByUserName(userName));
						System.out.println("User" + userName + " deleted.\n");
					}
					break;
				case ("6"):
					System.out.println("Write task id");
					if (scanner.hasNextLong()) {
						long id = scanner.nextLong();
						scanner.nextLine();
						if (taskService.findById(id) != null) {
							taskService.deleteTask(taskService.findById(id));
							System.out.println("Task " + id + " deleted.\n");
						}
					} else {
						scanner.nextLine();
						System.out.println("Incorrect value.\n");
					}
					break;
				case ("7"):
					System.out.println("Users:");
					for (User user : userService.findAll()) {
						System.out.println(user.getUserName());
					}
					System.out.println();
					break;
				case ("8"):
					System.out.println("Projects:");
					for (Project project : projectService.findAll()) {
						System.out.println("Project: " + project.getProjectName() + "\nTasks:");
						for (Task task : taskService.findByProject(project)) {
							System.out.println(task.getId() + ": " + task.getDescription());
						}
						System.out.println();
					}
					break;
				case ("9"):
					System.out.println("Write name of the project");
					projectName = scanner.nextLine();
					for (Task task : taskService.findByProject(projectService.findByProjectName(projectName))) {
						task.getByProject();
					}
					break;
				case ("10"):
					System.out.println("Write username");
					userName = scanner.nextLine();
					for (Task task : taskService.findByUser(userService.findByUserName(userName))) {
						task.getByUser();
					}
					break;
				case ("11"):
					isWork = false;
					break;
				default:
					System.out.println("Input correct number\n");
			}
		}
		context.close();
	}
}

