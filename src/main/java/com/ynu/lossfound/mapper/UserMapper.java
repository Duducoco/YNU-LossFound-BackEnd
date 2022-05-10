package com.ynu.lossfound.mapper;

import com.ynu.lossfound.bean.Found;
import com.ynu.lossfound.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user values (#{studentID}, #{name},#{phone}, #{email}, #{password}, #{avatarurl})")
    public int insert_user(User user);

    @Select("select * from user where studentID=#{studentID} and password=#{password}")
    public User select_user(String studentID, String password);

    @Select("select count(*) from user where studentID=#{studentID}")
    public int select_user_by_studentID(String studentID);

    @Update("update user set name=#{name}, phone=#{phone}, email=#{email},  avatarurl=#{avatarurl} where studentID=#{studentID}")
    public int update_user(User user);

    @Update("update user set password=#{password} where studentID=#{studentID} and password=#{origin_password}")
    public int update_user_password(String studentID, String origin_password, String password, String password2);

    @Select("select email from user where studentID=#{studentID}")
    public String select_email_by_studentID(String studentID);

    @Select("select email from user where phone=#{phone}")
    public String select_email_by_phone(String phone);

    @Select("select * from found where studentIDFeature=#{studentID}")
    public List<Found> select_found_by_host_studentID(String studentID);

    @Select("select * from found where phoneFeature=#{phone}")
    public List<Found> select_found_by_host_phone(String phone);

    @Select("select * from found where emailFeature=#{email}")
    public List<Found> select_found_by_host_email(String email);
}
