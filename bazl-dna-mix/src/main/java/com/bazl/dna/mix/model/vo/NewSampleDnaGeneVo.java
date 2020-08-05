package com.bazl.dna.mix.model.vo;

import java.io.Serializable;

public class NewSampleDnaGeneVo extends AbstractBaseVO<NewSampleDnaGene>  implements Serializable {

	private static final long serialVersionUID = 1L;
	
    public NewSampleDnaGeneVo() {
        super();
        this.entity = new NewSampleDnaGene();
    }

    public NewSampleDnaGeneVo(NewSampleDnaGene entity) {
        super();
        this.entity = entity;
    }

    // 案件表
    private  String caseId;

    private String caseNo;

    private String caseName;

    //地区表
    private String regionalismCode;

    private String regionalismName;

    private String parentCode;

    //样本表
    private String sampleNo;

    private String sampleName;


    //人员表
    private String personName;
    private String personSex;

    //字典项(人员表与词典表关联查出来的人员类型)
    private String personType;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getRegionalismCode() {
        return regionalismCode;
    }

    public void setRegionalismCode(String regionalismCode) {
        this.regionalismCode = regionalismCode;
    }

    public String getRegionalismName() {
        return regionalismName;
    }

    public void setRegionalismName(String regionalismName) {
        this.regionalismName = regionalismName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
}