package com.xxl.job.admin.core.route;

import com.xxl.job.admin.core.route.strategy.*;
import com.xxl.job.admin.core.util.I18nUtil;

/**
 * Created by xuxueli on 17/3/10.
 * 执行器路由策略
 */
public enum ExecutorRouteStrategyEnum {

    //选取第一个执行器
    FIRST(I18nUtil.getString("jobconf_route_first"), new ExecutorRouteFirst()),
    //选取最后一个执行器
    LAST(I18nUtil.getString("jobconf_route_last"), new ExecutorRouteLast()),
    //轮询
    ROUND(I18nUtil.getString("jobconf_route_round"), new ExecutorRouteRound()),
    //随机
    RANDOM(I18nUtil.getString("jobconf_route_random"), new ExecutorRouteRandom()),
    //根据jobId进行hash选取
    CONSISTENT_HASH(I18nUtil.getString("jobconf_route_consistenthash"), new ExecutorRouteConsistentHash()),
    //最不经常使用
    LEAST_FREQUENTLY_USED(I18nUtil.getString("jobconf_route_lfu"), new ExecutorRouteLFU()),
    //最近最久未使用
    LEAST_RECENTLY_USED(I18nUtil.getString("jobconf_route_lru"), new ExecutorRouteLRU()),
    /**
     * 故障转移:路由前先发送beat测试执行器是否故障
     */
    FAILOVER(I18nUtil.getString("jobconf_route_failover"), new ExecutorRouteFailover()),
    //忙碌转移
    BUSYOVER(I18nUtil.getString("jobconf_route_busyover"), new ExecutorRouteBusyover()),
    //分片广播
    SHARDING_BROADCAST(I18nUtil.getString("jobconf_route_shard"), null);

    ExecutorRouteStrategyEnum(String title, ExecutorRouter router) {
        this.title = title;
        this.router = router;
    }

    private String title;
    private ExecutorRouter router;

    public String getTitle() {
        return title;
    }
    public ExecutorRouter getRouter() {
        return router;
    }

    public static ExecutorRouteStrategyEnum match(String name, ExecutorRouteStrategyEnum defaultItem){
        if (name != null) {
            for (ExecutorRouteStrategyEnum item: ExecutorRouteStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }

}
