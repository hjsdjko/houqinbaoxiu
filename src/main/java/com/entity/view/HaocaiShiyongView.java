package com.entity.view;

import com.entity.HaocaiShiyongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 耗材使用
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("haocai_shiyong")
public class HaocaiShiyongView extends HaocaiShiyongEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 baoxiu
			/**
			* 报修 的 学生
			*/
			private Integer baoxiuXueshengId;
			/**
			* 报修 的 后勤人员
			*/
			private Integer baoxiuHouqinrenyuanId;
			/**
			* 报修编号
			*/
			private String baoxiuUuidNumber;
			/**
			* 报修名称
			*/
			private String baoxiuName;
			/**
			* 报修物品
			*/
			private String baoxiuWupinName;
			/**
			* 报修地点
			*/
			private String baoxiuAddress;
			/**
			* 报修类型
			*/
			private Integer baoxiuTypes;
				/**
				* 报修类型的值
				*/
				private String baoxiuValue;
			/**
			* 报修详情
			*/
			private String baoxiuContent;
			/**
			* 报修状态
			*/
			private Integer baoxiuZhuangtaiTypes;
				/**
				* 报修状态的值
				*/
				private String baoxiuZhuangtaiValue;

		//级联表 haocai
			/**
			* 耗材编号
			*/
			private String haocaiUuidNumber;
			/**
			* 耗材名称
			*/
			private String haocaiName;
			/**
			* 耗材照片
			*/
			private String haocaiPhoto;
			/**
			* 耗材类型
			*/
			private Integer haocaiTypes;
				/**
				* 耗材类型的值
				*/
				private String haocaiValue;
			/**
			* 耗材库存数量
			*/
			private Integer haocaiKucunNumber;
			/**
			* 耗材详细介绍
			*/
			private String haocaiContent;

	public HaocaiShiyongView() {

	}

	public HaocaiShiyongView(HaocaiShiyongEntity haocaiShiyongEntity) {
		try {
			BeanUtils.copyProperties(this, haocaiShiyongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}








				//级联表的get和set baoxiu

					/**
					* 获取：报修 的 学生
					*/
					public Integer getBaoxiuXueshengId() {
						return baoxiuXueshengId;
					}
					/**
					* 设置：报修 的 学生
					*/
					public void setBaoxiuXueshengId(Integer baoxiuXueshengId) {
						this.baoxiuXueshengId = baoxiuXueshengId;
					}


					/**
					* 获取：报修 的 后勤人员
					*/
					public Integer getBaoxiuHouqinrenyuanId() {
						return baoxiuHouqinrenyuanId;
					}
					/**
					* 设置：报修 的 后勤人员
					*/
					public void setBaoxiuHouqinrenyuanId(Integer baoxiuHouqinrenyuanId) {
						this.baoxiuHouqinrenyuanId = baoxiuHouqinrenyuanId;
					}


					/**
					* 获取： 报修编号
					*/
					public String getBaoxiuUuidNumber() {
						return baoxiuUuidNumber;
					}
					/**
					* 设置： 报修编号
					*/
					public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
						this.baoxiuUuidNumber = baoxiuUuidNumber;
					}

					/**
					* 获取： 报修名称
					*/
					public String getBaoxiuName() {
						return baoxiuName;
					}
					/**
					* 设置： 报修名称
					*/
					public void setBaoxiuName(String baoxiuName) {
						this.baoxiuName = baoxiuName;
					}

					/**
					* 获取： 报修物品
					*/
					public String getBaoxiuWupinName() {
						return baoxiuWupinName;
					}
					/**
					* 设置： 报修物品
					*/
					public void setBaoxiuWupinName(String baoxiuWupinName) {
						this.baoxiuWupinName = baoxiuWupinName;
					}

					/**
					* 获取： 报修地点
					*/
					public String getBaoxiuAddress() {
						return baoxiuAddress;
					}
					/**
					* 设置： 报修地点
					*/
					public void setBaoxiuAddress(String baoxiuAddress) {
						this.baoxiuAddress = baoxiuAddress;
					}

					/**
					* 获取： 报修类型
					*/
					public Integer getBaoxiuTypes() {
						return baoxiuTypes;
					}
					/**
					* 设置： 报修类型
					*/
					public void setBaoxiuTypes(Integer baoxiuTypes) {
						this.baoxiuTypes = baoxiuTypes;
					}


						/**
						* 获取： 报修类型的值
						*/
						public String getBaoxiuValue() {
							return baoxiuValue;
						}
						/**
						* 设置： 报修类型的值
						*/
						public void setBaoxiuValue(String baoxiuValue) {
							this.baoxiuValue = baoxiuValue;
						}

					/**
					* 获取： 报修详情
					*/
					public String getBaoxiuContent() {
						return baoxiuContent;
					}
					/**
					* 设置： 报修详情
					*/
					public void setBaoxiuContent(String baoxiuContent) {
						this.baoxiuContent = baoxiuContent;
					}

					/**
					* 获取： 报修状态
					*/
					public Integer getBaoxiuZhuangtaiTypes() {
						return baoxiuZhuangtaiTypes;
					}
					/**
					* 设置： 报修状态
					*/
					public void setBaoxiuZhuangtaiTypes(Integer baoxiuZhuangtaiTypes) {
						this.baoxiuZhuangtaiTypes = baoxiuZhuangtaiTypes;
					}


						/**
						* 获取： 报修状态的值
						*/
						public String getBaoxiuZhuangtaiValue() {
							return baoxiuZhuangtaiValue;
						}
						/**
						* 设置： 报修状态的值
						*/
						public void setBaoxiuZhuangtaiValue(String baoxiuZhuangtaiValue) {
							this.baoxiuZhuangtaiValue = baoxiuZhuangtaiValue;
						}





				//级联表的get和set haocai

					/**
					* 获取： 耗材编号
					*/
					public String getHaocaiUuidNumber() {
						return haocaiUuidNumber;
					}
					/**
					* 设置： 耗材编号
					*/
					public void setHaocaiUuidNumber(String haocaiUuidNumber) {
						this.haocaiUuidNumber = haocaiUuidNumber;
					}

					/**
					* 获取： 耗材名称
					*/
					public String getHaocaiName() {
						return haocaiName;
					}
					/**
					* 设置： 耗材名称
					*/
					public void setHaocaiName(String haocaiName) {
						this.haocaiName = haocaiName;
					}

					/**
					* 获取： 耗材照片
					*/
					public String getHaocaiPhoto() {
						return haocaiPhoto;
					}
					/**
					* 设置： 耗材照片
					*/
					public void setHaocaiPhoto(String haocaiPhoto) {
						this.haocaiPhoto = haocaiPhoto;
					}

					/**
					* 获取： 耗材类型
					*/
					public Integer getHaocaiTypes() {
						return haocaiTypes;
					}
					/**
					* 设置： 耗材类型
					*/
					public void setHaocaiTypes(Integer haocaiTypes) {
						this.haocaiTypes = haocaiTypes;
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

					/**
					* 获取： 耗材库存数量
					*/
					public Integer getHaocaiKucunNumber() {
						return haocaiKucunNumber;
					}
					/**
					* 设置： 耗材库存数量
					*/
					public void setHaocaiKucunNumber(Integer haocaiKucunNumber) {
						this.haocaiKucunNumber = haocaiKucunNumber;
					}

					/**
					* 获取： 耗材详细介绍
					*/
					public String getHaocaiContent() {
						return haocaiContent;
					}
					/**
					* 设置： 耗材详细介绍
					*/
					public void setHaocaiContent(String haocaiContent) {
						this.haocaiContent = haocaiContent;
					}
















}
