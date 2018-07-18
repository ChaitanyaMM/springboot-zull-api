package com.eyedentify.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.eyedentify.Entity.Sample;

@Repository
public interface SampleRepo2 extends CassandraRepository<Sample,UUID> {

	
	/*@Query("select * from sample where id=?")
	Optional<Sample> findById(UUID  c_id);*/


}
