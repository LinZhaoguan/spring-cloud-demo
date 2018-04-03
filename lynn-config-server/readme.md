我们可以通过浏览器、POSTMAN或CURL等工具直接来访问到我们的配置内容。访问配置信息的URL与配置文件的映射关系如下：
- /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.properties

上面的url会映射{application}-{profile}.properties对应的配置文件，其中{label}对应Git上不同的分支，默认为master。我们可以尝试构造不同的url来访问不同的配置内容，比如，要访问master分支，config-client应用的dev环境，就可以访问这个url：http://localhost:1201/lynn-config-client/dev/master