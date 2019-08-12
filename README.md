## spring boot example for using ssl

It is needed to generate a private key and public key. They could be self signed or purchase from authorized CA

example of how to consume the ssl endpoint

> github: spring-ssl-consumer

### generate ssl

please refer to  https://github.com/quantificial/brain/wiki/OpenSSL

### generate the self signed certificate

openssl req -x509 -nodes -sha256 -days 365 -newkey rsa:2048 -keyout secure.key -out secure.crt

private key: secure.key

public key: secure.crt

### convert the certificate to PKCS12 format 

openssl pkcs12 -export -in secure.crt -inkey secure.key -name testlocal -out secure.p12

need to input export password to protect the secure.p12 key

### if it is necessary to convert to jks, please use the command below

keytool -importkeystore -destkeystore secure.jks -srckeystore secure.p12 -srcstoretype pkcs12 -alias testlocal

### set the spring boot properties

```
http.port=8080

server.port=8443

security.require-ssl=true

# The format used for the keystore
server.ssl.key-store-type=PKCS12

# The path to the keystore containing the certificate
server.ssl.key-store=classpath:keystore/secure.p12

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

