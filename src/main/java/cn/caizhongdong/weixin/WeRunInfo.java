package cn.caizhongdong.weixin;

import cn.caizhongdong.domain.Rundata;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by caizhongdong on 2017/7/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeRunInfo {
    private List<Rundata> stepInfoList;

    public List<Rundata> getStepInfoList() {
        return stepInfoList;
    }

    public void setStepInfoList(List<Rundata> stepInfoList) {
        this.stepInfoList = stepInfoList;
    }
}


