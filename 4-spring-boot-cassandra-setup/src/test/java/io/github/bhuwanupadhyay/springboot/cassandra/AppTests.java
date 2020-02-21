package io.github.bhuwanupadhyay.springboot.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.CassandraFactory;
import com.github.nosan.embedded.cassandra.Settings;
import com.github.nosan.embedded.cassandra.local.LocalCassandraFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

    private static Cassandra cassandra;

    @Autowired
    private PersonRepository repository;

    @BeforeClass
    public static void infra() {
        CassandraFactory cassandraFactory = new LocalCassandraFactory();
        cassandra = cassandraFactory.create();

        cassandra.start();

        Settings settings = cassandra.getSettings();

        Cluster cluster = Cluster.builder()
                .withoutJMXReporting()
                .addContactPoint(settings.getAddress().getHostAddress())
                .withPort(settings.getPort())
                .build();

        Session connect = cluster.connect();

        connect.execute("CREATE KEYSPACE demo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };");

        /*
            If you don't want to use cassandra specific annotation then you must need to create
            a table using cql. Otherwise no need to create you, just you can create them by using
            spring.data.cassandra.schema-action=create_if_not_exists
         */

//        In case if you don't want to use annotations.
//        connect.execute("USE demo;");
//        connect.execute("CREATE TABLE person ( personId TEXT PRIMARY KEY, name TEXT);");

    }

    @AfterClass
    public static void tearDown() {
        cassandra.stop();
    }

    @Test
    public void repositoryTest() {
        Person person = new Person();
        String personId = UUID.randomUUID().toString();
        person.setPersonId(personId);
        person.setName("Bhuwan");
        repository.save(person);

        // find by id
        Optional<Person> personOptional = repository.findById(personId);
        assertTrue(personOptional.isPresent());
        assertEquals("Bhuwan", personOptional.get().getName());

    }
}
