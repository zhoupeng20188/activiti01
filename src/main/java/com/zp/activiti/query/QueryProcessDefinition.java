package com.zp.activiti.query;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * 流程定义基本信息查询
 */
public class QueryProcessDefinition {
    public static void main(String[] args) {
        List<ProcessDefinition> list = ActivitiUtil.getProcessDefinitionList("qingjia");

        for (ProcessDefinition processDefinition : list) {
            System.out.println(processDefinition.getId());
            System.out.println(processDefinition.getKey());
            System.out.println(processDefinition.getName());
            System.out.println(processDefinition.getVersion());
            System.out.println("流程部署id为" + processDefinition.getDeploymentId());
        }


    }
}
