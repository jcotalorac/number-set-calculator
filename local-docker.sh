docker rm -f number-set-calculator
docker build --tag number-set-calculator-img .
docker run -p 8080:8080 --env SPRING_PROFILES_ACTIVE=dev --name number-set-calculator number-set-calculator-img