package BusDriverManagement.Service;

import BusDriverManagement.entity.Route;
import BusDriverManagement.util.file.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RouteService {
    FileUtil fileUtil = new FileUtil();
    public static List<Route> routeList;
    private static String ROUTEDATAFILE = "route.dat";

    public void addRoute(){
        System.out.println("Nhập vào số chuyến mới:");
        int routeNumber = -1;
        do {
            try {
                routeNumber = new Scanner(System.in).nextInt();
                if (routeNumber > 0) {
                    break;
                }
                System.out.println("Phải nhập số nguyên dương, xin mời nhập lại!");
            } catch (InputMismatchException e){
                System.out.println("Phải nhập số nguyên dương, xin mời nhập lại!");
            }
        } while (true);
        for (int i=0;i<routeNumber;i++){
            Route route = new Route();
            route.inputRoute();
            routeList.add(route);
        }
        fileUtil.writeDataToFile(routeList, "route.dat");
    }

    public void showRoute(){
        for (Route route : routeList) {
            System.out.println(route);
        }
    }

    public void initializeLineData() {
        List<Route> routeList = fileUtil.readDataFromFile(ROUTEDATAFILE);
        if (routeList != null) {
            Route.autoId = routeList.get(routeList.size() - 1).getRouteId() + 1;
            this.routeList = routeList;
        } else {
            this.routeList = new ArrayList<>();
        }
    }
}
