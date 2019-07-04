package com.cetc.weiwen.commons.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Lazy(false)
public class IdGen {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return Encodes.encodeBase62(randomBytes);
	}

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        return retStr;
    }
    
    /**
     * 优惠批次号
     *
     * @return
     */
	public static String getSaleNum() {
		long time = System.currentTimeMillis();
		String radom = createRandom(true,4);
		return time+radom;
	}
    
    /**
     * 订单号
     *
     * @return
     */
	public static String getOrderNum() {
		long time = System.currentTimeMillis();
		String radom = createRandom(true,4);
		return time+radom;
	}
	
	/**
     * 组织机构号
     *
     * @return
     */
	public static String getOrgCode() {
		long time = System.currentTimeMillis();
		String radom = createRandom(true,4);
		return time+radom;
	}
	
	/**
     * 组织机构号
     *
     * @return
     */
	public static String getEmpId() {
		long time = System.currentTimeMillis();
		String radom = createRandom(true,4);
		return time+radom;
	}
    /**
     * 支付号
     *
     * @return
     */
	public static String getPayNum(String payType) {
		if(payType.equals("test")){
			long time = System.currentTimeMillis();
			String radom = createRandom(true,3);
			return "T"+time+radom;
		}else{
			long time = System.currentTimeMillis();
			String radom = createRandom(true,4);
			return time+radom;
		}
		
	}
	
    /**
     * 退款号
     *
     * @return
     */
	public static String getRefundNum() {
		long time = System.currentTimeMillis();
		String radom = createRandom(true,4);
		return time+radom;
	}
}
