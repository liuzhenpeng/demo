package com.example.mapper;

import com.example.pojo.KdUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface KdUserMapper {
    List<KdUser> getUsers();
    KdUser getUser(@Param("userId") int id);
    int insertUser(KdUser user );
    int updateUser(Map<String,Object> map);
    int deleteUser(Map<String,Object> map);
}
