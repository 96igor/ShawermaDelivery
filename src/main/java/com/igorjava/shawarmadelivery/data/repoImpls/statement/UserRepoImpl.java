package com.igorjava.shawarmadelivery.data.repoImpls.statement;

import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository("URwS")
public class UserRepoImpl implements UserRepo {

    private final Connection connection;

    public UserRepoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public IUser saveUser(IUser user) {

        try (Statement statement = connection.createStatement()){
            String sql="INSERT INTO users(name, email, password, telegram, phone, address) VALUES(" +
            "'"+user.getName()+"','"+user.getEmail()+"','"+ user.getPassword()+"','"+
                    user.getTelegram()+"','"+user.getPhone()+"','"+user.getAddress()+"'" +
                    ");";
            statement.executeUpdate(sql);
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUser(IUser user) {
        try (Statement statement = connection.createStatement()){
            String sql = "DELETE FROM users WHERE id="+user.getId();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IUser getUserByEmail(String email) {
        try (Statement statement = connection.createStatement()){
            String sql = "SELECT * FROM users WHERE email ='"+email+"';";
            ResultSet rs = statement.executeQuery(sql);
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setTelegram(rs.getString("telegram"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public IUser updateUser(IUser user) {
        try (Statement statement = connection.createStatement()) {
            String sql = "UPDATE users SET name ='"+user.getName() +"','"+
                   "email='"+user.getEmail()+"','password='"+user.getPassword()+"','"+
                   "telegram='"+user.getTelegram()+"','phone"+user.getPhone()+"','ddress='"+user.getAddress()+"'"+
                   " WHERE id="+user.getId()+";";
            statement.executeUpdate(sql);
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
