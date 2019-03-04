package com.cheng.lib.launchertasklib;

import android.os.Looper;
import android.os.MessageQueue;
import com.cheng.lib.launchertasklib.task.DispatchRunnable;
import com.cheng.lib.launchertasklib.task.Task;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 延迟初始化
 */
public class DelayInitDispatcher {

    private Queue<Task> mDelayTasks = new LinkedList<>();

    private MessageQueue.IdleHandler mIdleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            if(mDelayTasks.size()>0){
                Task task = mDelayTasks.poll();
                new DispatchRunnable(task).run();
            }
            return !mDelayTasks.isEmpty();
        }
    };

    public DelayInitDispatcher addTask(Task task){
        mDelayTasks.add(task);
        return this;
    }

    public void start(){
        Looper.myQueue().addIdleHandler(mIdleHandler);
    }

}
