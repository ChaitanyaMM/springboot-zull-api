package com.eyedentify.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyedentify.Entity.Sample;

@Repository
public interface SampleRepo2 extends JpaRepository<Sample, UUID> {

}
