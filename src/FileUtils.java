import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {

    public static File zipDirectory(String destination, String originDirectoryPath){
        File result = new File(destination + File.separator + "result.zip");

        try (   FileOutputStream dest = new FileOutputStream(result);
                ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest))) {

            File originDirectory = new File(originDirectoryPath);
            File files[] = originDirectory.listFiles();

            assert files != null;
            for (File file : files) {
                writeFileToOutputStream(file, out);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static void writeFileToOutputStream(File file, ZipOutputStream zos) {
        final int BUFFER = 2048;
        byte data[] = new byte[BUFFER];

        try( FileInputStream fi = new FileInputStream(file);
                BufferedInputStream origin = new BufferedInputStream(fi, BUFFER)) {
            ZipEntry entry = new ZipEntry(file.getName());
            zos.putNextEntry(entry);
            int count;
            while ((count = origin.read(data, 0, BUFFER)) != -1) {
                zos.write(data, 0, count);
            }
            origin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
