pache Shiro™ is a powerful and easy-to-use Java security framework that performs authentication, authorization, cryptography,
 and session management. With Shiro’s easy-to-understand API, 
 you can quickly and easily secure any application – from the smallest mobile applications to the largest web and enterprise applications..


Realm

 

Realms usually have a 1-to-1 correspondance with a datasource such as a relational database, file sysetem, or other similar resource. As such, implementations of this interface use datasource-specific APIs to determine authorization data (roles, permissions, etc), such as JDBC, File IO, Hibernate or JPA, or any other Data Access API. They are essentially security-specific DAOs.

Because most of these datasources usually contain Subject (a.k.a. User) information such as usernames and passwords, a Realm can act as a pluggable authentication module in a PAMconfiguration. This allows a Realm to perform both authentication and authorization duties for a single datasource, which caters to the large majority of applications. If for some reason you don't want your Realm implementation to perform authentication duties, you should override the supports(org.apache.shiro.authc.AuthenticationToken) method to always return false.

Because every application is different, security data such as users and roles can be represented in any number of ways. Shiro tries to maintain a non-intrusive development philosophy whenever possible - it does not require you to implement or extend any User, Group or Role interfaces or classes.

Instead, Shiro allows applications to implement this interface to access environment-specific datasources and data model objects. The implementation can then be plugged in to the application's Shiro configuration. This modular technique abstracts away any environment/modeling details and allows Shiro to be deployed in practically any application environment.

Most users will not implement the Realm interface directly, but will extend one of the subclasses, AuthenticatingRealm or AuthorizingRealm, greatly reducing the effort requird to implement a Realm from scratch.


from shrio apache.org.


http://shiro.apache.org/  apache 

https://github.com/apache/shiro.git  GitHub上的案列



