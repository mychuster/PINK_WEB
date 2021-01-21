package com.work.pinkweb.Mapper;

import com.work.pinkweb.Entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where admin_id = #{id}")
    Admin getallAdminById(Integer id);

    @Select("select * from admin")
    List<Admin> findAllAdmin();

    @Insert("INSERT INTO admin(admin_id,admin_pwd,admin_name,admin_power,admin_time) VALUES(#{admin_id},#{admin_pwd},#{admin_name},#{admin_power},'2020-12-21 09:09:09')")
    Integer addAdminInfo(Admin admin);

    @Update("update admin set admin_pwd=#{admin_pwd},admin_name=#{admin_name},admin_power=#{admin_power} where admin_id=#{admin_id}")
    Integer updateAdminByID(Admin admin);

    @Delete("delete from admin where admin_id=#{id}")
    Integer deleteAdmin(Integer id);

    @Select("select * from admin where admin_name like'%${adminName}%'")
    List<Admin> findAdminByName(String adminName);
}
