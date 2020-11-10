package com.jcloud.learn.Example;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

public class HashTest {
    public static final String str1 = "EFFCDE70-F35C-4AD3-B670-05C37161A8EF";
    public static final String str2 = "270000033127205";
    public static final String str3 = "001FCBE2-C04E-4BC9-9BA5-DAA3CA4ABAB2";
    public static final String str4 = "00261779M6567331T";

    @Test
    public void testJdkHash() {
        System.out.println(Math.abs("1223123123".hashCode()));

        System.out.println(Math.abs(str2.hashCode()));
//        System.out.println(String.valueOf(Math.abs(str2.hashCode())).length());
//
        boolean flag = false;
        Preconditions.checkNotNull(flag);
        HashFunction hf = Hashing.crc32c(); // 32bit version available as well
        HashCode hc = hf.newHasher()
                .putString(str2, Charsets.UTF_8)
                .hash();
//        System.out.println(Math.abs(hc.asInt()));
//        System.out.println(String.valueOf(Math.abs(hc.asInt())).length());
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        "".getBytes("UTF-8");
        System.out.println(DigestUtils.md5DigestAsHex("accountId0=2088012022013254&amount0=3&autoRenew0=NONE&businessValues0=0&centerCode0=1019082650501001268&centerPayService0=669&centerPayType0=ALIPAYWAP&channel0=0&chargeType0=1&couponFee0=0&couponSettlementFee0=0&currencyUnit0=CNY&fee0=1&frVersion0=FromCasher=1&Mobile_Casher=1&latitude=&longitude=&coordType=&fv0=zh2767610fb39d41c6c1b25f5caac039&gateway0=1910&name0=黄金VIP会员3个月自动续费&orderCode0=201908261401412701501&payType0=36&platform0=19&productFee0=3000&productId0=4&productType0=1&pushChannel0=0&realFee0=1&refer0={\"merchantNo\":\"2088911368296964\",\"suitABTestId\":\"autoRenewTestBVip\"}&renewalsFlag0=0&serviceId0=0&settlementFee0=1&status0=PAID&tradeCode0=2019082622001413250576144693&tradeNo0=201908261401412701501&type0=1&userId0=1424713868&userIp0=10.3.16.36test".getBytes("UTF-8")));
        System.out.println(DigestUtils.md5DigestAsHex("accountId0=2088012022013254&amount0=3&autoRenew0=NONE&businessValues0=0&centerCode0=1019082650501001268&centerPayService0=669&centerPayType0=ALIPAYWAP&channel0=0&chargeType0=1&couponFee0=0&couponSettlementFee0=0&currencyUnit0=CNY&fee0=1&frVersion0=FromCasher=1&Mobile_Casher=1&latitude=&longitude=&coordType=&fv0=zh2767610fb39d41c6c1b25f5caac039&gateway0=1910&name0=黄金VIP会员3个月自动续费&orderCode0=201908261401412701501&payType0=36&platform0=19&productFee0=3000&productId0=4&productType0=1&pushChannel0=0&realFee0=1&refer0={\"merchantNo\":\"2088911368296964\",\"suitABTestId\":\"autoRenewTestBVip\"}&renewalsFlag0=0&serviceId0=0&settlementFee0=1&status0=PAID&tradeCode0=2019082622001413250576144693&tradeNo0=201908261401412701501&type0=1&userId0=1424713868&userIp0=10.3.16.36test".getBytes()));
    }

    @Test
    public void timeStampTest() throws ParseException {
        List<String> t=new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(t));
        Integer i = 128;
        Integer j = 128;
//        System.out.println(i==j);
//        Long fee=960000000L * 30000000000L;
        Integer i1 = 1000000 * 100;
        System.out.println(i1);
        System.out.println(1000000 * 100 < 0);
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date1 = new Date(sdf.parse(sdf.format(Timestamp.valueOf("2019-09-11 17:22:45.2"))).getTime());
        Date date2 = new Date(sdf.parse(sdf.format(Timestamp.valueOf("2019-09-11 17:22:45"))).getTime());

        System.out.println((new Timestamp(date1.getTime())).equals(new Timestamp(date2.getTime())));
    }

    class T2{

    }

    public static void main(String[] args) {
        Map<Integer, T1> map = new LinkedHashMap<Integer, T1>();
        for(int i=0;i<100;i++){
            T1 t=new T1(i);
            map.put(i,t);
        }
        Thread thread1=new Thread(){
            @Override
            public void run() {
                for (T1 t:map.values()){
                    System.out.println("T1:".concat(String.valueOf(t.index)));
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2=new Thread(){
            @Override
            public void run() {
                for (T1 t:map.values()){
                    System.out.println("T2:".concat(String.valueOf(t.index)));
                }
            }
        };

        thread1.start();
        thread2.start();
        thread1.start();

    }
}
