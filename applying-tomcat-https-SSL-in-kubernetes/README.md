# Applying Tomcat https SSL in Kubernetes

Generate a self-signed certificate with openssl (or better yet, obtain a real certificate from a certificate authority):
```bash
./create-certs.sh
```
Open the link https://localhost:8443/

SSL configuration in `server.xml`
```xml
        <Connector port="8443"
                   maxThreads="150"
                   enableLookups="false"
                   disableUploadTimeout="true"
                   acceptCount="100"
                   scheme="https"
                   secure="true"
                   SSLEnabled="true"
                   SSLCertificateFile="${catalina.base}/conf/ssl.crt"
                   SSLCertificateKeyFile="${catalina.base}/conf/ssl.key"/>
```

https://medium.com/nuvo-group-tech/move-your-certs-to-helm-4f5f61338aca