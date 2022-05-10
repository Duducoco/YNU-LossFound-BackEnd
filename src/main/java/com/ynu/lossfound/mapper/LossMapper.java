package com.ynu.lossfound.mapper;

import com.ynu.lossfound.bean.Loss;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LossMapper {

    @Insert("insert into loss (`lossName`, `lossLocation`, `lossTime`, `releaseTime`, `imageUrl`, `studentIDFeature`, `phoneFeature`, `emailFeature`,`otherFeature`,`author`,`authorTeleMethod`,`isFound`) " +
            "values (#{lossName}, #{lossLocation}, #{lossTime}, #{releaseTime}, #{imageUrl}, #{studentIDFeature}, #{phoneFeature}, #{emailFeature}, #{otherFeature},#{author},#{authorTeleMethod},#{isFound})")
    public void insertLoss(Loss loss);

    @Select("select * from loss where isFound=false order by releaseTime desc limit 10 offset #{start}")
    public List<Loss> selectLoss(int start);

    @Select("select * from loss where author=#{studentID}")
    public List<Loss> selectLossByStudentID(String studentID);

    @Select("select count(*) from loss where isFound=false")
    public int selectLossCount();

    @Delete("delete from loss where lossID=#{lossID}")
    public int deleteLossByLossID(int lossID);
}
