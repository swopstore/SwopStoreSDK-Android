package com.swopstore.sdk.models

class Order {

    enum class Gender {
        male,
        female
    }


    var customerFirstName: String? = null
    var customerLastName: String? = null
    var customerEmail: String? = null
    var customerPhone: String? = null
    var customerGender: Gender? = null
    var orderId: String? = null
    var orderValue: String? = null
    var orderCurrency: Currency? = null
    var usedPromoCode: String? = null
    var usedCategory : String? = null

    fun setCustomerFirstName(customerFirstName: String?): Order {
        this.customerFirstName = customerFirstName
        return this
    }

    fun setCustomerLastName(customerLastName: String?): Order {
        this.customerLastName = customerLastName
        return this
    }

    fun setCustomerEmail(customerEmail: String?): Order {
        this.customerEmail = customerEmail
        return this
    }

    fun setCustomerPhone(customerPhone: String?): Order {
        this.customerPhone = customerPhone
        return this
    }

    fun setCustomerGender(customerGender: Gender?): Order {
        this.customerGender = customerGender
        return this
    }


    fun setOrderId(orderId: String?): Order {
        this.orderId = orderId
        return this
    }

    fun setOrderValue(orderValue: String?): Order {
        this.orderValue = orderValue
        return this
    }

    fun setOrderCurrency(orderCurrency: Currency?): Order {
        this.orderCurrency = orderCurrency
        return this
    }

    fun setUsedPromoCode(usedPromoCode: String?): Order {
        this.usedPromoCode = usedPromoCode
        return this
    }

    fun setUsedCategory(usedCategory: String?): Order {
        this.usedCategory = usedCategory
        return this
    }



}