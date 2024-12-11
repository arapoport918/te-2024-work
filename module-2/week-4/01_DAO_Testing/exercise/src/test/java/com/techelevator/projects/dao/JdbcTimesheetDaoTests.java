package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;
    private Timesheet test;

    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
        test = new Timesheet(0, 1, 1, LocalDate.of(2024,1,1), 5.0, false, "Test Timesheet");
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet timesheet1 = dao.getTimesheetById(1);
        assertTimesheetsMatch(TIMESHEET_1, timesheet1);

        Timesheet timesheet2 = dao.getTimesheetById(2);
        assertTimesheetsMatch(TIMESHEET_2, timesheet2);

        Timesheet timesheet3 = dao.getTimesheetById(3);
        assertTimesheetsMatch(TIMESHEET_3, timesheet3);

        Timesheet timesheet4 = dao.getTimesheetById(4);
        assertTimesheetsMatch(TIMESHEET_4, timesheet4);

    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Timesheet noExist = dao.getTimesheetById(-1);
        Assert.assertNull(noExist);
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));

        timesheets = dao.getTimesheetsByEmployeeId(2);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(1));

    }

    @Test
    public void getTimesheetsByProjectId_with_valid_id_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(3, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));


        timesheets = dao.getTimesheetsByProjectId(2);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(1, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(0));

    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet createdTimesheet = dao.createTimesheet(test);
        Assert.assertNotNull(createdTimesheet);

        int newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue(newId > 0);

        Timesheet retrievedTimesheet = dao.getTimesheetById(newId);
        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet updatedTimesheet = dao.getTimesheetById(1);

        updatedTimesheet.setEmployeeId(1);
        updatedTimesheet.setProjectId(1);
        updatedTimesheet.setDateWorked(LocalDate.parse("2024-01-01"));
        updatedTimesheet.setHoursWorked(20.0);
        updatedTimesheet.setBillable(false);
        updatedTimesheet.setDescription("Updated Timesheet");

        Timesheet editedTimesheet = dao.updateTimesheet(updatedTimesheet);
        Assert.assertNotNull(editedTimesheet);

        Timesheet getTimesheet = dao.getTimesheetById(1);
        assertTimesheetsMatch(editedTimesheet, getTimesheet);
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        int rows = dao.deleteTimesheetById(4);

        Assert.assertEquals(1, rows);

        Timesheet test = dao.getTimesheetById(4);
        Assert.assertNull(test);

    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double sut = dao.getBillableHours(1, 1);
        Assert.assertEquals(2.5, sut, 0.001);

        sut = dao.getBillableHours(2, 1);
        Assert.assertEquals(0.25, sut, 0.001);

        sut = dao.getBillableHours(2, 2);
        Assert.assertEquals(0, sut, 0);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
