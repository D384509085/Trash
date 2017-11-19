package com.enble.presenter;

import com.enble.model.Activity;
import com.enble.model.Model;
import com.enble.model.ModelImpl;
import com.enble.model.Shetuan;
import com.enble.view.MainView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class MainViewPresenterImpl implements MainViewPresenter{

    private MainView mView;

    private Model mModel;

    public MainViewPresenterImpl(MainView view) {
        mView = view;
        mModel = new ModelImpl(this);
    }

    @Override
    public ArrayList<String> getAllShetuanName() {
        ArrayList<Shetuan> allShetuan = mModel.loadAllShetuan();
        ArrayList<String> allShetuanName = new ArrayList<String>();
        for (Shetuan shetuan:allShetuan) {
            allShetuanName.add(shetuan.getShetuanName());
        }
        return allShetuanName;
    }

    @Override
    public ArrayList<String> getAllActivityName() {
        ArrayList<Activity> allActivity = mModel.loadAllActivity();
        ArrayList<String> allActivityName = new ArrayList<String>();
        for (Activity activity:allActivity) {
            allActivityName.add(activity.getActivityName());
        }
        return allActivityName;
    }

    @Override
    public Shetuan getTargetShetuanByName(String targetShetuanName) {
        ArrayList<Shetuan> allShetuan = mModel.loadAllShetuan();
        for (Shetuan shetuan : allShetuan) {
            if (shetuan.getShetuanName().equals(targetShetuanName)) {
                return shetuan;
            }
        }
        System.out.println("未找到目标社团:"+targetShetuanName);
        System.out.println();
        return null;
    }

    @Override
    public Activity getTargetActivityByName(String targetActivityName) {
        ArrayList<Activity> allActivity = mModel.loadAllActivity();
        for (Activity activity: allActivity) {
            if (activity.getActivityName().equals(targetActivityName)) {
                return activity;
            }
        }
        System.out.println("未找到目标活动:"+targetActivityName);
        System.out.println();
        return null;
    }
}
