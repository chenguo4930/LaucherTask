package com.cheng.lib.launchertasklib.task;

/**
 * 主线程任务
 *
 * @author Administrator
 */
public abstract class MainTask extends Task {

    @Override
    public boolean runOnMainThread() {
        return true;
    }
}
