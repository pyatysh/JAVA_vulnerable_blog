package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, String> {
}
