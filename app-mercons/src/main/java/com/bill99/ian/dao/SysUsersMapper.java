package com.bill99.ian.dao;

import java.util.List;
import java.util.Map;

import com.bill99.ian.entity.SysAuthorities;
import com.bill99.ian.entity.SysUsers;

public interface SysUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int insert(SysUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    SysUsers selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    List<SysUsers> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int updateByPrimaryKey(SysUsers record);
    
    List<SysAuthorities> findAuthoritiesByMap(Map<String, String> map);

    SysUsers findByUserAccount(String userAccount);
    
    void getSeqUserId(Map<String, String> seqMap);
}