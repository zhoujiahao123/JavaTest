package day05;

import java.util.*;

public class StringDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("周家豪", (int) (Math.random() * 1000)));
        list.add(new Person("石剑钧", (int) (Math.random() * 1000)));
        list.add(new Person("郑先进", (int) (Math.random() * 1000)));
        list.add(new Person("钟嘉灝", (int) (Math.random() * 1000)));
        list.add(new Person("周普莉", (int) (Math.random() * 1000)));
        list.add(new Person("何林杰", (int) (Math.random() * 1000)));
        String testWork[] = {"总体测试", "功能模块测试", "系统性能测试", "系统兼容性测试", "系统安全性测试"};
        int j = 0;
        //按随机数排序
        Sort.sortByNumber(list, 0, list.size() - 1);
        for (int i = 0; i <= 5; i++) {
            if (i == 1) {
                System.out.println(testWork[j] + ":" + list.get(i++).toString());
                System.out.println(testWork[j] + ":" + list.get(i).toString());
                j++;
            } else {
                System.out.println(testWork[j] + ":" + list.get(i).toString());
                j++;
            }
        }
    }
}

