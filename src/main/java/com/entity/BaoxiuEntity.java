package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 报修
 *
 * @author 
 * @email
 */
@TableName("baoxiu")
public class BaoxiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxiuEntity() {

	}

	public BaoxiuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 后勤人员
     */
    @TableField(value = "houqinrenyuan_id")

    private Integer houqinrenyuanId;


    /**
     * 报修编号
     */
    @TableField(value = "baoxiu_uuid_number")

    private String baoxiuUuidNumber;


    /**
     * 报修名称
     */
    @TableField(value = "baoxiu_name")

    private String baoxiuName;


    /**
     * 报修物品
     */
    @TableField(value = "baoxiu_wupin_name")

    private String baoxiuWupinName;


    /**
     * 报修地点
     */
    @TableField(value = "baoxiu_address")

    private String baoxiuAddress;


    /**
     * 报修类型
     */
    @TableField(value = "baoxiu_types")

    private Integer baoxiuTypes;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报修详情
     */
    @TableField(value = "baoxiu_content")

    private String baoxiuContent;


    /**
     * 报修状态
     */
    @TableField(value = "baoxiu_zhuangtai_types")

    private Integer baoxiuZhuangtaiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：后勤人员
	 */
    public Integer getHouqinrenyuanId() {
        return houqinrenyuanId;
    }
    /**
	 * 获取：后勤人员
	 */

    public void setHouqinrenyuanId(Integer houqinrenyuanId) {
        this.houqinrenyuanId = houqinrenyuanId;
    }
    /**
	 * 设置：报修编号
	 */
    public String getBaoxiuUuidNumber() {
        return baoxiuUuidNumber;
    }
    /**
	 * 获取：报修编号
	 */

    public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
        this.baoxiuUuidNumber = baoxiuUuidNumber;
    }
    /**
	 * 设置：报修名称
	 */
    public String getBaoxiuName() {
        return baoxiuName;
    }
    /**
	 * 获取：报修名称
	 */

    public void setBaoxiuName(String baoxiuName) {
        this.baoxiuName = baoxiuName;
    }
    /**
	 * 设置：报修物品
	 */
    public String getBaoxiuWupinName() {
        return baoxiuWupinName;
    }
    /**
	 * 获取：报修物品
	 */

    public void setBaoxiuWupinName(String baoxiuWupinName) {
        this.baoxiuWupinName = baoxiuWupinName;
    }
    /**
	 * 设置：报修地点
	 */
    public String getBaoxiuAddress() {
        return baoxiuAddress;
    }
    /**
	 * 获取：报修地点
	 */

    public void setBaoxiuAddress(String baoxiuAddress) {
        this.baoxiuAddress = baoxiuAddress;
    }
    /**
	 * 设置：报修类型
	 */
    public Integer getBaoxiuTypes() {
        return baoxiuTypes;
    }
    /**
	 * 获取：报修类型
	 */

    public void setBaoxiuTypes(Integer baoxiuTypes) {
        this.baoxiuTypes = baoxiuTypes;
    }
    /**
	 * 设置：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报修详情
	 */
    public String getBaoxiuContent() {
        return baoxiuContent;
    }
    /**
	 * 获取：报修详情
	 */

    public void setBaoxiuContent(String baoxiuContent) {
        this.baoxiuContent = baoxiuContent;
    }
    /**
	 * 设置：报修状态
	 */
    public Integer getBaoxiuZhuangtaiTypes() {
        return baoxiuZhuangtaiTypes;
    }
    /**
	 * 获取：报修状态
	 */

    public void setBaoxiuZhuangtaiTypes(Integer baoxiuZhuangtaiTypes) {
        this.baoxiuZhuangtaiTypes = baoxiuZhuangtaiTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Baoxiu{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", houqinrenyuanId=" + houqinrenyuanId +
            ", baoxiuUuidNumber=" + baoxiuUuidNumber +
            ", baoxiuName=" + baoxiuName +
            ", baoxiuWupinName=" + baoxiuWupinName +
            ", baoxiuAddress=" + baoxiuAddress +
            ", baoxiuTypes=" + baoxiuTypes +
            ", insertTime=" + insertTime +
            ", baoxiuContent=" + baoxiuContent +
            ", baoxiuZhuangtaiTypes=" + baoxiuZhuangtaiTypes +
            ", createTime=" + createTime +
        "}";
    }
}
