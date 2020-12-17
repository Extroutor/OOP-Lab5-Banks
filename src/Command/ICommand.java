package Command;

public interface ICommand {
    void Execute() throws Exception;
    void Undo() throws Exception;
}
