package BusDriverManagement.Service;

import BusDriverManagement.entity.driving.DrivingManagement;
import BusDriverManagement.util.file.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class AssigmentService {
    FileUtil fileUtil = new FileUtil();
    public static List<DrivingManagement> drivingManagementList;
    public static final String ASSIGNMENTDATAFILE = "assignment.dat";


    public void initializeAssignmentManagementData() {
        drivingManagementList = fileUtil.readDataFromFile(ASSIGNMENTDATAFILE);
        if (drivingManagementList == null) {
            drivingManagementList = new ArrayList<>();
        }
    }
}
