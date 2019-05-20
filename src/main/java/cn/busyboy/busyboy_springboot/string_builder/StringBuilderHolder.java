/*
 * StringBuilderHolder.java  * Created on  2019/5/17
 * Copyright (c) 2019 YueTu
 * YueTu TECHNOLOGY CO.,LTD. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * YueTu Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with YueTu Ltd.
 */
package cn.busyboy.busyboy_springboot.string_builder;

/**
 * @author ling.zhang
 */
public class StringBuilderHolder {
    private final StringBuilder sb;
    public StringBuilderHolder(int capacity){
        sb = new StringBuilder(capacity);
    }

    public StringBuilder resetAndGetStringBuilder(){
        sb.setLength(0);
        return sb;
    }



    private static final ThreadLocal<StringBuilderHolder> threadLocalStringBuilderHolder = new ThreadLocal<StringBuilderHolder>(){
        protected StringBuilderHolder initialValue(){
            return new StringBuilderHolder(256);
        }
    };

    public static void main(String[] args) {
        StringBuilder stringBuilder = threadLocalStringBuilderHolder.get().resetAndGetStringBuilder();
        stringBuilder.append("aaa").append("333");
        System.out.println(stringBuilder.length());
        StringBuilder aa = threadLocalStringBuilderHolder.get().resetAndGetStringBuilder();
        System.out.println(aa.length());

        System.currentTimeMillis();
    }


}
