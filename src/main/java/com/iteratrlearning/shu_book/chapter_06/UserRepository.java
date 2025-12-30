package com.iteratrlearning.shu_book.chapter_06;

import java.util.Optional;

// tag::UserRepository[]
public interface UserRepository extends AutoCloseable {
    boolean add(User user);
    Optional<User> get(String userId);
    void update(User user);
    FollowStatus follow(User follower, User userToFollow);
    void clear();

    @Override
    void close() throws Exception;
}
// end::UserRepository[]
