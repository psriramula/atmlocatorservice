# atm-locator-service #

[![GitHub version](https://img.shields.io/badge/version-0.0.1-orange.svg)](https://github.com/psriramula/atmlocatorservice/releases)


heu-ftm-service is an implementation for Play-WS standalone client, providers Flex Trade Manager apis / services for partners and internal process monitoring.


## Prerequisite
---------------
* [JDK 1. 8 ](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), at least version  1.8.0_650
* [sbt ](https://www.scala-sbt.org/download.html), sbt ( Scala Build Tool ) , at least version 1.1.0
* [Community Edition - Docker](https://www.docker.com/community-edition#/download) 

## Compiling
---------
To compile the code

```
$ sbt compile
```

## testing
---------
To exectute the tests

```
$ sbt test
```


## Running
----------

To run with in Development environment

```
$ sbt 'run 9000'
```
or if you are with in Windows environment

```
$ sbt 
```
Once you are in SBT console type the following command

```
SBT Command PRMOBT> run 9000
```

## Access the application within local environment


```
http://localhost:9000/atmlocation/<CITY NAME >
for example 
http://localhost:9000/atmlocation/Hilversum
```



## Generate executable application 

sbt dist will generate required zip file with self contained dependacies and executions file
```
$ sbt dist
```

copy the generated zip file to your required path 
```
<your execution path >$ < YOUR WORKSPACE >/atm-locator-service/target/universal/atmlocatorservice-1.0.zip .
```

unzip the archive locally ( atmlocatorservice-1.0.zip), with your unzip tool ( i.e unzip )
```
<your execution path >$ unzip atmlocatorservice-1.0.zip 
```

execute the application by running ( for linux based OS)

```
<your execution path >$ chmod +x ./atmlocatorservice-1.0/bin/atmlocatorservice
<your execution path >$ ./atmlocatorservice-1.0/bin/atmlocatorservice

```


execute the application by running ( for windows  OS)

```
<your execution path >$ ./atmlocatorservice-1.0/bin/atmlocatorservice.bat

```

## Generating docker files and resources

Enter the following coomand at the project folder to generate docker files and the resources

```
$ sbt docker:publishLocal
```


## Generating docker image

Change to the  scripts folder 

```
$ cd scripts
< YOUR WORKSPACE >/atm-locator-service/scripts$
```

run the build.sh to generate the docker images locally, which as the feature to push the images to ECR
```
< YOUR WORKSPACE >/atm-locator-service/scripts$./build.sh
```




# verify the newly generated docker image by listing local docker images :

```
$ docker images
```
You shall see list of all local docker images including heu-ftm-service:latest

```
REPOSITORY                      TAG                 IMAGE ID            CREATED             SIZE
atm-locator-service             latest              d4821899ca5d        17 minutes ago      790MB 
```

# run docker image locally

run the docker image locally with ports 9000:9000

```
$ docker run -it atm-locator-service :latest
```

-it allows the applicatio execution console out


# Further reading
* Play Framework - https://www.playframework.com




## Known limitation
----------
* Application assuming current REST Call and existing ill formed Json with ")]}',"   when called https://www.ing.nl/api/locator/atms/
