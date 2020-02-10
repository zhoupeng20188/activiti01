package com.zp.activiti.deploy;

import com.zp.activiti.util.ActivitiUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 部署
 *  即将读取流程图存到数据库中
 */
public class ActivitiDeploy {
    public static void main(String[] args) {
        // 创建repositoryService实例
        RepositoryService repositoryService = ActivitiUtil.getRepositoryService();

        // 进行部署
        Deployment deployment = repositoryService.createDeployment()
                // 文件夹的名称不能是process
                .addClasspathResource("processes/qingjia3.bpmn")
//                .addClasspathResource("processes/qingjia.png")
//                .addClasspathResource("qingjia.bpmn")
//                .addClasspathResource("qingjia.png")
                .name("请假流程")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }
}
