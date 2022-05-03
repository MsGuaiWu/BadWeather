package com.cl.badweather.view.horizonview;

/**
 * 定义滑动监听接口
 * @author: cl
 * @date: 2022/5/1
 */
public interface ScrollWatched {
    void addWatcher(ScrollWatcher watcher);
    void removeWatcher(ScrollWatcher watcher);
    void notifyWatcher(int x);
}
