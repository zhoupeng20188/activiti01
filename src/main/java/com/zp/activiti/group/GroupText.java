package com.zp.activiti.group;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import com.zp.activiti.util.ActivitiUtil;

/**
 * 总经理审核现在是三个候选人
 * 候选人不能直接完成任务，需要其中一人先拾取任务才能执行
 * @author zhouyao
 *
 */
public class GroupText {
	public static void main(String[] args) {
		
		String key = "qingjia4";
		
		// 先执行完t1和m1
		ActivitiUtil.taskComplete(key, "t1");
		ActivitiUtil.taskComplete(key, "m1");
		
		// 到总经理审批时
		TaskService taskService = ActivitiUtil.getTaskService();
		
		
		String candidateUser = "c2";
		
		List<Task> list = taskService.createTaskQuery()
					.processDefinitionKey(key)
					.taskCandidateUser(candidateUser)
//					.singleResult();
					.list();
		for(Task task: list) {
			// 此时输出为null，说明c2只是候选人，不是任务的执行人
			System.out.println(task.getAssignee());
			
			String taskId = task.getId();
			
			// c2拾取任务，拾取任务完成后即变成了任务执行者
			taskService.claim(taskId,candidateUser);	
			System.out.println(candidateUser + "拾取任务成功");
			
			// c2完成任务
//			ActivitiUtil.taskComplete(key, candidateUser);
			
			// c2放弃任务，归还任务
//			taskService.setAssignee(taskId, null);
			
			// c2将任务指定给c3
			taskService.setAssignee(taskId, "c3");
			
			// c3完成任务
			ActivitiUtil.taskComplete(key, "c3");
			
			
		}
							
		
	}
}
