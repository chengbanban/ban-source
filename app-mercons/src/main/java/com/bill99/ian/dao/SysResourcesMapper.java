package com.bill99.ian.dao;

import com.bill99.ian.entity.SysResources;
import java.util.List;

public interface SysResourcesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    int insert(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    List<SysResources> selectAll();
}