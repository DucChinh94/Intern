package BusDriverManagement.util.file;

import java.util.List;

public interface DataWriteable {
    <T> void writeDataToFile(List<T> data, String fileName);
}
