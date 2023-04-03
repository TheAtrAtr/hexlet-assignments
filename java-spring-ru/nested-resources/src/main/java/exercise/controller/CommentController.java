package exercise.controller;

import exercise.model.Comment;
import exercise.model.Post;
import exercise.repository.CommentRepository;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // BEGIN
    @GetMapping(path = "/{postId}/comments")
    public Iterable<Comment> getPostComments(@PathVariable long postId){
        return commentRepository.findAllByPostId(postId);
    }

    @GetMapping(path = "/{postId}/comments/{commentId}")
    public Comment findByIdAndPostId(@PathVariable Long commentId, @PathVariable Long postId){
        return commentRepository.findByIdAndPostId(commentId, postId).orElseThrow(()-> new ResourceNotFoundException("Comment not found"));
    }

    @PostMapping(path = "/{postId}/comments")
    public Iterable<Comment> createComment(@RequestBody Comment comment, @PathVariable Long postId){
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found"));
        comment.setPost(post);
        commentRepository.save(comment);
        return commentRepository.findAllByPostId(postId);
    }

    @PatchMapping(path = "/{postId}/comments/{commentId}")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable Long postId, @PathVariable Long commentId){
        Comment com = commentRepository.findByIdAndPostId(commentId, postId).orElseThrow(()-> new ResourceNotFoundException("Comment not found"));
        com.setContent(comment.getContent());
        commentRepository.save(com);
        return com;
    }

    @DeleteMapping(path = "/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId, @PathVariable Long postId){
        Comment comment = commentRepository.findByIdAndPostId(commentId, postId).orElseThrow(()-> new ResourceNotFoundException("Comment not found"));
        commentRepository.delete(comment);
    }

    // END
}
