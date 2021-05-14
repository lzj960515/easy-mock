# easy-mock
简单的mock工具，类似mock.js使用

## 使用方式

- 引入`easy-mock`依赖

  ```xml
   <dependency>
         <groupId>com.github.lzj960515</groupId>
         <artifactId>easy-mock</artifactId>
         <version>0.0.1</version>
   </dependency>
  ```

- 在类的属性名中增加注解

  ```java
  @Data
  public class User {
  
      @Name
      private String name;
      @Age
      private String age;
      @Chinese
      private String hobby;
      @Gender
      private String gender;
      @Entity
      private Order order;
  
      private List<Order> orderList;
  
  }
  ```

  ```java
  @Data
  public class Order {
  
      @Number
      private String number;
  
      @Price
      private String price;
  }
  ```

- 使用MockUtil进行生成对象

  ```java
  User user = MockUtil.mock(User.class);
  ```

## 支持的注解

- Address
- Age
- Avatar
- Birthday
- Chinese
- Date
- DateTime
- Disease
- Entity
- Gender
- Hospital
- IdNumber
- Medicine
- Name
- Number
- Phone
- Price
- Symptoms
- University