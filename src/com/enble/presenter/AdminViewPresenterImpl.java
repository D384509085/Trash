package com.enble.presenter;

import com.enble.model.*;
import com.enble.view.AdminView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
public class AdminViewPresenterImpl implements AdminViewPresenter {

    private AdminView mAdminView;

    private Model mModel;

    public AdminViewPresenterImpl(AdminView adminView) {
        this.mAdminView = adminView;
        mModel = new ModelImpl(this);
    }

    @Override
    public ArrayList<String> getMemberList(String shetuanName) {
        ArrayList<Shetuan> shetuanList = mModel.loadAllShetuan();
        for (Shetuan shetuan : shetuanList) {
            if (shetuan.getShetuanName().equals(shetuanName)) {
                return shetuan.getShetuanMemberName();
            }
        }
        System.out.println("找不到目标社团");
        return null;
    }

    @Override
    public ArrayList<Shetuan> getSortedShetuan(SortedMethod method) {
        ArrayList<Shetuan> shetuanList = mModel.loadAllShetuan();
        Shetuan.setmSortedMethod(method);
        shetuanList.sort(Shetuan::compareTo);
        return shetuanList;

    }

    @Override
    public Activity findActivityByName(String activityName) {
        ArrayList<Activity> activityList = mModel.loadAllActivity();
        for (Activity activity : activityList) {
            if (activity.getActivityName().equals(activityName)) {
                return activity;
            }
        }
        System.out.println("未找到目标活动");
        return null;
    }
}
