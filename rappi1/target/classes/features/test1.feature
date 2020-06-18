Feature: Validacion Rest servicio1
  Se requiere validar el response code y un campo del response

  Scenario: Validacion Correcta de Api servicio1
    Given Luis quiere consumir el api rest servicio1
    When el envia la peticion rest servicio1
    Then debe recibir las validaciones necesarias rest servicio1