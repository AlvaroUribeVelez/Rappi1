Feature: Validacion Rest servicio2
  Se requiere validar el response code y un campo del response

  Scenario: Validacion Correcta de Api servicio2
    Given Luis quiere consumir el api rest servicio2
    When el envia la peticion rest servicio2
    Then debe recibir las validaciones necesarias rest servicio2