package com.zp.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTest {

    /**
     * 生成activiti的表
     */
    @Test
    public void testTableCreate(){
        // 创建processEngineConfiguration
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        // 创建processEngine
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();

        // 完成以上两步即会生成表
        System.out.println(processEngine);
    }
}
