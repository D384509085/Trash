package com.enble.view;

import com.enble.model.Activity;
import com.enble.model.SortedMethod;
import com.enble.presenter.AdminViewPresenter;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
public interface AdminView extends BaseView<AdminViewPresenter>{

    void showMemberOrderByShetuanName(String shetuanName);

    void showSortedShetuan(SortedMethod method);

    void addMessageToActivity(String msg, String activityName);
}
