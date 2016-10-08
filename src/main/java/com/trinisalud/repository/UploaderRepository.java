package com.trinisalud.repository;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.Uploader;

public interface UploaderRepository extends CrudRepository<Uploader, String> { }
