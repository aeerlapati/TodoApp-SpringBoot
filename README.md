# TodoApp Spring Boot

## To run this app Locally
1. Clone this repo and navigate to this project folder
2. Run ./mvnw spring-boot:run 

## To deploy it to Docker
1. Run the command docker build -f Dockerfile -t (Some Name) for building an image in docker.
2. You may navigate to the project folder locally and run -- docker run -p 9095:9095 -it --rm --name my-maven-project -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3.3-jdk-8 mvn spring-boot:run
   for running the app on 9095 port with name my-maven-project

## To Access the database locally run below command
http://localhost:9095/h2-console/login.jsp

## Authorization
while testing through postman select basic as authorization type and use below credentials
Username: user
Password: password
