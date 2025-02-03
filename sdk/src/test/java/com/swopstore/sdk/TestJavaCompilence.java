package com.swopstore.sdk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJavaCompilence {


    @Test
    public void tesJava(){
        SwopStoreSDK sdk = SwopStoreSDK.INSTANCE.initSdk(12);
        sdk.getCurrentOrder().setOrderId("1234");
        assertEquals("1234",sdk.getCurrentOrder().getOrderId());
    }
}
