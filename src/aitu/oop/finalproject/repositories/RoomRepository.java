package aitu.oop.finalproject.repositories;

import aitu.oop.finalproject.ConsoleTable;
import aitu.oop.finalproject.data.ConnectionManager;
import aitu.oop.finalproject.data.PreparedStatementManager;
import aitu.oop.finalproject.entities.Room;
import aitu.oop.finalproject.repositories.interfaces.IRoomRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class RoomRepository implements IRoomRepository {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void getRooms() {
        Connection con = null;
        ResultSet res = null;
        Statement stmt = null;
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            String sql = PreparedStatementManager.getRooms();
            res = stmt.executeQuery(sql);
            ConsoleTable table = new ConsoleTable();
            table.setShowVerticalLines(true);
            table.setHeaders("roomID", "room number", "room type", "number of beds", "customer");
            while (res.next()){
                String room_id = String.valueOf(res.getInt("room_id"));
                String room_number = String.valueOf(res.getInt("room_number"));
                String room_type = res.getString("room_type");
                String number_of_beds = String.valueOf(res.getInt("number_of_beds"));
                String customer_id = String.valueOf(res.getInt("customer_id"));
                table.addRow(room_id, room_number, room_type, number_of_beds, customer_id);
            }
            table.print();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                res.close();
                stmt.close();
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void getRooms(int room_id) {
        Connection con = null;
        ResultSet res = null;
        Statement stmt = null;

        con = ConnectionManager.getConnection();
        try{
            stmt = con.createStatement();
            String sql = PreparedStatementManager.getRooms(room_id);
            res = stmt.executeQuery(sql);
            ConsoleTable table = new ConsoleTable();
            table.setShowVerticalLines(true);
            table.setHeaders("roomID", "room number", "room type", "number of beds", "customer");
            while (res.next()){
                String room_number = String.valueOf(res.getInt("room_number"));
                String room_type = res.getString("room_type");
                String number_of_beds = String.valueOf(res.getInt("number_of_beds"));
                String customer_id = String.valueOf(res.getInt("customer_id"));
                table.addRow(String.valueOf(room_id), room_number, room_type, number_of_beds, customer_id);
            }
            table.print();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                res.close();
                stmt.close();
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public boolean createRoom(int room_number, String room_type, int number_of_beds) {
        Integer customer_id = null;

        Connection con = null;
        Boolean res = null;
        Statement stmt = null;

        con = ConnectionManager.getConnection();
        try{
            stmt = con.createStatement();
            String sql = PreparedStatementManager.createRoom(room_number, room_type, number_of_beds);
            res = stmt.execute(sql);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean createRoom(int room_number, String room_type, int number_of_beds, int customer_id) {
        Connection con = null;
        Boolean res = null;
        Statement stmt = null;

        con = ConnectionManager.getConnection();
        try{
            stmt = con.createStatement();
            String sql = PreparedStatementManager.createRoom(room_number, room_type, number_of_beds, customer_id);
            res = stmt.execute(sql);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateRoom(int room_id, int room_number, String room_type, int number_of_beds) {
        Connection con = null;
        Boolean res = null;
        Statement stmt = null;

        con = ConnectionManager.getConnection();
        try{
            stmt = con.createStatement();
            String sql = PreparedStatementManager.updateRoom(room_id, room_number, room_type, number_of_beds);
            res = stmt.execute(sql);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateRoom(int room_id, int room_number, String room_type, int number_of_beds, int customer_id) {
        Connection con = null;
        Boolean res = null;
        Statement stmt = null;

        con = ConnectionManager.getConnection();
        try{
            stmt = con.createStatement();
            String sql = PreparedStatementManager.updateRoom(room_id, room_number, room_type, number_of_beds, customer_id);
            res = stmt.execute(sql);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteRoom(int room_id) {
        Connection con = null;
        Boolean res = null;
        Statement stmt = null;

        con = ConnectionManager.getConnection();
        try{
            stmt = con.createStatement();
            String sql = PreparedStatementManager.deleteRoom(room_id);
            res = stmt.execute(sql);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
