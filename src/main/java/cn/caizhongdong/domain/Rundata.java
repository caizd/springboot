package cn.caizhongdong.domain;

import cn.caizhongdong.rest.service.LoginService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caizhongdong on 2017/7/13.
 */
public class Rundata implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(Rundata.class);

    private Integer timestamp;
    private Integer step;
    private String runData;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getRunData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        log.info(getTimestamp().toString());
        Long lt = new Long(getTimestamp().toString());
        Date date = new Date(lt*1000);
        runData = sdf.format(date);
        log.info(runData);
        return runData;
    }
}
