package BusDriverManagement.Service;

import BusDriverManagement.entity.Driver;
import BusDriverManagement.util.file.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    FileUtil fileUtil = new FileUtil();
    public static List<Driver> driverList;
    public static final String DRIVERDATAFILE ="driver.dat";

    public void addDriver(){
        System.out.println("Nhập số lái xe mới:");
        int driverNumber = -1;
        do {
            try {
                driverNumber = new Scanner(System.in).nextInt();
                if (driverNumber > 0) {
                    break;
                }
                System.out.println("Phải nhập số nguyên dương, xin mời nhập lại!");
            } catch (InputMismatchException e){
                System.out.println("Phải nhập số nguyên dương, xin mời nhập lại!");
            }
        } while (true);
        for (int i=0; i<driverNumber;i++){
            Driver driver = new Driver();
            driver.inputInfo();
            driverList.add(driver);
        }
        fileUtil.writeDataToFile(driverList, "driver.dat");
    }

    public void showDriver(){
        for (Driver driver : driverList) {
            System.out.println(driver);
        }
    }

    public void initializeDriverData() {
        List<Driver> driverList = fileUtil.readDataFromFile(DriverService.DRIVERDATAFILE);
        if (driverList != null) {
            Driver.autoId = driverList.get(driverList.size() - 1).getDriverId() + 1;
            this.driverList = driverList;
        } else {
            this.driverList = new ArrayList<>();
        }

    }
}
