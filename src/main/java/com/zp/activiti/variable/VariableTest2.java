package com.zp.activiti.variable;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

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


        // 通过runtimeService的setVariable和setVariables也可以设置变量,第一个参数为流程实例id
//        通过setVariableLocal也可以设置局部变量
        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();
//        runtimeService.setVariable();
//        runtimeService.setVariables();


        // 通过taskService的setVariable和setVariables也可以设置变量,第一个参数为任务id
//        通过setVariableLocal也可以设置局部变量,局部变量只在当前节点有效
        TaskService taskService = ActivitiUtil.getTaskService();
//        taskService.setVariable();
//        taskService.setVariables();
    }
}
