# Bank Accounts

API to manage bank accounts.

## Getting started

- Start MySQL server `docker-compose up -d`.
- Start spring boot application with `./mvnw spring-boot:run`

## APIs

### POST /user/

Create a new user.

```http request
POST /user/ HTTP/1.1
Content-Type: application/json

{
    "name":"Jon Doe",
    "email":"jondoe@example.com",
    "phone":"5544332211"
}
```

```json
{
  "id": 1,
  "name": "Jon Doe",
  "email": "jondoe@example.com",
  "phone": "5544332211",
  "bankAccounts": []
}
```

### GET /user/{id}

Get user and bank accounts by id

```http request
GET /user/1 HTTP/1.1
```

```json
{
    "id": 1,
    "name": "Jon Doe",
    "email": "jondoe@example.com",
    "phone": "5544332211",
    "bankAccounts": [
        {
            "accountId": 1,
            "accountNumber": "1123",
            "bankName": "HDFC",
            "balance": 1000.0,
            "bankingServices": [
                {
                    "serviceId": 1,
                    "active": true,
                    "activatedOn": "2022-06-27T05:50:04.773",
                    "serviceType": "MOBILE_BANKING"
                }
            ]
        },
        {
            "accountId": 2,
            "accountNumber": "2123",
            "bankName": "ICICI",
            "balance": 2000.0,
            "bankingServices": [
                {
                    "serviceId": 2,
                    "active": true,
                    "activatedOn": "2022-06-27T05:50:04.773",
                    "serviceType": "MOBILE_BANKING"
                }
            ]
        }
    ]
}
```

### POST /bank-account/

Create a new bank account.

```http request
POST /bank-account/ HTTP/1.1
Content-Type: application/json

{
    "userId": 1,
    "accountNumber": "1123",
    "bankName": "HDFC",
    "balance": 1000.0,
    "bankingServices": [
        {
            "serviceId": 1,
            "active": true,
            "activatedOn": "2022-06-27T05:50:04.773",
            "serviceType": "MOBILE_BANKING"
        }
    ]
}
```

```json
{
    "accountId": 1,
    "accountNumber": "1123",
    "bankName": "HDFC",
    "balance": 1000.0,
    "bankingServices": [
        {
            "serviceId": 1,
            "active": true,
            "activatedOn": "2022-06-27T05:50:04.773",
            "serviceType": "MOBILE_BANKING"
        }
    ]
}
```

### GET /bank-account/{id}

Get bank account by id

```http request
GET /bank-account/1 HTTP/1.1
```

```json
{
    "accountId": 1,
    "accountNumber": "1123",
    "bankName": "HDFC",
    "balance": 1000.0,
    "bankingServices": [
        {
            "serviceId": 1,
            "active": true,
            "activatedOn": "2022-06-27T05:50:04.773",
            "serviceType": "MOBILE_BANKING"
        }
    ]
}
```

### GET /bank-account/?SERVICE_TYPE={SERVICE}

Get bank accounts with active service type

```http request
GET /bank-account/?SERVICE_TYPE=MOBILE_BANKING HTTP/1.1
```

```json
[
    {
        "accountId": 1,
        "accountNumber": "1123",
        "bankName": "HDFC",
        "balance": 1000.0,
        "bankingServices": [
            {
                "serviceId": 1,
                "active": true,
                "activatedOn": "2022-06-27T05:50:04.773",
                "serviceType": "MOBILE_BANKING"
            }
        ]
    },
    {
        "accountId": 2,
        "accountNumber": "2123",
        "bankName": "ICICI",
        "balance": 2000.0,
        "bankingServices": [
            {
                "serviceId": 2,
                "active": true,
                "activatedOn": "2022-06-27T05:50:04.773",
                "serviceType": "MOBILE_BANKING"
            }
        ]
    }
]
```