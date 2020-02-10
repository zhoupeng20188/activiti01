package com.zp.activiti.variable;

import com.zp.activiti.util.ActivitiUtil;

import java.util.HashMap;

/**
 * 当holidayNum <= 3时，不会走到总经理审核，所以m2没有任务
 * 当holidayNum > 3时，就会走到总经理审核，所以m2有任务
 */
public class VariableTest2 {
    public static void main(String[] args) {
        String key = "qingjia3";
//        ActivitiUtil.taskQuery(key, "m2");
        ActivitiUtil.taskComplete(key, "t1");
        HashMap<String, Object> map = new HashMap<>();
        Holiday holiday = new Holiday();
        holiday.setNum(5);
        map.put("holiday",holiday);
        ActivitiUtil.taskComplete(key, "m1", map);
        ActivitiUtil.taskComplete(key, "m2");
        ActivitiUtil.taskComplete(key, "r1");

    }
}
