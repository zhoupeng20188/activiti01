package com.zp.activiti.variable;

import com.zp.activiti.util.ActivitiUtil;

/**
 * 当holidayNum <= 3时，不会走到总经理审核，所以m2没有任务
 * 当holidayNum > 3时，就会走到总经理审核，所以m2有任务
 */
public class VariableTest {
    public static void main(String[] args) {
        String key = "qingjia3";
//        ActivitiUtil.taskQuery(key, "m2");
        ActivitiUtil.taskComplete(key, "t1");
        ActivitiUtil.taskComplete(key, "m1");
        ActivitiUtil.taskComplete(key, "m2");

    }
}
