package mariadb;


public class ParamConfig {
    public String url;
    public String UserName;
    public String Password;
    public String type;
    public int PoolInitialSize;
    public int PoolMaxActive;
    public int PoolMinIdle;
    public long maxWait;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public int getPoolInitialSize() {
        return this.PoolInitialSize;
    }

    public void setPoolInitialSize(int PoolInitialSize) {
        this.PoolInitialSize = PoolInitialSize;
    }

    public int getPoolMaxActive() {
        return this.PoolMaxActive;
    }

    public void setPoolMaxActive(int PoolMaxActive) {
        this.PoolMaxActive = PoolMaxActive;
    }
}
