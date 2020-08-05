
package com.bazl.dna.lims.core.webservice.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfDnaMatchInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDnaMatchInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DnaMatchInfo" type="{http://domain.lims.viathink.com}DnaMatchInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDnaMatchInfo", namespace = "http://domain.lims.viathink.com", propOrder = {
    "dnaMatchInfo"
})
public class ArrayOfDnaMatchInfo {

    @XmlElement(name = "DnaMatchInfo", nillable = true)
    protected List<DnaMatchInfo> dnaMatchInfo;

    /**
     * Gets the value of the dnaMatchInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dnaMatchInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDnaMatchInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DnaMatchInfo }
     * 
     * 
     */
    public List<DnaMatchInfo> getDnaMatchInfo() {
        if (dnaMatchInfo == null) {
            dnaMatchInfo = new ArrayList<DnaMatchInfo>();
        }
        return this.dnaMatchInfo;
    }

}
