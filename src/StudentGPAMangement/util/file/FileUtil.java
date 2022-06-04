package StudentGPAMangement.util.file;

import StudentGPAMangement.util.DataUtil;
import StudentGPAMangement.util.StringUtil;
import java.io.*;

public class FileUtil implements DataReadable, DataWritable {
    @Override
    public Object[] readDataFromFile(String fileName) {
        if (StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Object[]) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeDataToFile(Object[] objects, String fileName) {
        if (StringUtil.isNullOrEmpty(fileName) || DataUtil.isNullOrEmpty(objects)) {
            return;
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
