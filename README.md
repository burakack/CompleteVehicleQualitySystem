
# Complete Vehicle Quality System

This project deals with the management and storage of errors in manufactured vehicles.

## Bilgisayarınızda Çalıştırın

Clone Project

```bash
  git clone https://github.com/burakack/CompleteVehicleQualitySystem.git
```


## Docker 
If you want to use docker there is a way to run all 5 microservices at once
```bash
  cd CompleteVehicleQualitySystem
```
```bash
  docker compose up
```

Otherwise you have to run all microservices manually.


# EndPoints 

## Auth Service
### Authenticate
- Request
```http
  POST http://localhost:3000/api/v1/auth/authenticate
```

| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |
- Response
```javascript
{} with 200 status codewith 200
```
### Is Admin?
- Request
```http
  POST http://localhost:3000/api/v1/auth/isADMIN
```

| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |
- Response
```javascript
{} with 200 status code
```

### Is Operator?
- Request
```http
  POST http://localhost:3000/api/v1/auth/isOPERATOR
```

| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |
- Response
```javascript
{} with 200 status code
```
### Is Team Lead?
```http
  POST http://localhost:3000/api/v1/auth/isTEAMLEAD
```

| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

## User Management Service
### New User

- Request
```http
  POST http://localhost:3002/api/v1/user-management/add-user
```
| Parametre  | Tip      | Açıklama             |
|:-----------|:---------|:---------------------|
| `token`    | `string` | **Required**. Token. |
| `username` | `string` | **Required**.        |
| `password` | `string` | **Required**.        |
| `email`    | `string` | **Required**         |
| `name`     | `string` |                      |
| `surname`  | `string` |                      |
- Response 
```javascript
User Created Succesfully
```

### Delete User
- Request
```http
  DELETE http://localhost:3002/api/v1/user-management/delete-user
```
| Parametre  | Tip      | Açıklama             |
|:-----------|:---------|:---------------------|
| `token`    | `string` | **Required**. Token. |
| `username` | `string` | **Required**.        |
- Response 
```javascript
{} with 200 status code
```

### Add Role To User
- Request
```http
  POST http://localhost:3002/api/v1/user-management/add-role-to-user
```
| Parametre  | Tip      | Açıklama             |
|:-----------|:---------|:---------------------|
| `token`    | `string` | **Required**. Token. |
| `username` | `string` | **Required**.        |
- Response 
```javascript
{} with 200 status code
```

## Defect List Service
### Defect List With Sorting And Pagination

- Request
```http
  GET http://localhost:3003/api/v1/defect-list/:page/:pagesize/:sortvariable
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

- Response 


```javascript

{
"content": [
    {
        "id": 1,
        "model": modeladi,
        "defects": [
            {
                "id": 7,
                "defectName": "Cizik",
                "defectDescription": "Boya sökülmesi",
                "locations": [
                    {
                        "id": 6,
                        "x": 32,
                        "y": 57,
                        "image": "resimdatası"
                    }
                ]
            },
            {
                "id": 8,
                "defectName": "Cizik",
                "defectDescription": "Boya sökülmesi",
                "locations": [
                    {
                        "id": 7,
                        "x": 32,
                        "y": 47,
                        "image": "resimdatası"
                    }
                ]
            },

                              .
                              .
                              .
}

```

### Defect List With Sorting 

- Request
```http
  GET http://localhost:3003/api/v1/defect-list/all/:sortvariable
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

- Response


```javascript

[
    {
        "id": 1,
        "model": modeladi,
        "defects": [
            {
                "id": 7,
                "defectName": "Cizik",
                "defectDescription": "Boya sökülmesi",
                "locations": [
                    {
                        "id": 6,
                        "x": 32,
                        "y": 57,
                        "image": "resimdatası"
                    }
                ]
            },
            {
                "id": 8,
                "defectName": "Cizik",
                "defectDescription": "Boya sökülmesi",
                "locations": [
                    {
                        "id": 7,
                        "x": 32,
                        "y": 47,
                        "image": "resimdatası"
                    }
                ]
            },

                              .
                              .
                              .
]

```

### Defect List With  Pagination

- Request

```http
  GET http://localhost:3003/api/v1/defect-list/:page/:pagesize
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

- Response


```javascript

{
"content": [
    {
        "id": 1,
        "model": modeladi,
        "defects": [
            {
                "id": 7,
                "defectName": "Cizik",
                "defectDescription": "Boya sökülmesi",
                "locations": [
                    {
                        "id": 6,
                        "x": 32,
                        "y": 57,
                        "image": "resimdatası"
                    }
                ]
            },
            {
                "id": 8,
                "defectName": "Cizik",
                "defectDescription": "Boya sökülmesi",
                "locations": [
                    {
                        "id": 7,
                        "x": 32,
                        "y": 47,
                        "image": "resimdatası"
                    }
                ]
            },

                                .
                                .
                                .
}

```

## Defect Entry Service
### New Car

- Request
```http
  POST http://localhost:3004/api/v1/defect-entry/new-vehicle
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |
| `model`   | `string` |                      |

- Response 

```javascript
{} with 200 status code
```

### New Defect Entry

- Request
```http
  POST http://localhost:3004/api/v1/defect-entry/new-vehicle
```
| Parametre      | Tip      | Açıklama             |
|:---------------|:---------|:---------------------|
| `token`        | `string` | **Required**. Token. |
| `vehicleId`    | `string` |                      |
| `defectName`   | `string` |                      |
| `operatorName` | `string` |                      |
| `x`            | `string` |                      |
| `y`            | `string` |                      |
| `image`        | `string` |                      |

- Response 

```javascript
{} with 200 status code
```
TERMİNAL OLAYI 
## Terminal Service
### Terminal Service
### Get Terminals With Sorting And Pagination

- Request
```http
  GET http://localhost:3003/api/v1/defect-list/:page/:pagesize/:sortvariable
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

- Response


```javascript
{
    "content": [
        {
            "id": 52,
            "terminalName": "a",
            "isAvailable": true
        }
                  .
                  .
                  .
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageSize": 1,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 4,
    "totalPages": 4,
    "size": 1,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```

### Get Terminals With Sorting

- Request
```http
  GET http://localhost:3003/api/v1/defect-list/all/:sortvariable
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

- Response


```javascript

[
    {
        "id": 52,
        "terminalName": "a",
        "isAvailable": true
    },
    {
        "id": 1,
        "terminalName": "Terminal1",
        "isAvailable": true
    },
    {
        "id": 2,
        "terminalName": "Terminal2",
        "isAvailable": true
    },
    {
        "id": 3,
        "terminalName": "Terminal3",
        "isAvailable": false
    }
    
                 .
                 .
                 .
]
```

### Get Terminals With  Pagination

- Request

```http
  GET http://localhost:3003/api/v1/defect-list/:page/:pagesize
```
| Parametre | Tip      | Açıklama             |
|:----------|:---------|:---------------------|
| `token`   | `string` | **Required**. Token. |

- Response


```javascript
{
    "content": [
        {
            "id": 1,
            "terminalName": "Terminal1",
            "isAvailable": true
        }
                 .
                 .
                 .
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageSize": 1,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 4,
    "totalPages": 4,
    "size": 1,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}

```



  