package com.ext.dependency.jar;

import com.test.processor.UsersRepository;
import org.ojai.Document;
import org.ojai.DocumentStream;
import org.ojai.store.*;

import java.util.List;
import java.util.Map;

// This Java file is located in external jar file
public class MainJsonRepository {

    protected final Connection connection;
    protected final DocumentStore jsonStore;
    private final String tablePath;

    protected MainJsonRepository(String tablePath) {
        this.connection = DriverManager.getConnection("ojai:mapr:");
        this.jsonStore = this.connection.getStore("/demo_table");
        this.tablePath = tablePath;
    }

    public Document createDocument() {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    public DocumentStream getAllDocumentsAsStream() {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    public List<Document> getAllDocumentsAsStream(List<String> personIds) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    protected Document createDocument(String payload) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    public Document createDocument(Object object) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    public MainJsonRepository(String path, boolean useBufferedWrite) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    protected List<Document> getAllDocuments(String documentId) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    public List<Document> getAllDocuments(List<String> documentIds) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    protected List<Document> getAllDocuments(Map<String, Object> values) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    protected List<Document> query(QueryCondition queryCondition) {
        throw new UnsupportedOperationException("Not implemented yet !!!!!!!!!!!!!");
    }

    public static class MainJsonRepositoryFactory {

        public static MainJsonRepository createMainJsonRepository(String path) {
            return new MainJsonRepository(path);
        }

        public static UsersRepository createUsersRepository(String path, boolean useBufferedWrite) {
            return new UsersRepository(path, useBufferedWrite);
        }
        
        public static UsersRepository createUsersRepository(String path) {
            return new UsersRepository(path);
        }

        public static UsersRepository createDefaultUsersRepository() {
            return new UsersRepository();
        }
    }
}
