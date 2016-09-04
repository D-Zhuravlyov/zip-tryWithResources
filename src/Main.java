public class Main {

    public static void main(String[] args) {

        String resourcePath = "/Users/apple/Documents/JavaDev/Coursera/zip-unzip test/resources/files2zip";
        String destPath = "/Users/apple/Documents/JavaDev/Coursera/zip-unzip test/resources/dest";


        FileUtils.zipDirectory(destPath, resourcePath);
    }
}
