build:
	mvn clean package -DskipTests
image:
	docker-compose build --no-cache
redis:
	docker-compose up redis postgres
app:
	docker-compose up redis-in-hibernate
test:
	cd artillery-load-testing && npm install && npm run test && npm run report