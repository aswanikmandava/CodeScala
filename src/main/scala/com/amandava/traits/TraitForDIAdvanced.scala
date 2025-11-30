package com.amandava.traits

object TraitForDIAdvanced extends App {

  // this class encapsulates inventory services
  case class ProductInventoryService[T]() {
    def getStock(p: T): Boolean = {
      println(s"checking if $p is in stock ... ")
      p match {
        case "Eggs" => false
        case "Milk" => true
        case _ => false
      }
    }
  }

  // this class encapsulates pricing services
  case class ProductPricingService[T]() {
    def getPrice(p: T): Double = {
      println(s"computing $p price ... ")
      p match {
        case "Eggs" => 10.99
        case "Milk" => 7.99
        case _ => 2.99
      }
    }
  }

  // this class encapsulates order services
  case class ProductOrderService[T]() {
    def createOrder(p: T, price: Double, count: Int): Int = {
      println(s"creating order for $p ...")
      1
    }
  }

  // this class encapsulates shopping cart services
  case class ShoppingCartService[T](prodInvServ: ProductInventoryService[T],
                                    prodPriceServ: ProductPricingService[T],
                                    prodOrderServ: ProductOrderService[T]) {
    def placeOrder(p: T, count: Int): Int = {
      println(s"Preparing order for $p with $count quantity ...")
      if (prodInvServ.getStock(p)) {
        val price = prodPriceServ.getPrice(p)
        prodOrderServ.createOrder(p, price, count)
      } else {
        println(s"Sorry, product $p is out of stock")
        -1
      }
    }
  }

  // this trait encapsulates all the product services
  trait ProductServices {
    // create objects
    val productInventoryService = ProductInventoryService[String]()
    val productPricingService = ProductPricingService[String]()
    val productOrderService = ProductOrderService[String]()
    val shoppingCartService = ShoppingCartService[String](
      productInventoryService,
      productPricingService,
      productOrderService
    )
  }

  // create a trait that acts as a facade which exposes the functionality
  // of product store services
  trait StoreAppController {
    this: ProductServices =>
      def placeOrder(p: String, count: Int): Int = {
        println("Controller -> placeOrder")
        shoppingCartService.placeOrder(p, count)
      }
  }

  // create an entrypoint for the store app
  object StoreApp extends StoreAppController with ProductServices

  // place an order for a product using Store app
  StoreApp.placeOrder("Eggs", 2)

}
