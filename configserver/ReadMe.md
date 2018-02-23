# Config Server，可以在所有环境中管理应用程序的外部属性

## Q&A

### ConfigServer Service如何多环境支持？
* ConfigServer Service不需要多环境支持，一个ConfigServer管理多个环境

### ConfigServer Service和Eureka如何多环境匹配？
* Eureka中的bootstrap file中配置ConfigServer Service
