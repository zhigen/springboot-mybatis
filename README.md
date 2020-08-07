# springboot-mybatis
> 本项目使用springboot框架，通过mybatis进行数据库连接操作

# 目录
* [1 创建项目](#01)
* [2 启动数据库](#02)
* [3 编写代码](#03)
* [4 测试](#04)

## <div id="01"></div>
## 1 创建项目
> 参照或复制[springboot-maven](https://github.com/zhigen/springboot-maven)

## <div id="02"></div>
## 2 启动数据库
    2.1、docker pull mysql
    2.2、docker run -d -p 3306:3306 -v /F/data/docker/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 mysql
    2.3、确认2.2挂载目录后执行，开启服务
    2.4、数据库增加zglu0、zglu1库
    2.5、执行test.sql
> 参考[test.sql](https://github.com/zhigen/springboot-mybatis/tree/master/src/main/resources/test.sql)

## <div id="03"></div>
## 3 编写代码
    3.1、pom.xml文件引入依赖
    3.2、application.properties添加配置项
    3.3、编写实体类User
    3.4、编写mapper类UserMapper
    3.5、编写dao类UserDao
    3.6、编写service类UserService
    3.7、编写controller类UserController
    3.8、Application指定需扫描的mapper包
    3.9、编写README.md，描述开发或使用流程

## <div id="04"></div>
## 4 测试
> http://localhost:8082/swagger-ui.html