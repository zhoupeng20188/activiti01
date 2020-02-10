package com.zp.activiti.definition;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 流程实例的激动与挂起
 * （所有实例）
 */
public class SuspendProcessInstance {
    public static void main(String[] args) {
        ProcessDefinition processDefinition =
                ActivitiUtil.getProcessDefinition("qingjia");

        boolean suspended = processDefinition.isSuspended();

        RepositoryService repositoryService = ActivitiUtil.getRepositoryService();

        String processDefinitionId = processDefinition.getId();

        if(suspended){
            repositoryService
                    .activateProcessDefinitionById(processDefinitionId, true, null);
            System.out.println("流程实例被" + processDefinitionId + "激活");
        } else {
            repositoryService
                    .suspendProcessDefinitionById(processDefinitionId);
            System.out.println("流程实例被" + processDefinitionId + "挂起");
        }
    }
}
