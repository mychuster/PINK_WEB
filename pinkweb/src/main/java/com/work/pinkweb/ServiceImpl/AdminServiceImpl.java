package com.work.pinkweb.ServiceImpl;

import com.work.pinkweb.Entity.Admin;
import com.work.pinkweb.Mapper.AdminMapper;
import com.work.pinkweb.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getallAdminById(Integer id) {
        Admin admin = adminMapper.getallAdminById(id);
        return admin;
    }

    @Override
    public Integer addAdminInfo(Admin admin) {
        return adminMapper.addAdminInfo(admin);
    }

    @Override
    public List<Admin> findAllAdmin() {
        List<Admin> lists = adminMapper.findAllAdmin();
        return lists;
    }

    @Override
    public Integer updateAdminByID(Admin admin) {
        return adminMapper.updateAdminByID(admin);
    }

    @Override
    public Integer deleteAdmin(Integer id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public List<Admin> findAdminByName(String adminName) {
        List<Admin> lists = adminMapper.findAdminByName(adminName);
        return lists;
    }
}
