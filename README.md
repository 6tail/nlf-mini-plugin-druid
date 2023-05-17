# nlf-mini-plugin-druid [![License](https://img.shields.io/badge/license-MIT-4EB1BA.svg?style=flat-square)](https://github.com/6tail/nlf-mini-plugin-druid/blob/master/LICENSE)

nlf-mini-plugin-druid是 [nlf-mini](https://github.com/6tail/nlf-mini) 的插件，引入后可支持druid连接池。

### Maven

```xml
<dependency>
    <groupId>cn.6tail</groupId>
    <artifactId>nlf-mini</artifactId>
    <version>${nlf-mini.version}</version>
</dependency>

<dependency>
  <groupId>cn.6tail</groupId>
  <artifactId>nlf-mini-plugin-druid</artifactId>
  <version>1.0.0</version>
</dependency>
  
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid</artifactId>
  <version>${druid.version}</version>
</dependency>

<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>${mysql.version}</version>
</dependency>
```

### 下载jar

[Download](https://github.com/6tail/nlf-mini-plugin-druid/releases)

### 配置文件示例

    db.alias=a
     
    db.alias.a.dbtype=mysql
    db.alias.a.server=localhost
    db.alias.a.port=3306
    db.alias.a.dbname=mysql
    db.alias.a.user=root
    db.alias.a.password=
     
    # type 为 druid
    db.alias.a.type=druid
     
    db.alias.a.initialSize=1
    db.alias.a.minIdle=1
    db.alias.a.maxActive=20
    db.alias.a.maxWait=60000
    db.alias.a.timeBetweenEvictionRunsMillis=60000
    db.alias.a.minEvictableIdleTimeMillis=300000
    db.alias.a.testWhileIdle=true
    db.alias.a.testOnBorrow=false
    db.alias.a.testOnReturn=false
    db.alias.a.poolPreparedStatements=true
    db.alias.a.maxPoolPreparedStatementPerConnectionSize=20
    db.alias.a.filters=stat

### 使用示例

    import com.nlf.mini.extend.dao.sql.ISqlDao;
    import com.nlf.mini.extend.dao.sql.SqlDaoFactory;
     
    public class Demo {
      public static void main(String[] args){
        ISqlDao dao = SqlDaoFactory.getDao();
        int count = dao.getSelecter().table("user").count();
        System.out.println(count);
        dao.close();
      }
    }
