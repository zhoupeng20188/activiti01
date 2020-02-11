package com.zp.activiti.gateway;

import com.zp.activiti.util.ActivitiUtil;

/**
 * 如果两个条件同时满足，排它网关保证只会走其中一条分支
 * 具体来说，会走xml文件里userTask里id小的那一条分支
 */
public class ExclusiveGatewayTest {
    public static void main(String[] args) {
        String key = "qingjia5";
        ActivitiUtil.taskComplete(key, "t1");
        ActivitiUtil.taskComplete(key, "m1");
        // num现在=5，既满足>3也满足>=1，会走id小的总经理审批分支
        ActivitiUtil.taskComplete(key, "m2");
        ActivitiUtil.taskComplete(key, "r1");
    }
}
