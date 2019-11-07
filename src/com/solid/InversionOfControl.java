package com.solid;

/**
 * @author Swarn Singh.
 */

/**
 * Example of Dependency Injection and Inversion of Control
 */
public class InversionOfControl {

    public static void main(String[] args) {
        InversionOfControl ioc = new InversionOfControl();
        User user = ioc.new User(ioc.new OracleDatabase());
        user.add("This is some data");
    }

    /**
     * Business Layer Logic
     */

    public class User {
        Database database;

        public User(Database database) {
            this.database = database;
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    public interface Database {
        void persist(String data);
    }

    /**
     * DAO Layer
     */

    public class MySqlDatabase implements Database {

        @Override
        public void persist(String data) {
            System.out.println("MySql has persisted: " + data);
        }
    }

    public class OracleDatabase implements Database {

        @Override
        public void persist(String data) {
            System.out.println("Oracle has persisted: " + data);
        }
    }

}
