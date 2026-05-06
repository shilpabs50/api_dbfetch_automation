\# API + Database Automation Framework (Rest Assured + JDBC)



\## 📌 Project Overview



This project demonstrates an end-to-end API automation framework that validates API responses along with backend database verification.



It uses:



\* Rest Assured for API testing

\* JDBC for database validation

\* TestNG for test execution

\* ResourceBundle for environment-based configuration



\---



\## 🧰 Tech Stack



\* Java

\* Rest Assured

\* TestNG

\* JDBC (PostgreSQL - Supabase)

\* Maven

\* Git



\---



\## 📂 Project Structure



```

src

&#x20;├── main

&#x20;│   └── java

&#x20;│       ├── api        → API request classes

&#x20;│       ├── db         → DB utility classes

&#x20;│       └── utils      → Config management

&#x20;│

&#x20;└── test

&#x20;    └── java

&#x20;        └── tests      → Test classes

```



\---



\## ⚙️ Features Implemented



\* API request execution using Rest Assured

\* Reusable DB utility methods:



&#x20; \* executeUpdate()

&#x20; \* getSingleData()

\* Backend DB validation

\* Dynamic test data via properties file

\* Environment handling using ResourceBundle



\---



\## 🔄 Test Flow



1\. Send API request (POST /users)

2\. Validate API response (status code, fields)

3\. Extract ID from response

4\. Insert data into DB

5\. Fetch data from DB

6\. Compare API vs DB values



\---



\## 🧪 Sample Test Scenario



\* Create a user via API

\* Store user details in database

\* Validate if stored data matches API response



\---



\## 🗄️ Database



\* PostgreSQL (Supabase - Cloud DB)

\* Tables created manually for testing





\## 👩‍💻 Author



Shilpa – API Automation Tester



