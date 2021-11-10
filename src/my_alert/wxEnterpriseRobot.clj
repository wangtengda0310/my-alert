(ns my-alert.wxEnterpriseRobot)

;; https://work.weixin.qq.com/api/doc/90000/90136/91770

;如何使用群机器人
;在终端某个群组添加机器人之后，创建者可以在机器人详情页看的该机器人特有的webhookurl。开发者可以按以下说明a向这个地址发起HTTP POST 请求，即可实现给该群组发送消息。下面举个简单的例子.
;假设webhook是：https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=693a91f6-7xxx-4bc4-97a0-0ec2sifa5aaa
;特别特别要注意：一定要保护好机器人的webhook地址，避免泄漏！不要分享到github、博客等可被公开查阅的地方，否则坏人就可以用你的机器人来发垃圾消息了。
;
;以下是用curl工具往群组推送文本消息的示例（注意要将url替换成你的机器人webhook地址，content必须是utf8编码）：
;
;curl 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=693axxx6-7aoc-4bc4-97a0-0ec2sifa5aaa' \
;   -H 'Content-Type: application/json' \
;   -d '
;   {
;        "msgtype": "text",
;        "text": {
;            "content": "hello world"
;        }
;   }'
;当前自定义机器人支持文本（text）、markdown（markdown）、图片（image）、图文（news）四种消息类型。
;机器人的text/markdown类型消息支持在content中使用<@userid>扩展语法来@群成员

;消息发送频率限制
;每个机器人发送的消息不能超过20条/分钟。

;消息类型及数据格式

;todo 文本类型
;todo 图片类型
;todo 图文类型                                                        ;
;todo 文件类型
;todo 模版卡片类型 文本通知模版卡片
;todo 模版卡片类型 图文展示模版卡片

;todo 文件上传接口