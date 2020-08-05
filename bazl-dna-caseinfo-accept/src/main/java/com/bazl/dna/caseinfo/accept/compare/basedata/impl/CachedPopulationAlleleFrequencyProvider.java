package com.bazl.dna.caseinfo.accept.compare.basedata.impl;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bazl.dna.caseinfo.accept.compare.InitDict;
import com.bazl.dna.caseinfo.accept.compare.basedata.PopulationAlleleFrequencyProvider;
import com.bazl.dna.lims.model.po.AlleleFrequency;

/**
 * Created by Sun on 2019/4/2.
 */
@Service
public class CachedPopulationAlleleFrequencyProvider implements PopulationAlleleFrequencyProvider {
    private Map<String, Double> cache = new Hashtable();

    public CachedPopulationAlleleFrequencyProvider() {
    }

    @Override
    public double get(String populationId, String markerName, String alleleName, double defaultFrequency) {
        Double result = getAlleleFrequencyVal(markerName, alleleName);
                //(Double)this.cache.get(this.makeKey(populationId, markerName, alleleName));
        return result == null ? defaultFrequency : result.doubleValue();
    }

    private Double getAlleleFrequencyVal(String markerName, String alleleName){
        for(AlleleFrequency af : InitDict.alleles){
            if(af.getMarkerName().equals(markerName)
                    && af.getAlleleName().equals(alleleName)){
                return af.getAlleleFrequency();
            }
        }

        return null;
    }

    public void clear() {
        this.cache.clear();
    }

    public void set(String populationId, String markerName, String alleleName, double frequency) {
        this.cache.put(this.makeKey(populationId, markerName, alleleName), Double.valueOf(frequency));
    }

    private String makeKey(String populationId, String markerName, String alleleName) {
        return populationId.toUpperCase() + "|" + markerName.toUpperCase() + "|" + alleleName.toUpperCase();
    }
}
