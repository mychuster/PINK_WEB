package com.work.pinkweb.Service;

import com.work.pinkweb.Entity.Admin;

import java.util.List;

public interface AdminService {
    Admin getallAdminById(Integer id);
    Integer addAdminInfo(Admin admin);
    List<Admin> findAllAdmin();
    Integer updateAdminByID(Admin admin);
    Integer deleteAdmin(Integer id);
    List<Admin> findAdminByName(String adminName);
}
