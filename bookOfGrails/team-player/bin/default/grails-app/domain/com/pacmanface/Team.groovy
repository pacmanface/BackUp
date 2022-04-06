package com.pacmanface

class Team {

    String name
    String city
    String stadium
    String logo
    String manager

    static hasmany = [players: Player]

    static constraints = {
        name size: 5..30, blank: false, uniq: true
        city size: 5..30, blank: false
        stadium size: 5..30, blank: false
        logo size: 5..30, blank: false
        manager size: 5..30, blank: false
    }

    String toString() {
        name
    }
}
