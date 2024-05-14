package com.entity.view;

import com.entity.HaocaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 耗材
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("haocai")
public class HaocaiView extends HaocaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 耗材类型的值
		*/
		private String haocaiValue;



	public HaocaiView() {

	}

	public HaocaiView(HaocaiEntity haocaiEntity) {
		try {
			BeanUtils.copyProperties(this, haocaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 耗材类型的值
			*/
			public String getHaocaiValue() {
				return haocaiValue;
			}
			/**
			* 设置： 耗材类型的值
			*/
			public void setHaocaiValue(String haocaiValue) {
				this.haocaiValue = haocaiValue;
			}










}
