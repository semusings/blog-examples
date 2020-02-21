export KUBE_NAMESPACE := order-service
export APP_NAME := order-service
build:
	cd springboot-order-crud-service && mvn clean package -DskipTests
image:
	cp -R springboot-order-crud-service/target/springboot-order-crud-service.war docker/springboot-order-crud-service.war
	docker-compose build
	rm -rf docker/springboot-order-crud-service.war
up:
	docker-compose up
push:
	docker-compose push
clean:
	./kube-delete.sh ${KUBE_NAMESPACE} ${APP_NAME}
sslKey:
	./create-tls-certs.sh
kubeSslKey:
	./create-tls-certs.sh
logs:
	./kube-logs.sh ${KUBE_NAMESPACE} ${APP_NAME}
pods:
	kubectl get pods --namespace ${KUBE_NAMESPACE}
deploy:
	./kube-deploy.sh ${KUBE_NAMESPACE} ${APP_NAME}
helmInstall:
	helm install --dry-run --debug ./helm/order-service
all: image push deploy