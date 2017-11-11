package com.enble.presenter;

import com.enble.model.Activity;
import com.enble.model.Shetuan;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public interface MainViewPresenter extends BasePresenter {

    ArrayList<String> getAllShetuanName();

    ArrayList<String> getAllActivityName();

    Shetuan getTargetShetuanByName(String targetShetuanName);

    Activity getTargetActivityByName(String targetActivityName);
}
