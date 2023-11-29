# Barang Perbaikan Admin API Spec

## Create Barang Perbaikan Adminn

Endpoint : POST http://localhost:8080/api/v1/bperbaikanadmin/create

Request Body :

```json
{
  "namaBarang" : "rudal balistik",
  "bengkelToko" : "toko 1",
  "isPrimary" : false,
  "posisiBarang" : "cirebon",
  "keterangan" : "sedang transasksi belu rudal",
  "kapal" : "KNP 40998"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": 2,
    "no": 2,
    "namaBarang": "rudal balistik",
    "tanggal": "2023-11-29T07:53:17.000629576",
    "bengkelToko": "toko 1",
    "isPrimary": false,
    "posisiBarang": "cirebon",
    "keterangan": "sedang transasksi belu rudal",
    "kapal": "KNP 40998",
    "createdAt": "2023-11-29T07:53:17.002448685",
    "updatedAt": "2023-11-29T07:53:17.002448685"
  },
  "status_code": 200,
  "message": "The item was created successfully",
  "errors": null
}
```

Response Body (Failed) :

```json
{
  "errors" : "Barang Perbaikan Admin is not found"
}
```

## Update(Composite) Barang Perbaikan Admin

Endpoint : PUT http://localhost:8080/api/v1/bperbaikanadmin/update/{idPerbaikanAdmin}

Request Body :

```json
{
  "namaBarang" : "rudal balistik update",
  "bengkelToko" : "toko 1 update",
  "isPrimary" : true,
  "posisiBarang" : "cirebon update",
  "keterangan" : "sedang transasksi belu rudal update",
  "kapal" : "KNP 40998 update"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": 2,
    "no": 2,
    "namaBarang": "rudal balistik update",
    "tanggal": "2023-11-29T07:53:17.00063",
    "bengkelToko": "toko 1 update",
    "isPrimary": true,
    "posisiBarang": "cirebon update",
    "keterangan": "sedang transasksi belu rudal update",
    "kapal": "KNP 40998 update",
    "createdAt": "2023-11-29T07:53:17.002449",
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
  "errors" : "Barang Perbaikan Admin is not found"
}
```

## List Barang Perbaikan Admin

Endpoint : GET /api/v1/bperbaikanadmin/fetch?offset=number?limit=number?sorting=key_json?key_json=value_json

Endpoint : GET http://localhost:8080/api/v1/bperbaikanadmin/fetch?page=&size=&sort=&isPrimary=true

Response Body (Success) :

```json
{
  "list": [
    {
      "id": 2,
      "no": 2,
      "namaBarang": "rudal balistik update",
      "tanggal": "2023-11-29T07:53:17.00063",
      "bengkelToko": "toko 1 update",
      "isPrimary": true,
      "posisiBarang": "cirebon update",
      "keterangan": "sedang transasksi belu rudal update",
      "kapal": "KNP 40998 update",
      "createdAt": "2023-11-29T07:53:17.002449",
      "updatedAt": "2023-11-29T07:54:28.094124"
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
  "errors" : "Barang Perbaikan Admin is not found"
}
```

## Remove Barang Perbaikan Admin

Endpoint : DELETE http://localhost:8080/api/v1/bperbaikanadmin/remove/{idPerbaikanAdmin}

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
  "errors" : "Barang Perbaikan Admin is not found"
}
```

## Get Barang Perbaikan Admin

Endpoint : GET http://localhost:8080/api/v1/bperbaikanadmin/detail/{idBarangPerbaikanAdmin}

Response Body (Success) :

```json
{
  "data": {
    "id": 1,
    "no": 1,
    "namaBarang": "Piston",
    "tanggal": "2023-11-29T06:52:49.03913",
    "bengkelToko": "Bengkel Las Sejahtra",
    "isPrimary": false,
    "posisiBarang": "di luar kapal",
    "keterangan": "berlabuh di perairan jakarta, dan sedang perbaikan",
    "kapal": "KNP sinar mas 401",
    "createdAt": "2023-11-29T06:52:49.046857",
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
  "errors" : "Barang Perbaikan Admin is not found"
}
```