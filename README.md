## my_ofo 毕业设计

### 项目使用技术

- 使用框架：springMVC+Spring+Mybatis


### 使用的技术
- springMVC+Spring+mybatis


### 存在的问题

========

- 前端与后端的交互方式没有规定好，目前使用的交互方式以下几种，导致controller的返回数据格式不同意，访问方式也不统一，使得开发效率变低
1. 一种是直接通过访问controller层来提交表单或者通过通过controller跳转到指定jsp
2. 一种是通过js实现post方式提交，返回json数据  

解决方法：根据公司的方法是后台只产生数据，为json数据。前端通过get方式访问后台api，获取json数据，在前台展示。这种方法使得前端后端耦合性更加小，开发效率大大提高。（但是这种方法数据安全是一个问题）


- 前端框架不熟练，导致项目前端开缓慢。目前前端项目使用的是bootstrap框架。解决方法是使用nodejs+react+antDesign的前端框架，美化前端和加快前端开发效率


- 后台service，dao，controller层（以后需要修改成API接收层）职责不明确，目前数据验证涉及controller和service层。  
修改方法：数据验证可以放在controller层之前，在前端使用前端验证框架验证一遍，再在controller层之前验证参数。controller层只负责参数的接收和使用哪个service层处理。service只负责业务逻辑。dao层只与数据交互，不进行任何业务逻辑。

- dao层使用了mybatis框架，orm使用不够彻底，需要自己写sql，但是项目大部分的sql语句差不多可以重用，可以使用java代码实现重用。

