import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Programm {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные пользователя - ФИО, дату рождения, телефон и пол ");
            String input = scanner.nextLine();

            try {

                String[] data = input.split(" ");
                if (data.length != 6) {
                    throw new IllegalArgumentException("Количество данных не соответствует требованиям ");
                } if (data.equals("f")|| data.equals("m")) {
                    System.out.println();
                }
                else {
                    try {
                        throw new ExceptionOfGender();
                    }catch (ExceptionOfGender gender){
                        gender.genderException("");
                    }
                }


                String lastName = data[0];
                String name = data[1];
                String patronomic = data[2];
                Date dateofBirthday = parseDate(data[3]);
                int phoneNumber = Integer.parseInt(data[4]);
                char gender = data[5].charAt(0);

                System.out.println("Фамилия >>> " + lastName);
                System.out.println("Имя >>> " + name);
                System.out.println("Отчество >>> " + patronomic);
                System.out.println("Дата рождения >>> " + dateofBirthday);
                System.out.println("Номер телефона >>> " + phoneNumber);
                System.out.println("Пол >>> " + gender);
                try(FileWriter fileWriter = new FileWriter("Spisok.txt", true)){
                    for(String el : data){
                        fileWriter.append(String.valueOf(el));
                        fileWriter.append(" ");
//                        fileWriter.flush();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            } catch (IllegalArgumentException e){
                System.out.println("Ошибка" + e.getMessage());
            } catch (ParseException e){
                System.out.println("Неверный формат даты");
            }
//
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Недостаточно данных ");
            }

        }

        public static Date parseDate(String dataString) throws ParseException {
            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            return  format.parse(dataString);
        }

        public static String formatDate(Date date){
            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            return format.format(date);
        }
    }

