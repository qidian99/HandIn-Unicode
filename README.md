# HandIn

交付的过程无处不在。中学时代的每天的我们，每天做着老师布置的作业，交作业的过程是一种交付；大学后，每个PA，每个Lab独立自主实现并提交，是一种交付；工作以后，每一个业务的对接、问题的排查，也是一种交付。但是我们会发现，随着我们踏入人生的不同的阶段，标准的定义在逐渐模糊，我们有时候甚至根本找不到交付的「对象」，而因此陷入深深地焦虑与迷茫。

其实，我们与别人的连接与互动只是辅助，最重要的是实现对自己的「交付」：正确的认识自己，接受过去的自己，知行合一、顺势而为。在疫情这样的苦难与成长并存的环境下，Reconnect, Rethink, and Reform.

HandIn，你的重聚，我来安排。

## Unihack

### BP
[文章见公众号](https://mp.weixin.qq.com/s/nkjAyECkh5iYodEX8bLjmw)

### 一些资源

「羊毛资源」每天在公众号上面领红包，「饿了么」「美团」「话费」「电影票」

![](https://files.mdnice.com/user/16796/cf48118b-20fa-498c-8cc2-3d1ff0415891.png)

「学术切入」请联系

![](https://files.mdnice.com/user/16796/4ebb7d6a-b433-4fd9-9d17-c97516740630.png)

「个人联系」请备注意图（合作、资源、黑客松、创坛、学习、公益）

![](https://files.mdnice.com/user/16796/58163a5a-013a-4d73-95f5-e7bd9d0c4e8b.png)

## Memegle (HandIn✖️UCSD Triple C）

A search engine for Meme Pictures

该项目和UCSD Triple C也有合作，Triple C在做类似AI中台的提高图片质量的后端内容，同时也会做前端的切入形式的探索。我BP中提到的

1. iOS ShortCut开发，通过大白点一键生成模板表情包
2. 智能斗图序列预测
3. PC（macOS, Windows, Unix）、移动（iOS, Android）一站式开发

Triple C也会尝试，进展预计会缓慢。需要大佬加盟，有意向者加朱总VX：

![](./assets/memegle-qr.JPG)

### Dependencies
**To run this app, the following dependencies are required.**

1. Python3 (and pip3)
2. [Docker](https://www.docker.com/products/docker-desktop) and Docker-Compose

([MongoDB compass](https://www.mongodb.com/products/compass) is a tool for visualizing the MongoDB database, and is recommended.)

(URL to use in Mongo Compass is mongodb://127.0.0.1:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false)

(Windows users are recommended to use [Git Bash](https://gitforwindows.org/), which docker-compose comes along with)

### Running the app in dev environment
(All path are relative to current directory)
1. Run `./scripts/build.sh`
    - This will compile all the source code and create all docker images needed
    - Another option is to manually compile the source code with your IDE, before that you need to run `docker-compose up monstache` for all the required service to be available. (If you are doing it this way, sometime the container for monstache may fail to start because the elasticsearch is starting up slow. If this happens, keep the current terminal window open and re-run the command in a new terminal window in awhile)
2. Run `docker-compose up`

Client will be up on [localhost:3000]() and Server should be up on [localhost:8080](). 

Default ports: 27017 for MongoDB; 9200 for ElasticSearch.

(hot reload should be working for client both client and server now, reload for client will be relatively faster)

If you have made changes to server code, watch the terminal and look for the following logging message (which indicates the auto reload has been completed and you should be able to see the new changes on localhost:8080)
```$xslt
server_1         | 2020-07-16 09:26:22.483  INFO 114 --- [  restartedMain] c.m.server.util.ApplicationStartup       : BASE_URL is: http://localhost:8080
server_1         | 2020-07-16 09:26:22.485  INFO 114 --- [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged
```
### Other Notices
- If you see on terminal that monstache complains query to elasticsearch is FORBIDDEN with messages similar to something like READ_ONLY is set, it's probably because you're using up the space in your docker virtual machine. To fix this run the following commands (with elasticsearch container running).
    - `docker system prune` (this will remove unused images/containers/volumes)
    - `./scripts/reset-es-readonly.sh` (this will disable read-only property on elasticsearch)
