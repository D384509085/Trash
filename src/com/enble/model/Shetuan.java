package com.enble.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class Shetuan implements Comparable<Shetuan>{

    public static SortedMethod mSortedMethod = SortedMethod.ActivityNum;
    private String ShetuanName;
    private String createTime;
    private String mainPersonName;
    private Person mainPerson;
    private String phoneNumber;
    private String email;
    private ArrayList<String> shetuanMemberName;
    private ArrayList<Person> shetuanMember;
    private ArrayList<Activity> contentActivity;
    private ArrayList<String> contentActivityName;
    private String shetuanHeadline;

    public Shetuan(String shetuanName, String createTime, String mainPersonName, String phoneNumber, String email,
                   ArrayList<String> shetuanMemberName, ArrayList<String> contentActivityName, String activityHeadline) {
        ShetuanName = shetuanName;
        this.createTime = createTime;
        this.mainPersonName = mainPersonName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shetuanMemberName = shetuanMemberName;
        this.contentActivityName = contentActivityName;
        this.shetuanHeadline = activityHeadline;
    }

    public Shetuan(String shetuanName, String createTime, Person mainPerson, String phoneNumber, String email, ArrayList<Person>
            shetuanMember, ArrayList<Activity> contentActivity, String activityHeadline) {
        ShetuanName = shetuanName;
        this.createTime = createTime;
        this.mainPerson = mainPerson;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shetuanMember = shetuanMember;
        this.contentActivity = contentActivity;
        this.shetuanHeadline = activityHeadline;
    }

    public String getShetuanName() {
        return ShetuanName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getMainPersonName() {
        return mainPersonName;
    }

    public Person getMainPerson() {
        return mainPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getShetuanMemberName() {
        return shetuanMemberName;
    }

    public ArrayList<Person> getShetuanMember() {
        return shetuanMember;
    }

    public ArrayList<Activity> getContentActivity() {
        return contentActivity;
    }

    public ArrayList<String> getContentActivityName() {
        return contentActivityName;
    }

    public String getActivityHeadline() {
        return shetuanHeadline;
    }

    public void setShetuanName(String shetuanName) {
        ShetuanName = shetuanName;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setMainPersonName(String mainPersonName) {
        this.mainPersonName = mainPersonName;
    }

    public void setMainPerson(Person mainPerson) {
        this.mainPerson = mainPerson;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setShetuanMemberName(ArrayList<String> shetuanMemberName) {
        shetuanMemberName = shetuanMemberName;
    }

    public void setShetuanMember(ArrayList<Person> shetuanMember) {
        shetuanMember = shetuanMember;
    }

    public void setContentActivity(ArrayList<Activity> contentActivity) {
        this.contentActivity = contentActivity;
    }

    public void setContentActivityName(ArrayList<String> contentActivityName) {
        this.contentActivityName = contentActivityName;
    }

    public void setActivityHeadline(String activityHeadline) {
        this.shetuanHeadline = activityHeadline;
    }

    @Override
    public String toString() {
        System.out.println("已找到目标社团，现在显示该社团的详细信息");
        return
                "社团名： '" + ShetuanName + '\'' + '\n'+
                "社团创建时间： '" + createTime + '\'' +
                "负责人： '" + mainPersonName + '\'' + '\n'+
                "联系电话： '" + phoneNumber + '\'' + '\n' +
                "邮箱： '" + email + '\'' + '\n' +
                "社团成员： " + shetuanMemberName + '\n' +
                "社团活动： " + contentActivityName + '\n' +
                "社团简介： '" + shetuanHeadline + '\'';
    }

    public static void setmSortedMethod(SortedMethod mSortedMethod) {
        Shetuan.mSortedMethod = mSortedMethod;
    }

    @Override
    public int compareTo(Shetuan o) {
        switch (mSortedMethod) {
            case ActivityNum: {
                if (this.contentActivityName.size() > o.getContentActivityName().size()) {
                    return 1;
                } else if(this.contentActivityName.size() == o.getContentActivityName().size()) {
                    return 0;
                }
                else return -1;
            }
            case MemberNum: {
                if (this.shetuanMemberName.size() > o.getShetuanMemberName().size()) {
                    return 1;
                } else if(this.shetuanMemberName.size() == o.getShetuanMemberName().size()) {
                    return 0;
                }
                else return -1;
            }
        }
        return 0;
    }
}
