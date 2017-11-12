package com.enble;

import com.enble.model.Activity;
import com.enble.model.ModelCompl;
import com.enble.model.SortedMethod;
import com.enble.presenter.AdminViewPresenterCompl;
import com.enble.presenter.MainViewPresenterCompl;
import com.enble.view.AdminViewCompl;
import com.enble.view.MainViewCompl;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/11/4 0004.
 */
public class MainClass {
    public static void main(String[] args) {
        MainViewCompl view = new MainViewCompl();
        view.showAllShetuan();
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        view.showAllActivity();
        System.out.println("~~~~~~~~~~~~~~~~~~~");

        view.showTargetShetuanByName("乒乓社");
        view.showTargetShetuanByName("飞机社");

        view.showTargetActivityByName("鬼步教学");
        view.showTargetActivityByName("一起来女装");

        AdminViewCompl admainView = new AdminViewCompl();
        admainView.showMemberOrderByShetuanName("文学社");
        admainView.showSortedShetuan(SortedMethod.MemberNum);
        admainView.addMessageToActivity("送一双滑板鞋", "鬼步教学");
    }
}
