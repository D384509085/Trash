package com.enble.view;

import com.enble.model.Activity;
import com.enble.model.Shetuan;
import com.enble.presenter.MainViewPresenter;
import com.enble.presenter.MainViewPresenterCompl;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class MainViewCompl implements MainView {

    private MainViewPresenter mPresenter;

    public MainViewCompl() {
        setPresenter(new MainViewPresenterCompl(this));
    }
    @Override
    public void setPresenter(MainViewPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showAllShetuan() {
        ArrayList<String> allShetuanName = mPresenter.getAllShetuanName();
        System.out.println("现在显示所有社团列表");
        for (String shetuanName : allShetuanName) {
            System.out.println(shetuanName);
        }
    }

    @Override
    public void showAllActivity() {
        ArrayList<String> allActivityName = mPresenter.getAllActivityName();
        System.out.println("现在显示所有活动列表");
        System.out.println();
        for (String activityName :  allActivityName) {
            System.out.println(activityName);
        }
    }

    @Override
    public void showTargetShetuanByName(String targetName) {
        System.out.println();
        System.out.println("现在查找目标社团");
        Shetuan targetShetuan = mPresenter.getTargetShetuanByName(targetName);
        System.out.println();
        if (targetShetuan != null) {
            System.out.println(targetShetuan.toString());
        }
    }

    @Override
    public void showTargetActivityByName(String targetActivityName) {
        System.out.println();
        System.out.println("现在查找目标活动");
        Activity targetActivity = mPresenter.getTargetActivityByName(targetActivityName);
        if (targetActivity != null) {
            System.out.println(targetActivity.toString());
        }
    }
}
