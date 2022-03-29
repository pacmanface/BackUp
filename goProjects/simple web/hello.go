package main

import (
	"fmt"
	"html/template"
	"net/http"
	)

type User struct {
	Name                  string
	Age                   uint16
	Money                 int16
	Avg_grades, happiness float64
	Gifs                  []string
}

/*
func (u *User) setNewName(newName string) {
	u.name = newName
}
func (u *User) getAllInfo() string {
	return fmt.Sprintf("User name is %s."+
		"He is %d and his balance %d", u.name, u.age, u.money)
}
*/

func home_page(page http.ResponseWriter, r *http.Request) {
	bob := User{"Bob", 25, -50, 4.2, 0.8, []string{"Jane", "Kate", "Ann"}}
	//bob.setNewName("Alex")
	//fmt.Fprintf(page, bob.getAllInfo())
	tmpl, _ := template.ParseFiles("templates/home_page.html")
	tmpl.Execute(page, bob)
}

func contacts_page(page http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(page, "Contacts")
}

func handleRequest() {
	http.HandleFunc("/", home_page)
	http.HandleFunc("/contacts/", contacts_page)
	http.ListenAndServe(":8080", nil)
}

func main() {
	//var bob User =.....
	//bob := User{name: "Bob",age: 25,money: -50, avg_grades: 4.2, happiness: 0.8}
	//bob := User{"Bob",25,-50,4.2,0.8}
	handleRequest()
}
