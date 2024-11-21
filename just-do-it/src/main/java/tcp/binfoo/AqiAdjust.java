package tcp.binfoo;

import java.io.Serializable;

/**
 * Created by ZhangHongbin on 2017/7/10.
 */
public class AqiAdjust implements Serializable {
    private float voc;
    private float temp;
    private float arofene;
    private float co2;
    private float humidity;
    private float pm25;
    public float getArofene() {
        return arofene;
    }

    public void setArofene(float arofene) {
        this.arofene = arofene;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPm25() {
        return pm25;
    }

    public void setPm25(float pm25) {
        this.pm25 = pm25;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getVoc() {
        return voc;
    }

    public void setVoc(float voc) {
        this.voc = voc;
    }

    @Override
    public String toString() {
        return "AqiAdjust{" +
                "arofene=" + arofene +
                ", voc=" + voc +
                ", temp=" + temp +
                ", co2=" + co2 +
                ", humidity=" + humidity +
                ", pm25=" + pm25 +
                '}';
    }
}
