package com.yukicris.collection1.Day1;

import java.util.List;

public class Book {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 静态方法,冒泡排序
    public static void sort(List list){
        int listSize = list.size();
        for (int i = 0; i < listSize-1; i++) {
            for(int j = 0;j<listSize-1-i;j++){
                // 取出对象
                Book b1 = (Book)list.get(j);
                Book b2 = (Book)list.get(j);
                //交换
                if (b1.getPrice()>b2.getPrice()){
                    list.set(j,b2);
                    list.set(j+1,b1);
                }
            }
        }
    }
}
