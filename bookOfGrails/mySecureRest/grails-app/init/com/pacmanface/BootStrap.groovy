package com.pacmanface

class BootStrap {

    def init = { servletContext ->
        def prod1 = new Product(prodName: 'iPhone 7', prodDesc: 'brand new, 32gb, spaceGray', prodPrice: '780').save(flush: true, failOnError: true)
        def prod2 = new Product(prodName: 'iPhone 7 Plus', prodDesc: 'brand new, 128gb, roseGold', prodPrice: '980').save(flush: true, failOnError: true)
        def prod3 = new Product(prodName: 'iPhone 7SE', prodDesc: 'refurbished, 64gb, silver', prodPrice: '580').save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
