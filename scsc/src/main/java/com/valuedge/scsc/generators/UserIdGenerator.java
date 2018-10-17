package com.valuedge.scsc.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object)throws HibernateException {

    String prefix = "TRV";
    Connection connection = session.connection();

    try {
        Statement statement=connection.createStatement();

        ResultSet rs=statement.executeQuery("select count(user_id) as Id from user_details");

        if(rs.next())
        {
            int id=rs.getInt(1)+1;
            String generatedId = prefix + new Integer(id).toString();
            return generatedId;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

}