package com.zp.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例
 *  提前是完成部署
 */
public class ActivtiStartInstance {
    public static void main(String[] args) {
        // 创建processEngine
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 得到runtimeService
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        // 启动实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia");

        System.out.println(processInstance.getDeploymentId());
        System.out.println("流程实例id" + processInstance.getId());
        System.out.println(processInstance.getActivityId());
        System.out.println(processInstance.getName());


    }
}
