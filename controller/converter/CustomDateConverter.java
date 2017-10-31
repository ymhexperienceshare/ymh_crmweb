package com.guigu.crm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**       
 * 项目名称：SpringMVCMyBatis   
 * 类全名:com.guigu.ssm.controller.converter.CustomDateConverter  
 * 类描述：     
 * 创建人：刘老师   
 * 创建时间：2017-8-30 下午3:04:49    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, 980991634@qq.com All Rights Reserved.     
 */
public class CustomDateConverter  implements Converter<String, Date>{

    public Date convert(String source) {
        
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果参数绑定失败 返回null即可
        return null;
    }

}


