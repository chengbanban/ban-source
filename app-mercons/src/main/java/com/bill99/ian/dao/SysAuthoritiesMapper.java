package com.bill99.ian.dao;

import com.bill99.ian.entity.SysAuthorities;
import java.util.List;

public interface SysAuthoritiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_authorities
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int deleteByPrimaryKey(String authorityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_authorities
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int insert(SysAuthorities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_authorities
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    SysAuthorities selectByPrimaryKey(String authorityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_authorities
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    List<SysAuthorities> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_authorities
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int updateByPrimaryKey(SysAuthorities record);
}