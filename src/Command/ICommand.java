package Command;

public interface ICommand {
    void execute() throws Exception;
    void undo() throws Exception;
}
