package com.example.SpringIntegrationGoFHW12.controllers;

import com.example.SpringIntegrationGoFHW12.models.*;
import com.example.SpringIntegrationGoFHW12.services.FileGateway;
import com.example.SpringIntegrationGoFHW12.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final FileGateway fileGateway; // для выполнения первого задания. Можно и удалить, т.к. есть использование spring Integration при записи в логов в файл
    private final TaskService taskService;
//    private final ConsoleLog myLog; //Выбрать, если необходимо выводить сообщения в консоль
    private final FileLog myLog; //Выбрать, если необходимо записывать сообщения в файл

    /**
     * Посмотеть все задачи
     * @return список всех задач
     * */
    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getALLTasks();
    }

    /**
     * Добавить новую задачу. При этом задача записывается в файл,
     * название которого соответствует описанию задачи
     * @return Task
     * */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        myLog.writeLog( "Добавлена новая задача: \n"+ " " + task.toString() + "\n");
//        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());
        return taskService.addTask(task);
    }

     /**
     * Найти задачу по статусу. Задачи с искомым статусом записываются в файл,
      * названый по статусу выполнения задачи
     *  @return список задач
     * */
    @GetMapping("/status/{status}")
    public List<Task> findTaskByStatus(@PathVariable TaskStatus status){
        List<Task> tasks = taskService.findTackByStatus(status);
        for (Task task: tasks) {
            myLog.writeLog( "Найдена следующая задача cо статусом" + status + "\n"+ " " + task.toString() + "\n");
//            fileGateway.writeToFile(task.getStatus() + ".txt", task.toString());
        }
        return tasks;
    }

    /**
     * Изменить задачу. В задачу найденную по id вносятся изменения.
     * Измененная задача дозаписывается в файл соответствующий задаче
     * @return Task
     * */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        myLog.writeLog( "Изменена задача с id = " + id + ":"+ "\n"+ " " + task.toString() + "\n");
//        fileGateway.writeToFile(task.getDescription() + ".txt", "\n Обнавленная задача: \n" + task.toString());
        return taskService.changeTask(id, task);
    }

    /**
     * Удалить задачу по ID
     * @return Task
     * */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
