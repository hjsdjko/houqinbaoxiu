package com.entity.vo;

import com.entity.HaocaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 耗材
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("haocai")
public class HaocaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
