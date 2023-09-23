package homework.task_12_maps;

public class Main {
    public static void main(String[] args) throws WrongPathException {

        FileData file1 = new FileData("file1.txt", 10, "/path/to/file");
        FileData file2 = new FileData("file2.txt", 5, "/anotherpath/to/file");
        FileData file3 = new FileData("file3.pdf", 20, "/path/to/file");
        FileData file4 = new FileData("file4.doc", 50, "/anotherpath/to/file");
        FileData file5 = new FileData("file5.pdf", 15, "/path/to/file");

        FileNavigator fileNavigator = new FileNavigator();

        //1 - add
        fileNavigator.add(file1.getPath(), file1);
        fileNavigator.add(file2.getPath(), file2);
        fileNavigator.add(file3.getPath(), file3);
        fileNavigator.add(file4.getPath(), file4);
        fileNavigator.add(file5.getPath(), file5);
        //6. consistencyCheck - WrongPathException:
        // fileNavigator.add(file4.getPath(), file5);

        System.out.println(fileNavigator.getFilesList());
        System.out.println("----------------------------");

        //2 - find
        System.out.println(fileNavigator.find("/path/to/file"));
        System.out.println("----------------------------");

        //3 - filterBySize
        System.out.println(fileNavigator.filterBySize(11));
        System.out.println("----------------------------");

        //4 - remove
        fileNavigator.remove("/anotherpath/to/file");
        System.out.println("After removing " + fileNavigator.getFilesList());
        System.out.println("----------------------------");

        //5 - sortBySize
        System.out.println(fileNavigator.sortBySize());

    }
}
