package com.pacmanface

class Player {

    static belongsTo = [team: Team]
    
    String name
    Integer age
    String position

    static constraints = {
        name size: 4..40, blank: false, uniq: true
        age min: 16, blank: false
        position size: 4..30, blank: false
    }

    String toString() {
        name
    }
}
