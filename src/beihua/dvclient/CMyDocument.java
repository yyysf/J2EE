package beihua.dvclient;

import beihua.dvframework.CDocument;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

public class CMyDocument extends CDocument {
    public List<Student> students=new LinkedList<Student>();
    public boolean processEvent(ActionEvent e) {
// TODO Auto-generated method stub
        ActionEvent f=e;
        String command=f.getActionCommand();
        System.out.println(command);
        if(command.equals("add")){
            String inputstudent= JOptionPane.showInputDialog("请输入学生姓名和学生成绩，用逗号分割");
            if(inputstudent==null)return false;
            String [] sstudent=inputstudent.split(",");
            String name =sstudent[0];
            int score=Integer.parseInt(sstudent[1]);
            String grade = null;
            if(score < 60)
                grade = "不及格";
            else if (score >= 60 && score < 70)
                grade = "及格";
            else if (score >= 70 && score < 80)
                grade = "中等";
            else if (score >= 80 && score < 90)
                grade = "良好";
            else
                grade = "优秀";

            students.add(new Student(name,score,grade));
        }
        else if(command.equals("delete")){
            String deletestudent= JOptionPane.showInputDialog("请输入学生姓名和学生成绩，用逗号分割");
            for (int i = 0; i < students.size(); i++) {
                if(students.size()>0 && students.get(i).getName().equals(deletestudent))
                    students.remove(i);
            }
        }
        this.updateAllViews();
        return false;
    }
    protected int [] statisticScoreRange(){
        int[] statistic=new int[5];
        for(int i=0;i<5;i++)statistic[i]=0;
        for(Student stu:students){
            if(stu.score<60)statistic[0]++;
            else if(stu.score>59&&stu.score<70)statistic[1]++;
            else if(stu.score>69&&stu.score<80)statistic[2]++;
            else if(stu.score>79&&stu.score<90)statistic[3]++;
            else if(stu.score>89&&stu.score<=100)statistic[4]++;
        }
        return statistic;
    }
}
