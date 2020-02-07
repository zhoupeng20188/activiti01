package com.zp.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 当前用户的任务列表查询
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {


        String assignee = "zhangsan";


        // 创建processEngine
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 得到runtimeService
        TaskService taskService = defaultProcessEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery().processDefinitionKey("qingjia")
                .taskAssignee(assignee)
                .list();
        // 只有一个任务可以用singleResult
        for (Task task : list) {
            System.out.println("任务id为" + task.getId());
            System.out.println("任务名为" + task.getName());
            System.out.println("任务指派人为" + task.getAssignee());
            System.out.println("任务所在的流程实例id为" + task.getProcessInstanceId());
        }
    }
}
