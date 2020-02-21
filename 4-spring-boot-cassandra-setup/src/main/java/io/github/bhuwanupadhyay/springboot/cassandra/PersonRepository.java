package io.github.bhuwanupadhyay.springboot.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PersonRepository extends CassandraRepository<Person, String> {
}
