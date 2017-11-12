package com.enble.view;

import com.enble.model.Activity;
import com.enble.model.Shetuan;
import com.enble.model.SortedMethod;
import com.enble.presenter.AdminViewPresenter;
import com.enble.presenter.AdminViewPresenterCompl;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
public class AdminViewCompl implements AdminView {

    private AdminViewPresenter mPresenter;

    public AdminViewCompl() {
        setPresenter(new AdminViewPresenterCompl(this));
    }
    @Override
    public void setPresenter(AdminViewPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMemberOrderByShetuanName(String shetuanName) {
        System.out.println("现在开使查找目标社团");
        ArrayList<String> memberList = mPresenter.getMemberList(shetuanName);
        if (memberList != null) {
            System.out.println("找到该社团了，现在输出其成员列表");
            System.out.println(memberList);
        }
    }

    @Override
    public void showSortedShetuan(SortedMethod method) {
        System.out.println();
        System.out.println("现在以" + method + "为依据对社团进行排序");
        ArrayList<Shetuan> sortedShetuanList = mPresenter.getSortedShetuan(method);
        for (Shetuan shetuan : sortedShetuanList) {
            System.out.println("社团名: " + shetuan.getShetuanName() + ", 社团人数: " + shetuan.getShetuanMemberName().size());
        }

    }

    @Override
    public void addMessageToActivity(String msg, String activityName) {
        Activity activity = mPresenter.findActivityByName(activityName);
        activity.setAddedMsg(msg);
        System.out.println();
        System.out.println("现添加附加消息");
        System.out.println(activity.getActivityName() + " 附加消息是：" + msg);
    }
}
