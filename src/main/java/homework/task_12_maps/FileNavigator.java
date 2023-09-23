package homework.task_12_maps;

import java.util.*;

public class FileNavigator {

    private final Map<String, List<FileData>> filesList = new HashMap<>();

    public Map<String, List<FileData>> getFilesList() {
        return filesList;
    }

    //1 - add
    public void add(String path, FileData file) throws WrongPathException {
        if (filesList.containsKey(path)) {
            filesList.get(path).add(file);
        } else {
            var files = new ArrayList<FileData>();
            files.add(file);
            filesList.put(path, files);
        } // 6
        if (!consistencyCheck(path, file))  {
            throw new WrongPathException(path);
        }
    }

    //2 - find
    public List<FileData> find(String path) {
        return filesList.getOrDefault(path, List.of()); // to avoid returning null
    }

    //3 - filterBySize
    public List<FileData> filterBySize(Integer size) {
        List<FileData> filteredData = new ArrayList<>();
        //iteration over Lists
        for (List<FileData> filesList : filesList.values()) {
            //iteration over List's objects
            for (FileData fileData : filesList) {
                if (fileData.getSize() <= size) {
                    filteredData.add(fileData);
                }
            }
        }
        return filteredData;
    }

    //4 - remove
    public void remove(String path) {
        filesList.remove(path);
    }

    //5 - sortBySize
    public List<FileData> sortBySize() {
        List<FileData> sorteredData = new ArrayList<>();
        for (List<FileData> filesList : filesList.values()) {
            sorteredData.addAll(filesList);
        }
        // Комментарий для себя:
        // Comparator.comparingInt(...) - это статический метод comparingInt класса Comparator, который позволяет
        // создать компаратор на основе значения какого-то целочисленного поля объектов.
        // ссылка на метод: FileData::getSize, это способ сказать "возьми метод getSize из объекта типа FileData и используй его".
        sorteredData.sort(Comparator.comparingInt(FileData::getSize));
        return sorteredData;
    }

    //6 - consistencyCheck
    public boolean consistencyCheck(String path, FileData file){
        return path.equals(file.getPath());
    }

}


