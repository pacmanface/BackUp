package com.pacmanface

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class StudentControllerSpec extends Specification implements ControllerUnitTest<StudentController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.studentService = Mock(StudentService) {
            list() >> [new Student(firstName: 'John',lastName: 'Doe')]
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        model.studentList.size() == 1
        model.studentList[0].firstName == 'John'
        model.studentList[1].lastName == 'Doe'
    }

    void "Test the delete action with an instance"() {
        given:
        controller.studentService = Mock(StudentService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/student/index'
    }
}
