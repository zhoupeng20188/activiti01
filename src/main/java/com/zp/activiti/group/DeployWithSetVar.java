package com.zp.activiti.group;

import com.zp.activiti.bean.Holiday;
import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;

public class DeployWithSetVar {
    public static void main(String[] args) {
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        String key = "qingjia4";

        ActivitiUtil.deploy(key);

        HashMap<String, Object> map = new HashMap<>();
        Holiday holiday = new Holiday();
        // 流程启动时就设置变量
//        holiday.setNum(1);
        holiday.setNum(5);
        map.put("holiday",holiday);

        runtimeService.startProcessInstanceByKey(key, map);

        System.out.println("启动成功");


    }
}
