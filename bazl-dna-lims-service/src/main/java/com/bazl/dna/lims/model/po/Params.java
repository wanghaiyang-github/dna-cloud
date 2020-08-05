package com.bazl.dna.lims.model.po;

import java.io.Serializable;
import java.util.List;

public class Params implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> phones;//推送的手机号

    private String packageName;//包名

    private Notification message; //请求内容

    @Override
    public String toString() {
        return "Params{" +
                "phones=" + phones +
                ", packageName='" + packageName + '\'' +
                ", message=" + message +
                '}';
    }

    public Notification getMessage() {
        return message;
    }

    public void setMessage(Notification message) {
        this.message = message;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
