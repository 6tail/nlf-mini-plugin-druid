package com.nlf.extend.dao.sql.type.druid;

import com.nlf.mini.dao.setting.AbstractDbSetting;

/**
 * druid连接池配置
 * 
 * @author 6tail
 * 
 */
public class DruidSetting extends AbstractDbSetting{
  private static final long serialVersionUID = 1;
  /** 默认连接类型 */
  public static final String DEFAULT_TYPE = "druid";
  private int initialSize = -1;
  private int minIdle = -1;
  private int maxActive = -1;
  private long maxWait = -1;
  private long timeBetweenEvictionRunsMillis = -1;
  private long minEvictableIdleTimeMillis = -1;
  private int maxPoolPreparedStatementPerConnectionSize = -1;
  private boolean testWhileIdle = false;
  private boolean testOnBorrow = false;
  private boolean testOnReturn = false;
  private boolean poolPreparedStatements = false;

  /**
   * 如果连接泄露，是否需要回收泄露的连接，默认false
   */
  private boolean removeAbandoned = false;

  /**
   * 如果回收了泄露的连接，是否要打印一条log，默认false
   */
  private boolean logAbandoned = false;

  /**
   * 连接回收的超时毫秒数，默认5分钟
   */
  private long removeAbandonedTimeoutMillis = -1;
  private String filters;

  public DruidSetting(){
    type = DEFAULT_TYPE;
  }

  public int getInitialSize(){
    return initialSize;
  }

  public void setInitialSize(int initialSize){
    this.initialSize = initialSize;
  }

  public int getMinIdle(){
    return minIdle;
  }

  public void setMinIdle(int minIdle){
    this.minIdle = minIdle;
  }

  public int getMaxActive(){
    return maxActive;
  }

  public void setMaxActive(int maxActive){
    this.maxActive = maxActive;
  }

  public long getMaxWait(){
    return maxWait;
  }

  public void setMaxWait(long maxWait){
    this.maxWait = maxWait;
  }

  public long getTimeBetweenEvictionRunsMillis(){
    return timeBetweenEvictionRunsMillis;
  }

  public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis){
    this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
  }

  public long getMinEvictableIdleTimeMillis(){
    return minEvictableIdleTimeMillis;
  }

  public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis){
    this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
  }

  public long getRemoveAbandonedTimeoutMillis() {
    return removeAbandonedTimeoutMillis;
  }

  public void setRemoveAbandonedTimeoutMillis(long removeAbandonedTimeoutMillis) {
    this.removeAbandonedTimeoutMillis = removeAbandonedTimeoutMillis;
  }

  public int getMaxPoolPreparedStatementPerConnectionSize(){
    return maxPoolPreparedStatementPerConnectionSize;
  }

  public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize){
    this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
  }

  public boolean isTestWhileIdle(){
    return testWhileIdle;
  }

  public void setTestWhileIdle(boolean testWhileIdle){
    this.testWhileIdle = testWhileIdle;
  }

  public boolean isTestOnBorrow(){
    return testOnBorrow;
  }

  public void setTestOnBorrow(boolean testOnBorrow){
    this.testOnBorrow = testOnBorrow;
  }

  public boolean isTestOnReturn(){
    return testOnReturn;
  }

  public void setTestOnReturn(boolean testOnReturn){
    this.testOnReturn = testOnReturn;
  }

  public boolean isPoolPreparedStatements(){
    return poolPreparedStatements;
  }

  public void setPoolPreparedStatements(boolean poolPreparedStatements){
    this.poolPreparedStatements = poolPreparedStatements;
  }

  public boolean isRemoveAbandoned() {
    return removeAbandoned;
  }

  public void setRemoveAbandoned(boolean removeAbandoned) {
    this.removeAbandoned = removeAbandoned;
  }

  public boolean isLogAbandoned() {
    return logAbandoned;
  }

  public void setLogAbandoned(boolean logAbandoned) {
    this.logAbandoned = logAbandoned;
  }

  public String getFilters(){
    return filters;
  }

  public void setFilters(String filters){
    this.filters = filters;
  }
}