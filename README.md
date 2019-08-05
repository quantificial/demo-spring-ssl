## spring boot example for using ssl

It is needed to generate a private key and public key. They could be self signed or purchase from authorized CA

example of how to consume the ssl endpoint

> github: spring-ssl-consumer

### generate ssl

please refer to  https://github.com/quantificial/brain/wiki/OpenSSL

### generate the self signed certificate

openssl req -x509 -nodes -sha256 -days 365 -newkey rsa:2048 -keyout private.key -out private.crt

private key: private.key

public key: private.crt

### convert the certificate to PKCS12 format 

openssl pkcs12 -export -in private.crt -inkey private.key -name testlocal -out output.p12

need to input export password

### set the spring boot properties

```
http.port=8080

server.port=8443

security.require-ssl=true

# The format used for the keystore
server.ssl.key-store-type=PKCS12

# The path to the keystore containing the certificate
server.ssl.key-store=classpath:keystore/output.p12

# The password used to generate the certificate
server.ssl.key-store-password=abcd1234

# The alias mapped to the certificate
server.ssl.key-alias=testlocal

#trust store location
trust.store=classpath:keystore/test.p12

#trust store password
trust.store.password=password


```


## Resources

https://www.baeldung.com/spring-boot-https-self-signed-certificate

https://unix.stackexchange.com/questions/347116/how-to-create-keystore-and-truststore-using-self-signed-certificate

https://medium.com/@niral22/2-way-ssl-with-spring-boot-microservices-2c97c974e83

