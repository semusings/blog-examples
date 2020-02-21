export KUBE_NAMESPACE := spring-boot-oracle-db-in-kubernetes
export APP_NAME := k8s-spring-boot
export APP_INGRESS := api2.spring-boot.$(GROUP).$(KUBE_API_ENDPOINT)
appUp:
	helm upgrade \
        --install \
        --force \
        --set image.pullPolicy=Always \
        --set ingress.hosts[0]=${APP_INGRESS} \
        --namespace=${KUBE_NAMESPACE} \
        ${APP_NAME}  \
        ./helm/${APP_NAME}
clean:
	helm delete --purge ${APP_NAME}
logs:
	./scripts/get-logs.sh ${KUBE_NAMESPACE} ${APP_NAME}
describe:
	./scripts/get-describe.sh ${KUBE_NAMESPACE} ${APP_NAME}
package:
	./gradlew clean build
image: package
	docker-compose build
imageUp:
	docker-compose up
publish:
	docker-compose push
up: appUp
all: image publish up