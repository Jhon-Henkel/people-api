# Person-API
O objetivo desse projeto é fazer uma api simples para gerenciamento de pessoas

# Endpoint's

### Person
- Show:
  - Type: Get 
  - Uri: /person/{personId}
- Index
  - Type: Get
  - Uri: /person
- Insert
  - Type: Post
  - Uri: /person
  - JsonBody:
    ```
    {
      "name": "Person To Insert",
      "birthDate": "1995-10-12",
      "address": [
        {
          "publicPlace": "Main St Palace",
          "zipCode": 88899900,
          "number": 2514,
          "city": "Kansas",
          "mainAddress": true
        },
        {
          "publicPlace": "St Secondary Palace",
          "zipCode": 77744452,
          "number": 9955,
          "city": "Kansas",
          "mainAddress": false
        }
      ]
    }
    ```
- Update
  - Type: Put
  - Uri: /person/{personId}
  - JsonBody:
    ```
    {
      "name": "Person To Insert",
      "birthDate": "1995-10-12",
      "address": [
        {
          "publicPlace": "Main St Palace",
          "zipCode": 88899900,
          "number": 2514,
          "city": "Kansas",
          "mainAddress": true
        }
      ]
    }
    ```
---
### Address
- Update
  - Type: Put
  - Uri: /address/{addressId}
  - JsonBody:
    ```
      {
        "publicPlace": "Main St Palace",
        "zipCode": 88899900,
        "number": 2514,
        "city": "Kansas",
        "mainAddress": true
      }
    ```
- Show Address For Person
  - Type: Get
  - Uri: /address/person/{personId}
- Insert Address For Person
  - Type: Post
  - Uri: address/person/{personId}
  - JsonBody:
  ```
    {
      "publicPlace": "Main St Palace",
      "zipCode": 88899900,
      "number": 2514,
      "city": "Kansas",
      "mainAddress": true
    }
  ```