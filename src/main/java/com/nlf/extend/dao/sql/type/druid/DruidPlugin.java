package com.nlf.extend.dao.sql.type.druid;

import com.nlf.mini.App;
import com.nlf.mini.plugin.IPlugin;

/**
 * Druid插件
 *
 * @author 6tail
 */
public class DruidPlugin implements IPlugin {
  @Override
  public void onApply() {
    App.addImplement(DruidSettingProvider.class);
    App.addImplement(DruidConnectionProvider.class);
  }
}
