#!/usr/bin/env bash
cd docker/config && \
    rm -rf ssl.crt ssl.key && \
    openssl req -new -newkey rsa:4096 -days 3650 -nodes -x509 -subj \
    "/C=NP/ST=FarWest/L=Lamki/O=BhuwanUpadhyay/CN=*.bhuwanupadhyay.github.io" -keyout \
    ./ssl.key -out ./ssl.crt