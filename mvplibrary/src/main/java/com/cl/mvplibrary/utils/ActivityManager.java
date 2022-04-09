package com.cl.mvplibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: User
 * @date: 2022/3/8
 * 管理所有的Activity
 */
public class ActivityManager {
    //保存所有创建的Activity
    private List<Activity> allActivities = new ArrayList<>();
    /**
     * @description 添加Activity到管理器
     * @param  activity
     * @return 
     * @author User
     * @time 2022/3/8 21:55
     */
    public void addActivity(Activity activity){
        if (activity != null){
            allActivities.add(activity);
        }
    }
    /**
     * @description 从管理器移除Activity
     * @param activity
     * @return
     * @author User
     * @time 2022/3/8 21:57
     */
    public void removeActivity(Activity activity){
        if (activity != null){
            allActivities.remove(activity);
        }
    }
    /**
     * @description 关闭所有Activity
     * @param
     * @return
     * @author User
     * @time 2022/3/8 22:01
     */
    public void finishAll(){
        for (Activity activity : allActivities){
            activity.finish();
        }
    }
    public Activity getTaskTop(){
        return allActivities.get(allActivities.size() - 1);
    }
}
