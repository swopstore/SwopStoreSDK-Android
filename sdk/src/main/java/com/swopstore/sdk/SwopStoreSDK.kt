package com.swopstore.sdk

import com.swopstore.sdk.models.Banner
import com.swopstore.sdk.models.Order

object SwopStoreSDK {
    
    private var shopId = 0
    private var orderMap: MutableMap<String, Order> = HashMap<String, Order>()

    fun getShopId(): Int {
        return shopId
    }


    private  fun intSDKErrors(){
        shopIdError()
    }
    private fun shopIdError() {
        if (getShopId() == 0) {
            throw IllegalArgumentException("You have to set shopId first in initSDK() method")
        }
    }



    fun getBannerWithCurrentOrder(bannerId : Int) : Banner{
        intSDKErrors()
        return Banner(bannerId, getCurrentOrder())
    }


    fun getCurrentOrder(): Order {
        return orderMap.get("current")!!
    }

    fun addOrder(name: String, id: Order) {
        orderMap.put(name, id)
    }

    fun resetCurrentOrder() {
        orderMap.put("current", Order())
    }

    fun removeOrder(name: String) {
        orderMap.remove(name)
    }

    fun getOrderBy(name: String): Order? {
        return orderMap.get(name)
    }

    fun clearOrders() {
        orderMap.clear()
    }


    fun initSdk(shopId: Int) {
        this.shopId = shopId
        orderMap.put("current", Order())
    }

}