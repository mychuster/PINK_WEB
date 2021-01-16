package com.work.pinkweb.Controller;

import com.work.pinkweb.Entity.Admin;
import com.work.pinkweb.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/sign")
    public String adminSign() {
        return "sign";
    }

    @GetMapping("/regist")
    public String adminRegist() {
        return "regist";
    }

    @PostMapping("/sign")
    public String adminSign(@RequestParam("admin_id") Integer admin_id,
                            @RequestParam("admin_power") Integer admin_power,
                            Model model) {
        Admin admin = adminService.getallAdminById(admin_id);
        if(admin!= null){
            if(admin.getAdmin_power() == admin_power){
                return "admin_sign_success";
            }else{
                model.addAttribute("msg","密码错误");
                return "sign";
            }
        }else{
            model.addAttribute("msg","账户不存在");
            return "sign";
        }

    }

    @PostMapping("/regist")
    public String adminRegist(@RequestParam("admin_id") Integer admin_id,
                              @RequestParam("admin_name") String admin_name,
                              @RequestParam("admin_power") Integer admin_power
                              ) {
        Admin admin = new Admin(admin_id,admin_name,admin_power);
        adminService.addAdminInfo(admin);
        return "admin_regist_success";
    }
}
