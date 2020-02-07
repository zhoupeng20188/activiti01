package com.zp.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class QueryBpmnFile {
    public static void main(String[] args) throws IOException {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();

        // 流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionKey("qingjia")
                .orderByProcessDefinitionVersion()
                .desc()
                .singleResult();

        // 流程部署id
        String deploymentId = processDefinition.getDeploymentId();


        // getResourceAsStream
        // 第二个参数为getResourceName时为bpmn
        // 第二个参数为getDiagramResourceName时为png
        InputStream bpmnStream = repositoryService
                .getResourceAsStream(deploymentId, processDefinition.getResourceName());

        InputStream pngStream = repositoryService
                .getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());

        // 注意：processDefinition.getResourceName()和processDefinition.getDiagramResourceName()
        // 取得的路径可能是多级的，在new FileOutputStream时不能用多级的，不然会报错
        // 比如取出的resourceName为processes/qingjia.bpmn,这时如果指定一个文件夹路径，
        // 后面拼上processes/qingjia.bpmn时会报错，但拼上qingjia.bpmn就可以
        FileOutputStream bpmnOutput =
                new FileOutputStream("/users/zhouyao/Documents/qingjia.bpmn");

        FileOutputStream pngOutput =
                new FileOutputStream("/users/zhouyao/Documents/qingjia.png");

        // 使用common-io包来保存文件
        IOUtils.copy(bpmnStream, bpmnOutput);
        IOUtils.copy(pngStream, pngOutput);

        // 关闭流
        bpmnStream.close();
        pngStream.close();
        bpmnOutput.close();
        pngOutput.close();

    }
}
