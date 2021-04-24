package chapter_05;

@FunctionalInterface
interface Action{
    void execute(Facts facts);
}
