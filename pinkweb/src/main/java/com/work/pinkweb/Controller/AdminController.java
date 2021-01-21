package com.work.pinkweb.Controller;

import com.work.pinkweb.Entity.Admin;
import com.work.pinkweb.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String adminRegist(Admin admin) {
        adminService.addAdminInfo(admin);
        return "admin_register_success";
    }

    @GetMapping("/admin_list")
    public  String  getAllAdmin(Model model) {
        List<Admin> adminLists = adminService.findAllAdmin();
        model.addAttribute("admins",adminLists);
        return  "admin_list";
    }

    @GetMapping("/admin_update/{id}")
    public  String updateAdmin(@PathVariable("id")  Integer id,Model model){
        Admin admin = adminService.getallAdminById(id);
        model.addAttribute("adm",admin);
        return "admin_update";
    }

    @PostMapping("/admin_update")
    public String updateAdmin(Admin admin){
        adminService.updateAdminByID(admin);
        return "redirect:/admin_list";
    }

    @GetMapping("/admin_delete/{id}")
    public String deleteAdmin(@PathVariable("id")  Integer id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin_list";
    }

    @PostMapping("/admin_list")
    public String getAdminByID(@RequestParam("adminName")String adminName ,Model model){
        List<Admin> adminLists = adminService.findAdminByName(adminName);
        model.addAttribute("admins",adminLists);
        model.addAttribute("adminName",adminName);
        return "admin_list";
    }
}
