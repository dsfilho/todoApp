package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;
import util.RunTimeException;

/**
 *
 * @author daniel
 */
public class TaskController {

    public void save(Task task) throws SQLException, RunTimeException {

        String sql = "INSERT INTO TASK("
                + "idProject, "
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt VALUES(?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RunTimeException ("Erro ao salvar a tarefa"
            +ex.getMessage(),ex);
        }finally{
        
        ConnectionFactory.closeConnection(connection,statement);
        
    }

    }

    public void update(Task task) {

    }

    public void removeById(int taskId) throws SQLException, RunTimeException {

        String sql = "DELETE FROM tasks WHERE id=?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();

        } catch (Exception e) {

            throw new RuntimeException("Erro ao deletar a tarefa", e);

        } finally {

            ConnectionFactory.closeConnection(connection,statement);
        }

    }

    public List<Task> getAll(int idProject) {

        return null;

    }

}
