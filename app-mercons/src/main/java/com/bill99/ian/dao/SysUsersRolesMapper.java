package com.bill99.ian.dao;

import java.util.List;

import com.bill99.ian.entity.SysUsersRoles;

public interface SysUsersRolesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int insert(SysUsersRoles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    SysUsersRoles selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    List<SysUsersRoles> selectAll();
    
    List<SysUsersRoles> selectByUserId(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int updateByPrimaryKey(SysUsersRoles record);
}