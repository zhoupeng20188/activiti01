package com.zp.activiti.gateway;

import com.zp.activiti.util.ActivitiUtil;

/**
 * 并行网关会并行进行后面的任务，当后面的任务都执行完时才会学汇聚
 *
 */
public class parallelGatewayTest {
    public static void main(String[] args) {
        String key = "qingjia6";
        ActivitiUtil.taskComplete(key, "t1");
        ActivitiUtil.taskComplete(key, "m1");
        ActivitiUtil.taskComplete(key, "m2");
        ActivitiUtil.taskComplete(key, "r1");
        // n1,n2并行执行
        // 当n1,n2都执行完时才会到最后
        ActivitiUtil.taskComplete(key, "n1");
        ActivitiUtil.taskComplete(key, "n2");
    }
}
