package com.myblog12.myblog12.Service.Impl;

import com.myblog12.myblog12.Service.PostService;
import com.myblog12.myblog12.entity.Post;
import com.myblog12.myblog12.payload.PostDto;
import com.myblog12.myblog12.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post saved = postRepository.save(post);

        PostDto dto=new PostDto();
        dto.setTitle(saved.getTitle());
        dto.setContent(saved.getContent());
        dto.setDescription(saved.getDescription());


        return dto;


    }
}
