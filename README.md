# Simple-Microservice
Simple Orchestra Microservice
Dapat mengonversikan nilai Suhu dan Panjang


How to Use:
1. Buka aplikasi Postman
2. Isikan url Orchestrator Server (localhost:1001/api/convert)
3. Isikan pada body dengan tipe raw JSON, contoh:
   //untuk konversi nilai suhu dapat menggunakan Celcius, Fahrenheit, Kelvin dan Reamur
   {
    "value" : 30,
    "from" : "Reamur",
    "to" : "Kelvin"
   }

   //jika ingin konversi panjang, bisa menggunakan Centimeter, Inch, Meter, Kilometer
   //perhatikan huruf kapital
5. Kemudian akan muncul result sesuai dengan nilai 'to' yang diminta
