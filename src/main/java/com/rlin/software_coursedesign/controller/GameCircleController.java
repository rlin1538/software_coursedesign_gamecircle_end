package com.rlin.software_coursedesign.controller;

import com.rlin.software_coursedesign.pojo.*;
import com.rlin.software_coursedesign.result.Result;
import com.rlin.software_coursedesign.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
public class GameCircleController {
    @Autowired
    GameCircleService gameCircleService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    CollectionService collectionService;
    @Autowired
    UserService userService;

    //列出所有游戏圈
    @GetMapping("/api/gamecircle")
    public List<GameCircle> listCircle() throws Exception {
        return gameCircleService.list();
    }

    //查询游戏圈
    @GetMapping("/api/gamecircle/{name}")
    public List<GameCircle> listCircle(@PathVariable("name") String gameName) throws Exception {
        if (null != gameName)
            return gameCircleService.get(gameName);
        else
            return listCircle();
    }

    //添加游戏圈
    @CrossOrigin
    @PostMapping(value = "/api/gamecircle/add")
    @ResponseBody
    public Result addGameCircle(@RequestBody GameCircle gameCircle) throws Exception {
        gameCircleService.add(gameCircle);
        return new Result(200);
    }

    //删除游戏圈
    @CrossOrigin
    @PostMapping(value = "/api/gamecircle/delete")
    @ResponseBody
    public Result deleteGameCircle(@RequestBody GameCircle gameCircle) throws Exception {
        gameCircleService.delete(gameCircle);
        return new Result(200);
    }

    //返回游戏圈帖子
    @GetMapping("/api/gamecircle/{id}/post")
    public List<Post> listPost(@PathVariable("id") int id) throws Exception {
        if (0 != id) {
            List<Post> r = postService.listByCircle(id);
            r.sort(Comparator.comparing(Post::getPostTime, (t1,t2) -> t2.compareTo(t1)));
            return r;
        } else {
            return null;
        }
    }
    //返回用户游戏圈帖子
    @GetMapping("/api/user/{name}/post")
    public List<Post> listPost(@PathVariable("name") String name) throws Exception {
        if ("" != name) {
            List<Post> r = postService.listByUser(name);
            r.sort(Comparator.comparing(Post::getPostTime, (t1,t2) -> t2.compareTo(t1)));
            return r;
        } else {
            return null;
        }
    }

    //添加帖子
    @CrossOrigin
    @PostMapping(value = "/api/post/add")
    @ResponseBody
    public Result addPost(@RequestBody Post post) throws Exception {
        Date date = new Date();
        post.setPostTime(date);
        postService.add(post);
        return new Result(200);
    }
    //删除帖子
    @CrossOrigin
    @PostMapping(value = "/api/post/delete")
    @ResponseBody
    public Result deletePost(@RequestBody Post post) throws Exception {
        postService.delete(post);
        return new Result(200);
    }

    //添加评论
    @CrossOrigin
    @PostMapping(value = "/api/comment/add")
    @ResponseBody
    public Result addComment(@RequestBody Comment comment) throws Exception {
        Date date = new Date();
        comment.setPublishTime(date);
        commentService.add(comment);
        return new Result(200);
    }

    //删除评论
    @CrossOrigin
    @PostMapping(value = "/api/comment/delete")
    @ResponseBody
    public Result deleteComment(@RequestBody Comment comment) throws Exception {
        commentService.delete(comment);
        return new Result(200);
    }


    //返回评论
    @GetMapping("/api/post/{id}/comment")
    public List<Comment> listComment(@PathVariable("id") int id) throws Exception {
        if (0 != id) {
            return commentService.listByPostID(id);
        } else {
            return null;
        }
    }

    //返回用户评论
    @GetMapping("/api/user/{name}/comment")
    public List<Comment> listComment(@PathVariable("name") String name) throws Exception {
        if ("" != name) {
            return commentService.listByUserName(name);
        } else {
            return null;
        }
    }

    //查询已收藏游戏圈
    @GetMapping("/api/user/{id}/collection")
    public List<Collection> listCollection(@PathVariable("id") int id) throws Exception {
        if (0 != id) {
            return collectionService.listByUserID(id);
        } else {
            return null;
        }
    }

    //检查是否加入游戏圈
    @CrossOrigin
    @PostMapping("/api/user/collection/check")
    public Result checkGameInCollection(@RequestBody Collection collection) throws Exception {
        if (collectionService.get(collection) != null)
            return new Result(200);
        else
            return new Result(400);
    }

    //添加游戏圈到收藏
    @CrossOrigin
    @PostMapping(value = "/api/user/collection/add")
    @ResponseBody
    public Result addCollection(@RequestBody Collection collection) throws Exception {
        if (collectionService.get(collection) == null){
            collectionService.add(collection);
            return new Result(200);
        }
        return new Result(400);
    }

    //删除游戏圈收藏
    @CrossOrigin
    @PostMapping(value = "/api/user/collection/delete")
    @ResponseBody
    public Result deleteCollection(@RequestBody Collection collection) throws Exception {
        if (collectionService.get(collection) != null){
            Collection c = collectionService.get(collection);
            collectionService.delete(c);
            return new Result(200);
        }
        return new Result(400);
    }

    //查询用户
    @GetMapping("/api/user/{name}")
    public User listCollection(@PathVariable("name") String name) throws Exception {
        if (null != name) {
            return userService.getByName(name);
        } else {
            return null;
        }
    }
}
