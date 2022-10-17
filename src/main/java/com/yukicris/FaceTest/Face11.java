package com.yukicris.FaceTest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Face11 {
    //springboot全局异常
    /**是通过两个注解@ControllerAdvice和@ExceptionHandler来实现的
     *

     @ControllerAdvice 增强型控制器，对于控制器的全局配置放在同一个位置，全局异常的注解，放在类上。
     @ControllerAdvice 默认只会处理controller层抛出的异常，如果需要处理service层的异常，需要定义一个自定义的MyException来
     继承RuntimeException类，然后@ExceptionHandler（MyException）即可。
     下面那个原文链接写的挺好的
     *
     *
     *
     * @ExceptionHandler：指明需要处理的异常类型以及子类。注解放在方法上面
     */


  /*  @RestControllerAdvice特点：
            （1）通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置，他可以管理所有的Controller。
            （2）注解了@RestControllerAdvice的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
            （3）@RestControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。
            （4）@ExceptionHandler：用于指定异常处理方法。当与@RestControllerAdvice配合使用时，用于全局处理控制器里的异常。
            （5）

    @InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
    @ModelAttribute：本来作用是绑定键值对到Model中，当与@ControllerAdvice配合使用时，可以让全局的@RequestMapping都能获得在此处设置的键值对**
            2、@ExceptionHandler注解我们一般是用来自定义异常的。
    可以认为它是一个异常拦截器（处理器）。
            ————————————————

    看这篇吧
    原文链接：https://blog.csdn.net/weixin_40483369/article/details/124673723*/

    @ControllerAdvice
    public class GlobalExceptionHandler {
/**
         * 定义要捕获的异常 可以多个 @ExceptionHandler({})
         *
         * @param request  request
         * @param e        exception
         * @param response response
         * @return 响应结果
         */
  /*      @ExceptionHandler(CustomException.class)
        public ErrorResult customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            CustomException exception = (CustomException) e;
            return new ErrorResult(exception.getCode(), exception.getMessage());
        }*/

        /**
         * 捕获  RuntimeException 异常
         * TODO  如果你觉得在一个 exceptionHandler 通过  if (e instanceof xxxException) 太麻烦
         * TODO  那么你还可以自己写多个不同的 exceptionHandler 处理不同异常
         *
         * @param request  request
         * @param e        exception
         * @param response response
         * @return 响应结果
         */
     /*   @ExceptionHandler(RuntimeException.class)
        public ErrorResult runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            RuntimeException exception = (RuntimeException) e;
            return new ErrorResult(400, exception.getMessage());
        }*/
    }
}
