# spring-boot
##前言
spring-boot解决了什么，为什么要用它呢？
Spring Boot就是用来简化Spring应用的搭建以及开发过程。该框架致力于实现免XML配置，提供便捷，独立的运行环境，实现“一键运行”满足快速应用开发的需求。
基于SpringBoot+Mybatis项目敏捷开发系统，该项目创建于2017年9月13凌晨（苹果十周年发布），随着时间的推移，正在慢慢的成长，努力打造一个spring-boot整合mybatis快速、敏捷、灵活的中小企业解决方案的项目。

##项目介绍
基于SpringBoot+Mybatis分布式敏捷开发系统架构，提供为中小型企业打造全方位J2EE企业级快速开发解决方案。
###技术选型
####后端技术
| 技术                | 名称           | 官网                                       |
| ----------------- | ------------ | ---------------------------------------- |
| Spring Framework  | 容器           | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/) |
| Apache Shiro      | 安全框架         | [http://shiro.apache.org/](http://shiro.apache.org/) |
| Spring session    | 分布式Session管理 | [http://projects.spring.io/spring-session/](http://projects.spring.io/spring-session/) |
| MyBatis           | ORM框架        | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html) |
| MyBatis Generator | 代码生成         | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html) |
## 环境搭建（QQ群内有“zheng环境搭建和系统部署文档.doc”）

#### 开发工具:
- MySql: 数据库
- jetty: 开发服务器
- Tomcat: 应用服务器
- SVN|Git: 版本管理
- Nginx: 反向代理服务器
- IntelliJ IDEA: 开发IDE
- PowerDesigner: 建模工具
- Navicat for MySQL: 数据库客户端

#### 开发环境：
- Jdk7+
- Mysql5.5+
- Redis

###项目搭建步骤
#### 项目结构（最初的模样）
 ![QQ图片20170913174526](C:\Users\User\Desktop\QQ图片20170913174526.png)
#### 数据库
spring-boot.sql

```
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'longjingcha', '18', '123456');
```

#### Maven配置

pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>com.longjingcha</groupId>
<artifactId>spring-boot</artifactId>
<version>1.0-SNAPSHOT</version>
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>1.2.5.RELEASE</version>
</parent>
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <java.version>1.7</java.version>
  <mybatis-spring.version>1.2.2</mybatis-spring.version>
  <mybatis.version>3.2.8</mybatis.version>
  <alibaba.version>1.1.43</alibaba.version>
  <swagger.version>0.9.5</swagger.version>
  <common.version>2.5</common.version>
  <shiro.version>1.3.2</shiro.version>
</properties>
<dependencies>
  <!--Spring Boot-->
  <!--支持 Web 应用开发，包含 Tomcat 和 spring-mvc。 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <!--模板引擎-->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  <!--支持使用 JDBC 访问数据库-->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
  </dependency>
  <!--添加适用于生产环境的功能，如性能指标和监测等功能。 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>
  <!--Mybatis-->
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>${mybatis-spring.version}</version>
  </dependency>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>${mybatis.version}</version>
  </dependency>
  <!--Mysql / DataSource-->
  <dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jdbc</artifactId>
  </dependency>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
  </dependency>
  <!--Json Support-->
  <dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>${alibaba.version}</version>
  </dependency>
  <!--Swagger support-->
  <dependency>
    <groupId>com.mangofactory</groupId>
    <artifactId>swagger-springmvc</artifactId>
    <version>${swagger.version}</version>
  </dependency>
  <dependency>
    <groupId>commons-lang</groupId>
    <artifactId>commons-lang</artifactId>
    <version>${common.version}</version>
  </dependency>
  <dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-core</artifactId>
    <version>${shiro.version}</version>
  </dependency>
</dependencies>
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
  </plugins>
</build>
<repositories>
  <repository>
    <id>spring-milestone</id>
    <url>https://repo.spring.io/libs-release</url>
  </repository>
</repositories>
<pluginRepositories>
  <pluginRepository>
    <id>spring-milestone</id>
    <url>https://repo.spring.io/libs-release</url>
  </pluginRepository>
</pluginRepositories>
</project>
```

#### Controller

使用了三种接口样例供你参考，试图模板（IndexController），JSON（UserController），RESTFUL（Swagger UI--SwaggerController）

#### Mybatis

application.properties

```
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/spring-boot?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

注意，在Application.java代码中，配置DataSource时的注解

@ConfigurationProperties(prefix=“spring.datasource”) 

表示将根据前缀“spring.datasource”从application.properties中匹配相关属性值。

UserMapper.xml

Mybatis的sql映射文件。Mybatis同样支持注解方式

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.longjingcha.dao.UserDao">
  <resultMap id="BaseResultMap" type="com.longjingcha.model.User" >
    <result column="name" property="name" jdbcType="VARCHAR" />
    <result column="password" property="password" jdbcType="VARCHAR" />
    <result column="age" property="age" jdbcType="INTEGER" />
  </resultMap>
  <sql id="Base_Column_List" >
    name, password, age
  </sql>
  <select id="findUserInfo" resultMap="BaseResultMap">
    select * from user;
  </select>
 
</mapper>
```

实现类UserDao

```
package com.longjingcha.dao;

import java.util.List;

/**
 * Created by user
 */
public interface UserDao {
    public List findUserInfo();
}

```

#### 主函数

ApplicationBoot启动项目（ApplicationBoot.java）

此外，该类中还包含和数据库相关的DataSource，SqlSeesion配置内容。

注：@MapperScan(“cn.no7player.mapper”) 表示Mybatis的映射路径（package路径）



 ![QQ图片20170913180548](C:\Users\User\Desktop\QQ图片20170913180548.png)

上边之前提过的三种方式

view

http://localhost:8080/sso/index

 ![QQ图片20170913180750](C:\Users\User\Desktop\QQ图片20170913180750.png)

 JSON![QQ图片20170913180848](C:\Users\User\Desktop\QQ图片20170913180848.png)

RESTFUL

 ![QQ图片20170913181022](C:\Users\User\Desktop\QQ图片20170913181022.png)



### 资源下载

- JDK7 [http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html "JDK7")
- Maven [http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi "Maven")
- Redis [https://redis.io/download](https://redis.io/download "Redis")
### 优秀文章和博客
- [单点登录原理与简单实现](http://shuzheng5201314.iteye.com/blog/2343910 "单点登录原理与简单实现")

- [ITeye论坛关于权限控制的讨论](http://www.iteye.com/magazines/82 "ITeye论坛关于权限控制的讨论")

- [RBAC新解：基于资源的权限管理(Resource-Based Access Control)](http://globeeip.iteye.com/blog/1236167 "RBAC新解：基于资源的权限管理(Resource-Based Access Control)")

- [网站架构经验随笔](http://jinnianshilongnian.iteye.com/blog/2289904 "网站架构经验随笔")
- 《使用 Spring Boot 快速构建 Spring 框架应用》
  http://www.ibm.com/developerworks/cn/java/j-lo-spring-boot/





​									未完待续--