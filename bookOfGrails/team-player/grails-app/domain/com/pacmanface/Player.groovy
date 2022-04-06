package com.pacmanface

class Player {

    static belongsTo = [team: Team]
    
    String name
    String position
    Integer age

    static constraints = {
        name size: 5..40, blank: false, uniq: true
        age min: 16, blank: false
        position size: 5..30, blank: false
    }

    String toString() {
        name
    }
}
