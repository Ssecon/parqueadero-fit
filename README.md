# parqueadero-fit
##  Objetivo:
Desarrollar un microservicio que gestione el módulo de Registrar un vehículo al parqueadero.

### El módulo de registro debe permitir:
- Agregar un vehículo (placa/patente, color, marca, dueño, modelo, hora entrada)
- Borrar un vehículo (placa/patente)
- Actualizar información del vehículo
- Mostrar la lista de vehículos agregados y/o información de un vehiculo
## SQL

Se ejecutan los siguientes scripts para la creacion de la tabla y bbdd.


Motor de base de datos elegido: MySQL

``` sql
CREATE DATABASE VEHICULOS;
```
``` sql
USE VEHICULOS;
```
``` sql
CREATE TABLE VEHICULO_INFO (
    ID INTEGER PRIMARY KEY  AUTO_INCREMENT,
    PATENTE VARCHAR(255) UNIQUE NOT NULL,
    COLOR VARCHAR(255) NOT NULL,
    MARCA VARCHAR(255) NOT NULL,
    DUEÑO VARCHAR(255) NOT NULL,
    MODELO VARCHAR(255) NOT NULL,
    HORA_ENTRADA DATETIME NOT NULL
);
```
## Api Collection (Insomnia)
``` yaml
_type: export
__export_format: 4
__export_date: 2024-01-16T19:38:36.664Z
__export_source: insomnia.desktop.app:v8.5.1
resources:
- _id: req_d7e4b4c0ab944d0eb5774b517d719b3b
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431540045
  created: 1705431246983
  url: localhost:8080/get-all-vehicles
  name: /get-all-vehicles
  description: ""
  method: GET
  body: {}
  parameters: []
  headers:
    - name: User-Agent
      value: insomnia/8.5.1
      authentication: {}
      metaSortKey: -1705431443150
      isPrivate: false
      settingStoreCookies: true
      settingSendCookies: true
      settingDisableRenderRequestBody: false
      settingEncodeUrl: true
      settingRebuildPath: true
      settingFollowRedirects: global
      _type: request
- _id: wrk_a564b051cc8d45e89a978bd3e6b7d897
  parentId: null
  modified: 1705431164622
  created: 1705431164622
  name: Parqueadero-fit
  description: ""
  scope: collection
  _type: workspace
- _id: req_6bcd2d4d879c4272938482fa9bd23bce
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431541779
  created: 1705431170158
  url: localhost:8080/find-vehicle/aa845de
  name: /find-vehicle
  description: ""
  method: GET
  body: {}
  parameters: []
  headers:
    - name: User-Agent
      value: insomnia/8.5.1
      authentication: {}
      metaSortKey: -1705431443100
      isPrivate: false
      settingStoreCookies: true
      settingSendCookies: true
      settingDisableRenderRequestBody: false
      settingEncodeUrl: true
      settingRebuildPath: true
      settingFollowRedirects: global
      _type: request
- _id: req_c5728e7cefcf41f5967e6d5597916674
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431546149
  created: 1705431305065
  url: localhost:8080/create-vehicle
  name: /create-vehicle
  description: ""
  method: POST
  body:
  mimeType: application/json
  text: |-
  {
  "patente":"aa912bo",
  "color":"Blanco",
  "marca":"BMW",
  "dueño": "Marcelo gallardo",
  "modelo": "M3"
  }
  parameters: []
  headers:
    - name: Content-Type
      value: application/json
    - name: User-Agent
      value: insomnia/8.5.1
      authentication: {}
      metaSortKey: -1705431443075
      isPrivate: false
      settingStoreCookies: true
      settingSendCookies: true
      settingDisableRenderRequestBody: false
      settingEncodeUrl: true
      settingRebuildPath: true
      settingFollowRedirects: global
      _type: request
- _id: req_049355b76030443e883ae1b54a20f717
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431533389
  created: 1705431443050
  url: localhost:8080/update-vehicle/aa845de
  name: /update-vehicle
  description: ""
  method: PATCH
  body:
  mimeType: application/json
  text: |-
  {
  "color":"Azul"
  }
  parameters: []
  headers:
    - name: Content-Type
      value: application/json
    - name: User-Agent
      value: insomnia/8.5.1
      authentication: {}
      metaSortKey: -1705431443050
      isPrivate: false
      settingStoreCookies: true
      settingSendCookies: true
      settingDisableRenderRequestBody: false
      settingEncodeUrl: true
      settingRebuildPath: true
      settingFollowRedirects: global
      _type: request
- _id: req_d8e51f5f95634d31b9d810f8dfb00890
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431420641
  created: 1705431398490
  url: localhost:8080/delete-vehicle
  name: /delete-vehicle
  description: ""
  method: DELETE
  body:
  mimeType: application/json
  text: |-
  {
  "patente":"aa845de"
  }
  parameters: []
  headers:
    - name: Content-Type
      value: application/json
    - name: User-Agent
      value: insomnia/8.5.1
      authentication: {}
      metaSortKey: -1705431398490
      isPrivate: false
      settingStoreCookies: true
      settingSendCookies: true
      settingDisableRenderRequestBody: false
      settingEncodeUrl: true
      settingRebuildPath: true
      settingFollowRedirects: global
      _type: request
- _id: env_abceddf4b7354c0eff9e2ee3799681688b3689d1
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431164627
  created: 1705431164627
  name: Base Environment
  data: {}
  dataPropertyOrder: null
  color: null
  isPrivate: false
  metaSortKey: 1705431164627
  _type: environment
- _id: jar_abceddf4b7354c0eff9e2ee3799681688b3689d1
  parentId: wrk_a564b051cc8d45e89a978bd3e6b7d897
  modified: 1705431164634
  created: 1705431164634
  name: Default Jar
  cookies: []
  _type: cookie_jar
```
