# Generate Key
openssl genpkey -algorithm RSA -aes256 > private_key.pem
openssl rsa -in private_key.pem -pubout -outform PEM -out public_key.pem
openssl req -x509 -key private_key.pem -subj /CN=YOUR_DOMAIN.COM -days 99999  > certificate.pem
openssl pkcs12 -export -inkey private_key.pem -in certificate.pem -out pilot.p12 -name "smp.pilot"

# Docker Build & Launch
docker build --pull -t phoss-smp-with-config -f Dockerfile .
docker run -d --name phoss-smp-with-config -p 80:8080 phoss-smp-with-config
docker stop phoss-smp-with-config
docker rm phoss-smp-with-config
