package com.work.pinkweb.Mapper;

import com.work.pinkweb.Entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where admin_id = #{id}")
    Admin getallAdminById(Integer id);

    @Insert("INSERT INTO admin(admin_id,admin_pwd,admin_name,admin_power) VALUES(#{admin_id},#{admin_pwd},#{admin_name},#{admin_power})")
    Integer addAdminInfo(Admin admin);
}
