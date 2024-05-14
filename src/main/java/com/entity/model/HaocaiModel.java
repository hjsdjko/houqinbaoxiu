package com.entity.model;

import com.entity.HaocaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 耗材
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HaocaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 耗材库存数量
     */
    private Integer haocaiKucunNumber;


    /**
     * 耗材详细介绍
     */
    private String haocaiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：耗材编号
	 */
    public String getHaocaiUuidNumber() {
        return haocaiUuidNumber;
    }


    /**
	 * 设置：耗材编号
	 */
    public void setHaocaiUuidNumber(String haocaiUuidNumber) {
        this.haocaiUuidNumber = haocaiUuidNumber;
    }
    /**
	 * 获取：耗材名称
	 */
    public String getHaocaiName() {
        return haocaiName;
    }


    /**
	 * 设置：耗材名称
	 */
    public void setHaocaiName(String haocaiName) {
        this.haocaiName = haocaiName;
    }
    /**
	 * 获取：耗材照片
	 */
    public String getHaocaiPhoto() {
        return haocaiPhoto;
    }


    /**
	 * 设置：耗材照片
	 */
    public void setHaocaiPhoto(String haocaiPhoto) {
        this.haocaiPhoto = haocaiPhoto;
    }
    /**
	 * 获取：耗材类型
	 */
    public Integer getHaocaiTypes() {
        return haocaiTypes;
    }


    /**
	 * 设置：耗材类型
	 */
    public void setHaocaiTypes(Integer haocaiTypes) {
        this.haocaiTypes = haocaiTypes;
    }
    /**
	 * 获取：耗材库存数量
	 */
    public Integer getHaocaiKucunNumber() {
        return haocaiKucunNumber;
    }


    /**
	 * 设置：耗材库存数量
	 */
    public void setHaocaiKucunNumber(Integer haocaiKucunNumber) {
        this.haocaiKucunNumber = haocaiKucunNumber;
    }
    /**
	 * 获取：耗材详细介绍
	 */
    public String getHaocaiContent() {
        return haocaiContent;
    }


    /**
	 * 设置：耗材详细介绍
	 */
    public void setHaocaiContent(String haocaiContent) {
        this.haocaiContent = haocaiContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
