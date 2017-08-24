package tcp.binfoo;

import java.io.Serializable;

/**
 * Created by ZhangHongbin on 2017/7/13.
 */
public class MsgAck implements Serializable {

    private boolean update;
    private String new_version;
    private String update_url;
    private String update_log;
    private int update_type;
    private String file_name;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public String getNew_version() {
        return new_version;
    }

    public void setNew_version(String new_version) {
        this.new_version = new_version;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    @Override
    public String toString() {
        return "MsgAck{" +
                "file_name='" + file_name + '\'' +
                ", update=" + update +
                ", new_version='" + new_version + '\'' +
                ", update_url='" + update_url + '\'' +
                ", update_log='" + update_log + '\'' +
                ", update_type=" + update_type +
                '}';
    }

    public String getUpdate_log() {
        return update_log;
    }

    public void setUpdate_log(String update_log) {
        this.update_log = update_log;
    }

    public int getUpdate_type() {
        return update_type;
    }

    public void setUpdate_type(int update_type) {
        this.update_type = update_type;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }




}
