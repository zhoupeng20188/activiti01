package com.zp.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

/**
 * 流程定义删除
 *     注意：1.如果流程没有走完，删除流程时会失败
 *          2.如果这时要强制删除，可以将deleteDeployment方法的第二个参数设为true
 *          第二个参数为true代表级联删除，先删除没有完成的流程节点，最后再删除流程定义
 */
public class DeleteProcessDefinition {
    public static void main(String[] args) {

        RepositoryService repositoryService = ActivitiUtil.getRepositoryService();

        // 流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionKey("qingjia")
                .orderByProcessDefinitionVersion()
                .desc()
                .singleResult();

        // 流程部署id
        String deploymentId = processDefinition.getDeploymentId();


        // 删除流程定义，参数为流程部署id
        repositoryService.deleteDeployment(deploymentId);
    }
}
