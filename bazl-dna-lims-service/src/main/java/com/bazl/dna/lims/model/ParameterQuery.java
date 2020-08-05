package com.bazl.dna.lims.model;

import java.io.Serializable;

/**
 * @author wanghaiyang
 * @date 2020/7/30 15:15
 */
public class ParameterQuery implements Serializable {
    private static final long serialVersionUID = -4697330388664017051L;

    /** 受理单位code */
    private String acceptOrgId;

    /** 开始时间 */
    private String startDate;

    /** 结束时间 */
    private String endDate;

    public String getAcceptOrgId() {
        return acceptOrgId;
    }

    public void setAcceptOrgId(String acceptOrgId) {
        this.acceptOrgId = acceptOrgId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}