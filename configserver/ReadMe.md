# Spring Cloud Config

通过Spring Cloud Bus，可以在所有环境中管理应用程序的属性

### 绑定的 config-repo[git] 目录结构

The HTTP service has resources in the following form:

```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```
where **application** is injected as the spring.config.name in the **SpringApplication** (what is normally application in a regular Spring Boot app),   
**profile** is an active profile (or comma-separated list of properties),  
and **label** is an optional git label (defaults to **master**.)

Spring Cloud Config Server pulls configuration for remote clients from various sources. The following example gets configuration from a git repository (which must be provided), as shown in the following example:

```
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/spring-cloud-samples/config-repo

```
Other sources are any JDBC compatible database, Subversion, Hashicorp Vault, Credhub and local filesystems.

### DEMO

在依赖了spring-cloud-config-client 的模块的bootstrap.properties 中配置spring-cloud-config信息

```
## config server setting must be bootstrap file

# Flag to say that remote configuration is enabled. Default true;
spring.cloud.config.enabled=true

# The URI of the remote config server (default http://localhost:8888).
spring.cloud.config.uri=http://localhost:8888/

# The default profile to use when fetching remote configuration (comma-separated).
# Default is "default".
spring.cloud.config.profile=dev

# The label name to use to pull remote configuration properties.
# The default is set on the server (generally "master" for a git based server).
spring.cloud.config.label=dev

# Service id to locate config server. Default is "configserver"
spring.cloud.config.discovery.service-id=ConfigServer
```