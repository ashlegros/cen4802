package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonalTaskManagerApplicationTests {

    @Test
    void addingATaskShouldAddATaskToTheService(){
        TaskService taskService = new TaskService();

        Task newTask = new Task(1 ,"Testing the adding feature", "Low");

        taskService.addTask(newTask.getTitle(),  newTask.getPriority());

        assertEquals(1, taskService.getAllTasks().size());
        assertEquals(newTask.getTitle(),taskService.getAllTasks().get(0).getTitle());
    }

    @Test
    void updatingATaskCompletionShouldTurnStatusToTrue(){
        TaskService taskService = new TaskService();

        taskService.addTask("Testing the completion status feature", "High");

        Task newTask = taskService.getAllTasks().get(0);

        taskService.updateTaskCompletionStatus(newTask.getId());

        assertTrue(newTask.isCompleted());
    }

    @Test
    void deletingATaskShouldRemoveATaskFromTheService(){
        TaskService taskService = new TaskService();

        Task newTask = new Task(1 ,"Testing the delete feature",  "High");

        taskService.addTask(newTask.getTitle(),   newTask.getPriority());

        taskService.deleteTask(newTask.getId());

        assertEquals(0, taskService.getAllTasks().size());
    }
    @Test
    void remainingTaskCountShouldOnlyIncludeIncompleteTasks() {
        TaskService taskService = new TaskService();

        taskService.addTask("Incomplete task", "Low");
        taskService.addTask("Completed task", "Low");

        taskService.updateTaskCompletionStatus(2);

        assertEquals(2, taskService.getRemainingTasks()); //Controlled Error: Change task count to 2 instead of 1
    }
}
