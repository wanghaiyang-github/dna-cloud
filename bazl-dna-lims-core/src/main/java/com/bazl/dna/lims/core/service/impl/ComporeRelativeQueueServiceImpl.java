package com.bazl.dna.lims.core.service.impl;

import com.bazl.dna.lims.core.dao.ComporeRelativeQueueMapper;
import com.bazl.dna.lims.core.model.PageInfo;
import com.bazl.dna.lims.core.model.vo.ComporeRelativeQueueVo;
import com.bazl.dna.lims.core.service.ComporeRelativeQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huawei on 2019/8/6.
 */
@Service
public class ComporeRelativeQueueServiceImpl extends BaseService implements ComporeRelativeQueueService {

    @Autowired
    ComporeRelativeQueueMapper comporeRelativeQueueMapper;

    public List<ComporeRelativeQueueVo> selectVOPaginationList(ComporeRelativeQueueVo query, PageInfo pageInfo) {
        List<ComporeRelativeQueueVo> comporeSameQueueVoList = null;
        int pageNo;
        int pageSize;
        try {
            pageNo = pageInfo.getPage();
            pageSize = pageInfo.getEvePageRecordCnt();
            query.setOffset((pageNo - 1) * pageSize);
            query.setRows(query.getOffset() + pageSize);

            comporeSameQueueVoList = comporeRelativeQueueMapper.selectVOPaginationList(query);
        } catch(Exception ex) {
            logger.info("查询同一比对队列报错："+ex);
            return null;
        }

        return comporeSameQueueVoList;
    }

    public int selectVOCount(ComporeRelativeQueueVo query) {
        return comporeRelativeQueueMapper.selectVOCount(query);
    }


}
