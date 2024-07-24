package jpa_study.com.mycom.myapp.config;

import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
// META-INF/persistence.xml 대체
public class MyPersistenceUnitInfo implements PersistenceUnitInfo{
    @Override
    public String getPersistenceUnitName() {
        return "my-pu";
    }
    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }
    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }
    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jpa_basic");
        dataSource.setUsername("root");
        dataSource.setPassword("Ace0828yc@");
        return dataSource;
    }
    @Override
    public DataSource getNonJtaDataSource() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<String> getMappingFileNames() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<URL> getJarFileUrls() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public URL getPersistenceUnitRootUrl() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<String> getManagedClassNames() {
        return List.of("jpa_study.com.mycom.myapp.entity.Product");
    }
    @Override
    public boolean excludeUnlistedClasses() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public SharedCacheMode getSharedCacheMode() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public ValidationMode getValidationMode() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Properties getProperties() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getPersistenceXMLSchemaVersion() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public ClassLoader getClassLoader() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void addTransformer(ClassTransformer transformer) {
        // TODO Auto-generated method stub

    }
    @Override
    public ClassLoader getNewTempClassLoader() {
        // TODO Auto-generated method stub
        return null;
    }
}
