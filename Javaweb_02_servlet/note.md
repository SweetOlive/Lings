1、父级模块
```xml
<parent>
    <groupId>org.example</groupId>
    <artifactId>Javaweb_02_servlet</artifactId>
    <version>1.0-SNAPSHOT</version>
 </parent>
```
2、web.xml模板
```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
version="4.0"
metadata-complete="true">

</web-app>
```
3、配置resources，放置资源导出失败的问题
```xml
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <excludes>
          <exclude>**/*.properties</exclude>
          <exclude>**/*.xml</exclude>
        </excludes>
        <filtering>true</filtering>
      </resource>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
      </resource>
    </resources>
```