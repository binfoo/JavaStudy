package mariadb;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.PrintStream;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;

public class DBUtils {
    private static final DBUtils m_su = new DBUtils();
    private static Dao dao = null;
    private static DruidDataSource dds = null;
    private static ParamConfig configBean = null;

    public Dao getDAO() {
        if (dao == null) {
            if (configBean == null) {
                String ParentPath = PathUtil.getAbsProjectPath();

                String filePath = ParentPath + "/config/MariaDBConfig.properties";
                System.out.println("读取MariaDB配置文件" + filePath);

                String fileContent = FileUtils.readFileByLines(filePath);
                System.out.println("数据库url参数" + fileContent);

                Gson gson = new Gson();
                configBean = (ParamConfig) gson.fromJson(fileContent, new TypeToken() {
                }.getType());
            }
            if (dds == null) {
                dds = new DruidDataSource();
                dds.setDriverClassName("org.mariadb.jdbc.Driver");
                dds.setInitialSize(configBean.PoolInitialSize);
                dds.setMaxActive(configBean.PoolMaxActive);
                dds.setMinIdle(configBean.PoolMinIdle);
                dds.setMaxWait(configBean.maxWait);
                dds.setUrl(configBean.url);
                dds.setUsername(configBean.UserName);
                dds.setPassword(configBean.Password);
                dds.setPoolPreparedStatements(false);
                dds.setMinIdle(configBean.PoolMinIdle);
                dds.setPoolPreparedStatements(true);
                dds.setMaxPoolPreparedStatementPerConnectionSize(100);
                dds.setRemoveAbandoned(true);
                dds.setRemoveAbandonedTimeout(1800);
            }
            dao = new NutDao(dds);
        }
        return dao;
    }

    public void closeConnection() {
        if (dds != null) {
            dds.close();
            dds = null;
        }
        dao = null;
    }

    public static DBUtils getInstance() {
        return m_su;
    }

    public static void main(String[] args) {

        String ParentPath = PathUtil.getAbsProjectPath();

        String filePath = ParentPath + "/config/MariaDBConfig.properties";
        System.out.println("读取MariaDB配置文件" + filePath);

        String fileContent = FileUtils.readFileByLines(filePath);
        System.out.println("数据库url参数" + fileContent);

        Gson gson = new Gson();
        configBean = (ParamConfig) gson.fromJson(fileContent, new TypeToken() {
        }.getType());


    }
}
