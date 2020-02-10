package com.zp.activiti.assingnee;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;

public class AssingneeUEL {
    public static void main(String[] args) {
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        HashMap map = new HashMap<>();

        map.put("assignee", "a2");

        runtimeService.startProcessInstanceByKey("qingjia2", map);
    }
}
