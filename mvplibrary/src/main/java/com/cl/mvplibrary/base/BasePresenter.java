package com.cl.mvplibrary.base;

import java.lang.ref.WeakReference;

/**
 * Presenter基类 操作视图View
 * @author: cl
 * @date: 2022/3/9
 */
public class BasePresenter<V extends BaseView> {
    private WeakReference<V> mWeakReference;
    private V mView;
    /**
     * @description 关联view
     * @param v
     * @return
     * @author cl
     * @time 2022/3/9 17:28
     */
    public void attach(V v){
        mWeakReference = new WeakReference<V>(v);
    }
    /**
     * @description 分离view
     * @param v
     * @return
     * @author cl
     * @time 2022/3/9 18:07
     */
    public void detach(V v){
        if (mWeakReference != null){
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

    /**
     * 获取view
     * @return
     */
    public V getView(){
        if (mWeakReference != null){
            return mWeakReference.get();
        }
        return null;
    }
}
