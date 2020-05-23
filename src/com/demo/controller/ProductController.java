package com.demo.controller;

import com.demo.beans.AjaxRespInfo;
import com.demo.beans.ProductInfo;
import com.demo.beans.ProductTypeInfo;
import com.demo.common.ValidatorGroup1;
import com.demo.common.ValidatorGroup2;
import com.demo.service.ProductService;
import com.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Controller
@RequestMapping("/prd")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;



    @RequestMapping(path="/list")
    /*@ResponseBody*/
    public String prdList(ModelMap model) throws Exception {
       model.addAttribute("prdList",this.productService.findAllProducts());
       return  "prd/list"  ;
    }


    @PostMapping(value = "/add")
    public String add(/*@Validated( value = ValidatorGroup1.class)*/ ProductInfo prdInfo, BindingResult bindingResult, ModelMap map){
        List<String> msgs=new ArrayList<>();
        if(bindingResult.hasFieldErrors()){
            return "prd/add";
          /*  List<FieldError> errors=bindingResult.getFieldErrors();
           for (FieldError error:errors){
               msgs.add(error.getDefaultMessage());
           }*/
        }
        /*         if(msgs.size()>0){
             map.addAttribute("msgs",msgs);
             return "prd/add";
         }*/
        if(prdInfo!=null){
            if(prdInfo.getTypeId()!=null&&prdInfo.getTypeId()==0){
                prdInfo.setTypeId(null);
            }
        }
        //将客户端提交的参数保存到数据库中
        boolean result=this.productService.saveInfo(prdInfo);
        map.addAttribute("msg",result?"保存成功！":"保存失败！");
        return  "redirect:/prd/add";
    }
    @GetMapping(value = "/add")
    public String add(){

        return  "prd/add";
    }

    @ModelAttribute("typeList")
    public List<ProductTypeInfo> findProductTypes(){
        return this.productTypeService.findAllTypes();
    }

    @GetMapping(value = "/test")
    public String test(){
        return "my_view1";
    }

    @GetMapping(path="/edit/{prdId}")
    public String edit(@PathVariable Integer prdId, Model model){
        System.out.println("服务器端得到的商品编号为："+prdId);
        ProductInfo prdInfo=this.productService.findProductById(prdId);

        model.addAttribute("productInfo",prdInfo);
        model.addAttribute("typeList",this.productTypeService.findAllTypes());
        return "prd/edit";
    }
    @PostMapping("/edit")
    public String edit(/*@Validated(value = {ValidatorGroup2.class, Default.class})*/ ProductInfo productInfo, BindingResult bindingResult){
       if(bindingResult.hasFieldErrors()){
           return "prd/edit";
       }
       //调用业务层执行商品信息的编辑
        System.out.println("修改数据库中的商品信息");
        return  "redirect:/prd/list";
    }


     @PostMapping("/ajax/add")
     @ResponseBody
     public AjaxRespInfo ajaxAdd(@RequestBody ProductInfo productInfo){
             boolean result=this.productService.saveInfo(productInfo);

             AjaxRespInfo ajaxRespInfo=new AjaxRespInfo();
             if(result){
                 ajaxRespInfo.setCode(0);

             }else {
                 ajaxRespInfo.setCode(-1);
                 ajaxRespInfo.setMsg("数据库操作失败");
             }
             return  ajaxRespInfo;
     }
}
