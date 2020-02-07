package com.zp.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * 历史记录查询
 */
public class HistroyQuery {
    public static void main(String[] args) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        HistoryService historyService = defaultProcessEngine.getHistoryService();

        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();

        List<HistoricActivityInstance> list = historicActivityInstanceQuery.processInstanceId("2501").list();

        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println("=======");
            System.out.println(historicActivityInstance.getActivityId());
            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getAssignee());
            System.out.println("=======");
        }
    }
}
