package com.entity.model;

import com.entity.HaocaiShiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 耗材使用
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HaocaiShiyongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 耗材
     */
    private Integer haocaiId;


    /**
     * 报修
     */
    private Integer baoxiuId;


    /**
     * 耗材使用编号
     */
    private String haocaiShiyongUuidNumber;


    /**
     * 使用数量
     */
    private Integer haocaiShiyongNumber;


    /**
     * 使用备注
     */
    private String haocaiShiyongContent;


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
	 * 获取：耗材
	 */
    public Integer getHaocaiId() {
        return haocaiId;
    }


    /**
	 * 设置：耗材
	 */
    public void setHaocaiId(Integer haocaiId) {
        this.haocaiId = haocaiId;
    }
    /**
	 * 获取：报修
	 */
    public Integer getBaoxiuId() {
        return baoxiuId;
    }


    /**
	 * 设置：报修
	 */
    public void setBaoxiuId(Integer baoxiuId) {
        this.baoxiuId = baoxiuId;
    }
    /**
	 * 获取：耗材使用编号
	 */
    public String getHaocaiShiyongUuidNumber() {
        return haocaiShiyongUuidNumber;
    }


    /**
	 * 设置：耗材使用编号
	 */
    public void setHaocaiShiyongUuidNumber(String haocaiShiyongUuidNumber) {
        this.haocaiShiyongUuidNumber = haocaiShiyongUuidNumber;
    }
    /**
	 * 获取：使用数量
	 */
    public Integer getHaocaiShiyongNumber() {
        return haocaiShiyongNumber;
    }


    /**
	 * 设置：使用数量
	 */
    public void setHaocaiShiyongNumber(Integer haocaiShiyongNumber) {
        this.haocaiShiyongNumber = haocaiShiyongNumber;
    }
    /**
	 * 获取：使用备注
	 */
    public String getHaocaiShiyongContent() {
        return haocaiShiyongContent;
    }


    /**
	 * 设置：使用备注
	 */
    public void setHaocaiShiyongContent(String haocaiShiyongContent) {
        this.haocaiShiyongContent = haocaiShiyongContent;
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
