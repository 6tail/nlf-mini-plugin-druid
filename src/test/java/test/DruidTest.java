package test;

import com.nlf.mini.extend.dao.sql.SqlDaoFactory;
import org.junit.Assert;
import org.junit.Test;

public class DruidTest {

  @Test
  public void test() {
    int count = SqlDaoFactory.getDao().getSelecter().table("user").count();
    Assert.assertTrue(count>0);
  }
}
