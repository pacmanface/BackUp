package main

import (
	"database/sql"
	"fmt"
	"log"

	_ "github.com/go-sql-driver/mysql"
)

type user struct {
	Id   uint   `json:"id"`
	Name string `json:"name"`
}

func main() {
	fmt.Println("Try to query DB")

	db, err := sql.Open("mysql", "locpac:9uyR!chy@tcp(127.0.0.1:3306)/Dvlwrkshp")

	if err != nil {
		log.Print(err.Error())
	}

	fmt.Println("Connection success!")

	defer db.Close()
	/*
		insert, err := db.Query("INSERT INTO users VALUES(1,'Vasya'),(2,'Petya')")

		if err != nil {
			panic(err)
		}

		fmt.Println("insert successful")

		defer insert.Close()
	*/

	results, err := db.Query("SELECT * FROM users")

	if err != nil {
		panic(err.Error())
	}

	for results.Next() {
		var tag user
		err = results.Scan(&tag.Id, &tag.Name)

		if err != nil {
			panic(err.Error())
		}

		fmt.Printf("User: %s with age %d", tag.Name, tag.Id)
	}

}
