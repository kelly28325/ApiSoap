# 📦 API SOAP - Seguimiento de Paquetes (Tracking)

Este proyecto es una API SOAP desarrollada con **Spring Boot** que permite consultar el estado de un paquete logístico a través de su código de seguimiento.

---

## 🚀 Tecnologías utilizadas

- Java 11+
- Spring Boot
- Maven
- JAX-WS (SOAP)
- IntelliJ IDEA / Eclipse

---

## 📦 Cómo desplegar la API

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/kelly28325/ApiSoap.git
cd ApiSoap
```

### 2️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

O desde tu IDE, ejecuta la clase `SoapTrackingApplication.java`.

---

## 🔍 Probar la API SOAP

### 1. Acceder al WSDL

Abre el navegador en:

```
http://localhost:8080/ws/tracking.wsdl
```

Este archivo define el servicio y permite generar clientes SOAP.

---

### 2. Usar herramienta cliente SOAP

Puedes usar [SOAP UI](https://www.soapui.org/) u otra herramienta para enviar una solicitud. 

---

### 🧪 Ejemplo de Request SOAP

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:trk="http://www.logistica.com/soaptracking">
   <soapenv:Header/>
   <soapenv:Body>
      <trk:GetTrackingStatusRequest>
         <trk:trackingCode>ABC123</trk:trackingCode>
      </trk:GetTrackingStatusRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

---

### 📬 Ejemplo de Respuesta SOAP

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:trk="http://www.logistica.com/soaptracking">
   <soapenv:Header/>
   <soapenv:Body>
      <trk:GetTrackingStatusResponse>
         <trk:status>En tránsito</trk:status>
         <trk:events>
            <trk:event>
               <trk:location>Quito</trk:location>
               <trk:timestamp>2025-06-01T10:00:00</trk:timestamp>
            </trk:event>
         </trk:events>
      </trk:GetTrackingStatusResponse>
   </soapenv:Body>
</soapenv:Envelope>
```

---

## 🧑‍💻 Autora

- **Kelly Altamirano**
- 📦 Repositorio: [https://github.com/kelly28325/ApiSoap]

