package com.zp.activiti.gateway;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;

public class DeployInclusiveGateway {
    public static void main(String[] args) {
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        String key = "tijian";

        ActivitiUtil.deploy(key, "体检流程");

        HashMap<String, Object> map = new HashMap<>();
        // userType=2代表领导
        Integer userType = 2;
        map.put("userType",userType);

        runtimeService.startProcessInstanceByKey(key, map);

        System.out.println("启动成功");


    }
}
