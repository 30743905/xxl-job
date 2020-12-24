package com.xxl.job.admin.core.util;

import com.xxl.job.admin.core.cron.CronExpression;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-12-10
 * @since 1.0.0
 */
public class CronExpressionTest {

    @Test
    public void getNextValidTimeAfterTest() throws ParseException {
        String cron1 = "17/30 * * * * ?";//每50s执行一次
        Long time = 1607568136214L;//Thu Dec 10 10:42:16 CST 2020
        Date date = new Date(time);
        System.out.println("time:"+time+", date:"+date);
        Date nextValidTime = new CronExpression(cron1).getNextValidTimeAfter(date);
        System.out.println(nextValidTime);
    }
}