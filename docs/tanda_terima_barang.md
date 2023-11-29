# Tanda Terima API Spec

## Create Tanda Terima 

Endpoint : POST http://localhost:8080/api/v1/barang/create

Request Body :

```json
{
  "noNPP": "1111-2222",
  "namaBarang": "rudal balistik",
  "keterangan": "bla bal bla",
  "kapal": "KNP 420"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": 2,
    "no": 2,
    "tanggal": "2023-11-29T06:54:55.206165857",
    "noNPP": "1111-2222",
    "namaBarang": "rudal balistik",
    "keterangan": "bla bal bla",
    "kapal": "KNP 420",
    "createdAt": "2023-11-29T06:54:55.206727159",
    "updatedAt": "2023-11-29T06:54:55.206727159"
  },
  "status_code": 200,
  "message": "The item was created successfully",
  "errors": null
}
```

Response Body (Failed) :

```json
{
  "errors" : "Tanda Terima is not found"
}
```

## Update(Composite) Terima Barang

Endpoint : PUT http://localhost:8080/api/v1/barang/update/{idTandaTerima}

Request Body :

```json
{
  "noNPP": "1111-2222",
  "namaBarang": "rudal balistik",
  "keterangan": "bla bal bla",
  "kapal": "KNP 420"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": 2,
    "no": 2,
    "tanggal": "2023-11-29T06:54:55.206166",
    "noNPP": "9999-900",
    "namaBarang": "rudal balistik",
    "keterangan": "bla bal bla",
    "kapal": "KNP 420",
    "createdAt": "2023-11-29T06:54:55.206727",
    "updatedAt": null
  },
  "status_code": 200,
  "message": "The item was updated successfully",
  "errors": null
}
```

Response Body (Failed) :

```json
{
  "errors" : "Tanda Terima is not found"
}
```

## List Tanda Terima

Endpoint : GET api/v1/barang/fetch?offset=number?limit=number?sorting=key_json?key_json=value_json

Endpoint : GET http://localhost:8080/api/v1/barang/fetch?page=&size=&sort=&kapal=

Response Body (Success) :

```json
{
  "list": [
    {
      "id": 2,
      "no": 2,
      "tanggal": "2023-11-29T06:54:55.206166",
      "noNPP": "9999-900",
      "namaBarang": "rudal balistik",
      "keterangan": "bla bal bla",
      "kapal": "KNP 420",
      "createdAt": "2023-11-29T06:54:55.206727",
      "updatedAt": "2023-11-29T06:58:13.384163"
    },
    {
      "id": 1,
      "no": 1,
      "tanggal": "2023-11-29T06:52:48.431173",
      "noNPP": "1111-2222-3333",
      "namaBarang": "torpedo",
      "keterangan": "berlabuh di perairan cirebon",
      "kapal": "KNP sinar mas 403",
      "createdAt": "2023-11-29T06:52:48.53747",
      "updatedAt": null
    }
  ],
  "status_code": 200,
  "message": "The item exist",
  "errors": null,
  "paging": {
    "currentPage": 0,
    "totalPage": 1,
    "sizePage": 10
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Tanda Terima is not found"
}
```

## Remove Tanda Terima

Endpoint : DELETE http://localhost:8080/api/v1/barang/remove/{idTandaTerima}

Response Body (Success) :

```json
{
  "data": "",
  "status_code": 200,
  "message": "The item was deleted successfully",
  "errors": null
}
```

Response Body (Failed) :

```json
{
  "errors" : "Tanda Terima is not found"
}
```

## Get Tanda Terima

Endpoint : GET http://localhost:8080/api/v1/barang/detail/{idTandaTerima}

Response Body (Success) :

```json
{
  "data": {
    "id": 1,
    "no": 1,
    "tanggal": "2023-11-29T06:52:48.431173",
    "noNPP": "1111-2222-3333",
    "namaBarang": "torpedo",
    "keterangan": "berlabuh di perairan cirebon",
    "kapal": "KNP sinar mas 403",
    "createdAt": "2023-11-29T06:52:48.53747",
    "updatedAt": null
  },
  "status_code": 200,
  "message": "The item exist",
  "errors": null
}
```

Response Body (Failed) :

```json
{
  "errors" : "Tanda Terima is not found"
}
```