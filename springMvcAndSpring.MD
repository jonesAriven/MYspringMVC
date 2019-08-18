### 创建springMvc项目步骤
#### 第一步、在web.xml中配置相关信息
1. 配置dispatcherServlet
```xml
 <servlet>
        <servlet-name>springDispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 给DispatcherServlet配置初始化参数：
                指定Springmvc的核心配置文件
         -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/springmvc.xml</param-value>
        </init-param>

        <!--
            load-on-startup: 设置DispatcherServlet在服务器启动时加载。
                Servlet的创建时机：
                     1. 请求到达以后创建
                     2. 服务器启动即创建
         -->
        <load-on-startup>1</load-on-startup>
    </servlet>
```
2. 配置请求映射：
```xml
  <servlet-mapping>
        <servlet-name>springDispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```
3. 规定spingioc的核心容器文件
```xml
    <!--通过servletListerer 监听器启动springIOC 容器-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!--通过servletListerer 监听器启动springIOC 容器-->
```
### 第二步，配置springMvc的核心文件
springmvc.xml
1. 配置试图解析器
```xml
    <!--  2. 视图解析器

         工作机制:  prefix + 请求处理方法的返回值 + suffix  =  物理视图路径.
                  /WEB-INF/views/success.jsp

        WEB-INF: 是服务器内部路径。 不能直接从浏览器端访问该路径下的资源. 但是可以内部转发进行访问

    -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
```
2. 开启包扫描只扫描controller注解
```xml
    <!--  1. 组件扫描 -->
    <!--若要使用<context:include-filter 标签，必须将use-default-filters设置为false-->
    <context:component-scan base-package="com.swdeve" use-default-filters="false">
        <!--排除Controller注解，与spring区分开，仅仅扫描Controller注解-->
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:include-filter>
    </context:component-scan>
```
### 第四步，配置sping的核心配置文件
applicationContext.xml
1. 开启包扫描并排除controller注解
```xml
    <!--  1. 组件扫描 -->
    <context:component-scan base-package="com.swdeve">
        <!--排除Controller注解，与springMVC区分看，仅仅扫描非Controller注解-->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:exclude-filter>
    </context:component-scan>
```
### 第五步，编写后台代码，如下：
有两点需要注意：
1. 类上添加注解，交由spring容器或者springMVC管理
2. 方法上添加地址映射，便于前台找到handller
3. 返回视图
```java
package com.swdeve.springMvc.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //不可省略
public class Hello {

    public Hello(){
//        System.out.println("初始化Hello");
    }
    //访问路径  http://localhost:8080/hello
    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("进入hello方法");
        //该success是直接作为字符串到返回是视图的路径上的
        return "success";
    }
}

```

