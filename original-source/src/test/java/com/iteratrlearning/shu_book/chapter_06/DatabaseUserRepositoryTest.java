package com.iteratrlearning.shu_book.chapter_06;

import chapter_06.UserRepository;
import chapter_06.database.DatabaseUserRepository;

public class DatabaseUserRepositoryTest extends AbstractUserRepositoryTest
{
    @Override
    protected UserRepository newRepository()
    {
        return new DatabaseUserRepository();
    }
}
