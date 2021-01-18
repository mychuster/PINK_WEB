package com.work.pinkweb.Controller;

import com.work.pinkweb.Entity.Admin;
import com.work.pinkweb.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/login/admin_login")
    public String adminSign() {
        return "admin_login";
    }

    @GetMapping("/register/admin_register")
    public String adminRegist() {
        return "admin_register";
    }

    @PostMapping("/login/admin_login")
    public String adminSign(@RequestParam("admin_id") Integer admin_id,
                            @RequestParam("admin_pwd") Integer admin_pwd,
                            Model model) {
        Admin admin = adminService.getallAdminById(admin_id);
        if(admin!= null){
            if(admin.getAdmin_pwd() == admin_pwd){
                return "admin_home";
            }else{
                model.addAttribute("msg","密码错误");
                return "admin_login";
            }
        }else{
            model.addAttribute("msg","账户不存在");
            return "admin_login";
        }

    }

    @PostMapping("/register/admin_register")
    public String adminRegist(@RequestParam("admin_id") Integer admin_id,
                              @RequestParam("admin_pwd") Integer admin_pwd,
                              @RequestParam("admin_name") String admin_name,
                              @RequestParam("admin_power") Integer admin_power
                              ) {
        Admin admin = new Admin(admin_id,admin_pwd,admin_name,admin_power);
        adminService.addAdminInfo(admin);
        return "admin_register_success";
    }
}
