package com.zp.activiti.gateway;

import com.zp.activiti.bean.Holiday;
import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;

public class DeployParallelGateway {
    public static void main(String[] args) {
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        String key = "qingjia6";

        ActivitiUtil.deploy(key, "请假流程");

        HashMap<String, Object> map = new HashMap<>();
        Holiday holiday = new Holiday();
        holiday.setNum(5);
        map.put("holiday",holiday);

        runtimeService.startProcessInstanceByKey(key, map);

        System.out.println("启动成功");


    }
}
