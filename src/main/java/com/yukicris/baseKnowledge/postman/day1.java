package com.yukicris.baseKnowledge.postman;

public class day1 {
    //postman可以设置环境变量
    //点击左边的environment设置,用的时候用{{参数}}引用即可

    //然后接口返回的参数,在test里面可以把返回的值拿去作为另外一个接口的环境参数
    //比如验证码之类的
    //将数据解析成json

    /*
    var data=JSON.parse(responseBody);
    //获取access_token值
    var data=data.data
    //设置成环境变量
    pm.environment.set("IQ_APP_CODE",data.code)
    */
    //然后在其它接口的参数传递中使用
//    {
//        "phone":"xxx",
//        "vcode":"{IQ_APP_CODE}"
//    }
}
