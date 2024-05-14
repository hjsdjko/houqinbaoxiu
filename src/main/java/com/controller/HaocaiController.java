
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 耗材
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/haocai")
public class HaocaiController {
    private static final Logger logger = LoggerFactory.getLogger(HaocaiController.class);

    @Autowired
    private HaocaiService haocaiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private HouqinrenyuanService houqinrenyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("后勤人员".equals(role))
            params.put("houqinrenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = haocaiService.queryPage(params);

        //字典表数据转换
        List<HaocaiView> list =(List<HaocaiView>)page.getList();
        for(HaocaiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HaocaiEntity haocai = haocaiService.selectById(id);
        if(haocai !=null){
            //entity转view
            HaocaiView view = new HaocaiView();
            BeanUtils.copyProperties( haocai , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HaocaiEntity haocai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,haocai:{}",this.getClass().getName(),haocai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HaocaiEntity> queryWrapper = new EntityWrapper<HaocaiEntity>()
            .eq("haocai_uuid_number", haocai.getHaocaiUuidNumber())
            .eq("haocai_name", haocai.getHaocaiName())
            .eq("haocai_types", haocai.getHaocaiTypes())
            .eq("haocai_kucun_number", haocai.getHaocaiKucunNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HaocaiEntity haocaiEntity = haocaiService.selectOne(queryWrapper);
        if(haocaiEntity==null){
            haocai.setInsertTime(new Date());
            haocai.setCreateTime(new Date());
            haocaiService.insert(haocai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HaocaiEntity haocai, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,haocai:{}",this.getClass().getName(),haocai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HaocaiEntity> queryWrapper = new EntityWrapper<HaocaiEntity>()
            .notIn("id",haocai.getId())
            .andNew()
            .eq("haocai_uuid_number", haocai.getHaocaiUuidNumber())
            .eq("haocai_name", haocai.getHaocaiName())
            .eq("haocai_types", haocai.getHaocaiTypes())
            .eq("haocai_kucun_number", haocai.getHaocaiKucunNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HaocaiEntity haocaiEntity = haocaiService.selectOne(queryWrapper);
        if("".equals(haocai.getHaocaiPhoto()) || "null".equals(haocai.getHaocaiPhoto())){
                haocai.setHaocaiPhoto(null);
        }
        if(haocaiEntity==null){
            haocaiService.updateById(haocai);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        haocaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HaocaiEntity> haocaiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HaocaiEntity haocaiEntity = new HaocaiEntity();
//                            haocaiEntity.setHaocaiUuidNumber(data.get(0));                    //耗材编号 要改的
//                            haocaiEntity.setHaocaiName(data.get(0));                    //耗材名称 要改的
//                            haocaiEntity.setHaocaiPhoto("");//详情和图片
//                            haocaiEntity.setHaocaiTypes(Integer.valueOf(data.get(0)));   //耗材类型 要改的
//                            haocaiEntity.setHaocaiKucunNumber(Integer.valueOf(data.get(0)));   //耗材库存数量 要改的
//                            haocaiEntity.setHaocaiContent("");//详情和图片
//                            haocaiEntity.setInsertTime(date);//时间
//                            haocaiEntity.setCreateTime(date);//时间
                            haocaiList.add(haocaiEntity);


                            //把要查询是否重复的字段放入map中
                                //耗材编号
                                if(seachFields.containsKey("haocaiUuidNumber")){
                                    List<String> haocaiUuidNumber = seachFields.get("haocaiUuidNumber");
                                    haocaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> haocaiUuidNumber = new ArrayList<>();
                                    haocaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("haocaiUuidNumber",haocaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //耗材编号
                        List<HaocaiEntity> haocaiEntities_haocaiUuidNumber = haocaiService.selectList(new EntityWrapper<HaocaiEntity>().in("haocai_uuid_number", seachFields.get("haocaiUuidNumber")));
                        if(haocaiEntities_haocaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HaocaiEntity s:haocaiEntities_haocaiUuidNumber){
                                repeatFields.add(s.getHaocaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [耗材编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        haocaiService.insertBatch(haocaiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
