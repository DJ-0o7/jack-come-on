## 说明

> 这些demo是个人之前做的小测试，主要是对一些框架的知识进行学习。



## 项目介绍


* **crud项目**：是一个springboot与mybatis整合，以注解的形式实现简单的crud。
* **duboo-zookeeper项目**：springboot整合dubbo + zookeeper。
* **jack_es项目**：spring整合ElasticSearch。
* **rabbitmq项目**：消息队列的实现，含有Direct直连交换机、Fanout扇型交换机和Topic主题交换机的测试。
* **simple_page项目**：Thymeleaf简单分页的实现。
* **springboot_mail项目**：简单邮件的发送实现。
* **springboot_redis_mysql项目**：这个项目是以redis作为中间介，用户访问是先访问redis缓存是否命中，如果命中则直接获取数据，不会再去到数据库中获取。如果没有命中，则再去数据库中查询获取数据，再将获取到的数据存入到redis缓存中。
* **vuedemo项目**：是springboot与vue简单的前后端分离项目。

------

个人博客中有一些对应项目的详解：

**博客**：https://blog.csdn.net/qq_42137703