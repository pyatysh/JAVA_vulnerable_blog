package com.javaAPI.blog_V3.service;

import com.javaAPI.blog_V3.models.Post;
import com.javaAPI.blog_V3.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post blogPostSave(Post post){
        return postRepository.save(post);
    }

    public Optional<Post> blogPostFind(long id){
        return postRepository.findById(id);
    }
//    public Optional<Post> blogPostFind(long id){
//        return postRepository.unsafePostSearch(id);
//    }

    public void blogPostDelete(Post post) {
        postRepository.delete(post);
    }

    public Iterable<Post> postsSearch(String searchWords){
         return postRepository.findByTitleContainingIgnoreCase(searchWords);
//        return postRepository.unsafePostSearch(searchWords);
    }


}
