spring-boot-doc是一款针对IT团队开发的简单好用的文档管理系统。

spring-boot-doc的前身是[MinDoc](https://git.oschina.net/longfei6671/godoc)，MinDoc 的前身是 SmartWiki 文档系统。SmartWiki 是基于 PHP 框架 laravel 开发的一款文档管理系统。因 PHP 的部署对普通用户来说太复杂，所以原作者改用 Golang 开发。然而对于自身一个JAVAE开发者来说，对于GO语言，出现问题又不能解决，所以使用spring-boot重写了MinDoc，可以方便JAVA用户部署和使用，目前只完善了部分功能，持续更新中。

## 使用的技术

- spring-boot 1.52
- thymeleaf 2.1.5 
- kaptcha 2.3.2
- mysql 5.6
- editor.md
- bootstrap 3.2
- vuejs 2.2.6
- jquery 库
- layer 弹出层框架
- webuploader 文件上传框架
- Nprogress 库
- jstree 树状结构库
- font awesome 字体库
- cropper 图片剪裁库
- layer 弹出层框架
- highlight 代码高亮库
- to-markdown HTML转Markdown库
- wangEditor 富文本编辑器

## 主要功能

- 项目管理，可以对项目进行编辑更改，成员添加等。
- 文档管理，添加和删除文档等。
- 评论管理，可以管理文档评论和自己发布的评论。
- 用户管理，添加和禁用用户，个人资料更改等。
- 用户权限管理 ， 实现用户角色的变更。
- 项目加密，可以设置项目公开状态，私有项目需要通过Token访问。
- 站点配置，可开启匿名访问、验证码等。

## 项目截图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0909/190321_c8688308_87650.png "1.png")

![输入图片说明](https://git.oschina.net/uploads/images/2017/0909/190328_79701eb8_87650.png "2.png")

