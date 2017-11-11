package com.enble.model;

import com.enble.presenter.MainViewPresenter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class ModelCompl implements Model {

    private MainViewPresenter mPresenter;

    public ModelCompl(MainViewPresenter presenter) {
        this.mPresenter = presenter;
    }
    @Override
    public ArrayList<Shetuan> loadAllShetuan() {
        ArrayList<Shetuan> shetuanList = new ArrayList<Shetuan>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("社团表.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到文件");
        }
        InputStreamReader input= new InputStreamReader(fileInputStream, Charset.forName("gbk"));
        BufferedReader br = new BufferedReader(input);

        String line;
        String shetuanName;
        String createTime;
        String mainPerson;
        String phoneNumber;
        String mail;
        ArrayList<String> shetuanMemberNameList = new ArrayList<String>();
        ArrayList<String> shetuanActivityNameList = new ArrayList<String>();
        String headline;

        try {
            line = br.readLine();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                //最后的介绍一栏可能有多个逗号，所以加个分隔上限mmp
                String[] info = line.split(",", 8);
                //操作需分割成功
                if (info.length > 1) {
                    shetuanName = info[0];
                    createTime = info[1];
                    mainPerson = info[2];
                    phoneNumber = info[3];
                    mail = info[4];
                    //社团人员姓名列表
                    String[] nameInfo = info[5].split("、");
                    for (String memberName : nameInfo) {
                        shetuanMemberNameList.add(memberName);
                    }

                    String[] activityInfo = info[6].split("、");
                    for (String activityName: activityInfo) {
                        shetuanActivityNameList.add(activityName);
                    }
                    headline = info[7];
                    Shetuan shetuan = new Shetuan(shetuanName, createTime, mainPerson, phoneNumber, mail, new ArrayList<String>(shetuanMemberNameList), new ArrayList<String>(shetuanActivityNameList), headline);
                    //System.out.println(shetuan.toString());
                    shetuanList.add(shetuan);
                    shetuanActivityNameList.clear();
                    shetuanMemberNameList.clear();
                }
            }
            br.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        }
        return shetuanList;
    }

    @Override
    public ArrayList<Activity> loadAllActivity() {
        ArrayList<Activity> activityList = new ArrayList<Activity>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("活动表.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到文件");
        }
        InputStreamReader input= new InputStreamReader(fileInputStream, Charset.forName("gbk"));
        BufferedReader br = new BufferedReader(input);

        String line;
        String activityName;
        String startTime;
        String place;
        String Shetuan;
        String xuanchuan;
        String beizhu;
        try {
            line = br.readLine();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                //操作需分割成功
                if (info.length > 1) {
                    activityName = info[0];
                    startTime = info[1];
                    place = info[2];
                    Shetuan = info[3];
                    xuanchuan = info[4];
                    //备注可能为空
                    if (info.length==6) {
                        beizhu = info[5];
                    } else {
                        beizhu = "无介绍";
                    }

                    Activity activity = new Activity(activityName,startTime,place,Shetuan,xuanchuan,beizhu);
                    activityList.add(activity);
                    //System.out.println(activity.toString());
                }

            }
            br.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        }
        return activityList;
    }
}
