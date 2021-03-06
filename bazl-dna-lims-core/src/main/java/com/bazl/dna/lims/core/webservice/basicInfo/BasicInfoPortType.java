package com.bazl.dna.lims.core.webservice.basicInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.11
 * 2019-10-09T09:08:33.825+08:00
 * Generated source version: 3.0.11
 * 
 */
@WebService(targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", name = "basicInfoPortType")
@XmlSeeAlso({ObjectFactory.class})
public interface BasicInfoPortType {

    @WebMethod
    @RequestWrapper(localName = "getMutationList", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetMutationList")
    @ResponseWrapper(localName = "getMutationListResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetMutationListResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public ArrayOfWSMutation getMutationList();

    @WebMethod
    @RequestWrapper(localName = "getResultProcessState", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetResultProcessState")
    @ResponseWrapper(localName = "getResultProcessStateResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetResultProcessStateResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public com.bazl.dna.lims.core.webservice.basicInfo.ArrayOfWSResultProcessState getResultProcessState();

    @WebMethod
    @RequestWrapper(localName = "getSampleTypeList", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetSampleTypeList")
    @ResponseWrapper(localName = "getSampleTypeListResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetSampleTypeListResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public com.bazl.dna.lims.core.webservice.basicInfo.ArrayOfWSSampleType getSampleTypeList();

    @WebMethod
    @RequestWrapper(localName = "getPopulationList", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPopulationList")
    @ResponseWrapper(localName = "getPopulationListResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPopulationListResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public com.bazl.dna.lims.core.webservice.basicInfo.ArrayOfWSPopulation getPopulationList();

    @WebMethod
    @RequestWrapper(localName = "getMarkersOfPanel", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetMarkersOfPanel")
    @ResponseWrapper(localName = "getMarkersOfPanelResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetMarkersOfPanelResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public ArrayOfString getMarkersOfPanel(
            @WebParam(name = "in0", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
            String in0
    );

    @WebMethod
    @RequestWrapper(localName = "getMatchTypeList", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetMatchTypeList")
    @ResponseWrapper(localName = "getMatchTypeListResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetMatchTypeListResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public com.bazl.dna.lims.core.webservice.basicInfo.ArrayOfWSMatchType getMatchTypeList();

    @WebMethod
    @RequestWrapper(localName = "getPanelList", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPanelList")
    @ResponseWrapper(localName = "getPanelListResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPanelListResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public ArrayOfWSPanel getPanelList();

    @WebMethod
    @RequestWrapper(localName = "getPE", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPE")
    @ResponseWrapper(localName = "getPEResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPEResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public double getPE(
            @WebParam(name = "in0", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
            String in0,
            @WebParam(name = "in1", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
            int in1,
            @WebParam(name = "in2", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
            String in2
    );

    @WebMethod
    @RequestWrapper(localName = "getPopulation", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPopulation")
    @ResponseWrapper(localName = "getPopulationResponse", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com", className = "com.bazl.dna.lims.core.webservice.basicInfo.GetPopulationResponse")
    @WebResult(name = "out", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
    public WSPopPopulation getPopulation(
            @WebParam(name = "in0", targetNamespace = "http://BasicInfo.webservice.web.dna.todaysoft.com")
            String in0
    );
}
