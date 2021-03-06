#Spring IoC专题
[Spring 官网](https://spring.io/projects/spring-framework)  
[Spring Github源码地址](https://github.com/spring-projects/spring-framework.git)
## 什么是IoC?
>IoC也称为依赖注入(dependency injection DI)。它是一个对象定义依赖关系的过程,即对象只通过构造函数参数、  
工厂方法的参数或对象参数实例构造或从工厂方法返回后在对象实例上设置的属性来定义它们所使用的其他对象。  
然后容器在创建bean时注入这些依赖项。这个过程本质上是bean本身的逆过程，因此称为控制反转(IoC),通过直接  
构造来控制其依赖项的实例化。

## 什么是bean?
>在Spring中,构成应用程序主干并由Spring IoC容器管理的对象称为bean。bean是由Spring IoC实例化、组装和管理的对象。

## 1. 为什么我们使用Spring?
>   1. 从spring ioc角度回答：统一负责对象的创建，管理生命周期，自动维护对象依赖关系（也就是依赖注入DI）。  
    依赖查找： byType byName  
    依赖注入：a.构造器传参 b.方法传参 c.属性 反射 field.set(x)  
    spring使用：  
    bean交给spring管理。  
    2. 从spring aop角度回答见下方： 什么是Spring AOP？


## 2. BeanFactory和FactoryBean有什么区别?
> BeanFactory指的是IOC容器的编程抽象，比如 ApplicationContext，XmlBeanFactory 等，  
这些都是 IOC 容器的具体表现，需要使用什么样的容器由客户决定,但 Spring 为我们提供了丰富的选择。  
FactoryBean 只是一个可以在 IOC 而容器中被管理的一个 Bean,是对各种处理过程和资源使用的抽象,FactoryBean  
在需要时产生另一个对象，而不返回 FactoryBean 本身,我们可以把它看成是一个抽象工厂，对它的调用返回的是  
工厂生产的产品。所有的 FactoryBean 都实现特殊的 org.springframework.beans.factory.FactoryBean 接口，当使用  
容器中 FactoryBean 的时候，该容器不会返回 FactoryBean 本身,而是返回其生成的对象。Spring 包括了大部分的  
通用资源和服务访问抽象的 FactoryBean 的实现，其中包括:对 JNDI 查询的处理，对代理对象的处理，对事务性  
代理的处理，对 RMI 代理的处理等，这些我们都可以看成是具体的工厂,看成是 Spring 为我们建立好的工厂。  
也就是说Spring通过使用抽象工厂模式为我们准备了一系列工厂来生产一些特定的对象,免除我们手工重复的工作，  
我们要使用时只需要在 IOC 容器里配置好就能很方便的使用了。
>
>在 Spring 中，有两个很容易混淆的类：BeanFactory 和 FactoryBean。 
 BeanFactory：Bean 工厂，是一个工厂(Factory)，我们 SpringIOC 容器的最顶层接口就是这个 BeanFactory，
 它的作用是管理 Bean，即实例化、定位、配置应用程序中的对象及建立这些对象间的依赖。  
 FactoryBean：工厂 Bean，是一个 Bean，作用是产生其他 bean 实例。通常情况下，这种 bean 没有什么特别的要  
 求，仅需要提供一个工厂方法，该方法用来返回其他 bean 实例。通常情况下，bean 无须自己实现工厂模式，Spring  
 容器担任工厂角色；但少数情况下，容器中的 bean 本身就是工厂，其作用是产生其它 bean 实例。  
 当用户使用容器本身时，可以使用转义字符”&”来得到 FactoryBean 本身，以区别通过 FactoryBean 产生的实例  
 对象和 FactoryBean 对象本身。在 BeanFactory 中通过如下代码定义了该转义字符：  
 StringFACTORY_BEAN_PREFIX="&";  
 如果 myJndiObject 是一个 FactoryBean，则使用&myJndiObject 得到的是 myJndiObject 对象，而不是 myJndiObject  
 产生出来的对象。

## 3. Spring提供了几种方式管理bean的生命周期? 有什么区别?


