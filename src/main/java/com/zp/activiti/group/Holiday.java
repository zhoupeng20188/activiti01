package com.zp.activiti.group;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Holiday implements Serializable {

    private Integer id;

    private String holidayName;

    private String type;

    private Integer num;

    private String reason;

    private Date beginDate;

    private Date endDate;
}
