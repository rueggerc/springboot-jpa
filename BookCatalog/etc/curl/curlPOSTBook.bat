@echo off

curl -H "Content-Type: application/json" -X POST http://localhost:8080/book -d "@data/newBook1.json"




