package com.eyedentify.Repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.eyedentify.Entity.Sample;

@Repository
public interface SampleRepo2 extends CassandraRepository<Sample,UUID> {

}
