package com.bazl.dna.lims.service;

import java.util.List;

import com.bazl.dna.common.PageInfo;
import com.bazl.dna.lims.model.po.LabExtractInfo;
import com.bazl.dna.lims.model.vo.LabExtractInfoVo;

/**
 * @author wanghaiyang
 * @date 2019/3/8.
 */
public interface LabExtractInfoService {

    /**
     * 根据extractId删除信息
     * @param extractId
     * @return
     */
    public int deleteByPrimaryKey(String extractId);

    /**
     * 插入信息
     * @param record
     * @return
     */
    public int insert(LabExtractInfo record);

    /**
     * 根据extractId查询信息
     * @param extractId
     * @return
     */
    public LabExtractInfo selectByPrimaryKey(String extractId);

    /**
     * 查询所有的信息
     * @return
     */
    public List<LabExtractInfo> selectAll();

    /**
     * 更新信息
     * @param record
     * @return
     */
    public int updateByPrimaryKey(LabExtractInfo record);

    /**
     * 根据任务id查询提取记录信息
     * @param taskId
     * @return
     */
    public List<LabExtractInfo> selectByTaskId(String taskId);


    public List<LabExtractInfoVo> selectVoList(LabExtractInfoVo labExtractInfoVo, PageInfo pageInfo);

    public int selectVOCount(LabExtractInfoVo labExtractInfoVo);

    /**
     * 根据案件id查询实验信息
     * @param caseId
     * @return
     */
    public List<LabExtractInfo> selectByCaseId(String caseId);

    /**
     * 根据机构编号，提取状态查询提取数据
     * @param orgId
     * @param extractStage
     * @return
     */
    public int selectExtractCount(String orgId, String extractStage);

    /**
     * 分页查询提取状态列表
     * @param query
     * @param pageInfo
     * @return
     */
    public List<LabExtractInfoVo> selectPaginationQuery(LabExtractInfoVo query, PageInfo pageInfo);
}
