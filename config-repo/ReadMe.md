## Resources

`application`，在`bootstrap.properties`文件中设置  
`profile`，在`application.yml`文件中设置  
`label`为git branch

* {application} maps to "spring.application.name" on the client side
* {profile} maps to "spring.profiles.active" on the client (comma separated list)  
* {label} which is a server side feature labelling  

| Path             | Description  | demo |
|------------------|--------------|--------------|
| {application}-{profile} |    以文件名分组。格式：应用名-环境     | demo-dev.yml |
| {label}/{application}-{profile} | 以git branch(Service)分组，默认为master。格式：分支名/应用名-环境 | xxbranch/demo-dev.yml |

### linux port limit
2^16)-1, or 0-65,535

### Project Info
| Application | Profile | Port |
|----------|--------------|--------------|
| Eureka | default |  8761 |
| Eureka |   dev   | 18761 |
| Eureka |   prod  | 28761 |
| Gateway | default |  8000 |
| Gateway |   dev   | 18000 |
| Gateway |   prod  | 28000 |
| ZipKin | default |  8200 |
| ZipKin |   dev   | 18200 |
| ZipKin |   prod  | 28200 |
| SpringBootAdmin | default |  8400 |
| SpringBootAdmin |   dev   | 18400 |
| SpringBootAdmin |   prod  | 28400 |
| Search | default |  8030 |
| Search |   dev   | 18030 |
| Search |   prod  | 28030 |
| SpringCloudImpl | default |  8010 |
| SpringCloudImpl |   dev   | 18010 |
| SpringCloudImpl |   prod  | 28010 |
| Rabbitmq |   -  | 5672 |
| MySQL |   -  | 3306 |
| LogStash |   -  | 5044 |