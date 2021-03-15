package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
    List<Post> findByTitleContainingIgnoreCase(String searchWords);
}
