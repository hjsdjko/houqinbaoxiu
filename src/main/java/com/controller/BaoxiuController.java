
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
 * 报修
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baoxiu")
public class BaoxiuController {
    private static final Logger logger = LoggerFactory.getLogger(BaoxiuController.class);

    @Autowired
    private BaoxiuService baoxiuService;


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
        PageUtils page = baoxiuService.queryPage(params);

        //字典表数据转换
        List<BaoxiuView> list =(List<BaoxiuView>)page.getList();
        for(BaoxiuView c:list){
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
        BaoxiuEntity baoxiu = baoxiuService.selectById(id);
        if(baoxiu !=null){
            //entity转view
            BaoxiuView view = new BaoxiuView();
            BeanUtils.copyProperties( baoxiu , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(baoxiu.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //级联表
                HouqinrenyuanEntity houqinrenyuan = houqinrenyuanService.selectById(baoxiu.getHouqinrenyuanId());
                if(houqinrenyuan != null){
                    BeanUtils.copyProperties( houqinrenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHouqinrenyuanId(houqinrenyuan.getId());
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
    public R save(@RequestBody BaoxiuEntity baoxiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoxiu:{}",this.getClass().getName(),baoxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role)){
            baoxiu.setBaoxiuZhuangtaiTypes(1);
            baoxiu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        else if("后勤人员".equals(role))
            baoxiu.setHouqinrenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BaoxiuEntity> queryWrapper = new EntityWrapper<BaoxiuEntity>()
            .eq("xuesheng_id", baoxiu.getXueshengId())
            .eq("houqinrenyuan_id", baoxiu.getHouqinrenyuanId())
            .eq("baoxiu_uuid_number", baoxiu.getBaoxiuUuidNumber())
            .eq("baoxiu_name", baoxiu.getBaoxiuName())
            .eq("baoxiu_wupin_name", baoxiu.getBaoxiuWupinName())
            .eq("baoxiu_address", baoxiu.getBaoxiuAddress())
            .eq("baoxiu_types", baoxiu.getBaoxiuTypes())
            .eq("baoxiu_zhuangtai_types", baoxiu.getBaoxiuZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxiuEntity baoxiuEntity = baoxiuService.selectOne(queryWrapper);
        if(baoxiuEntity==null){
            baoxiu.setInsertTime(new Date());
            baoxiu.setCreateTime(new Date());
            baoxiuService.insert(baoxiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoxiuEntity baoxiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,baoxiu:{}",this.getClass().getName(),baoxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            baoxiu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("后勤人员".equals(role))
//            baoxiu.setHouqinrenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BaoxiuEntity> queryWrapper = new EntityWrapper<BaoxiuEntity>()
            .notIn("id",baoxiu.getId())
            .andNew()
            .eq("xuesheng_id", baoxiu.getXueshengId())
            .eq("houqinrenyuan_id", baoxiu.getHouqinrenyuanId())
            .eq("baoxiu_uuid_number", baoxiu.getBaoxiuUuidNumber())
            .eq("baoxiu_name", baoxiu.getBaoxiuName())
            .eq("baoxiu_wupin_name", baoxiu.getBaoxiuWupinName())
            .eq("baoxiu_address", baoxiu.getBaoxiuAddress())
            .eq("baoxiu_types", baoxiu.getBaoxiuTypes())
            .eq("baoxiu_zhuangtai_types", baoxiu.getBaoxiuZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxiuEntity baoxiuEntity = baoxiuService.selectOne(queryWrapper);
        if(baoxiuEntity==null){
            baoxiuService.updateById(baoxiu);//根据id更新
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
        baoxiuService.deleteBatchIds(Arrays.asList(ids));
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
            List<BaoxiuEntity> baoxiuList = new ArrayList<>();//上传的东西
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
                            BaoxiuEntity baoxiuEntity = new BaoxiuEntity();
//                            baoxiuEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            baoxiuEntity.setHouqinrenyuanId(Integer.valueOf(data.get(0)));   //后勤人员 要改的
//                            baoxiuEntity.setBaoxiuUuidNumber(data.get(0));                    //报修编号 要改的
//                            baoxiuEntity.setBaoxiuName(data.get(0));                    //报修名称 要改的
//                            baoxiuEntity.setBaoxiuWupinName(data.get(0));                    //报修物品 要改的
//                            baoxiuEntity.setBaoxiuAddress(data.get(0));                    //报修地点 要改的
//                            baoxiuEntity.setBaoxiuTypes(Integer.valueOf(data.get(0)));   //报修类型 要改的
//                            baoxiuEntity.setInsertTime(date);//时间
//                            baoxiuEntity.setBaoxiuContent("");//详情和图片
//                            baoxiuEntity.setBaoxiuZhuangtaiTypes(Integer.valueOf(data.get(0)));   //报修状态 要改的
//                            baoxiuEntity.setCreateTime(date);//时间
                            baoxiuList.add(baoxiuEntity);


                            //把要查询是否重复的字段放入map中
                                //报修编号
                                if(seachFields.containsKey("baoxiuUuidNumber")){
                                    List<String> baoxiuUuidNumber = seachFields.get("baoxiuUuidNumber");
                                    baoxiuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> baoxiuUuidNumber = new ArrayList<>();
                                    baoxiuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("baoxiuUuidNumber",baoxiuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报修编号
                        List<BaoxiuEntity> baoxiuEntities_baoxiuUuidNumber = baoxiuService.selectList(new EntityWrapper<BaoxiuEntity>().in("baoxiu_uuid_number", seachFields.get("baoxiuUuidNumber")));
                        if(baoxiuEntities_baoxiuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BaoxiuEntity s:baoxiuEntities_baoxiuUuidNumber){
                                repeatFields.add(s.getBaoxiuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报修编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        baoxiuService.insertBatch(baoxiuList);
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
