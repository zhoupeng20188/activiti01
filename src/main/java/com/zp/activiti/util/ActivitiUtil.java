package com.zp.activiti.util;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;

public class ActivitiUtil {

    public static ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 获取ProcessDefinition
     * @param processDefinitionKey
     * @return
     */
    public static ProcessDefinition getProcessDefinition(String processDefinitionKey){

        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();

        // 流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionKey(processDefinitionKey)
                .orderByProcessDefinitionVersion()
                .desc()
                .singleResult();

        return processDefinition;
    }

    /**
     * 获取ProcessDefinition列表
     * @param processDefinitionKey
     * @return
     */
    public static List<ProcessDefinition> getProcessDefinitionList(String processDefinitionKey){

        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();

        // 流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey(processDefinitionKey)
                .orderByProcessDefinitionVersion()
                .desc()
                .list();

        return list;
    }

    public static RepositoryService getRepositoryService(){

        return defaultProcessEngine.getRepositoryService();
    }

    public static RuntimeService getRuntimeService(){

        return defaultProcessEngine.getRuntimeService();
    }

    public static HistoryService getHistoryService(){

        return defaultProcessEngine.getHistoryService();
    }

    public static TaskService getTaskService(){

        return defaultProcessEngine.getTaskService();
    }

    /**
     * 流程部署
     * @param bpmnName
     */
    public static void deploy(String bpmnName){

        RepositoryService repositoryService = getRepositoryService();

        // 进行部署
        Deployment deployment = repositoryService.createDeployment()
                // 文件夹的名称不能是process
                .addClasspathResource("processes/" + bpmnName + ".bpmn")
                .name("请假流程")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    /**
     * 指定key的流程指派assignee完成任务
     * @param key
     * @param assignee
     */
    public static void taskComplete(String key, String assignee){
        // 得到runtimeService
        TaskService taskService = getTaskService();


        List<Task> list = taskService.createTaskQuery().processDefinitionKey(key)
                .taskAssignee(assignee)
                .list();
        for (Task task : list) {
            String taskId = task.getId();
            System.out.println("任务id为" + taskId);
            System.out.println("任务名为" + task.getName());
            System.out.println("任务指派人为" + task.getAssignee());
            System.out.println("任务所在的流程实例id为" + task.getProcessInstanceId());
            System.out.println("任务完成");
            // 处理任务 参数为任务id
            taskService.complete(taskId);
        }
    }

    /**
     * 指定key的流程指派assignee完成任务,并带上map参数
     * @param key
     * @param assignee
     */
    public static void taskComplete(String key, String assignee, HashMap map){
        // 得到runtimeService
        TaskService taskService = getTaskService();


        List<Task> list = taskService.createTaskQuery().processDefinitionKey(key)
                .taskAssignee(assignee)
                .list();
        for (Task task : list) {
            String taskId = task.getId();
            System.out.println("任务id为" + taskId);
            System.out.println("任务名为" + task.getName());
            System.out.println("任务指派人为" + task.getAssignee());
            System.out.println("任务所在的流程实例id为" + task.getProcessInstanceId());

            // 处理任务 参数为任务id
            taskService.complete(taskId, map);
        }
    }

    public static void taskQuery(String key, String assignee){
        // 得到runtimeService
        TaskService taskService = getTaskService();

        List<Task> list = taskService.createTaskQuery().processDefinitionKey(key)
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
