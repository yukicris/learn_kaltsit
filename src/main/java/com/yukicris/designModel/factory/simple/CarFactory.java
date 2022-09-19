package com.yukicris.designModel.factory.simple;

public class CarFactory {
    //方法一
    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new Wulin();
        }else if(car.equals("特斯拉")){
            return new Tesla();
        }else{
            return null;
        }
    }

    //方法二
    public static Car getWuling(){
        return new Wulin();
    }

    public static Car getTesla(){
        return new Tesla();
    }
}
