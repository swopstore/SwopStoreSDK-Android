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

    fun withCustomerFirstName(customerFirstName: String?): Order {
        this.customerFirstName = customerFirstName
        return this
    }

    fun withCustomerLastName(customerLastName: String?): Order {
        this.customerLastName = customerLastName
        return this
    }

    fun withCustomerEmail(customerEmail: String?): Order {
        this.customerEmail = customerEmail
        return this
    }

    fun withCustomerPhone(customerPhone: String?): Order {
        this.customerPhone = customerPhone
        return this
    }

    fun withCustomerGender(customerGender: Gender?): Order {
        this.customerGender = customerGender
        return this
    }


    fun withOrderId(orderId: String?): Order {
        this.orderId = orderId
        return this
    }

    fun withOrderValue(orderValue: String?): Order {
        this.orderValue = orderValue
        return this
    }

    fun withOrderCurrency(orderCurrency: Currency?): Order {
        this.orderCurrency = orderCurrency
        return this
    }

    fun withUsedPromoCode(usedPromoCode: String?): Order {
        this.usedPromoCode = usedPromoCode
        return this
    }

    fun withUsedCategory(usedCategory: String?): Order {
        this.usedCategory = usedCategory
        return this
    }



}