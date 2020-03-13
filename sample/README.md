# sample user-management-service

For User Registration, Login and Change Password

## System Requirements & Tool Dependencies
1. Java 11 OpenJDK
2. Docker & Docker Compose
3. Maven
4. IDE of your choice

## Installation

### IDE Setup

You can use any IDE of your choice. Spring Tool Suite (STS) 4 works just fine in this case. (Download location is https://spring.io/tools)

SpringToolSuite4.ini file may look like following after you set desired memory options based on your machine's available memory:


### Database Setup

1. Install [Docker](https://www.docker.com/) and [Docker Compose](https://docs.docker.com/compose/install/).

2. A Docker Compose file is available in docker-compose.yml file in sample/dev-tools/docker. From that directory run `docker-compose up` and all service prerequisites will be running.

```
host: localhost
port: 3306
database: sample
user: root
password: services

## Service Startup
1. In order to run the service,  run the docker-compose up command to set up mysql. 
2. Connect to mysql from a client and create the scema "sample".
3. you can use STS's Project Right Click and Run/Debug as apring boot application
3. When the service is started, it will connect to the schema `sample` and will set up the tables using Flyway scripts available within resources


