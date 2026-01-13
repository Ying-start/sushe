package com.sushe.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-28 00:23
 **/
@Data
public class DormRepair extends BasePageRequest{
    private int r_id;
    private int d_id;
    private String  d_dormbuilding;
    private String r_name;
    private String reason;
    private int r_status;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date r_time;
}

