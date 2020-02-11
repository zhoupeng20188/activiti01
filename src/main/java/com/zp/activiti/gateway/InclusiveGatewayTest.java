package com.zp.activiti.gateway;

import com.zp.activiti.util.ActivitiUtil;

/**
 * 包含网关相当于排它网关和并行网关的结合体
 * 包含网关可以设置条件，满足条件的可以走多个分支，分支里的所有任务都执行完后再汇聚
 * 并行网关是无视条件执行所有分支的
 *
 */
public class InclusiveGatewayTest {
    public static void main(String[] args) {
        String key = "tijian";
        ActivitiUtil.taskComplete(key, "t1");
        // userType=2，所以会执行t2,t3,t4,t5
        ActivitiUtil.taskComplete(key, "t2");
        ActivitiUtil.taskComplete(key, "t3");
        ActivitiUtil.taskComplete(key, "t4");
        ActivitiUtil.taskComplete(key, "t5");
    }
}
