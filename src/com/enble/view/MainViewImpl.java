package com.enble.view;

import com.enble.model.Activity;
import com.enble.model.Shetuan;
import com.enble.presenter.MainViewPresenter;
import com.enble.presenter.MainViewPresenterImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class MainViewImpl extends JFrame implements MainView, ActionListener {

    private MainViewPresenter mPresenter;
    private JButton showShetuanBtn;
    private JButton showActivityBtn;
    private JTextField findShetuanText;
    private JButton finShetuanBtn;
    private JTextField findActivityText;
    private JButton findActivityBtn;
    private JTextArea resultText;
    public MainViewImpl() {
        super("社团管理界面");
        setPresenter(new MainViewPresenterImpl(this));
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        showShetuanBtn = new JButton("显示所有社团");
        showShetuanBtn.addActionListener(this);
        showActivityBtn = new JButton("显示所有活动");
        showActivityBtn.addActionListener(this);
        Panel findshetuanPanel = new Panel();
        JLabel findShetuanLabel = new JLabel("社团名");
        findShetuanText = new JTextField(10);
        finShetuanBtn = new JButton("寻找目标社团");
        finShetuanBtn.addActionListener(this);
        findshetuanPanel.add(findShetuanLabel);
        findshetuanPanel.add(findShetuanText);
        findshetuanPanel.add(finShetuanBtn);

        Panel findActivityPanel = new Panel();
        JLabel findActivityLabel = new JLabel("活动名");
        findActivityText = new JTextField(10);
        findActivityBtn = new JButton("寻找目标活动");
        findActivityBtn.addActionListener(this);
        findActivityPanel.add(findActivityLabel);
        findActivityPanel.add(findActivityText);
        findActivityPanel.add(findActivityBtn);
        c.add(showShetuanBtn);
        c.add(showActivityBtn);
        c.add(findshetuanPanel);
        c.add(findActivityPanel);
        resultText = new JTextArea("操作结果",10,20);
        c.add(resultText);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,1000);
        this.setVisible(true);

    }
    @Override
    public void setPresenter(MainViewPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showAllShetuan() {
        ArrayList<String> allShetuanName = mPresenter.getAllShetuanName();
        System.out.println("现在显示所有社团列表");
        String result = "";
        for (String shetuanName : allShetuanName) {
            System.out.println(shetuanName);
            result += shetuanName + "\n";
        }
        resultText.setText(result);
    }

    @Override
    public void showAllActivity() {
        ArrayList<String> allActivityName = mPresenter.getAllActivityName();
        System.out.println("现在显示所有活动列表");
        System.out.println();
        String result = "";
        for (String activityName :  allActivityName) {
            System.out.println(activityName);
            result += activityName + "\n";
        }
        resultText.setText(result);
    }

    @Override
    public void showTargetShetuanByName(String targetName) {
        System.out.println();
        System.out.println("现在查找目标社团");
        Shetuan targetShetuan = mPresenter.getTargetShetuanByName(targetName);
        System.out.println();
        if (targetShetuan != null) {
            System.out.println(targetShetuan.toString());
            resultText.setText(targetShetuan.toString());
        }
    }

    @Override
    public void showTargetActivityByName(String targetActivityName) {
        System.out.println();
        System.out.println("现在查找目标活动");
        Activity targetActivity = mPresenter.getTargetActivityByName(targetActivityName);
        if (targetActivity != null) {
            System.out.println(targetActivity.toString());
            resultText.setText(targetActivity.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showShetuanBtn) {
            showAllShetuan();
        }
        if (e.getSource() == showActivityBtn) {
            showAllActivity();
        }
        if (e.getSource() == finShetuanBtn) {
            showTargetShetuanByName(findShetuanText.getText());
        }
        if (e.getSource() == findActivityBtn) {
            showTargetActivityByName(findActivityText.getText());
        }
    }
}
