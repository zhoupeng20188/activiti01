package com.zp.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 当前用户的任务完成
 */
public class ActivitiTaskComplete {
    public static void main(String[] args) {


//        String assignee = "zhangsan";
        String assignee = "lisi";


        // 得到runtimeService
        TaskService taskService = ActivitiUtil.getTaskService();


        List<Task> list = taskService.createTaskQuery().processDefinitionKey("qingjia")
                .taskAssignee(assignee)
                .list();
        for (Task task : list) {
            String taskId = task.getId();
            System.out.println("任务id为" + taskId);
            System.out.println("任务名为" + task.getName());
            System.out.println("任务指派人为" + task.getAssignee());
            System.out.println("任务所在的流程实例id为" + task.getProcessInstanceId());

            // 处理任务 参数为任务id
            taskService.complete(taskId);
        }

    }
}
