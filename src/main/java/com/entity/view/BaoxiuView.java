package com.entity.view;

import com.entity.BaoxiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 报修
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("baoxiu")
public class BaoxiuView extends BaoxiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 报修类型的值
		*/
		private String baoxiuValue;
		/**
		* 报修状态的值
		*/
		private String baoxiuZhuangtaiValue;



		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

		//级联表 houqinrenyuan
			/**
			* 公司
			*/
			private Integer gongsiTypes;
				/**
				* 公司的值
				*/
				private String gongsiValue;
			/**
			* 后勤人员姓名
			*/
			private String houqinrenyuanName;
			/**
			* 后勤人员手机号
			*/
			private String houqinrenyuanPhone;
			/**
			* 后勤人员身份证号
			*/
			private String houqinrenyuanIdNumber;
			/**
			* 后勤人员头像
			*/
			private String houqinrenyuanPhoto;
			/**
			* 电子邮箱
			*/
			private String houqinrenyuanEmail;

	public BaoxiuView() {

	}

	public BaoxiuView(BaoxiuEntity baoxiuEntity) {
		try {
			BeanUtils.copyProperties(this, baoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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



















				//级联表的get和set xuesheng

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}




				//级联表的get和set houqinrenyuan

					/**
					* 获取： 公司
					*/
					public Integer getGongsiTypes() {
						return gongsiTypes;
					}
					/**
					* 设置： 公司
					*/
					public void setGongsiTypes(Integer gongsiTypes) {
						this.gongsiTypes = gongsiTypes;
					}


						/**
						* 获取： 公司的值
						*/
						public String getGongsiValue() {
							return gongsiValue;
						}
						/**
						* 设置： 公司的值
						*/
						public void setGongsiValue(String gongsiValue) {
							this.gongsiValue = gongsiValue;
						}

					/**
					* 获取： 后勤人员姓名
					*/
					public String getHouqinrenyuanName() {
						return houqinrenyuanName;
					}
					/**
					* 设置： 后勤人员姓名
					*/
					public void setHouqinrenyuanName(String houqinrenyuanName) {
						this.houqinrenyuanName = houqinrenyuanName;
					}

					/**
					* 获取： 后勤人员手机号
					*/
					public String getHouqinrenyuanPhone() {
						return houqinrenyuanPhone;
					}
					/**
					* 设置： 后勤人员手机号
					*/
					public void setHouqinrenyuanPhone(String houqinrenyuanPhone) {
						this.houqinrenyuanPhone = houqinrenyuanPhone;
					}

					/**
					* 获取： 后勤人员身份证号
					*/
					public String getHouqinrenyuanIdNumber() {
						return houqinrenyuanIdNumber;
					}
					/**
					* 设置： 后勤人员身份证号
					*/
					public void setHouqinrenyuanIdNumber(String houqinrenyuanIdNumber) {
						this.houqinrenyuanIdNumber = houqinrenyuanIdNumber;
					}

					/**
					* 获取： 后勤人员头像
					*/
					public String getHouqinrenyuanPhoto() {
						return houqinrenyuanPhoto;
					}
					/**
					* 设置： 后勤人员头像
					*/
					public void setHouqinrenyuanPhoto(String houqinrenyuanPhoto) {
						this.houqinrenyuanPhoto = houqinrenyuanPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getHouqinrenyuanEmail() {
						return houqinrenyuanEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setHouqinrenyuanEmail(String houqinrenyuanEmail) {
						this.houqinrenyuanEmail = houqinrenyuanEmail;
					}



}
