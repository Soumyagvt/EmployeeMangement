package com.ems.service;

import com.ems.dao.AttendanceDAO;
import com.ems.model.Attendance;
import java.util.List;

public class AttendanceService {
    private AttendanceDAO dao = new AttendanceDAO();

    public void addAttendance(Attendance att) throws Exception {
        if (att.getEmployeeId() <= 0) throw new Exception("Valid employee ID required");
        dao.addAttendance(att);
    }

    public List<Attendance> getAttendanceByEmployee(int empId) { return dao.getAttendanceByEmployee(empId); }
}