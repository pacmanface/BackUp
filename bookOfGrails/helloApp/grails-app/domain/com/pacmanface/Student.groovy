package com.pacmanface

class Student {

	String firstName
	String lastName
	
    static constraints = {
        firstName size: 4..30, blank: false
        lastName size: 4..40, blank: false
    }

    String toString() {
        lastName
    }
}
