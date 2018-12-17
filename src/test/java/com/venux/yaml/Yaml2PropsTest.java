package com.venux.yaml;

public class Yaml2PropsTest {
    public static void main(String[] args){
        String content = "server:\n" +
                "  port: 6023\n" +
                "\n" +
                "spring:\n" +
                "  application:\n" +
                "    name: zredis-base-service\n" +
                "  rabbitmq:\n" +
                "    host: 10.10.12.21\n" +
                "    port: 5672\n" +
                "    username: user\n" +
                "    password: password\n" +
                "  cloud:\n" +
                "    config:\n" +
                "      discovery:\n" +
                "        enabled: true\n" +
                "        service-id: SPRING-CLOUD-CONFIG\n" +
                "      fail-fast: true\n" +
                "      label: master\n" +
                "  redis:\n" +
                "    jedis:\n" +
                "      pool:\n" +
                "        max-active: 10000\n" +
                "        max-wait: 100000\n" +
                "        max-idle: 100\n" +
                "        min-idle: 10\n" +
                "      test-on-borrow: 60000\n" +
                "    #哨兵集群\n" +
                "    #sentinel:\n" +
                "      #master:  redis1\n" +
                "      #nodes: 10.10.6.71:7000,10.10.6.72:7000,10.10.6.73:7000\n" +
                "    timeout: 60000\n" +
                "    #redis cluster集群节点\n" +
                "    cluster:\n" +
                "       #max-redirects: 3\n" +
                "       nodes: 10.10.6.154:30001,10.10.6.154:30002,10.10.6.155:30001,10.10.6.155:30002,10.10.6.156:30001,10.10.6.156:30002\n" +
                " \n" +
                "eureka:\n" +
                "  client:\n" +
                "    eureka-server-total-connections-per-host: 500\n" +
                "  instance:\n" +
                "    prefer-ip-address: true\n" +
                "    instance-id: ${spring.cloud.client.ipAddress}:${spring.application.name}:${server.port}\n" +
                "\n" +
                "#hystrix超时熔断配置\n" +
                "hystrix:\n" +
                "  threadpool:\n" +
                "    default:\n" +
                "      coreSize: 30\n" +
                "      maxQueueSize: 100\n" +
                "      queueSizeRejectionThreshold: 20\n" +
                "  command:\n" +
                "    default:\n" +
                "      execution:\n" +
                "        isolation:\n" +
                "          thread:\n" +
                "            timeoutInMilliseconds: 1000\n" +
                "\n" +
                "#日志\n" +
                "logging:\n" +
                "  file: /data/logs/zredis-base-service/zredis-base-service.log";


    }
}
