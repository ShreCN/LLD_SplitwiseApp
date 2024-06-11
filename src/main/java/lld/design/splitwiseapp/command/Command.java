package lld.design.splitwiseapp.command;

public interface Command {
    public boolean matches(String inputCommand);
    public void execute(String executeCommand);
}
