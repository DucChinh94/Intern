package BusDriverManagement.Service;

import BusDriverManagement.entity.Driver;
import BusDriverManagement.entity.Route;
import BusDriverManagement.entity.driving.Assignment;
import BusDriverManagement.entity.driving.DrivingManagement;
import BusDriverManagement.util.file.FileUtil;
import BusDriverManagement.util.DataUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AssigmentService {
    FileUtil fileUtil = new FileUtil();
    public static List<DrivingManagement> drivingManagementList;
    public static final String ASSIGNMENTDATAFILE = "assignment.dat";

    private Driver inputDriverId() {
        System.out.print("Nhập ID của lái xe muốn thêm điểm: ");
        Driver driver;
        do {
            try {
                int driverId = new Scanner(System.in).nextInt();
                driver = DriverService.findDriverById(driverId);
                if (!DataUtil.isNullOrEmpty(driver)) {
                    break;
                }
                System.out.print("ID lãi xe vừa nhập không tồn tại trong hệ thống, xin mời nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("ID lái xe phải là một số nguyên dương, xin mời nhập lại: ");
            }
        } while (true);
        return driver;
    }

    private int inputRouteNumber() {
        System.out.print("Nhập số lượng tuyến lái xe chạy: ");
        int routeNumber = -1;
        do {
            try {
                routeNumber = new Scanner(System.in).nextInt();
                if (routeNumber > 0 && routeNumber <= RouteService.routeList.size()) {
                    break;
                }
                System.out.print("Số lượng tuyến là số nguyên và không vượt qua số tuyến có sẵn, xin mời nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lượng tuyến là một số nguyên, xin mời nhập lại: ");
            }
        } while (true);
        return routeNumber;
    }

    private int findIndexAssignmentExits(int indexDrivingManagementExitsed, int id) {
        for (int i = 0; i < drivingManagementList.get(indexDrivingManagementExitsed).getAssignmentList().size(); i++) {
            if (drivingManagementList.get(indexDrivingManagementExitsed).getAssignmentList().get(i).getRoute().getRouteId() == id)
                return i;
        }
        return -1;
    }

    private int findIndexDrivingManagementExits(int driverId) {
        for (int i = 0; i < drivingManagementList.size(); i++) {
            if (driverId == drivingManagementList.get(i).getDriver().getDriverId())
                return i;
        }
        return -1;
    }

    private Route inputRouteId(int j, Driver driver) {
        System.out.print("Nhập ID tuyến đường thứ " + (j + 1) + "  mà lái xe " + driver.getFullName() + " lái: ");
        Route route;
        do {
            try {
                int routeId = new Scanner(System.in).nextInt();
                route = RouteService.findRouteById(routeId);
                if (!DataUtil.isNullOrEmpty(route)) {
                    break;
                }
                System.out.print("ID vừa nhập không tồn tại trong hệ thống, xin mời nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("ID phải là số nguyên dương, xin mời nhập lại: ");
            }
        } while (true);
        return route;
    }

    private int inputTurnNumber(Route route) {
        System.out.print("Nhập số lượt của tuyến " + route.getRouteId() + " :");
        int turnNumber = -1;
        do {
            try {
                turnNumber = new Scanner(System.in).nextInt();
                if (turnNumber > 0) {
                    break;
                }
                System.out.print("Số lượt là số nguyên dương, xin mời nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lượt là số nguyên dương, không phải là chữ, xin mời nhập lại: ");
            }
        } while (true);
        return turnNumber;
    }

    private void createDrivingManagementList(List<Assignment> assignmentList, int routeNumber, Driver driver) {
        for (int i = 0; i < routeNumber; i++) {
            Route route = inputRouteId(i, driver);
            int turnNumber = inputTurnNumber(route);
            int turnSumCurrent = 0;
            turnSumCurrent = assignmentList.stream().mapToInt(Assignment::getRouteNumber).sum();
            if (turnNumber + turnSumCurrent > 15) {
                System.out.println("Số tuyến vượt 15");
            } else {
                assignmentList.add(new Assignment(route, turnNumber));
            }
        }
    }

    public void creatDrivingManagement() {
        if (checkEmptyDriverOrRoute()) {
            return;
        }
        Driver driver = inputDriverId();

        int lineNumber = inputRouteNumber();
        int indexAgssignmentTableExits = findIndexDrivingManagementExits(driver.getDriverId());

        if (indexAgssignmentTableExits < 0) {

            List<Assignment> assignmentList = new ArrayList<>();
            createDrivingManagementList(assignmentList, lineNumber, driver);
            drivingManagementList.add(new DrivingManagement(driver, assignmentList));
        } else {

            updateOrAddDrivingManagementExits(indexAgssignmentTableExits, lineNumber, driver);
        }
        fileUtil.writeDataToFile(drivingManagementList, ASSIGNMENTDATAFILE);
    }

    private void updateOrAddDrivingManagementExits(int indexDrivingManagementExitsed, int routeNumber, Driver driver) {
        for (int i = 0; i < routeNumber; i++) {
            Route route = inputRouteId(i, driver);
            int turnNumber = inputTurnNumber(route);
            int indexAssignmentExits = findIndexAssignmentExits(indexDrivingManagementExitsed, route.getRouteId());
            int turnSumCurrent = 0;
            turnSumCurrent = drivingManagementList.get(indexDrivingManagementExitsed).getAssignmentList()
                    .stream().mapToInt(Assignment::getRouteNumber).sum();

            if (indexAssignmentExits < 0) {
                if (turnNumber + turnSumCurrent > 15) {
                    System.out.println("Số tuyến vượt 15");
                } else {
                    drivingManagementList.get(indexDrivingManagementExitsed).getAssignmentList()
                            .add(new Assignment(route, turnNumber));
                }
            }

            else {
                turnSumCurrent = turnSumCurrent - drivingManagementList.get(indexDrivingManagementExitsed)
                        .getAssignmentList().get(indexAssignmentExits).getRouteNumber();
                if (turnSumCurrent + turnSumCurrent > 15) {
                    System.out.println("Số tuyến vượt 15");
                } else {
                    drivingManagementList.get(indexDrivingManagementExitsed).getAssignmentList()
                            .set(indexAssignmentExits, new Assignment(route, turnNumber));
                }
            }
        }
    }

    public void showDrivingManagement() {
        for (DrivingManagement drivingManagement : drivingManagementList)
            System.out.println(drivingManagement);
    }

    private static boolean checkEmptyDriverOrRoute() {
        return DriverService.driverList.size() == 0 || RouteService.routeList.size() == 0;
    }


    public void initializeAssignmentManagementData() {
        drivingManagementList = fileUtil.readDataFromFile(ASSIGNMENTDATAFILE);
        if (drivingManagementList == null) {
            drivingManagementList = new ArrayList<>();
        }
    }
}
