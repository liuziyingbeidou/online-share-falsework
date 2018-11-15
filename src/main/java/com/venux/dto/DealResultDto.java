package com.venux.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 业务处理结果DTO
 */
@ApiModel
public class DealResultDto {

    @ApiModelProperty("结果码,S-成功,E-失败")
    private String returnCode;
    @ApiModelProperty("返回数据")
    private String data;
    @ApiModelProperty("失败原因")
    private String returnMessage;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DealResultDto{" +
                "returnCode='" + returnCode + '\'' +
                ", data='" + data + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                '}';
    }
}
