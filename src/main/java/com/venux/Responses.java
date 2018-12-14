package com.venux;

import com.venux.dto.DealResultDto;
import com.venux.exception.BusinessErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 接口响应
 */
public class Responses {
    public static ResponseEntity ok() {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 接口处理成功
     * @return
     */
    public static ResponseEntity dealSuccess() {
        DealResultDto dealResultDto = new DealResultDto();
        dealResultDto.setReturnCode("S");
        return new ResponseEntity(dealResultDto,HttpStatus.OK);
    }
    
    /**
     * 调用 接口成功
     * @param data
     * @return
     */
    public static ResponseEntity dealSuccess(String data) {
        DealResultDto dealResultDto = new DealResultDto();
        dealResultDto.setReturnCode("S");
        dealResultDto.setData(data);
        dealResultDto.setReturnMessage("处理成功");
        return new ResponseEntity(dealResultDto,HttpStatus.OK);
    }

    /**
     * 处理失败
     * @param errorMessage
     * @return
     */
    public static ResponseEntity dealError(String errorMessage) {
        DealResultDto dealResultDto = new DealResultDto();
        dealResultDto.setReturnCode("E");
        dealResultDto.setReturnMessage("错误:"+errorMessage);
        return new ResponseEntity(dealResultDto,HttpStatus.OK);
    }

    public static ResponseEntity exception(HttpStatus httpStatus,BusinessErrorModel model) {
        return new ResponseEntity(model,httpStatus);
    }

    public static <T> ResponseEntity<T> ok(T model) {
        return new ResponseEntity(model, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> businessException(T model) {

        return new ResponseEntity(model, HttpStatus.NOT_ACCEPTABLE);
    }
}
