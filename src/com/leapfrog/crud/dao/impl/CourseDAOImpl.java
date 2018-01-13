/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crud.dao.impl;

import com.leapfrog.crud.dao.CourseDAO;
import com.leapfrog.crud.dbutil.DbConnection;
import com.leapfrog.crud.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public class CourseDAOImpl implements CourseDAO {

    private DbConnection db = new DbConnection();

    @Override
    public int insert(Course course) throws ClassNotFoundException, SQLException {
        String sql = "insert into tbl_courses(name,fees,status) "
                + "values(?,?,?)";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setInt(2, course.getFees());
        stmt.setBoolean(3, course.isStatus());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Course course) throws ClassNotFoundException, SQLException {
        String sql = "update tbl_courses set "
                + "name=?,fees=?,status=? where id=?";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setInt(2, course.getFees());
        stmt.setBoolean(3, course.isStatus());
        stmt.setInt(4, course.getId());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from tbl_courses where id=?";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public Course getById(int id) throws ClassNotFoundException, SQLException {
        Course course = null;
        String sql = "select * from tbl_courses where id=?";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            course = new Course();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("name"));
            course.setFees(rs.getInt("fees"));
            course.setAddedDate(rs.getDate("added_date"));
            course.setStatus(rs.getBoolean("status"));
        }
        db.close();
        return course;
    }

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        List<Course> courseList = new ArrayList<>();
        String sql = "select * from tbl_courses";
        db.connect();
        db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            Course course = new Course();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("name"));
            course.setFees(rs.getInt("fees"));
            course.setAddedDate(rs.getDate("added_date"));
            course.setStatus(rs.getBoolean("status"));
            courseList.add(course);
        }
        db.close();
        return courseList;
    }

}
