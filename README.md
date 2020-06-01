
基于COLA、spring-cloud-alibaba、seata搭建的微服务框架

依赖环境：
nacos ： 注册和配置中心
seata ： 分布式事务组件
kafka ：消息队列，主要用于领域集成事件
skywalking ： 服务调用链追踪监控

分为三个服务，订单服务、账号服务、库存服务；实现了seata AT 和 TCC 模式的示例，领域事件实现通过kafka 消息队列消费

数据库在db 文件夹中
