package com.zp.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class BusinessKeyAdd {
    public static void main(String[] args) {


        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        // 第一个参数为流程的key
        // 第二个参数为business key,即业务表的id
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("qingjia", "1001");

        System.out.println("business key is " + processInstance.getBusinessKey());
    }
}
