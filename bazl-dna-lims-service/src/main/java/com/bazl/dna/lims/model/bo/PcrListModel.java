package com.bazl.dna.lims.model.bo;

import com.bazl.dna.lims.model.po.LabPcrSample;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LX on 2019/9/25.
 */
public class PcrListModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<LabPcrSample> labPcrSampleList;

    private List<List<LabPcrSample>> listList;

    public List<LabPcrSample> getLabPcrSampleList() {
        return labPcrSampleList;
    }

    public void setLabPcrSampleList(List<LabPcrSample> labPcrSampleList) {
        this.labPcrSampleList = labPcrSampleList;
    }

    public List<List<LabPcrSample>> getListList() {
        return listList;
    }

    public void setListList(List<List<LabPcrSample>> listList) {
        this.listList = listList;
    }
}
