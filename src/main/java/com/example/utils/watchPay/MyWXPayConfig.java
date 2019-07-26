package com.example.utils.watchPay;

import java.io.InputStream;

public  class MyWXPayConfig extends WXPayConfig {
    private String appId;
    private String mchId;
    private String key;
    public MyWXPayConfig(String appId,String mchId,String key){
        this.appId=appId;
        this.mchId=mchId;
        this.key=key;
    }
    @Override
    String getAppID() {
        return this.appId;
    }

    @Override
    String getMchID() {
        return this.mchId;
    }

    @Override
    String getKey() {
        return this.key;
    }

    @Override
    InputStream getCertStream() {
        return null;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return null;
    }
}
