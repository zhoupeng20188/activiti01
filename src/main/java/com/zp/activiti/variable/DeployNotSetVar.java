package com.zp.activiti.variable;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;

public class DeployNotSetVar {
    public static void main(String[] args) {
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        String key = "qingjia3";

        ActivitiUtil.deploy(key, "请假流程");

        runtimeService.startProcessInstanceByKey(key);

        System.out.println("启动成功");


    }
}
