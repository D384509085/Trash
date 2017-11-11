package com.enble.view;

import com.enble.model.Activity;
import com.enble.model.Shetuan;
import com.enble.presenter.MainViewPresenter;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public interface MainView extends BaseView<MainViewPresenter>{

    //显示所有的社团
    void showAllShetuan();

    //显示所有的活动
    void showAllActivity();

    //按社团名查找社团
    void showTargetShetuanByName(String targetName);

    //按照活动名查找活动
    void showTargetActivityByName(String targetActivityName);
}
