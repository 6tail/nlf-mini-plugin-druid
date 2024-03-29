package com.nlf.extend.dao.sql.type.druid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.druid.pool.DruidDataSource;
import com.nlf.mini.App;
import com.nlf.mini.dao.connection.AbstractConnectionProvider;
import com.nlf.mini.dao.connection.IConnection;
import com.nlf.mini.dao.exception.DaoException;
import com.nlf.mini.extend.dao.sql.SqlConnection;

/**
 * druid连接提供器
 *
 * @author 6tail
 *
 */
public class DruidConnectionProvider extends AbstractConnectionProvider{
  private static final Map<String,DruidDataSource> dataSources = new HashMap<>();

  public IConnection getConnection(){
    DruidSetting setting = (DruidSetting)this.setting;
    Connection conn;
    try{
      String key = setting.getAlias();
      DruidDataSource dataSource = dataSources.get(key);
      if(null==dataSource){
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName(setting.getDriver());
        dataSource.setUrl(setting.getUrl());
        dataSource.setUsername(setting.getUser());
        dataSource.setPassword(setting.getPassword());
        dataSource.setTestOnBorrow(setting.isTestOnBorrow());
        dataSource.setTestOnReturn(setting.isTestOnReturn());
        dataSource.setTestWhileIdle(setting.isTestWhileIdle());
        dataSource.setPoolPreparedStatements(setting.isPoolPreparedStatements());
        if(-1!=setting.getInitialSize()){
          dataSource.setInitialSize(setting.getInitialSize());
        }
        if(-1!=setting.getMinIdle()){
          dataSource.setMinIdle(setting.getMinIdle());
        }
        if(-1!=setting.getMaxActive()){
          dataSource.setMaxActive(setting.getMaxActive());
        }
        if(-1!=setting.getMaxWait()){
          dataSource.setMaxWait(setting.getMaxWait());
        }
        if(-1!=setting.getTimeBetweenEvictionRunsMillis()){
          dataSource.setTimeBetweenEvictionRunsMillis(setting.getTimeBetweenEvictionRunsMillis());
        }
        if(-1!=setting.getMinEvictableIdleTimeMillis()){
          dataSource.setMinEvictableIdleTimeMillis(setting.getMinEvictableIdleTimeMillis());
        }
        if(-1!=setting.getMaxPoolPreparedStatementPerConnectionSize()){
          dataSource.setMaxPoolPreparedStatementPerConnectionSize(setting.getMaxPoolPreparedStatementPerConnectionSize());
        }
        dataSource.setRemoveAbandoned(setting.isRemoveAbandoned());
        dataSource.setLogAbandoned(setting.isLogAbandoned());
        if (-1 != setting.getRemoveAbandonedTimeoutMillis()) {
          dataSource.setRemoveAbandonedTimeoutMillis(setting.getRemoveAbandonedTimeoutMillis());
        }
        dataSource.setValidationQuery(App.getProperty("nlf.dao.setting."+setting.getDbType()+".sql"));
        if(null!=setting.getFilters()){
          dataSource.setFilters(setting.getFilters());
        }
        dataSources.put(key,dataSource);
      }
      conn = dataSource.getConnection();
    }catch(SQLException e){
      throw new DaoException(e);
    }
    SqlConnection sc = new SqlConnection(conn);
    sc.setDbSetting(setting);
    return sc;
  }

  public boolean support(String type){
    return "druid".equalsIgnoreCase(type);
  }
}