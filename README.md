# WebApp JEE using java 21
## Steps to reproduce

### This is an application for manage products simple CRUD, build with java21, jpa, jsf

### Steps to reproduce

1. Clone repository `https://github.com/luisca060606/jsf-webapp.git`
2. Install java21 and download server wildfly 38
3. From the root of your project execute 'mvn clean install'
4. Expose a desserts database locally or with Docker
5. Add datasource in Wildfly manager `Config -> Subsystem -> Datasource and drivers -> add` "If you don't have the PostgreSQL JDBC driver, download it from the Maven repository."
6. In persistence.xml change JNDI Name with your instance
`<persistence-unit name="CRUD_P" transaction-type="JTA">
    <jta-data-source>JNDI Name</jta-data-source>...`
7. Deploy artifact created in step 3, using wildfly manager.
8. View result in `http://localhost:8080/webApp-1.0-SNAPSHOT/`

### Contact luis.ca0804@gmail.com
