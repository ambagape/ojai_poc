package com.test.processor;

import com.ext.dependency.jar.MainJsonRepository;
import java.util.ArrayList;
import java.util.Iterator;
import org.ojai.Document;
import org.ojai.DocumentStream;
import org.ojai.store.QueryCondition;
import org.ojai.types.OTimestamp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class UsersRepository extends MainJsonRepository {

    private static final String TABLE_PATH = "groupData";

    private final String[] fields = {"_id"};

    public UsersRepository(String path, boolean useBufferedWrite) {
        super(path, useBufferedWrite);
    }

    public UsersRepository(String path) {
        super(path);
    }

    public UsersRepository() {
        super(TABLE_PATH);
    }

    public List<String> getRegisteredUsersByDate() {
        final var ids = new ArrayList<String>();
        final var query = this.connection.newQuery()
                .select(fields).build();
        try (final var stream = jsonStore.find(query)) {
            stream.forEach(document -> {
                if (Objects.nonNull(document)) {
                    ids.add(document.getIdString());
                }
            });
        }

        return ids;
    }

    public Iterator<Document> getRegisteredUsers(List<String> users) {
        QueryCondition condition = connection.newCondition().and().in("documentId", users)
                .close()
                .build();

        final var query = this.connection.newQuery()
                .select(new String[]{"documentId"})
                .where(condition).build();
        final var result = jsonStore.find(query);
        return result.iterator();
    }

    public DocumentStream getUsers() {
        QueryCondition queryCondition = connection.newCondition().and()
                .is("username", QueryCondition.Op.EQUAL, new OTimestamp(null))
                .is("year", QueryCondition.Op.EQUAL, new OTimestamp(null))
                .close().build();

        final var query = this.connection.newQuery()
                .select(new String[]{})
                .where(queryCondition).build();
        return jsonStore.find(query);
    }

}
