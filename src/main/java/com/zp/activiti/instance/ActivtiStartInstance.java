package com.zp.activiti.instance;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例
 *  提前是完成部署
 */
public class ActivtiStartInstance {
    public static void main(String[] args) {

        // 得到runtimeService
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        // 启动实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia");

        System.out.println(processInstance.getDeploymentId());
        System.out.println("流程实例id" + processInstance.getId());
        System.out.println(processInstance.getActivityId());
        System.out.println(processInstance.getName());


    }
}
