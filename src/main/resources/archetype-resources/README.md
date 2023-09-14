#Welcome to ${rootArtifactId} Microservice project for Sicatel

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000)
> Telcel Sicatel ${rootArtifactId}

## Install

	${rootArtifactId}-api Microservice. Tested for Spring Boot 2.7.1, Java 8 and Eclipse 2021-09 (4.21.0)

	To compile the project is necessary to run in the main pom.xml this command:
	mvn clear verify


	[localhost](http://localhost:9090/${rootArtifactId}-api/swagger-ui/index.html)
	[QA](http://localhost:9090/${rootArtifactId}-api/swagger-ui/index.html)

Liberty Server

    Configure the variables in the jvm.option file in OpenShift
	-DSICATEL.PROFILE=dev



## Usage

	Use Postman or Spring Swagger UI to call a service
		[healthCheck](http://localhost:9090/${rootArtifactId}-api/swagger-ui/index.html)

## Author

*Sicatel TEAM*

* Website: www.telcel.com
* Gitlab: [Telcel/@Sicatel](http://intranet.telcel.com:9045/gitlab/)

## License

Copyright � 2023 Sicatel Telcel.

This project is [UNLICENSED] licensed.