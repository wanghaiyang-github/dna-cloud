package com.bazl.dna.database.nation.converter.dao;

import com.bazl.dna.database.nation.converter.model.po.LabInfo;
import java.util.List;

public interface LabInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LAB_INFO
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LAB_INFO
     *
     * @mbggenerated
     */
    int insert(LabInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LAB_INFO
     *
     * @mbggenerated
     */
    LabInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LAB_INFO
     *
     * @mbggenerated
     */
    List<LabInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LAB_INFO
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LabInfo record);

    List<LabInfo> getlabInfoList(String initServerNoLike);
}