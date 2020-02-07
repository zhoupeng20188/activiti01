package com.zp.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

public class ActivitiUtil {

    public static ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

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
}
