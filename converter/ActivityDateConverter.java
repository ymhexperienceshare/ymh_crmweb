package com.guigu.crm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.converter.ActivityDateConverter  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 下午1:26:20    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class ActivityDateConverter implements Converter<String, Date>{

    public Date convert(String time) {
        
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}


