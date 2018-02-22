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