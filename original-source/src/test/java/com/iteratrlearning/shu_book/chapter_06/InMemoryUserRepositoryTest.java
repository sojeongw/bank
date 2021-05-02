package com.iteratrlearning.shu_book.chapter_06;


import chapter_06.UserRepository;
import chapter_06.in_memory.InMemoryUserRepository;

public class InMemoryUserRepositoryTest extends AbstractUserRepositoryTest
{
    private InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

    @Override
    protected UserRepository newRepository()
    {
        return inMemoryUserRepository;
    }
}
