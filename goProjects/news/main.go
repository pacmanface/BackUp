package main

import (
	"database/sql"
	"fmt"
	"html/template"
	"log"
	"net/http"

	_ "github.com/go-sql-driver/mysql"
)

type Articles struct {
	Id                     uint
	Title, Anons, FullText string
}

var posts = []Articles{}

func index(w http.ResponseWriter, r *http.Request) {
	t, err := template.ParseFiles("templates/index.html", "templates/header.html", "templates/footer.html")

	if err != nil {
		fmt.Fprint(w, err.Error())
	}

	fmt.Println("Try to query DB for indexing")

	db, err := sql.Open("mysql", "locpac:9uyR!chy@tcp(127.0.0.1:3306)/Dvlwrkshp")

	if err != nil {
		log.Print(err.Error())
	}

	fmt.Println("Indexing Connection success!")

	defer db.Close()

	posts = []Articles{}

	results, err := db.Query("SELECT * FROM articles")

	if err != nil {
		panic(err.Error())
	}

	for results.Next() {
		var tag Articles
		err = results.Scan(&tag.Id, &tag.Title, &tag.Anons, &tag.FullText)

		if err != nil {
			panic(err.Error())
		}
		posts = append(posts, tag)

		//fmt.Printf("Id: %d, title %s, anons %s, full_text %s ", tag.Id, tag.Title, tag.Anons, tag.FullText)
	}

	t.ExecuteTemplate(w, "index", posts)
}

func create(w http.ResponseWriter, r *http.Request) {
	t, err := template.ParseFiles("templates/create.html", "templates/header.html", "templates/footer.html")

	if err != nil {
		fmt.Fprint(w, err.Error())
	}

	t.ExecuteTemplate(w, "create", nil)
}
func save_article(w http.ResponseWriter, r *http.Request) {
	title := r.FormValue("title")
	anons := r.FormValue("anons")
	full_text := r.FormValue("full_text")

	if title == "" || anons == "" || full_text == "" {

		fmt.Fprintf(w, "охуел?")

	} else {

		fmt.Println("Try to query DB")

		db, err := sql.Open("mysql", "locpac:9uyR!chy@tcp(127.0.0.1:3306)/Dvlwrkshp")

		if err != nil {
			log.Print(err.Error())
		}

		fmt.Println("Connection success!")

		defer db.Close()

		insert, err := db.Query(fmt.Sprintf("INSERT INTO articles (`title`,`anons`,`full_text`) VALUES('%s','%s','%s')", title, anons, full_text))
		if err != nil {
			panic(err)
		}

		fmt.Println("insert successful")

		defer insert.Close()

		http.Redirect(w, r, "/", http.StatusSeeOther)
	}

}

func handleFunc() {
	http.HandleFunc("/", index)
	http.HandleFunc("/create", create)
	http.HandleFunc("/save_article", save_article)
	http.ListenAndServe(":8080", nil)
}

func main() {
	handleFunc()
}
