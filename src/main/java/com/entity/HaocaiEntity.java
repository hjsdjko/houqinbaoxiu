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
 * 耗材
 *
 * @author 
 * @email
 */
@TableName("haocai")
public class HaocaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HaocaiEntity() {

	}

	public HaocaiEntity(T t) {
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
     * 耗材编号
     */
    @TableField(value = "haocai_uuid_number")

    private String haocaiUuidNumber;


    /**
     * 耗材名称
     */
    @TableField(value = "haocai_name")

    private String haocaiName;


    /**
     * 耗材照片
     */
    @TableField(value = "haocai_photo")

    private String haocaiPhoto;


    /**
     * 耗材类型
     */
    @TableField(value = "haocai_types")

    private Integer haocaiTypes;


    /**
     * 耗材库存数量
     */
    @TableField(value = "haocai_kucun_number")

    private Integer haocaiKucunNumber;


    /**
     * 耗材详细介绍
     */
    @TableField(value = "haocai_content")

    private String haocaiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：耗材编号
	 */
    public String getHaocaiUuidNumber() {
        return haocaiUuidNumber;
    }
    /**
	 * 获取：耗材编号
	 */

    public void setHaocaiUuidNumber(String haocaiUuidNumber) {
        this.haocaiUuidNumber = haocaiUuidNumber;
    }
    /**
	 * 设置：耗材名称
	 */
    public String getHaocaiName() {
        return haocaiName;
    }
    /**
	 * 获取：耗材名称
	 */

    public void setHaocaiName(String haocaiName) {
        this.haocaiName = haocaiName;
    }
    /**
	 * 设置：耗材照片
	 */
    public String getHaocaiPhoto() {
        return haocaiPhoto;
    }
    /**
	 * 获取：耗材照片
	 */

    public void setHaocaiPhoto(String haocaiPhoto) {
        this.haocaiPhoto = haocaiPhoto;
    }
    /**
	 * 设置：耗材类型
	 */
    public Integer getHaocaiTypes() {
        return haocaiTypes;
    }
    /**
	 * 获取：耗材类型
	 */

    public void setHaocaiTypes(Integer haocaiTypes) {
        this.haocaiTypes = haocaiTypes;
    }
    /**
	 * 设置：耗材库存数量
	 */
    public Integer getHaocaiKucunNumber() {
        return haocaiKucunNumber;
    }
    /**
	 * 获取：耗材库存数量
	 */

    public void setHaocaiKucunNumber(Integer haocaiKucunNumber) {
        this.haocaiKucunNumber = haocaiKucunNumber;
    }
    /**
	 * 设置：耗材详细介绍
	 */
    public String getHaocaiContent() {
        return haocaiContent;
    }
    /**
	 * 获取：耗材详细介绍
	 */

    public void setHaocaiContent(String haocaiContent) {
        this.haocaiContent = haocaiContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Haocai{" +
            "id=" + id +
            ", haocaiUuidNumber=" + haocaiUuidNumber +
            ", haocaiName=" + haocaiName +
            ", haocaiPhoto=" + haocaiPhoto +
            ", haocaiTypes=" + haocaiTypes +
            ", haocaiKucunNumber=" + haocaiKucunNumber +
            ", haocaiContent=" + haocaiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
