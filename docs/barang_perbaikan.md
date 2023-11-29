# Barang Perbaikan API Spec

## Create Barang Perbaikan

Endpoint : POST http://localhost:8080/api/v1/bperbaikan/create

Request Body :

```json
{
  "noNPK": "111-222-3333-4444",
  "namaBarang": "rudal balistik",
  "keterangan": "transaksi pembelian rudal balistik",
  "kapal": "KNP 409"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": 2,
    "no": 2,
    "tanggal": "2023-11-29T07:44:12.13859494",
    "noNPK": "111-222-3333-4444",
    "namaBarang": "rudal balistik",
    "keterangan": "transaksi pembelian rudal balistik",
    "kapal": "KNP 409",
    "createdAt": "2023-11-29T07:44:12.161996832",
    "updatedAt": "2023-11-29T07:44:12.161996832"
  },
  "status_code": 200,
  "message": "The item was created successfully",
  "errors": null
}
```

Response Body (Failed) :

```json
{
  "errors" : "Barang Perbaikan is not found"
}
```

## Update(Composite) Barang Perbaikan

Endpoint : PUT http://localhost:8080/api/v1/bperbaikan/update/{idBarangPerbaikan}

Request Body :

```json
{
  "noNPK": "111-222-3333-4444-update",
  "namaBarang": "rudal balistik update",
  "keterangan": "transaksi pembelian rudal balistik update",
  "kapal": "KNP 409 update"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": 2,
    "no": 2,
    "tanggal": "2023-11-29T07:44:12.138595",
    "noNPK": "111-222-3333-4444-update",
    "namaBarang": "rudal balistik update",
    "keterangan": "transaksi pembelian rudal balistik update",
    "kapal": "KNP 409 update",
    "createdAt": "2023-11-29T07:44:12.161997",
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
  "errors" : "Barang Perbaikan is not found"
}
```

## List Barang Perbaikan

Endpoint : GET /api/v1/bperbaikan/fetch?offset=number?limit=number?sorting=key_json?key_json=value_json

Endpoint : GET http://localhost:8080/api/v1/bperbaikan/fetch?page=&size=&sort=&namaBarang=

Response Body (Success) :

```json
{
  "list": [
    {
      "id": 2,
      "no": 2,
      "tanggal": "2023-11-29T07:44:12.138595",
      "noNPK": "111-222-3333-4444-update",
      "namaBarang": "rudal balistik update",
      "keterangan": "transaksi pembelian rudal balistik update",
      "kapal": "KNP 409 update",
      "createdAt": "2023-11-29T07:44:12.161997",
      "updatedAt": "2023-11-29T07:46:01.684279"
    },
    {
      "id": 1,
      "no": 1,
      "tanggal": "2023-11-29T06:52:48.905275",
      "noNPK": "4444-5555-6666",
      "namaBarang": "meriam",
      "keterangan": "berlabuh di perairan jakarta",
      "kapal": "KNP sinar mas 402",
      "createdAt": "2023-11-29T06:52:48.917251",
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
  "errors" : "Barang Perbaikan is not found"
}
```

## Remove Barang Perbaikan

Endpoint : DELETE http://localhost:8080/api/v1/bperbaikan/remove/{idBarangPerbaikan}

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
  "errors" : "Barang Perbaikan is not found"
}
```

## Get Barang Perbaikan

Endpoint : GET http://localhost:8080/api/v1/bperbaikan/detail/{idBarangPerbaikan}

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
  "errors" : "Barang Perbaikan is not found"
}
```