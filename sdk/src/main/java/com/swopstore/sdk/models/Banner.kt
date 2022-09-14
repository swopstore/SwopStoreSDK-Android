package com.swopstore.sdk.models

import com.swopstore.sdk.SwopStoreSDK


class Banner(val bannerId  : Int ,
             var order: Order? = null) {


    private fun generateParamString(paramName: String, paramVal: String?): String? {
        paramVal?.let {
            return "'$paramName': '$paramVal'"
        }
        return null
    }

    private fun generateParams(): String {
        val shopIdParams = generateParamString("_shopId", SwopStoreSDK.getShopId().toString())
        val bannerIdIdParams = generateParamString("_bannerId", bannerId.toString())
        val firstNameParams = generateParamString("_customerFirstName", order?.customerFirstName)
        val lastnameIdParams = generateParamString("_customerLastName", order?.customerLastName)
        val emailParams = generateParamString("_customerEmail", order?.customerEmail)
        val phoneParams = generateParamString("_customerPhone", order?.customerPhone)
        val genderParams = generateParamString("_customerGender", order?.customerGender?.name)
        val orderIdParams = generateParamString("_orderId", order?.orderId)
        val orderValueParams = generateParamString("_orderValue", order?.orderValue)
        val currencyParams = generateParamString("_orderCurrency", order?.orderCurrency?.currencyCode)
        val promocodeParams = generateParamString("_usedPromoCode", order?.usedPromoCode)
        val categoryParams = generateParamString("_usedCategory", order?.usedCategory)

        val list = listOfNotNull(shopIdParams,bannerIdIdParams,firstNameParams,lastnameIdParams,emailParams,
            phoneParams,genderParams,orderIdParams,orderValueParams,currencyParams,promocodeParams,categoryParams)
        var paramsString = ""
        list.forEachIndexed { index, s ->
            if(index == list.size-1){
                paramsString = paramsString + s +"\n"
            }else{
                paramsString = paramsString + s +",\n"
            }
        }

        return paramsString
    }

    private fun generateHTML(scale : Double): String {
        val string = "<html>" +
                "<HEAD><meta name=\"viewport\" content=\" width=device-width,initial-scale="+scale+", shrink-to-fit=no\"></HEAD>" +
                "<body>" +
                "<div id=\"promocode-element-container\"></div>" +
                "<script type=\"text/javascript\">\n" +
                "var _iPromoBannerObj = function() {\n" +
                "this.htmlElementId = 'promocode-element-container';\n" +
                "this.params = {\n" +
                generateParams()+
                "};\n" +
                "\n" +
                "this.lS=function(s){document.write('<sc'+'ript type=\"text/javascript\" src=\"'+s+'\" async=\"true\"></scr'+'ipt>');},\n" +
                "this.gc=function(){return document.getElementById(this.htmlElementId);};\n" +
                "var r=[];for(e in this.params){if(typeof(e)==='string'){r.push(e+'='+encodeURIComponent(this.params[e]));}}r.push('method=main');r.push('jsc=iPromoCpnObj');this.lS(('https:'==document.location.protocol ? 'https://':'http://')+'swopstore.com/wrapper.php?'+r.join('&'));};\n" +
                "\n" +
                "var iPromoCpnObj = new _iPromoBannerObj();\n" +
                "</script>" +
                "</body>" +
                "</html>"
        return string
    }

    fun getScript(scale : Double): String {
        return generateHTML(scale)
    }

    fun getDebugScript(scale : Double) : String{
        return generateStagingHTML(scale)
    }

    private fun generateStagingHTML(scale : Double): String {
        val string = "<html>" +
                "<HEAD><meta name=\"viewport\" content=\" width=device-width,initial-scale="+scale+", shrink-to-fit=no\"></HEAD>" +
                "<body>" +

                "<div id=\"promocode-element-container\"></div>" +
                "<script type=\"text/javascript\">\n" +
                "var _iPromoBannerObj = function() {\n" +
                "this.htmlElementId = 'promocode-element-container';\n" +
                "this.params = {\n"+
                generateParams()+
                "};\n" +
                "\n" +
                "this.lS=function(s){document.write('<sc'+'ript type=\"text/javascript\" src=\"'+s+'\" async=\"true\"></scr'+'ipt>');},\n" +
                "this.gc=function(){return document.getElementById(this.htmlElementId);};\n" +
                "var r=[];for(e in this.params){if(typeof(e)==='string'){r.push(e+'='+encodeURIComponent(this.params[e]));}}r.push('method=main');r.push('jsc=iPromoCpnObj');this.lS(('https:'==document.location.protocol ? 'https://':'http://')+'staging.swopstore.com/wrapper.php?'+r.join('&'));};\n" +
                "\n" +
                "var iPromoCpnObj = new _iPromoBannerObj();\n" +
                "</script>" +
                "</body>" +
                "</html>"
        return string
    }

}