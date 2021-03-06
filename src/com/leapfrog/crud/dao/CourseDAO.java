/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crud.dao;

import com.leapfrog.crud.entity.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface CourseDAO {

    int insert(Course course) throws ClassNotFoundException, SQLException;

    int update(Course course) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;

    Course getById(int id) throws ClassNotFoundException, SQLException;

    List<Course> getAll() throws ClassNotFoundException, SQLException;
}
