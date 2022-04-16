package com.pacmanface

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PlayerSpec extends Specification implements DomainUnitTest<Player> {

    def setup() {
        def player = new Player(name:'joe',age: 19,position: 'back')
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
