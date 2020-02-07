package com.zp.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

public class SuspendSingleProcessInstance {
    public static void main(String[] args) {
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();

        ProcessInstance processInstance = processInstanceQuery
                .processInstanceBusinessKey("1001")
                .singleResult();

        boolean suspended = processInstance.isSuspended();

        String processInstanceId = processInstance.getId();

        if(suspended){
            runtimeService
                    .activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例被" + processInstanceId + "激活");
        } else {
            runtimeService
                    .suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例被" + processInstanceId + "挂起");
        }
    }
}
