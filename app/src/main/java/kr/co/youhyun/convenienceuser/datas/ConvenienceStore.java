package kr.co.youhyun.convenienceuser.datas;

import java.io.Serializable;

public class ConvenienceStore implements Serializable {

    private String storeName;
    private String storePhoneNum;
    private String logoUrl;

    public ConvenienceStore(String storeName, String storePhoneNum, String logoUrl) {
        this.storeName = storeName;
        this.storePhoneNum = storePhoneNum;
        this.logoUrl = logoUrl;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhoneNum() {
        return storePhoneNum;
    }

    public void setStorePhoneNum(String storePhoneNum) {
        this.storePhoneNum = storePhoneNum;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
