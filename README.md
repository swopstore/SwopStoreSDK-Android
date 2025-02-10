
# SwopStore SDK Android
This is an SDK for SwopStore , written in the Kotlin [![](https://jitpack.io/v/swopstore/SwopStoreSDK-Android.svg)](https://jitpack.io/#swopstore/SwopStoreSDK-Android)

## Installation  

Installation happens through the jitpack repository 

First enable JitPack in repositories list,

```groovy
repositories {
    maven { url "https://jitpack.io" }
}
```

To import the SwopStoreSDK import the dependency,

```groovy
dependencies {
     implementation 'com.github.swopstore:SwopStoreSDK-Android:1.1.3'
}
```


## Quick start

At the beginning (before creating an order), initialize the SDK using the initSDK(shopId : Int) method, specifying your shopId

```kotlin
   SwopStoreSDK.initSDK(863)
```


To collect parameters for an order, use the builder pattern for the order object

```kotlin
    SwopStoreSDK.getCurrentOrder().
					withCustomerFirstName("name").
					withCustomerLastName("lastname")...

 ```

Possible parameters for the Order object:


    Gender {
        male,
        female
    }

     customerFirstName: String
     customerLastName: String
     customerEmail: String
     customerPhone: String
     customerGender: Gender
     orderId: String
     orderValue: String
     orderCurrency: Currency
     usedPromoCode: String
     usedCategory : String




It is possible to add several Order objects, for subsequent selection and insertion into BannerView


```kotlin
    SwopStoreSDK.addOrder("NewOne")

    SwopStoreSDK.getOrder("NewOne").
					withCustomerFirstName("name").
					withCustomerLastName("lastname")...

 ```

Add BannerView to xml markup, or create programmatically

```xml
    <com.swopstore.sdk.view.BannerView
            android:layout_width="match_parent"
            android:id="@+id/bannerView"
            android:layout_height="150dp"/>

 ```
Create a Banner object, passing bannerId and Order to it

```kotlin
val banner = Banner(bannerId, order)
 ```

for convenience, there is a method for generating a Banner object for the current Order in SwopStoreSDK.getBannerWithCurrentOrder(bannerId)


Call the showBanner(banner) method on the BannerView when ready

```kotlin
bannerView.showBanner(banner, 1.0)
 ```


The showBanner() method has an optional parameter scale : Double - you can reduce or enlarge the banner (default 1.0)


Call the SwopStoreSDK.resetCurrentOrder() method to reset the current Order

```kotlin
SwopStoreSDK.resetCurrentOrder()
 ```

The complete code:
```kotlin
		//SDK initialization
        SwopStoreSDK.initSdk(863)


     	//To reset the current order and start a new one
        SwopStoreSDK.resetCurrentOrder()
		
		//Adding fields to an order
        //Kotlin
        SwopStoreSDK.getCurrentOrder().customerFirstName = "FirstName"
        SwopStoreSDK.getCurrentOrder().withCustomerLastName("LastName")
									  .withCustomerGender(Order.Gender.male)


        val bannerView: BannerView = findViewById(R.id.bannerView)
		
		//Creating a banner model with an Id for the current order
        val banner = SwopStoreSDK.getBannerWithCurrentOrder(2804)
		//Display banner
        bannerView.showBanner(banner, 1.0)
		
	
 ```




