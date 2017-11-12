package com.enble.presenter;

import com.enble.model.Activity;
import com.enble.model.Shetuan;
import com.enble.model.SortedMethod;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
public interface AdminViewPresenter extends BasePresenter {

    ArrayList<String> getMemberList(String shetuanName);

    ArrayList<Shetuan> getSortedShetuan(SortedMethod method);

    Activity findActivityByName(String activityName);
}
