package com.bazl.dna.lims.core.service;

import com.bazl.dna.lims.core.model.po.FileArchivesInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/12/21.
 */
@Repository
public interface FileArchivesInfoService {

    int insert(FileArchivesInfo fileArchivesInfo);


    FileArchivesInfo queryFileLetter(String caseId);

    FileArchivesInfo queryEntrustBook(String caseId);
}
