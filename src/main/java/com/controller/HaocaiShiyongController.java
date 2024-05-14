
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
 * 耗材使用
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/haocaiShiyong")
public class HaocaiShiyongController {
    private static final Logger logger = LoggerFactory.getLogger(HaocaiShiyongController.class);

    @Autowired
    private HaocaiShiyongService haocaiShiyongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private BaoxiuService baoxiuService;
    @Autowired
    private HaocaiService haocaiService;

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
        PageUtils page = haocaiShiyongService.queryPage(params);

        //字典表数据转换
        List<HaocaiShiyongView> list =(List<HaocaiShiyongView>)page.getList();
        for(HaocaiShiyongView c:list){
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
        HaocaiShiyongEntity haocaiShiyong = haocaiShiyongService.selectById(id);
        if(haocaiShiyong !=null){
            //entity转view
            HaocaiShiyongView view = new HaocaiShiyongView();
            BeanUtils.copyProperties( haocaiShiyong , view );//把实体数据重构到view中

                //级联表
                BaoxiuEntity baoxiu = baoxiuService.selectById(haocaiShiyong.getBaoxiuId());
                if(baoxiu != null){
                    BeanUtils.copyProperties( baoxiu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBaoxiuId(baoxiu.getId());
                }
                //级联表
                HaocaiEntity haocai = haocaiService.selectById(haocaiShiyong.getHaocaiId());
                if(haocai != null){
                    BeanUtils.copyProperties( haocai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHaocaiId(haocai.getId());
                }
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
    public R save(@RequestBody HaocaiShiyongEntity haocaiShiyong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,haocaiShiyong:{}",this.getClass().getName(),haocaiShiyong.toString());


        HaocaiEntity haocaiEntity = haocaiService.selectById(haocaiShiyong.getHaocaiId());
        if(haocaiEntity == null)
            return R.error("查不到耗材");
        int balance = haocaiEntity.getHaocaiKucunNumber() - haocaiShiyong.getHaocaiShiyongNumber();
        if(balance <0)
            return R.error("库存没有那么多耗材,请核实后再使用");

        haocaiEntity.setHaocaiKucunNumber(balance);
        haocaiService.updateById(haocaiEntity);

        haocaiShiyong.setInsertTime(new Date());
            haocaiShiyong.setCreateTime(new Date());
            haocaiShiyongService.insert(haocaiShiyong);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HaocaiShiyongEntity haocaiShiyong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,haocaiShiyong:{}",this.getClass().getName(),haocaiShiyong.toString());

            haocaiShiyongService.updateById(haocaiShiyong);//根据id更新
            return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        haocaiShiyongService.deleteBatchIds(Arrays.asList(ids));
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
            List<HaocaiShiyongEntity> haocaiShiyongList = new ArrayList<>();//上传的东西
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
                            HaocaiShiyongEntity haocaiShiyongEntity = new HaocaiShiyongEntity();
//                            haocaiShiyongEntity.setHaocaiId(Integer.valueOf(data.get(0)));   //耗材 要改的
//                            haocaiShiyongEntity.setBaoxiuId(Integer.valueOf(data.get(0)));   //报修 要改的
//                            haocaiShiyongEntity.setHaocaiShiyongUuidNumber(data.get(0));                    //耗材使用编号 要改的
//                            haocaiShiyongEntity.setHaocaiShiyongNumber(Integer.valueOf(data.get(0)));   //使用数量 要改的
//                            haocaiShiyongEntity.setHaocaiShiyongContent("");//详情和图片
//                            haocaiShiyongEntity.setInsertTime(date);//时间
//                            haocaiShiyongEntity.setCreateTime(date);//时间
                            haocaiShiyongList.add(haocaiShiyongEntity);


                            //把要查询是否重复的字段放入map中
                                //耗材使用编号
                                if(seachFields.containsKey("haocaiShiyongUuidNumber")){
                                    List<String> haocaiShiyongUuidNumber = seachFields.get("haocaiShiyongUuidNumber");
                                    haocaiShiyongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> haocaiShiyongUuidNumber = new ArrayList<>();
                                    haocaiShiyongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("haocaiShiyongUuidNumber",haocaiShiyongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //耗材使用编号
                        List<HaocaiShiyongEntity> haocaiShiyongEntities_haocaiShiyongUuidNumber = haocaiShiyongService.selectList(new EntityWrapper<HaocaiShiyongEntity>().in("haocai_shiyong_uuid_number", seachFields.get("haocaiShiyongUuidNumber")));
                        if(haocaiShiyongEntities_haocaiShiyongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HaocaiShiyongEntity s:haocaiShiyongEntities_haocaiShiyongUuidNumber){
                                repeatFields.add(s.getHaocaiShiyongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [耗材使用编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        haocaiShiyongService.insertBatch(haocaiShiyongList);
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
