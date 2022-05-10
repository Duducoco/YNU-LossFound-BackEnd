package com.ynu.lossfound.mapper;

import com.ynu.lossfound.bean.Found;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoundMapper {
    @Insert("insert into found (`foundName`,`foundLocation`, `foundTime`, `releaseTime`, `imageUrl`, `studentIDFeature`,`phoneFeature`, `emailFeature`,`otherFeature`,`author`,`foundNowLocation`,`authorTeleMethod`,`isReturn`) " +
            "values (#{foundName}, #{foundLocation}, #{foundTime}, #{releaseTime}, #{imageUrl}, #{studentIDFeature}, #{phoneFeature}, #{emailFeature}, #{otherFeature}, #{author},#{foundNowLocation},#{authorTeleMethod},#{isReturn})")
    public void insertFound(Found found);

    @Select("select * from found where isReturn=false order by foundID desc limit 10 offset #{start}")
    public List<Found> selectFound(int start);

    @Select("select count(*) from found where isReturn=false")
    public int selectFoundCount();

    @Select("select * from found where author=#{studentID}")
    public List<Found> selectFoundByStudentID(String studentID);

    @Delete("delete from found where foundID=#{foundID}")
    public int deleteFound(int foundID);
}
