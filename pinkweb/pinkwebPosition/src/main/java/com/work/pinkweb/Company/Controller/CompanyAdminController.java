package com.work.pinkweb.Company.Controller;

import com.work.pinkweb.Entity.CompanyAdmin;
import com.work.pinkweb.Entity.CompanyHr;
import com.work.pinkweb.Company.Service.CompanyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CompanyAdminController {
    @Autowired
    private CompanyAdminService companyAdminService;

    @RequestMapping("/company/profile/{ea_id}")
    public CompanyAdmin getCompanyInfo(@PathVariable("ea_id")Integer ea_id){
        System.err.println(ea_id);
        return companyAdminService.getCompanyInfo(ea_id);
    }

    @RequestMapping("/company/list/{ea_id}")
    public List<CompanyHr> getCompanyHrList(@PathVariable("ea_id")Integer ea_id){
        List<CompanyAdmin> list1=companyAdminService.getCompanyHrList(ea_id);
        List<CompanyHr> list2=new LinkedList<>();
        for (int i = 0; i < list1.size(); i++) {
            System.err.println(list1.get(i).getCompany().getCompanyHrList().get(0));
            list2.add(list1.get(i).getCompany().getCompanyHrList().get(0));
        }
        return list2;
    }

}
