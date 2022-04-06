package com.pacmanface

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

@Integration
@Rollback
class StudentServiceSpec extends Specification {

    StudentService studentService
    SessionFactory sessionFactory

    private Long setUpData() {
        new Student(firstName: 'John', lastName: 'Snow').save(flush: true, failOnError: true)
        new Student(firstName: 'Jackson', lastName: 'Baranovich').save(flush: true, failOnError: true)
        Student student = new Student(firstName: 'Ahalay', lastName: 'Mahalay').save(flush: true, failOnError: true)
        student.id
    }

    void "test list"() {
        setUpData()
        
        when:
        List<Student> studentList = studentService.list()

        then:
        studentList.size() == 3
        studentList[0].lastName == 'Snow'
        studentList[1].lastName == 'Baranovich'
        studentList[2].firstName == 'Ahalay'
    }

    void "test delete"() {
        Long id = setUpData()

        expect:
        studentService.list().size() == 3

        when:
        studentService.delete(id)
        sessionFactory.currentSession.flush()

        then:
        studentService.list().size() == 2
    }
}
