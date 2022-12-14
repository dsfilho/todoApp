package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        String sql = "INSERT INTO tasks ("
                + "idProject, "
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES(?,?,?,?,?,?,?,?)";
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
        } catch (SQLException ex) {
            System.out.println("Sql: "+sql);
            throw new RunTimeException("Erro ao salvar a tarefa"
                    , ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET "
                + "idProject=?,"
                + "name=?,"
                + "description=?,"
                + "notes=?,"
                + "completed=?,"
                + "deadline=?,"
                + "createdAt=?,"
                + "updatedAt=? "
                + "WHERE id=?";

        Connection connection = null;
        PreparedStatement statment = null;

        try {
            connection = ConnectionFactory.getConnection();
            statment = connection.prepareStatement(sql);
            statment.setInt(1, task.getIdProject());
            statment.setString(2, task.getName());
            statment.setString(3, task.getDescription());
            statment.setString(4, task.getNotes());
            statment.setBoolean(5, task.isIsCompleted());
            statment.setDate(6, new Date(task.getCreatedAt().getTime()));
            statment.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statment.setDate(8, new Date(task.getDeadline().getTime()));
            statment.setInt(9, task.getId());
            statment.execute();

        } catch (Exception e) {
            System.out.println("Sql: "+sql);             
            throw new RuntimeException("Erro ao atualizar a tarefa", e);
        }

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

            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public List<Task> getAll(int idProject) throws SQLException, RunTimeException {
        String sql = "SELECT * FROM tasks WHERE idProject =?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<Task>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }

        } catch (Exception e) {
           
               throw new RuntimeException("Erro ao listar as tarefas", e);

        }finally{
            ConnectionFactory.closeConnection(connection, statement,resultSet);
        }

        return tasks;

    }

}
