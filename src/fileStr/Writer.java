package fileStr;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer {
    public static void main(String[] args) {
        String catalog = "E:\\Test\\Stream\\FileStream";
//        String catalog2 = "E:\\Test\\Stream\\FilesStreamRenamed";
        File dir = new File(catalog);

        System.out.printf("Проверяем, существует ли \"%s\" - %s.\n", catalog, dir.exists());

        boolean created = dir.mkdir();
        if(created)
            System.out.printf("Каталог по пути \"%s\" успешно создан.\n", catalog);
        else System.out.printf("Каталог по пути \"%s\" уже существует.\n", catalog);

//        File newDir = new File(catalog2);
//        dir.renameTo(newDir);
//
//        System.out.printf("Каталог \"%s\" переименован в \"%s\"\n", dir.getName(), newDir.getName());

        System.out.printf("\nПроверяем, существует ли \"%s\" - %s.\n", catalog, dir.exists());
        System.out.printf("Проверяем, является ли \"%s\" каталогом - %s.\n", catalog, dir.isDirectory());
        System.out.printf("Проверяем, является ли \"%s\" файлом - %s.\n", catalog, dir.isFile());

        String fileName = "StreamFile.txt";

        File newFile = new File((dir.getAbsolutePath() + "\\" + fileName));

        System.out.printf("\nИмя файла: %s\n", newFile.getName());
        System.out.printf("Родительский каталог: %s\n", newFile.getParent());

        if(newFile.exists()) System.out.printf("Файл %s уже существует.\n", newFile.getName());
        else {
            System.out.printf("Файл %s еще не создан.\n", newFile.getName());
            System.out.println("\nСоздание файла...");
            try{
                boolean fileCreated = newFile.createNewFile();
                Thread.sleep(3000);
                if(fileCreated) System.out.printf("Файл %s создан.\n", newFile.getName());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Размер файла %s = %d байт.\n", newFile.getName(), newFile.length());

        if(newFile.length() > 0) {
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream((dir.getAbsolutePath() + "\\" + fileName), false), "UTF-8")) {
                System.out.printf("\nФайл \"%s\" не пустой.\n", newFile.getName());
                String text = "";
                try{
                    System.out.println("Производится очистка файла...");
                    writer.write(text);
                    Thread.sleep(2000);
                    System.out.println("Очистка файла произведена.");
                    System.out.printf("Размер файла %s = %d байт.\n", newFile.getName(), newFile.length());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writer.flush();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("\nПроверяем, существует ли \"%s\" - %s.\n", newFile.getName(), newFile.exists());
        System.out.printf("Проверяем, является ли \"%s\" каталогом - %s.\n", newFile.getName(), newFile.isDirectory());
        System.out.printf("Проверяем, является ли \"%s\" файлом - %s.\n", newFile.getName(), newFile.isFile());

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream((dir.getAbsolutePath() + "\\" + fileName), false), "UTF-8")) {
            String text = "Запись из потока FileWriter.";

            try{
                System.out.printf("\nЗапись в файл...\nЗаписывается строка: %s\n", text);
                writer.write(text);
                Thread.sleep(1000);
                System.out.println("Строка записана.");
                writer.flush();
                System.out.printf("Размер файла %s = %d байт.\n", newFile.getName(), newFile.length());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            String txt = "Hello";
            writer.append("\n" + txt + "\n");
            System.out.printf("Добавлена запись: %s\n", txt);

            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Размер файла %s = %d байт.\n", newFile.getName(), newFile.length());

        try (OutputStreamWriter writer2 = new OutputStreamWriter(
                new FileOutputStream((dir.getAbsolutePath() + "\\" + fileName), true), "UTF-8")) {
            String text = "Вторая запись из потока FileWriter2.";

            try{
                System.out.printf("\nЗапись в файл из второго потока...\nЗаписывается строка: %s\n", text);
                writer2.write(text);
                Thread.sleep(1000);
                System.out.println("Строка записана.");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            writer2.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Размер файла %s = %d байт.\n", newFile.getName(), newFile.length());

        {
            long x = newFile.lastModified();

            String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(x));

            Date datex = new Date(newFile.lastModified());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");

            String formattedDate = sdf.format(datex);

            Date dnow = new Date();

            System.out.printf("\nПоследнее изменение в миллисекундах, прошедших с начала эпохи Unix: %d\n", x);
            System.out.printf("Файл изменен %d мс назад\n", dnow.getTime()-x);
            System.out.printf("Последнее изменение %s\n", date);
            System.out.printf("Последнее изменение %s\n", formattedDate);
        }

//        System.out.printf("\nПроизводится удаление файла %s.\n", newFile.getName());
//        boolean fileDelete = newFile.delete();
//        if(fileDelete) System.out.printf("Файл %s успешно удален.\n", newFile.getName());
//
//        System.out.printf("Проверяем, существует ли \"%s\" - %s.\n", newFile.getName(), newFile.exists());
//
//        System.out.printf("Производится удаление каталога %s.\n", dir.getAbsolutePath());
//        boolean deleted = dir.delete();
//        if(deleted) System.out.printf("Каталог \"%s\" успешно удален.\n", dir.getAbsolutePath());
//
//        System.out.printf("Проверяем, существует ли \"%s\" - %s.\n", catalog, dir.exists());

        try(InputStreamReader reader = new InputStreamReader(
                new FileInputStream((dir.getAbsolutePath() + "\\" + fileName)), "UTF-8")){
            System.out.printf("\nПроизводится чтение из файла %s...\n", newFile.getName());
            System.out.println("{");

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char)c);
            }
            System.out.println();
            System.out.println("}");
            System.out.println("Чтение завершено.");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        char in = '\n';

        try {
            System.out.print("\nЖелаете удалить файл и каталог? (если да - ввести любой символ) ");
            in = (char)System.in.read();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if(in != '\n') {
            System.out.printf("\nПроизводится удаление файла %s.\n", newFile.getName());
            boolean fileDelete2 = newFile.delete();
            if (fileDelete2) System.out.printf("Файл %s успешно удален.\n", newFile.getName());

            System.out.printf("Проверяем, существует ли \"%s\" - %s.\n", newFile.getName(), newFile.exists());

            System.out.printf("\nПроизводится удаление каталога %s.\n", dir.getAbsolutePath());
            boolean deleted2 = dir.delete();
            if (deleted2) System.out.printf("Каталог \"%s\" успешно удален.\n", dir.getAbsolutePath());

            System.out.printf("Проверяем, существует ли \"%s\" - %s.\n", catalog, dir.exists());
        } else System.out.println("Вы выбрали нет.");

    }
}
