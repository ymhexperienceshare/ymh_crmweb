package com.guigu.crm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**       
 * ��Ŀ���ƣ�SpringMVCMyBatis   
 * ��ȫ��:com.guigu.ssm.controller.converter.CustomDateConverter  
 * ��������     
 * �����ˣ�����ʦ   
 * ����ʱ�䣺2017-8-30 ����3:04:49    
 * �޸ı�ע��  
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
        //���������ʧ�� ����null����
        return null;
    }

}


