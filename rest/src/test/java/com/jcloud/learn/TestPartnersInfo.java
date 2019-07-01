package com.jcloud.learn;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
class PartnersInfo {
    private String partnerCode;
    private String partnerName;
    private boolean supportQiyiRefund;
    private boolean supportPartnerRefund;
    private boolean needAudit;
}

public class TestPartnersInfo {
    public static void main(String[] args) {
         ConcurrentHashMap<String, PartnersInfo> partners = new ConcurrentHashMap<>(10);
        PartnersInfo partnersInfo=new PartnersInfo();
        partnersInfo.setPartnerCode("test");
        partnersInfo.setNeedAudit(true);
        partnersInfo.setPartnerName("测试");
        partnersInfo.setSupportPartnerRefund(true);
        partnersInfo.setSupportQiyiRefund(true);

        PartnersInfo partnersInfo1=new PartnersInfo();
        partnersInfo1.setPartnerCode("test");
        partnersInfo1.setNeedAudit(false);
        partnersInfo1.setPartnerName("测试1");
        partnersInfo1.setSupportPartnerRefund(true);
        partnersInfo1.setSupportQiyiRefund(true);
        partners.put("test",partnersInfo);
        partners.put("test",partnersInfo1);
        System.out.println(partners.size());
        System.out.println(partners.get("test"));

    }
}