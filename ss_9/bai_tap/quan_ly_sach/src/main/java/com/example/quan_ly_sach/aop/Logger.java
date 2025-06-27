package com.example.quan_ly_sach.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing("execution(* com.example.quan_ly_sach.controller.BookController.borrowBooks(..))")
    public void BookQuantityException() {
        System.out.println("Đã xảy ra lỗi khi mượn sách");
    }

    @AfterThrowing("execution(* com.example.quan_ly_sach.controller.BookController.returnBook(..))")
    public void BookCodeException() {
        System.out.println("Mã sách không đúng hoặc không tồn tại");
    }

    @Around("execution(* com.example.quan_ly_sach.controller.BookController.*(..))")
    public Object LoggerBookAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Bắt đầu phương thức :" + methodName);
        try {
            Object object = joinPoint.proceed();
            System.out.println("Kết thúc phương thức :" + methodName);
            return object;
        } catch (Throwable e) {
            System.out.println("lỗi trong quá trình thực thi phương thức" + methodName);
            System.out.println("Thông tin lỗi :" + e.getMessage());
            throw e;
        }
    }

    private int count = 0;

    @Before("execution(* com.example.quan_ly_sach.controller.BookController.*(..))")
    public void countVisitor(JoinPoint joinPoint) {
        count++;
        String method = joinPoint.getSignature().getName();
        System.out.println("người dùng vừa truy cập phương thức :" + method);
        System.out.println("tổng số lượt truy cập " + count);
    }
}
