package com.enble.model;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class Activity implements Comparable<Activity>{

    private String activityName;
    private String startTime;
    private String place;
    private String hostShetuan;
    private String headline;
    private String remark;

    public Activity(String activityName, String startTime, String place, String host, String headline, String remark) {
        this.activityName = activityName;
        this.startTime = startTime;
        this.place = place;
        this.hostShetuan = host;
        this.headline = headline;
        this.remark = remark;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getPlace() {
        return place;
    }

    public String getHostShetuan() {
        return hostShetuan;
    }

    public String getHeadline() {
        return headline;
    }

    public String getRemark() {
        return remark;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setHost(String host) {
        this.hostShetuan = host;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int compareTo(Activity o) {
        return 0;
    }

    @Override
    public String toString() {
        System.out.println("已找到目标活动，现在显示该社团的详细信息");
        return
                "活动名： '" + activityName + '\'' + '\n' +
                "开始时间： '" + startTime + '\'' + '\n' +
                "举办地点： '" + place + '\'' + '\n' +
                "主办社团： '" + hostShetuan + '\'' + '\n' +
                "宣传信息： '" + headline + '\'' + '\n' +
                "备注： '" + remark + '\'';
    }
}

