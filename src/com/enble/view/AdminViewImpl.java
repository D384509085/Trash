package com.enble.view;

import com.enble.model.Activity;
import com.enble.model.Shetuan;
import com.enble.model.SortedMethod;
import com.enble.presenter.AdminViewPresenter;
import com.enble.presenter.AdminViewPresenterImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
public class AdminViewImpl extends JFrame implements AdminView, ActionListener, ItemListener{

    private AdminViewPresenter mPresenter;
    private SortedMethod mSortedMethod = SortedMethod.MemberNum;
    JTextField shetuanText;
    private JButton findShetuanBtn;

    JRadioButton shetuanMemberItem = new JRadioButton("社团成员数量");
    JRadioButton shetuanActivityItem = new JRadioButton("社团活动数量");
    private JButton sortShetuanBtn;

    private JTextField beizhuText;
    private JTextField huodongText;
    private JButton addMessageBtn;

    private JTextArea resultText;
    public AdminViewImpl() {
        super("管理界面");
        setPresenter(new AdminViewPresenterImpl(this));
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JPanel findShetuanPanel = new JPanel(new FlowLayout());
        findShetuanBtn = new JButton("寻找目标社团的成员");
        sortShetuanBtn = new JButton("按指定方法排序");
        addMessageBtn = new JButton("添加备注");
        findShetuanBtn.addActionListener(this);
        sortShetuanBtn.addActionListener(this);
        addMessageBtn.addActionListener(this);
        resultText = new JTextArea("操作结果",10,20);

        JLabel label = new JLabel("要查找的社团名？");
        shetuanText = new JTextField(20);
        findShetuanPanel.add(label);
        findShetuanPanel.add(shetuanText);
        findShetuanPanel.add(findShetuanBtn);

        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(new GridLayout(1, 3));
        sortPanel.setBorder(BorderFactory.createTitledBorder("排序标准?"));
        sortPanel.add(shetuanMemberItem);
        sortPanel.add(shetuanActivityItem);
        sortPanel.add(sortShetuanBtn);
        ButtonGroup bgroup1 = new ButtonGroup();
        shetuanMemberItem.addItemListener(this);
        bgroup1.add(shetuanMemberItem);
        shetuanActivityItem.addItemListener(this);
        bgroup1.add(shetuanActivityItem);

        JPanel addMessagePanel = new JPanel();
        JLabel beizhu = new JLabel("备注是");
        JLabel labelActivity = new JLabel("活动是");
        beizhuText = new JTextField(10);
        huodongText = new JTextField(10);
        addMessagePanel.add(beizhu);
        addMessagePanel.add(beizhuText);
        addMessagePanel.add(labelActivity);
        addMessagePanel.add(huodongText);
        addMessagePanel.add(addMessageBtn);
        c.add(findShetuanPanel);
        c.add(sortPanel);
        c.add(addMessagePanel);
        c.add(resultText);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,1000);
        this.setVisible(true);
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
        resultText.setText(memberList.toString());
    }

    @Override
    public void showSortedShetuan(SortedMethod method) {
        System.out.println();
        String result = "";
        System.out.println("现在以" + method + "为依据对社团进行排序");
        ArrayList<Shetuan> sortedShetuanList = mPresenter.getSortedShetuan(method);

        for (Shetuan shetuan : sortedShetuanList) {
            switch (method) {
                case ActivityNum: {
                    result += "社团名: " + shetuan.getShetuanName() + ", 活动数量: " + shetuan.getContentActivityName().size()+"\n";
                    System.out.println("社团名: " + shetuan.getShetuanName() + ", 活动数量: " + shetuan.getContentActivityName().size());
                    break;
                }
                case MemberNum: {
                    result += "社团名: " + shetuan.getShetuanName() + ", 社团人数: " + shetuan.getShetuanMemberName().size()+"\n";
                    System.out.println("社团名: " + shetuan.getShetuanName() + ", 社团人数: " + shetuan.getShetuanMemberName().size());
                    break;
                }
            }
        }
        resultText.setText(result);
    }

    @Override
    public void addMessageToActivity(String msg, String activityName) {
        Activity activity = mPresenter.findActivityByName(activityName);
        activity.setAddedMsg(msg);
        System.out.println();
        System.out.println("现添加附加消息");
        System.out.println(activity.getActivityName() + " 附加消息是：" + msg);
        resultText.setText(activity.getActivityName() + " 附加消息是：" + msg);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findShetuanBtn) {
            showMemberOrderByShetuanName(shetuanText.getText());
        }
        if (e.getSource() == sortShetuanBtn) {
            showSortedShetuan(mSortedMethod);
        }
        if (e.getSource() == addMessageBtn) {
            addMessageToActivity(beizhuText.getText(), huodongText.getText());
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("item");
            if (e.getStateChange() == e.SELECTED) {
                if (e.getSource() == shetuanActivityItem) {
                    mSortedMethod = SortedMethod.ActivityNum;
                    System.out.println("activityNum");
                }
                if (e.getSource() == shetuanMemberItem) {
                    mSortedMethod = SortedMethod.MemberNum;
                    System.out.println("membernum");
                }
            }

    }
}
