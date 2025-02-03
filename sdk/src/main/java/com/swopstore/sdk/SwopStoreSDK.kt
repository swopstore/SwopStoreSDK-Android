package com.swopstore.sdk

import com.swopstore.sdk.models.Banner
import com.swopstore.sdk.models.Order

object SwopStoreSDK {
    
    private var shopId = 0
    private const val CURRENT_ORDER_NAME = "current"
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
        return orderMap[CURRENT_ORDER_NAME]!!
    }

    fun addOrder(name: String, id: Order) {
        orderMap[name] = id
    }

    fun resetCurrentOrder() {
        orderMap[CURRENT_ORDER_NAME] = Order()
    }

    fun removeOrder(name: String) {
        orderMap.remove(name)
        if(name == CURRENT_ORDER_NAME ){
            resetCurrentOrder()
        }
    }

    fun getOrderBy(name: String): Order? {
        return orderMap[name]
    }

    fun clearOrders() {
        orderMap.clear()
        resetCurrentOrder()
    }


    fun initSdk(shopId: Int) : SwopStoreSDK {
        this.shopId = shopId
        resetCurrentOrder()
        return this
    }

}