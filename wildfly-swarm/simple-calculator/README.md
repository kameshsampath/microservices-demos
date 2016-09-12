# Microservices with Wildfly Swarm

A very trival, simple calculator microservice demo application build using [wildfly-swarm](http://wildfly-swarm.io/). The
sample application provides a [swagger](http://swagger.io/) representation of the services.

# Build and running the service with Docker 

This applications uses the [s2i](https://github.com/openshift/source-to-image/releases) to build the docker
image from sources.  To build and run the application follow the steps below,

 1. Download [s2i](https://github.com/openshift/source-to-image/releases) and add it to the path
 2. run the following command `s2i build https://github.com/kameshsampath/microservice-demos/simple-calculator -e "artifactId=simple-calculator" kameshsampath/microservice-java-s2i msa-simplecalc-app`
 3. the step#2 would build a docker image called `msa-simplecalc-app`, use `docker run -p 8080:8080 msa-simplecalc-app`
 4. Use [swagger ui](http://swagger.io/swagger-ui/), and use swagger ui to point API url to `http://localhost:8080/swagger.json` to get list of 
    available operations and play with the REST API

# LICENSE
Copyright 2016 Kamesh Sampath

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

# References
* [s2i](https://github.com/openshift/source-to-image/releases)
* [wildfly-swarm](http://wildfly-swarm.io/)