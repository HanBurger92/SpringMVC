package com.springmvc.controller;

import com.springmvc.entity.Consumer;
import com.springmvc.entity.Product;
import com.springmvc.entity.Supplier;
import com.springmvc.service.BasicDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mainPage/basicDataManagement")
public class BasicDataManagementController {

    @Autowired
    private BasicDataManagementService basicDataManagementService;

    private static String AUTHORIZATION_ERROR = "This account is not authorized to perform this action";
    private static String DUPLICATE_INSERTION_ERROR = "Duplicated Code, Insertion failed";
    private static String SUCCESS = "Completed";

    // Consumer query
    @RequestMapping(value = "/consumerSelect", method = RequestMethod.POST)
    public ModelAndView consumerSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Consumer> consumerList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        map.put("name", request.getParameter("name"));
        map.put("linkman", request.getParameter("linkmanSearch"));
        consumerList = basicDataManagementService.consumerSelect(map);
        modelAndView.setViewName("basicDataManagement");
        modelAndView.addObject("consumerList",consumerList);
        return modelAndView;
    }

    @RequestMapping(value = "/consumerInsert", method = RequestMethod.POST)
    public ModelAndView consumerInsert(Consumer consumer, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        List<Consumer> consumerList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", consumer.getConsumerCode()); // front-end data will be kept in the form of "Object Consumer"
        consumerList = basicDataManagementService.consumerSelect(map);
        System.out.println(consumer.toString());

        // To check if the data is duplicate refers to Code
        if(!consumerList.isEmpty()){
            modelAndView.addObject("msg",DUPLICATE_INSERTION_ERROR);
        }else if(!session.getAttribute("role").toString().equals("manager")){
            modelAndView.addObject("msg", AUTHORIZATION_ERROR);
        }else {
            modelAndView.addObject("msg", SUCCESS);
            basicDataManagementService.insertConsumer(consumer);
        }
        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/consumerDelete", method = RequestMethod.GET)
    public ModelAndView consumerDelete(@RequestParam String consumerCode, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").equals("manager")){
            modelAndView.addObject("msg", AUTHORIZATION_ERROR);
        }else {
            basicDataManagementService.deleteConsumer(consumerCode);
            modelAndView.addObject("msg",SUCCESS);
        }

        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/consumerUpdate", method = RequestMethod.POST)
    public ModelAndView consumerUpdate(Consumer consumer, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            modelAndView.addObject("msg", AUTHORIZATION_ERROR);
        }else {
            basicDataManagementService.updateConsumer(consumer);
            modelAndView.addObject("msg",SUCCESS);
        }

        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    // Supplier query
    @RequestMapping(value = "/supplierSelect", method = RequestMethod.POST)
    public ModelAndView supplierSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> supplierList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        map.put("name", request.getParameter("name"));
        map.put("linkman", request.getParameter("linkmanSearch"));
        supplierList = basicDataManagementService.supplierSelect(map);
        modelAndView.setViewName("basicDataManagement");
        modelAndView.addObject("supplierList",supplierList);
        return modelAndView;
    }

    @RequestMapping(value = "/supplierInsert", method = RequestMethod.POST)
    public ModelAndView supplierInsert(Supplier supplier, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        List<Supplier> supplierList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", supplier.getSupplierCode());
        supplierList = basicDataManagementService.supplierSelect(map);

        // To check if the data is duplicate refers to Code
        if(!supplierList.isEmpty()){
            modelAndView.addObject("msg",DUPLICATE_INSERTION_ERROR);
        }else if(!session.getAttribute("role").toString().equals("manager")) {
            modelAndView.addObject("msg",AUTHORIZATION_ERROR);
        }else{
                modelAndView.addObject("msg", SUCCESS);
                basicDataManagementService.insertSupplier(supplier);
        }
        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/supplierDelete", method = RequestMethod.GET)
    public ModelAndView supplierDelete(@RequestParam String supplierCode, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            modelAndView.addObject("msg",AUTHORIZATION_ERROR);
        }else{
            basicDataManagementService.deleteSupplier(supplierCode);
            modelAndView.addObject("msg",SUCCESS);
        }
        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/supplierUpdate", method = RequestMethod.POST)
    public ModelAndView supplierUpdate(HttpServletRequest request, Supplier supplier){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            modelAndView.addObject("msg", AUTHORIZATION_ERROR);
        }else{
            basicDataManagementService.updateSupplier(supplier);
            modelAndView.addObject("msg",SUCCESS);
        }

        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    // Product Query
    @RequestMapping(value = "/productSelect", method = RequestMethod.POST)
    public ModelAndView productSelect(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        map.put("name", request.getParameter("name"));
        map.put("category", request.getParameter("categorySearch"));
        productList = basicDataManagementService.productSelect(map);
        modelAndView.setViewName("basicDataManagement");
        modelAndView.addObject("productList",productList);
        return modelAndView;
    }

    @RequestMapping(value = "/productInsert", method = RequestMethod.POST)
    public ModelAndView productInsert(Product product, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        List<Product> productList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", product.getProductCode());
        productList = basicDataManagementService.productSelect(map);

        // To check if the data is duplicate refers to Code
        if(!productList.isEmpty()){
            modelAndView.addObject("msg",DUPLICATE_INSERTION_ERROR);
        }else if(!session.getAttribute("role").toString().equals("manager")) {
            modelAndView.addObject("msg",AUTHORIZATION_ERROR);
        }else{
            modelAndView.addObject("msg", SUCCESS);
            basicDataManagementService.insertProduct(product);
        }
        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/productDelete", method = RequestMethod.GET)
    public ModelAndView productDelete(@RequestParam String productCode, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            modelAndView.addObject("msg",AUTHORIZATION_ERROR);
        }else{
            basicDataManagementService.deleteProduct(productCode);
            modelAndView.addObject("msg",SUCCESS);
        }

        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
    public ModelAndView productUpdate(Product product, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();

        if(!session.getAttribute("role").toString().equals("manager")){
            modelAndView.addObject("msg",AUTHORIZATION_ERROR);
        }else{
            basicDataManagementService.updateProduct(product);
            modelAndView.addObject("msg",SUCCESS);
        }

        modelAndView.setViewName("basicDataManagement");
        return modelAndView;
    }
}
