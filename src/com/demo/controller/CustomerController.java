package com.demo.controller;

import com.demo.beans.CustomerInfo;
import com.demo.beans.ProductInfo;
import com.demo.service.CustomerService;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/cst")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path="/list")
    public ModelAndView cstList() throws Exception {
        List<CustomerInfo> customerInfos=customerService.findAllCustomers();
        ModelAndView mav=new ModelAndView();
        mav.addObject("cstList",customerInfos);
        mav.setViewName("cst/list");
        return mav;

    }
    @GetMapping("/add")
    public String add(){
        return "cst/add";
    }
    @PostMapping("/add")
    public String add(CustomerInfo cstInfo,Model model){
        System.out.println(cstInfo.getFirstName());
       boolean result=this.customerService.saveInfo(cstInfo);
       model.addAttribute("msg",result?"保存成功":"保存失败");
       return "cst/add";


    }
}
