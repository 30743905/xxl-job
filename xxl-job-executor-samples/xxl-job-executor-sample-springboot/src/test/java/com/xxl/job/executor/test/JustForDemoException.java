package com.xxl.job.executor.test;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-12-09
 * @since 1.0.0
 */

public class JustForDemoException extends RuntimeException {
    private static final long serialVersionUID = 2134186859756705446L;

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    private static void method1() {
        System.out.println("in method 1");
        method2();
    }

    private static void method2() {
        System.out.println("in method 2");
        method3();
    }

    private static void method3() {
        System.out.println("in method 3");
        method4();
    }

    private static void method4() {
        System.out.println("in method 4");
        throw new JustForDemoException();
    }

    public static void main(String[] args) {
        method1();
    }

}