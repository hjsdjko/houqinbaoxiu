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
 * 耗材使用
 *
 * @author 
 * @email
 */
@TableName("haocai_shiyong")
public class HaocaiShiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HaocaiShiyongEntity() {

	}

	public HaocaiShiyongEntity(T t) {
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
     * 耗材
     */
    @TableField(value = "haocai_id")

    private Integer haocaiId;


    /**
     * 报修
     */
    @TableField(value = "baoxiu_id")

    private Integer baoxiuId;


    /**
     * 耗材使用编号
     */
    @TableField(value = "haocai_shiyong_uuid_number")

    private String haocaiShiyongUuidNumber;


    /**
     * 使用数量
     */
    @TableField(value = "haocai_shiyong_number")

    private Integer haocaiShiyongNumber;


    /**
     * 使用备注
     */
    @TableField(value = "haocai_shiyong_content")

    private String haocaiShiyongContent;


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
	 * 设置：耗材
	 */
    public Integer getHaocaiId() {
        return haocaiId;
    }
    /**
	 * 获取：耗材
	 */

    public void setHaocaiId(Integer haocaiId) {
        this.haocaiId = haocaiId;
    }
    /**
	 * 设置：报修
	 */
    public Integer getBaoxiuId() {
        return baoxiuId;
    }
    /**
	 * 获取：报修
	 */

    public void setBaoxiuId(Integer baoxiuId) {
        this.baoxiuId = baoxiuId;
    }
    /**
	 * 设置：耗材使用编号
	 */
    public String getHaocaiShiyongUuidNumber() {
        return haocaiShiyongUuidNumber;
    }
    /**
	 * 获取：耗材使用编号
	 */

    public void setHaocaiShiyongUuidNumber(String haocaiShiyongUuidNumber) {
        this.haocaiShiyongUuidNumber = haocaiShiyongUuidNumber;
    }
    /**
	 * 设置：使用数量
	 */
    public Integer getHaocaiShiyongNumber() {
        return haocaiShiyongNumber;
    }
    /**
	 * 获取：使用数量
	 */

    public void setHaocaiShiyongNumber(Integer haocaiShiyongNumber) {
        this.haocaiShiyongNumber = haocaiShiyongNumber;
    }
    /**
	 * 设置：使用备注
	 */
    public String getHaocaiShiyongContent() {
        return haocaiShiyongContent;
    }
    /**
	 * 获取：使用备注
	 */

    public void setHaocaiShiyongContent(String haocaiShiyongContent) {
        this.haocaiShiyongContent = haocaiShiyongContent;
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
        return "HaocaiShiyong{" +
            "id=" + id +
            ", haocaiId=" + haocaiId +
            ", baoxiuId=" + baoxiuId +
            ", haocaiShiyongUuidNumber=" + haocaiShiyongUuidNumber +
            ", haocaiShiyongNumber=" + haocaiShiyongNumber +
            ", haocaiShiyongContent=" + haocaiShiyongContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
